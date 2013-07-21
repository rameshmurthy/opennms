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
package org.opennms.netmgt.linkd.snmp;

import java.util.List;

import org.opennms.netmgt.model.OnmsVlan;
import org.opennms.netmgt.model.OnmsVlan.VlanStatus;

/**
 * The Interface VlanTable.
 */
public interface VlanTable {

    /** The VLAN string to define default VLAN name. */
    public static final String DEFAULT_VLAN_NAME = "default";

    /** The VLAN int to define default VLAN index. */
    public static final int DEFAULT_VLAN_INDEX = 1;

    /** The VLAN int to define default VLAN status, 1 means operational/active. */
    public static final VlanStatus DEFAULT_VLAN_STATUS = VlanStatus.CISCOVTP_OPERATIONAL;

    /**
     * Gets the vlans for snmp collection.
     *
     * @return the vlans for snmp collection
     */
    public List<OnmsVlan> getVlansForSnmpCollection();

}
