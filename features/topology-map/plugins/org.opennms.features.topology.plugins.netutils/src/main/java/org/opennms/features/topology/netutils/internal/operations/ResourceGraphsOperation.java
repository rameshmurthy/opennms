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

package org.opennms.features.topology.netutils.internal.operations;

import java.net.URL;
import java.util.List;

import org.opennms.features.topology.api.AbstractOperation;
import org.opennms.features.topology.api.OperationContext;
import org.opennms.features.topology.api.OperationContext.DisplayLocation;
import org.opennms.features.topology.api.topo.VertexRef;
import org.opennms.features.topology.netutils.internal.Node;
import org.opennms.features.topology.netutils.internal.ResourceGraphsWindow;

import com.vaadin.server.Page;

/**
 * The Class ResourceGraphsOperation.
 */
public class ResourceGraphsOperation extends AbstractOperation {

    /** The m_resource graph list url. */
    private String m_resourceGraphListURL;

    /** The m_resource graph node url. */
    private String m_resourceGraphNodeURL;

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#execute(java.util.List, org.opennms.features.topology.api.OperationContext)
     */
    @Override
    public Undoer execute(final List<VertexRef> targets, final OperationContext operationContext) {
        String label = "";
        int nodeID = -1;

        try {
            if (targets != null) {
                for (final VertexRef target : targets) {
                    final String labelValue = getLabelValue(operationContext, target);
                    final Integer nodeValue = getNodeIdValue(operationContext, target);

                    if (nodeValue != null && nodeValue > 0) {
                        label = labelValue == null ? "" : labelValue;
                        nodeID = nodeValue.intValue();
                    }
                }
            }
            final Node node = new Node(nodeID, null, label);

            final URL baseURL = Page.getCurrent().getLocation().toURL();

            final URL nodeURL;

            if (node.getNodeID() >= 0) {
                nodeURL = new URL(baseURL, getResourceGraphNodeURL() + "[" + node.getNodeID() + "]");
            } else {
                nodeURL = new URL(baseURL, getResourceGraphListURL());
            }

            operationContext.getMainWindow().addWindow(new ResourceGraphsWindow(node, nodeURL));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.AbstractOperation#display(java.util.List, org.opennms.features.topology.api.OperationContext)
     */
    @Override
    public boolean display(final List<VertexRef> targets, final OperationContext operationContext) {
        if (operationContext.getDisplayLocation() == DisplayLocation.MENUBAR) {
            return true;
        } else if (targets != null && targets.size() > 0 && targets.get(0) != null) {
            return true;
        } else {
            return false;
        }

    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#getId()
     */
    @Override
    public String getId() {
        return "contextResourceGraphs";
    }

    /**
     * Gets the resource graph list url.
     *
     * @return the resource graph list url
     */
    public String getResourceGraphListURL() {
        return m_resourceGraphListURL;
    }

    /**
     * Sets the resource graph list url.
     *
     * @param resourceGraphListURL
     *            the new resource graph list url
     */
    public void setResourceGraphListURL(String resourceGraphListURL) {
        this.m_resourceGraphListURL = resourceGraphListURL;
    }

    /**
     * Gets the resource graph node url.
     *
     * @return the resource graph node url
     */
    public String getResourceGraphNodeURL() {
        return m_resourceGraphNodeURL;
    }

    /**
     * Sets the resource graph node url.
     *
     * @param resourceGraphNodeURL
     *            the new resource graph node url
     */
    public void setResourceGraphNodeURL(final String resourceGraphNodeURL) {
        m_resourceGraphNodeURL = resourceGraphNodeURL;
    }

}
