/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.dao.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opennms.core.utils.PropertiesCache;
import org.opennms.netmgt.mock.MockResourceType;
import org.opennms.netmgt.model.OnmsAttribute;
import org.opennms.netmgt.model.OnmsResource;
import org.opennms.netmgt.model.RrdGraphAttribute;
import org.opennms.netmgt.model.StringPropertyAttribute;
import org.opennms.netmgt.model.VirtualAttribute;
import org.opennms.netmgt.rrd.RrdUtils;
import org.opennms.test.FileAnticipator;
import org.opennms.test.ThrowableAnticipator;
import org.opennms.test.mock.MockUtil;

/**
 * @author <a href="mailto:dj@opennms.org">DJ Gregor</a>
 */
public class ResourceTypeUtilsTest {
    private FileAnticipator m_fileAnticipator;
    private File m_snmp;
    private File m_node;
    private File m_intf;

    @Before
    public void setUp() throws Exception {
        m_fileAnticipator = new FileAnticipator();
        m_fileAnticipator.initialize();
        m_snmp = m_fileAnticipator.tempDir(DefaultResourceDao.SNMP_DIRECTORY);
        
        RrdUtils.setStrategy(new NullRrdStrategy());
    }
    
    @After
    public void tearDown() throws Exception {
        m_fileAnticipator.tearDown();
    }
    

    @Test
    public void testLoadPropertiesNullRrdDirectory() {
        ThrowableAnticipator ta = new ThrowableAnticipator();
        ta.anticipate(new IllegalArgumentException("rrdDirectory argument must not be null"));
        try {
            //ResourceTypeUtils.loadProperties(null);
            ResourceTypeUtils.getStringProperties(null, "something");
        } catch (Throwable t) {
            ta.throwableReceived(t);
        }
        ta.verifyAnticipated();
    }

    @Test
    public void testLoadPropertiesNullRelativePath() {
        ThrowableAnticipator ta = new ThrowableAnticipator();
        ta.anticipate(new IllegalArgumentException("relativePath argument must not be null"));
        try {
            //ResourceTypeUtils.loadProperties(null);
            ResourceTypeUtils.getStringProperties(new File(""), null);
        } catch (Throwable t) {
            ta.throwableReceived(t);
        }
        ta.verifyAnticipated();
    }
    
    @Test
    public void testLoadPropertiesEmpty() throws Exception {
        OnmsResource childResource = createResource();
        createPropertiesFile(childResource, "", false);

        Properties p = ResourceTypeUtils.getStringProperties(m_fileAnticipator.getTempDir(), "snmp/1/eth0");
        
        assertNotNull("properties should not be null", p);
        assertEquals("properties size", 0, p.size());
    }
    
    @Test
    public void testLoadPropertiesNonEmpty() throws Exception {
        OnmsResource childResource = createResource();
        createPropertiesFile(childResource, "foo=bar", false);

        Properties p = ResourceTypeUtils.getStringProperties(m_fileAnticipator.getTempDir(), "snmp/1/eth0");
        
        assertNotNull("properties should not be null", p);
        assertEquals("properties size", 1, p.size());
        assertNotNull("property 'foo' should exist", p.get("foo"));
        assertEquals("property 'foo' value", "bar", p.get("foo"));
    }

    @Test
    public void testLoadPropertiesDoesNotExist() throws Exception {
        OnmsResource childResource = createResource();
        createPropertiesFile(childResource, "", true);

        Properties p = ResourceTypeUtils.getStringProperties(m_fileAnticipator.getTempDir(), "snmp/1/eth0");
        assertNull("no properties file was created, so the properties object should be null", p);
    }
    
    @Test
    public void testGetAttributesAtRelativePathWithBogusDirectory() {
        File bogusRrdDirectory = new File("/foo/bogus/blam/cheese/this/really/should/never/exist");
        assertFalse("bogus RRD directory " + bogusRrdDirectory + " should not exist", bogusRrdDirectory.exists());
        ResourceTypeUtils.getAttributesAtRelativePath(bogusRrdDirectory, "also-should-never-exist");
    }

    /*
     * This test is associated with issue NMS-5806:
     * http://issues.opennms.org/browse/NMS-5806
     */
    @Test
    public void testUpdateFileOutsideResourceTypeUtils() throws Exception {
        System.setProperty(PropertiesCache.CHECK_LAST_MODIFY_STRING, "true");

        // Be sure that the file doesn't exist.
        File resourceDir = new File("target/");
        File propertiesFile = new File(resourceDir, "strings.properties");
        propertiesFile.delete();

        // Creating a new strings.properties file and adding one value to it
        ResourceTypeUtils.updateStringProperty(resourceDir, "2012", "year");
        assertEquals("2012", ResourceTypeUtils.getStringProperty(resourceDir, "year"));
        Thread.sleep(1000l); // Simulate a delay, to be sure that we are going to have a different lastModifyTime

        // Externally updating the strings.proeprties file
        Properties properties = new Properties();
        properties.load(new FileInputStream(propertiesFile));
        properties.setProperty("year", "2013");
        properties.store(new FileWriter(propertiesFile), "Updated!");

        // Verify that after the external update, we can get the updated value
        assertEquals("2013", ResourceTypeUtils.getStringProperty(resourceDir, "year"));
    }

    @Test
    public void testLoadVirtualAttributes() throws Exception {
        OnmsResource childResource = createResource("1");
        OnmsResource sourceResource = createResource("2");
        createVirtualAttributesFile(childResource, "foo2=node[2].nodeSnmp[].bar\nfoo3=node[2].interfaceSnmp[eth0].a\n", false);
        createPropertiesFile(sourceResource, "a=bar", false);

        File resourceDir = new File(m_fileAnticipator.getTempDir(), "snmp/1/eth0");
        Properties p = ResourceTypeUtils.getVirtualProperties(resourceDir);

        Set<OnmsAttribute> set = ResourceTypeUtils.getAttributesAtRelativePath(m_fileAnticipator.getTempDir(), "snmp/1/eth0");
        assertNotNull("set should not be null", set);
        assertEquals("set size", 2, set.size());
        for(OnmsAttribute attr : set) {
            MockUtil.println(attr.getName());
            if (VirtualAttribute.class.isAssignableFrom(attr.getClass())) {
                VirtualAttribute v = (VirtualAttribute) attr;
                if (v.getName().equals("foo2")) {
                    assertEquals("virtual-rrd", "node[2].nodeSnmp[].bar", v.getOriginalResourceId());
                }
                if (v.getName().equals("foo3")) {
                    assertEquals("virtual-rrd", "node[2].interfaceSnmp[eth0].a", v.getOriginalResourceId());
                }
            }
        }

        assertNotNull("properties should not be null", p);
        assertEquals("properties size", 2, p.size());
        assertNotNull("property 'foo' should exist", p.get("foo2"));
        assertEquals("property 'foo' value", "node[2].nodeSnmp[].bar", p.get("foo2"));
    }

    private OnmsResource createResource() {
        return createResource("1");
    }

    private OnmsResource createResource(String node) {
        OnmsResource topResource = new OnmsResource(node, "Node One", new MockResourceType(), new HashSet<OnmsAttribute>(0));
        Set<OnmsAttribute> attributes = new HashSet<OnmsAttribute>(1);
        attributes.add(new RrdGraphAttribute("foo", node+"/eth0", "foo.jrb"));
        OnmsResource childResource = new OnmsResource("eth0", "Interface eth0", new MockResourceType(), attributes);
        childResource.setParent(topResource);
        return childResource;
    }

    private File createPropertiesFile(OnmsResource childResource, String propertiesContent, boolean onlyCreateParentDirectories) throws IOException {
        m_node = m_fileAnticipator.tempDir(m_snmp, childResource.getParent().getName());
        m_intf = m_fileAnticipator.tempDir(m_node, childResource.getName());
        if (onlyCreateParentDirectories) {
            return new File(m_intf, "strings.properties");
        } else {
            return m_fileAnticipator.tempFile(m_intf, "strings.properties", propertiesContent);
        }
    }
    
    private File createVirtualAttributesFile(OnmsResource childResource, String propertiesContent, boolean onlyCreateParentDirectories) throws IOException {
        m_node = m_fileAnticipator.tempDir(m_snmp, childResource.getParent().getName());
        m_intf = m_fileAnticipator.tempDir(m_node, childResource.getName());
        if (onlyCreateParentDirectories) {
            return new File(m_intf, "virtual-datasources.properties");
        } else {
            return m_fileAnticipator.tempFile(m_intf, "virtual-datasources.properties", propertiesContent);
        }
    }
}
