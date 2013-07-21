/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2008-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.eventd;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.opennms.netmgt.model.events.EventIpcManager;
import org.opennms.netmgt.model.events.EventIpcManagerProxy;
import org.opennms.netmgt.model.events.EventListener;
import org.opennms.test.ThrowableAnticipator;
import org.opennms.test.mock.EasyMockUtils;

/**
 * The Class EventIpcManagerProxyTest.
 */
public class EventIpcManagerProxyTest extends TestCase {

    /** The m_mocks. */
    private EasyMockUtils m_mocks = new EasyMockUtils();

    /** The m_proxy. */
    private EventIpcManagerProxy m_proxy = new EventIpcManagerProxy();

    /** The m_event listener. */
    private EventListener m_eventListener = m_mocks.createMock(EventListener.class);

    /**
     * Test add event listener no proxy set.
     */
    public void testAddEventListenerNoProxySet() {
        ThrowableAnticipator ta = new ThrowableAnticipator();

        ta.anticipate(new IllegalStateException("property delegate not set; has the event daemon successfully started?"));
        try {
            m_proxy.addEventListener(m_eventListener);
        } catch (Throwable t) {
            ta.throwableReceived(t);
        }

        ta.verifyAnticipated();
    }

    /**
     * Test add event listener with proxy set.
     */
    public void testAddEventListenerWithProxySet() {
        EventIpcManager delegate = EasyMock.createMock(EventIpcManager.class);

        m_proxy.setDelegate(delegate);

        delegate.addEventListener(m_eventListener);

        m_mocks.replayAll();
        m_proxy.addEventListener(m_eventListener);
        m_mocks.verifyAll();
    }
}
