/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2010-2012 The OpenNMS Group, Inc.
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

package org.opennms.api.reporting.parameter;

import java.io.Serializable;

/**
 * <p>
 * ReportStringParm class.
 * </p>
 *
 * @author ranger
 * @version $Id: $
 */
public class ReportStringParm extends ReportParm implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2057597127243217834L;

    /** The m_value. */
    String m_value;

    /** The m_type. */
    String m_type;

    /**
     * <p>
     * Constructor for ReportStringParm.
     * </p>
     */
    public ReportStringParm() {
        super();
    }

    /**
     * <p>
     * getValue
     * </p>
     * .
     *
     * @return a {@link java.lang.String} object.
     */
    public String getValue() {
        return m_value;
    }

    /**
     * <p>
     * setValue
     * </p>
     * .
     *
     * @param value
     *            a {@link java.lang.String} object.
     */
    public void setValue(String value) {
        m_value = value;
    }

    /**
     * <p>
     * getInputType
     * </p>
     * .
     *
     * @return a {@link java.lang.String} object.
     */
    public String getInputType() {
        return m_type;
    }

    /**
     * <p>
     * setInputType
     * </p>
     * .
     *
     * @param type
     *            a {@link java.lang.String} object.
     */
    public void setInputType(String type) {
        m_type = type;
    }

}
