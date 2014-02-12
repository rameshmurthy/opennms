/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
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

package org.opennms.protocols.xml.vtdxml;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.opennms.netmgt.collectd.CollectionAgent;
import org.opennms.netmgt.collectd.CollectionException;
import org.opennms.netmgt.collectd.ServiceCollector;
import org.opennms.netmgt.config.collector.AttributeGroupType;
import org.opennms.protocols.xml.collector.XmlCollectionResource;
import org.opennms.protocols.xml.collector.XmlCollectionSet;
import org.opennms.protocols.xml.config.Request;
import org.opennms.protocols.xml.config.XmlDataCollection;
import org.opennms.protocols.xml.config.XmlSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ximpleware.VTDNav;

/**
 * The Class DefaultVTDXmlCollectionHandler.
 *
 * @author <a href="mailto:ronald.roskens@gmail.com">Ronald Roskens</a>
 */
public class DefaultVTDXmlCollectionHandler extends AbstractVTDXmlCollectionHandler {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultVTDXmlCollectionHandler.class);

    /* (non-Javadoc)
     * @see org.opennms.protocols.xml.collector.XmlCollectionHandler#collect(org.opennms.netmgt.collectd.CollectionAgent, org.opennms.protocols.xml.config.XmlDataCollection, java.util.Map)
     */
    @Override
    public XmlCollectionSet collect(CollectionAgent agent, XmlDataCollection collection, Map<String, Object> parameters) throws CollectionException {
        XmlCollectionSet collectionSet = new XmlCollectionSet(agent);
        collectionSet.setCollectionTimestamp(new Date());
        collectionSet.setStatus(ServiceCollector.COLLECTION_UNKNOWN);
        DateTime startTime = new DateTime();
        try {
            LOG.debug("collect: looping sources for collection {}", collection.getName());
            for (XmlSource source : collection.getXmlSources()) {
                LOG.debug("collect: starting source url '{}' collection", source.getUrl());
                String urlStr = parseUrl(source.getUrl(), agent, collection.getXmlRrd().getStep());
                LOG.debug("collect: parsed url for source url '{}'", source.getUrl());
                Request request = parseRequest(source.getRequest(), agent);
                LOG.debug("collect: parsed request for source url '{}'", source.getUrl());
                VTDNav vn = getVTDXmlDocument(urlStr, request);
                LOG.debug("collect: parsed document for source url '{}' collection", source.getUrl());
                fillCollectionSet(agent, collectionSet, source, vn);
                LOG.debug("collect: finished source url '{}' collection", source.getUrl());
            }
            collectionSet.setStatus(ServiceCollector.COLLECTION_SUCCEEDED);
            DateTime endTime = new DateTime();
            LOG.debug("collect: finished collection {}: duration: {}", collection.getName(), endTime.getMillis()-startTime.getMillis());
            return collectionSet;
        } catch (Exception e) {
            collectionSet.setStatus(ServiceCollector.COLLECTION_FAILED);
            DateTime endTime = new DateTime();
            LOG.debug("collect: failed collection {}: duration: {}", collection.getName(), endTime.getMillis()-startTime.getMillis());
            throw new CollectionException(e.getMessage(), e);
        }
    }

    /* (non-Javadoc)
     * @see org.opennms.protocols.xml.collector.AbstractXmlCollectionHandler#processXmlResource(org.opennms.protocols.xml.collector.XmlCollectionResource, org.opennms.netmgt.config.collector.AttributeGroupType)
     */
    @Override
    protected void processXmlResource(XmlCollectionResource collectionResource, AttributeGroupType attribGroupType) {}
}
