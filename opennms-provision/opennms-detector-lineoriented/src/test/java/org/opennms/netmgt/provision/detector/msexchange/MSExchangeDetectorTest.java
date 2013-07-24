/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2009-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.provision.detector.msexchange;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.test.MockLogAppender;
import org.opennms.core.utils.BeanUtils;
import org.opennms.netmgt.provision.server.SimpleServer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The Class MSExchangeDetectorTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/opennms/detectors.xml" })
public class MSExchangeDetectorTest implements InitializingBean {

    /** The test banner. */
    private static String TEST_BANNER = "Microsoft Exchange";

    /** The m_detector. */
    @Autowired
    MSExchangeDetector m_detector;

    /** The m_pop3 server. */
    SimpleServer m_pop3Server;

    /** The m_imap server. */
    SimpleServer m_imapServer;

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        BeanUtils.assertAutowiring(this);
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

        m_pop3Server = new SimpleServer() {

            @Override
            public void onInit() {
                setBanner(TEST_BANNER);
            }
        };
        m_pop3Server.init();
        m_pop3Server.startServer();

        m_imapServer = new SimpleServer() {

            @Override
            public void onInit() {
                setBanner(TEST_BANNER);
            }
        };
        m_imapServer.init();
        m_imapServer.startServer();

    }

    /**
     * Tear down.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @After
    public void tearDown() throws IOException {
        if (m_imapServer != null) {
            m_imapServer.stopServer();
            m_imapServer = null;
        }

        if (m_pop3Server != null) {
            m_pop3Server.stopServer();
            m_pop3Server = null;
        }
    }

    /**
     * Test detector wired.
     */
    @Test(timeout = 90000)
    public void testDetectorWired() {
        assertNotNull(m_detector);
    }

    /**
     * Test detector success.
     *
     * @throws UnknownHostException
     *             the unknown host exception
     */
    @Test(timeout = 90000)
    public void testDetectorSuccess() throws UnknownHostException {
        m_detector.setImapPort(m_imapServer.getLocalPort());
        m_detector.setPop3Port(m_pop3Server.getLocalPort());
        m_detector.onInit();
        assertTrue(m_detector.isServiceDetected(m_pop3Server.getInetAddress()));
    }

    /**
     * Test detector success pop3 fail imap.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test(timeout = 90000)
    public void testDetectorSuccessPop3FailImap() throws IOException {
        m_imapServer.stopServer();
        m_detector.setPop3Port(m_pop3Server.getLocalPort());
        m_detector.onInit();
        assertTrue(m_detector.isServiceDetected(m_pop3Server.getInetAddress()));
    }

    /**
     * Test detector success imap fail pop3.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test(timeout = 90000)
    public void testDetectorSuccessImapFailPop3() throws IOException {
        m_pop3Server.stopServer();
        m_detector.setImapPort(m_imapServer.getLocalPort());
        m_detector.onInit();
        assertTrue(m_detector.isServiceDetected(m_pop3Server.getInetAddress()));
    }

    /**
     * Test detector fail wrong port.
     */
    @Test(timeout = 90000)
    public void testDetectorFailWrongPort() {
        m_detector.setImapPort(9000);
        m_detector.setPop3Port(9001);
        m_detector.onInit();
        assertFalse(m_detector.isServiceDetected(m_pop3Server.getInetAddress()));
    }
}
