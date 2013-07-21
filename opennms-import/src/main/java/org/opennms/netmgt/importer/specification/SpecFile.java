/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.importer.specification;

import java.io.IOException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.opennms.core.xml.CastorUtils;
import org.opennms.netmgt.importer.ModelImportException;
import org.opennms.netmgt.importer.config.Asset;
import org.opennms.netmgt.importer.config.Category;
import org.opennms.netmgt.importer.config.Interface;
import org.opennms.netmgt.importer.config.ModelImport;
import org.opennms.netmgt.importer.config.MonitoredService;
import org.opennms.netmgt.importer.config.Node;
import org.springframework.core.io.Resource;

/**
 * <p>
 * SpecFile class.
 * </p>
 *
 * @author ranger
 * @version $Id: $
 */
public class SpecFile {

    /** The m_mi. */
    private ModelImport m_mi;

    /**
     * <p>
     * loadResource
     * </p>
     * .
     *
     * @param resource
     *            a {@link org.springframework.core.io.Resource} object.
     * @throws ModelImportException
     *             the model import exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void loadResource(Resource resource) throws ModelImportException, IOException {
        try {
            m_mi = CastorUtils.unmarshal(ModelImport.class, resource);
        } catch (MarshalException e) {
            throw new ModelImportException("Exception while marshalling import: " + e, e);
        } catch (ValidationException e) {
            throw new ModelImportException("Exception while validating import " + e);
        }
    }

    /**
     * <p>
     * visitImport
     * </p>
     * .
     *
     * @param visitor
     *            a
     *            {@link org.opennms.netmgt.importer.specification.ImportVisitor}
     *            object.
     */
    public void visitImport(ImportVisitor visitor) {
        doVisitImport(visitor);
    }

    /**
     * Do visit import.
     *
     * @param visitor
     *            the visitor
     */
    private void doVisitImport(ImportVisitor visitor) {
        visitor.visitModelImport(m_mi);
        for (Node node : m_mi.getNodeCollection()) {
            visitNode(visitor, node);
        }
        visitor.completeModelImport(m_mi);
    }

    /**
     * Visit node.
     *
     * @param visitor
     *            the visitor
     * @param node
     *            the node
     */
    private void visitNode(final ImportVisitor visitor, final Node node) {
        doVisitNode(visitor, node);
    }

    /**
     * Do visit node.
     *
     * @param visitor
     *            the visitor
     * @param node
     *            the node
     */
    private void doVisitNode(ImportVisitor visitor, Node node) {
        visitor.visitNode(node);
        for (Category category : node.getCategoryCollection()) {
            visitCategory(visitor, category);
        }
        for (Interface iface : node.getInterfaceCollection()) {
            visitInterface(visitor, iface);
        }
        for (Asset asset : node.getAssetCollection()) {
            visitAsset(visitor, asset);
        }
        visitor.completeNode(node);
    }

    /**
     * Visit asset.
     *
     * @param visitor
     *            the visitor
     * @param asset
     *            the asset
     */
    private void visitAsset(ImportVisitor visitor, Asset asset) {
        doVisitAsset(visitor, asset);
    }

    /**
     * Do visit asset.
     *
     * @param visitor
     *            the visitor
     * @param asset
     *            the asset
     */
    private void doVisitAsset(ImportVisitor visitor, Asset asset) {
        visitor.visitAsset(asset);
        visitor.completeAsset(asset);
    }

    /**
     * Visit category.
     *
     * @param visitor
     *            the visitor
     * @param category
     *            the category
     */
    private void visitCategory(ImportVisitor visitor, Category category) {
        doVisitCategory(visitor, category);
    }

    /**
     * Do visit category.
     *
     * @param visitor
     *            the visitor
     * @param category
     *            the category
     */
    private void doVisitCategory(ImportVisitor visitor, Category category) {
        visitor.visitCategory(category);
        visitor.completeCategory(category);
    }

    /**
     * Visit interface.
     *
     * @param visitor
     *            the visitor
     * @param iface
     *            the iface
     */
    private void visitInterface(ImportVisitor visitor, Interface iface) {
        doVisitInterface(visitor, iface);
    }

    /**
     * Do visit interface.
     *
     * @param visitor
     *            the visitor
     * @param iface
     *            the iface
     */
    private void doVisitInterface(ImportVisitor visitor, Interface iface) {
        visitor.visitInterface(iface);
        for (MonitoredService svc : iface.getMonitoredServiceCollection()) {
            visitMonitoredService(visitor, svc);
        }
        visitor.completeInterface(iface);
    }

    /**
     * Visit monitored service.
     *
     * @param visitor
     *            the visitor
     * @param svc
     *            the svc
     */
    private void visitMonitoredService(ImportVisitor visitor, MonitoredService svc) {
        doVisitMonitoredService(visitor, svc);
    }

    /**
     * Do visit monitored service.
     *
     * @param visitor
     *            the visitor
     * @param svc
     *            the svc
     */
    private void doVisitMonitoredService(ImportVisitor visitor, MonitoredService svc) {
        visitor.visitMonitoredService(svc);
        visitor.completeMonitoredService(svc);
    }

    /**
     * <p>
     * getForeignSource
     * </p>
     * .
     *
     * @return a {@link java.lang.String} object.
     */
    public String getForeignSource() {
        return m_mi.getForeignSource();
    }

    /**
     * <p>
     * setForeignSource
     * </p>
     * .
     *
     * @param foreignSource
     *            a {@link java.lang.String} object.
     */
    public void setForeignSource(String foreignSource) {
        m_mi.setForeignSource(foreignSource);
    }

}
