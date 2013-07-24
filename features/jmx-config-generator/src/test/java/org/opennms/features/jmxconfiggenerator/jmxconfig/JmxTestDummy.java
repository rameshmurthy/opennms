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

package org.opennms.features.jmxconfiggenerator.jmxconfig;

import org.junit.Ignore;

/**
 * The Class JmxTestDummy.
 *
 * @author Markus Neumann <markus@opennms.com>
 */
@Ignore
public class JmxTestDummy implements JmxTestDummyMBean {

    /** The name. */
    String name = "JmxTest";

    /** The x. */
    int x = 42;

    /** The writable. */
    int writable = 0;

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#getX()
     */
    @Override
    public int getX() {
        return x;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#getInteger()
     */
    @Override
    public Integer getInteger() {
        return new Integer(42);
    }

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#getLong()
     */
    @Override
    public Long getLong() {
        return new Long(42);
    }

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#setWritableY(int)
     */
    @Override
    public void setWritableY(int writable) {
        this.writable = writable;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.jmxconfiggenerator.jmxconfig.JmxTestDummyMBean#getWritableY()
     */
    @Override
    public int getWritableY() {
        return writable;
    }
}
