/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2013 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2013 The OpenNMS Group, Inc.
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

package org.opennms.features.vaadin.nodemaps.internal.gwt.client.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.discotools.gwt.leaflet.client.types.Icon;
import org.discotools.gwt.leaflet.client.types.IconOptions;
import org.discotools.gwt.leaflet.client.types.LatLng;
import org.discotools.gwt.leaflet.client.types.Point;
import org.opennms.features.vaadin.nodemaps.internal.NodeMap;
import org.opennms.features.vaadin.nodemaps.internal.gwt.client.MapNode;
import org.opennms.features.vaadin.nodemaps.internal.gwt.client.NodeMapState;
import org.opennms.features.vaadin.nodemaps.internal.gwt.client.NodeMarker;
import org.opennms.features.vaadin.nodemaps.internal.gwt.client.event.NodeMarkerClusterCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

/**
 * The Class NodeMapConnector.
 */
@Connect(NodeMap.class)
public class NodeMapConnector extends AbstractComponentConnector {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The m_icons. */
    private Map<String, Icon> m_icons;

    /**
     * Instantiates a new node map connector.
     */
    public NodeMapConnector() {
        initializeIcons();
    }

    /**
     * Checks if is retina.
     *
     * @return true, if is retina
     */
    private static final native boolean isRetina() /*-{
                                                   return $wnd.L.Browser.retina;
                                                   }-*/;

    /* (non-Javadoc)
     * @see com.vaadin.client.ui.AbstractComponentConnector#onStateChanged(com.vaadin.client.communication.StateChangeEvent)
     */
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        // Handle all common Vaadin features first
        super.onStateChanged(stateChangeEvent);

        if (stateChangeEvent.hasPropertyChanged("initialSearch")) {
            getWidget().setSearchString(getState().initialSearch);
        }

        if (stateChangeEvent.hasPropertyChanged("nodes")) {
            updateNodes();
        }

    }

    /**
     * Update nodes.
     */
    private void updateNodes() {
        if (getState().nodes.isEmpty()) {
            return;
        }

        final List<NodeMarker> featureCollection = new ArrayList<NodeMarker>();

        for (MapNode node : getState().nodes) {
            final NodeMarker marker = new NodeMarker(new LatLng(node.getLatitude(), node.getLongitude()));
            marker.putProperty(NodeMarker.Property.NODE_ID, node.getNodeId());
            marker.putProperty(NodeMarker.Property.NODE_LABEL, node.getNodeLabel());
            marker.putProperty(NodeMarker.Property.FOREIGN_SOURCE, node.getForeignSource());
            marker.putProperty(NodeMarker.Property.FOREIGN_ID, node.getForeignId());
            marker.putProperty(NodeMarker.Property.DESCRIPTION, node.getDescription());
            marker.putProperty(NodeMarker.Property.MAINTCONTRACT, node.getMaintcontract());
            marker.putProperty(NodeMarker.Property.IP_ADDRESS, node.getIpAddress());
            marker.putProperty(NodeMarker.Property.SEVERITY, node.getSeverity());
            marker.putProperty(NodeMarker.Property.SEVERITY_LABEL, node.getSeverityLabel());

            List<String> categories = node.getCategories();
            if (categories != null) {
                marker.setCategories(categories.toArray(new String[] {}));
            }

            // TODO: Icon handling should be moved to the Widget
            if (m_icons.containsKey(marker.getSeverityLabel())) {
                marker.setIcon(m_icons.get(marker.getSeverityLabel()));
            } else {
                marker.setIcon(m_icons.get("Normal"));
            }

            // TODO: This should be moved to the Widget
            marker.bindPopup(NodeMarkerClusterCallback.getPopupTextForMarker(marker));

            featureCollection.add(marker);
        }
        getWidget().setMarkers(featureCollection);
    }

    /* (non-Javadoc)
     * @see com.vaadin.client.ui.AbstractComponentConnector#getState()
     */
    @Override
    public NodeMapState getState() {
        return (NodeMapState) super.getState();
    }

    /* (non-Javadoc)
     * @see com.vaadin.client.ui.AbstractComponentConnector#createWidget()
     */
    @Override
    protected Widget createWidget() {
        return GWT.create(NodeMapWidget.class);
    }

    /* (non-Javadoc)
     * @see com.vaadin.client.ui.AbstractComponentConnector#getWidget()
     */
    @Override
    public NodeMapWidget getWidget() {
        return (NodeMapWidget) super.getWidget();
    }

    /**
     * Initialize icons.
     */
    private void initializeIcons() {
        if (m_icons == null) {
            m_icons = new HashMap<String, Icon>();
            for (final String severity : new String[] { "Normal", "Warning", "Minor", "Major", "Critical" }) {
                IconOptions options = new IconOptions();
                options.setIconSize(new Point(25, 41));
                options.setIconAnchor(new Point(12, 41));
                options.setPopupAnchor(new Point(1, -34));
                options.setShadowUrl(new Point(41, 41));
                String basePath = GWT.getModuleBaseForStaticFiles() + "images/";
                if (isRetina()) {
                    options.setIconUrl(basePath + severity + "@2x.png");
                } else {
                    options.setIconUrl(basePath + severity + ".png");
                }
                Icon icon = new Icon(options);

                m_icons.put(severity, icon);
            }
        }
    }
}
