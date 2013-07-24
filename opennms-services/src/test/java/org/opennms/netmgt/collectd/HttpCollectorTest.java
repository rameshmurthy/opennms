/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.collectd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.test.ConfigurationTestUtils;
import org.opennms.core.test.MockLogAppender;
import org.opennms.core.test.OpenNMSJUnit4ClassRunner;
import org.opennms.core.test.db.annotations.JUnitTemporaryDatabase;
import org.opennms.core.test.http.annotations.JUnitHttpServer;
import org.opennms.core.utils.BeanUtils;
import org.opennms.core.utils.InetAddressUtils;
import org.opennms.netmgt.config.CollectdConfigFactory;
import org.opennms.netmgt.config.CollectdPackage;
import org.opennms.netmgt.config.collectd.Filter;
import org.opennms.netmgt.config.collectd.Package;
import org.opennms.netmgt.config.collectd.Parameter;
import org.opennms.netmgt.config.collectd.Service;
import org.opennms.netmgt.config.collector.CollectionSet;
import org.opennms.netmgt.dao.api.IpInterfaceDao;
import org.opennms.netmgt.dao.api.NodeDao;
import org.opennms.netmgt.dao.api.ServiceTypeDao;
import org.opennms.netmgt.model.NetworkBuilder;
import org.opennms.netmgt.model.OnmsDistPoller;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.OnmsServiceType;
import org.opennms.netmgt.rrd.RrdUtils;
import org.opennms.test.FileAnticipator;
import org.opennms.test.JUnitConfigurationEnvironment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The Class HttpCollectorTest.
 *
 * @author <a href="mailto:david@opennms.org">David Hustace</a>
 */

@RunWith(OpenNMSJUnit4ClassRunner.class)
@TestExecutionListeners({ JUnitCollectorExecutionListener.class })
@ContextConfiguration(locations = { "classpath:/META-INF/opennms/applicationContext-soa.xml",
        "classpath:/META-INF/opennms/applicationContext-dao.xml", "classpath*:/META-INF/opennms/component-dao.xml",
        "classpath:/META-INF/opennms/applicationContext-daemon.xml",
        "classpath:/META-INF/opennms/applicationContext-collectdTest.xml",
        "classpath:/META-INF/opennms/mockEventIpcManager.xml",
        "classpath*:/META-INF/opennms/applicationContext-minimal-conf.xml" })
@JUnitConfigurationEnvironment(systemProperties = "org.opennms.rrd.storeByGroup=false")
@JUnitTemporaryDatabase
public class HttpCollectorTest implements TestContextAware, InitializingBean {

    /** The m_transaction manager. */
    @Autowired
    private PlatformTransactionManager m_transactionManager;

    /** The m_node dao. */
    @Autowired
    private NodeDao m_nodeDao;

    /** The m_ip interface dao. */
    @Autowired
    private IpInterfaceDao m_ipInterfaceDao;

    /** The m_service type dao. */
    @Autowired
    private ServiceTypeDao m_serviceTypeDao;

    /** The m_collectd. */
    @Autowired
    private Collectd m_collectd;

    /** The m_context. */
    private TestContext m_context;

    /** The m_dist poller. */
    private final OnmsDistPoller m_distPoller = new OnmsDistPoller("localhost", "127.0.0.1");

    /** The m_test host name. */
    private final String m_testHostName = "127.0.0.1";

    /** The m_collector. */
    private HttpCollector m_collector;

    /** The m_collection specification. */
    private CollectionSpecification m_collectionSpecification;

    /** The m_https collection specification. */
    private CollectionSpecification m_httpsCollectionSpecification;

    /** The m_collection agent. */
    private CollectionAgent m_collectionAgent;

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        BeanUtils.assertAutowiring(this);
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.collectd.TestContextAware#setTestContext(org.springframework.test.context.TestContext)
     */
    @Override
    public void setTestContext(TestContext t) {
        m_context = t;
    }

    /**
     * Gets the service type.
     *
     * @param name
     *            the name
     * @return the service type
     */
    private OnmsServiceType getServiceType(String name) {
        OnmsServiceType serviceType = m_serviceTypeDao.findByName(name);
        if (serviceType == null) {
            serviceType = new OnmsServiceType(name);
            m_serviceTypeDao.save(serviceType);
            m_serviceTypeDao.flush();
        }
        return serviceType;
    }

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp() throws Exception {
        MockLogAppender.setupLogging();

        if (m_nodeDao.findByLabel("testnode").size() == 0) {
            NetworkBuilder builder = new NetworkBuilder(m_distPoller);
            builder.addNode("testnode");
            builder.addInterface(InetAddressUtils.normalize(m_testHostName)).setIsManaged("M").setIsSnmpPrimary("P");
            builder.addService(getServiceType("ICMP"));
            builder.addService(getServiceType("HTTP"));
            builder.addService(getServiceType("HTTPS"));
            OnmsNode n = builder.getCurrentNode();
            assertNotNull(n);
            m_nodeDao.save(n);
            m_nodeDao.flush();
        }

        m_collector = new HttpCollector();

        Collection<OnmsIpInterface> ifaces = m_ipInterfaceDao.findByIpAddress(m_testHostName);
        assertEquals(1, ifaces.size());
        OnmsIpInterface iface = ifaces.iterator().next();

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("collection", "default");
        m_collector.initialize(parameters);

        m_collectionSpecification = CollectorTestUtils.createCollectionSpec("HTTP", m_collector, "default");
        m_httpsCollectionSpecification = CollectorTestUtils.createCollectionSpec("HTTPS", m_collector, "default");
        m_collectionAgent = DefaultCollectionAgent.create(iface.getId(), m_ipInterfaceDao, m_transactionManager);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        MockLogAppender.noWarningsOrHigherLogged();
    }

    /**
     * Test method for.
     *
     * @throws Exception
     *             the exception
     *             {@link org.opennms.netmgt.collectd.HttpCollector#collect(org.opennms.netmgt.collectd.CollectionAgent, org.opennms.netmgt.model.events.EventProxy, Map)}
     *             .
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-config.xml", datacollectionType = "http", anticipateRrds = {
            "1/documentCount", "1/greatAnswer", "1/someNumber" }, anticipateFiles = { "1/strings.properties" })
    public final void testCollect() throws Exception {
        m_collectionSpecification.initialize(m_collectionAgent);

        CollectionSet collectionSet = m_collectionSpecification.collect(m_collectionAgent);
        assertEquals("collection status", ServiceCollector.COLLECTION_SUCCEEDED, collectionSet.getStatus());
        CollectorTestUtils.persistCollectionSet(m_collectionSpecification, collectionSet);

        m_collectionSpecification.release(m_collectionAgent);
    }

    /**
     * Test persist.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-persist-test-config.xml", datacollectionType = "http", anticipateRrds = {
            "1/documentCount", "1/greatAnswer", "1/someNumber" }, anticipateFiles = { "1/strings.properties" })
    public final void testPersist() throws Exception {
        doTestPersist(m_collectionSpecification);
    }

    /**
     * Test persist https.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" }, https = true)
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-persist-https-test-config.xml", datacollectionType = "https", anticipateRrds = {
            "1/documentCount", "1/greatAnswer", "1/someNumber" }, anticipateFiles = { "1/strings.properties" })
    public final void testPersistHttps() throws Exception {
        doTestPersist(m_httpsCollectionSpecification);
    }

    /**
     * Do test persist.
     *
     * @param spec
     *            the spec
     * @throws Exception
     *             the exception
     */
    public final void doTestPersist(CollectionSpecification spec) throws Exception {
        File snmpRrdDirectory = (File) m_context.getAttribute("rrdDirectory");
        FileAnticipator anticipator = (FileAnticipator) m_context.getAttribute("fileAnticipator");

        int numUpdates = 2;
        int stepSizeInSecs = 1;

        int stepSizeInMillis = stepSizeInSecs * 1000;

        m_collectionSpecification.initialize(m_collectionAgent);

        CollectorTestUtils.collectNTimes(m_collectionSpecification, m_collectionAgent, numUpdates);

        // node level collection
        File nodeDir = CollectorTestUtils.anticipatePath(anticipator, snmpRrdDirectory, "1");
        File documentCountRrdFile = new File(nodeDir, CollectorTestUtils.rrd("documentCount"));
        File someNumberRrdFile = new File(nodeDir, CollectorTestUtils.rrd("someNumber"));
        File greatAnswerRrdFile = new File(nodeDir, CollectorTestUtils.rrd("greatAnswer"));

        // This is the value of documentCount from the first test page
        // documentCount = Gauge32: 5
        assertEquals("documentCount", Double.valueOf(5.0),
                     RrdUtils.fetchLastValueInRange(documentCountRrdFile.getAbsolutePath(), "documentCount",
                                                    stepSizeInMillis, stepSizeInMillis));

        // This is the value of documentType from the first test page
        // someNumber = Gauge32: 17
        assertEquals("documentType", Double.valueOf(17.0),
                     RrdUtils.fetchLastValueInRange(someNumberRrdFile.getAbsolutePath(), "someNumber",
                                                    stepSizeInMillis, stepSizeInMillis));

        // This is the value of greatAnswer from the second test page
        // someNumber = Gauge32: 42
        assertEquals("greatAnswer", Double.valueOf(42.0),
                     RrdUtils.fetchLastValueInRange(greatAnswerRrdFile.getAbsolutePath(), "greatAnswer",
                                                    stepSizeInMillis, stepSizeInMillis));

        m_collectionSpecification.release(m_collectionAgent);
    }

    /**
     * Test persist apache stats.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-persist-apache-stats.xml", datacollectionType = "http", anticipateRrds = {
            "1/TotalAccesses", "1/TotalkBytes", "1/CPULoad", "1/Uptime", "1/ReqPerSec", "1/BytesPerSec",
            "1/BytesPerReq", "1/BusyWorkers", "1/IdleWorkers" })
    public final void testPersistApacheStats() throws Exception {
        File snmpRrdDirectory = (File) m_context.getAttribute("rrdDirectory");
        FileAnticipator anticipator = (FileAnticipator) m_context.getAttribute("fileAnticipator");

        int numUpdates = 2;
        int stepSizeInSecs = 1;

        int stepSizeInMillis = stepSizeInSecs * 1000;

        m_collectionSpecification.initialize(m_collectionAgent);

        CollectorTestUtils.collectNTimes(m_collectionSpecification, m_collectionAgent, numUpdates);

        // node level collection
        File nodeDir = CollectorTestUtils.anticipatePath(anticipator, snmpRrdDirectory, "1");

        File documentCountRrdFile = new File(nodeDir, CollectorTestUtils.rrd("TotalAccesses"));
        File someNumberRrdFile = new File(nodeDir, CollectorTestUtils.rrd("IdleWorkers"));
        File cpuLoadRrdFile = new File(nodeDir, CollectorTestUtils.rrd("CPULoad"));

        // Total Accesses: 175483
        assertEquals("TotalAccesses", Double.valueOf(175483.0),
                     RrdUtils.fetchLastValueInRange(documentCountRrdFile.getAbsolutePath(), "TotalAccesses",
                                                    stepSizeInMillis, stepSizeInMillis));

        // IdleWorkers: 12
        assertEquals("IdleWorkers", Double.valueOf(12.0),
                     RrdUtils.fetchLastValueInRange(someNumberRrdFile.getAbsolutePath(), "IdleWorkers",
                                                    stepSizeInMillis, stepSizeInMillis));

        // CPU Load: .497069
        assertEquals("CPULoad", Double.valueOf(0.497069),
                     RrdUtils.fetchLastValueInRange(cpuLoadRrdFile.getAbsolutePath(), "CPULoad", stepSizeInMillis,
                                                    stepSizeInMillis));
        m_collectionSpecification.release(m_collectionAgent);
    }

    /**
     * Test broken regex.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-broken-regex.xml", datacollectionType = "http")
    public final void testBrokenRegex() throws Exception {
        int numUpdates = 2;

        m_collectionSpecification.initialize(m_collectionAgent);

        CollectorTestUtils.failToCollectNTimes(m_collectionSpecification, m_collectionAgent, numUpdates);

        m_collectionSpecification.release(m_collectionAgent);
    }

    /**
     * Test persist apache stats via capsd.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-persist-apache-stats.xml", datacollectionType = "http", anticipateRrds = {
            "1/TotalAccesses", "1/TotalkBytes", "1/CPULoad", "1/Uptime", "1/ReqPerSec", "1/BytesPerSec",
            "1/BytesPerReq", "1/BusyWorkers", "1/IdleWorkers" })
    public void testPersistApacheStatsViaCapsd() throws Exception {
        // TODO: Do we need this init? applicationContext-collectdTest.xml
        // should take care of this
        CollectdConfigFactory collectdConfig = new CollectdConfigFactory(
                                                                         ConfigurationTestUtils.getInputStreamForResource(this,
                                                                                                                          "/org/opennms/netmgt/capsd/collectd-configuration.xml"),
                                                                         "nms1", false);
        CollectdConfigFactory.setInstance(collectdConfig);
        CollectdConfigFactory.init();

        // Add the HTTP collector to capsd
        m_collectd.setServiceCollector("HTTP", m_collector);
        m_collectd.init();
        m_collectd.start();
        Thread.sleep(10000);
        m_collectd.stop();
    }

    /**
     * Test persist apache stats alternate locale.
     *
     * @throws Exception
     *             the exception
     */
    public final void testPersistApacheStatsAlternateLocale() throws Exception {
        final Locale defaultLocale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.FRANCE);

            File snmpRrdDirectory = (File) m_context.getAttribute("rrdDirectory");
            FileAnticipator anticipator = (FileAnticipator) m_context.getAttribute("fileAnticipator");

            int numUpdates = 2;
            int stepSizeInSecs = 1;

            int stepSizeInMillis = stepSizeInSecs * 1000;

            m_collectionSpecification.initialize(m_collectionAgent);

            CollectorTestUtils.collectNTimes(m_collectionSpecification, m_collectionAgent, numUpdates);

            // node level collection
            File nodeDir = CollectorTestUtils.anticipatePath(anticipator, snmpRrdDirectory, "1");

            File documentCountRrdFile = new File(nodeDir, CollectorTestUtils.rrd("TotalAccesses"));
            File someNumberRrdFile = new File(nodeDir, CollectorTestUtils.rrd("IdleWorkers"));
            File cpuLoadRrdFile = new File(nodeDir, CollectorTestUtils.rrd("CPULoad"));

            // Total Accesses: 175483
            assertEquals("TotalAccesses", Double.valueOf(175483.0),
                         RrdUtils.fetchLastValueInRange(documentCountRrdFile.getAbsolutePath(), "TotalAccesses",
                                                        stepSizeInMillis, stepSizeInMillis));

            // IdleWorkers: 12
            assertEquals("IdleWorkers", Double.valueOf(12.0),
                         RrdUtils.fetchLastValueInRange(someNumberRrdFile.getAbsolutePath(), "IdleWorkers",
                                                        stepSizeInMillis, stepSizeInMillis));

            // CPU Load: .497069
            assertEquals("CPULoad", Double.valueOf(0.497069),
                         RrdUtils.fetchLastValueInRange(cpuLoadRrdFile.getAbsolutePath(), "CPULoad", stepSizeInMillis,
                                                        stepSizeInMillis));
            m_collectionSpecification.release(m_collectionAgent);
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    /**
     * Test nm s4886with http.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" })
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-config-NMS4886.xml", datacollectionType = "http", anticipateRrds = {
            "1/documentCount", "1/greatAnswer", "1/someNumber" }, anticipateFiles = { "1/strings.properties" })
    public final void testNMS4886withHttp() throws Exception {
        doTestNMS4886("HTTP");
    }

    /**
     * Test nm s4886with https.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @JUnitHttpServer(port = 10342, vhosts = { "127.0.0.1" }, https = true)
    @JUnitCollector(datacollectionConfig = "/org/opennms/netmgt/config/http-datacollection-config-NMS4886-https.xml", datacollectionType = "https", anticipateRrds = {
            "1/documentCount", "1/greatAnswer", "1/someNumber" }, anticipateFiles = { "1/strings.properties" })
    public final void testNMS4886withHttps() throws Exception {
        doTestNMS4886("HTTPS");
    }

    /**
     * Do test nm s4886.
     *
     * @param svcName
     *            the svc name
     * @throws Exception
     *             the exception
     */
    public final void doTestNMS4886(String svcName) throws Exception {
        HttpCollector collector = new HttpCollector();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("http-collection", "default");
        parameters.put("port", "10342");
        collector.initialize(parameters);

        Package pkg = new Package();
        Filter filter = new Filter();
        filter.setContent("IPADDR IPLIKE *.*.*.*");
        pkg.setFilter(filter);
        Service service = new Service();
        service.setName(svcName);
        Parameter collectionParm = new Parameter();
        collectionParm.setKey("http-collection");
        collectionParm.setValue("default");
        service.addParameter(collectionParm);
        Parameter portParm = new Parameter();
        portParm.setKey("port");
        portParm.setValue("10342");
        service.addParameter(portParm);
        pkg.addService(service);

        CollectdPackage wpkg = new CollectdPackage(pkg, "default", false);
        CollectionSpecification collectionSpecification = new CollectionSpecification(wpkg, svcName, collector);
        collectionSpecification.initialize(m_collectionAgent);

        CollectionSet collectionSet = collectionSpecification.collect(m_collectionAgent);
        assertEquals("collection status", ServiceCollector.COLLECTION_SUCCEEDED, collectionSet.getStatus());
        CollectorTestUtils.persistCollectionSet(collectionSpecification, collectionSet);

        collectionSpecification.release(m_collectionAgent);
    }

}
