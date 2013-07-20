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

package org.opennms.netmgt.correlation.ncs;

import org.opennms.netmgt.xml.event.Event;

public class Resolved {
    private Event m_cause;

    private Event m_resolution;

    public Resolved(Event cause, Event resolution) {
        m_cause = cause;
        m_resolution = resolution;
    }

    public Event getCause() {
        return m_cause;
    }

    public void setCause(Event cause) {
        m_cause = cause;
    }

    public Event getResolution() {
        return m_resolution;
    }

    public void setResolution(Event resolution) {
        m_resolution = resolution;
    }

    @Override
    public String toString() {
        return "Resolved[ " + "cause=" + m_cause + ", resolution=" + m_resolution + " ]";
    }

}
