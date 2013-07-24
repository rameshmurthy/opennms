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

package org.opennms.features.gwt.ksc.add.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;

/**
 * The Class GraphInfo.
 */
public final class GraphInfo {

    /** The m_report. */
    private String m_report = null;

    /** The m_title. */
    private String m_title = null;

    /** The m_resource id. */
    private String m_resourceId = null;

    /** The m_timespan. */
    private String m_timespan = null;

    /** The m_start time. */
    private Integer m_startTime = null;

    /** The m_end time. */
    private Integer m_endTime = null;

    /**
     * Instantiates a new graph info.
     *
     * @param elem
     *            the elem
     */
    public GraphInfo(final Element elem) {
        // required
        m_report = elem.getAttribute("reportName");
        m_resourceId = elem.getAttribute("resourceId");
        m_timespan = elem.getAttribute("timespan");
        if (m_report == null) {
            GWT.log("element missing the required report tag!");
        }
        if (m_resourceId == null) {
            GWT.log("element missing the required resourceId tag!");
        }
        if (m_timespan == null) {
            GWT.log("element missing the required timespan tag!");
        }

        // optional
        m_title = elem.getAttribute("graphTitle");

        if ("lastday".equals(m_timespan)) {
            m_timespan = "1_day";
        } else if ("lastweek".equals(m_timespan)) {
            m_timespan = "7_day";
        } else if ("lastmonth".equals(m_timespan)) {
            m_timespan = "1_month";
        } else if ("lastyear".equals(m_timespan)) {
            m_timespan = "1_year";
        } else {
            GWT.log("invalid timespan '" + m_timespan + "', using 7_day");
        }
    }

    /**
     * Gets the report name.
     *
     * @return the report name
     */
    public String getReportName() {
        return m_report;
    }

    /**
     * Gets the resource id.
     *
     * @return the resource id
     */
    public String getResourceId() {
        return m_resourceId;
    }

    /**
     * Gets the timespan.
     *
     * @return the timespan
     */
    public String getTimespan() {
        return m_timespan;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return m_title;
    }

    /**
     * Gets the start time.
     *
     * @return the start time
     */
    public Integer getStartTime() {
        return m_startTime;
    }

    /**
     * Gets the end time.
     *
     * @return the end time
     */
    public Integer getEndTime() {
        return m_endTime;
    }
}
