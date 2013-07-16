/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2009-2012 The OpenNMS Group, Inc.
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2009.01.29 at 01:15:48 PM EST
//


package org.opennms.netmgt.provision.persist.requisition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Transient;
import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opennms.core.xml.ValidateUsing;
import org.opennms.netmgt.provision.persist.OnmsNodeRequisition;
import org.opennms.netmgt.provision.persist.RequisitionVisitor;
import org.springframework.core.io.Resource;


/**
 * <p>Requisition class.</p>
 *
 * @author ranger
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="model-import")
@ValidateUsing("model-import.xsd")
public class Requisition implements Serializable, Comparable<Requisition> {
    private static final Logger LOG = LoggerFactory.getLogger(Requisition.class);
    private static final long serialVersionUID = 1629774241824443273L;

    @XmlTransient
    private Map<String, OnmsNodeRequisition> m_nodeReqs = new LinkedHashMap<String, OnmsNodeRequisition>();

    @XmlElement(name="node")
    protected List<RequisitionNode> m_nodes = new ArrayList<RequisitionNode>();

    @XmlAttribute(name="date-stamp")
    protected XMLGregorianCalendar m_dateStamp;

    @XmlAttribute(name="foreign-source")
    protected String m_foreignSource = "imported:";

    @XmlAttribute(name="last-import")
    protected XMLGregorianCalendar m_lastImport;

    @XmlTransient
    /** the resource that this requisition was created from **/
    private Resource m_resource;

    /**
     * <p>getNode</p>
     *
     * @param foreignId a {@link java.lang.String} object.
     * @return a {@link org.opennms.netmgt.provision.persist.requisition.RequisitionNode} object.
     */
    public RequisitionNode getNode(String foreignId) {
        if (m_nodes != null) {
            for (RequisitionNode n : m_nodes) {
                if (n.getForeignId().equals(foreignId)) {
                	LOG.debug("returning node '{}' for foreign id '{}'", n, foreignId);
                    return n;
                }
            }
        }
        return null;
    }

    /**
     * <p>removeNode</p>
     *
     * @param node a {@link org.opennms.netmgt.provision.persist.requisition.RequisitionNode} object.
     */
    public void deleteNode(RequisitionNode node) {
        if (m_nodes != null) {
            Iterator<RequisitionNode> i = m_nodes.iterator();
            while (i.hasNext()) {
                RequisitionNode n = i.next();
                if (n.getForeignId().equals(node.getForeignId())) {
                    i.remove();
                    break;
                }
            }
        }
    }

    /**
     * <p>deleteNode</p>
     *
     * @param foreignId a {@link java.lang.String} object.
     */
    public void deleteNode(final String foreignId) {
        if (m_nodes != null) {
        	final Iterator<RequisitionNode> i = m_nodes.iterator();
            while (i.hasNext()) {
                final RequisitionNode n = i.next();
                if (n.getForeignId().equals(foreignId)) {
                    i.remove();
                    break;
                }
            }
        }
    }

    /* backwards-compat with ModelImport */
    /**
     * <p>getNode</p>
     *
     * @return an array of {@link org.opennms.netmgt.provision.persist.requisition.RequisitionNode} objects.
     */
    @XmlTransient
    public RequisitionNode[] getNode() {
        return getNodes().toArray(new RequisitionNode[] {});
    }

    /**
     * <p>getNodes</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<RequisitionNode> getNodes() {
        return m_nodes;
    }

    /**
     * <p>setNodes</p>
     *
     * @param nodes a {@link java.util.List} object.
     */
    public void setNodes(final List<RequisitionNode> nodes) {
        m_nodes = nodes;
        updateNodeCache();
    }

    /**
     * <p>insertNode</p>
     *
     * @param node a {@link org.opennms.netmgt.provision.persist.requisition.RequisitionNode} object.
     */
    public void insertNode(final RequisitionNode node) {
        updateNodeCacheIfNecessary();
        if (m_nodeReqs.containsKey(node.getForeignId())) {
        	final RequisitionNode n = m_nodeReqs.get(node.getForeignId()).getNode();
            m_nodes.remove(n);
        }
        m_nodes.add(0, node);
        m_nodeReqs.put(node.getForeignId(), new OnmsNodeRequisition(getForeignSource(), node));
    }

    /**
     * <p>putNode</p>
     *
     * @param node a {@link org.opennms.netmgt.provision.persist.requisition.RequisitionNode} object.
     */
    public void putNode(final RequisitionNode node) {
        updateNodeCacheIfNecessary();
        if (m_nodeReqs.containsKey(node.getForeignId())) {
            final RequisitionNode n = m_nodeReqs.get(node.getForeignId()).getNode();
            m_nodes.remove(n);
        }
        m_nodes.add(node);
        m_nodeReqs.put(node.getForeignId(), new OnmsNodeRequisition(getForeignSource(), node));
    }

    /**
     * <p>getDateStamp</p>
     *
     * @return a {@link javax.xml.datatype.XMLGregorianCalendar} object.
     */
    public XMLGregorianCalendar getDateStamp() {
        return m_dateStamp;
    }

    /**
     * <p>setDateStamp</p>
     *
     * @param value a {@link javax.xml.datatype.XMLGregorianCalendar} object.
     */
    public void setDateStamp(final XMLGregorianCalendar value) {
        m_dateStamp = value;
    }

    /**
     * <p>updateDateStamp</p>
     */
    public void updateDateStamp() {
        try {
            m_dateStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (final DatatypeConfigurationException e) {
            LOG.warn("unable to update datestamp", e);
        }
    }

    /**
     * <p>getForeignSource</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getForeignSource() {
        if (m_foreignSource == null) {
            return "imported:";
        } else {
            return m_foreignSource;
        }
    }

    /**
     * <p>setForeignSource</p>
     *
     * @param value a {@link java.lang.String} object.
     */
    public void setForeignSource(final String value) {
        m_foreignSource = value;
    }

    /**
     * <p>getLastImport</p>
     *
     * @return a {@link javax.xml.datatype.XMLGregorianCalendar} object.
     */
    public XMLGregorianCalendar getLastImport() {
        return m_lastImport;
    }

    /**
     * <p>setLastImport</p>
     *
     * @param value a {@link javax.xml.datatype.XMLGregorianCalendar} object.
     */
    public void setLastImport(final XMLGregorianCalendar value) {
        m_lastImport = value;
    }

    /**
     * Update the last imported stamp to the current date and time
     */
    public void updateLastImported() {
        try {
            m_lastImport = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (final DatatypeConfigurationException e) {
            LOG.warn("unable to update last import datestamp", e);
        }
    }

    /* Start non-JAXB methods */

    /**
     * <p>Constructor for Requisition.</p>
     */
    public Requisition() {
        updateNodeCache();
        updateDateStamp();
    }

    /**
     * <p>Constructor for Requisition.</p>
     *
     * @param foreignSource a {@link java.lang.String} object.
     */
    public Requisition(final String foreignSource) {
        this();
        m_foreignSource = foreignSource;
    }

    /**
     * Get the resource (if any) this requisition is associated with.
     * @return a Resource representing the location of the requisition file
     */
    public Resource getResource() {
        return m_resource;
    }

    public void setResource(final Resource resource) {
        m_resource = resource;
    }

    private void updateNodeCache() {
        m_nodeReqs.clear();
        if (m_nodes != null) {
            for (final RequisitionNode n : m_nodes) {
                m_nodeReqs.put(n.getForeignId(), new OnmsNodeRequisition(getForeignSource(), n));
            }
        }
    }

	private void updateNodeCacheIfNecessary() {
		if (m_nodes != null && m_nodeReqs.size() != m_nodes.size()) {
            updateNodeCache();
        }
	}

    /**
     * <p>visit</p>
     *
     * @param visitor a {@link org.opennms.netmgt.provision.persist.RequisitionVisitor} object.
     */
    public void visit(final RequisitionVisitor visitor) {
        updateNodeCacheIfNecessary();

        if (visitor == null) {
            LOG.warn("no visitor specified!");
            return;
        }

        visitor.visitModelImport(this);

        for (final OnmsNodeRequisition nodeReq : m_nodeReqs.values()) {
            nodeReq.visit(visitor);
        }

        visitor.completeModelImport(this);
    }

    /**
     * <p>getNodeRequistion</p>
     *
     * @param foreignId a {@link java.lang.String} object.
     * @return a {@link org.opennms.netmgt.provision.persist.OnmsNodeRequisition} object.
     */
    public OnmsNodeRequisition getNodeRequistion(final String foreignId) {
        updateNodeCacheIfNecessary();
        return m_nodeReqs.get(foreignId);
    }

    /**
     * <p>getNodeCount</p>
     *
     * @return a int.
     */
    @XmlTransient
    public int getNodeCount() {
        return (m_nodes == null) ? 0 : m_nodes.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((m_dateStamp == null) ? 0 : m_dateStamp.hashCode());
        result = prime * result + ((m_foreignSource == null) ? 0 : m_foreignSource.hashCode());
        result = prime * result + ((m_lastImport == null) ? 0 : m_lastImport.hashCode());
        result = prime * result + ((m_nodes == null) ? 0 : m_nodes.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Requisition))  return false;

        final Requisition other = (Requisition) obj;
        if (m_dateStamp == null) {
            if (other.m_dateStamp != null) return false;
        } else if (!m_dateStamp.equals(other.m_dateStamp)) {
            return false;
        }
        if (m_foreignSource == null) {
            if (other.m_foreignSource != null) return false;
        } else if (!m_foreignSource.equals(other.m_foreignSource)) {
            return false;
        }
        if (m_lastImport == null) {
            if (other.m_lastImport != null) return false;
        } else if (!m_lastImport.equals(other.m_lastImport)) {
            return false;
        }
        if (m_nodes == null) {
            if (other.m_nodes != null) return false;
        } else if (!m_nodes.equals(other.m_nodes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Requisition [nodes="
                + m_nodes + ", dateStamp=" + m_dateStamp
                + ", foreignSource=" + m_foreignSource + ", lastImport="
                + m_lastImport + "]";
    }

    /**
     * <p>compareTo</p>
     *
     * @param obj a {@link org.opennms.netmgt.provision.persist.requisition.Requisition} object.
     * @return a int.
     */
    @Override
    public int compareTo(final Requisition obj) {
        return new CompareToBuilder()
            .append(m_foreignSource, obj.m_foreignSource)
            .append(m_dateStamp, obj.m_dateStamp)
            .append(m_lastImport, obj.m_lastImport)
            .toComparison();
    }

    /**
     * Make sure that no data in the requisition is inconsistent.  Nodes should be unique,
     * interfaces should be unique per node, etc.
     */
    public void validate() throws ValidationException {
    	final Map<String,Integer> foreignSourceCounts = new HashMap<String,Integer>();
    	final Set<String> errors = new HashSet<String>();

    	for (final RequisitionNode node : m_nodes) {
    		final String foreignId = node.getForeignId();
			Integer count = foreignSourceCounts.get(foreignId);
			foreignSourceCounts.put(foreignId, count == null? 1 : ++count);
    	}

    	for (final String foreignId : foreignSourceCounts.keySet()) {
    		final Integer count = foreignSourceCounts.get(foreignId);
    		if (count > 1) {
    			errors.add( foreignId + " (" + count + " found)");
    		}
    	}

    	if (errors.size() > 0) {
    		final StringBuilder sb = new StringBuilder();
    		sb.append("Duplicate nodes found on foreign source ").append(getForeignSource()).append(": ");
    		final Iterator<String> it = errors.iterator();
    		while (it.hasNext()) {
    			final String error = it.next();
    			sb.append(error);
    			if (it.hasNext()) {
    				sb.append(", ");
    			}
    		}
    		throw new ValidationException(sb.toString());
    	}
    }

    @XmlTransient
    @Transient
    public Date getDate() {
        return getDateStamp() == null? null : getDateStamp().toGregorianCalendar().getTime();
    }

    public void setDate(final Date date) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        try {
            setDateStamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
        } catch (final DatatypeConfigurationException e) {
            LOG.warn("Failed to turn {} into an XML date.", date);
        }
    }
}
