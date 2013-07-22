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

package org.opennms.nrtg.api;

import java.util.List;

import org.opennms.nrtg.api.model.CollectionJob;
import org.opennms.nrtg.api.model.MeasurementSet;

/**
 * Abstraction for communication of the nrt feature.
 * Implementations could be message brokers or simple forwarding queues.
 *
 * @author Christian Pape
 * @author Markus Neumann
 */
public interface NrtBroker {

    /**
     * Publish collection job.
     *
     * @param collectionJob
     *            the collection job
     */
    void publishCollectionJob(CollectionJob collectionJob);

    /**
     * Receive measurement sets.
     *
     * @param destination
     *            the destination
     * @return the list
     */
    List<MeasurementSet> receiveMeasurementSets(String destination);

}
