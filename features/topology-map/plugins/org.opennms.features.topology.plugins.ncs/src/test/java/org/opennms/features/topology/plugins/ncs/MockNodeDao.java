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
package org.opennms.features.topology.plugins.ncs;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.opennms.core.criteria.Criteria;
import org.opennms.netmgt.dao.api.NodeDao;
import org.opennms.netmgt.model.OnmsCategory;
import org.opennms.netmgt.model.OnmsCriteria;
import org.opennms.netmgt.model.OnmsDistPoller;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.SurveillanceStatus;

/**
 * The Class MockNodeDao.
 */
public class MockNodeDao implements NodeDao {

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#lock()
     */
    @Override
    public void lock() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#initialize(java.lang.Object)
     */
    @Override
    public void initialize(Object obj) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#flush()
     */
    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#clear()
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#countAll()
     */
    @Override
    public int countAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#delete(java.lang.Object)
     */
    @Override
    public void delete(OnmsNode entity) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#delete(java.io.Serializable)
     */
    @Override
    public void delete(Integer key) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#findMatching(org.opennms.core.criteria.Criteria)
     */
    @Override
    public List<OnmsNode> findMatching(Criteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#findMatching(org.opennms.netmgt.model.OnmsCriteria)
     */
    @Override
    public List<OnmsNode> findMatching(OnmsCriteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#countMatching(org.opennms.core.criteria.Criteria)
     */
    @Override
    public int countMatching(Criteria onmsCrit) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#countMatching(org.opennms.netmgt.model.OnmsCriteria)
     */
    @Override
    public int countMatching(OnmsCriteria onmsCrit) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#get(java.io.Serializable)
     */
    @Override
    public OnmsNode get(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#load(java.io.Serializable)
     */
    @Override
    public OnmsNode load(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#save(java.lang.Object)
     */
    @Override
    public void save(OnmsNode entity) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(OnmsNode entity) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.OnmsDao#update(java.lang.Object)
     */
    @Override
    public void update(OnmsNode entity) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#get(java.lang.String)
     */
    @Override
    public OnmsNode get(String lookupCriteria) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getLabelForId(java.lang.Integer)
     */
    @Override
    public String getLabelForId(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findByLabel(java.lang.String)
     */
    @Override
    public List<OnmsNode> findByLabel(String label) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findNodes(org.opennms.netmgt.model.OnmsDistPoller)
     */
    @Override
    public List<OnmsNode> findNodes(OnmsDistPoller dp) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getHierarchy(java.lang.Integer)
     */
    @Override
    public OnmsNode getHierarchy(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getForeignIdToNodeIdMap(java.lang.String)
     */
    @Override
    public Map<String, Integer> getForeignIdToNodeIdMap(String foreignSource) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAllByVarCharAssetColumn(java.lang.String, java.lang.String)
     */
    @Override
    public List<OnmsNode> findAllByVarCharAssetColumn(String columnName, String columnValue) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAllByVarCharAssetColumnCategoryList(java.lang.String, java.lang.String, java.util.Collection)
     */
    @Override
    public List<OnmsNode> findAllByVarCharAssetColumnCategoryList(String columnName, String columnValue,
            Collection<OnmsCategory> categories) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findByCategory(org.opennms.netmgt.model.OnmsCategory)
     */
    @Override
    public List<OnmsNode> findByCategory(OnmsCategory category) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAllByCategoryList(java.util.Collection)
     */
    @Override
    public List<OnmsNode> findAllByCategoryList(Collection<OnmsCategory> categories) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAllByCategoryLists(java.util.Collection, java.util.Collection)
     */
    @Override
    public List<OnmsNode> findAllByCategoryLists(Collection<OnmsCategory> rowCatNames,
            Collection<OnmsCategory> colCatNames) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAll()
     */
    @Override
    public List<OnmsNode> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findByForeignSource(java.lang.String)
     */
    @Override
    public List<OnmsNode> findByForeignSource(String foreignSource) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findByForeignId(java.lang.String, java.lang.String)
     */
    @Override
    public OnmsNode findByForeignId(String foreignSource, String foreignId) {
        OnmsNode node = new OnmsNode();
        node.setId((int) (Math.random() * 100));
        node.setLabel("node-label");
        return node;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getNodeCountForForeignSource(java.lang.String)
     */
    @Override
    public int getNodeCountForForeignSource(String groupName) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findAllProvisionedNodes()
     */
    @Override
    public List<OnmsNode> findAllProvisionedNodes() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findObsoleteIpInterfaces(java.lang.Integer, java.util.Date)
     */
    @Override
    public List<OnmsIpInterface> findObsoleteIpInterfaces(Integer nodeId, Date scanStamp) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#deleteObsoleteInterfaces(java.lang.Integer, java.util.Date)
     */
    @Override
    public void deleteObsoleteInterfaces(Integer nodeId, Date scanStamp) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#updateNodeScanStamp(java.lang.Integer, java.util.Date)
     */
    @Override
    public void updateNodeScanStamp(Integer nodeId, Date scanStamp) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getNodeIds()
     */
    @Override
    public Collection<Integer> getNodeIds() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findByForeignSourceAndIpAddress(java.lang.String, java.lang.String)
     */
    @Override
    public List<OnmsNode> findByForeignSourceAndIpAddress(String foreignSource, String ipAddress) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#findSurveillanceStatusByCategoryLists(java.util.Collection, java.util.Collection)
     */
    @Override
    public SurveillanceStatus findSurveillanceStatusByCategoryLists(Collection<OnmsCategory> rowCategories,
            Collection<OnmsCategory> columnCategories) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getNextNodeId(java.lang.Integer)
     */
    @Override
    public Integer getNextNodeId(Integer nodeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.dao.api.NodeDao#getPreviousNodeId(java.lang.Integer)
     */
    @Override
    public Integer getPreviousNodeId(Integer nodeId) {
        // TODO Auto-generated method stub
        return null;
    }

}
