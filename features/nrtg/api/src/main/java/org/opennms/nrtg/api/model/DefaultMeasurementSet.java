/**
 * *****************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2012 The OpenNMS Group, Inc. OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with OpenNMS(R). If not, see:
 * http://www.gnu.org/licenses/
 *
 * For more information contact: OpenNMS(R) Licensing <license@opennms.org> http://www.opennms.org/ http://www.opennms.com/
 ******************************************************************************
 */
package org.opennms.nrtg.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class DefaultMeasurementSet.
 *
 * @author Markus Neumann
 * @author Christian Pape
 */
public class DefaultMeasurementSet implements MeasurementSet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7536809905120941525L;

    /** The m_measurements. */
    private List<Measurement> m_measurements = new ArrayList<Measurement>();

    /**
     * Adds the measurement.
     *
     * @param measurement
     *            the measurement
     */
    public void addMeasurement(Measurement measurement) {
        m_measurements.add(measurement);
    }

    /* (non-Javadoc)
     * @see org.opennms.nrtg.api.model.MeasurementSet#getJson()
     */
    @Override
    public String getJson() {
        StringBuilder buf = new StringBuilder("[");

        boolean first = true;
        for (Measurement m : getMeasurements()) {
            if (!first) {
                buf.append(",");
            } else {
                first = false;
            }
            buf.append("{");
            buf.append("\"metricId\"").append(":\"").append(m.getMetricId()).append("\"").append(",");
            buf.append("\"metricType\"").append(":\"").append(m.getMetricType()).append("\"").append(",");
            buf.append("\"netInterface\"").append(":\"").append(m.getNetInterface()).append("\"").append(",");
            buf.append("\"nodeId\"").append(":").append(m.getNodeId()).append(",");
            buf.append("\"service\"").append(":\"").append(m.getService()).append("\"").append(",");
            buf.append("\"timeStamp\"").append(":").append(m.getTimestamp().getTime()).append(",");
            buf.append("\"onmsLogicMetricId\"").append(":\"").append(m.getOnmsLogicMetricId()).append("\",");
            buf.append("\"value\"").append(":").append(m.getValue());
            buf.append("}");
        }

        buf.append("]");
        return buf.toString();
    }

    /* (non-Javadoc)
     * @see org.opennms.nrtg.api.model.MeasurementSet#getMeasurements()
     */
    @Override
    public List<Measurement> getMeasurements() {
        return m_measurements;
    }

    /**
     * This toString method is for displaying reasons in the webapp NrtGrapher
     * only. It's for prototyping only.
     *
     * @return a {@link String} that contains the metrics and there values in a
     *         easy parsable way.
     */
    @Override
    public String toString() {
        return this.getJson();
    }
}
