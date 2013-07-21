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

import java.util.Map;

import org.opennms.features.topology.app.internal.gwt.client.service.Filter;

/**
 * The Class NotFilter.
 */
public class NotFilter extends AbstractFilter {

    /** The m_filter. */
    Filter m_filter;

    /**
     * Instantiates a new not filter.
     *
     * @param filter
     *            the filter
     */
    public NotFilter(Filter filter) {
        m_filter = filter;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.app.internal.gwt.client.service.filter.AbstractFilter#match(java.util.Map)
     */
    @Override
    public boolean match(Map<String, String> properties) {
        return !m_filter.match(properties);
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.app.internal.gwt.client.service.filter.AbstractFilter#toString()
     */
    @Override
    public String toString() {
        return new StringBuilder().append("(!").append(m_filter).append(")").toString();
    }

}
