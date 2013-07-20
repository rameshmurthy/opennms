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
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @author <a href="mailto:antonio@opennme.it">Antonio Russo</a>
 * @author <a href="mailto:alejandro@opennms.org">Alejandro Galue</a>
 */

public abstract class Nms10205bNetworkBuilder extends LinkdNetworkBuilder {

    protected static final String MUMBAI_IP = "10.205.56.5";

    protected static final String MUMBAI_NAME = "Mumbai";

    static final String MUMBAI_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.9";

    protected static final Map<InetAddress, Integer> MUMBAI_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> MUMBAI_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MUMBAI_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MUMBAI_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MUMBAI_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> MUMBAI_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String DELHI_IP = "10.205.56.7";

    protected static final String DELHI_NAME = "Delhi";

    static final String DELHI_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.29";

    protected static final Map<InetAddress, Integer> DELHI_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> DELHI_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> DELHI_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> DELHI_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> DELHI_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> DELHI_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String BANGALORE_IP = "10.205.56.9";

    protected static final String BANGALORE_NAME = "Bangalore";

    static final String BANGALORE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.10";

    protected static final Map<InetAddress, Integer> BANGALORE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> BANGALORE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BANGALORE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BANGALORE_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BANGALORE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> BANGALORE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String MYSORE_IP = "10.205.56.22";

    protected static final String MYSORE_NAME = "Mysore";

    static final String MYSORE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.11";

    protected static final Map<InetAddress, Integer> MYSORE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> MYSORE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MYSORE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MYSORE_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> MYSORE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> MYSORE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String BAGMANE_IP = "10.205.56.20";

    protected static final String BAGMANE_NAME = "Bagmane";

    static final String BAGMANE_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.57";

    protected static final Map<InetAddress, Integer> BAGMANE_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> BAGMANE_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BAGMANE_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BAGMANE_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> BAGMANE_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> BAGMANE_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String SPACE_EX_SW1_IP = "10.205.56.1";

    protected static final String SPACE_EX_SW1_NAME = "Space-EX-SW1";

    static final String SPACE_EX_SW1_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.30";

    protected static final Map<InetAddress, Integer> SPACE_EX_SW1_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> SPACE_EX_SW1_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW1_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW1_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW1_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> SPACE_EX_SW1_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String SPACE_EX_SW2_IP = "10.205.56.2";

    protected static final String SPACE_EX_SW2_NAME = "Space-EX-SW2";

    static final String SPACE_EX_SW2_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.31";

    static final Map<InetAddress, Integer> SPACE_EX_SW2_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> SPACE_EX_SW2_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW2_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW2_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SPACE_EX_SW2_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> SPACE_EX_SW2_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String J6350_42_IP = "10.205.56.42";

    protected static final String J6350_42_NAME = "J6350-2";

    static final String J6350_42_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.20";

    protected static final String J6350_42_LLDP_CHASSISID = "2c6bf55dc100";

    static final Map<InetAddress, Integer> J6350_42_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> J6350_42_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> J6350_42_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> J6350_42_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> J6350_42_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> J6350_42_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected static final String SRX_100_IP = "10.205.56.23";

    protected static final String SRX_100_NAME = "SRX_56.23";

    static final String SRX_100_SYSOID = ".1.3.6.1.4.1.2636.1.1.1.2.41";

    static final Map<InetAddress, Integer> SRX_100_IP_IF_MAP = new HashMap<InetAddress, Integer>();

    static final Map<Integer, String> SRX_100_IF_IFNAME_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SRX_100_IF_IFDESCR_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SRX_100_IF_MAC_MAP = new HashMap<Integer, String>();

    static final Map<Integer, String> SRX_100_IF_IFALIAS_MAP = new HashMap<Integer, String>();

    static final Map<Integer, InetAddress> SRX_100_IF_NETMASK_MAP = new HashMap<Integer, InetAddress>();

    protected OnmsNode getMumbai() {
        return getNode(MUMBAI_NAME, MUMBAI_SYSOID, MUMBAI_IP, MUMBAI_IP_IF_MAP, MUMBAI_IF_IFNAME_MAP,
                       MUMBAI_IF_MAC_MAP, MUMBAI_IF_IFDESCR_MAP, MUMBAI_IF_IFALIAS_MAP, MUMBAI_IF_NETMASK_MAP);
    }

    protected OnmsNode getDelhi() {
        return getNode(DELHI_NAME, DELHI_SYSOID, DELHI_IP, DELHI_IP_IF_MAP, DELHI_IF_IFNAME_MAP, DELHI_IF_MAC_MAP,
                       DELHI_IF_IFDESCR_MAP, DELHI_IF_IFALIAS_MAP, DELHI_IF_NETMASK_MAP);
    }

    protected OnmsNode getBangalore() {
        return getNode(BANGALORE_NAME, BANGALORE_SYSOID, BANGALORE_IP, BANGALORE_IP_IF_MAP, BANGALORE_IF_IFNAME_MAP,
                       BANGALORE_IF_MAC_MAP, BANGALORE_IF_IFDESCR_MAP, BANGALORE_IF_IFALIAS_MAP,
                       BANGALORE_IF_NETMASK_MAP);
    }

    protected OnmsNode getBagmane() {
        return getNode(BAGMANE_NAME, BAGMANE_SYSOID, BAGMANE_IP, BAGMANE_IP_IF_MAP, BAGMANE_IF_IFNAME_MAP,
                       BAGMANE_IF_MAC_MAP, BAGMANE_IF_IFDESCR_MAP, BAGMANE_IF_IFALIAS_MAP, BAGMANE_IF_NETMASK_MAP);
    }

    protected OnmsNode getMysore() {
        return getNode(MYSORE_NAME, MYSORE_SYSOID, MYSORE_IP, MYSORE_IP_IF_MAP, MYSORE_IF_IFNAME_MAP,
                       MYSORE_IF_MAC_MAP, MYSORE_IF_IFDESCR_MAP, MYSORE_IF_IFALIAS_MAP, MYSORE_IF_NETMASK_MAP);
    }

    protected OnmsNode getSpaceExSw1() {
        return getNode(SPACE_EX_SW1_NAME, SPACE_EX_SW1_SYSOID, SPACE_EX_SW1_IP, SPACE_EX_SW1_IP_IF_MAP,
                       SPACE_EX_SW1_IF_IFNAME_MAP, SPACE_EX_SW1_IF_MAC_MAP, SPACE_EX_SW1_IF_IFDESCR_MAP,
                       SPACE_EX_SW1_IF_IFALIAS_MAP, SPACE_EX_SW1_IF_NETMASK_MAP);
    }

    protected OnmsNode getSpaceExSw2() {
        return getNode(SPACE_EX_SW2_NAME, SPACE_EX_SW2_SYSOID, SPACE_EX_SW2_IP, SPACE_EX_SW2_IP_IF_MAP,
                       SPACE_EX_SW2_IF_IFNAME_MAP, SPACE_EX_SW2_IF_MAC_MAP, SPACE_EX_SW2_IF_IFDESCR_MAP,
                       SPACE_EX_SW2_IF_IFALIAS_MAP, SPACE_EX_SW2_IF_NETMASK_MAP);
    }

    protected OnmsNode getJ635042() {
        return getNode(J6350_42_NAME, J6350_42_SYSOID, J6350_42_IP, J6350_42_IP_IF_MAP, J6350_42_IF_IFNAME_MAP,
                       J6350_42_IF_MAC_MAP, J6350_42_IF_IFDESCR_MAP, J6350_42_IF_IFALIAS_MAP, J6350_42_IF_NETMASK_MAP);
    }

    protected OnmsNode getSRX100() {
        return getNode(SRX_100_NAME, SRX_100_SYSOID, SRX_100_IP, SRX_100_IP_IF_MAP, SRX_100_IF_IFNAME_MAP,
                       SRX_100_IF_MAC_MAP, SRX_100_IF_IFDESCR_MAP, SRX_100_IF_IFALIAS_MAP, SRX_100_IF_NETMASK_MAP);
    }

    static {
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.10"), 1732);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.42"), 656);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.20.1"), 16);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.18"), 534);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.22"), 1729);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("172.16.20.1"), 540);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.20"), 535);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        BAGMANE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.13"), 654);
        BAGMANE_IF_IFNAME_MAP.put(501, "demux0");
        BAGMANE_IF_IFDESCR_MAP.put(501, "demux0");
        BAGMANE_IF_IFNAME_MAP.put(502, "cbp0");
        BAGMANE_IF_IFDESCR_MAP.put(502, "cbp0");
        BAGMANE_IF_MAC_MAP.put(502, "80711fc70f11");
        BAGMANE_IF_IFNAME_MAP.put(4, "lsi");
        BAGMANE_IF_IFDESCR_MAP.put(4, "lsi");
        BAGMANE_IF_IFNAME_MAP.put(1729, "ge-1/0/1.0");
        BAGMANE_IF_IFDESCR_MAP.put(1729, "ge-1/0/1.0");
        BAGMANE_IF_MAC_MAP.put(1729, "80711fc70f61");
        BAGMANE_IF_NETMASK_MAP.put(1729, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(655, "ge-1/0/6.0");
        BAGMANE_IF_IFDESCR_MAP.put(655, "ge-1/0/6.0");
        BAGMANE_IF_MAC_MAP.put(655, "80711fc70f66");
        BAGMANE_IF_IFNAME_MAP.put(508, "xe-0/0/0");
        BAGMANE_IF_IFDESCR_MAP.put(508, "xe-0/0/0");
        BAGMANE_IF_MAC_MAP.put(508, "80711fc70f00");
        BAGMANE_IF_IFNAME_MAP.put(516, "ge-1/0/4");
        BAGMANE_IF_IFDESCR_MAP.put(516, "ge-1/0/4");
        BAGMANE_IF_MAC_MAP.put(516, "80711fc70f64");
        BAGMANE_IF_IFALIAS_MAP.put(516, "TO-BANGALORE");
        BAGMANE_IF_IFNAME_MAP.put(8, "gre");
        BAGMANE_IF_IFDESCR_MAP.put(8, "gre");
        BAGMANE_IF_IFNAME_MAP.put(518, "ge-1/0/6");
        BAGMANE_IF_IFDESCR_MAP.put(518, "ge-1/0/6");
        BAGMANE_IF_MAC_MAP.put(518, "80711fc70f66");
        BAGMANE_IF_IFNAME_MAP.put(16, "lo0.0");
        BAGMANE_IF_IFDESCR_MAP.put(16, "lo0.0");
        BAGMANE_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        BAGMANE_IF_IFNAME_MAP.put(530, "ge-1/1/8");
        BAGMANE_IF_IFDESCR_MAP.put(530, "ge-1/1/8");
        BAGMANE_IF_MAC_MAP.put(530, "80711fc70f80");
        BAGMANE_IF_IFNAME_MAP.put(505, "irb");
        BAGMANE_IF_IFDESCR_MAP.put(505, "irb");
        BAGMANE_IF_MAC_MAP.put(505, "80711fc70ff0");
        BAGMANE_IF_IFNAME_MAP.put(533, "xe-1/3/0");
        BAGMANE_IF_IFDESCR_MAP.put(533, "xe-1/3/0");
        BAGMANE_IF_MAC_MAP.put(533, "80711fc70fa8");
        BAGMANE_IF_IFNAME_MAP.put(525, "ge-1/1/3");
        BAGMANE_IF_IFDESCR_MAP.put(525, "ge-1/1/3");
        BAGMANE_IF_MAC_MAP.put(525, "80711fc70f7b");
        BAGMANE_IF_IFNAME_MAP.put(535, "ge-1/0/3.0");
        BAGMANE_IF_IFDESCR_MAP.put(535, "ge-1/0/3.0");
        BAGMANE_IF_MAC_MAP.put(535, "80711fc70f63");
        BAGMANE_IF_NETMASK_MAP.put(535, InetAddressUtils.addr("255.255.0.0"));
        BAGMANE_IF_IFNAME_MAP.put(10, "pime");
        BAGMANE_IF_IFDESCR_MAP.put(10, "pime");
        BAGMANE_IF_IFNAME_MAP.put(517, "ge-1/0/5");
        BAGMANE_IF_IFDESCR_MAP.put(517, "ge-1/0/5");
        BAGMANE_IF_MAC_MAP.put(517, "80711fc70f65");
        BAGMANE_IF_IFALIAS_MAP.put(517, "TO-MYSORE");
        BAGMANE_IF_IFNAME_MAP.put(523, "ge-1/1/1");
        BAGMANE_IF_IFDESCR_MAP.put(523, "ge-1/1/1");
        BAGMANE_IF_MAC_MAP.put(523, "80711fc70f79");
        BAGMANE_IF_IFNAME_MAP.put(536, "pfh-0/0/0");
        BAGMANE_IF_IFDESCR_MAP.put(536, "pfh-0/0/0");
        BAGMANE_IF_IFNAME_MAP.put(503, "pip0");
        BAGMANE_IF_IFDESCR_MAP.put(503, "pip0");
        BAGMANE_IF_MAC_MAP.put(503, "80711fc70fb0");
        BAGMANE_IF_IFNAME_MAP.put(524, "ge-1/1/2");
        BAGMANE_IF_IFDESCR_MAP.put(524, "ge-1/1/2");
        BAGMANE_IF_MAC_MAP.put(524, "80711fc70f7a");
        BAGMANE_IF_IFNAME_MAP.put(506, "lc-0/0/0");
        BAGMANE_IF_IFDESCR_MAP.put(506, "lc-0/0/0");
        BAGMANE_IF_IFNAME_MAP.put(528, "ge-1/1/6");
        BAGMANE_IF_IFDESCR_MAP.put(528, "ge-1/1/6");
        BAGMANE_IF_MAC_MAP.put(528, "80711fc70f7e");
        BAGMANE_IF_IFNAME_MAP.put(520, "ge-1/0/8");
        BAGMANE_IF_IFDESCR_MAP.put(520, "ge-1/0/8");
        BAGMANE_IF_MAC_MAP.put(520, "80711fc70f68");
        BAGMANE_IF_IFNAME_MAP.put(526, "ge-1/1/4");
        BAGMANE_IF_IFDESCR_MAP.put(526, "ge-1/1/4");
        BAGMANE_IF_MAC_MAP.put(526, "80711fc70f7c");
        BAGMANE_IF_IFNAME_MAP.put(654, "ge-1/0/5.0");
        BAGMANE_IF_IFDESCR_MAP.put(654, "ge-1/0/5.0");
        BAGMANE_IF_MAC_MAP.put(654, "80711fc70f65");
        BAGMANE_IF_NETMASK_MAP.put(654, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(539, "pfe-0/0/0.16383");
        BAGMANE_IF_IFDESCR_MAP.put(539, "pfe-0/0/0.16383");
        BAGMANE_IF_IFNAME_MAP.put(509, "xe-0/0/1");
        BAGMANE_IF_IFDESCR_MAP.put(509, "xe-0/0/1");
        BAGMANE_IF_MAC_MAP.put(509, "80711fc70f01");
        BAGMANE_IF_IFNAME_MAP.put(522, "ge-1/1/0");
        BAGMANE_IF_IFDESCR_MAP.put(522, "ge-1/1/0");
        BAGMANE_IF_MAC_MAP.put(522, "80711fc70f78");
        BAGMANE_IF_IFNAME_MAP.put(6, "lo0");
        BAGMANE_IF_IFDESCR_MAP.put(6, "lo0");
        BAGMANE_IF_IFNAME_MAP.put(18, "em0.0");
        BAGMANE_IF_IFDESCR_MAP.put(18, "em0.0");
        BAGMANE_IF_MAC_MAP.put(18, "020000000004");
        BAGMANE_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        BAGMANE_IF_IFNAME_MAP.put(529, "ge-1/1/7");
        BAGMANE_IF_IFDESCR_MAP.put(529, "ge-1/1/7");
        BAGMANE_IF_MAC_MAP.put(529, "80711fc70f7f");
        BAGMANE_IF_IFNAME_MAP.put(507, "lc-0/0/0.32769");
        BAGMANE_IF_IFDESCR_MAP.put(507, "lc-0/0/0.32769");
        BAGMANE_IF_IFNAME_MAP.put(7, "tap");
        BAGMANE_IF_IFDESCR_MAP.put(7, "tap");
        BAGMANE_IF_IFNAME_MAP.put(504, "pp0");
        BAGMANE_IF_IFDESCR_MAP.put(504, "pp0");
        BAGMANE_IF_IFNAME_MAP.put(510, "xe-0/0/2");
        BAGMANE_IF_IFDESCR_MAP.put(510, "xe-0/0/2");
        BAGMANE_IF_MAC_MAP.put(510, "80711fc70f02");
        BAGMANE_IF_IFNAME_MAP.put(12, "mtun");
        BAGMANE_IF_IFDESCR_MAP.put(12, "mtun");
        BAGMANE_IF_IFNAME_MAP.put(519, "ge-1/0/7");
        BAGMANE_IF_IFDESCR_MAP.put(519, "ge-1/0/7");
        BAGMANE_IF_MAC_MAP.put(519, "80711fc70f67");
        BAGMANE_IF_IFNAME_MAP.put(23, "em1");
        BAGMANE_IF_IFDESCR_MAP.put(23, "em1");
        BAGMANE_IF_MAC_MAP.put(23, "020002000004");
        BAGMANE_IF_IFNAME_MAP.put(538, "pfh-0/0/0.16383");
        BAGMANE_IF_IFDESCR_MAP.put(538, "pfh-0/0/0.16383");
        BAGMANE_IF_IFNAME_MAP.put(513, "ge-1/0/1");
        BAGMANE_IF_IFDESCR_MAP.put(513, "ge-1/0/1");
        BAGMANE_IF_MAC_MAP.put(513, "80711fc70f61");
        BAGMANE_IF_IFALIAS_MAP.put(513, "TO-DEHI");
        BAGMANE_IF_IFNAME_MAP.put(512, "ge-1/0/0");
        BAGMANE_IF_IFDESCR_MAP.put(512, "ge-1/0/0");
        BAGMANE_IF_MAC_MAP.put(512, "80711fc70f60");
        BAGMANE_IF_IFALIAS_MAP.put(512, "TO-MUMBAI");
        BAGMANE_IF_IFNAME_MAP.put(17, "em0");
        BAGMANE_IF_IFDESCR_MAP.put(17, "em0");
        BAGMANE_IF_MAC_MAP.put(17, "020000000004");
        BAGMANE_IF_IFNAME_MAP.put(9, "ipip");
        BAGMANE_IF_IFDESCR_MAP.put(9, "ipip");
        BAGMANE_IF_IFNAME_MAP.put(531, "ge-1/1/9");
        BAGMANE_IF_IFDESCR_MAP.put(531, "ge-1/1/9");
        BAGMANE_IF_MAC_MAP.put(531, "80711fc70f81");
        BAGMANE_IF_IFNAME_MAP.put(511, "xe-0/0/3");
        BAGMANE_IF_IFDESCR_MAP.put(511, "xe-0/0/3");
        BAGMANE_IF_MAC_MAP.put(511, "80711fc70f03");
        BAGMANE_IF_IFNAME_MAP.put(11, "pimd");
        BAGMANE_IF_IFDESCR_MAP.put(11, "pimd");
        BAGMANE_IF_IFNAME_MAP.put(534, "ge-1/0/0.0");
        BAGMANE_IF_IFDESCR_MAP.put(534, "ge-1/0/0.0");
        BAGMANE_IF_MAC_MAP.put(534, "80711fc70f60");
        BAGMANE_IF_NETMASK_MAP.put(534, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(514, "ge-1/0/2");
        BAGMANE_IF_IFDESCR_MAP.put(514, "ge-1/0/2");
        BAGMANE_IF_MAC_MAP.put(514, "80711fc70f62");
        BAGMANE_IF_IFALIAS_MAP.put(514, "TO-J42");
        BAGMANE_IF_IFNAME_MAP.put(33, "me0");
        BAGMANE_IF_IFDESCR_MAP.put(33, "me0");
        BAGMANE_IF_MAC_MAP.put(33, "02000000000b");
        BAGMANE_IF_IFNAME_MAP.put(521, "ge-1/0/9");
        BAGMANE_IF_IFDESCR_MAP.put(521, "ge-1/0/9");
        BAGMANE_IF_MAC_MAP.put(521, "80711fc70f69");
        BAGMANE_IF_IFNAME_MAP.put(34, "me0.0");
        BAGMANE_IF_IFDESCR_MAP.put(34, "me0.0");
        BAGMANE_IF_MAC_MAP.put(34, "02000000000b");
        BAGMANE_IF_IFNAME_MAP.put(537, "pfe-0/0/0");
        BAGMANE_IF_IFDESCR_MAP.put(537, "pfe-0/0/0");
        BAGMANE_IF_IFNAME_MAP.put(5, "dsc");
        BAGMANE_IF_IFDESCR_MAP.put(5, "dsc");
        BAGMANE_IF_IFNAME_MAP.put(1732, "ge-1/0/4.0");
        BAGMANE_IF_IFDESCR_MAP.put(1732, "ge-1/0/4.0");
        BAGMANE_IF_MAC_MAP.put(1732, "80711fc70f64");
        BAGMANE_IF_NETMASK_MAP.put(1732, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(540, "ge-1/0/2.0");
        BAGMANE_IF_IFDESCR_MAP.put(540, "ge-1/0/2.0");
        BAGMANE_IF_MAC_MAP.put(540, "80711fc70f62");
        BAGMANE_IF_NETMASK_MAP.put(540, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(656, "ge-1/1/5.0");
        BAGMANE_IF_IFDESCR_MAP.put(656, "ge-1/1/5.0");
        BAGMANE_IF_MAC_MAP.put(656, "80711fc70f7d");
        BAGMANE_IF_IFALIAS_MAP.put(656, "TO-DELHI");
        BAGMANE_IF_NETMASK_MAP.put(656, InetAddressUtils.addr("255.255.255.252"));
        BAGMANE_IF_IFNAME_MAP.put(527, "ge-1/1/5");
        BAGMANE_IF_IFDESCR_MAP.put(527, "ge-1/1/5");
        BAGMANE_IF_MAC_MAP.put(527, "80711fc70f7d");
        BAGMANE_IF_IFNAME_MAP.put(532, "xe-1/2/0");
        BAGMANE_IF_IFDESCR_MAP.put(532, "xe-1/2/0");
        BAGMANE_IF_MAC_MAP.put(532, "80711fc70f90");
        BAGMANE_IF_IFNAME_MAP.put(515, "ge-1/0/3");
        BAGMANE_IF_IFDESCR_MAP.put(515, "ge-1/0/3");
        BAGMANE_IF_MAC_MAP.put(515, "80711fc70f63");
        BAGMANE_IF_IFALIAS_MAP.put(515, "TO-QAINDIA");
        BAGMANE_IF_IFNAME_MAP.put(22, "lo0.16385");
        BAGMANE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        BAGMANE_IF_IFNAME_MAP.put(1, "fxp0");
        BAGMANE_IF_IFDESCR_MAP.put(1, "fxp0");
        BAGMANE_IF_MAC_MAP.put(1, "80711fc70fff");
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 14);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 14);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("172.16.9.1"), 2398);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.9"), 2396);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("9.1.1.1"), 2407);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("9.1.1.2"), 3350);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.9.1"), 16);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 14);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.6"), 2397);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.14"), 2401);
        BANGALORE_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.9"), 2366);
        BANGALORE_IF_IFNAME_MAP.put(2398, "ge-0/0/3.0");
        BANGALORE_IF_IFDESCR_MAP.put(2398, "ge-0/0/3.0");
        BANGALORE_IF_MAC_MAP.put(2398, "0022831d7c03");
        BANGALORE_IF_NETMASK_MAP.put(2398, InetAddressUtils.addr("255.255.255.252"));
        BANGALORE_IF_IFNAME_MAP.put(16, "lo0.0");
        BANGALORE_IF_IFDESCR_MAP.put(16, "lo0.0");
        BANGALORE_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        BANGALORE_IF_IFNAME_MAP.put(3329, "ge-0/0/3");
        BANGALORE_IF_IFDESCR_MAP.put(3329, "ge-0/0/3");
        BANGALORE_IF_MAC_MAP.put(3329, "0022831d7c03");
        BANGALORE_IF_IFNAME_MAP.put(10, "pime");
        BANGALORE_IF_IFDESCR_MAP.put(10, "pime");
        BANGALORE_IF_IFNAME_MAP.put(14, "fxp1.0");
        BANGALORE_IF_IFDESCR_MAP.put(14, "fxp1.0");
        BANGALORE_IF_MAC_MAP.put(14, "020000000004");
        BANGALORE_IF_NETMASK_MAP.put(14, InetAddressUtils.addr("255.0.0.0"));
        BANGALORE_IF_IFNAME_MAP.put(3321, "ge-0/0/1");
        BANGALORE_IF_IFDESCR_MAP.put(3321, "ge-0/0/1");
        BANGALORE_IF_MAC_MAP.put(3321, "0022831d7c01");
        BANGALORE_IF_IFALIAS_MAP.put(3321, "TO-DELHI");
        BANGALORE_IF_IFNAME_MAP.put(11, "pimd");
        BANGALORE_IF_IFDESCR_MAP.put(11, "pimd");
        BANGALORE_IF_IFNAME_MAP.put(3324, "ge-0/1/1");
        BANGALORE_IF_IFDESCR_MAP.put(3324, "ge-0/1/1");
        BANGALORE_IF_MAC_MAP.put(3324, "0022831d7c20");
        BANGALORE_IF_IFNAME_MAP.put(2, "fxp1");
        BANGALORE_IF_IFDESCR_MAP.put(2, "fxp1");
        BANGALORE_IF_MAC_MAP.put(2, "020000000004");
        BANGALORE_IF_IFNAME_MAP.put(3335, "mt-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3335, "mt-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(5, "dsc");
        BANGALORE_IF_IFDESCR_MAP.put(5, "dsc");
        BANGALORE_IF_IFNAME_MAP.put(3333, "ip-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3333, "ip-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(3331, "pe-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3331, "pe-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(2397, "ge-0/0/1.0");
        BANGALORE_IF_IFDESCR_MAP.put(2397, "ge-0/0/1.0");
        BANGALORE_IF_MAC_MAP.put(2397, "0022831d7c01");
        BANGALORE_IF_NETMASK_MAP.put(2397, InetAddressUtils.addr("255.255.255.252"));
        BANGALORE_IF_IFNAME_MAP.put(1, "fxp0");
        BANGALORE_IF_IFDESCR_MAP.put(1, "fxp0");
        BANGALORE_IF_MAC_MAP.put(1, "00a0a561e749");
        BANGALORE_IF_IFNAME_MAP.put(3339, "pc-0/1/0.16383");
        BANGALORE_IF_IFDESCR_MAP.put(3339, "pc-0/1/0.16383");
        BANGALORE_IF_IFNAME_MAP.put(7, "tap");
        BANGALORE_IF_IFDESCR_MAP.put(7, "tap");
        BANGALORE_IF_IFNAME_MAP.put(3322, "pc-0/0/0");
        BANGALORE_IF_IFDESCR_MAP.put(3322, "pc-0/0/0");
        BANGALORE_IF_IFNAME_MAP.put(3330, "pd-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3330, "pd-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(348, "ge-0/0/0");
        BANGALORE_IF_IFDESCR_MAP.put(348, "ge-0/0/0");
        BANGALORE_IF_MAC_MAP.put(348, "0022831d7c00");
        BANGALORE_IF_IFALIAS_MAP.put(348, "TO-MUMBAI");
        BANGALORE_IF_IFNAME_MAP.put(12, "mtun");
        BANGALORE_IF_IFDESCR_MAP.put(12, "mtun");
        BANGALORE_IF_IFNAME_MAP.put(2401, "ge-0/0/0.0");
        BANGALORE_IF_IFDESCR_MAP.put(2401, "ge-0/0/0.0");
        BANGALORE_IF_MAC_MAP.put(2401, "0022831d7c00");
        BANGALORE_IF_NETMASK_MAP.put(2401, InetAddressUtils.addr("255.255.255.252"));
        BANGALORE_IF_IFNAME_MAP.put(2366, "ge-0/0/2.0");
        BANGALORE_IF_IFDESCR_MAP.put(2366, "ge-0/0/2.0");
        BANGALORE_IF_MAC_MAP.put(2366, "0022831d7c02");
        BANGALORE_IF_NETMASK_MAP.put(2366, InetAddressUtils.addr("255.255.0.0"));
        BANGALORE_IF_IFNAME_MAP.put(4, "lsi");
        BANGALORE_IF_IFDESCR_MAP.put(4, "lsi");
        BANGALORE_IF_IFNAME_MAP.put(3323, "ge-0/1/0");
        BANGALORE_IF_IFDESCR_MAP.put(3323, "ge-0/1/0");
        BANGALORE_IF_MAC_MAP.put(3323, "0022831d7c1f");
        BANGALORE_IF_IFALIAS_MAP.put(3323, "TO-BAGMANE");
        BANGALORE_IF_IFNAME_MAP.put(3337, "ge-1/3/0");
        BANGALORE_IF_IFDESCR_MAP.put(3337, "ge-1/3/0");
        BANGALORE_IF_MAC_MAP.put(3337, "0022831d7cdb");
        BANGALORE_IF_IFNAME_MAP.put(9, "ipip");
        BANGALORE_IF_IFDESCR_MAP.put(9, "ipip");
        BANGALORE_IF_IFNAME_MAP.put(6, "lo0");
        BANGALORE_IF_IFDESCR_MAP.put(6, "lo0");
        BANGALORE_IF_IFNAME_MAP.put(8, "gre");
        BANGALORE_IF_IFDESCR_MAP.put(8, "gre");
        BANGALORE_IF_IFNAME_MAP.put(3334, "vt-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3334, "vt-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(3326, "ge-0/0/2");
        BANGALORE_IF_IFDESCR_MAP.put(3326, "ge-0/0/2");
        BANGALORE_IF_MAC_MAP.put(3326, "0022831d7c02");
        BANGALORE_IF_IFALIAS_MAP.put(3326, "TO-QAINDIA");
        BANGALORE_IF_IFNAME_MAP.put(3328, "pc-0/1/0");
        BANGALORE_IF_IFDESCR_MAP.put(3328, "pc-0/1/0");
        BANGALORE_IF_IFNAME_MAP.put(3332, "gr-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3332, "gr-1/2/0");
        BANGALORE_IF_IFNAME_MAP.put(2396, "ge-0/1/0.0");
        BANGALORE_IF_IFDESCR_MAP.put(2396, "ge-0/1/0.0");
        BANGALORE_IF_MAC_MAP.put(2396, "0022831d7c1f");
        BANGALORE_IF_NETMASK_MAP.put(2396, InetAddressUtils.addr("255.255.255.252"));
        BANGALORE_IF_IFNAME_MAP.put(3327, "ge-0/1/3");
        BANGALORE_IF_IFDESCR_MAP.put(3327, "ge-0/1/3");
        BANGALORE_IF_MAC_MAP.put(3327, "0022831d7c22");
        BANGALORE_IF_IFNAME_MAP.put(3336, "lt-1/2/0");
        BANGALORE_IF_IFDESCR_MAP.put(3336, "lt-1/2/0");
        BANGALORE_IF_MAC_MAP.put(3336, "0022831d7cbc");
        BANGALORE_IF_IFNAME_MAP.put(3325, "ge-0/1/2");
        BANGALORE_IF_IFDESCR_MAP.put(3325, "ge-0/1/2");
        BANGALORE_IF_MAC_MAP.put(3325, "0022831d7c21");
        BANGALORE_IF_IFNAME_MAP.put(2407, "ge-0/1/3.0");
        BANGALORE_IF_IFDESCR_MAP.put(2407, "ge-0/1/3.0");
        BANGALORE_IF_MAC_MAP.put(2407, "0022831d7c22");
        BANGALORE_IF_NETMASK_MAP.put(2407, InetAddressUtils.addr("255.255.255.255"));
        BANGALORE_IF_IFNAME_MAP.put(22, "lo0.16385");
        BANGALORE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        BANGALORE_IF_IFNAME_MAP.put(3338, "pc-0/0/0.16383");
        BANGALORE_IF_IFDESCR_MAP.put(3338, "pc-0/0/0.16383");
        BANGALORE_IF_IFNAME_MAP.put(3350, "ge-0/1/3.1");
        BANGALORE_IF_IFDESCR_MAP.put(3350, "ge-0/1/3.1");
        BANGALORE_IF_MAC_MAP.put(3350, "0022831d7c22");
        BANGALORE_IF_NETMASK_MAP.put(3350, InetAddressUtils.addr("255.255.0.0"));
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.10"), 28503);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("172.16.7.1"), 17619);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.5"), 3674);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.2"), 28514);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.21"), 29804);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.7.1"), 16);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.7"), 13);
        DELHI_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        DELHI_IF_IFNAME_MAP.put(9, "ipip");
        DELHI_IF_IFDESCR_MAP.put(9, "ipip");
        DELHI_IF_IFNAME_MAP.put(28525, "lc-1/1/0");
        DELHI_IF_IFDESCR_MAP.put(28525, "lc-1/1/0");
        DELHI_IF_IFNAME_MAP.put(3671, "demux0");
        DELHI_IF_IFDESCR_MAP.put(3671, "demux0");
        DELHI_IF_IFNAME_MAP.put(7, "tap");
        DELHI_IF_IFDESCR_MAP.put(7, "tap");
        DELHI_IF_IFNAME_MAP.put(829, "ge-1/2/1");
        DELHI_IF_IFDESCR_MAP.put(829, "ge-1/2/1");
        DELHI_IF_MAC_MAP.put(829, "002283f163e0");
        DELHI_IF_IFNAME_MAP.put(1303, "pip0");
        DELHI_IF_IFDESCR_MAP.put(1303, "pip0");
        DELHI_IF_MAC_MAP.put(1303, "002283f167b0");
        DELHI_IF_IFNAME_MAP.put(28504, "ge-1/0/6");
        DELHI_IF_IFDESCR_MAP.put(28504, "ge-1/0/6");
        DELHI_IF_MAC_MAP.put(28504, "002283f1629b");
        DELHI_IF_IFNAME_MAP.put(28506, "ge-1/0/8");
        DELHI_IF_IFDESCR_MAP.put(28506, "ge-1/0/8");
        DELHI_IF_MAC_MAP.put(28506, "002283f1629d");
        DELHI_IF_IFNAME_MAP.put(272, "lc-1/2/0");
        DELHI_IF_IFDESCR_MAP.put(272, "lc-1/2/0");
        DELHI_IF_IFNAME_MAP.put(12397, "ge-1/2/2");
        DELHI_IF_IFDESCR_MAP.put(12397, "ge-1/2/2");
        DELHI_IF_MAC_MAP.put(12397, "002283f163e1");
        DELHI_IF_IFNAME_MAP.put(28499, "ge-1/0/3");
        DELHI_IF_IFDESCR_MAP.put(28499, "ge-1/0/3");
        DELHI_IF_MAC_MAP.put(28499, "002283f16298");
        DELHI_IF_IFNAME_MAP.put(28498, "ge-1/0/2");
        DELHI_IF_IFDESCR_MAP.put(28498, "ge-1/0/2");
        DELHI_IF_MAC_MAP.put(28498, "002283f16297");
        DELHI_IF_IFALIAS_MAP.put(28498, "TO-MUMBAI");
        DELHI_IF_IFNAME_MAP.put(3674, "ge-1/0/1.0");
        DELHI_IF_IFDESCR_MAP.put(3674, "ge-1/0/1.0");
        DELHI_IF_MAC_MAP.put(3674, "002283f16296");
        DELHI_IF_NETMASK_MAP.put(3674, InetAddressUtils.addr("255.255.255.252"));
        DELHI_IF_IFNAME_MAP.put(18, "em0.0");
        DELHI_IF_IFDESCR_MAP.put(18, "em0.0");
        DELHI_IF_MAC_MAP.put(18, "020000000004");
        DELHI_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        DELHI_IF_IFNAME_MAP.put(271, "ge-1/2/9");
        DELHI_IF_IFDESCR_MAP.put(271, "ge-1/2/9");
        DELHI_IF_MAC_MAP.put(271, "002283f163e8");
        DELHI_IF_IFNAME_MAP.put(270, "ge-1/2/8");
        DELHI_IF_IFDESCR_MAP.put(270, "ge-1/2/8");
        DELHI_IF_MAC_MAP.put(270, "002283f163e7");
        DELHI_IF_IFNAME_MAP.put(275, "ge-1/3/1");
        DELHI_IF_IFDESCR_MAP.put(275, "ge-1/3/1");
        DELHI_IF_MAC_MAP.put(275, "002283f16485");
        DELHI_IF_IFNAME_MAP.put(28515, "ge-1/1/2");
        DELHI_IF_IFDESCR_MAP.put(28515, "ge-1/1/2");
        DELHI_IF_MAC_MAP.put(28515, "002283f1633c");
        DELHI_IF_IFNAME_MAP.put(280, "ge-1/3/5");
        DELHI_IF_IFDESCR_MAP.put(280, "ge-1/3/5");
        DELHI_IF_MAC_MAP.put(280, "002283f16489");
        DELHI_IF_IFNAME_MAP.put(283, "ge-1/3/9");
        DELHI_IF_IFDESCR_MAP.put(283, "ge-1/3/9");
        DELHI_IF_MAC_MAP.put(283, "002283f1648d");
        DELHI_IF_IFNAME_MAP.put(11, "pimd");
        DELHI_IF_IFDESCR_MAP.put(11, "pimd");
        DELHI_IF_IFNAME_MAP.put(28501, "ge-1/0/5");
        DELHI_IF_IFDESCR_MAP.put(28501, "ge-1/0/5");
        DELHI_IF_MAC_MAP.put(28501, "002283f1629a");
        DELHI_IF_IFNAME_MAP.put(1, "fxp0");
        DELHI_IF_IFDESCR_MAP.put(1, "fxp0");
        DELHI_IF_MAC_MAP.put(1, "00a0a56264ef");
        DELHI_IF_IFNAME_MAP.put(29799, "ge-1/2/3");
        DELHI_IF_IFDESCR_MAP.put(29799, "ge-1/2/3");
        DELHI_IF_MAC_MAP.put(29799, "002283f163e2");
        DELHI_IF_IFNAME_MAP.put(24, "em1.0");
        DELHI_IF_IFDESCR_MAP.put(24, "em1.0");
        DELHI_IF_MAC_MAP.put(24, "020001000004");
        DELHI_IF_IFNAME_MAP.put(17619, "ge-1/1/6.0");
        DELHI_IF_IFDESCR_MAP.put(17619, "ge-1/1/6.0");
        DELHI_IF_MAC_MAP.put(17619, "002283f16340");
        DELHI_IF_NETMASK_MAP.put(17619, InetAddressUtils.addr("255.255.255.252"));
        DELHI_IF_IFNAME_MAP.put(28507, "ge-1/0/9");
        DELHI_IF_IFDESCR_MAP.put(28507, "ge-1/0/9");
        DELHI_IF_MAC_MAP.put(28507, "002283f1629e");
        DELHI_IF_IFNAME_MAP.put(12, "mtun");
        DELHI_IF_IFDESCR_MAP.put(12, "mtun");
        DELHI_IF_IFNAME_MAP.put(274, "ge-1/3/0");
        DELHI_IF_IFDESCR_MAP.put(274, "ge-1/3/0");
        DELHI_IF_MAC_MAP.put(274, "002283f16484");
        DELHI_IF_IFNAME_MAP.put(8, "gre");
        DELHI_IF_IFDESCR_MAP.put(8, "gre");
        DELHI_IF_IFNAME_MAP.put(10, "pime");
        DELHI_IF_IFDESCR_MAP.put(10, "pime");
        DELHI_IF_IFNAME_MAP.put(28519, "ge-1/1/5");
        DELHI_IF_IFDESCR_MAP.put(28519, "ge-1/1/5");
        DELHI_IF_MAC_MAP.put(28519, "002283f1633f");
        DELHI_IF_IFALIAS_MAP.put(28519, "TO-BAGMANE");
        DELHI_IF_IFNAME_MAP.put(28526, "lc-1/1/0.32769");
        DELHI_IF_IFDESCR_MAP.put(28526, "lc-1/1/0.32769");
        DELHI_IF_IFNAME_MAP.put(285, "lc-1/3/0.32769");
        DELHI_IF_IFDESCR_MAP.put(285, "lc-1/3/0.32769");
        DELHI_IF_IFNAME_MAP.put(28497, "ge-1/0/1");
        DELHI_IF_IFDESCR_MAP.put(28497, "ge-1/0/1");
        DELHI_IF_MAC_MAP.put(28497, "002283f16296");
        DELHI_IF_IFALIAS_MAP.put(28497, "to-BANGALORE");
        DELHI_IF_IFNAME_MAP.put(28510, "lc-1/0/0.32769");
        DELHI_IF_IFDESCR_MAP.put(28510, "lc-1/0/0.32769");
        DELHI_IF_IFNAME_MAP.put(279, "ge-1/3/6");
        DELHI_IF_IFDESCR_MAP.put(279, "ge-1/3/6");
        DELHI_IF_MAC_MAP.put(279, "002283f1648a");
        DELHI_IF_IFNAME_MAP.put(284, "lc-1/3/0");
        DELHI_IF_IFDESCR_MAP.put(284, "lc-1/3/0");
        DELHI_IF_IFNAME_MAP.put(28517, "ge-1/1/3");
        DELHI_IF_IFDESCR_MAP.put(28517, "ge-1/1/3");
        DELHI_IF_MAC_MAP.put(28517, "002283f1633d");
        DELHI_IF_IFNAME_MAP.put(28509, "lc-1/0/0");
        DELHI_IF_IFDESCR_MAP.put(28509, "lc-1/0/0");
        DELHI_IF_IFNAME_MAP.put(29804, "ge-1/1/5.0");
        DELHI_IF_IFDESCR_MAP.put(29804, "ge-1/1/5.0");
        DELHI_IF_MAC_MAP.put(29804, "002283f1633f");
        DELHI_IF_IFALIAS_MAP.put(29804, "TO-BAGMANE");
        DELHI_IF_NETMASK_MAP.put(29804, InetAddressUtils.addr("255.255.255.252"));
        DELHI_IF_IFNAME_MAP.put(28511, "ge-1/1/0");
        DELHI_IF_IFDESCR_MAP.put(28511, "ge-1/1/0");
        DELHI_IF_MAC_MAP.put(28511, "002283f1633a");
        DELHI_IF_IFALIAS_MAP.put(28511, "TO-CHENNAI");
        DELHI_IF_IFNAME_MAP.put(22, "lo0.16385");
        DELHI_IF_IFDESCR_MAP.put(22, "lo0.16385");
        DELHI_IF_IFNAME_MAP.put(281, "ge-1/3/7");
        DELHI_IF_IFDESCR_MAP.put(281, "ge-1/3/7");
        DELHI_IF_MAC_MAP.put(281, "002283f1648b");
        DELHI_IF_IFNAME_MAP.put(5, "dsc");
        DELHI_IF_IFDESCR_MAP.put(5, "dsc");
        DELHI_IF_IFNAME_MAP.put(269, "ge-1/2/7");
        DELHI_IF_IFDESCR_MAP.put(269, "ge-1/2/7");
        DELHI_IF_MAC_MAP.put(269, "002283f163e6");
        DELHI_IF_IFNAME_MAP.put(28523, "ge-1/1/9");
        DELHI_IF_IFDESCR_MAP.put(28523, "ge-1/1/9");
        DELHI_IF_MAC_MAP.put(28523, "002283f16343");
        DELHI_IF_IFNAME_MAP.put(16, "lo0.0");
        DELHI_IF_IFDESCR_MAP.put(16, "lo0.0");
        DELHI_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        DELHI_IF_IFNAME_MAP.put(273, "lc-1/2/0.32769");
        DELHI_IF_IFDESCR_MAP.put(273, "lc-1/2/0.32769");
        DELHI_IF_IFNAME_MAP.put(267, "ge-1/2/5");
        DELHI_IF_IFDESCR_MAP.put(267, "ge-1/2/5");
        DELHI_IF_MAC_MAP.put(267, "002283f163e4");
        DELHI_IF_IFNAME_MAP.put(278, "ge-1/3/4");
        DELHI_IF_IFDESCR_MAP.put(278, "ge-1/3/4");
        DELHI_IF_MAC_MAP.put(278, "002283f16488");
        DELHI_IF_IFNAME_MAP.put(28521, "ge-1/1/7");
        DELHI_IF_IFDESCR_MAP.put(28521, "ge-1/1/7");
        DELHI_IF_MAC_MAP.put(28521, "002283f16341");
        DELHI_IF_IFNAME_MAP.put(28518, "ge-1/1/4");
        DELHI_IF_IFDESCR_MAP.put(28518, "ge-1/1/4");
        DELHI_IF_MAC_MAP.put(28518, "002283f1633e");
        DELHI_IF_IFNAME_MAP.put(3672, "irb");
        DELHI_IF_IFDESCR_MAP.put(3672, "irb");
        DELHI_IF_MAC_MAP.put(3672, "002283f167f0");
        DELHI_IF_IFNAME_MAP.put(28500, "ge-1/0/4");
        DELHI_IF_IFDESCR_MAP.put(28500, "ge-1/0/4");
        DELHI_IF_MAC_MAP.put(28500, "002283f16299");
        DELHI_IF_IFNAME_MAP.put(6, "lo0");
        DELHI_IF_IFDESCR_MAP.put(6, "lo0");
        DELHI_IF_IFNAME_MAP.put(28527, "ge-1/2/0");
        DELHI_IF_IFDESCR_MAP.put(28527, "ge-1/2/0");
        DELHI_IF_MAC_MAP.put(28527, "002283f163df");
        DELHI_IF_IFNAME_MAP.put(1302, "cbp0");
        DELHI_IF_IFDESCR_MAP.put(1302, "cbp0");
        DELHI_IF_MAC_MAP.put(1302, "002283f16011");
        DELHI_IF_IFNAME_MAP.put(28505, "ge-1/0/7");
        DELHI_IF_IFDESCR_MAP.put(28505, "ge-1/0/7");
        DELHI_IF_MAC_MAP.put(28505, "002283f1629c");
        DELHI_IF_IFNAME_MAP.put(17, "em0");
        DELHI_IF_IFDESCR_MAP.put(17, "em0");
        DELHI_IF_MAC_MAP.put(17, "020000000004");
        DELHI_IF_IFNAME_MAP.put(277, "ge-1/3/3");
        DELHI_IF_IFDESCR_MAP.put(277, "ge-1/3/3");
        DELHI_IF_MAC_MAP.put(277, "002283f16487");
        DELHI_IF_IFNAME_MAP.put(23, "em1");
        DELHI_IF_IFDESCR_MAP.put(23, "em1");
        DELHI_IF_MAC_MAP.put(23, "020001000004");
        DELHI_IF_IFNAME_MAP.put(276, "ge-1/3/2");
        DELHI_IF_IFDESCR_MAP.put(276, "ge-1/3/2");
        DELHI_IF_MAC_MAP.put(276, "002283f16486");
        DELHI_IF_IFNAME_MAP.put(268, "ge-1/2/6");
        DELHI_IF_IFDESCR_MAP.put(268, "ge-1/2/6");
        DELHI_IF_MAC_MAP.put(268, "002283f163e5");
        DELHI_IF_IFNAME_MAP.put(28520, "ge-1/1/6");
        DELHI_IF_IFDESCR_MAP.put(28520, "ge-1/1/6");
        DELHI_IF_MAC_MAP.put(28520, "002283f16340");
        DELHI_IF_IFALIAS_MAP.put(28520, "TO-EX-SW1");
        DELHI_IF_IFNAME_MAP.put(28522, "ge-1/1/8");
        DELHI_IF_IFDESCR_MAP.put(28522, "ge-1/1/8");
        DELHI_IF_MAC_MAP.put(28522, "002283f16342");
        DELHI_IF_IFNAME_MAP.put(502, "ge-1/0/0");
        DELHI_IF_IFDESCR_MAP.put(502, "ge-1/0/0");
        DELHI_IF_MAC_MAP.put(502, "002283f16295");
        DELHI_IF_IFNAME_MAP.put(4, "lsi");
        DELHI_IF_IFDESCR_MAP.put(4, "lsi");
        DELHI_IF_IFNAME_MAP.put(28514, "ge-1/1/0.0");
        DELHI_IF_IFDESCR_MAP.put(28514, "ge-1/1/0.0");
        DELHI_IF_MAC_MAP.put(28514, "002283f1633a");
        DELHI_IF_NETMASK_MAP.put(28514, InetAddressUtils.addr("255.255.255.252"));
        DELHI_IF_IFNAME_MAP.put(282, "ge-1/3/8");
        DELHI_IF_IFDESCR_MAP.put(282, "ge-1/3/8");
        DELHI_IF_MAC_MAP.put(282, "002283f1648c");
        DELHI_IF_IFNAME_MAP.put(13, "fxp0.0");
        DELHI_IF_IFDESCR_MAP.put(13, "fxp0.0");
        DELHI_IF_MAC_MAP.put(13, "00a0a56264ef");
        DELHI_IF_NETMASK_MAP.put(13, InetAddressUtils.addr("255.255.0.0"));
        DELHI_IF_IFNAME_MAP.put(28513, "ge-1/1/1");
        DELHI_IF_IFDESCR_MAP.put(28513, "ge-1/1/1");
        DELHI_IF_MAC_MAP.put(28513, "002283f1633b");
        DELHI_IF_IFNAME_MAP.put(501, "pp0");
        DELHI_IF_IFDESCR_MAP.put(501, "pp0");
        DELHI_IF_IFNAME_MAP.put(28503, "ge-1/0/2.0");
        DELHI_IF_IFDESCR_MAP.put(28503, "ge-1/0/2.0");
        DELHI_IF_MAC_MAP.put(28503, "002283f16297");
        DELHI_IF_NETMASK_MAP.put(28503, InetAddressUtils.addr("255.255.255.252"));
        DELHI_IF_IFNAME_MAP.put(29800, "ge-1/2/4");
        DELHI_IF_IFDESCR_MAP.put(29800, "ge-1/2/4");
        DELHI_IF_MAC_MAP.put(29800, "002283f163e3");
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.1"), 22);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("192.168.168.1"), 517);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("128.0.1.16"), 22);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("172.16.20.2"), 549);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.42"), 508);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 22);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("10.11.11.11"), 548);
        J6350_42_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.16"), 22);
        J6350_42_IF_IFNAME_MAP.put(515, "mt-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(515, "mt-0/0/0");
        J6350_42_IF_IFNAME_MAP.put(6, "lo0");
        J6350_42_IF_IFDESCR_MAP.put(6, "lo0");
        J6350_42_IF_IFNAME_MAP.put(7, "tap");
        J6350_42_IF_IFDESCR_MAP.put(7, "tap");
        J6350_42_IF_IFNAME_MAP.put(22, "lo0.16385");
        J6350_42_IF_IFDESCR_MAP.put(22, "lo0.16385");
        J6350_42_IF_NETMASK_MAP.put(22, InetAddressUtils.addr("255.255.255.255"));
        J6350_42_IF_IFNAME_MAP.put(513, "gr-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(513, "gr-0/0/0");
        J6350_42_IF_IFNAME_MAP.put(549, "ge-0/0/2.0");
        J6350_42_IF_IFDESCR_MAP.put(549, "ge-0/0/2.0");
        J6350_42_IF_MAC_MAP.put(549, "2c6bf55dc082");
        J6350_42_IF_IFALIAS_MAP.put(549, "TO-BAMANE");
        J6350_42_IF_NETMASK_MAP.put(549, InetAddressUtils.addr("255.255.255.252"));
        J6350_42_IF_IFNAME_MAP.put(501, "lo0.32768");
        J6350_42_IF_IFDESCR_MAP.put(501, "lo0.32768");
        J6350_42_IF_IFNAME_MAP.put(8, "gre");
        J6350_42_IF_IFDESCR_MAP.put(8, "gre");
        J6350_42_IF_IFNAME_MAP.put(517, "ge-0/0/1.0");
        J6350_42_IF_IFDESCR_MAP.put(517, "ge-0/0/1.0");
        J6350_42_IF_MAC_MAP.put(517, "2c6bf55dc081");
        J6350_42_IF_NETMASK_MAP.put(517, InetAddressUtils.addr("255.255.255.0"));
        J6350_42_IF_IFNAME_MAP.put(9, "ipip");
        J6350_42_IF_IFDESCR_MAP.put(9, "ipip");
        J6350_42_IF_IFNAME_MAP.put(503, "st0");
        J6350_42_IF_IFDESCR_MAP.put(503, "st0");
        J6350_42_IF_IFNAME_MAP.put(12, "mtun");
        J6350_42_IF_IFDESCR_MAP.put(12, "mtun");
        J6350_42_IF_IFNAME_MAP.put(514, "lsq-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(514, "lsq-0/0/0");
        J6350_42_IF_IFNAME_MAP.put(510, "ge-0/0/2");
        J6350_42_IF_IFDESCR_MAP.put(510, "ge-0/0/2");
        J6350_42_IF_MAC_MAP.put(510, "2c6bf55dc082");
        J6350_42_IF_IFNAME_MAP.put(506, "vlan");
        J6350_42_IF_IFDESCR_MAP.put(506, "vlan");
        J6350_42_IF_MAC_MAP.put(506, "2c6bf55dc088");
        J6350_42_IF_IFNAME_MAP.put(516, "lt-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(516, "lt-0/0/0");
        J6350_42_IF_MAC_MAP.put(516, "2c6bf55dc080");
        J6350_42_IF_IFNAME_MAP.put(10, "pime");
        J6350_42_IF_IFDESCR_MAP.put(10, "pime");
        J6350_42_IF_IFNAME_MAP.put(4, "lsi");
        J6350_42_IF_IFDESCR_MAP.put(4, "lsi");
        J6350_42_IF_IFNAME_MAP.put(5, "dsc");
        J6350_42_IF_IFDESCR_MAP.put(5, "dsc");
        J6350_42_IF_IFNAME_MAP.put(512, "ip-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(512, "ip-0/0/0");
        J6350_42_IF_IFNAME_MAP.put(508, "ge-0/0/0.0");
        J6350_42_IF_IFDESCR_MAP.put(508, "ge-0/0/0.0");
        J6350_42_IF_MAC_MAP.put(508, "2c6bf55dc080");
        J6350_42_IF_NETMASK_MAP.put(508, InetAddressUtils.addr("255.255.0.0"));
        J6350_42_IF_IFNAME_MAP.put(509, "ge-0/0/1");
        J6350_42_IF_IFDESCR_MAP.put(509, "ge-0/0/1");
        J6350_42_IF_MAC_MAP.put(509, "2c6bf55dc081");
        J6350_42_IF_IFNAME_MAP.put(548, "st0.0");
        J6350_42_IF_IFDESCR_MAP.put(548, "st0.0");
        J6350_42_IF_NETMASK_MAP.put(548, InetAddressUtils.addr("255.255.255.0"));
        J6350_42_IF_IFNAME_MAP.put(505, "ppe0");
        J6350_42_IF_IFDESCR_MAP.put(505, "ppe0");
        J6350_42_IF_IFNAME_MAP.put(11, "pimd");
        J6350_42_IF_IFDESCR_MAP.put(11, "pimd");
        J6350_42_IF_IFNAME_MAP.put(507, "ge-0/0/0");
        J6350_42_IF_IFDESCR_MAP.put(507, "ge-0/0/0");
        J6350_42_IF_MAC_MAP.put(507, "2c6bf55dc080");
        J6350_42_IF_IFNAME_MAP.put(504, "ppd0");
        J6350_42_IF_IFDESCR_MAP.put(504, "ppd0");
        J6350_42_IF_IFNAME_MAP.put(511, "ge-0/0/3");
        J6350_42_IF_IFDESCR_MAP.put(511, "ge-0/0/3");
        J6350_42_IF_MAC_MAP.put(511, "2c6bf55dc083");
        J6350_42_IF_IFNAME_MAP.put(502, "pp0");
        J6350_42_IF_IFDESCR_MAP.put(502, "pp0");
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.1"), 16);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.13"), 507);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 18);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.5"), 520);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.5"), 508);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 18);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("15.15.0.5"), 518);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 18);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.21"), 978);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.9"), 519);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.17"), 977);
        MUMBAI_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.1"), 18);
        MUMBAI_IF_IFNAME_MAP.put(516, "ge-1/0/0");
        MUMBAI_IF_IFDESCR_MAP.put(516, "ge-1/0/0");
        MUMBAI_IF_MAC_MAP.put(516, "0019e27095fe");
        MUMBAI_IF_IFNAME_MAP.put(12, "mtun");
        MUMBAI_IF_IFDESCR_MAP.put(12, "mtun");
        MUMBAI_IF_IFNAME_MAP.put(16, "lo0.0");
        MUMBAI_IF_IFDESCR_MAP.put(16, "lo0.0");
        MUMBAI_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        MUMBAI_IF_IFNAME_MAP.put(515, "pc-0/1/0.16383");
        MUMBAI_IF_IFDESCR_MAP.put(515, "pc-0/1/0.16383");
        MUMBAI_IF_IFNAME_MAP.put(19, "bcm0");
        MUMBAI_IF_IFDESCR_MAP.put(19, "bcm0");
        MUMBAI_IF_MAC_MAP.put(19, "020000000004");
        MUMBAI_IF_IFNAME_MAP.put(521, "pfh-0/0/0");
        MUMBAI_IF_IFDESCR_MAP.put(521, "pfh-0/0/0");
        MUMBAI_IF_IFNAME_MAP.put(524, "pfh-1/0/0.16383");
        MUMBAI_IF_IFDESCR_MAP.put(524, "pfh-1/0/0.16383");
        MUMBAI_IF_IFNAME_MAP.put(1, "fxp0");
        MUMBAI_IF_IFDESCR_MAP.put(1, "fxp0");
        MUMBAI_IF_MAC_MAP.put(1, "00a0a5623009");
        MUMBAI_IF_IFNAME_MAP.put(513, "ge-0/1/3");
        MUMBAI_IF_IFDESCR_MAP.put(513, "ge-0/1/3");
        MUMBAI_IF_MAC_MAP.put(513, "0019e2709482");
        MUMBAI_IF_IFALIAS_MAP.put(513, "TO-CHENNAI");
        MUMBAI_IF_IFNAME_MAP.put(519, "ge-0/1/2.0");
        MUMBAI_IF_IFDESCR_MAP.put(519, "ge-0/1/2.0");
        MUMBAI_IF_MAC_MAP.put(519, "0019e2709481");
        MUMBAI_IF_NETMASK_MAP.put(519, InetAddressUtils.addr("255.255.255.252"));
        MUMBAI_IF_IFNAME_MAP.put(978, "ge-0/1/1.0");
        MUMBAI_IF_IFDESCR_MAP.put(978, "ge-0/1/1.0");
        MUMBAI_IF_MAC_MAP.put(978, "0019e2709480");
        MUMBAI_IF_NETMASK_MAP.put(978, InetAddressUtils.addr("255.255.255.252"));
        MUMBAI_IF_IFNAME_MAP.put(511, "ge-0/1/1");
        MUMBAI_IF_IFDESCR_MAP.put(511, "ge-0/1/1");
        MUMBAI_IF_MAC_MAP.put(511, "0019e2709480");
        MUMBAI_IF_IFALIAS_MAP.put(511, "to-Mysore");
        MUMBAI_IF_IFNAME_MAP.put(508, "ge-0/0/3.0");
        MUMBAI_IF_IFDESCR_MAP.put(508, "ge-0/0/3.0");
        MUMBAI_IF_MAC_MAP.put(508, "0019e2709403");
        MUMBAI_IF_NETMASK_MAP.put(508, InetAddressUtils.addr("255.255.0.0"));
        MUMBAI_IF_IFNAME_MAP.put(8, "gre");
        MUMBAI_IF_IFDESCR_MAP.put(8, "gre");
        MUMBAI_IF_IFNAME_MAP.put(522, "pfh-0/0/0.16383");
        MUMBAI_IF_IFDESCR_MAP.put(522, "pfh-0/0/0.16383");
        MUMBAI_IF_IFNAME_MAP.put(509, "pc-0/0/0.16383");
        MUMBAI_IF_IFDESCR_MAP.put(509, "pc-0/0/0.16383");
        MUMBAI_IF_IFNAME_MAP.put(504, "ge-0/0/2");
        MUMBAI_IF_IFDESCR_MAP.put(504, "ge-0/0/2");
        MUMBAI_IF_MAC_MAP.put(504, "0019e2709402");
        MUMBAI_IF_IFALIAS_MAP.put(504, "TO-BAGMANE");
        MUMBAI_IF_IFNAME_MAP.put(9, "ipip");
        MUMBAI_IF_IFDESCR_MAP.put(9, "ipip");
        MUMBAI_IF_IFNAME_MAP.put(501, "pp0");
        MUMBAI_IF_IFDESCR_MAP.put(501, "pp0");
        MUMBAI_IF_IFNAME_MAP.put(4, "lsi");
        MUMBAI_IF_IFDESCR_MAP.put(4, "lsi");
        MUMBAI_IF_IFNAME_MAP.put(510, "ge-0/1/0");
        MUMBAI_IF_IFDESCR_MAP.put(510, "ge-0/1/0");
        MUMBAI_IF_MAC_MAP.put(510, "0019e270947f");
        MUMBAI_IF_IFALIAS_MAP.put(510, "TO_UNKNOWN");
        MUMBAI_IF_IFNAME_MAP.put(507, "ge-0/0/1.0");
        MUMBAI_IF_IFDESCR_MAP.put(507, "ge-0/0/1.0");
        MUMBAI_IF_MAC_MAP.put(507, "0019e2709401");
        MUMBAI_IF_NETMASK_MAP.put(507, InetAddressUtils.addr("255.255.255.252"));
        MUMBAI_IF_IFNAME_MAP.put(514, "pc-0/1/0");
        MUMBAI_IF_IFDESCR_MAP.put(514, "pc-0/1/0");
        MUMBAI_IF_IFNAME_MAP.put(6, "lo0");
        MUMBAI_IF_IFDESCR_MAP.put(6, "lo0");
        MUMBAI_IF_IFNAME_MAP.put(18, "em0.0");
        MUMBAI_IF_IFDESCR_MAP.put(18, "em0.0");
        MUMBAI_IF_MAC_MAP.put(18, "020001000004");
        MUMBAI_IF_NETMASK_MAP.put(18, InetAddressUtils.addr("255.0.0.0"));
        MUMBAI_IF_IFNAME_MAP.put(512, "ge-0/1/2");
        MUMBAI_IF_IFDESCR_MAP.put(512, "ge-0/1/2");
        MUMBAI_IF_MAC_MAP.put(512, "0019e2709481");
        MUMBAI_IF_IFALIAS_MAP.put(512, "to-Delhi");
        MUMBAI_IF_IFNAME_MAP.put(542, "ge-0/0/0");
        MUMBAI_IF_IFDESCR_MAP.put(542, "ge-0/0/0");
        MUMBAI_IF_MAC_MAP.put(542, "0019e2709400");
        MUMBAI_IF_IFNAME_MAP.put(506, "pc-0/0/0");
        MUMBAI_IF_IFDESCR_MAP.put(506, "pc-0/0/0");
        MUMBAI_IF_IFNAME_MAP.put(10, "pime");
        MUMBAI_IF_IFDESCR_MAP.put(10, "pime");
        MUMBAI_IF_IFNAME_MAP.put(979, "ge-0/1/3.32767");
        MUMBAI_IF_IFDESCR_MAP.put(979, "ge-0/1/3.32767");
        MUMBAI_IF_MAC_MAP.put(979, "0019e2709482");
        MUMBAI_IF_IFNAME_MAP.put(505, "ge-0/0/3");
        MUMBAI_IF_IFDESCR_MAP.put(505, "ge-0/0/3");
        MUMBAI_IF_MAC_MAP.put(505, "0019e2709403");
        MUMBAI_IF_IFALIAS_MAP.put(505, "TO-QAINDIA");
        MUMBAI_IF_IFNAME_MAP.put(22, "lo0.16385");
        MUMBAI_IF_IFDESCR_MAP.put(22, "lo0.16385");
        MUMBAI_IF_IFNAME_MAP.put(523, "pfh-1/0/0");
        MUMBAI_IF_IFDESCR_MAP.put(523, "pfh-1/0/0");
        MUMBAI_IF_IFNAME_MAP.put(17, "em0");
        MUMBAI_IF_IFDESCR_MAP.put(17, "em0");
        MUMBAI_IF_MAC_MAP.put(17, "020001000004");
        MUMBAI_IF_IFNAME_MAP.put(977, "ge-0/0/2.0");
        MUMBAI_IF_IFDESCR_MAP.put(977, "ge-0/0/2.0");
        MUMBAI_IF_MAC_MAP.put(977, "0019e2709402");
        MUMBAI_IF_NETMASK_MAP.put(977, InetAddressUtils.addr("255.255.255.252"));
        MUMBAI_IF_IFNAME_MAP.put(518, "ge-0/1/0.0");
        MUMBAI_IF_IFDESCR_MAP.put(518, "ge-0/1/0.0");
        MUMBAI_IF_MAC_MAP.put(518, "0019e270947f");
        MUMBAI_IF_NETMASK_MAP.put(518, InetAddressUtils.addr("255.255.0.0"));
        MUMBAI_IF_IFNAME_MAP.put(520, "ge-0/1/3.0");
        MUMBAI_IF_IFDESCR_MAP.put(520, "ge-0/1/3.0");
        MUMBAI_IF_MAC_MAP.put(520, "0019e2709482");
        MUMBAI_IF_NETMASK_MAP.put(520, InetAddressUtils.addr("255.255.255.252"));
        MUMBAI_IF_IFNAME_MAP.put(503, "ge-0/0/1");
        MUMBAI_IF_IFDESCR_MAP.put(503, "ge-0/0/1");
        MUMBAI_IF_MAC_MAP.put(503, "0019e2709401");
        MUMBAI_IF_IFALIAS_MAP.put(503, "to-Bangalore");
        MUMBAI_IF_IFNAME_MAP.put(517, "ge-1/1/0");
        MUMBAI_IF_IFDESCR_MAP.put(517, "ge-1/1/0");
        MUMBAI_IF_MAC_MAP.put(517, "0019e270967d");
        MUMBAI_IF_IFNAME_MAP.put(20, "bcm0.0");
        MUMBAI_IF_IFDESCR_MAP.put(20, "bcm0.0");
        MUMBAI_IF_MAC_MAP.put(20, "020000000004");
        MUMBAI_IF_IFNAME_MAP.put(7, "tap");
        MUMBAI_IF_IFDESCR_MAP.put(7, "tap");
        MUMBAI_IF_IFNAME_MAP.put(11, "pimd");
        MUMBAI_IF_IFDESCR_MAP.put(11, "pimd");
        MUMBAI_IF_IFNAME_MAP.put(5, "dsc");
        MUMBAI_IF_IFDESCR_MAP.put(5, "dsc");
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.4"), 14);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.17"), 505);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.22.1"), 16);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.5.22"), 508);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 14);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("192.168.1.14"), 520);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.22"), 519);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("172.16.22.1"), 521);
        MYSORE_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 14);
        MYSORE_IF_IFNAME_MAP.put(22, "lo0.16385");
        MYSORE_IF_IFDESCR_MAP.put(22, "lo0.16385");
        MYSORE_IF_IFNAME_MAP.put(14, "fxp1.0");
        MYSORE_IF_IFDESCR_MAP.put(14, "fxp1.0");
        MYSORE_IF_MAC_MAP.put(14, "020000000004");
        MYSORE_IF_NETMASK_MAP.put(14, InetAddressUtils.addr("255.0.0.0"));
        MYSORE_IF_IFNAME_MAP.put(9, "ipip");
        MYSORE_IF_IFDESCR_MAP.put(9, "ipip");
        MYSORE_IF_IFNAME_MAP.put(507, "ge-0/0/3");
        MYSORE_IF_IFDESCR_MAP.put(507, "ge-0/0/3");
        MYSORE_IF_MAC_MAP.put(507, "0022831ba803");
        MYSORE_IF_IFNAME_MAP.put(501, "pfh-0/0/0");
        MYSORE_IF_IFDESCR_MAP.put(501, "pfh-0/0/0");
        MYSORE_IF_IFNAME_MAP.put(7, "tap");
        MYSORE_IF_IFDESCR_MAP.put(7, "tap");
        MYSORE_IF_IFNAME_MAP.put(10, "pime");
        MYSORE_IF_IFDESCR_MAP.put(10, "pime");
        MYSORE_IF_IFNAME_MAP.put(1, "fxp0");
        MYSORE_IF_IFDESCR_MAP.put(1, "fxp0");
        MYSORE_IF_MAC_MAP.put(1, "00a0a561e234");
        MYSORE_IF_IFNAME_MAP.put(506, "ge-0/0/2");
        MYSORE_IF_IFDESCR_MAP.put(506, "ge-0/0/2");
        MYSORE_IF_MAC_MAP.put(506, "0022831ba802");
        MYSORE_IF_IFNAME_MAP.put(16, "lo0.0");
        MYSORE_IF_IFDESCR_MAP.put(16, "lo0.0");
        MYSORE_IF_NETMASK_MAP.put(16, InetAddressUtils.addr("255.255.255.255"));
        MYSORE_IF_IFNAME_MAP.put(514, "ge-0/1/3");
        MYSORE_IF_IFDESCR_MAP.put(514, "ge-0/1/3");
        MYSORE_IF_MAC_MAP.put(514, "0022831ba822");
        MYSORE_IF_IFNAME_MAP.put(517, "pc-0/1/0.16383");
        MYSORE_IF_IFDESCR_MAP.put(517, "pc-0/1/0.16383");
        MYSORE_IF_IFNAME_MAP.put(4, "lsi");
        MYSORE_IF_IFDESCR_MAP.put(4, "lsi");
        MYSORE_IF_IFNAME_MAP.put(502, "pfh-0/0/0.16383");
        MYSORE_IF_IFDESCR_MAP.put(502, "pfh-0/0/0.16383");
        MYSORE_IF_IFNAME_MAP.put(8, "gre");
        MYSORE_IF_IFDESCR_MAP.put(8, "gre");
        MYSORE_IF_IFNAME_MAP.put(513, "ge-0/1/2");
        MYSORE_IF_IFDESCR_MAP.put(513, "ge-0/1/2");
        MYSORE_IF_MAC_MAP.put(513, "0022831ba821");
        MYSORE_IF_IFNAME_MAP.put(11, "pimd");
        MYSORE_IF_IFDESCR_MAP.put(11, "pimd");
        MYSORE_IF_IFNAME_MAP.put(6, "lo0");
        MYSORE_IF_IFDESCR_MAP.put(6, "lo0");
        MYSORE_IF_IFNAME_MAP.put(520, "ge-0/1/1.0");
        MYSORE_IF_IFDESCR_MAP.put(520, "ge-0/1/1.0");
        MYSORE_IF_MAC_MAP.put(520, "0022831ba820");
        MYSORE_IF_NETMASK_MAP.put(520, InetAddressUtils.addr("255.255.255.252"));
        MYSORE_IF_IFNAME_MAP.put(505, "ge-0/0/0.0");
        MYSORE_IF_IFDESCR_MAP.put(505, "ge-0/0/0.0");
        MYSORE_IF_MAC_MAP.put(505, "0022831ba800");
        MYSORE_IF_NETMASK_MAP.put(505, InetAddressUtils.addr("255.255.255.252"));
        MYSORE_IF_IFNAME_MAP.put(503, "ge-0/0/0");
        MYSORE_IF_IFDESCR_MAP.put(503, "ge-0/0/0");
        MYSORE_IF_MAC_MAP.put(503, "0022831ba800");
        MYSORE_IF_IFALIAS_MAP.put(503, "TO-CHENNAI");
        MYSORE_IF_IFNAME_MAP.put(12, "mtun");
        MYSORE_IF_IFDESCR_MAP.put(12, "mtun");
        MYSORE_IF_IFNAME_MAP.put(509, "pc-0/0/0");
        MYSORE_IF_IFDESCR_MAP.put(509, "pc-0/0/0");
        MYSORE_IF_IFNAME_MAP.put(515, "pc-0/1/0");
        MYSORE_IF_IFDESCR_MAP.put(515, "pc-0/1/0");
        MYSORE_IF_IFNAME_MAP.put(521, "ge-0/1/2.0");
        MYSORE_IF_IFDESCR_MAP.put(521, "ge-0/1/2.0");
        MYSORE_IF_MAC_MAP.put(521, "0022831ba821");
        MYSORE_IF_IFALIAS_MAP.put(521, "TO-SRX100");
        MYSORE_IF_NETMASK_MAP.put(521, InetAddressUtils.addr("255.255.255.252"));
        MYSORE_IF_IFNAME_MAP.put(519, "ge-0/1/0.0");
        MYSORE_IF_IFDESCR_MAP.put(519, "ge-0/1/0.0");
        MYSORE_IF_MAC_MAP.put(519, "0022831ba81f");
        MYSORE_IF_NETMASK_MAP.put(519, InetAddressUtils.addr("255.255.0.0"));
        MYSORE_IF_IFNAME_MAP.put(508, "ge-0/0/1.0");
        MYSORE_IF_IFDESCR_MAP.put(508, "ge-0/0/1.0");
        MYSORE_IF_MAC_MAP.put(508, "0022831ba801");
        MYSORE_IF_NETMASK_MAP.put(508, InetAddressUtils.addr("255.255.255.252"));
        MYSORE_IF_IFNAME_MAP.put(511, "ge-0/1/1");
        MYSORE_IF_IFDESCR_MAP.put(511, "ge-0/1/1");
        MYSORE_IF_MAC_MAP.put(511, "0022831ba820");
        MYSORE_IF_IFALIAS_MAP.put(511, "TO-BAGMANE");
        MYSORE_IF_IFNAME_MAP.put(504, "ge-0/0/1");
        MYSORE_IF_IFDESCR_MAP.put(504, "ge-0/0/1");
        MYSORE_IF_MAC_MAP.put(504, "0022831ba801");
        MYSORE_IF_IFALIAS_MAP.put(504, "TO-MUMBAI");
        MYSORE_IF_IFNAME_MAP.put(2, "fxp1");
        MYSORE_IF_IFDESCR_MAP.put(2, "fxp1");
        MYSORE_IF_MAC_MAP.put(2, "020000000004");
        MYSORE_IF_IFNAME_MAP.put(5, "dsc");
        MYSORE_IF_IFDESCR_MAP.put(5, "dsc");
        MYSORE_IF_IFNAME_MAP.put(516, "pc-0/0/0.16383");
        MYSORE_IF_IFDESCR_MAP.put(516, "pc-0/0/0.16383");
        MYSORE_IF_IFNAME_MAP.put(510, "ge-0/1/0");
        MYSORE_IF_IFDESCR_MAP.put(510, "ge-0/1/0");
        MYSORE_IF_MAC_MAP.put(510, "0022831ba81f");
        MYSORE_IF_IFALIAS_MAP.put(510, "TO-QAINDIA");
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("172.16.10.1"), 1361);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.16"), 38);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.127"), 504);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("55.55.55.55"), 506);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.32"), 38);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.1"), 524);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("172.16.7.2"), 528);
        SPACE_EX_SW1_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 38);
        SPACE_EX_SW1_IF_IFNAME_MAP.put(543, "ge-0/0/9");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(543, "ge-0/0/9");
        SPACE_EX_SW1_IF_MAC_MAP.put(543, "00239c023b4c");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(4, "lsi");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(4, "lsi");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(548, "ge-0/0/15.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(548, "ge-0/0/15.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(548, "00239c023b52");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(37, "bme0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(37, "bme0");
        SPACE_EX_SW1_IF_MAC_MAP.put(37, "000bcafe0000");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(506, "vlan.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(506, "vlan.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(506, "00239c023b41");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(506, InetAddressUtils.addr("255.255.255.0"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(6, "lo0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(6, "lo0");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(38, "bme0.32768");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(38, "bme0.32768");
        SPACE_EX_SW1_IF_MAC_MAP.put(38, "000bcafe0000");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(38, InetAddressUtils.addr("192.0.0.0"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(505, "ge-0/0/10");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(505, "ge-0/0/10");
        SPACE_EX_SW1_IF_MAC_MAP.put(505, "00239c023b4d");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(542, "ge-0/0/8");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(542, "ge-0/0/8");
        SPACE_EX_SW1_IF_MAC_MAP.put(542, "00239c023b4b");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(524, "ge-0/0/4.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(524, "ge-0/0/4.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(524, "00239c023b47");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(524, InetAddressUtils.addr("255.255.0.0"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(517, "ge-0/0/16");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(517, "ge-0/0/16");
        SPACE_EX_SW1_IF_MAC_MAP.put(517, "00239c023b53");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(521, "ge-0/0/18");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(521, "ge-0/0/18");
        SPACE_EX_SW1_IF_MAC_MAP.put(521, "00239c023b55");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(504, "jsrv.1");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(504, "jsrv.1");
        SPACE_EX_SW1_IF_MAC_MAP.put(504, "00239c023b40");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(504, InetAddressUtils.addr("192.0.0.0"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(540, "ge-0/0/6");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(540, "ge-0/0/6");
        SPACE_EX_SW1_IF_MAC_MAP.put(540, "00239c023b49");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(549, "ge-0/0/16.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(549, "ge-0/0/16.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(549, "00239c023b53");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(5, "dsc");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(5, "dsc");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(12, "mtun");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(12, "mtun");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(519, "ge-0/0/17");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(519, "ge-0/0/17");
        SPACE_EX_SW1_IF_MAC_MAP.put(519, "00239c023b54");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(529, "ge-0/0/21");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(529, "ge-0/0/21");
        SPACE_EX_SW1_IF_MAC_MAP.put(529, "00239c023b58");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(536, "ge-0/0/3");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(536, "ge-0/0/3");
        SPACE_EX_SW1_IF_MAC_MAP.put(536, "00239c023b46");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(534, "ge-0/0/23");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(534, "ge-0/0/23");
        SPACE_EX_SW1_IF_MAC_MAP.put(534, "00239c023b5a");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(533, "vlan");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(533, "vlan");
        SPACE_EX_SW1_IF_MAC_MAP.put(533, "00239c023b41");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(33, "me0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(33, "me0");
        SPACE_EX_SW1_IF_MAC_MAP.put(33, "00239c023b7f");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(509, "ge-0/0/12");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(509, "ge-0/0/12");
        SPACE_EX_SW1_IF_MAC_MAP.put(509, "00239c023b4f");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(539, "ge-0/0/5");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(539, "ge-0/0/5");
        SPACE_EX_SW1_IF_MAC_MAP.put(539, "00239c023b48");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(527, "ge-0/0/20");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(527, "ge-0/0/20");
        SPACE_EX_SW1_IF_MAC_MAP.put(527, "00239c023b57");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(9, "ipip");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(9, "ipip");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(525, "ge-0/0/2");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(525, "ge-0/0/2");
        SPACE_EX_SW1_IF_MAC_MAP.put(525, "00239c023b45");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(503, "ge-0/0/1");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(503, "ge-0/0/1");
        SPACE_EX_SW1_IF_MAC_MAP.put(503, "00239c023b44");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(1361, "ge-0/0/0.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(1361, "ge-0/0/0.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(1361, "00239c023b43");
        SPACE_EX_SW1_IF_IFALIAS_MAP.put(1361, "TO-EX-SW1");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(1361, InetAddressUtils.addr("255.255.255.252"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(523, "ge-0/0/19");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(523, "ge-0/0/19");
        SPACE_EX_SW1_IF_MAC_MAP.put(523, "00239c023b56");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(7, "tap");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(7, "tap");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(515, "ge-0/0/15");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(515, "ge-0/0/15");
        SPACE_EX_SW1_IF_MAC_MAP.put(515, "00239c023b52");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(528, "ge-0/0/6.0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(528, "ge-0/0/6.0");
        SPACE_EX_SW1_IF_MAC_MAP.put(528, "00239c023b49");
        SPACE_EX_SW1_IF_NETMASK_MAP.put(528, InetAddressUtils.addr("255.255.255.252"));
        SPACE_EX_SW1_IF_IFNAME_MAP.put(8, "gre");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(8, "gre");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(502, "jsrv");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(502, "jsrv");
        SPACE_EX_SW1_IF_MAC_MAP.put(502, "00239c023b40");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(507, "ge-0/0/11");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(507, "ge-0/0/11");
        SPACE_EX_SW1_IF_MAC_MAP.put(507, "00239c023b4e");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(501, "ge-0/0/0");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(501, "ge-0/0/0");
        SPACE_EX_SW1_IF_MAC_MAP.put(501, "00239c023b43");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(10, "pime");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(10, "pime");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(531, "ge-0/0/22");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(531, "ge-0/0/22");
        SPACE_EX_SW1_IF_MAC_MAP.put(531, "00239c023b59");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(513, "ge-0/0/14");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(513, "ge-0/0/14");
        SPACE_EX_SW1_IF_MAC_MAP.put(513, "00239c023b51");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(11, "pimd");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(11, "pimd");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(538, "ge-0/0/4");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(538, "ge-0/0/4");
        SPACE_EX_SW1_IF_MAC_MAP.put(538, "00239c023b47");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(511, "ge-0/0/13");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(511, "ge-0/0/13");
        SPACE_EX_SW1_IF_MAC_MAP.put(511, "00239c023b50");
        SPACE_EX_SW1_IF_IFNAME_MAP.put(541, "ge-0/0/7");
        SPACE_EX_SW1_IF_IFDESCR_MAP.put(541, "ge-0/0/7");
        SPACE_EX_SW1_IF_MAC_MAP.put(541, "00239c023b4a");
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.32"), 38);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("172.16.10.2"), 531);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.2"), 34);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 38);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.127"), 523);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("172.16.9.2"), 551);
        SPACE_EX_SW2_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.16"), 38);
        SPACE_EX_SW2_IF_IFNAME_MAP.put(50, "vcp-0.32768");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(50, "vcp-0.32768");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(509, "ge-0/0/16");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(509, "ge-0/0/16");
        SPACE_EX_SW2_IF_MAC_MAP.put(509, "002159cf4c10");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(52, "vcp-1.32768");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(52, "vcp-1.32768");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(531, "ge-0/0/0.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(531, "ge-0/0/0.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(531, "002159cf4c00");
        SPACE_EX_SW2_IF_NETMASK_MAP.put(531, InetAddressUtils.addr("255.255.255.252"));
        SPACE_EX_SW2_IF_IFNAME_MAP.put(529, "ae1");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(529, "ae1");
        SPACE_EX_SW2_IF_MAC_MAP.put(529, "002159cf4c01");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(154, "ge-0/0/19");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(154, "ge-0/0/19");
        SPACE_EX_SW2_IF_MAC_MAP.put(154, "002159cf4c13");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(11, "pimd");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(11, "pimd");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(5, "dsc");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(5, "dsc");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(521, "ge-0/0/9");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(521, "ge-0/0/9");
        SPACE_EX_SW2_IF_MAC_MAP.put(521, "002159cf4c09");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(505, "ge-0/0/12");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(505, "ge-0/0/12");
        SPACE_EX_SW2_IF_MAC_MAP.put(505, "002159cf4c0c");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(7, "tap");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(7, "tap");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(513, "ge-0/0/22");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(513, "ge-0/0/22");
        SPACE_EX_SW2_IF_MAC_MAP.put(513, "002159cf4c16");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(515, "ge-0/0/3");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(515, "ge-0/0/3");
        SPACE_EX_SW2_IF_MAC_MAP.put(515, "002159cf4c03");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(541, "ge-0/0/19.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(541, "ge-0/0/19.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(541, "002159cf4c13");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(527, "ae0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(527, "ae0");
        SPACE_EX_SW2_IF_MAC_MAP.put(527, "002159cf4c00");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(503, "ge-0/0/10");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(503, "ge-0/0/10");
        SPACE_EX_SW2_IF_MAC_MAP.put(503, "002159cf4c0a");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(49, "vcp-0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(49, "vcp-0");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(6, "lo0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(6, "lo0");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(152, "ge-0/0/18");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(152, "ge-0/0/18");
        SPACE_EX_SW2_IF_MAC_MAP.put(152, "002159cf4c12");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(51, "vcp-1");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(51, "vcp-1");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(506, "ge-0/0/13");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(506, "ge-0/0/13");
        SPACE_EX_SW2_IF_MAC_MAP.put(506, "002159cf4c0d");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(520, "ge-0/0/8");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(520, "ge-0/0/8");
        SPACE_EX_SW2_IF_MAC_MAP.put(520, "002159cf4c08");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(508, "ge-0/0/15");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(508, "ge-0/0/15");
        SPACE_EX_SW2_IF_MAC_MAP.put(508, "002159cf4c0f");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(551, "ge-0/0/3.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(551, "ge-0/0/3.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(551, "002159cf4c03");
        SPACE_EX_SW2_IF_NETMASK_MAP.put(551, InetAddressUtils.addr("255.255.255.252"));
        SPACE_EX_SW2_IF_IFNAME_MAP.put(522, "jsrv");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(522, "jsrv");
        SPACE_EX_SW2_IF_MAC_MAP.put(522, "002159cf4c00");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(540, "ge-0/0/18.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(540, "ge-0/0/18.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(540, "002159cf4c12");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(544, "ge-0/0/23.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(544, "ge-0/0/23.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(544, "002159cf4c17");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(156, "ge-0/0/20");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(156, "ge-0/0/20");
        SPACE_EX_SW2_IF_MAC_MAP.put(156, "002159cf4c14");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(9, "ipip");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(9, "ipip");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(523, "jsrv.1");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(523, "jsrv.1");
        SPACE_EX_SW2_IF_MAC_MAP.put(523, "002159cf4c00");
        SPACE_EX_SW2_IF_NETMASK_MAP.put(523, InetAddressUtils.addr("192.0.0.0"));
        SPACE_EX_SW2_IF_IFNAME_MAP.put(38, "bme0.32768");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(38, "bme0.32768");
        SPACE_EX_SW2_IF_MAC_MAP.put(38, "000bcafe0000");
        SPACE_EX_SW2_IF_NETMASK_MAP.put(38, InetAddressUtils.addr("192.0.0.0"));
        SPACE_EX_SW2_IF_IFNAME_MAP.put(539, "ge-0/0/17.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(539, "ge-0/0/17.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(539, "002159cf4c11");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(518, "ge-0/0/6");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(518, "ge-0/0/6");
        SPACE_EX_SW2_IF_MAC_MAP.put(518, "002159cf4c06");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(507, "ge-0/0/14");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(507, "ge-0/0/14");
        SPACE_EX_SW2_IF_MAC_MAP.put(507, "002159cf4c0e");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(516, "ge-0/0/4");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(516, "ge-0/0/4");
        SPACE_EX_SW2_IF_MAC_MAP.put(516, "002159cf4c04");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(10, "pime");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(10, "pime");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(511, "ge-0/0/2");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(511, "ge-0/0/2");
        SPACE_EX_SW2_IF_MAC_MAP.put(511, "002159cf4c02");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(504, "ge-0/0/11");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(504, "ge-0/0/11");
        SPACE_EX_SW2_IF_MAC_MAP.put(504, "002159cf4c0b");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(4, "lsi");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(4, "lsi");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(530, "ge-0/0/22.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(530, "ge-0/0/22.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(530, "002159cf4c16");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(12, "mtun");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(12, "mtun");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(502, "ge-0/0/1");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(502, "ge-0/0/1");
        SPACE_EX_SW2_IF_MAC_MAP.put(502, "002159cf4c01");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(510, "ge-0/0/17");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(510, "ge-0/0/17");
        SPACE_EX_SW2_IF_MAC_MAP.put(510, "002159cf4c11");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(517, "ge-0/0/5");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(517, "ge-0/0/5");
        SPACE_EX_SW2_IF_MAC_MAP.put(517, "002159cf4c05");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(33, "me0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(33, "me0");
        SPACE_EX_SW2_IF_MAC_MAP.put(33, "002159cf4c3f");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(34, "me0.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(34, "me0.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(34, "002159cf4c3f");
        SPACE_EX_SW2_IF_NETMASK_MAP.put(34, InetAddressUtils.addr("255.255.0.0"));
        SPACE_EX_SW2_IF_IFNAME_MAP.put(35, "vme");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(35, "vme");
        SPACE_EX_SW2_IF_MAC_MAP.put(35, "002159cf4c01");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(37, "bme0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(37, "bme0");
        SPACE_EX_SW2_IF_MAC_MAP.put(37, "000bcafe0000");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(519, "ge-0/0/7");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(519, "ge-0/0/7");
        SPACE_EX_SW2_IF_MAC_MAP.put(519, "002159cf4c07");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(514, "ge-0/0/23");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(514, "ge-0/0/23");
        SPACE_EX_SW2_IF_MAC_MAP.put(514, "002159cf4c17");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(501, "ge-0/0/0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(501, "ge-0/0/0");
        SPACE_EX_SW2_IF_MAC_MAP.put(501, "002159cf4c00");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(543, "ge-0/0/21.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(543, "ge-0/0/21.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(543, "002159cf4c15");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(542, "ge-0/0/20.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(542, "ge-0/0/20.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(542, "002159cf4c14");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(537, "ge-0/0/15.0");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(537, "ge-0/0/15.0");
        SPACE_EX_SW2_IF_MAC_MAP.put(537, "002159cf4c0f");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(524, "vlan");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(524, "vlan");
        SPACE_EX_SW2_IF_MAC_MAP.put(524, "002159cf4c00");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(8, "gre");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(8, "gre");
        SPACE_EX_SW2_IF_IFNAME_MAP.put(512, "ge-0/0/21");
        SPACE_EX_SW2_IF_IFDESCR_MAP.put(512, "ge-0/0/21");
        SPACE_EX_SW2_IF_MAC_MAP.put(512, "002159cf4c15");
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("128.0.1.16"), 22);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.4"), 22);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("10.205.56.23"), 516);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.16"), 22);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.6"), 530);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.6"), 530);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("172.16.22.2"), 518);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("10.0.0.1"), 22);
        SRX_100_IP_IF_MAP.put(InetAddressUtils.addr("128.0.0.1"), 22);
        SRX_100_IF_IFNAME_MAP.put(12, "mtun");
        SRX_100_IF_IFDESCR_MAP.put(12, "mtun");
        SRX_100_IF_IFNAME_MAP.put(505, "ppd0");
        SRX_100_IF_IFDESCR_MAP.put(505, "ppd0");
        SRX_100_IF_IFNAME_MAP.put(508, "fe-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(508, "fe-0/0/0");
        SRX_100_IF_MAC_MAP.put(508, "2c6bf502b800");
        SRX_100_IF_IFNAME_MAP.put(501, "pp0");
        SRX_100_IF_IFDESCR_MAP.put(501, "pp0");
        SRX_100_IF_IFNAME_MAP.put(7, "tap");
        SRX_100_IF_IFDESCR_MAP.put(7, "tap");
        SRX_100_IF_IFNAME_MAP.put(521, "sp-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(521, "sp-0/0/0");
        SRX_100_IF_IFNAME_MAP.put(503, "irb");
        SRX_100_IF_IFDESCR_MAP.put(503, "irb");
        SRX_100_IF_MAC_MAP.put(503, "2c6bf502b870");
        SRX_100_IF_IFNAME_MAP.put(22, "lo0.16385");
        SRX_100_IF_IFDESCR_MAP.put(22, "lo0.16385");
        SRX_100_IF_NETMASK_MAP.put(22, InetAddressUtils.addr("255.255.255.255"));
        SRX_100_IF_IFNAME_MAP.put(4, "lsi");
        SRX_100_IF_IFDESCR_MAP.put(4, "lsi");
        SRX_100_IF_IFNAME_MAP.put(523, "ip-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(523, "ip-0/0/0");
        SRX_100_IF_IFNAME_MAP.put(529, "sp-0/0/0.0");
        SRX_100_IF_IFDESCR_MAP.put(529, "sp-0/0/0.0");
        SRX_100_IF_IFNAME_MAP.put(513, "fe-0/0/5");
        SRX_100_IF_IFDESCR_MAP.put(513, "fe-0/0/5");
        SRX_100_IF_MAC_MAP.put(513, "2c6bf502b805");
        SRX_100_IF_IFNAME_MAP.put(6, "lo0");
        SRX_100_IF_IFDESCR_MAP.put(6, "lo0");
        SRX_100_IF_IFNAME_MAP.put(11, "pimd");
        SRX_100_IF_IFDESCR_MAP.put(11, "pimd");
        SRX_100_IF_IFNAME_MAP.put(510, "fe-0/0/2");
        SRX_100_IF_IFDESCR_MAP.put(510, "fe-0/0/2");
        SRX_100_IF_MAC_MAP.put(510, "2c6bf502b802");
        SRX_100_IF_IFNAME_MAP.put(511, "fe-0/0/3");
        SRX_100_IF_IFDESCR_MAP.put(511, "fe-0/0/3");
        SRX_100_IF_MAC_MAP.put(511, "2c6bf502b803");
        SRX_100_IF_IFNAME_MAP.put(9, "ipip");
        SRX_100_IF_IFDESCR_MAP.put(9, "ipip");
        SRX_100_IF_IFNAME_MAP.put(525, "mt-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(525, "mt-0/0/0");
        SRX_100_IF_IFNAME_MAP.put(10, "pime");
        SRX_100_IF_IFDESCR_MAP.put(10, "pime");
        SRX_100_IF_IFNAME_MAP.put(248, "lo0.32768");
        SRX_100_IF_IFDESCR_MAP.put(248, "lo0.32768");
        SRX_100_IF_IFNAME_MAP.put(516, "fe-0/0/0.0");
        SRX_100_IF_IFDESCR_MAP.put(516, "fe-0/0/0.0");
        SRX_100_IF_MAC_MAP.put(516, "2c6bf502b800");
        SRX_100_IF_NETMASK_MAP.put(516, InetAddressUtils.addr("255.255.0.0"));
        SRX_100_IF_IFNAME_MAP.put(502, "vlan");
        SRX_100_IF_IFDESCR_MAP.put(502, "vlan");
        SRX_100_IF_MAC_MAP.put(502, "2c6bf502b808");
        SRX_100_IF_IFNAME_MAP.put(506, "ppe0");
        SRX_100_IF_IFDESCR_MAP.put(506, "ppe0");
        SRX_100_IF_IFNAME_MAP.put(512, "fe-0/0/4");
        SRX_100_IF_IFDESCR_MAP.put(512, "fe-0/0/4");
        SRX_100_IF_MAC_MAP.put(512, "2c6bf502b804");
        SRX_100_IF_IFNAME_MAP.put(522, "gr-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(522, "gr-0/0/0");
        SRX_100_IF_IFNAME_MAP.put(507, "vlan.0");
        SRX_100_IF_IFDESCR_MAP.put(507, "vlan.0");
        SRX_100_IF_MAC_MAP.put(507, "2c6bf502b808");
        SRX_100_IF_IFNAME_MAP.put(504, "st0");
        SRX_100_IF_IFDESCR_MAP.put(504, "st0");
        SRX_100_IF_IFNAME_MAP.put(514, "fe-0/0/6");
        SRX_100_IF_IFDESCR_MAP.put(514, "fe-0/0/6");
        SRX_100_IF_MAC_MAP.put(514, "2c6bf502b806");
        SRX_100_IF_IFNAME_MAP.put(518, "fe-0/0/2.0");
        SRX_100_IF_IFDESCR_MAP.put(518, "fe-0/0/2.0");
        SRX_100_IF_MAC_MAP.put(518, "2c6bf502b802");
        SRX_100_IF_IFALIAS_MAP.put(518, "TO-MYSORE");
        SRX_100_IF_NETMASK_MAP.put(518, InetAddressUtils.addr("255.255.255.252"));
        SRX_100_IF_IFNAME_MAP.put(530, "sp-0/0/0.16383");
        SRX_100_IF_IFDESCR_MAP.put(530, "sp-0/0/0.16383");
        SRX_100_IF_NETMASK_MAP.put(530, InetAddressUtils.addr("255.255.255.255"));
        SRX_100_IF_IFNAME_MAP.put(8, "gre");
        SRX_100_IF_IFDESCR_MAP.put(8, "gre");
        SRX_100_IF_IFNAME_MAP.put(515, "fe-0/0/7");
        SRX_100_IF_IFDESCR_MAP.put(515, "fe-0/0/7");
        SRX_100_IF_MAC_MAP.put(515, "2c6bf502b807");
        SRX_100_IF_IFNAME_MAP.put(509, "fe-0/0/1");
        SRX_100_IF_IFDESCR_MAP.put(509, "fe-0/0/1");
        SRX_100_IF_MAC_MAP.put(509, "2c6bf502b801");
        SRX_100_IF_IFNAME_MAP.put(526, "lt-0/0/0");
        SRX_100_IF_IFDESCR_MAP.put(526, "lt-0/0/0");
        SRX_100_IF_MAC_MAP.put(526, "2c6bf502b800");
    }

    protected static InetAddress MUMBAI_OSPF_ID;

    protected static InetAddress DELHI_OSPF_ID;

    protected static InetAddress BANGALORE_OSPF_ID;

    protected static InetAddress MYSORE_OSPF_ID;

    protected static InetAddress BAGMANE_OSPF_ID;

    protected static InetAddress SPACE_EX_SW1_OSPF_ID;

    protected static InetAddress SPACE_EX_SW2_OSPF_ID;

    protected static InetAddress J6350_42_OSPF_ID;

    protected static InetAddress SRX_100_OSPF_ID;
    static {
        MUMBAI_OSPF_ID = InetAddressUtils.addr("192.168.5.1");
        DELHI_OSPF_ID = InetAddressUtils.addr("192.168.7.1");
        BANGALORE_OSPF_ID = InetAddressUtils.addr("192.168.9.1");
        MYSORE_OSPF_ID = InetAddressUtils.addr("192.168.22.1");
        BAGMANE_OSPF_ID = InetAddressUtils.addr("192.168.20.1");
        SPACE_EX_SW1_OSPF_ID = InetAddressUtils.addr("10.205.56.1");
        SPACE_EX_SW2_OSPF_ID = InetAddressUtils.addr("10.205.56.2");
        J6350_42_OSPF_ID = InetAddressUtils.addr("10.205.56.42");
        SRX_100_OSPF_ID = InetAddressUtils.addr("0.0.0.0");
    }

}
