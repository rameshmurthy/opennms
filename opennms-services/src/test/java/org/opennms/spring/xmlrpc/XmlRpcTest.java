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

package org.opennms.spring.xmlrpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.xmlrpc.WebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opennms.core.test.MockLogAppender;
import org.springframework.remoting.RemoteAccessException;

/**
 * The Class XmlRpcTest.
 *
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @author <a href="mailto:dj@opennms.org">DJ Gregor</a>
 */
public class XmlRpcTest {

    /** The m_web server. */
    private WebServer m_webServer;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp() throws Exception {

        MockLogAppender.setupLogging();

        XmlRpcWebServerFactoryBean wsf = new XmlRpcWebServerFactoryBean();
        wsf.setPort(9192);
        wsf.setSecure(false);
        wsf.afterPropertiesSet();

        m_webServer = (WebServer) wsf.getObject();
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        m_webServer.shutdown();

    }

    /**
     * Test xml rpc proxy factory bean and service exporter.
     *
     * @throws Throwable
     *             the throwable
     */
    @Test
    public void testXmlRpcProxyFactoryBeanAndServiceExporter() throws Throwable {
        TestBean target = new TestBean("myname", 99);

        final XmlRpcServiceExporter exporter = new XmlRpcServiceExporter();
        exporter.setServiceInterface(ITestBean.class);
        exporter.setService(target);
        exporter.setWebServer(m_webServer);
        exporter.afterPropertiesSet();

        XmlRpcProxyFactoryBean<ITestBean> pfb = new XmlRpcProxyFactoryBean<ITestBean>();
        pfb.setServiceInterface(ITestBean.class);
        pfb.setServiceUrl("http://localhost:9192/RPC2");
        pfb.afterPropertiesSet();

        ITestBean proxy = pfb.getObject();
        assertEquals("myname", proxy.getName());
        assertEquals(99, proxy.getAge());
        proxy.setAge(50);
        assertEquals(50, proxy.getAge());

    }

    /**
     * Test xml rpc proxy factory bean and service exporter with https.
     *
     * @throws Throwable
     *             the throwable
     */
    @Test
    @Ignore("We're not set up for HTTPS for these tests.")
    public void testXmlRpcProxyFactoryBeanAndServiceExporterWithHttps() throws Throwable {
        TestBean target = new TestBean("myname", 99);

        final XmlRpcServiceExporter exporter = new XmlRpcServiceExporter();
        exporter.setServiceInterface(ITestBean.class);
        exporter.setService(target);
        exporter.setWebServer(m_webServer);
        exporter.afterPropertiesSet();

        XmlRpcProxyFactoryBean<ITestBean> pfb = new XmlRpcProxyFactoryBean<ITestBean>();
        pfb.setServiceInterface(ITestBean.class);
        pfb.setServiceUrl("https://localhost:9192/RPC2");
        pfb.afterPropertiesSet();

        ITestBean proxy = pfb.getObject();
        assertEquals("myname", proxy.getName());
        assertEquals(99, proxy.getAge());
        proxy.setAge(50);
        assertEquals(50, proxy.getAge());

    }

    /**
     * Test xml rpc proxy factory bean and service exporter with io exception.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @Ignore("If you're using OpenDNS, myurl gives an IP address")
    public void testXmlRpcProxyFactoryBeanAndServiceExporterWithIOException() throws Exception {
        TestBean target = new TestBean("myname", 99);

        final XmlRpcServiceExporter exporter = new XmlRpcServiceExporter();
        exporter.setServiceInterface(ITestBean.class);
        exporter.setService(target);
        exporter.setWebServer(m_webServer);
        exporter.afterPropertiesSet();

        XmlRpcProxyFactoryBean<ITestBean> pfb = new XmlRpcProxyFactoryBean<ITestBean>();
        pfb.setServiceInterface(ITestBean.class);
        pfb.setServiceUrl("http://127.0.0.1:9191/RPC2"); // this is wrong (we
                                                         // hope) so we throw an
                                                         // exception
        pfb.afterPropertiesSet();

        ITestBean proxy = pfb.getObject();
        try {
            proxy.setAge(50);
            fail("Should have thrown RemoteAccessException");
        } catch (RemoteAccessException ex) {
            // expected
            assertTrue(ex.getCause() instanceof IOException);
        }
    }

    /**
     * The Interface ITestBean.
     */
    public static interface ITestBean {

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName();

        /**
         * Gets the age.
         *
         * @return the age
         */
        public int getAge();

        /**
         * Sets the age.
         *
         * @param age
         *            the new age
         */
        public void setAge(int age);
    }

    /**
     * The Class TestBean.
     */
    static class TestBean implements ITestBean {

        /** The name. */
        private String name;

        /** The age. */
        private int age;

        /**
         * Instantiates a new test bean.
         *
         * @param name
         *            the name
         * @param age
         *            the age
         */
        TestBean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /* (non-Javadoc)
         * @see org.opennms.spring.xmlrpc.XmlRpcTest.ITestBean#getName()
         */
        @Override
        public String getName() {
            return this.name;
        }

        /* (non-Javadoc)
         * @see org.opennms.spring.xmlrpc.XmlRpcTest.ITestBean#getAge()
         */
        @Override
        public int getAge() {
            return this.age;
        }

        /* (non-Javadoc)
         * @see org.opennms.spring.xmlrpc.XmlRpcTest.ITestBean#setAge(int)
         */
        @Override
        public void setAge(int age) {
            this.age = age;
        }
    }

}
