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

package org.opennms.netmgt.snmp.snmp4j;

import org.opennms.netmgt.snmp.SnmpV2TrapBuilder;
import org.snmp4j.PDU;

/**
 * The Class Snmp4JV2InformBuilder.
 */
public class Snmp4JV2InformBuilder extends Snmp4JV2TrapBuilder implements SnmpV2TrapBuilder {

    /**
     * Instantiates a new snmp4 j v2 inform builder.
     *
     * @param strategy
     *            the strategy
     */
    protected Snmp4JV2InformBuilder(Snmp4JStrategy strategy) {
        super(strategy, new PDU(), PDU.INFORM);
    }

}
