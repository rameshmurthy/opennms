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

package org.opennms.features.topology.plugins.topo.simple.internal.operations;

import java.util.List;

import org.opennms.features.topology.api.Constants;
import org.opennms.features.topology.api.Operation;
import org.opennms.features.topology.api.OperationContext;
import org.opennms.features.topology.api.topo.Vertex;
import org.opennms.features.topology.api.topo.VertexRef;

/**
 * The Class ResetOperation.
 */
public class ResetOperation implements Constants, Operation {

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#execute(java.util.List, org.opennms.features.topology.api.OperationContext)
     */
    @Override
    public Undoer execute(List<VertexRef> targets, OperationContext operationContext) {

        operationContext.getGraphContainer().getBaseTopology().resetContainer();
        Vertex groupId = operationContext.getGraphContainer().getBaseTopology().addGroup("Group", GROUP_ICON_KEY);
        Vertex vertexId = operationContext.getGraphContainer().getBaseTopology().addVertex(50, 50);
        operationContext.getGraphContainer().getBaseTopology().setParent(vertexId, groupId);
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#display(java.util.List, org.opennms.features.topology.api.OperationContext)
     */
    @Override
    public boolean display(List<VertexRef> targets, OperationContext operationContext) {
        return true;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#enabled(java.util.List, org.opennms.features.topology.api.OperationContext)
     */
    @Override
    public boolean enabled(List<VertexRef> targets, OperationContext operationContext) {
        return true;
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.Operation#getId()
     */
    @Override
    public String getId() {
        return "Reset";
    }
}
