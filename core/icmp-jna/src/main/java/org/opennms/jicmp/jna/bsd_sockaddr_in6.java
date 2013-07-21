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

package org.opennms.jicmp.jna;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.jna.Structure;

/**
 * The Class bsd_sockaddr_in6.
 */
public class bsd_sockaddr_in6 extends Structure {

    /** The sin6_len. */
    public byte sin6_len;

    /** The sin6_family. */
    public byte sin6_family;

    /** The sin6_port. */
    public byte[] sin6_port = new byte[2]; /* Transport layer port # (in_port_t) */

    /** The sin6_flowinfo. */
    public byte[] sin6_flowinfo = new byte[4]; /* IP6 flow information */

    /** The sin6_addr. */
    public byte[] sin6_addr = new byte[16]; /* IP6 address */

    /** The sin6_scope_id. */
    public byte[] sin6_scope_id = new byte[4]; /* scope zone index */

    /**
     * Instantiates a new bsd_sockaddr_in6.
     *
     * @param family
     *            the family
     * @param addr
     *            the addr
     * @param port
     *            the port
     */
    public bsd_sockaddr_in6(int family, byte[] addr, byte[] port) {
        sin6_family = (byte) (0xff & family);
        assertLen("port", port, 2);
        sin6_port = port;
        sin6_flowinfo = new byte[4];
        assertLen("address", addr, 16);
        sin6_addr = addr;
        sin6_scope_id = new byte[4];
        sin6_len = (byte) (0xff & size());
    }

    /**
     * Instantiates a new bsd_sockaddr_in6.
     */
    public bsd_sockaddr_in6() {
        this((byte) 0, new byte[16], new byte[2]);
    }

    /**
     * Instantiates a new bsd_sockaddr_in6.
     *
     * @param address
     *            the address
     * @param port
     *            the port
     */
    public bsd_sockaddr_in6(InetAddress address, int port) {
        this(NativeDatagramSocket.AF_INET6, address.getAddress(), new byte[] { (byte) (0xff & (port >> 8)),
                (byte) (0xff & port) });
    }

    /**
     * Assert len.
     *
     * @param field
     *            the field
     * @param addr
     *            the addr
     * @param len
     *            the len
     */
    private void assertLen(String field, byte[] addr, int len) {
        if (addr.length != len) {
            throw new IllegalArgumentException(field + " length must be " + len + " bytes but was " + addr.length
                    + " bytes.");
        }
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public InetAddress getAddress() {
        try {
            return InetAddress.getByAddress(sin6_addr);
        } catch (UnknownHostException ex) {
            // this can never happen as sin6_addr is always 16 bytes long.
            return null;
        }
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the new address
     */
    public void setAddress(InetAddress address) {
        byte[] addr = address.getAddress();
        assertLen("address", addr, 16);
        sin6_addr = addr;
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public int getPort() {
        int port = 0;
        for (int i = 0; i < 2; i++) {
            port = ((port << 8) | (sin6_port[i] & 0xff));
        }
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port
     *            the new port
     */
    public void setPort(int port) {
        byte[] p = new byte[] { (byte) (0xff & (port >> 8)), (byte) (0xff & port) };
        assertLen("port", p, 2);
        sin6_port = p;
    }
}
