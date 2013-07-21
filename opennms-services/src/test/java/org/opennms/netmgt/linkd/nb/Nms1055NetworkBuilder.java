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

package org.opennms.netmgt.linkd.nb;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.opennms.core.utils.InetAddressUtils;
import org.opennms.netmgt.model.OnmsNode;

/**
 * The Class Nms1055NetworkBuilder.
 *
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @author <a href="mailto:antonio@opennme.it">Antonio Russo</a>
 * @author <a href="mailto:alejandro@opennms.org">Alejandro Galue</a>
 */

public abstract class Nms1055NetworkBuilder extends LinkdNetworkBuilder {

    /** The Constant PENROSE_IP. */
    protected static final String PENROSE_IP = "10.155.69.16";

    /** The Constant PENROSE_NAME. */
    protected static final String PENROSE_NAME = "penrose-mx480";

    /** The Constant PENROSE_SYSOID. */
    protected static final String PENROSE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.25";

    /** The Constant PENROSE_LLDP_CHASSISID. */
    protected static final String PENROSE_LLDP_CHASSISID = "80711f8fafc0";

    /** The Constant PENROSE_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> PENROSE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant PENROSE_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> PENROSE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant PENROSE_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> PENROSE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant PENROSE_IF_MAC_MAP. */
    protected static final Map<Integer, String> PENROSE_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant PENROSE_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> PENROSE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant PENROSE_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> PENROSE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    /** The Constant DELAWARE_IP. */
    protected static final String DELAWARE_IP = "10.155.69.17";

    /** The Constant DELAWARE_NAME. */
    protected static final String DELAWARE_NAME = "delaware";

    /** The Constant DELAWARE_SYSOID. */
    protected static final String DELAWARE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.25";

    /** The Constant DELAWARE_LLDP_CHASSISID. */
    protected static final String DELAWARE_LLDP_CHASSISID = "0022830957c0";

    /** The Constant DELAWARE_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> DELAWARE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant DELAWARE_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> DELAWARE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant DELAWARE_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> DELAWARE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant DELAWARE_IF_MAC_MAP. */
    protected static final Map<Integer, String> DELAWARE_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant DELAWARE_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> DELAWARE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant DELAWARE_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> DELAWARE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    /** The Constant PHOENIX_IP. */
    protected static final String PHOENIX_IP = "10.155.69.42";

    /** The Constant PHOENIX_NAME. */
    protected static final String PHOENIX_NAME = "phoenix-mx80";

    /** The Constant PHOENIX_SYSOID. */
    protected static final String PHOENIX_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.57";

    /** The Constant PHOENIX_LLDP_CHASSISID. */
    protected static final String PHOENIX_LLDP_CHASSISID = "80711fc414c0";

    /** The Constant PHOENIX_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> PHOENIX_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant PHOENIX_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> PHOENIX_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant PHOENIX_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> PHOENIX_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant PHOENIX_IF_MAC_MAP. */
    protected static final Map<Integer, String> PHOENIX_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant PHOENIX_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> PHOENIX_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant PHOENIX_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> PHOENIX_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    /** The Constant AUSTIN_IP. */
    protected static final String AUSTIN_IP = "10.155.69.43";

    /** The Constant AUSTIN_NAME. */
    protected static final String AUSTIN_NAME = "Austin";

    /** The Constant AUSTIN_SYSOID. */
    protected static final String AUSTIN_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.57";

    /** The Constant AUSTIN_LLDP_CHASSISID. */
    protected static final String AUSTIN_LLDP_CHASSISID = "80711fc413c0";

    /** The Constant AUSTIN_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> AUSTIN_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant AUSTIN_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> AUSTIN_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant AUSTIN_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> AUSTIN_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant AUSTIN_IF_MAC_MAP. */
    protected static final Map<Integer, String> AUSTIN_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant AUSTIN_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> AUSTIN_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant AUSTIN_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> AUSTIN_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    /** The Constant SANJOSE_IP. */
    protected static final String SANJOSE_IP = "10.155.69.12";

    /** The Constant SANJOSE_NAME. */
    protected static final String SANJOSE_NAME = "sanjose-mx240";

    /** The Constant SANJOSE_SYSOID. */
    protected static final String SANJOSE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.29";

    /** The Constant SANJOSE_LLDP_CHASSISID. */
    protected static final String SANJOSE_LLDP_CHASSISID = "002283d857c0";

    /** The Constant SANJOSE_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> SANJOSE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant SANJOSE_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> SANJOSE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant SANJOSE_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> SANJOSE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant SANJOSE_IF_MAC_MAP. */
    protected static final Map<Integer, String> SANJOSE_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant SANJOSE_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> SANJOSE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant SANJOSE_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> SANJOSE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    /** The Constant RIOVISTA_IP. */
    protected static final String RIOVISTA_IP = "10.155.69.107";

    /** The Constant RIOVISTA_NAME. */
    protected static final String RIOVISTA_NAME = "Riovista-ce";

    /** The Constant RIOVISTA_SYSOID. */
    protected static final String RIOVISTA_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.10";

    /** The Constant RIOVISTA_LLDP_CHASSISID. */
    protected static final String RIOVISTA_LLDP_CHASSISID = "001f12373dc0";

    /** The Constant RIOVISTA_IP_IF_MAP. */
    protected static final Map<InetAddress, Integer> RIOVISTA_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    /** The Constant RIOVISTA_IF_IFNAME_MAP. */
    protected static final Map<Integer, String> RIOVISTA_IF_IFNAME_MAP = new HashMap<Integer, String>();

    /** The Constant RIOVISTA_IF_IFDESCR_MAP. */
    protected static final Map<Integer, String> RIOVISTA_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    /** The Constant RIOVISTA_IF_MAC_MAP. */
    protected static final Map<Integer, String> RIOVISTA_IF_MAC_MAP = new HashMap<Integer, String>();

    /** The Constant RIOVISTA_IF_IFALIAS_MAP. */
    protected static final Map<Integer, String> RIOVISTA_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    /** The Constant RIOVISTA_IF_NETMASK_MAP. */
    protected static final Map<Integer, InetAddress> RIOVISTA_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    static {
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("20.1.1.2"), 644);
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.16"), 13);
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        PENROSE_IP_IF_MAP.put(InetAddressUtils.addr("10.1.0.1"), 535);
        PENROSE_IF_IFNAME_MAP.put(1, "fxp0");
        PENROSE_IF_IFDESCR_MAP.put(1, "fxp0");
        PENROSE_IF_MAC_MAP.put(1, "00a0a564f50c");
        PENROSE_IF_IFNAME_MAP.put(535, "xe-1/0/0.0");
        PENROSE_IF_IFDESCR_MAP.put(535, "xe-1/0/0.0");
        PENROSE_IF_MAC_MAP.put(535, "80711f8fa94a");
        PENROSE_IF_NETMASK_MAP.put(535, InetAddressUtils.addr("255.255.255.252"));
        PENROSE_IF_IFNAME_MAP.put(515, "ge-1/2/1");
        PENROSE_IF_IFDESCR_MAP.put(515, "ge-1/2/1");
        PENROSE_IF_MAC_MAP.put(515, "80711f8fa9ef");
        PENROSE_IF_IFNAME_MAP.put(5, "dsc");
        PENROSE_IF_IFDESCR_MAP.put(5, "dsc");
        PENROSE_IF_IFNAME_MAP.put(518, "ge-1/2/4");
        PENROSE_IF_IFDESCR_MAP.put(518, "ge-1/2/4");
        PENROSE_IF_MAC_MAP.put(518, "80711f8fa9f2");
        PENROSE_IF_IFNAME_MAP.put(536, "ge-1/3/0.0");
        PENROSE_IF_IFDESCR_MAP.put(536, "ge-1/3/0.0");
        PENROSE_IF_MAC_MAP.put(536, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(521, "ge-1/2/7");
        PENROSE_IF_IFDESCR_MAP.put(521, "ge-1/2/7");
        PENROSE_IF_MAC_MAP.put(521, "80711f8fa9f5");
        PENROSE_IF_IFNAME_MAP.put(504, "pp0");
        PENROSE_IF_IFDESCR_MAP.put(504, "pp0");
        PENROSE_IF_IFNAME_MAP.put(2693, "ae0");
        PENROSE_IF_IFDESCR_MAP.put(2693, "ae0");
        PENROSE_IF_MAC_MAP.put(2693, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(643, "pfe-1/2/0.16383");
        PENROSE_IF_IFDESCR_MAP.put(643, "pfe-1/2/0.16383");
        PENROSE_IF_IFNAME_MAP.put(4, "lsi");
        PENROSE_IF_IFDESCR_MAP.put(4, "lsi");
        PENROSE_IF_IFNAME_MAP.put(6, "lo0");
        PENROSE_IF_IFDESCR_MAP.put(6, "lo0");
        PENROSE_IF_IFNAME_MAP.put(528, "ge-1/3/4");
        PENROSE_IF_IFDESCR_MAP.put(528, "ge-1/3/4");
        PENROSE_IF_MAC_MAP.put(528, "80711f8faa44");
        PENROSE_IF_IFNAME_MAP.put(511, "xe-1/0/1");
        PENROSE_IF_IFDESCR_MAP.put(511, "xe-1/0/1");
        PENROSE_IF_MAC_MAP.put(511, "80711f8fa94b");
        PENROSE_IF_IFNAME_MAP.put(507, "lc-1/0/0.32769");
        PENROSE_IF_IFDESCR_MAP.put(507, "lc-1/0/0.32769");
        PENROSE_IF_IFNAME_MAP.put(513, "xe-1/1/1");
        PENROSE_IF_IFDESCR_MAP.put(513, "xe-1/1/1");
        PENROSE_IF_MAC_MAP.put(513, "80711f8fa99d");
        PENROSE_IF_IFNAME_MAP.put(525, "ge-1/3/1");
        PENROSE_IF_IFDESCR_MAP.put(525, "ge-1/3/1");
        PENROSE_IF_MAC_MAP.put(525, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(11, "pimd");
        PENROSE_IF_IFDESCR_MAP.put(11, "pimd");
        PENROSE_IF_IFNAME_MAP.put(516, "ge-1/2/2");
        PENROSE_IF_IFDESCR_MAP.put(516, "ge-1/2/2");
        PENROSE_IF_MAC_MAP.put(516, "80711f8fa9f0");
        PENROSE_IF_IFNAME_MAP.put(527, "ge-1/3/3");
        PENROSE_IF_IFDESCR_MAP.put(527, "ge-1/3/3");
        PENROSE_IF_MAC_MAP.put(527, "80711f8faa43");
        PENROSE_IF_IFNAME_MAP.put(530, "ge-1/3/6");
        PENROSE_IF_IFDESCR_MAP.put(530, "ge-1/3/6");
        PENROSE_IF_MAC_MAP.put(530, "80711f8faa46");
        PENROSE_IF_IFNAME_MAP.put(524, "ge-1/3/0");
        PENROSE_IF_IFDESCR_MAP.put(524, "ge-1/3/0");
        PENROSE_IF_MAC_MAP.put(524, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(13, "fxp0.0");
        PENROSE_IF_IFDESCR_MAP.put(13, "fxp0.0");
        PENROSE_IF_MAC_MAP.put(13, "00a0a564f50c");
        PENROSE_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.224.0"));
        PENROSE_IF_IFNAME_MAP.put(531, "ge-1/3/7");
        PENROSE_IF_IFDESCR_MAP.put(531, "ge-1/3/7");
        PENROSE_IF_MAC_MAP.put(531, "80711f8faa47");
        PENROSE_IF_IFNAME_MAP.put(520, "ge-1/2/6");
        PENROSE_IF_IFDESCR_MAP.put(520, "ge-1/2/6");
        PENROSE_IF_MAC_MAP.put(520, "80711f8fa9f4");
        PENROSE_IF_IFNAME_MAP.put(12, "mtun");
        PENROSE_IF_IFDESCR_MAP.put(12, "mtun");
        PENROSE_IF_IFNAME_MAP.put(509, "lc-1/2/0.32769");
        PENROSE_IF_IFDESCR_MAP.put(509, "lc-1/2/0.32769");
        PENROSE_IF_IFNAME_MAP.put(17, "em0");
        PENROSE_IF_IFDESCR_MAP.put(17, "em0");
        PENROSE_IF_MAC_MAP.put(17, "020000000004");
        PENROSE_IF_IFNAME_MAP.put(506, "lc-1/0/0");
        PENROSE_IF_IFDESCR_MAP.put(506, "lc-1/0/0");
        PENROSE_IF_IFNAME_MAP.put(503, "pip0");
        PENROSE_IF_IFDESCR_MAP.put(503, "pip0");
        PENROSE_IF_MAC_MAP.put(503, "80711f8fafb0");
        PENROSE_IF_IFNAME_MAP.put(644, "xe-1/0/1.0");
        PENROSE_IF_IFDESCR_MAP.put(644, "xe-1/0/1.0");
        PENROSE_IF_MAC_MAP.put(644, "80711f8fa94b");
        PENROSE_IF_NETMASK_MAP.put(644, InetAddressUtils.addr("255.255.255.252"));
        PENROSE_IF_IFNAME_MAP.put(501, "demux0");
        PENROSE_IF_IFDESCR_MAP.put(501, "demux0");
        PENROSE_IF_IFNAME_MAP.put(22, "lo0.16385");
        PENROSE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        PENROSE_IF_IFNAME_MAP.put(641, "pfe-1/0/0.16383");
        PENROSE_IF_IFDESCR_MAP.put(641, "pfe-1/0/0.16383");
        PENROSE_IF_IFNAME_MAP.put(510, "xe-1/0/0");
        PENROSE_IF_IFDESCR_MAP.put(510, "xe-1/0/0");
        PENROSE_IF_MAC_MAP.put(510, "80711f8fa94a");
        PENROSE_IF_IFALIAS_MAP.put(510, "<To_Delaware>");
        PENROSE_IF_IFNAME_MAP.put(21, "lo0.16384");
        PENROSE_IF_IFDESCR_MAP.put(21, "lo0.16384");
        PENROSE_IF_IFNAME_MAP.put(10, "pime");
        PENROSE_IF_IFDESCR_MAP.put(10, "pime");
        PENROSE_IF_IFNAME_MAP.put(7, "tap");
        PENROSE_IF_IFDESCR_MAP.put(7, "tap");
        PENROSE_IF_IFNAME_MAP.put(526, "ge-1/3/2");
        PENROSE_IF_IFDESCR_MAP.put(526, "ge-1/3/2");
        PENROSE_IF_MAC_MAP.put(526, "80711f8faa42");
        PENROSE_IF_IFNAME_MAP.put(2694, "ae1");
        PENROSE_IF_IFDESCR_MAP.put(2694, "ae1");
        PENROSE_IF_MAC_MAP.put(2694, "80711f8fafc1");
        PENROSE_IF_IFNAME_MAP.put(508, "lc-1/2/0");
        PENROSE_IF_IFDESCR_MAP.put(508, "lc-1/2/0");
        PENROSE_IF_IFNAME_MAP.put(638, "pfh-1/0/0");
        PENROSE_IF_IFDESCR_MAP.put(638, "pfh-1/0/0");
        PENROSE_IF_IFNAME_MAP.put(640, "pfe-1/2/0");
        PENROSE_IF_IFDESCR_MAP.put(640, "pfe-1/2/0");
        PENROSE_IF_IFNAME_MAP.put(522, "ge-1/2/8");
        PENROSE_IF_IFDESCR_MAP.put(522, "ge-1/2/8");
        PENROSE_IF_MAC_MAP.put(522, "80711f8fa9f6");
        PENROSE_IF_IFNAME_MAP.put(519, "ge-1/2/5");
        PENROSE_IF_IFDESCR_MAP.put(519, "ge-1/2/5");
        PENROSE_IF_MAC_MAP.put(519, "80711f8fa9f3");
        PENROSE_IF_IFNAME_MAP.put(642, "pfh-1/0/0.16383");
        PENROSE_IF_IFDESCR_MAP.put(642, "pfh-1/0/0.16383");
        PENROSE_IF_IFNAME_MAP.put(514, "ge-1/2/0");
        PENROSE_IF_IFDESCR_MAP.put(514, "ge-1/2/0");
        PENROSE_IF_MAC_MAP.put(514, "80711f8fa9ee");
        PENROSE_IF_IFNAME_MAP.put(517, "ge-1/2/3");
        PENROSE_IF_IFDESCR_MAP.put(517, "ge-1/2/3");
        PENROSE_IF_MAC_MAP.put(517, "80711f8fa9f1");
        PENROSE_IF_IFNAME_MAP.put(8, "gre");
        PENROSE_IF_IFDESCR_MAP.put(8, "gre");
        PENROSE_IF_IFNAME_MAP.put(533, "ge-1/3/9");
        PENROSE_IF_IFDESCR_MAP.put(533, "ge-1/3/9");
        PENROSE_IF_MAC_MAP.put(533, "80711f8faa49");
        PENROSE_IF_IFNAME_MAP.put(639, "pfe-1/0/0");
        PENROSE_IF_IFDESCR_MAP.put(639, "pfe-1/0/0");
        PENROSE_IF_IFNAME_MAP.put(1138, "ae0.0");
        PENROSE_IF_IFDESCR_MAP.put(1138, "ae0.0");
        PENROSE_IF_MAC_MAP.put(1138, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(1139, "ge-1/3/1.0");
        PENROSE_IF_IFDESCR_MAP.put(1139, "ge-1/3/1.0");
        PENROSE_IF_MAC_MAP.put(1139, "80711f8fafc0");
        PENROSE_IF_IFNAME_MAP.put(23, "em1");
        PENROSE_IF_IFDESCR_MAP.put(23, "em1");
        PENROSE_IF_MAC_MAP.put(23, "020001000004");
        PENROSE_IF_IFNAME_MAP.put(18, "em0.0");
        PENROSE_IF_IFDESCR_MAP.put(18, "em0.0");
        PENROSE_IF_MAC_MAP.put(18, "020000000004");
        PENROSE_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        PENROSE_IF_IFNAME_MAP.put(505, "irb");
        PENROSE_IF_IFDESCR_MAP.put(505, "irb");
        PENROSE_IF_MAC_MAP.put(505, "80711f8faff0");
        PENROSE_IF_IFNAME_MAP.put(532, "ge-1/3/8");
        PENROSE_IF_IFDESCR_MAP.put(532, "ge-1/3/8");
        PENROSE_IF_MAC_MAP.put(532, "80711f8faa48");
        PENROSE_IF_IFNAME_MAP.put(529, "ge-1/3/5");
        PENROSE_IF_IFDESCR_MAP.put(529, "ge-1/3/5");
        PENROSE_IF_MAC_MAP.put(529, "80711f8faa45");
        PENROSE_IF_IFNAME_MAP.put(502, "cbp0");
        PENROSE_IF_IFDESCR_MAP.put(502, "cbp0");
        PENROSE_IF_MAC_MAP.put(502, "80711f8fa811");
        PENROSE_IF_IFNAME_MAP.put(24, "em1.0");
        PENROSE_IF_IFDESCR_MAP.put(24, "em1.0");
        PENROSE_IF_MAC_MAP.put(24, "020001000004");
        PENROSE_IF_IFNAME_MAP.put(523, "ge-1/2/9");
        PENROSE_IF_IFDESCR_MAP.put(523, "ge-1/2/9");
        PENROSE_IF_MAC_MAP.put(523, "80711f8fa9f7");
        PENROSE_IF_IFNAME_MAP.put(512, "xe-1/1/0");
        PENROSE_IF_IFDESCR_MAP.put(512, "xe-1/1/0");
        PENROSE_IF_MAC_MAP.put(512, "80711f8fa99c");
        PENROSE_IF_IFNAME_MAP.put(9, "ipip");
        PENROSE_IF_IFDESCR_MAP.put(9, "ipip");
        PENROSE_IF_IFNAME_MAP.put(670, "ge-1/2/1.0");
        PENROSE_IF_IFDESCR_MAP.put(670, "ge-1/2/1.0");
        PENROSE_IF_MAC_MAP.put(670, "80711f8fa9ef");
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.120"), 630);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("20.1.1.6"), 599);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.113"), 623);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.122"), 632);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.124"), 633);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.1"), 18);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.106"), 615);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.111"), 621);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.109"), 618);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.123"), 641);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.110"), 619);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.121"), 631);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.0.2"), 16);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.105"), 614);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.125"), 634);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.114"), 624);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.112"), 622);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.117"), 627);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.104"), 613);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.108"), 617);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.103"), 612);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.17"), 13);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.100"), 610);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.116"), 626);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.119"), 629);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.118"), 628);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.107"), 616);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("10.1.0.2"), 598);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.115"), 625);
        DELAWARE_IP_IF_MAP.put(InetAddressUtils.addr("1.1.1.101"), 611);
        DELAWARE_IF_IFNAME_MAP.put(534, "ge-0/1/6");
        DELAWARE_IF_IFDESCR_MAP.put(534, "ge-0/1/6");
        DELAWARE_IF_MAC_MAP.put(534, "002283095058");
        DELAWARE_IF_IFNAME_MAP.put(591, "ge-1/3/3");
        DELAWARE_IF_IFDESCR_MAP.put(591, "ge-1/3/3");
        DELAWARE_IF_MAC_MAP.put(591, "002283095243");
        DELAWARE_IF_IFNAME_MAP.put(610, "ge-1/3/9.1");
        DELAWARE_IF_IFDESCR_MAP.put(610, "ge-1/3/9.1");
        DELAWARE_IF_MAC_MAP.put(610, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(610, "test unit1");
        DELAWARE_IF_NETMASK_MAP.put(610, InetAddressUtils.addr("255.255.255.0"));
        DELAWARE_IF_IFNAME_MAP.put(540, "ge-0/2/0");
        DELAWARE_IF_IFDESCR_MAP.put(540, "ge-0/2/0");
        DELAWARE_IF_MAC_MAP.put(540, "0022830950a4");
        DELAWARE_IF_IFNAME_MAP.put(548, "ge-0/2/8");
        DELAWARE_IF_IFDESCR_MAP.put(548, "ge-0/2/8");
        DELAWARE_IF_MAC_MAP.put(548, "0022830950ac");
        DELAWARE_IF_IFNAME_MAP.put(625, "ge-1/3/9.15");
        DELAWARE_IF_IFDESCR_MAP.put(625, "ge-1/3/9.15");
        DELAWARE_IF_MAC_MAP.put(625, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(625, "test unit15");
        DELAWARE_IF_NETMASK_MAP.put(625, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(23, "em1");
        DELAWARE_IF_IFDESCR_MAP.put(23, "em1");
        DELAWARE_IF_MAC_MAP.put(23, "020001000004");
        DELAWARE_IF_IFNAME_MAP.put(562, "lc-0/3/0");
        DELAWARE_IF_IFDESCR_MAP.put(562, "lc-0/3/0");
        DELAWARE_IF_IFNAME_MAP.put(594, "ge-1/3/6");
        DELAWARE_IF_IFDESCR_MAP.put(594, "ge-1/3/6");
        DELAWARE_IF_MAC_MAP.put(594, "002283095246");
        DELAWARE_IF_IFNAME_MAP.put(584, "ge-1/2/6");
        DELAWARE_IF_IFDESCR_MAP.put(584, "ge-1/2/6");
        DELAWARE_IF_MAC_MAP.put(584, "0022830951f4");
        DELAWARE_IF_IFNAME_MAP.put(567, "lc-1/2/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(567, "lc-1/2/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(1, "fxp0");
        DELAWARE_IF_IFDESCR_MAP.put(1, "fxp0");
        DELAWARE_IF_MAC_MAP.put(1, "00a0a5678e60");
        DELAWARE_IF_IFNAME_MAP.put(8, "gre");
        DELAWARE_IF_IFDESCR_MAP.put(8, "gre");
        DELAWARE_IF_IFNAME_MAP.put(624, "ge-1/3/9.14");
        DELAWARE_IF_IFDESCR_MAP.put(624, "ge-1/3/9.14");
        DELAWARE_IF_MAC_MAP.put(624, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(624, "test unit14");
        DELAWARE_IF_NETMASK_MAP.put(624, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(517, "ge-0/0/1");
        DELAWARE_IF_IFDESCR_MAP.put(517, "ge-0/0/1");
        DELAWARE_IF_MAC_MAP.put(517, "002283095001");
        DELAWARE_IF_IFALIAS_MAP.put(517, "test");
        DELAWARE_IF_IFNAME_MAP.put(549, "ge-0/2/9");
        DELAWARE_IF_IFDESCR_MAP.put(549, "ge-0/2/9");
        DELAWARE_IF_MAC_MAP.put(549, "0022830950ad");
        DELAWARE_IF_IFNAME_MAP.put(24, "em1.0");
        DELAWARE_IF_IFDESCR_MAP.put(24, "em1.0");
        DELAWARE_IF_MAC_MAP.put(24, "020001000004");
        DELAWARE_IF_IFNAME_MAP.put(505, "irb");
        DELAWARE_IF_IFDESCR_MAP.put(505, "irb");
        DELAWARE_IF_MAC_MAP.put(505, "0022830957f0");
        DELAWARE_IF_IFNAME_MAP.put(560, "ge-0/3/8");
        DELAWARE_IF_IFDESCR_MAP.put(560, "ge-0/3/8");
        DELAWARE_IF_MAC_MAP.put(560, "0022830950fe");
        DELAWARE_IF_IFNAME_MAP.put(611, "ge-1/3/9.2");
        DELAWARE_IF_IFDESCR_MAP.put(611, "ge-1/3/9.2");
        DELAWARE_IF_MAC_MAP.put(611, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(611, "test unit2");
        DELAWARE_IF_NETMASK_MAP.put(611, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(619, "ge-1/3/9.10");
        DELAWARE_IF_IFDESCR_MAP.put(619, "ge-1/3/9.10");
        DELAWARE_IF_MAC_MAP.put(619, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(619, "test unit10");
        DELAWARE_IF_NETMASK_MAP.put(619, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(503, "pip0");
        DELAWARE_IF_IFDESCR_MAP.put(503, "pip0");
        DELAWARE_IF_MAC_MAP.put(503, "0022830957b0");
        DELAWARE_IF_IFNAME_MAP.put(663, "ge-0/2/0.0");
        DELAWARE_IF_IFDESCR_MAP.put(663, "ge-0/2/0.0");
        DELAWARE_IF_MAC_MAP.put(663, "0022830950a4");
        DELAWARE_IF_IFNAME_MAP.put(579, "ge-1/2/1");
        DELAWARE_IF_IFDESCR_MAP.put(579, "ge-1/2/1");
        DELAWARE_IF_MAC_MAP.put(579, "0022830951ef");
        DELAWARE_IF_IFNAME_MAP.put(541, "ge-0/2/1");
        DELAWARE_IF_IFDESCR_MAP.put(541, "ge-0/2/1");
        DELAWARE_IF_MAC_MAP.put(541, "0022830950a5");
        DELAWARE_IF_IFNAME_MAP.put(18, "em0.0");
        DELAWARE_IF_IFDESCR_MAP.put(18, "em0.0");
        DELAWARE_IF_MAC_MAP.put(18, "020000000004");
        DELAWARE_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        DELAWARE_IF_IFNAME_MAP.put(561, "ge-0/3/9");
        DELAWARE_IF_IFDESCR_MAP.put(561, "ge-0/3/9");
        DELAWARE_IF_MAC_MAP.put(561, "0022830950ff");
        DELAWARE_IF_IFNAME_MAP.put(539, "lc-0/1/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(539, "lc-0/1/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(536, "ge-0/1/8");
        DELAWARE_IF_IFDESCR_MAP.put(536, "ge-0/1/8");
        DELAWARE_IF_MAC_MAP.put(536, "00228309505a");
        DELAWARE_IF_IFNAME_MAP.put(592, "ge-1/3/4");
        DELAWARE_IF_IFDESCR_MAP.put(592, "ge-1/3/4");
        DELAWARE_IF_MAC_MAP.put(592, "002283095244");
        DELAWARE_IF_IFNAME_MAP.put(527, "lc-0/0/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(527, "lc-0/0/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(530, "ge-0/1/2");
        DELAWARE_IF_IFDESCR_MAP.put(530, "ge-0/1/2");
        DELAWARE_IF_MAC_MAP.put(530, "002283095054");
        DELAWARE_IF_IFNAME_MAP.put(595, "ge-1/3/7");
        DELAWARE_IF_IFDESCR_MAP.put(595, "ge-1/3/7");
        DELAWARE_IF_MAC_MAP.put(595, "002283095247");
        DELAWARE_IF_IFNAME_MAP.put(639, "ge-0/0/2.1");
        DELAWARE_IF_IFDESCR_MAP.put(639, "ge-0/0/2.1");
        DELAWARE_IF_MAC_MAP.put(639, "002283095002");
        DELAWARE_IF_IFNAME_MAP.put(551, "lc-0/2/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(551, "lc-0/2/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(545, "ge-0/2/5");
        DELAWARE_IF_IFDESCR_MAP.put(545, "ge-0/2/5");
        DELAWARE_IF_MAC_MAP.put(545, "0022830950a9");
        DELAWARE_IF_IFNAME_MAP.put(528, "ge-0/1/0");
        DELAWARE_IF_IFDESCR_MAP.put(528, "ge-0/1/0");
        DELAWARE_IF_MAC_MAP.put(528, "002283095052");
        DELAWARE_IF_IFNAME_MAP.put(586, "ge-1/2/8");
        DELAWARE_IF_IFDESCR_MAP.put(586, "ge-1/2/8");
        DELAWARE_IF_MAC_MAP.put(586, "0022830951f6");
        DELAWARE_IF_IFNAME_MAP.put(589, "ge-1/3/1");
        DELAWARE_IF_IFDESCR_MAP.put(589, "ge-1/3/1");
        DELAWARE_IF_MAC_MAP.put(589, "002283095241");
        DELAWARE_IF_IFNAME_MAP.put(629, "ge-1/3/9.19");
        DELAWARE_IF_IFDESCR_MAP.put(629, "ge-1/3/9.19");
        DELAWARE_IF_MAC_MAP.put(629, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(629, "test unit19");
        DELAWARE_IF_NETMASK_MAP.put(629, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(621, "ge-1/3/9.11");
        DELAWARE_IF_IFDESCR_MAP.put(621, "ge-1/3/9.11");
        DELAWARE_IF_MAC_MAP.put(621, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(621, "test unit11");
        DELAWARE_IF_NETMASK_MAP.put(621, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(543, "ge-0/2/3");
        DELAWARE_IF_IFDESCR_MAP.put(543, "ge-0/2/3");
        DELAWARE_IF_MAC_MAP.put(543, "0022830950a7");
        DELAWARE_IF_IFNAME_MAP.put(615, "ge-1/3/9.6");
        DELAWARE_IF_IFDESCR_MAP.put(615, "ge-1/3/9.6");
        DELAWARE_IF_MAC_MAP.put(615, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(615, "test unit6");
        DELAWARE_IF_NETMASK_MAP.put(615, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(526, "lc-0/0/0");
        DELAWARE_IF_IFDESCR_MAP.put(526, "lc-0/0/0");
        DELAWARE_IF_IFNAME_MAP.put(13, "fxp0.0");
        DELAWARE_IF_IFDESCR_MAP.put(13, "fxp0.0");
        DELAWARE_IF_MAC_MAP.put(13, "00a0a5678e60");
        DELAWARE_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.224.0"));
        DELAWARE_IF_IFNAME_MAP.put(662, "ge-0/0/6.0");
        DELAWARE_IF_IFDESCR_MAP.put(662, "ge-0/0/6.0");
        DELAWARE_IF_MAC_MAP.put(662, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(582, "ge-1/2/4");
        DELAWARE_IF_IFDESCR_MAP.put(582, "ge-1/2/4");
        DELAWARE_IF_MAC_MAP.put(582, "0022830951f2");
        DELAWARE_IF_IFNAME_MAP.put(531, "ge-0/1/3");
        DELAWARE_IF_IFDESCR_MAP.put(531, "ge-0/1/3");
        DELAWARE_IF_MAC_MAP.put(531, "002283095055");
        DELAWARE_IF_IFNAME_MAP.put(630, "ge-1/3/9.20");
        DELAWARE_IF_IFDESCR_MAP.put(630, "ge-1/3/9.20");
        DELAWARE_IF_MAC_MAP.put(630, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(630, "test unit20");
        DELAWARE_IF_NETMASK_MAP.put(630, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(553, "ge-0/3/1");
        DELAWARE_IF_IFDESCR_MAP.put(553, "ge-0/3/1");
        DELAWARE_IF_MAC_MAP.put(553, "0022830950f7");
        DELAWARE_IF_IFNAME_MAP.put(577, "xe-1/1/1");
        DELAWARE_IF_IFDESCR_MAP.put(577, "xe-1/1/1");
        DELAWARE_IF_MAC_MAP.put(577, "00228309519d");
        DELAWARE_IF_IFNAME_MAP.put(620, "ge-1/3/9.32767");
        DELAWARE_IF_IFDESCR_MAP.put(620, "ge-1/3/9.32767");
        DELAWARE_IF_MAC_MAP.put(620, "002283095249");
        DELAWARE_IF_IFNAME_MAP.put(631, "ge-1/3/9.21");
        DELAWARE_IF_IFDESCR_MAP.put(631, "ge-1/3/9.21");
        DELAWARE_IF_MAC_MAP.put(631, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(631, "test unit21");
        DELAWARE_IF_NETMASK_MAP.put(631, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(566, "lc-1/2/0");
        DELAWARE_IF_IFDESCR_MAP.put(566, "lc-1/2/0");
        DELAWARE_IF_IFNAME_MAP.put(565, "lc-1/0/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(565, "lc-1/0/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(628, "ge-1/3/9.18");
        DELAWARE_IF_IFDESCR_MAP.put(628, "ge-1/3/9.18");
        DELAWARE_IF_MAC_MAP.put(628, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(628, "test unit18");
        DELAWARE_IF_NETMASK_MAP.put(628, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(502, "cbp0");
        DELAWARE_IF_IFDESCR_MAP.put(502, "cbp0");
        DELAWARE_IF_MAC_MAP.put(502, "002283095011");
        DELAWARE_IF_IFNAME_MAP.put(661, "ge-0/0/5.0");
        DELAWARE_IF_IFDESCR_MAP.put(661, "ge-0/0/5.0");
        DELAWARE_IF_MAC_MAP.put(661, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(547, "ge-0/2/7");
        DELAWARE_IF_IFDESCR_MAP.put(547, "ge-0/2/7");
        DELAWARE_IF_MAC_MAP.put(547, "0022830950ab");
        DELAWARE_IF_IFNAME_MAP.put(587, "ge-1/2/9");
        DELAWARE_IF_IFDESCR_MAP.put(587, "ge-1/2/9");
        DELAWARE_IF_MAC_MAP.put(587, "0022830951f7");
        DELAWARE_IF_IFNAME_MAP.put(533, "ge-0/1/5");
        DELAWARE_IF_IFDESCR_MAP.put(533, "ge-0/1/5");
        DELAWARE_IF_MAC_MAP.put(533, "002283095057");
        DELAWARE_IF_IFNAME_MAP.put(617, "ge-1/3/9.8");
        DELAWARE_IF_IFDESCR_MAP.put(617, "ge-1/3/9.8");
        DELAWARE_IF_MAC_MAP.put(617, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(617, "test unit8");
        DELAWARE_IF_NETMASK_MAP.put(617, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(519, "ge-0/0/3");
        DELAWARE_IF_IFDESCR_MAP.put(519, "ge-0/0/3");
        DELAWARE_IF_MAC_MAP.put(519, "002283095003");
        DELAWARE_IF_IFNAME_MAP.put(593, "ge-1/3/5");
        DELAWARE_IF_IFDESCR_MAP.put(593, "ge-1/3/5");
        DELAWARE_IF_MAC_MAP.put(593, "002283095245");
        DELAWARE_IF_IFNAME_MAP.put(583, "ge-1/2/5");
        DELAWARE_IF_IFDESCR_MAP.put(583, "ge-1/2/5");
        DELAWARE_IF_MAC_MAP.put(583, "0022830951f3");
        DELAWARE_IF_IFNAME_MAP.put(622, "ge-1/3/9.12");
        DELAWARE_IF_IFDESCR_MAP.put(622, "ge-1/3/9.12");
        DELAWARE_IF_MAC_MAP.put(622, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(622, "test unit12");
        DELAWARE_IF_NETMASK_MAP.put(622, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(580, "ge-1/2/2");
        DELAWARE_IF_IFDESCR_MAP.put(580, "ge-1/2/2");
        DELAWARE_IF_MAC_MAP.put(580, "0022830951f0");
        DELAWARE_IF_IFNAME_MAP.put(659, "ae1");
        DELAWARE_IF_IFDESCR_MAP.put(659, "ae1");
        DELAWARE_IF_MAC_MAP.put(659, "0022830957c1");
        DELAWARE_IF_IFNAME_MAP.put(626, "ge-1/3/9.16");
        DELAWARE_IF_IFDESCR_MAP.put(626, "ge-1/3/9.16");
        DELAWARE_IF_MAC_MAP.put(626, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(626, "test unit16");
        DELAWARE_IF_NETMASK_MAP.put(626, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(523, "ge-0/0/7");
        DELAWARE_IF_IFDESCR_MAP.put(523, "ge-0/0/7");
        DELAWARE_IF_MAC_MAP.put(523, "002283095007");
        DELAWARE_IF_IFNAME_MAP.put(612, "ge-1/3/9.3");
        DELAWARE_IF_IFDESCR_MAP.put(612, "ge-1/3/9.3");
        DELAWARE_IF_MAC_MAP.put(612, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(612, "test unit3");
        DELAWARE_IF_NETMASK_MAP.put(612, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(616, "ge-1/3/9.7");
        DELAWARE_IF_IFDESCR_MAP.put(616, "ge-1/3/9.7");
        DELAWARE_IF_MAC_MAP.put(616, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(616, "test unit7");
        DELAWARE_IF_NETMASK_MAP.put(616, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(550, "lc-0/2/0");
        DELAWARE_IF_IFDESCR_MAP.put(550, "lc-0/2/0");
        DELAWARE_IF_IFNAME_MAP.put(537, "ge-0/1/9");
        DELAWARE_IF_IFDESCR_MAP.put(537, "ge-0/1/9");
        DELAWARE_IF_MAC_MAP.put(537, "00228309505b");
        DELAWARE_IF_IFNAME_MAP.put(11, "pimd");
        DELAWARE_IF_IFDESCR_MAP.put(11, "pimd");
        DELAWARE_IF_IFNAME_MAP.put(4, "lsi");
        DELAWARE_IF_IFDESCR_MAP.put(4, "lsi");
        DELAWARE_IF_IFNAME_MAP.put(632, "ge-1/3/9.22");
        DELAWARE_IF_IFDESCR_MAP.put(632, "ge-1/3/9.22");
        DELAWARE_IF_MAC_MAP.put(632, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(632, "test unit22");
        DELAWARE_IF_NETMASK_MAP.put(632, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(641, "ge-1/3/9.23");
        DELAWARE_IF_IFDESCR_MAP.put(641, "ge-1/3/9.23");
        DELAWARE_IF_MAC_MAP.put(641, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(641, "test unit23");
        DELAWARE_IF_NETMASK_MAP.put(641, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(557, "ge-0/3/5");
        DELAWARE_IF_IFDESCR_MAP.put(557, "ge-0/3/5");
        DELAWARE_IF_MAC_MAP.put(557, "0022830950fb");
        DELAWARE_IF_IFNAME_MAP.put(525, "ge-0/0/9");
        DELAWARE_IF_IFDESCR_MAP.put(525, "ge-0/0/9");
        DELAWARE_IF_MAC_MAP.put(525, "002283095009");
        DELAWARE_IF_IFNAME_MAP.put(555, "ge-0/3/3");
        DELAWARE_IF_IFDESCR_MAP.put(555, "ge-0/3/3");
        DELAWARE_IF_MAC_MAP.put(555, "0022830950f9");
        DELAWARE_IF_IFNAME_MAP.put(576, "xe-1/1/0");
        DELAWARE_IF_IFDESCR_MAP.put(576, "xe-1/1/0");
        DELAWARE_IF_MAC_MAP.put(576, "00228309519c");
        DELAWARE_IF_IFNAME_MAP.put(599, "xe-1/0/1.0");
        DELAWARE_IF_IFDESCR_MAP.put(599, "xe-1/0/1.0");
        DELAWARE_IF_MAC_MAP.put(599, "00228309514b");
        DELAWARE_IF_NETMASK_MAP.put(599, InetAddressUtils.addr("255.255.255.252"));
        DELAWARE_IF_IFNAME_MAP.put(535, "ge-0/1/7");
        DELAWARE_IF_IFDESCR_MAP.put(535, "ge-0/1/7");
        DELAWARE_IF_MAC_MAP.put(535, "002283095059");
        DELAWARE_IF_IFNAME_MAP.put(598, "xe-1/0/0.0");
        DELAWARE_IF_IFDESCR_MAP.put(598, "xe-1/0/0.0");
        DELAWARE_IF_MAC_MAP.put(598, "00228309514a");
        DELAWARE_IF_NETMASK_MAP.put(598, InetAddressUtils.addr("255.255.255.252"));
        DELAWARE_IF_IFNAME_MAP.put(556, "ge-0/3/4");
        DELAWARE_IF_IFDESCR_MAP.put(556, "ge-0/3/4");
        DELAWARE_IF_MAC_MAP.put(556, "0022830950fa");
        DELAWARE_IF_IFNAME_MAP.put(638, "ge-0/0/1.0");
        DELAWARE_IF_IFDESCR_MAP.put(638, "ge-0/0/1.0");
        DELAWARE_IF_MAC_MAP.put(638, "002283095001");
        DELAWARE_IF_IFNAME_MAP.put(516, "ge-0/0/0");
        DELAWARE_IF_IFDESCR_MAP.put(516, "ge-0/0/0");
        DELAWARE_IF_MAC_MAP.put(516, "002283095000");
        DELAWARE_IF_IFNAME_MAP.put(538, "lc-0/1/0");
        DELAWARE_IF_IFDESCR_MAP.put(538, "lc-0/1/0");
        DELAWARE_IF_IFNAME_MAP.put(590, "ge-1/3/2");
        DELAWARE_IF_IFDESCR_MAP.put(590, "ge-1/3/2");
        DELAWARE_IF_MAC_MAP.put(590, "002283095242");
        DELAWARE_IF_IFNAME_MAP.put(10, "pime");
        DELAWARE_IF_IFDESCR_MAP.put(10, "pime");
        DELAWARE_IF_IFNAME_MAP.put(660, "ae0.0");
        DELAWARE_IF_IFDESCR_MAP.put(660, "ae0.0");
        DELAWARE_IF_MAC_MAP.put(660, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(597, "ge-1/3/9");
        DELAWARE_IF_IFDESCR_MAP.put(597, "ge-1/3/9");
        DELAWARE_IF_MAC_MAP.put(597, "002283095249");
        DELAWARE_IF_IFNAME_MAP.put(552, "ge-0/3/0");
        DELAWARE_IF_IFDESCR_MAP.put(552, "ge-0/3/0");
        DELAWARE_IF_MAC_MAP.put(552, "0022830950f6");
        DELAWARE_IF_IFNAME_MAP.put(618, "ge-1/3/9.9");
        DELAWARE_IF_IFDESCR_MAP.put(618, "ge-1/3/9.9");
        DELAWARE_IF_MAC_MAP.put(618, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(618, "test unit9");
        DELAWARE_IF_NETMASK_MAP.put(618, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(558, "ge-0/3/6");
        DELAWARE_IF_IFDESCR_MAP.put(558, "ge-0/3/6");
        DELAWARE_IF_MAC_MAP.put(558, "0022830950fc");
        DELAWARE_IF_IFNAME_MAP.put(7, "tap");
        DELAWARE_IF_IFDESCR_MAP.put(7, "tap");
        DELAWARE_IF_IFNAME_MAP.put(6, "lo0");
        DELAWARE_IF_IFDESCR_MAP.put(6, "lo0");
        DELAWARE_IF_IFNAME_MAP.put(12, "mtun");
        DELAWARE_IF_IFDESCR_MAP.put(12, "mtun");
        DELAWARE_IF_IFNAME_MAP.put(658, "ae0");
        DELAWARE_IF_IFDESCR_MAP.put(658, "ae0");
        DELAWARE_IF_MAC_MAP.put(658, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(16, "lo0.0");
        DELAWARE_IF_IFDESCR_MAP.put(16, "lo0.0");
        DELAWARE_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(5, "dsc");
        DELAWARE_IF_IFDESCR_MAP.put(5, "dsc");
        DELAWARE_IF_IFNAME_MAP.put(554, "ge-0/3/2");
        DELAWARE_IF_IFDESCR_MAP.put(554, "ge-0/3/2");
        DELAWARE_IF_MAC_MAP.put(554, "0022830950f8");
        DELAWARE_IF_IFNAME_MAP.put(521, "ge-0/0/5");
        DELAWARE_IF_IFDESCR_MAP.put(521, "ge-0/0/5");
        DELAWARE_IF_MAC_MAP.put(521, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(9, "ipip");
        DELAWARE_IF_IFDESCR_MAP.put(9, "ipip");
        DELAWARE_IF_IFNAME_MAP.put(633, "ge-1/3/9.24");
        DELAWARE_IF_IFDESCR_MAP.put(633, "ge-1/3/9.24");
        DELAWARE_IF_MAC_MAP.put(633, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(633, "test unit24");
        DELAWARE_IF_NETMASK_MAP.put(633, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(588, "ge-1/3/0");
        DELAWARE_IF_IFDESCR_MAP.put(588, "ge-1/3/0");
        DELAWARE_IF_MAC_MAP.put(588, "002283095240");
        DELAWARE_IF_IFNAME_MAP.put(522, "ge-0/0/6");
        DELAWARE_IF_IFDESCR_MAP.put(522, "ge-0/0/6");
        DELAWARE_IF_MAC_MAP.put(522, "0022830957c0");
        DELAWARE_IF_IFNAME_MAP.put(542, "ge-0/2/2");
        DELAWARE_IF_IFDESCR_MAP.put(542, "ge-0/2/2");
        DELAWARE_IF_MAC_MAP.put(542, "0022830950a6");
        DELAWARE_IF_IFNAME_MAP.put(596, "ge-1/3/8");
        DELAWARE_IF_IFDESCR_MAP.put(596, "ge-1/3/8");
        DELAWARE_IF_MAC_MAP.put(596, "002283095248");
        DELAWARE_IF_IFNAME_MAP.put(578, "ge-1/2/0");
        DELAWARE_IF_IFDESCR_MAP.put(578, "ge-1/2/0");
        DELAWARE_IF_MAC_MAP.put(578, "0022830951ee");
        DELAWARE_IF_IFNAME_MAP.put(544, "ge-0/2/4");
        DELAWARE_IF_IFDESCR_MAP.put(544, "ge-0/2/4");
        DELAWARE_IF_MAC_MAP.put(544, "0022830950a8");
        DELAWARE_IF_IFNAME_MAP.put(524, "ge-0/0/8");
        DELAWARE_IF_IFDESCR_MAP.put(524, "ge-0/0/8");
        DELAWARE_IF_MAC_MAP.put(524, "002283095008");
        DELAWARE_IF_IFNAME_MAP.put(563, "lc-0/3/0.32769");
        DELAWARE_IF_IFDESCR_MAP.put(563, "lc-0/3/0.32769");
        DELAWARE_IF_IFNAME_MAP.put(574, "xe-1/0/0");
        DELAWARE_IF_IFDESCR_MAP.put(574, "xe-1/0/0");
        DELAWARE_IF_MAC_MAP.put(574, "00228309514a");
        DELAWARE_IF_IFALIAS_MAP.put(574, "<To_Penrose>");
        DELAWARE_IF_IFNAME_MAP.put(627, "ge-1/3/9.17");
        DELAWARE_IF_IFDESCR_MAP.put(627, "ge-1/3/9.17");
        DELAWARE_IF_MAC_MAP.put(627, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(627, "test unit17");
        DELAWARE_IF_NETMASK_MAP.put(627, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(585, "ge-1/2/7");
        DELAWARE_IF_IFDESCR_MAP.put(585, "ge-1/2/7");
        DELAWARE_IF_MAC_MAP.put(585, "0022830951f5");
        DELAWARE_IF_IFNAME_MAP.put(546, "ge-0/2/6");
        DELAWARE_IF_IFDESCR_MAP.put(546, "ge-0/2/6");
        DELAWARE_IF_MAC_MAP.put(546, "0022830950aa");
        DELAWARE_IF_IFNAME_MAP.put(504, "pp0");
        DELAWARE_IF_IFDESCR_MAP.put(504, "pp0");
        DELAWARE_IF_IFNAME_MAP.put(532, "ge-0/1/4");
        DELAWARE_IF_IFDESCR_MAP.put(532, "ge-0/1/4");
        DELAWARE_IF_MAC_MAP.put(532, "002283095056");
        DELAWARE_IF_IFNAME_MAP.put(581, "ge-1/2/3");
        DELAWARE_IF_IFDESCR_MAP.put(581, "ge-1/2/3");
        DELAWARE_IF_MAC_MAP.put(581, "0022830951f1");
        DELAWARE_IF_IFNAME_MAP.put(520, "ge-0/0/4");
        DELAWARE_IF_IFDESCR_MAP.put(520, "ge-0/0/4");
        DELAWARE_IF_MAC_MAP.put(520, "002283095004");
        DELAWARE_IF_IFNAME_MAP.put(501, "demux0");
        DELAWARE_IF_IFDESCR_MAP.put(501, "demux0");
        DELAWARE_IF_IFNAME_MAP.put(22, "lo0.16385");
        DELAWARE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        DELAWARE_IF_IFNAME_MAP.put(17, "em0");
        DELAWARE_IF_IFDESCR_MAP.put(17, "em0");
        DELAWARE_IF_MAC_MAP.put(17, "020000000004");
        DELAWARE_IF_IFNAME_MAP.put(634, "ge-1/3/9.25");
        DELAWARE_IF_IFDESCR_MAP.put(634, "ge-1/3/9.25");
        DELAWARE_IF_MAC_MAP.put(634, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(634, "test unit25");
        DELAWARE_IF_NETMASK_MAP.put(634, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(623, "ge-1/3/9.13");
        DELAWARE_IF_IFDESCR_MAP.put(623, "ge-1/3/9.13");
        DELAWARE_IF_MAC_MAP.put(623, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(623, "test unit13");
        DELAWARE_IF_NETMASK_MAP.put(623, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(575, "xe-1/0/1");
        DELAWARE_IF_IFDESCR_MAP.put(575, "xe-1/0/1");
        DELAWARE_IF_MAC_MAP.put(575, "00228309514b");
        DELAWARE_IF_IFNAME_MAP.put(564, "lc-1/0/0");
        DELAWARE_IF_IFDESCR_MAP.put(564, "lc-1/0/0");
        DELAWARE_IF_IFNAME_MAP.put(559, "ge-0/3/7");
        DELAWARE_IF_IFDESCR_MAP.put(559, "ge-0/3/7");
        DELAWARE_IF_MAC_MAP.put(559, "0022830950fd");
        DELAWARE_IF_IFNAME_MAP.put(614, "ge-1/3/9.5");
        DELAWARE_IF_IFDESCR_MAP.put(614, "ge-1/3/9.5");
        DELAWARE_IF_MAC_MAP.put(614, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(614, "test unit5");
        DELAWARE_IF_NETMASK_MAP.put(614, InetAddressUtils.addr("255.255.255.255"));
        DELAWARE_IF_IFNAME_MAP.put(529, "ge-0/1/1");
        DELAWARE_IF_IFDESCR_MAP.put(529, "ge-0/1/1");
        DELAWARE_IF_MAC_MAP.put(529, "002283095053");
        DELAWARE_IF_IFNAME_MAP.put(640, "ge-0/0/2.32767");
        DELAWARE_IF_IFDESCR_MAP.put(640, "ge-0/0/2.32767");
        DELAWARE_IF_MAC_MAP.put(640, "002283095002");
        DELAWARE_IF_IFNAME_MAP.put(518, "ge-0/0/2");
        DELAWARE_IF_IFDESCR_MAP.put(518, "ge-0/0/2");
        DELAWARE_IF_MAC_MAP.put(518, "002283095002");
        DELAWARE_IF_IFNAME_MAP.put(613, "ge-1/3/9.4");
        DELAWARE_IF_IFDESCR_MAP.put(613, "ge-1/3/9.4");
        DELAWARE_IF_MAC_MAP.put(613, "002283095249");
        DELAWARE_IF_IFALIAS_MAP.put(613, "test unit4");
        DELAWARE_IF_NETMASK_MAP.put(613, InetAddressUtils.addr("255.255.255.255"));
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.42"), 13);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.3"), 16);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.5"), 566);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("20.1.1.1"), 564);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("2.2.2.2"), 563);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("200.200.1.1"), 560);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.1"), 565);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("200.200.1.100"), 560);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("3.3.3.3"), 561);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.1"), 16);
        PHOENIX_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        PHOENIX_IF_IFNAME_MAP.put(516, "ge-1/0/4");
        PHOENIX_IF_IFDESCR_MAP.put(516, "ge-1/0/4");
        PHOENIX_IF_MAC_MAP.put(516, "80711fc41464");
        PHOENIX_IF_IFNAME_MAP.put(512, "ge-1/0/0");
        PHOENIX_IF_IFDESCR_MAP.put(512, "ge-1/0/0");
        PHOENIX_IF_MAC_MAP.put(512, "80711fc41460");
        PHOENIX_IF_IFNAME_MAP.put(511, "xe-0/0/3");
        PHOENIX_IF_IFDESCR_MAP.put(511, "xe-0/0/3");
        PHOENIX_IF_MAC_MAP.put(511, "80711fc41403");
        PHOENIX_IF_IFNAME_MAP.put(533, "ge-1/2/1");
        PHOENIX_IF_IFDESCR_MAP.put(533, "ge-1/2/1");
        PHOENIX_IF_MAC_MAP.put(533, "80711fc41491");
        PHOENIX_IF_IFNAME_MAP.put(539, "ge-1/2/7");
        PHOENIX_IF_IFDESCR_MAP.put(539, "ge-1/2/7");
        PHOENIX_IF_MAC_MAP.put(539, "80711fc41497");
        PHOENIX_IF_IFNAME_MAP.put(5423, "ge-1/1/0.717");
        PHOENIX_IF_IFDESCR_MAP.put(5423, "ge-1/1/0.717");
        PHOENIX_IF_MAC_MAP.put(5423, "80711fc41478");
        PHOENIX_IF_IFALIAS_MAP.put(5423, "No description available for selected UNI interface.");
        PHOENIX_IF_IFNAME_MAP.put(529, "ge-1/1/7");
        PHOENIX_IF_IFDESCR_MAP.put(529, "ge-1/1/7");
        PHOENIX_IF_MAC_MAP.put(529, "80711fc4147f");
        PHOENIX_IF_IFNAME_MAP.put(7, "tap");
        PHOENIX_IF_IFDESCR_MAP.put(7, "tap");
        PHOENIX_IF_IFNAME_MAP.put(5428, "ge-1/0/2.313");
        PHOENIX_IF_IFDESCR_MAP.put(5428, "ge-1/0/2.313");
        PHOENIX_IF_MAC_MAP.put(5428, "80711fc41462");
        PHOENIX_IF_IFNAME_MAP.put(16, "lo0.0");
        PHOENIX_IF_IFDESCR_MAP.put(16, "lo0.0");
        PHOENIX_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        PHOENIX_IF_IFNAME_MAP.put(565, "xe-0/0/0.0");
        PHOENIX_IF_IFDESCR_MAP.put(565, "xe-0/0/0.0");
        PHOENIX_IF_MAC_MAP.put(565, "80711fc41400");
        PHOENIX_IF_NETMASK_MAP.put(565, InetAddressUtils.addr("255.255.255.252"));
        PHOENIX_IF_IFNAME_MAP.put(12, "mtun");
        PHOENIX_IF_IFDESCR_MAP.put(12, "mtun");
        PHOENIX_IF_IFNAME_MAP.put(13, "fxp0.0");
        PHOENIX_IF_IFDESCR_MAP.put(13, "fxp0.0");
        PHOENIX_IF_MAC_MAP.put(13, "80711fc414ff");
        PHOENIX_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.224.0"));
        PHOENIX_IF_IFNAME_MAP.put(524, "ge-1/1/2");
        PHOENIX_IF_IFDESCR_MAP.put(524, "ge-1/1/2");
        PHOENIX_IF_MAC_MAP.put(524, "80711fc4147a");
        PHOENIX_IF_IFNAME_MAP.put(525, "ge-1/1/3");
        PHOENIX_IF_IFDESCR_MAP.put(525, "ge-1/1/3");
        PHOENIX_IF_MAC_MAP.put(525, "80711fc4147b");
        PHOENIX_IF_IFNAME_MAP.put(532, "ge-1/2/0");
        PHOENIX_IF_IFDESCR_MAP.put(532, "ge-1/2/0");
        PHOENIX_IF_MAC_MAP.put(532, "80711fc41490");
        PHOENIX_IF_IFNAME_MAP.put(501, "demux0");
        PHOENIX_IF_IFDESCR_MAP.put(501, "demux0");
        PHOENIX_IF_IFNAME_MAP.put(538, "ge-1/2/6");
        PHOENIX_IF_IFDESCR_MAP.put(538, "ge-1/2/6");
        PHOENIX_IF_MAC_MAP.put(538, "80711fc41496");
        PHOENIX_IF_IFNAME_MAP.put(508, "xe-0/0/0");
        PHOENIX_IF_IFDESCR_MAP.put(508, "xe-0/0/0");
        PHOENIX_IF_MAC_MAP.put(508, "80711fc41400");
        PHOENIX_IF_IFALIAS_MAP.put(508, "<ToAUS-xe000>");
        PHOENIX_IF_IFNAME_MAP.put(562, "ge-1/0/5.0");
        PHOENIX_IF_IFDESCR_MAP.put(562, "ge-1/0/5.0");
        PHOENIX_IF_MAC_MAP.put(562, "80711fc41465");
        PHOENIX_IF_IFNAME_MAP.put(563, "ge-1/1/6.0");
        PHOENIX_IF_IFDESCR_MAP.put(563, "ge-1/1/6.0");
        PHOENIX_IF_MAC_MAP.put(563, "80711fc4147e");
        PHOENIX_IF_NETMASK_MAP.put(563, InetAddressUtils.addr("255.255.255.255"));
        PHOENIX_IF_IFNAME_MAP.put(536, "ge-1/2/4");
        PHOENIX_IF_IFDESCR_MAP.put(536, "ge-1/2/4");
        PHOENIX_IF_MAC_MAP.put(536, "80711fc41494");
        PHOENIX_IF_IFNAME_MAP.put(5427, "ge-1/0/2.32767");
        PHOENIX_IF_IFDESCR_MAP.put(5427, "ge-1/0/2.32767");
        PHOENIX_IF_MAC_MAP.put(5427, "80711fc41462");
        PHOENIX_IF_IFNAME_MAP.put(513, "ge-1/0/1");
        PHOENIX_IF_IFDESCR_MAP.put(513, "ge-1/0/1");
        PHOENIX_IF_MAC_MAP.put(513, "80711fc41461");
        PHOENIX_IF_IFNAME_MAP.put(551, "ge-1/3/9");
        PHOENIX_IF_IFDESCR_MAP.put(551, "ge-1/3/9");
        PHOENIX_IF_MAC_MAP.put(551, "80711fc414b1");
        PHOENIX_IF_IFNAME_MAP.put(528, "ge-1/1/6");
        PHOENIX_IF_IFDESCR_MAP.put(528, "ge-1/1/6");
        PHOENIX_IF_MAC_MAP.put(528, "80711fc4147e");
        PHOENIX_IF_IFNAME_MAP.put(527, "ge-1/1/5");
        PHOENIX_IF_IFDESCR_MAP.put(527, "ge-1/1/5");
        PHOENIX_IF_MAC_MAP.put(527, "80711fc4147d");
        PHOENIX_IF_IFNAME_MAP.put(543, "ge-1/3/1");
        PHOENIX_IF_IFDESCR_MAP.put(543, "ge-1/3/1");
        PHOENIX_IF_MAC_MAP.put(543, "80711fc414a9");
        PHOENIX_IF_IFNAME_MAP.put(5367, "ge-1/0/8.715");
        PHOENIX_IF_IFDESCR_MAP.put(5367, "ge-1/0/8.715");
        PHOENIX_IF_MAC_MAP.put(5367, "80711fc41468");
        PHOENIX_IF_IFALIAS_MAP.put(5367, "No description available for selected UNI interface.");
        PHOENIX_IF_IFNAME_MAP.put(509, "xe-0/0/1");
        PHOENIX_IF_IFDESCR_MAP.put(509, "xe-0/0/1");
        PHOENIX_IF_MAC_MAP.put(509, "80711fc41401");
        PHOENIX_IF_IFNAME_MAP.put(564, "xe-0/0/1.0");
        PHOENIX_IF_IFDESCR_MAP.put(564, "xe-0/0/1.0");
        PHOENIX_IF_MAC_MAP.put(564, "80711fc41401");
        PHOENIX_IF_NETMASK_MAP.put(564, InetAddressUtils.addr("255.255.255.252"));
        PHOENIX_IF_IFNAME_MAP.put(530, "ge-1/1/8");
        PHOENIX_IF_IFDESCR_MAP.put(530, "ge-1/1/8");
        PHOENIX_IF_MAC_MAP.put(530, "80711fc41480");
        PHOENIX_IF_IFNAME_MAP.put(520, "ge-1/0/8");
        PHOENIX_IF_IFDESCR_MAP.put(520, "ge-1/0/8");
        PHOENIX_IF_MAC_MAP.put(520, "80711fc41468");
        PHOENIX_IF_IFNAME_MAP.put(550, "ge-1/3/8");
        PHOENIX_IF_IFDESCR_MAP.put(550, "ge-1/3/8");
        PHOENIX_IF_MAC_MAP.put(550, "80711fc414b0");
        PHOENIX_IF_IFNAME_MAP.put(4, "lsi");
        PHOENIX_IF_IFDESCR_MAP.put(4, "lsi");
        PHOENIX_IF_IFNAME_MAP.put(521, "ge-1/0/9");
        PHOENIX_IF_IFDESCR_MAP.put(521, "ge-1/0/9");
        PHOENIX_IF_MAC_MAP.put(521, "80711fc41469");
        PHOENIX_IF_IFNAME_MAP.put(506, "lc-0/0/0");
        PHOENIX_IF_IFDESCR_MAP.put(506, "lc-0/0/0");
        PHOENIX_IF_IFNAME_MAP.put(545, "ge-1/3/3");
        PHOENIX_IF_IFDESCR_MAP.put(545, "ge-1/3/3");
        PHOENIX_IF_MAC_MAP.put(545, "80711fc414ab");
        PHOENIX_IF_IFNAME_MAP.put(542, "ge-1/3/0");
        PHOENIX_IF_IFDESCR_MAP.put(542, "ge-1/3/0");
        PHOENIX_IF_MAC_MAP.put(542, "80711fc414a8");
        PHOENIX_IF_IFNAME_MAP.put(523, "ge-1/1/1");
        PHOENIX_IF_IFDESCR_MAP.put(523, "ge-1/1/1");
        PHOENIX_IF_MAC_MAP.put(523, "80711fc41479");
        PHOENIX_IF_IFNAME_MAP.put(548, "ge-1/3/6");
        PHOENIX_IF_IFDESCR_MAP.put(548, "ge-1/3/6");
        PHOENIX_IF_MAC_MAP.put(548, "80711fc414ae");
        PHOENIX_IF_IFNAME_MAP.put(534, "ge-1/2/2");
        PHOENIX_IF_IFDESCR_MAP.put(534, "ge-1/2/2");
        PHOENIX_IF_MAC_MAP.put(534, "80711fc41492");
        PHOENIX_IF_IFNAME_MAP.put(522, "ge-1/1/0");
        PHOENIX_IF_IFDESCR_MAP.put(522, "ge-1/1/0");
        PHOENIX_IF_MAC_MAP.put(522, "80711fc41478");
        PHOENIX_IF_IFNAME_MAP.put(519, "ge-1/0/7");
        PHOENIX_IF_IFDESCR_MAP.put(519, "ge-1/0/7");
        PHOENIX_IF_MAC_MAP.put(519, "80711fc41467");
        PHOENIX_IF_IFNAME_MAP.put(1, "fxp0");
        PHOENIX_IF_IFDESCR_MAP.put(1, "fxp0");
        PHOENIX_IF_MAC_MAP.put(1, "80711fc414ff");
        PHOENIX_IF_IFNAME_MAP.put(535, "ge-1/2/3");
        PHOENIX_IF_IFDESCR_MAP.put(535, "ge-1/2/3");
        PHOENIX_IF_MAC_MAP.put(535, "80711fc41493");
        PHOENIX_IF_IFNAME_MAP.put(502, "cbp0");
        PHOENIX_IF_IFDESCR_MAP.put(502, "cbp0");
        PHOENIX_IF_MAC_MAP.put(502, "80711fc41411");
        PHOENIX_IF_IFNAME_MAP.put(5368, "ge-1/0/7.32767");
        PHOENIX_IF_IFDESCR_MAP.put(5368, "ge-1/0/7.32767");
        PHOENIX_IF_MAC_MAP.put(5368, "80711fc41467");
        PHOENIX_IF_IFNAME_MAP.put(505, "irb");
        PHOENIX_IF_IFDESCR_MAP.put(505, "irb");
        PHOENIX_IF_MAC_MAP.put(505, "80711fc414f0");
        PHOENIX_IF_IFNAME_MAP.put(507, "lc-0/0/0.32769");
        PHOENIX_IF_IFDESCR_MAP.put(507, "lc-0/0/0.32769");
        PHOENIX_IF_IFNAME_MAP.put(504, "pp0");
        PHOENIX_IF_IFDESCR_MAP.put(504, "pp0");
        PHOENIX_IF_IFNAME_MAP.put(544, "ge-1/3/2");
        PHOENIX_IF_IFDESCR_MAP.put(544, "ge-1/3/2");
        PHOENIX_IF_MAC_MAP.put(544, "80711fc414aa");
        PHOENIX_IF_IFNAME_MAP.put(537, "ge-1/2/5");
        PHOENIX_IF_IFDESCR_MAP.put(537, "ge-1/2/5");
        PHOENIX_IF_MAC_MAP.put(537, "80711fc41495");
        PHOENIX_IF_IFNAME_MAP.put(553, "pfh-0/0/0.16383");
        PHOENIX_IF_IFDESCR_MAP.put(553, "pfh-0/0/0.16383");
        PHOENIX_IF_IFNAME_MAP.put(22, "lo0.16385");
        PHOENIX_IF_IFDESCR_MAP.put(22, "lo0.16385");
        PHOENIX_IF_IFNAME_MAP.put(555, "pfe-0/0/0.16383");
        PHOENIX_IF_IFDESCR_MAP.put(555, "pfe-0/0/0.16383");
        PHOENIX_IF_IFNAME_MAP.put(17, "em0");
        PHOENIX_IF_IFDESCR_MAP.put(17, "em0");
        PHOENIX_IF_MAC_MAP.put(17, "020000000004");
        PHOENIX_IF_IFNAME_MAP.put(546, "ge-1/3/4");
        PHOENIX_IF_IFDESCR_MAP.put(546, "ge-1/3/4");
        PHOENIX_IF_MAC_MAP.put(546, "80711fc414ac");
        PHOENIX_IF_IFNAME_MAP.put(515, "ge-1/0/3");
        PHOENIX_IF_IFDESCR_MAP.put(515, "ge-1/0/3");
        PHOENIX_IF_MAC_MAP.put(515, "80711fc41463");
        PHOENIX_IF_IFNAME_MAP.put(531, "ge-1/1/9");
        PHOENIX_IF_IFDESCR_MAP.put(531, "ge-1/1/9");
        PHOENIX_IF_MAC_MAP.put(531, "80711fc41481");
        PHOENIX_IF_IFNAME_MAP.put(552, "pfh-0/0/0");
        PHOENIX_IF_IFDESCR_MAP.put(552, "pfh-0/0/0");
        PHOENIX_IF_IFNAME_MAP.put(526, "ge-1/1/4");
        PHOENIX_IF_IFDESCR_MAP.put(526, "ge-1/1/4");
        PHOENIX_IF_MAC_MAP.put(526, "80711fc4147c");
        PHOENIX_IF_IFNAME_MAP.put(11, "pimd");
        PHOENIX_IF_IFDESCR_MAP.put(11, "pimd");
        PHOENIX_IF_IFNAME_MAP.put(541, "ge-1/2/9");
        PHOENIX_IF_IFDESCR_MAP.put(541, "ge-1/2/9");
        PHOENIX_IF_MAC_MAP.put(541, "80711fc41499");
        PHOENIX_IF_IFNAME_MAP.put(23, "em1");
        PHOENIX_IF_IFDESCR_MAP.put(23, "em1");
        PHOENIX_IF_MAC_MAP.put(23, "020002000004");
        PHOENIX_IF_IFNAME_MAP.put(18, "em0.0");
        PHOENIX_IF_IFDESCR_MAP.put(18, "em0.0");
        PHOENIX_IF_MAC_MAP.put(18, "020000000004");
        PHOENIX_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        PHOENIX_IF_IFNAME_MAP.put(517, "ge-1/0/5");
        PHOENIX_IF_IFDESCR_MAP.put(517, "ge-1/0/5");
        PHOENIX_IF_MAC_MAP.put(517, "80711fc41465");
        PHOENIX_IF_IFNAME_MAP.put(554, "pfe-0/0/0");
        PHOENIX_IF_IFDESCR_MAP.put(554, "pfe-0/0/0");
        PHOENIX_IF_IFNAME_MAP.put(561, "ge-1/0/4.0");
        PHOENIX_IF_IFDESCR_MAP.put(561, "ge-1/0/4.0");
        PHOENIX_IF_MAC_MAP.put(561, "80711fc41464");
        PHOENIX_IF_NETMASK_MAP.put(561, InetAddressUtils.addr("255.255.255.255"));
        PHOENIX_IF_IFNAME_MAP.put(556, "ge-1/1/0.32767");
        PHOENIX_IF_IFDESCR_MAP.put(556, "ge-1/1/0.32767");
        PHOENIX_IF_MAC_MAP.put(556, "80711fc41478");
        PHOENIX_IF_IFNAME_MAP.put(568, "ge-1/0/8.32767");
        PHOENIX_IF_IFDESCR_MAP.put(568, "ge-1/0/8.32767");
        PHOENIX_IF_MAC_MAP.put(568, "80711fc41468");
        PHOENIX_IF_IFNAME_MAP.put(34, "me0.0");
        PHOENIX_IF_IFDESCR_MAP.put(34, "me0.0");
        PHOENIX_IF_MAC_MAP.put(34, "02000000000b");
        PHOENIX_IF_IFNAME_MAP.put(510, "xe-0/0/2");
        PHOENIX_IF_IFDESCR_MAP.put(510, "xe-0/0/2");
        PHOENIX_IF_MAC_MAP.put(510, "80711fc41402");
        PHOENIX_IF_IFNAME_MAP.put(503, "pip0");
        PHOENIX_IF_IFDESCR_MAP.put(503, "pip0");
        PHOENIX_IF_MAC_MAP.put(503, "80711fc414b0");
        PHOENIX_IF_IFNAME_MAP.put(549, "ge-1/3/7");
        PHOENIX_IF_IFDESCR_MAP.put(549, "ge-1/3/7");
        PHOENIX_IF_MAC_MAP.put(549, "80711fc414af");
        PHOENIX_IF_IFNAME_MAP.put(566, "ge-1/0/3.0");
        PHOENIX_IF_IFDESCR_MAP.put(566, "ge-1/0/3.0");
        PHOENIX_IF_MAC_MAP.put(566, "80711fc41463");
        PHOENIX_IF_NETMASK_MAP.put(566, InetAddressUtils.addr("255.255.255.252"));
        PHOENIX_IF_IFNAME_MAP.put(540, "ge-1/2/8");
        PHOENIX_IF_IFDESCR_MAP.put(540, "ge-1/2/8");
        PHOENIX_IF_MAC_MAP.put(540, "80711fc41498");
        PHOENIX_IF_IFNAME_MAP.put(514, "ge-1/0/2");
        PHOENIX_IF_IFDESCR_MAP.put(514, "ge-1/0/2");
        PHOENIX_IF_MAC_MAP.put(514, "80711fc41462");
        PHOENIX_IF_IFNAME_MAP.put(9, "ipip");
        PHOENIX_IF_IFDESCR_MAP.put(9, "ipip");
        PHOENIX_IF_IFNAME_MAP.put(8, "gre");
        PHOENIX_IF_IFDESCR_MAP.put(8, "gre");
        PHOENIX_IF_IFNAME_MAP.put(10, "pime");
        PHOENIX_IF_IFDESCR_MAP.put(10, "pime");
        PHOENIX_IF_IFNAME_MAP.put(5, "dsc");
        PHOENIX_IF_IFDESCR_MAP.put(5, "dsc");
        PHOENIX_IF_IFNAME_MAP.put(518, "ge-1/0/6");
        PHOENIX_IF_IFDESCR_MAP.put(518, "ge-1/0/6");
        PHOENIX_IF_MAC_MAP.put(518, "80711fc41466");
        PHOENIX_IF_IFNAME_MAP.put(560, "ge-1/0/1.0");
        PHOENIX_IF_IFDESCR_MAP.put(560, "ge-1/0/1.0");
        PHOENIX_IF_MAC_MAP.put(560, "80711fc41461");
        PHOENIX_IF_NETMASK_MAP.put(560, InetAddressUtils.addr("255.255.255.0"));
        PHOENIX_IF_IFNAME_MAP.put(33, "me0");
        PHOENIX_IF_IFDESCR_MAP.put(33, "me0");
        PHOENIX_IF_MAC_MAP.put(33, "02000000000b");
        PHOENIX_IF_IFNAME_MAP.put(8217, "ge-1/1/1.32767");
        PHOENIX_IF_IFDESCR_MAP.put(8217, "ge-1/1/1.32767");
        PHOENIX_IF_MAC_MAP.put(8217, "80711fc41479");
        PHOENIX_IF_IFNAME_MAP.put(547, "ge-1/3/5");
        PHOENIX_IF_IFDESCR_MAP.put(547, "ge-1/3/5");
        PHOENIX_IF_MAC_MAP.put(547, "80711fc414ad");
        PHOENIX_IF_IFNAME_MAP.put(6, "lo0");
        PHOENIX_IF_IFDESCR_MAP.put(6, "lo0");
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.2"), 554);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.9"), 586);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.43"), 13);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("20.1.1.5"), 555);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("192.168.0.2"), 16);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("20.1.11.1"), 553);
        AUSTIN_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        AUSTIN_IF_IFNAME_MAP.put(519, "ge-1/0/7");
        AUSTIN_IF_IFDESCR_MAP.put(519, "ge-1/0/7");
        AUSTIN_IF_MAC_MAP.put(519, "80711fc41367");
        AUSTIN_IF_IFNAME_MAP.put(518, "ge-1/0/6");
        AUSTIN_IF_IFDESCR_MAP.put(518, "ge-1/0/6");
        AUSTIN_IF_MAC_MAP.put(518, "80711fc41366");
        AUSTIN_IF_IFNAME_MAP.put(582, "ge-1/0/8.32767");
        AUSTIN_IF_IFDESCR_MAP.put(582, "ge-1/0/8.32767");
        AUSTIN_IF_MAC_MAP.put(582, "80711fc41368");
        AUSTIN_IF_IFNAME_MAP.put(17, "em0");
        AUSTIN_IF_IFDESCR_MAP.put(17, "em0");
        AUSTIN_IF_MAC_MAP.put(17, "020000000004");
        AUSTIN_IF_IFNAME_MAP.put(509, "xe-0/0/1");
        AUSTIN_IF_IFDESCR_MAP.put(509, "xe-0/0/1");
        AUSTIN_IF_MAC_MAP.put(509, "80711fc41301");
        AUSTIN_IF_IFNAME_MAP.put(552, "pfh-0/0/0");
        AUSTIN_IF_IFDESCR_MAP.put(552, "pfh-0/0/0");
        AUSTIN_IF_IFNAME_MAP.put(513, "ge-1/0/1");
        AUSTIN_IF_IFDESCR_MAP.put(513, "ge-1/0/1");
        AUSTIN_IF_MAC_MAP.put(513, "80711fc41361");
        AUSTIN_IF_IFNAME_MAP.put(555, "xe-0/0/1.0");
        AUSTIN_IF_IFDESCR_MAP.put(555, "xe-0/0/1.0");
        AUSTIN_IF_MAC_MAP.put(555, "80711fc41301");
        AUSTIN_IF_NETMASK_MAP.put(555, InetAddressUtils.addr("255.255.255.252"));
        AUSTIN_IF_IFNAME_MAP.put(523, "ge-1/1/1");
        AUSTIN_IF_IFDESCR_MAP.put(523, "ge-1/1/1");
        AUSTIN_IF_MAC_MAP.put(523, "80711fc41379");
        AUSTIN_IF_IFNAME_MAP.put(511, "xe-0/0/3");
        AUSTIN_IF_IFDESCR_MAP.put(511, "xe-0/0/3");
        AUSTIN_IF_MAC_MAP.put(511, "80711fc41303");
        AUSTIN_IF_IFNAME_MAP.put(512, "ge-1/0/0");
        AUSTIN_IF_IFDESCR_MAP.put(512, "ge-1/0/0");
        AUSTIN_IF_MAC_MAP.put(512, "80711fc41360");
        AUSTIN_IF_IFNAME_MAP.put(522, "ge-1/1/0");
        AUSTIN_IF_IFDESCR_MAP.put(522, "ge-1/1/0");
        AUSTIN_IF_MAC_MAP.put(522, "80711fc41378");
        AUSTIN_IF_IFNAME_MAP.put(505, "lc-0/0/0.32769");
        AUSTIN_IF_IFDESCR_MAP.put(505, "lc-0/0/0.32769");
        AUSTIN_IF_IFNAME_MAP.put(515, "ge-1/0/3");
        AUSTIN_IF_IFDESCR_MAP.put(515, "ge-1/0/3");
        AUSTIN_IF_MAC_MAP.put(515, "80711fc41363");
        AUSTIN_IF_IFNAME_MAP.put(551, "ge-1/3/9");
        AUSTIN_IF_IFDESCR_MAP.put(551, "ge-1/3/9");
        AUSTIN_IF_MAC_MAP.put(551, "80711fc413b1");
        AUSTIN_IF_IFNAME_MAP.put(541, "ge-1/2/9");
        AUSTIN_IF_IFDESCR_MAP.put(541, "ge-1/2/9");
        AUSTIN_IF_MAC_MAP.put(541, "80711fc41399");
        AUSTIN_IF_IFNAME_MAP.put(6, "lo0");
        AUSTIN_IF_IFDESCR_MAP.put(6, "lo0");
        AUSTIN_IF_IFNAME_MAP.put(23, "em1");
        AUSTIN_IF_IFDESCR_MAP.put(23, "em1");
        AUSTIN_IF_MAC_MAP.put(23, "020002000004");
        AUSTIN_IF_IFNAME_MAP.put(554, "xe-0/0/0.0");
        AUSTIN_IF_IFDESCR_MAP.put(554, "xe-0/0/0.0");
        AUSTIN_IF_MAC_MAP.put(554, "80711fc41300");
        AUSTIN_IF_NETMASK_MAP.put(554, InetAddressUtils.addr("255.255.255.252"));
        AUSTIN_IF_IFNAME_MAP.put(547, "ge-1/3/5");
        AUSTIN_IF_IFDESCR_MAP.put(547, "ge-1/3/5");
        AUSTIN_IF_MAC_MAP.put(547, "80711fc413ad");
        AUSTIN_IF_IFNAME_MAP.put(510, "xe-0/0/2");
        AUSTIN_IF_IFDESCR_MAP.put(510, "xe-0/0/2");
        AUSTIN_IF_MAC_MAP.put(510, "80711fc41302");
        AUSTIN_IF_IFNAME_MAP.put(536, "ge-1/2/4");
        AUSTIN_IF_IFDESCR_MAP.put(536, "ge-1/2/4");
        AUSTIN_IF_MAC_MAP.put(536, "80711fc41394");
        AUSTIN_IF_IFNAME_MAP.put(504, "lc-0/0/0");
        AUSTIN_IF_IFDESCR_MAP.put(504, "lc-0/0/0");
        AUSTIN_IF_IFNAME_MAP.put(534, "ge-1/2/2");
        AUSTIN_IF_IFDESCR_MAP.put(534, "ge-1/2/2");
        AUSTIN_IF_MAC_MAP.put(534, "80711fc41392");
        AUSTIN_IF_IFNAME_MAP.put(535, "ge-1/2/3");
        AUSTIN_IF_IFDESCR_MAP.put(535, "ge-1/2/3");
        AUSTIN_IF_MAC_MAP.put(535, "80711fc41393");
        AUSTIN_IF_IFNAME_MAP.put(540, "ge-1/2/8");
        AUSTIN_IF_IFDESCR_MAP.put(540, "ge-1/2/8");
        AUSTIN_IF_MAC_MAP.put(540, "80711fc41398");
        AUSTIN_IF_IFNAME_MAP.put(537, "ge-1/2/5");
        AUSTIN_IF_IFDESCR_MAP.put(537, "ge-1/2/5");
        AUSTIN_IF_MAC_MAP.put(537, "80711fc41395");
        AUSTIN_IF_IFNAME_MAP.put(524, "ge-1/1/2");
        AUSTIN_IF_IFDESCR_MAP.put(524, "ge-1/1/2");
        AUSTIN_IF_MAC_MAP.put(524, "80711fc4137a");
        AUSTIN_IF_IFNAME_MAP.put(533, "ge-1/2/1");
        AUSTIN_IF_IFDESCR_MAP.put(533, "ge-1/2/1");
        AUSTIN_IF_MAC_MAP.put(533, "80711fc41391");
        AUSTIN_IF_IFNAME_MAP.put(501, "demux0");
        AUSTIN_IF_IFDESCR_MAP.put(501, "demux0");
        AUSTIN_IF_IFNAME_MAP.put(12, "mtun");
        AUSTIN_IF_IFDESCR_MAP.put(12, "mtun");
        AUSTIN_IF_IFNAME_MAP.put(34, "me0.0");
        AUSTIN_IF_IFDESCR_MAP.put(34, "me0.0");
        AUSTIN_IF_MAC_MAP.put(34, "02000000000b");
        AUSTIN_IF_IFNAME_MAP.put(557, "pfe-0/0/0");
        AUSTIN_IF_IFDESCR_MAP.put(557, "pfe-0/0/0");
        AUSTIN_IF_IFNAME_MAP.put(11, "pimd");
        AUSTIN_IF_IFDESCR_MAP.put(11, "pimd");
        AUSTIN_IF_IFNAME_MAP.put(1, "fxp0");
        AUSTIN_IF_IFDESCR_MAP.put(1, "fxp0");
        AUSTIN_IF_MAC_MAP.put(1, "80711fc413ff");
        AUSTIN_IF_IFNAME_MAP.put(539, "ge-1/2/7");
        AUSTIN_IF_IFDESCR_MAP.put(539, "ge-1/2/7");
        AUSTIN_IF_MAC_MAP.put(539, "80711fc41397");
        AUSTIN_IF_IFNAME_MAP.put(561, "xe-0/0/3.715");
        AUSTIN_IF_IFDESCR_MAP.put(561, "xe-0/0/3.715");
        AUSTIN_IF_MAC_MAP.put(561, "80711fc41303");
        AUSTIN_IF_IFALIAS_MAP.put(561, "No description available for selected UNI interface.");
        AUSTIN_IF_IFNAME_MAP.put(8, "gre");
        AUSTIN_IF_IFDESCR_MAP.put(8, "gre");
        AUSTIN_IF_IFNAME_MAP.put(10, "pime");
        AUSTIN_IF_IFDESCR_MAP.put(10, "pime");
        AUSTIN_IF_IFNAME_MAP.put(548, "ge-1/3/6");
        AUSTIN_IF_IFDESCR_MAP.put(548, "ge-1/3/6");
        AUSTIN_IF_MAC_MAP.put(548, "80711fc413ae");
        AUSTIN_IF_IFNAME_MAP.put(516, "ge-1/0/4");
        AUSTIN_IF_IFDESCR_MAP.put(516, "ge-1/0/4");
        AUSTIN_IF_MAC_MAP.put(516, "80711fc41364");
        AUSTIN_IF_IFNAME_MAP.put(6207, "ge-1/0/4.32767");
        AUSTIN_IF_IFDESCR_MAP.put(6207, "ge-1/0/4.32767");
        AUSTIN_IF_MAC_MAP.put(6207, "80711fc41364");
        AUSTIN_IF_IFNAME_MAP.put(563, "ge-1/0/4.716");
        AUSTIN_IF_IFDESCR_MAP.put(563, "ge-1/0/4.716");
        AUSTIN_IF_MAC_MAP.put(563, "80711fc41364");
        AUSTIN_IF_IFALIAS_MAP.put(563, "No description available for selected UNI interface.");
        AUSTIN_IF_IFNAME_MAP.put(586, "ge-1/0/3.0");
        AUSTIN_IF_IFDESCR_MAP.put(586, "ge-1/0/3.0");
        AUSTIN_IF_MAC_MAP.put(586, "80711fc41363");
        AUSTIN_IF_NETMASK_MAP.put(586, InetAddressUtils.addr("255.255.255.252"));
        AUSTIN_IF_IFNAME_MAP.put(530, "ge-1/1/8");
        AUSTIN_IF_IFDESCR_MAP.put(530, "ge-1/1/8");
        AUSTIN_IF_MAC_MAP.put(530, "80711fc41380");
        AUSTIN_IF_IFNAME_MAP.put(508, "xe-0/0/0");
        AUSTIN_IF_IFDESCR_MAP.put(508, "xe-0/0/0");
        AUSTIN_IF_MAC_MAP.put(508, "80711fc41300");
        AUSTIN_IF_IFALIAS_MAP.put(508, "<ToPHX-xe000>");
        AUSTIN_IF_IFNAME_MAP.put(544, "ge-1/3/2");
        AUSTIN_IF_IFDESCR_MAP.put(544, "ge-1/3/2");
        AUSTIN_IF_MAC_MAP.put(544, "80711fc413aa");
        AUSTIN_IF_IFNAME_MAP.put(527, "ge-1/1/5");
        AUSTIN_IF_IFDESCR_MAP.put(527, "ge-1/1/5");
        AUSTIN_IF_MAC_MAP.put(527, "80711fc4137d");
        AUSTIN_IF_IFNAME_MAP.put(532, "ge-1/2/0");
        AUSTIN_IF_IFDESCR_MAP.put(532, "ge-1/2/0");
        AUSTIN_IF_MAC_MAP.put(532, "80711fc41390");
        AUSTIN_IF_IFNAME_MAP.put(7, "tap");
        AUSTIN_IF_IFDESCR_MAP.put(7, "tap");
        AUSTIN_IF_IFNAME_MAP.put(506, "pp0");
        AUSTIN_IF_IFDESCR_MAP.put(506, "pp0");
        AUSTIN_IF_IFNAME_MAP.put(566, "ge-1/0/5.32767");
        AUSTIN_IF_IFDESCR_MAP.put(566, "ge-1/0/5.32767");
        AUSTIN_IF_MAC_MAP.put(566, "80711fc41365");
        AUSTIN_IF_IFNAME_MAP.put(580, "ge-1/0/7.32767");
        AUSTIN_IF_IFDESCR_MAP.put(580, "ge-1/0/7.32767");
        AUSTIN_IF_MAC_MAP.put(580, "80711fc41367");
        AUSTIN_IF_IFNAME_MAP.put(545, "ge-1/3/3");
        AUSTIN_IF_IFDESCR_MAP.put(545, "ge-1/3/3");
        AUSTIN_IF_MAC_MAP.put(545, "80711fc413ab");
        AUSTIN_IF_IFNAME_MAP.put(521, "ge-1/0/9");
        AUSTIN_IF_IFDESCR_MAP.put(521, "ge-1/0/9");
        AUSTIN_IF_MAC_MAP.put(521, "80711fc41369");
        AUSTIN_IF_IFNAME_MAP.put(9, "ipip");
        AUSTIN_IF_IFDESCR_MAP.put(9, "ipip");
        AUSTIN_IF_IFNAME_MAP.put(542, "ge-1/3/0");
        AUSTIN_IF_IFDESCR_MAP.put(542, "ge-1/3/0");
        AUSTIN_IF_MAC_MAP.put(542, "80711fc413a8");
        AUSTIN_IF_IFNAME_MAP.put(13, "fxp0.0");
        AUSTIN_IF_IFDESCR_MAP.put(13, "fxp0.0");
        AUSTIN_IF_MAC_MAP.put(13, "80711fc413ff");
        AUSTIN_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.224.0"));
        AUSTIN_IF_IFNAME_MAP.put(16, "lo0.0");
        AUSTIN_IF_IFDESCR_MAP.put(16, "lo0.0");
        AUSTIN_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        AUSTIN_IF_IFNAME_MAP.put(550, "ge-1/3/8");
        AUSTIN_IF_IFDESCR_MAP.put(550, "ge-1/3/8");
        AUSTIN_IF_MAC_MAP.put(550, "80711fc413b0");
        AUSTIN_IF_IFNAME_MAP.put(33, "me0");
        AUSTIN_IF_IFDESCR_MAP.put(33, "me0");
        AUSTIN_IF_MAC_MAP.put(33, "02000000000b");
        AUSTIN_IF_IFNAME_MAP.put(531, "ge-1/1/9");
        AUSTIN_IF_IFDESCR_MAP.put(531, "ge-1/1/9");
        AUSTIN_IF_MAC_MAP.put(531, "80711fc41381");
        AUSTIN_IF_IFNAME_MAP.put(507, "irb");
        AUSTIN_IF_IFDESCR_MAP.put(507, "irb");
        AUSTIN_IF_MAC_MAP.put(507, "80711fc413f0");
        AUSTIN_IF_IFNAME_MAP.put(514, "ge-1/0/2");
        AUSTIN_IF_IFDESCR_MAP.put(514, "ge-1/0/2");
        AUSTIN_IF_MAC_MAP.put(514, "80711fc41362");
        AUSTIN_IF_IFNAME_MAP.put(543, "ge-1/3/1");
        AUSTIN_IF_IFDESCR_MAP.put(543, "ge-1/3/1");
        AUSTIN_IF_MAC_MAP.put(543, "80711fc413a9");
        AUSTIN_IF_IFNAME_MAP.put(549, "ge-1/3/7");
        AUSTIN_IF_IFDESCR_MAP.put(549, "ge-1/3/7");
        AUSTIN_IF_MAC_MAP.put(549, "80711fc413af");
        AUSTIN_IF_IFNAME_MAP.put(559, "pfh-0/0/0.16383");
        AUSTIN_IF_IFDESCR_MAP.put(559, "pfh-0/0/0.16383");
        AUSTIN_IF_IFNAME_MAP.put(18, "em0.0");
        AUSTIN_IF_IFDESCR_MAP.put(18, "em0.0");
        AUSTIN_IF_MAC_MAP.put(18, "020000000004");
        AUSTIN_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        AUSTIN_IF_IFNAME_MAP.put(22, "lo0.16385");
        AUSTIN_IF_IFDESCR_MAP.put(22, "lo0.16385");
        AUSTIN_IF_IFNAME_MAP.put(546, "ge-1/3/4");
        AUSTIN_IF_IFDESCR_MAP.put(546, "ge-1/3/4");
        AUSTIN_IF_MAC_MAP.put(546, "80711fc413ac");
        AUSTIN_IF_IFNAME_MAP.put(558, "pfe-0/0/0.16383");
        AUSTIN_IF_IFDESCR_MAP.put(558, "pfe-0/0/0.16383");
        AUSTIN_IF_IFNAME_MAP.put(529, "ge-1/1/7");
        AUSTIN_IF_IFDESCR_MAP.put(529, "ge-1/1/7");
        AUSTIN_IF_MAC_MAP.put(529, "80711fc4137f");
        AUSTIN_IF_IFNAME_MAP.put(502, "cbp0");
        AUSTIN_IF_IFDESCR_MAP.put(502, "cbp0");
        AUSTIN_IF_MAC_MAP.put(502, "80711fc41311");
        AUSTIN_IF_IFNAME_MAP.put(562, "xe-0/0/3.32767");
        AUSTIN_IF_IFDESCR_MAP.put(562, "xe-0/0/3.32767");
        AUSTIN_IF_MAC_MAP.put(562, "80711fc41303");
        AUSTIN_IF_IFNAME_MAP.put(564, "ge-1/0/7.723");
        AUSTIN_IF_IFDESCR_MAP.put(564, "ge-1/0/7.723");
        AUSTIN_IF_MAC_MAP.put(564, "80711fc41367");
        AUSTIN_IF_IFALIAS_MAP.put(564, "No description available for selected UNI interface.");
        AUSTIN_IF_IFNAME_MAP.put(517, "ge-1/0/5");
        AUSTIN_IF_IFDESCR_MAP.put(517, "ge-1/0/5");
        AUSTIN_IF_MAC_MAP.put(517, "80711fc41365");
        AUSTIN_IF_IFNAME_MAP.put(5, "dsc");
        AUSTIN_IF_IFDESCR_MAP.put(5, "dsc");
        AUSTIN_IF_IFNAME_MAP.put(553, "ge-1/0/1.0");
        AUSTIN_IF_IFDESCR_MAP.put(553, "ge-1/0/1.0");
        AUSTIN_IF_MAC_MAP.put(553, "80711fc41361");
        AUSTIN_IF_NETMASK_MAP.put(553, InetAddressUtils.addr("255.255.255.252"));
        AUSTIN_IF_IFNAME_MAP.put(528, "ge-1/1/6");
        AUSTIN_IF_IFDESCR_MAP.put(528, "ge-1/1/6");
        AUSTIN_IF_MAC_MAP.put(528, "80711fc4137e");
        AUSTIN_IF_IFNAME_MAP.put(526, "ge-1/1/4");
        AUSTIN_IF_IFDESCR_MAP.put(526, "ge-1/1/4");
        AUSTIN_IF_MAC_MAP.put(526, "80711fc4137c");
        AUSTIN_IF_IFNAME_MAP.put(520, "ge-1/0/8");
        AUSTIN_IF_IFDESCR_MAP.put(520, "ge-1/0/8");
        AUSTIN_IF_MAC_MAP.put(520, "80711fc41368");
        AUSTIN_IF_IFNAME_MAP.put(4, "lsi");
        AUSTIN_IF_IFDESCR_MAP.put(4, "lsi");
        AUSTIN_IF_IFNAME_MAP.put(538, "ge-1/2/6");
        AUSTIN_IF_IFDESCR_MAP.put(538, "ge-1/2/6");
        AUSTIN_IF_MAC_MAP.put(538, "80711fc41396");
        AUSTIN_IF_IFNAME_MAP.put(525, "ge-1/1/3");
        AUSTIN_IF_IFDESCR_MAP.put(525, "ge-1/1/3");
        AUSTIN_IF_MAC_MAP.put(525, "80711fc4137b");
        AUSTIN_IF_IFNAME_MAP.put(503, "pip0");
        AUSTIN_IF_IFDESCR_MAP.put(503, "pip0");
        AUSTIN_IF_MAC_MAP.put(503, "80711fc413b0");
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.1"), 16);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.1"), 18);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.12"), 13);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.6"), 564);
        SANJOSE_IP_IF_MAP.put(InetAddressUtils.addr("20.1.0.10"), 8562);
        SANJOSE_IF_IFNAME_MAP.put(523, "ge-1/0/7");
        SANJOSE_IF_IFDESCR_MAP.put(523, "ge-1/0/7");
        SANJOSE_IF_MAC_MAP.put(523, "002283d8529c");
        SANJOSE_IF_IFNAME_MAP.put(8560, "pfe-1/2/0");
        SANJOSE_IF_IFDESCR_MAP.put(8560, "pfe-1/2/0");
        SANJOSE_IF_IFNAME_MAP.put(537, "ge-1/1/9");
        SANJOSE_IF_IFDESCR_MAP.put(537, "ge-1/1/9");
        SANJOSE_IF_MAC_MAP.put(537, "002283d85343");
        SANJOSE_IF_IFNAME_MAP.put(4, "lsi");
        SANJOSE_IF_IFDESCR_MAP.put(4, "lsi");
        SANJOSE_IF_IFNAME_MAP.put(551, "lc-1/2/0.32769");
        SANJOSE_IF_IFDESCR_MAP.put(551, "lc-1/2/0.32769");
        SANJOSE_IF_IFNAME_MAP.put(517, "ge-1/0/1");
        SANJOSE_IF_IFDESCR_MAP.put(517, "ge-1/0/1");
        SANJOSE_IF_MAC_MAP.put(517, "002283d85296");
        SANJOSE_IF_IFNAME_MAP.put(525, "ge-1/0/9");
        SANJOSE_IF_IFDESCR_MAP.put(525, "ge-1/0/9");
        SANJOSE_IF_MAC_MAP.put(525, "002283d8529e");
        SANJOSE_IF_IFNAME_MAP.put(533, "ge-1/1/5");
        SANJOSE_IF_IFDESCR_MAP.put(533, "ge-1/1/5");
        SANJOSE_IF_MAC_MAP.put(533, "002283d8533f");
        SANJOSE_IF_IFNAME_MAP.put(559, "ge-1/3/7");
        SANJOSE_IF_IFDESCR_MAP.put(559, "ge-1/3/7");
        SANJOSE_IF_MAC_MAP.put(559, "002283d8548b");
        SANJOSE_IF_IFNAME_MAP.put(564, "ge-1/0/0.0");
        SANJOSE_IF_IFDESCR_MAP.put(564, "ge-1/0/0.0");
        SANJOSE_IF_MAC_MAP.put(564, "002283d85295");
        SANJOSE_IF_NETMASK_MAP.put(564, InetAddressUtils.addr("255.255.255.252"));
        SANJOSE_IF_IFNAME_MAP.put(555, "ge-1/3/3");
        SANJOSE_IF_IFDESCR_MAP.put(555, "ge-1/3/3");
        SANJOSE_IF_MAC_MAP.put(555, "002283d85487");
        SANJOSE_IF_IFNAME_MAP.put(7, "tap");
        SANJOSE_IF_IFDESCR_MAP.put(7, "tap");
        SANJOSE_IF_IFNAME_MAP.put(524, "ge-1/0/8");
        SANJOSE_IF_IFDESCR_MAP.put(524, "ge-1/0/8");
        SANJOSE_IF_MAC_MAP.put(524, "002283d8529d");
        SANJOSE_IF_IFNAME_MAP.put(518, "ge-1/0/2");
        SANJOSE_IF_IFDESCR_MAP.put(518, "ge-1/0/2");
        SANJOSE_IF_MAC_MAP.put(518, "002283d85297");
        SANJOSE_IF_IFNAME_MAP.put(546, "ge-1/2/6");
        SANJOSE_IF_IFDESCR_MAP.put(546, "ge-1/2/6");
        SANJOSE_IF_MAC_MAP.put(546, "002283d853e5");
        SANJOSE_IF_IFNAME_MAP.put(8562, "ge-1/0/1.0");
        SANJOSE_IF_IFDESCR_MAP.put(8562, "ge-1/0/1.0");
        SANJOSE_IF_MAC_MAP.put(8562, "002283d85296");
        SANJOSE_IF_NETMASK_MAP.put(8562, InetAddressUtils.addr("255.255.255.252"));
        SANJOSE_IF_IFNAME_MAP.put(8558, "pfe-1/0/0");
        SANJOSE_IF_IFDESCR_MAP.put(8558, "pfe-1/0/0");
        SANJOSE_IF_IFNAME_MAP.put(17, "em0");
        SANJOSE_IF_IFDESCR_MAP.put(17, "em0");
        SANJOSE_IF_MAC_MAP.put(17, "020000000004");
        SANJOSE_IF_IFNAME_MAP.put(560, "ge-1/3/8");
        SANJOSE_IF_IFDESCR_MAP.put(560, "ge-1/3/8");
        SANJOSE_IF_MAC_MAP.put(560, "002283d8548c");
        SANJOSE_IF_IFNAME_MAP.put(12, "mtun");
        SANJOSE_IF_IFDESCR_MAP.put(12, "mtun");
        SANJOSE_IF_IFNAME_MAP.put(527, "lc-1/0/0.32769");
        SANJOSE_IF_IFDESCR_MAP.put(527, "lc-1/0/0.32769");
        SANJOSE_IF_IFNAME_MAP.put(22, "lo0.16385");
        SANJOSE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        SANJOSE_IF_IFNAME_MAP.put(534, "ge-1/1/6");
        SANJOSE_IF_IFDESCR_MAP.put(534, "ge-1/1/6");
        SANJOSE_IF_MAC_MAP.put(534, "002283d85340");
        SANJOSE_IF_IFNAME_MAP.put(8557, "pfh-1/0/0");
        SANJOSE_IF_IFDESCR_MAP.put(8557, "pfh-1/0/0");
        SANJOSE_IF_IFNAME_MAP.put(553, "ge-1/3/1");
        SANJOSE_IF_IFDESCR_MAP.put(553, "ge-1/3/1");
        SANJOSE_IF_MAC_MAP.put(553, "002283d85485");
        SANJOSE_IF_IFNAME_MAP.put(529, "ge-1/1/1");
        SANJOSE_IF_IFDESCR_MAP.put(529, "ge-1/1/1");
        SANJOSE_IF_MAC_MAP.put(529, "002283d8533b");
        SANJOSE_IF_IFNAME_MAP.put(516, "ge-1/0/0");
        SANJOSE_IF_IFDESCR_MAP.put(516, "ge-1/0/0");
        SANJOSE_IF_MAC_MAP.put(516, "002283d85295");
        SANJOSE_IF_IFNAME_MAP.put(8559, "pfe-1/1/0");
        SANJOSE_IF_IFDESCR_MAP.put(8559, "pfe-1/1/0");
        SANJOSE_IF_IFNAME_MAP.put(528, "ge-1/1/0");
        SANJOSE_IF_IFDESCR_MAP.put(528, "ge-1/1/0");
        SANJOSE_IF_MAC_MAP.put(528, "002283d8533a");
        SANJOSE_IF_IFNAME_MAP.put(541, "ge-1/2/1");
        SANJOSE_IF_IFDESCR_MAP.put(541, "ge-1/2/1");
        SANJOSE_IF_MAC_MAP.put(541, "002283d853e0");
        SANJOSE_IF_IFNAME_MAP.put(532, "ge-1/1/4");
        SANJOSE_IF_IFDESCR_MAP.put(532, "ge-1/1/4");
        SANJOSE_IF_MAC_MAP.put(532, "002283d8533e");
        SANJOSE_IF_IFNAME_MAP.put(549, "ge-1/2/9");
        SANJOSE_IF_IFDESCR_MAP.put(549, "ge-1/2/9");
        SANJOSE_IF_MAC_MAP.put(549, "002283d853e8");
        SANJOSE_IF_IFNAME_MAP.put(543, "ge-1/2/3");
        SANJOSE_IF_IFDESCR_MAP.put(543, "ge-1/2/3");
        SANJOSE_IF_MAC_MAP.put(543, "002283d853e2");
        SANJOSE_IF_IFNAME_MAP.put(16, "lo0.0");
        SANJOSE_IF_IFDESCR_MAP.put(16, "lo0.0");
        SANJOSE_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        SANJOSE_IF_IFNAME_MAP.put(542, "ge-1/2/2");
        SANJOSE_IF_IFDESCR_MAP.put(542, "ge-1/2/2");
        SANJOSE_IF_MAC_MAP.put(542, "002283d853e1");
        SANJOSE_IF_IFNAME_MAP.put(563, "lc-1/3/0.32769");
        SANJOSE_IF_IFDESCR_MAP.put(563, "lc-1/3/0.32769");
        SANJOSE_IF_IFNAME_MAP.put(544, "ge-1/2/4");
        SANJOSE_IF_IFDESCR_MAP.put(544, "ge-1/2/4");
        SANJOSE_IF_MAC_MAP.put(544, "002283d853e3");
        SANJOSE_IF_IFNAME_MAP.put(6, "lo0");
        SANJOSE_IF_IFDESCR_MAP.put(6, "lo0");
        SANJOSE_IF_IFNAME_MAP.put(5, "dsc");
        SANJOSE_IF_IFDESCR_MAP.put(5, "dsc");
        SANJOSE_IF_IFNAME_MAP.put(554, "ge-1/3/2");
        SANJOSE_IF_IFDESCR_MAP.put(554, "ge-1/3/2");
        SANJOSE_IF_MAC_MAP.put(554, "002283d85486");
        SANJOSE_IF_IFNAME_MAP.put(545, "ge-1/2/5");
        SANJOSE_IF_IFDESCR_MAP.put(545, "ge-1/2/5");
        SANJOSE_IF_MAC_MAP.put(545, "002283d853e4");
        SANJOSE_IF_IFNAME_MAP.put(520, "ge-1/0/4");
        SANJOSE_IF_IFDESCR_MAP.put(520, "ge-1/0/4");
        SANJOSE_IF_MAC_MAP.put(520, "002283d85299");
        SANJOSE_IF_IFNAME_MAP.put(505, "irb");
        SANJOSE_IF_IFDESCR_MAP.put(505, "irb");
        SANJOSE_IF_MAC_MAP.put(505, "002283d857f0");
        SANJOSE_IF_IFNAME_MAP.put(550, "lc-1/2/0");
        SANJOSE_IF_IFDESCR_MAP.put(550, "lc-1/2/0");
        SANJOSE_IF_IFNAME_MAP.put(13, "fxp0.0");
        SANJOSE_IF_IFDESCR_MAP.put(13, "fxp0.0");
        SANJOSE_IF_MAC_MAP.put(13, "00a0a56211a7");
        SANJOSE_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.224.0"));
        SANJOSE_IF_IFNAME_MAP.put(558, "ge-1/3/6");
        SANJOSE_IF_IFDESCR_MAP.put(558, "ge-1/3/6");
        SANJOSE_IF_MAC_MAP.put(558, "002283d8548a");
        SANJOSE_IF_IFNAME_MAP.put(502, "cbp0");
        SANJOSE_IF_IFDESCR_MAP.put(502, "cbp0");
        SANJOSE_IF_MAC_MAP.put(502, "002283d85011");
        SANJOSE_IF_IFNAME_MAP.put(531, "ge-1/1/3");
        SANJOSE_IF_IFDESCR_MAP.put(531, "ge-1/1/3");
        SANJOSE_IF_MAC_MAP.put(531, "002283d8533d");
        SANJOSE_IF_IFNAME_MAP.put(24, "em1.0");
        SANJOSE_IF_IFDESCR_MAP.put(24, "em1.0");
        SANJOSE_IF_MAC_MAP.put(24, "020001000004");
        SANJOSE_IF_IFNAME_MAP.put(539, "lc-1/1/0.32769");
        SANJOSE_IF_IFDESCR_MAP.put(539, "lc-1/1/0.32769");
        SANJOSE_IF_IFNAME_MAP.put(9, "ipip");
        SANJOSE_IF_IFDESCR_MAP.put(9, "ipip");
        SANJOSE_IF_IFNAME_MAP.put(522, "ge-1/0/6");
        SANJOSE_IF_IFDESCR_MAP.put(522, "ge-1/0/6");
        SANJOSE_IF_MAC_MAP.put(522, "002283d8529b");
        SANJOSE_IF_IFNAME_MAP.put(10, "pime");
        SANJOSE_IF_IFDESCR_MAP.put(10, "pime");
        SANJOSE_IF_IFNAME_MAP.put(561, "ge-1/3/9");
        SANJOSE_IF_IFDESCR_MAP.put(561, "ge-1/3/9");
        SANJOSE_IF_MAC_MAP.put(561, "002283d8548d");
        SANJOSE_IF_IFNAME_MAP.put(504, "pp0");
        SANJOSE_IF_IFDESCR_MAP.put(504, "pp0");
        SANJOSE_IF_IFNAME_MAP.put(547, "ge-1/2/7");
        SANJOSE_IF_IFDESCR_MAP.put(547, "ge-1/2/7");
        SANJOSE_IF_MAC_MAP.put(547, "002283d853e6");
        SANJOSE_IF_IFNAME_MAP.put(8561, "pfe-1/3/0");
        SANJOSE_IF_IFDESCR_MAP.put(8561, "pfe-1/3/0");
        SANJOSE_IF_IFNAME_MAP.put(501, "demux0");
        SANJOSE_IF_IFDESCR_MAP.put(501, "demux0");
        SANJOSE_IF_IFNAME_MAP.put(530, "ge-1/1/2");
        SANJOSE_IF_IFDESCR_MAP.put(530, "ge-1/1/2");
        SANJOSE_IF_MAC_MAP.put(530, "002283d8533c");
        SANJOSE_IF_IFNAME_MAP.put(8, "gre");
        SANJOSE_IF_IFDESCR_MAP.put(8, "gre");
        SANJOSE_IF_IFNAME_MAP.put(552, "ge-1/3/0");
        SANJOSE_IF_IFDESCR_MAP.put(552, "ge-1/3/0");
        SANJOSE_IF_MAC_MAP.put(552, "002283d85484");
        SANJOSE_IF_IFNAME_MAP.put(519, "ge-1/0/3");
        SANJOSE_IF_IFDESCR_MAP.put(519, "ge-1/0/3");
        SANJOSE_IF_MAC_MAP.put(519, "002283d85298");
        SANJOSE_IF_IFNAME_MAP.put(521, "ge-1/0/5");
        SANJOSE_IF_IFDESCR_MAP.put(521, "ge-1/0/5");
        SANJOSE_IF_MAC_MAP.put(521, "002283d8529a");
        SANJOSE_IF_IFNAME_MAP.put(540, "ge-1/2/0");
        SANJOSE_IF_IFDESCR_MAP.put(540, "ge-1/2/0");
        SANJOSE_IF_MAC_MAP.put(540, "002283d853df");
        SANJOSE_IF_IFNAME_MAP.put(1, "fxp0");
        SANJOSE_IF_IFDESCR_MAP.put(1, "fxp0");
        SANJOSE_IF_MAC_MAP.put(1, "00a0a56211a7");
        SANJOSE_IF_IFNAME_MAP.put(503, "pip0");
        SANJOSE_IF_IFDESCR_MAP.put(503, "pip0");
        SANJOSE_IF_MAC_MAP.put(503, "002283d857b0");
        SANJOSE_IF_IFNAME_MAP.put(23, "em1");
        SANJOSE_IF_IFDESCR_MAP.put(23, "em1");
        SANJOSE_IF_MAC_MAP.put(23, "020001000004");
        SANJOSE_IF_IFNAME_MAP.put(562, "lc-1/3/0");
        SANJOSE_IF_IFDESCR_MAP.put(562, "lc-1/3/0");
        SANJOSE_IF_IFNAME_MAP.put(18, "em0.0");
        SANJOSE_IF_IFDESCR_MAP.put(18, "em0.0");
        SANJOSE_IF_MAC_MAP.put(18, "020000000004");
        SANJOSE_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        SANJOSE_IF_IFNAME_MAP.put(538, "lc-1/1/0");
        SANJOSE_IF_IFDESCR_MAP.put(538, "lc-1/1/0");
        SANJOSE_IF_IFNAME_MAP.put(548, "ge-1/2/8");
        SANJOSE_IF_IFDESCR_MAP.put(548, "ge-1/2/8");
        SANJOSE_IF_MAC_MAP.put(548, "002283d853e7");
        SANJOSE_IF_IFNAME_MAP.put(556, "ge-1/3/4");
        SANJOSE_IF_IFDESCR_MAP.put(556, "ge-1/3/4");
        SANJOSE_IF_MAC_MAP.put(556, "002283d85488");
        SANJOSE_IF_IFNAME_MAP.put(536, "ge-1/1/8");
        SANJOSE_IF_IFDESCR_MAP.put(536, "ge-1/1/8");
        SANJOSE_IF_MAC_MAP.put(536, "002283d85342");
        SANJOSE_IF_IFNAME_MAP.put(557, "ge-1/3/5");
        SANJOSE_IF_IFDESCR_MAP.put(557, "ge-1/3/5");
        SANJOSE_IF_MAC_MAP.put(557, "002283d85489");
        SANJOSE_IF_IFNAME_MAP.put(535, "ge-1/1/7");
        SANJOSE_IF_IFDESCR_MAP.put(535, "ge-1/1/7");
        SANJOSE_IF_MAC_MAP.put(535, "002283d85341");
        SANJOSE_IF_IFNAME_MAP.put(11, "pimd");
        SANJOSE_IF_IFDESCR_MAP.put(11, "pimd");
        SANJOSE_IF_IFNAME_MAP.put(526, "lc-1/0/0");
        SANJOSE_IF_IFDESCR_MAP.put(526, "lc-1/0/0");
        RIOVISTA_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.16"), 38);
        RIOVISTA_IP_IF_MAP.put(InetAddressUtils.addr("10.155.69.107"), 34);
        RIOVISTA_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.32"), 38);
        RIOVISTA_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.127"), 502);
        RIOVISTA_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 38);
        RIOVISTA_IF_IFNAME_MAP.put(532, "ge-0/0/36");
        RIOVISTA_IF_IFDESCR_MAP.put(532, "ge-0/0/36");
        RIOVISTA_IF_MAC_MAP.put(532, "001f12373de4");
        RIOVISTA_IF_IFNAME_MAP.put(579, "vlan");
        RIOVISTA_IF_IFDESCR_MAP.put(579, "vlan");
        RIOVISTA_IF_MAC_MAP.put(579, "001f12373dc0");
        RIOVISTA_IF_IFNAME_MAP.put(11, "pimd");
        RIOVISTA_IF_IFDESCR_MAP.put(11, "pimd");
        RIOVISTA_IF_IFNAME_MAP.put(12, "mtun");
        RIOVISTA_IF_IFDESCR_MAP.put(12, "mtun");
        RIOVISTA_IF_IFNAME_MAP.put(542, "ge-0/0/28");
        RIOVISTA_IF_IFDESCR_MAP.put(542, "ge-0/0/28");
        RIOVISTA_IF_MAC_MAP.put(542, "001f12373ddc");
        RIOVISTA_IF_IFNAME_MAP.put(550, "ge-0/0/43");
        RIOVISTA_IF_IFDESCR_MAP.put(550, "ge-0/0/43");
        RIOVISTA_IF_MAC_MAP.put(550, "001f12373deb");
        RIOVISTA_IF_IFNAME_MAP.put(501, "jsrv");
        RIOVISTA_IF_IFDESCR_MAP.put(501, "jsrv");
        RIOVISTA_IF_MAC_MAP.put(501, "001f12373dc0");
        RIOVISTA_IF_IFNAME_MAP.put(541, "ge-0/0/27");
        RIOVISTA_IF_IFDESCR_MAP.put(541, "ge-0/0/27");
        RIOVISTA_IF_MAC_MAP.put(541, "001f12373ddb");
        RIOVISTA_IF_IFNAME_MAP.put(526, "ge-0/0/13");
        RIOVISTA_IF_IFDESCR_MAP.put(526, "ge-0/0/13");
        RIOVISTA_IF_MAC_MAP.put(526, "001f12373dcd");
        RIOVISTA_IF_IFNAME_MAP.put(533, "ge-0/0/37");
        RIOVISTA_IF_IFDESCR_MAP.put(533, "ge-0/0/37");
        RIOVISTA_IF_MAC_MAP.put(533, "001f12373de5");
        RIOVISTA_IF_IFNAME_MAP.put(520, "ge-0/0/10");
        RIOVISTA_IF_IFDESCR_MAP.put(520, "ge-0/0/10");
        RIOVISTA_IF_MAC_MAP.put(520, "001f12373dca");
        RIOVISTA_IF_IFNAME_MAP.put(536, "ge-0/0/23");
        RIOVISTA_IF_IFDESCR_MAP.put(536, "ge-0/0/23");
        RIOVISTA_IF_MAC_MAP.put(536, "001f12373dd7");
        RIOVISTA_IF_IFNAME_MAP.put(548, "ge-0/0/41");
        RIOVISTA_IF_IFDESCR_MAP.put(548, "ge-0/0/41");
        RIOVISTA_IF_MAC_MAP.put(548, "001f12373de9");
        RIOVISTA_IF_IFNAME_MAP.put(514, "ge-0/0/7");
        RIOVISTA_IF_IFDESCR_MAP.put(514, "ge-0/0/7");
        RIOVISTA_IF_MAC_MAP.put(514, "001f12373dc7");
        RIOVISTA_IF_IFNAME_MAP.put(511, "ge-0/0/14");
        RIOVISTA_IF_IFDESCR_MAP.put(511, "ge-0/0/14");
        RIOVISTA_IF_MAC_MAP.put(511, "001f12373dce");
        RIOVISTA_IF_IFNAME_MAP.put(525, "ge-0/0/21");
        RIOVISTA_IF_IFDESCR_MAP.put(525, "ge-0/0/21");
        RIOVISTA_IF_MAC_MAP.put(525, "001f12373dd5");
        RIOVISTA_IF_IFNAME_MAP.put(540, "ge-0/0/26");
        RIOVISTA_IF_IFDESCR_MAP.put(540, "ge-0/0/26");
        RIOVISTA_IF_MAC_MAP.put(540, "001f12373dda");
        RIOVISTA_IF_IFNAME_MAP.put(516, "ge-0/0/8");
        RIOVISTA_IF_IFDESCR_MAP.put(516, "ge-0/0/8");
        RIOVISTA_IF_MAC_MAP.put(516, "001f12373dc8");
        RIOVISTA_IF_IFNAME_MAP.put(584, "ge-0/0/0.0");
        RIOVISTA_IF_IFDESCR_MAP.put(584, "ge-0/0/0.0");
        RIOVISTA_IF_MAC_MAP.put(584, "001f12373dc0");
        RIOVISTA_IF_IFNAME_MAP.put(546, "ge-0/0/39");
        RIOVISTA_IF_IFDESCR_MAP.put(546, "ge-0/0/39");
        RIOVISTA_IF_MAC_MAP.put(546, "001f12373de7");
        RIOVISTA_IF_IFNAME_MAP.put(50, "vcp-0.32768");
        RIOVISTA_IF_IFDESCR_MAP.put(50, "vcp-0.32768");
        RIOVISTA_IF_IFNAME_MAP.put(518, "ge-0/0/9");
        RIOVISTA_IF_IFDESCR_MAP.put(518, "ge-0/0/9");
        RIOVISTA_IF_MAC_MAP.put(518, "001f12373dc9");
        RIOVISTA_IF_IFNAME_MAP.put(38, "bme0.32768");
        RIOVISTA_IF_IFDESCR_MAP.put(38, "bme0.32768");
        RIOVISTA_IF_MAC_MAP.put(38, "000bcafe0000");
        RIOVISTA_IF_NETMASK_MAP.put(38, InetAddressUtils.addr("192.0.0.0"));
        RIOVISTA_IF_IFNAME_MAP.put(33, "me0");
        RIOVISTA_IF_IFDESCR_MAP.put(33, "me0");
        RIOVISTA_IF_MAC_MAP.put(33, "001f12373e3f");
        RIOVISTA_IF_IFNAME_MAP.put(519, "ge-0/0/18");
        RIOVISTA_IF_IFDESCR_MAP.put(519, "ge-0/0/18");
        RIOVISTA_IF_MAC_MAP.put(519, "001f12373dd2");
        RIOVISTA_IF_IFNAME_MAP.put(515, "ge-0/0/16");
        RIOVISTA_IF_IFDESCR_MAP.put(515, "ge-0/0/16");
        RIOVISTA_IF_MAC_MAP.put(515, "001f12373dd0");
        RIOVISTA_IF_IFNAME_MAP.put(512, "ge-0/0/6");
        RIOVISTA_IF_IFDESCR_MAP.put(512, "ge-0/0/6");
        RIOVISTA_IF_MAC_MAP.put(512, "001f12373dc6");
        RIOVISTA_IF_IFNAME_MAP.put(539, "ge-0/0/25");
        RIOVISTA_IF_IFDESCR_MAP.put(539, "ge-0/0/25");
        RIOVISTA_IF_MAC_MAP.put(539, "001f12373dd9");
        RIOVISTA_IF_IFNAME_MAP.put(517, "ge-0/0/17");
        RIOVISTA_IF_IFDESCR_MAP.put(517, "ge-0/0/17");
        RIOVISTA_IF_MAC_MAP.put(517, "001f12373dd1");
        RIOVISTA_IF_IFNAME_MAP.put(547, "ge-0/0/40");
        RIOVISTA_IF_IFDESCR_MAP.put(547, "ge-0/0/40");
        RIOVISTA_IF_MAC_MAP.put(547, "001f12373de8");
        RIOVISTA_IF_IFNAME_MAP.put(529, "ge-0/0/33");
        RIOVISTA_IF_IFDESCR_MAP.put(529, "ge-0/0/33");
        RIOVISTA_IF_MAC_MAP.put(529, "001f12373de1");
        RIOVISTA_IF_IFNAME_MAP.put(528, "ge-0/0/32");
        RIOVISTA_IF_IFDESCR_MAP.put(528, "ge-0/0/32");
        RIOVISTA_IF_MAC_MAP.put(528, "001f12373de0");
        RIOVISTA_IF_IFNAME_MAP.put(8, "gre");
        RIOVISTA_IF_IFDESCR_MAP.put(8, "gre");
        RIOVISTA_IF_IFNAME_MAP.put(52, "vcp-1.32768");
        RIOVISTA_IF_IFDESCR_MAP.put(52, "vcp-1.32768");
        RIOVISTA_IF_IFNAME_MAP.put(544, "ge-0/0/30");
        RIOVISTA_IF_IFDESCR_MAP.put(544, "ge-0/0/30");
        RIOVISTA_IF_MAC_MAP.put(544, "001f12373dde");
        RIOVISTA_IF_IFNAME_MAP.put(4, "lsi");
        RIOVISTA_IF_IFDESCR_MAP.put(4, "lsi");
        RIOVISTA_IF_IFNAME_MAP.put(552, "ge-0/0/45");
        RIOVISTA_IF_IFDESCR_MAP.put(552, "ge-0/0/45");
        RIOVISTA_IF_MAC_MAP.put(552, "001f12373ded");
        RIOVISTA_IF_IFNAME_MAP.put(506, "ge-0/0/3");
        RIOVISTA_IF_IFDESCR_MAP.put(506, "ge-0/0/3");
        RIOVISTA_IF_MAC_MAP.put(506, "001f12373dc3");
        RIOVISTA_IF_IFNAME_MAP.put(37, "bme0");
        RIOVISTA_IF_IFDESCR_MAP.put(37, "bme0");
        RIOVISTA_IF_MAC_MAP.put(37, "000bcafe0000");
        RIOVISTA_IF_IFNAME_MAP.put(49, "vcp-0");
        RIOVISTA_IF_IFDESCR_MAP.put(49, "vcp-0");
        RIOVISTA_IF_IFNAME_MAP.put(503, "ge-0/0/46.0");
        RIOVISTA_IF_IFDESCR_MAP.put(503, "ge-0/0/46.0");
        RIOVISTA_IF_MAC_MAP.put(503, "001f12373dee");
        RIOVISTA_IF_IFNAME_MAP.put(9, "ipip");
        RIOVISTA_IF_IFDESCR_MAP.put(9, "ipip");
        RIOVISTA_IF_IFNAME_MAP.put(531, "ge-0/0/35");
        RIOVISTA_IF_IFDESCR_MAP.put(531, "ge-0/0/35");
        RIOVISTA_IF_MAC_MAP.put(531, "001f12373de3");
        RIOVISTA_IF_IFNAME_MAP.put(523, "ge-0/0/20");
        RIOVISTA_IF_IFDESCR_MAP.put(523, "ge-0/0/20");
        RIOVISTA_IF_MAC_MAP.put(523, "001f12373dd4");
        RIOVISTA_IF_IFNAME_MAP.put(521, "ge-0/0/19");
        RIOVISTA_IF_IFDESCR_MAP.put(521, "ge-0/0/19");
        RIOVISTA_IF_MAC_MAP.put(521, "001f12373dd3");
        RIOVISTA_IF_IFNAME_MAP.put(535, "ge-0/0/22");
        RIOVISTA_IF_IFDESCR_MAP.put(535, "ge-0/0/22");
        RIOVISTA_IF_MAC_MAP.put(535, "001f12373dd6");
        RIOVISTA_IF_IFNAME_MAP.put(34, "me0.0");
        RIOVISTA_IF_IFDESCR_MAP.put(34, "me0.0");
        RIOVISTA_IF_MAC_MAP.put(34, "001f12373e3f");
        RIOVISTA_IF_NETMASK_MAP.put(34, InetAddressUtils.addr("255.255.224.0"));
        RIOVISTA_IF_IFNAME_MAP.put(538, "ge-0/0/24");
        RIOVISTA_IF_IFDESCR_MAP.put(538, "ge-0/0/24");
        RIOVISTA_IF_MAC_MAP.put(538, "001f12373dd8");
        RIOVISTA_IF_IFNAME_MAP.put(5, "dsc");
        RIOVISTA_IF_IFDESCR_MAP.put(5, "dsc");
        RIOVISTA_IF_IFNAME_MAP.put(10, "pime");
        RIOVISTA_IF_IFDESCR_MAP.put(10, "pime");
        RIOVISTA_IF_IFNAME_MAP.put(522, "ge-0/0/11");
        RIOVISTA_IF_IFDESCR_MAP.put(522, "ge-0/0/11");
        RIOVISTA_IF_MAC_MAP.put(522, "001f12373dcb");
        RIOVISTA_IF_IFNAME_MAP.put(510, "ge-0/0/5");
        RIOVISTA_IF_IFDESCR_MAP.put(510, "ge-0/0/5");
        RIOVISTA_IF_MAC_MAP.put(510, "001f12373dc5");
        RIOVISTA_IF_IFNAME_MAP.put(7, "tap");
        RIOVISTA_IF_IFDESCR_MAP.put(7, "tap");
        RIOVISTA_IF_IFNAME_MAP.put(527, "ge-0/0/31");
        RIOVISTA_IF_IFDESCR_MAP.put(527, "ge-0/0/31");
        RIOVISTA_IF_MAC_MAP.put(527, "001f12373ddf");
        RIOVISTA_IF_IFNAME_MAP.put(502, "jsrv.1");
        RIOVISTA_IF_IFDESCR_MAP.put(502, "jsrv.1");
        RIOVISTA_IF_MAC_MAP.put(502, "001f12373dc0");
        RIOVISTA_IF_NETMASK_MAP.put(502, InetAddressUtils.addr("192.0.0.0"));
        RIOVISTA_IF_IFNAME_MAP.put(549, "ge-0/0/42");
        RIOVISTA_IF_IFDESCR_MAP.put(549, "ge-0/0/42");
        RIOVISTA_IF_MAC_MAP.put(549, "001f12373dea");
        RIOVISTA_IF_IFNAME_MAP.put(35, "vme");
        RIOVISTA_IF_IFDESCR_MAP.put(35, "vme");
        RIOVISTA_IF_MAC_MAP.put(35, "001f12373dc1");
        RIOVISTA_IF_IFNAME_MAP.put(51, "vcp-1");
        RIOVISTA_IF_IFDESCR_MAP.put(51, "vcp-1");
        RIOVISTA_IF_IFNAME_MAP.put(530, "ge-0/0/34");
        RIOVISTA_IF_IFDESCR_MAP.put(530, "ge-0/0/34");
        RIOVISTA_IF_MAC_MAP.put(530, "001f12373de2");
        RIOVISTA_IF_IFNAME_MAP.put(504, "ge-0/0/2");
        RIOVISTA_IF_IFDESCR_MAP.put(504, "ge-0/0/2");
        RIOVISTA_IF_MAC_MAP.put(504, "001f12373dc2");
        RIOVISTA_IF_IFNAME_MAP.put(554, "ge-0/0/47");
        RIOVISTA_IF_IFDESCR_MAP.put(554, "ge-0/0/47");
        RIOVISTA_IF_MAC_MAP.put(554, "001f12373def");
        RIOVISTA_IF_IFNAME_MAP.put(534, "ge-0/0/1");
        RIOVISTA_IF_IFDESCR_MAP.put(534, "ge-0/0/1");
        RIOVISTA_IF_MAC_MAP.put(534, "001f12373dc1");
        RIOVISTA_IF_IFNAME_MAP.put(524, "ge-0/0/12");
        RIOVISTA_IF_IFDESCR_MAP.put(524, "ge-0/0/12");
        RIOVISTA_IF_MAC_MAP.put(524, "001f12373dcc");
        RIOVISTA_IF_IFNAME_MAP.put(551, "ge-0/0/44");
        RIOVISTA_IF_IFDESCR_MAP.put(551, "ge-0/0/44");
        RIOVISTA_IF_MAC_MAP.put(551, "001f12373dec");
        RIOVISTA_IF_IFNAME_MAP.put(581, "ge-0/0/0");
        RIOVISTA_IF_IFDESCR_MAP.put(581, "ge-0/0/0");
        RIOVISTA_IF_MAC_MAP.put(581, "001f12373dc0");
        RIOVISTA_IF_IFNAME_MAP.put(543, "ge-0/0/29");
        RIOVISTA_IF_IFDESCR_MAP.put(543, "ge-0/0/29");
        RIOVISTA_IF_MAC_MAP.put(543, "001f12373ddd");
        RIOVISTA_IF_IFNAME_MAP.put(508, "ge-0/0/4");
        RIOVISTA_IF_IFDESCR_MAP.put(508, "ge-0/0/4");
        RIOVISTA_IF_MAC_MAP.put(508, "001f12373dc4");
        RIOVISTA_IF_IFNAME_MAP.put(553, "ge-0/0/46");
        RIOVISTA_IF_IFDESCR_MAP.put(553, "ge-0/0/46");
        RIOVISTA_IF_MAC_MAP.put(553, "001f12373dee");
        RIOVISTA_IF_IFNAME_MAP.put(6, "lo0");
        RIOVISTA_IF_IFDESCR_MAP.put(6, "lo0");
        RIOVISTA_IF_IFNAME_MAP.put(545, "ge-0/0/38");
        RIOVISTA_IF_IFDESCR_MAP.put(545, "ge-0/0/38");
        RIOVISTA_IF_MAC_MAP.put(545, "001f12373de6");
        RIOVISTA_IF_IFNAME_MAP.put(513, "ge-0/0/15");
        RIOVISTA_IF_IFDESCR_MAP.put(513, "ge-0/0/15");
        RIOVISTA_IF_MAC_MAP.put(513, "001f12373dcf");
    }

    /**
     * Gets the penrose.
     *
     * @return the penrose
     */
    protected OnmsNode getPenrose() {
        return getNode(PENROSE_NAME, PENROSE_SYSOID, PENROSE_IP, PENROSE_IP_IF_MAP, PENROSE_IF_IFNAME_MAP,
                       PENROSE_IF_MAC_MAP, PENROSE_IF_IFDESCR_MAP, PENROSE_IF_IFALIAS_MAP, PENROSE_IF_NETMASK_MAP);
    }

    /**
     * Gets the delaware.
     *
     * @return the delaware
     */
    protected OnmsNode getDelaware() {
        return getNode(DELAWARE_NAME, DELAWARE_SYSOID, DELAWARE_IP, DELAWARE_IP_IF_MAP, DELAWARE_IF_IFNAME_MAP,
                       DELAWARE_IF_MAC_MAP, DELAWARE_IF_IFDESCR_MAP, DELAWARE_IF_IFALIAS_MAP, DELAWARE_IF_NETMASK_MAP);
    }

    /**
     * Gets the phoenix.
     *
     * @return the phoenix
     */
    protected OnmsNode getPhoenix() {
        return getNode(PHOENIX_NAME, PHOENIX_SYSOID, PHOENIX_IP, PHOENIX_IP_IF_MAP, PHOENIX_IF_IFNAME_MAP,
                       PHOENIX_IF_MAC_MAP, PHOENIX_IF_IFDESCR_MAP, PHOENIX_IF_IFALIAS_MAP, PHOENIX_IF_NETMASK_MAP);
    }

    /**
     * Gets the austin.
     *
     * @return the austin
     */
    protected OnmsNode getAustin() {
        return getNode(AUSTIN_NAME, AUSTIN_SYSOID, AUSTIN_IP, AUSTIN_IP_IF_MAP, AUSTIN_IF_IFNAME_MAP,
                       AUSTIN_IF_MAC_MAP, AUSTIN_IF_IFDESCR_MAP, AUSTIN_IF_IFALIAS_MAP, AUSTIN_IF_NETMASK_MAP);
    }

    /**
     * Gets the sanjose.
     *
     * @return the sanjose
     */
    protected OnmsNode getSanjose() {
        return getNode(SANJOSE_NAME, SANJOSE_SYSOID, SANJOSE_IP, SANJOSE_IP_IF_MAP, SANJOSE_IF_IFNAME_MAP,
                       SANJOSE_IF_MAC_MAP, SANJOSE_IF_IFDESCR_MAP, SANJOSE_IF_IFALIAS_MAP, SANJOSE_IF_NETMASK_MAP);
    }

    /**
     * Gets the riovista.
     *
     * @return the riovista
     */
    protected OnmsNode getRiovista() {
        return getNode(RIOVISTA_NAME, RIOVISTA_SYSOID, RIOVISTA_IP, RIOVISTA_IP_IF_MAP, RIOVISTA_IF_IFNAME_MAP,
                       RIOVISTA_IF_MAC_MAP, RIOVISTA_IF_IFDESCR_MAP, RIOVISTA_IF_IFALIAS_MAP, RIOVISTA_IF_NETMASK_MAP);
    }

}
