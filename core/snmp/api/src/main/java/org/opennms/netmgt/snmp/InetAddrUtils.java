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
package org.opennms.netmgt.snmp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * The Class InetAddrUtils.
 */
public class InetAddrUtils {

    /**
     * Str.
     *
     * @param address
     *            the address
     * @return the string
     */
    public static String str(InetAddress address) {
        return address == null ? null : address.getHostAddress();
    }

    /**
     * Addr.
     *
     * @param value
     *            the value
     * @return the inet address
     */
    public static InetAddress addr(String value) {
        try {
            return value == null ? null : InetAddress.getByName(value);
        } catch (UnknownHostException e) {
            throw new RuntimeException("Unable to turn " + value + " into an inet address");
        }
    }

    /**
     * Gets the local host address.
     *
     * @return the local host address
     */
    public static InetAddress getLocalHostAddress() {
        return addr("127.0.0.1");
    }

}
