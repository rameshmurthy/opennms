/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.snmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class SnmpRowResult.
 */
public class SnmpRowResult {

    /** The m_results. */
    private final Map<SnmpObjId, SnmpResult> m_results = new TreeMap<SnmpObjId, SnmpResult>();

    /** The m_instance. */
    private SnmpInstId m_instance;

    /** The m_column count. */
    private int m_columnCount;

    /**
     * Instantiates a new snmp row result.
     *
     * @param columnCount
     *            the column count
     * @param instance
     *            the instance
     */
    public SnmpRowResult(int columnCount, SnmpInstId instance) {
        m_instance = instance;
        m_columnCount = columnCount;
    }

    /**
     * Checks if is complete.
     *
     * @param ignoreColumns
     *            the ignore columns
     * @return true, if is complete
     */
    public boolean isComplete(SnmpObjId... ignoreColumns) {
        if (m_results.size() == m_columnCount) {
            return true;
        } else if (m_results.size() > 0 && ignoreColumns.length > 0) {
            /*
             * short-circuit if the table result is telling us to consider
             * certain SnmpObjId's as finished
             */
            int total = m_results.size();
            for (SnmpObjId col : ignoreColumns) {
                if (!m_results.containsKey(col)) {
                    total++;
                }
            }
            return total == m_columnCount;
        }
        return false;
    }

    /**
     * Gets the column count.
     *
     * @return the column count
     */
    public int getColumnCount() {
        return m_columnCount;
    }

    /**
     * Gets the results.
     *
     * @return the results
     */
    public List<SnmpResult> getResults() {
        return new ArrayList<SnmpResult>(m_results.values());
    }

    /**
     * Adds the result.
     *
     * @param column
     *            the column
     * @param result
     *            the result
     */
    public void addResult(SnmpObjId column, SnmpResult result) {
        assertTrue(m_instance.equals(result.getInstance()), "unexpected result %s passed to row with instance %s",
                   result, m_instance);
        m_results.put(column, result);
    }

    /**
     * Gets the single instance of SnmpRowResult.
     *
     * @return single instance of SnmpRowResult
     */
    public SnmpInstId getInstance() {
        return m_instance;
    }

    /**
     * Gets the value.
     *
     * @param base
     *            the base
     * @return the value
     */
    public SnmpValue getValue(SnmpObjId base) {
        for (SnmpResult result : getResults()) {
            if (base.equals(result.getBase())) {
                return result.getValue();
            }
        }

        return null;
    }

    /**
     * Assert true.
     *
     * @param b
     *            the b
     * @param fmt
     *            the fmt
     * @param args
     *            the args
     */
    private void assertTrue(boolean b, String fmt, Object... args) {
        if (!b) {
            throw new IllegalArgumentException(String.format(fmt, args));
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("columnCount", m_columnCount).append("results", m_results).toString();
    }

}
