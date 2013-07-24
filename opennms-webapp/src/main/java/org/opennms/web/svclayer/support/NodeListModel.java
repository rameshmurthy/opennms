/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2012 The OpenNMS Group, Inc.
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

package org.opennms.web.svclayer.support;

import java.util.List;

import org.opennms.netmgt.model.OnmsArpInterface;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.OnmsSnmpInterface;

/**
 * <p>NodeListModel class.</p>
 *
 * @author <a href="mailto:dj@opennms.org">DJ Gregor</a>
 * @version $Id: $
 * @since 1.8.1
 */
public class NodeListModel {
    private List<NodeModel> m_nodes;
    private int m_interfaceCount;

    /**
     * <p>Constructor for NodeListModel.</p>
     *
     * @param nodes a {@link java.util.List} object.
     * @param interfaceCount a int.
     */
    public NodeListModel(final List<NodeModel> nodes, final int interfaceCount) {
        m_nodes = nodes;
        m_interfaceCount = interfaceCount;
    }

    /**
     * <p>getNodes</p>
     *
     * @return a {@link java.util.List} object.
     */
    public final List<NodeModel> getNodes() {
        return m_nodes;
    }

    /**
     * <p>getNodesLeft</p>
     *
     * @return a {@link java.util.List} object.
     */
    public final List<NodeModel> getNodesLeft() {
        return m_nodes.subList(0, getLastInLeftColumn());
    }

    /**
     * <p>getNodesRight</p>
     *
     * @return a {@link java.util.List} object.
     */
    public final List<NodeModel> getNodesRight() {
        return m_nodes.subList(getLastInLeftColumn(), m_nodes.size());
    }

    /**
     * <p>getLastInLeftColumn</p>
     *
     * @return a int.
     */
    public final int getLastInLeftColumn() {
        return (int) Math.ceil(m_nodes.size()/2.0);
    }

    /**
     * <p>getNodeCount</p>
     *
     * @return a int.
     */
    public final int getNodeCount() {
        return m_nodes.size();
    }

    /**
     * <p>getInterfaceCount</p>
     *
     * @return a int.
     */
    public final int getInterfaceCount() {
        return m_interfaceCount;
    }

    public static class NodeModel {
        private OnmsNode m_node;
        private List<OnmsIpInterface> m_interfaces;
        private List<OnmsArpInterface> m_arpinterfaces;
        private List<OnmsSnmpInterface> m_snmpinterfaces;


        public NodeModel(final OnmsNode node, final List<OnmsIpInterface> interfaces, final List<OnmsArpInterface> arpinterfaces, final List<OnmsSnmpInterface> snmpinterfaces) {
            m_node = node;
            m_interfaces = interfaces;
            m_arpinterfaces = arpinterfaces;
            m_snmpinterfaces = snmpinterfaces;
        }

        public final OnmsNode getNode() {
            return m_node;
        }

        public final List<OnmsIpInterface> getInterfaces() {
            return m_interfaces;
        }

        public final List<OnmsArpInterface> getArpInterfaces() {
            return m_arpinterfaces;
        }

        public final List<OnmsSnmpInterface> getSnmpInterfaces() {
            return m_snmpinterfaces;
        }
    }

}
