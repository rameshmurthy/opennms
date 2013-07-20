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

package org.opennms.netmgt.config.mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.opennms.netmgt.config.GroupManager;

/**
 * The Class MockGroupManager.
 */
public class MockGroupManager extends GroupManager {

    /** The m_xml string. */
    String m_xmlString;

    /** The update needed. */
    boolean updateNeeded = false;

    /**
     * Instantiates a new mock group manager.
     *
     * @param xmlString
     *            the xml string
     * @throws MarshalException
     *             the marshal exception
     * @throws ValidationException
     *             the validation exception
     */
    public MockGroupManager(String xmlString) throws MarshalException, ValidationException {
        m_xmlString = xmlString;
        parseXML();
    }

    /**
     * Parses the xml.
     *
     * @throws MarshalException
     *             the marshal exception
     * @throws ValidationException
     *             the validation exception
     */
    private void parseXML() throws MarshalException, ValidationException {
        try {
            InputStream reader = new ByteArrayInputStream(m_xmlString.getBytes("UTF-8"));
            parseXml(reader);
            updateNeeded = false;
        } catch (UnsupportedEncodingException e) {
            // Can't happen with UTF-8
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.config.GroupManager#update()
     */
    @Override
    public void update() throws IOException, MarshalException, ValidationException {
        if (updateNeeded) {
            parseXML();
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.config.GroupManager#saveXml(java.lang.String)
     */
    @Override
    protected void saveXml(String data) throws IOException {
        m_xmlString = data;
        updateNeeded = true;
    }

}
