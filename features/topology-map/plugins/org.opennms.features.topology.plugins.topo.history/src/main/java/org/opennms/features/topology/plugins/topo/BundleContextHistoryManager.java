/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2012 The OpenNMS Group, Inc.
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
package org.opennms.features.topology.plugins.topo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.opennms.features.topology.api.support.AbstractHistoryManager;
import org.opennms.features.topology.api.support.SavedHistory;
import org.osgi.framework.BundleContext;
import org.slf4j.LoggerFactory;

/**
 * The Class BundleContextHistoryManager.
 */
public class BundleContextHistoryManager extends AbstractHistoryManager {

    /** The m_bundle context. */
    private final BundleContext m_bundleContext;

    /** The Constant DATA_FILE_NAME. */
    public static final String DATA_FILE_NAME = BundleContextHistoryManager.class.getName() + ".properties";

    /**
     * Instantiates a new bundle context history manager.
     *
     * @param bundleContext
     *            the bundle context
     */
    public BundleContextHistoryManager(BundleContext bundleContext) {
        m_bundleContext = bundleContext;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.support.AbstractHistoryManager#saveHistory(java.lang.String, org.opennms.features.topology.api.support.SavedHistory)
     */
    @Override
    protected synchronized void saveHistory(String userId, SavedHistory hist) {
        Properties props = loadProperties(m_bundleContext);
        StringWriter writer = new StringWriter();
        Marshaller marshaller;
        try {
            JAXBContext context = JAXBContext.newInstance(SavedHistory.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
            marshaller.marshal(hist, writer);
        } catch (JAXBException e) {
            LoggerFactory.getLogger(getClass()).error("Could not marshall SavedHistory object to String", e);
        }
        props.put(hist.getFragment(), writer.toString());
        props.put(userId, hist.getFragment());
        storeProperties(m_bundleContext, props);
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.support.AbstractHistoryManager#getHistory(java.lang.String, java.lang.String)
     */
    @Override
    protected synchronized SavedHistory getHistory(String userId, String fragmentId) {
        if (fragmentId != null) {
            Properties props = loadProperties(m_bundleContext);
            String xml = props.getProperty(fragmentId);
            if (xml == null || "".equals(xml)) {
                // There is no stored history for this fragment ID
                return null;
            } else {
                return JAXB.unmarshal(new StringReader(xml), SavedHistory.class);
            }
        }

        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.HistoryManager#getHistoryForUser(java.lang.String)
     */
    @Override
    public synchronized String getHistoryForUser(String userId) {
        return loadProperties(m_bundleContext).getProperty(userId);
    }

    /**
     * Load properties.
     *
     * @param context
     *            the context
     * @return the properties
     */
    private static Properties loadProperties(BundleContext context) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(context.getDataFile(DATA_FILE_NAME)));
        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger(BundleContextHistoryManager.class).warn("BundleContextHistoryManager data file does not exist yet");
        } catch (IOException e) {
            LoggerFactory.getLogger(BundleContextHistoryManager.class).warn("IOException when reading BundleContextHistoryManager data file",
                                                                            e);
        }
        return props;
    }

    /**
     * Store properties.
     *
     * @param context
     *            the context
     * @param props
     *            the props
     */
    private static void storeProperties(BundleContext context, Properties props) {
        try {
            props.store(new FileOutputStream(context.getDataFile(DATA_FILE_NAME)),
                        BundleContextHistoryManager.class.getName() + " History Data");
        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger(BundleContextHistoryManager.class).warn("BundleContextHistoryManager data file does not exist");
        } catch (IOException e) {
            LoggerFactory.getLogger(BundleContextHistoryManager.class).warn("IOException when writing to BundleContextHistoryManager data file",
                                                                            e);
        }
    }
}
