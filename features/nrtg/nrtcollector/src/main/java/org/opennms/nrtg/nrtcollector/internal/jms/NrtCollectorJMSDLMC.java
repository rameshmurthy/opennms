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

package org.opennms.nrtg.nrtcollector.internal.jms;

import org.opennms.nrtg.nrtcollector.api.NrtCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.AbstractMessageListenerContainer;

/**
 * A JMS based NrtCollector listening to CollectionJobs using a.
 * {@link org.springframework.jms.listener.AbstractMessageListenerContainer}.
 * Received Jobs will be send to a {@link CollectionJobListener} configured via
 * spring.
 *
 * @author Simon Walter
 */
public class NrtCollectorJMSDLMC implements NrtCollector {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(NrtCollectorJMSDLMC.class);

    /** The listener container. */
    private AbstractMessageListenerContainer listenerContainer;

    /**
     * Sets the listener container.
     *
     * @param listenerContainer
     *            the new listener container
     */
    public void setListenerContainer(AbstractMessageListenerContainer listenerContainer) {
        this.listenerContainer = listenerContainer;
    }

    /* (non-Javadoc)
     * @see org.opennms.nrtg.nrtcollector.api.NrtCollector#start()
     */
    @Override
    public void start() {
        logger.info("Starting instance: " + this.hashCode() + " with destination: ["
                + listenerContainer.getDestinationName() + "] msgListener: [" + listenerContainer.getMessageListener()
                + "]");

        listenerContainer.start();
    }

    /* (non-Javadoc)
     * @see org.opennms.nrtg.nrtcollector.api.NrtCollector#terminated()
     */
    @Override
    public boolean terminated() {
        return !listenerContainer.isRunning();
    }

    /* (non-Javadoc)
     * @see org.opennms.nrtg.nrtcollector.api.NrtCollector#stop()
     */
    @Override
    public void stop() {
        logger.info("Stopping instance: " + this.hashCode());
        listenerContainer.stop();
        listenerContainer.destroy();
    }
}
