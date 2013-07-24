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

package org.opennms.web.graph;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.opennms.netmgt.model.OnmsResource;

/**
 * <p>
 * GraphResults class.
 * </p>
 *
 * @author ranger
 * @version $Id: $
 * @since 1.8.1
 */
public class GraphResults {
    // note these run from 0-11, this is because of java.util.Calendar!
    /** The Constant s_months. */
    private static final String[] s_months = new String[] { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };

    /** The Constant s_monthMap. */
    private static final Map<Integer, String> s_monthMap;

    /** The Constant s_hours. */
    private static final String[] s_hours;

    /** The Constant s_hourMap. */
    private static final Map<Integer, String> s_hourMap;

    /** The m_reports. */
    private String[] m_reports;

    /** The m_start. */
    private Date m_start;

    /** The m_end. */
    private Date m_end;

    /** The m_relative time. */
    private String m_relativeTime;

    /** The m_relative time periods. */
    private RelativeTimePeriod[] m_relativeTimePeriods;

    /** The m_graph result sets. */
    private List<GraphResultSet> m_graphResultSets = new LinkedList<GraphResultSet>();

    /** The m_graph top offset with text. */
    private int m_graphTopOffsetWithText;

    /** The m_graph left offset. */
    private int m_graphLeftOffset;

    /** The m_graph right offset. */
    private int m_graphRightOffset;

    // FIXME: this is very US-centric; can we have it use the system locale?
    static {
        s_monthMap = new LinkedHashMap<Integer, String>();
        for (int i = 0; i < s_months.length; i++) {
            s_monthMap.put(i, s_months[i]);
        }

        s_hours = new String[24];
        for (int i = 0; i < s_hours.length; i++) {
            int hour = i % 12;
            if (hour == 0) {
                hour = 12;
            }
            s_hours[i] = hour + " " + (i < 12 ? "AM" : "PM");
        }

        s_hourMap = new LinkedHashMap<Integer, String>();
        for (int i = 0; i < s_hours.length; i++) {
            s_hourMap.put(i, s_hours[i]);
        }

    }

    /**
     * <p>
     * setStart
     * </p>
     * .
     *
     * @param start
     *            a {@link java.util.Date} object.
     */
    public void setStart(Date start) {
        m_start = start;
    }

    /**
     * <p>
     * getStart
     * </p>
     * .
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getStart() {
        return m_start;
    }

    /**
     * <p>
     * getStartCalendar
     * </p>
     * .
     *
     * @return a {@link org.opennms.web.graph.GraphResults.BeanFriendlyCalendar}
     *         object.
     */
    public BeanFriendlyCalendar getStartCalendar() {
        return new BeanFriendlyCalendar(m_start);
    }

    /**
     * <p>
     * setEnd
     * </p>
     * .
     *
     * @param end
     *            a {@link java.util.Date} object.
     */
    public void setEnd(Date end) {
        m_end = end;
    }

    /**
     * <p>
     * getEnd
     * </p>
     * .
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getEnd() {
        return m_end;
    }

    /**
     * <p>
     * getEndCalendar
     * </p>
     * .
     *
     * @return a {@link org.opennms.web.graph.GraphResults.BeanFriendlyCalendar}
     *         object.
     */
    public BeanFriendlyCalendar getEndCalendar() {
        return new BeanFriendlyCalendar(m_end);
    }

    /**
     * <p>
     * setRelativeTime
     * </p>
     * .
     *
     * @param relativeTime
     *            a {@link java.lang.String} object.
     */
    public void setRelativeTime(String relativeTime) {
        m_relativeTime = relativeTime;
    }

    /**
     * <p>
     * getRelativeTime
     * </p>
     * .
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRelativeTime() {
        return m_relativeTime;
    }

    /**
     * <p>
     * setRelativeTimePeriods
     * </p>
     * .
     *
     * @param relativeTimePeriods
     *            an array of {@link org.opennms.web.graph.RelativeTimePeriod}
     *            objects.
     */
    public void setRelativeTimePeriods(RelativeTimePeriod[] relativeTimePeriods) {
        m_relativeTimePeriods = relativeTimePeriods;
    }

    /**
     * <p>
     * getRelativeTimePeriods
     * </p>
     * .
     *
     * @return an array of {@link org.opennms.web.graph.RelativeTimePeriod}
     *         objects.
     */
    public RelativeTimePeriod[] getRelativeTimePeriods() {
        return m_relativeTimePeriods;
    }

    /**
     * <p>
     * getMonths
     * </p>
     * .
     *
     * @return an array of {@link java.lang.String} objects.
     */
    public static String[] getMonths() {
        return s_months;
    }

    /**
     * <p>
     * getMonthMap
     * </p>
     * .
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<Integer, String> getMonthMap() {
        return s_monthMap;
    }

    /**
     * <p>
     * getHours
     * </p>
     * .
     *
     * @return an array of {@link java.lang.String} objects.
     */
    public static String[] getHours() {
        return s_hours;
    }

    /**
     * <p>
     * getHourMap
     * </p>
     * .
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<Integer, String> getHourMap() {
        return s_hourMap;
    }

    /**
     * <p>
     * addGraphResultSet
     * </p>
     * .
     *
     * @param resultSet
     *            a {@link org.opennms.web.graph.GraphResults.GraphResultSet}
     *            object.
     */
    public void addGraphResultSet(GraphResultSet resultSet) {
        m_graphResultSets.add(resultSet);
    }

    /**
     * <p>
     * getGraphResultSets
     * </p>
     * .
     *
     * @return a {@link java.util.List} object.
     */
    public List<GraphResultSet> getGraphResultSets() {
        return m_graphResultSets;
    }

    /**
     * <p>
     * getReports
     * </p>
     * .
     *
     * @return an array of {@link java.lang.String} objects.
     */
    public String[] getReports() {
        return m_reports;
    }

    /**
     * <p>
     * setReports
     * </p>
     * .
     *
     * @param reports
     *            an array of {@link java.lang.String} objects.
     */
    public void setReports(String[] reports) {
        m_reports = reports;
    }

    /**
     * The Class GraphResultSet.
     */
    public class GraphResultSet {

        /** The m_graphs. */
        private List<Graph> m_graphs = null;

        /** The m_resource. */
        private OnmsResource m_resource;

        /**
         * Instantiates a new graph result set.
         */
        public GraphResultSet() {
        }

        /**
         * Sets the resource.
         *
         * @param resource
         *            the new resource
         */
        public void setResource(OnmsResource resource) {
            m_resource = resource;
        }

        /**
         * Gets the resource.
         *
         * @return the resource
         */
        public OnmsResource getResource() {
            return m_resource;
        }

        /**
         * Gets the graphs.
         *
         * @return the graphs
         */
        public List<Graph> getGraphs() {
            return m_graphs;
        }

        /**
         * Sets the graphs.
         *
         * @param graphs
         *            the new graphs
         */
        public void setGraphs(List<Graph> graphs) {
            m_graphs = graphs;
        }
    }

    /**
     * The Class BeanFriendlyCalendar.
     */
    public class BeanFriendlyCalendar extends GregorianCalendar {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = -4145668894553732167L;

        /**
         * Instantiates a new bean friendly calendar.
         *
         * @param date
         *            the date
         */
        public BeanFriendlyCalendar(Date date) {
            super();
            setTime(date);
        }

        /**
         * Gets the year.
         *
         * @return the year
         */
        public int getYear() {
            return get(Calendar.YEAR);
        }

        /**
         * Gets the month.
         *
         * @return the month
         */
        public int getMonth() {
            return get(Calendar.MONTH);
        }

        /**
         * Gets the date.
         *
         * @return the date
         */
        public int getDate() {
            return get(Calendar.DATE);
        }

        /**
         * Gets the hour of day.
         *
         * @return the hour of day
         */
        public int getHourOfDay() {
            return get(Calendar.HOUR_OF_DAY);
        }
    }

    /**
     * <p>
     * getGraphLeftOffset
     * </p>
     * .
     *
     * @return a int.
     */
    public int getGraphLeftOffset() {
        return m_graphLeftOffset;
    }

    /**
     * <p>
     * setGraphLeftOffset
     * </p>
     * .
     *
     * @param graphLeftOffset
     *            a int.
     */
    public void setGraphLeftOffset(int graphLeftOffset) {
        m_graphLeftOffset = graphLeftOffset;

    }

    /**
     * <p>
     * getGraphRightOffset
     * </p>
     * .
     *
     * @return a int.
     */
    public int getGraphRightOffset() {
        return m_graphRightOffset;
    }

    /**
     * <p>
     * setGraphRightOffset
     * </p>
     * .
     *
     * @param graphRightOffset
     *            a int.
     */
    public void setGraphRightOffset(int graphRightOffset) {
        m_graphRightOffset = graphRightOffset;
    }

    /**
     * <p>
     * getGraphTopOffsetWithText
     * </p>
     * .
     *
     * @return a int.
     */
    public int getGraphTopOffsetWithText() {
        return m_graphTopOffsetWithText;
    }

    /**
     * <p>
     * setGraphTopOffsetWithText
     * </p>
     * .
     *
     * @param graphTopOffsetWithText
     *            a int.
     */
    public void setGraphTopOffsetWithText(int graphTopOffsetWithText) {
        m_graphTopOffsetWithText = graphTopOffsetWithText;
    }

}
