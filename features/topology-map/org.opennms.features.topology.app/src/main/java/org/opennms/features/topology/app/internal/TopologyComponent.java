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

package org.opennms.features.topology.app.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.opennms.features.topology.api.BoundingBox;
import org.opennms.features.topology.api.Graph;
import org.opennms.features.topology.api.GraphContainer;
import org.opennms.features.topology.api.GraphContainer.ChangeListener;
import org.opennms.features.topology.api.GraphVisitor;
import org.opennms.features.topology.api.MapViewManager;
import org.opennms.features.topology.api.MapViewManagerListener;
import org.opennms.features.topology.api.Point;
import org.opennms.features.topology.api.SelectionContext;
import org.opennms.features.topology.api.SelectionListener;
import org.opennms.features.topology.api.topo.Edge;
import org.opennms.features.topology.api.topo.Vertex;
import org.opennms.features.topology.api.topo.VertexRef;
import org.opennms.features.topology.app.internal.gwt.client.TopologyComponentServerRpc;
import org.opennms.features.topology.app.internal.gwt.client.TopologyComponentState;
import org.opennms.features.topology.app.internal.support.IconRepositoryManager;

import com.vaadin.annotations.JavaScript;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

/**
 * The Class TopologyComponent.
 */
@JavaScript({ "gwt/public/topologywidget/js/d3.v3.js", "gwt/public/topologywidget/js/d3.interpolate-zoom.v0.js" })
public class TopologyComponent extends AbstractComponent implements ChangeListener, ValueChangeListener,
        MapViewManagerListener {

    /** The m_rpc. */
    TopologyComponentServerRpc m_rpc = new TopologyComponentServerRpc() {

        private static final long serialVersionUID = 6945103738578953304L;

        @Override
        public void doubleClicked(MouseEventDetails eventDetails) {
            double scale = getViewManager().getScale() + 0.25;
            getViewManager().zoomToPoint(scale, new Point(eventDetails.getClientX(), eventDetails.getClientY()));
        }

        @Override
        public void deselectAllItems() {
            m_graphContainer.getSelectionManager().deselectAll();
        }

        @Override
        public void edgeClicked(String edgeId) {
            selectEdge(edgeId);
        }

        @Override
        public void backgroundClicked() {
            m_graphContainer.getSelectionManager().deselectAll();
        }

        @Override
        public void scrollWheel(double scrollVal, int x, int y) {
            getViewManager().zoomToPoint(getViewManager().getScale() - scrollVal, new Point(x, y));
        }

        @Override
        public void mapPhysicalBounds(int width, int height) {
            getViewManager().setViewPort(width, height);
        }

        @Override
        public void marqueeSelection(String[] vertexKeys, MouseEventDetails eventDetails) {
            selectVertices(eventDetails.isShiftKey(), eventDetails.isCtrlKey(), vertexKeys);
        }

        @Override
        public void contextMenu(String target, String type, int x, int y) {

            Object menuTarget = null;
            if (type.toLowerCase().equals("vertex")) {
                String targetKey = target;
                menuTarget = getGraph().getVertexByKey(targetKey);
            } else if (type.toLowerCase().equals("edge")) {
                String targetKey = (String) target;
                menuTarget = getGraph().getEdgeByKey(targetKey);
            }

            m_contextMenuHandler.show(menuTarget, x, y);

        }

        @Override
        public void clientCenterPoint(int x, int y) {
            getViewManager().setCenter(new Point(x, y));
        }

        @Override
        public void vertexClicked(String vertexId, MouseEventDetails eventDetails, String platform) {
            selectVertices(eventDetails.isShiftKey(), eventDetails.isCtrlKey(), vertexId);
        }

        @Override
        public void updateVertices(List<String> vertices) {
            for (String vUpdate : vertices) {
                updateVertex(vUpdate);
            }

            fireVertexUpdated();
            if (vertices.size() > 0) {
                updateGraph();
            }
        }

        @Override
        public void backgroundDoubleClick(double x, double y) {
            // TODO: set the center point and zoom in by 25%
        }

    };

    /**
     * The listener interface for receiving vertexUpdate events.
     * The class that is interested in processing a vertexUpdate
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addVertexUpdateListener<code> method. When
     * the vertexUpdate event occurs, that object's appropriate
     * method is invoked.
     *
     * @see VertexUpdateEvent
     */
    public interface VertexUpdateListener {

        /**
         * On vertex update.
         */
        public void onVertexUpdate();
    }

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The m_graph container. */
    private final GraphContainer m_graphContainer;

    /** The m_graph. */
    private Graph m_graph;

    /** The m_menu item state listener. */
    private final List<MenuItemUpdateListener> m_menuItemStateListener = new ArrayList<MenuItemUpdateListener>();

    /** The m_context menu handler. */
    private final ContextMenuHandler m_contextMenuHandler;

    /** The m_icon repo manager. */
    private final IconRepositoryManager m_iconRepoManager;

    /** The m_active tool. */
    private String m_activeTool = "pan";

    /** The m_block selection events. */
    private boolean m_blockSelectionEvents = false;

    /** The m_vertex update listeners. */
    private Set<VertexUpdateListener> m_vertexUpdateListeners = new CopyOnWriteArraySet<VertexUpdateListener>();

    /**
     * Instantiates a new topology component.
     *
     * @param dataSource
     *            the data source
     * @param iconRepositoryManager
     *            the icon repository manager
     * @param contextMenuHandler
     *            the context menu handler
     */
    public TopologyComponent(GraphContainer dataSource, IconRepositoryManager iconRepositoryManager,
            ContextMenuHandler contextMenuHandler) {
        m_graphContainer = dataSource;
        m_iconRepoManager = iconRepositoryManager;
        m_contextMenuHandler = contextMenuHandler;

        registerRpc(m_rpc);

        setGraph(m_graphContainer.getGraph());

        m_graphContainer.getSelectionManager().addSelectionListener(new SelectionListener() {

            @Override
            public void selectionChanged(SelectionContext selectionContext) {
                if (!m_blockSelectionEvents) {
                    computeBoundsForSelected(selectionContext);
                }
                updateGraph();
            }
        });

        m_graphContainer.getMapViewManager().addListener(this);
        m_graphContainer.addChangeListener(this);

        setScaleDataSource(m_graphContainer.getScaleProperty());

        updateGraph();
    }

    /**
     * Sets the scale data source.
     *
     * @param scale
     *            the new scale data source
     */
    private void setScaleDataSource(Property<Double> scale) {
        // Listens the new data source if possible
        if (scale != null && Property.ValueChangeNotifier.class.isAssignableFrom(scale.getClass())) {
            ((Property.ValueChangeNotifier) scale).addValueChangeListener(this);
        }
    }

    /* (non-Javadoc)
     * @see com.vaadin.ui.AbstractComponent#getState()
     */
    @Override
    protected TopologyComponentState getState() {
        return (TopologyComponentState) super.getState();
    }

    /**
     * Update graph.
     */
    public void updateGraph() {
        BoundingBox boundingBox = getBoundingBox();
        getState().setBoundX(boundingBox.getX());
        getState().setBoundY(boundingBox.getY());
        getState().setBoundWidth(boundingBox.getWidth());
        getState().setBoundHeight(boundingBox.getHeight());
        getState().setActiveTool(m_activeTool);

        Graph graph = getGraph();
        // Set Status provider from the graph container because I may move it
        // later
        GraphVisitor painter = new GraphPainter(m_graphContainer, graph.getLayout(), m_iconRepoManager,
                                                m_graphContainer.getStatusProvider(), getState());
        try {
            graph.visit(painter);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Gets the bounding box.
     *
     * @return the bounding box
     */
    private BoundingBox getBoundingBox() {

        return getViewManager().getCurrentBoundingBox();
    }

    /**
     * Select vertices.
     *
     * @param shiftModifierPressed
     *            the shift modifier pressed
     * @param ctrlModifierPressed
     *            the ctrl modifier pressed
     * @param vertexKeys
     *            the vertex keys
     */
    private void selectVertices(boolean shiftModifierPressed, boolean ctrlModifierPressed, String... vertexKeys) {
        m_blockSelectionEvents = true;
        List<VertexRef> vertexRefsToSelect = new ArrayList<VertexRef>(vertexKeys.length);
        List<VertexRef> vertexRefsToDeselect = new ArrayList<VertexRef>();
        boolean add = shiftModifierPressed || ctrlModifierPressed;
        for (String eachVertexKey : vertexKeys) {
            if (ctrlModifierPressed
                    && m_graphContainer.getSelectionManager().isVertexRefSelected(m_graph.getVertexByKey(eachVertexKey))) {
                vertexRefsToDeselect.add(getGraph().getVertexByKey(eachVertexKey)); // we
                                                                                    // want
                                                                                    // it
                                                                                    // to
                                                                                    // be
                                                                                    // unselected
            } else {
                vertexRefsToSelect.add(getGraph().getVertexByKey(eachVertexKey));
            }
        }
        if (add) { // we want to add, so add the already selected ones (except
                   // the explicit removed ones)
            vertexRefsToSelect.addAll(m_graphContainer.getSelectionManager().getSelectedVertexRefs());
            vertexRefsToSelect.removeAll(vertexRefsToDeselect);
        }
        m_graphContainer.getSelectionManager().deselectAll();
        m_graphContainer.getSelectionManager().selectVertexRefs(m_graphContainer.getVertexRefForest(vertexRefsToSelect));
        m_blockSelectionEvents = false;
    }

    /**
     * Select edge.
     *
     * @param edgeKey
     *            the edge key
     */
    private void selectEdge(String edgeKey) {
        Edge edge = getGraph().getEdgeByKey(edgeKey);

        m_graphContainer.getSelectionManager().setSelectedEdgeRefs(Collections.singleton(edge));

    }

    /**
     * Update vertex.
     *
     * @param vertexUpdate
     *            the vertex update
     */
    private void updateVertex(String vertexUpdate) {
        String[] vertexProps = vertexUpdate.split("\\|");

        String id = vertexProps[0].split(",")[1];
        int x = (int) Double.parseDouble(vertexProps[1].split(",")[1]);
        int y = (int) Double.parseDouble(vertexProps[2].split(",")[1]);
        boolean selected = vertexProps[3].split(",")[1].equals("true");

        Vertex vertex = getGraph().getVertexByKey(id);

        getGraph().getLayout().setLocation(vertex, x, y);

        if (selected) {
            m_graphContainer.getSelectionManager().selectVertexRefs(Collections.singleton(vertex));
        } else {
            m_graphContainer.getSelectionManager().deselectVertexRefs(Collections.singleton(vertex));
        }
    }

    /**
     * Sets the scale.
     *
     * @param scale
     *            the new scale
     */
    protected void setScale(double scale) {
        m_graphContainer.setScale(scale);
    }

    /**
     * Gets the graph.
     *
     * @return the graph
     */
    protected Graph getGraph() {
        return m_graph;
    }

    /**
     * Sets the graph.
     *
     * @param graph
     *            the new graph
     */
    private void setGraph(Graph graph) {
        m_graph = graph;
        getViewManager().setMapBounds(graph.getLayout().getBounds());
    }

    /**
     * Adds the menu item state listener.
     *
     * @param listener
     *            the listener
     */
    public void addMenuItemStateListener(MenuItemUpdateListener listener) {
        m_menuItemStateListener.add(listener);
    }

    /**
     * Removes the menu item state listener.
     *
     * @param listener
     *            the listener
     */
    public void removeMenuItemStateListener(MenuItemUpdateListener listener) {
        m_menuItemStateListener.remove(listener);
    }

    /**
     * Update menu items.
     */
    private void updateMenuItems() {
        for (MenuItemUpdateListener listener : m_menuItemStateListener) {
            listener.updateMenuItems();
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.GraphContainer.ChangeListener#graphChanged(org.opennms.features.topology.api.GraphContainer)
     */
    @Override
    public void graphChanged(GraphContainer container) {
        Graph graph = container.getGraph();
        setGraph(graph);

        getViewManager().setMapBounds(graph.getLayout().getBounds());
        computeBoundsForSelected(m_graphContainer.getSelectionManager());
    }

    /**
     * ValueChange listener for the scale property.
     *
     * @param event
     *            the event
     */
    @Override
    public void valueChange(ValueChangeEvent event) {

        double scale = (Double) event.getProperty().getValue();

        getViewManager().setScale(scale);

    }

    /**
     * Sets the active tool.
     *
     * @param toolname
     *            the new active tool
     */
    public void setActiveTool(String toolname) {
        if (!m_activeTool.equals(toolname)) {
            m_activeTool = toolname;
            getState().setActiveTool(toolname);
            updateGraph();
        }
    }

    /**
     * Compute bounds for selected.
     *
     * @param selectionContext
     *            the selection context
     */
    private void computeBoundsForSelected(SelectionContext selectionContext) {
        if (selectionContext.getSelectedVertexRefs().size() > 0) {
            Collection<? extends Vertex> visible = m_graphContainer.getGraph().getDisplayVertices();
            Collection<VertexRef> selected = selectionContext.getSelectedVertexRefs();
            Collection<VertexRef> vRefs = new ArrayList<VertexRef>();
            for (VertexRef vRef : selected) {
                if (visible.contains(vRef)) {
                    vRefs.add(vRef);
                }
            }

            getViewManager().setBoundingBox(m_graphContainer.getGraph().getLayout().computeBoundingBox(vRefs));

        } else {
            getViewManager().setBoundingBox(m_graphContainer.getGraph().getLayout().getBounds());
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.features.topology.api.MapViewManagerListener#boundingBoxChanged(org.opennms.features.topology.api.MapViewManager)
     */
    @Override
    public void boundingBoxChanged(MapViewManager viewManager) {
        setScale(viewManager.getScale());
        updateGraph();
    }

    /**
     * Gets the view manager.
     *
     * @return the view manager
     */
    public MapViewManager getViewManager() {
        return m_graphContainer.getMapViewManager();
    }

    /**
     * Adds the vertex update listener.
     *
     * @param listener
     *            the listener
     */
    public void addVertexUpdateListener(VertexUpdateListener listener) {
        m_vertexUpdateListeners.add(listener);
    }

    /**
     * Fire vertex updated.
     */
    private void fireVertexUpdated() {
        for (VertexUpdateListener listener : m_vertexUpdateListeners) {
            listener.onVertexUpdate();
        }
    }

}
