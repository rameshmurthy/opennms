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

package org.opennms.netmgt.ncs.persistence;

import java.util.LinkedHashSet;
import java.util.Set;

import org.opennms.netmgt.EventConstants;
import org.opennms.netmgt.model.events.EventBuilder;
import org.opennms.netmgt.model.events.EventProxy;
import org.opennms.netmgt.model.events.EventProxyException;
import org.opennms.netmgt.xml.event.Event;

/**
 * The Class ComponentEventQueue.
 */
public final class ComponentEventQueue {

    /** The m_added. */
    private final Set<ComponentIdentifier> m_added = new LinkedHashSet<ComponentIdentifier>();

    /** The m_deleted. */
    private final Set<ComponentIdentifier> m_deleted = new LinkedHashSet<ComponentIdentifier>();

    /** The m_updated. */
    private final Set<ComponentIdentifier> m_updated = new LinkedHashSet<ComponentIdentifier>();

    /**
     * Component added.
     *
     * @param identifier
     *            the identifier
     */
    public void componentAdded(final ComponentIdentifier identifier) {
        m_added.add(identifier);
        m_deleted.remove(identifier);
        m_updated.remove(identifier);
    }

    /**
     * Component deleted.
     *
     * @param identifier
     *            the identifier
     */
    public void componentDeleted(final ComponentIdentifier identifier) {
        m_added.remove(identifier);
        m_deleted.add(identifier);
        m_updated.remove(identifier);
    }

    /**
     * Component updated.
     *
     * @param identifier
     *            the identifier
     */
    public void componentUpdated(final ComponentIdentifier identifier) {
        m_added.remove(identifier);
        m_deleted.remove(identifier);
        m_updated.add(identifier);
    }

    /**
     * Send all.
     *
     * @param eventProxy
     *            the event proxy
     * @throws EventProxyException
     *             the event proxy exception
     */
    public void sendAll(final EventProxy eventProxy) throws EventProxyException {
        for (final ComponentIdentifier id : m_deleted) {
            final String uei = EventConstants.COMPONENT_DELETED_UEI;
            eventProxy.send(getEvent(uei, id));
        }
        for (final ComponentIdentifier id : m_added) {
            final String uei = EventConstants.COMPONENT_ADDED_UEI;
            eventProxy.send(getEvent(uei, id));
        }
        for (final ComponentIdentifier id : m_updated) {
            final String uei = EventConstants.COMPONENT_UPDATED_UEI;
            eventProxy.send(getEvent(uei, id));
        }
    }

    /**
     * Gets the event.
     *
     * @param uei
     *            the uei
     * @param id
     *            the id
     * @return the event
     */
    private Event getEvent(final String uei, final ComponentIdentifier id) {
        final EventBuilder builder = new EventBuilder(uei, "NCSComponentService");
        builder.addParam("componentId", id.getId());
        builder.addParam("componentType", id.getType());
        builder.addParam("componentName", id.getName());
        builder.addParam("componentForeignSource", id.getForeignSource());
        builder.addParam("componentForeignId", id.getForeignId());
        builder.addParam("dependencyRequirements", id.getDependencyRequirements().toString());
        final Event event = builder.getEvent();
        return event;
    }
}
