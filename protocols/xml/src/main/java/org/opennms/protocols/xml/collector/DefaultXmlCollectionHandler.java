/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2010-2011 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2011 The OpenNMS Group, Inc.
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

package org.opennms.protocols.xml.collector;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.opennms.netmgt.collectd.CollectionAgent;
import org.opennms.netmgt.collectd.CollectionException;
import org.opennms.netmgt.collectd.ServiceCollector;

import org.opennms.protocols.xml.config.XmlDataCollection;
import org.opennms.protocols.xml.config.XmlGroup;
import org.opennms.protocols.xml.config.XmlObject;
import org.opennms.protocols.xml.config.XmlSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The Class XmlCollector.
 * 
 * @author <a href="mailto:agalue@opennms.org">Alejandro Galue</a>
 */
public class DefaultXmlCollectionHandler extends AbstractXmlCollectionHandler {

    /* (non-Javadoc)
     * @see org.opennms.protocols.xml.collector.XmlCollectionHandler#collect(org.opennms.netmgt.collectd.CollectionAgent, org.opennms.protocols.xml.config.XmlDataCollection, java.util.Map)
     */
    @Override
    public XmlCollectionSet collect(CollectionAgent agent, XmlDataCollection collection, Map<String, Object> parameters) throws CollectionException {
        // Create a new collection set.
        XmlCollectionSet collectionSet = new XmlCollectionSet(agent);
        collectionSet.setCollectionTimestamp(new Date());
        collectionSet.setStatus(ServiceCollector.COLLECTION_UNKNOWN);

        // Load the attribute group types.
        loadAttributes(collection);

        try {
            for (XmlSource source : collection.getXmlSources()) {
                // Retrieve the XML data
                String urlStr = parseUrl(source.getUrl(), agent, collection.getXmlRrd().getStep());
                Document doc = getXmlDocument(agent, urlStr);

                // Cycle through all of the queries for this collection
                XPath xpath = XPathFactory.newInstance().newXPath();
                for (XmlGroup group : source.getXmlGroups()) {
                    log().debug("collect: getting resources for XML group " + group.getName() + " using XPATH " + group.getResourceXpath());
                    Date timestamp = getTimeStamp(doc, xpath, group);
                    NodeList resourceList = (NodeList) xpath.evaluate(group.getResourceXpath(), doc, XPathConstants.NODESET);
                    for (int j = 0; j < resourceList.getLength(); j++) {
                        Node resource = resourceList.item(j);
                        Node resourceName = (Node) xpath.evaluate(group.getKeyXpath(), resource, XPathConstants.NODE);
                        log().debug("collect: processing XML resource " + resourceName);
                        XmlCollectionResource collectionResource = getCollectionResource(agent, resourceName.getNodeValue(), group.getResourceType(), timestamp);
                        for (XmlObject object : group.getXmlObjects()) {
                            String value = (String) xpath.evaluate(object.getXpath(), resource, XPathConstants.STRING);
                            collectionResource.setAttributeValue(getCollectionAttributeType(object.getName()), value);
                        }
                        collectionSet.getCollectionResources().add(collectionResource);
                    }
                }
            }
            collectionSet.setStatus(ServiceCollector.COLLECTION_SUCCEEDED);
            return collectionSet;
        } catch (Exception e) {
            collectionSet.setStatus(ServiceCollector.COLLECTION_FAILED);
            throw new CollectionException("Can't collect XML data because " + e.getMessage(), e);
        }
    }

    /**
     * Gets the XML document.
     *
     * @param agent the collection agent
     * @param urlString the URL string
     * @return the XML document
     */
    protected Document getXmlDocument(CollectionAgent agent, String urlString) {
        try {
            URL url = UrlFactory.getUrl(urlString);
            URLConnection c = url.openConnection();
            c.connect();
            InputStream is = c.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            UrlFactory.disconnect(c);
            return doc;
        } catch (Exception e) {
            throw new XmlCollectorException("Can't retrieve data from " + urlString + " because " + e.getMessage(), e);
        }
    }

}