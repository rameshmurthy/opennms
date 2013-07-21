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
package org.opennms.features.topology.app.internal.gwt.client.service.filter;

/**
 * The Class LessThanFilter.
 */
public class LessThanFilter extends AttributeComparisonFilter {

    /** The m_value. */
    private String m_value;

    /**
     * Instantiates a new less than filter.
     *
     * @param attribute
     *            the attribute
     * @param value
     *            the value
     */
    public LessThanFilter(String attribute, String value) {
        super(attribute);
        m_value = value;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.app.internal.gwt.client.service.filter.AttributeComparisonFilter#valueMatches(java.lang.String)
     */
    @Override
    protected boolean valueMatches(String value) {
        try {
            return Double.parseDouble(value) <= Double.parseDouble(m_value);
        } catch (NumberFormatException e) {
            return value.compareToIgnoreCase(m_value) <= 0;
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.app.internal.gwt.client.service.filter.AttributeComparisonFilter#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("(").append(getAttribute()).append("<=").append(m_value).append(")");
        return buf.toString();
    }

}
