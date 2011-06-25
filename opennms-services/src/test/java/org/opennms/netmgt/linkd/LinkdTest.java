/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2010-2011 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2011 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.linkd;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.test.OpenNMSJUnit4ClassRunner;
import org.opennms.core.test.snmp.annotations.JUnitSnmpAgent;
import org.opennms.core.test.snmp.annotations.JUnitSnmpAgents;
import org.opennms.core.utils.InetAddressUtils;
import org.opennms.core.utils.LogUtils;
import org.opennms.netmgt.config.LinkdConfigManager;
import org.opennms.netmgt.dao.DataLinkInterfaceDao;
import org.opennms.netmgt.dao.NodeDao;
import org.opennms.netmgt.dao.db.JUnitConfigurationEnvironment;
import org.opennms.netmgt.dao.db.JUnitTemporaryDatabase;
import org.opennms.netmgt.model.DataLinkInterface;
import org.opennms.netmgt.model.NetworkBuilder;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.snmp.SnmpAgentConfig;
import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpUtils;
import org.opennms.netmgt.snmp.SnmpValue;
import org.opennms.test.mock.MockLogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(OpenNMSJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:/META-INF/opennms/applicationContext-dao.xml",
        "classpath:/META-INF/opennms/applicationContext-commonConfigs.xml",
		"classpath:/META-INF/opennms/applicationContext-daemon.xml",
		"classpath:/META-INF/opennms/applicationContext-proxy-snmp.xml",
		"classpath:/META-INF/opennms/mockEventIpcManager.xml",
		"classpath:/META-INF/opennms/applicationContext-databasePopulator.xml",
		"classpath:/META-INF/opennms/applicationContext-setupIpLike-enabled.xml",
		"classpath:/META-INF/opennms/applicationContext-linkd.xml",
		"classpath:/applicationContext-minimal-conf.xml",
		"classpath:/applicationContext-linkd-test.xml"
})
@JUnitConfigurationEnvironment
@JUnitTemporaryDatabase
public class LinkdTest {

    @Autowired
	private Linkd m_linkd;

	@Autowired
	private NodeDao m_nodeDao;

	@Autowired
	private DataLinkInterfaceDao m_dataLinkInterfaceDao;

	@Before
	public void setUp() throws Exception {
		// Use the mock.logLevel system property to control the log level
		MockLogAppender.setupLogging(true);

		NetworkBuilder nb = new NetworkBuilder();
        nb.addNode("test.example.com").setForeignSource("linkd").setForeignId("1").setSysObjectId(".1.3.6.1.4.1.1724.81").setType("A");
        nb.addInterface("192.168.1.10").setIsSnmpPrimary("P").setIsManaged("M");
        m_nodeDao.save(nb.getCurrentNode());

        nb.addNode("nortel.example.com").setForeignSource("linkd").setForeignId("nortelbay470").setSysObjectId(".1.3.6.1.4.1.45.3.46.1").setType("A");
        nb.addInterface("192.168.160.250").setIsSnmpPrimary("P").setIsManaged("M");
        m_nodeDao.save(nb.getCurrentNode());

        nb.addNode("linksys.example.com").setForeignSource("linkd").setForeignId("linksyssrw2048").setSysObjectId(".1.3.6.1.4.1.3955.6.1.2048.1").setType("A");
        nb.addInterface("192.168.160.253").setIsSnmpPrimary("P").setIsManaged("M");
        m_nodeDao.save(nb.getCurrentNode());

        m_nodeDao.flush();
	}

	@After
	public void tearDown() throws Exception {
	    for (final OnmsNode node : m_nodeDao.findAll()) {
	        m_nodeDao.delete(node);
	    }
	    m_nodeDao.flush();
	}
	
	@Test
	@Ignore
	@JUnitSnmpAgent(host="127.0.0.1", resource="classpath:linkd-a-nortelbay470.properties")
	public void testGetHexString() throws Exception {
	    final SnmpAgentConfig config = new SnmpAgentConfig(InetAddressUtils.addr("127.0.0.1"));
	    config.setPort(9161);
        final SnmpValue value = SnmpUtils.get(config, SnmpObjId.get(".1.3.6.1.2.1.17.2.15.1.6.34"));
	    LogUtils.debugf(this, "value = %s", value.toHexString());
	}
	
	@Test
	@JUnitSnmpAgent(resource="classpath:westell-smartjack.properties", useMockSnmpStrategy=true)
	public void testScheduleNodeCollection() throws Exception {
		final OnmsNode node = m_nodeDao.findByForeignId("linkd", "1");
		LogUtils.debugf(this, "node = %s", node);

        m_linkd.start();
        assertTrue(m_linkd.scheduleNodeCollection(node.getId()));
		m_linkd.stop();
	}
	
    @Test
    // @Transactional
    @JUnitSnmpAgents(value={
        @JUnitSnmpAgent(host="192.168.160.250", port=161, resource="classpath:linkd-a-nortelbay470.properties"),
        @JUnitSnmpAgent(host="192.168.160.253", port=161, resource="classpath:linkd-b-linksyssrw2048.properties")
    }, useMockSnmpStrategy=true)
    public void testSimpleLink() throws Exception {
        final OnmsNode node = m_nodeDao.findByForeignId("linkd", "1");
        final OnmsNode nortel = m_nodeDao.findByForeignId("linkd", "nortelbay470");
        final OnmsNode linksys = m_nodeDao.findByForeignId("linkd", "linksyssrw2048");
        LogUtils.debugf(this, "node = %s", node);
        LogUtils.debugf(this, "nortel = %s", nortel);
        LogUtils.debugf(this, "linksys = %s", linksys);

        final LinkdConfigManager manager = (LinkdConfigManager)m_linkd.getLinkdConfig();
        manager.getConfiguration().setInitial_sleep_time(0);
        manager.getConfiguration().setSnmp_poll_interval(5000);
        manager.getConfiguration().setDiscovery_link_interval(5000);

//        m_linkd.init();
        m_linkd.start();
        m_linkd.getScheduler();
        assertTrue(m_linkd.scheduleNodeCollection(nortel.getId()));
        assertTrue(m_linkd.scheduleNodeCollection(linksys.getId()));

        Thread.sleep(30000);
        m_linkd.stop();
        
        Thread.sleep(20000);

        for (final DataLinkInterface iface : m_dataLinkInterfaceDao.findAll()) {
            LogUtils.debugf(this, "iface = %s", iface);
        }
        for (final OnmsNode dbNode : m_nodeDao.findAll()) {
            LogUtils.debugf(this, "node = %s", dbNode);
        }
    }
}
