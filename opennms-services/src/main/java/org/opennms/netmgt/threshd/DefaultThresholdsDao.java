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

package org.opennms.netmgt.threshd;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.opennms.netmgt.config.ThresholdingConfigFactory;
import org.opennms.netmgt.config.threshd.Basethresholddef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * <p>
 * DefaultThresholdsDao class.
 * </p>
 *
 * @author ranger
 * @version $Id: $
 */
public class DefaultThresholdsDao implements ThresholdsDao, InitializingBean {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultThresholdsDao.class);

    /** The m_thresholding config factory. */
    private ThresholdingConfigFactory m_thresholdingConfigFactory;

    /** {@inheritDoc} */
    @Override
    public ThresholdGroup get(String name) {
        return get(name, null);
    }

    /** {@inheritDoc} */
    @Override
    public ThresholdGroup merge(ThresholdGroup group) {
        return get(group.getName(), group);
    }

    /**
     * Gets the.
     *
     * @param name
     *            the name
     * @param group
     *            the group
     * @return the threshold group
     */
    private ThresholdGroup get(String name, ThresholdGroup group) {
        boolean merge = group != null;
        ThresholdGroup newGroup = new ThresholdGroup(name);

        File rrdRepository = new File(getThresholdingConfigFactory().getRrdRepository(name));
        newGroup.setRrdRepository(rrdRepository);

        ThresholdResourceType nodeType = merge ? mergeType(name, "node", group.getNodeResourceType())
            : createType(name, "node");
        newGroup.setNodeResourceType(nodeType);

        ThresholdResourceType ifType = merge ? mergeType(name, "if", group.getIfResourceType())
            : createType(name, "if");
        newGroup.setIfResourceType(ifType);

        for (Basethresholddef thresh : getThresholdingConfigFactory().getThresholds(name)) {
            String id = thresh.getDsType();
            if (!(id.equals("if") || id.equals("node") || newGroup.getGenericResourceTypeMap().containsKey(id))) {
                ThresholdResourceType genericType = merge ? mergeType(name, id,
                                                                      group.getGenericResourceTypeMap().get(id))
                    : createType(name, id);
                if (genericType.getThresholdMap().size() > 0) {
                    LOG.info("Adding {}::{} with {} elements", name, id, genericType.getThresholdMap().size());
                    newGroup.getGenericResourceTypeMap().put(id, genericType);
                }
            }
        }

        return newGroup;
    }

    /**
     * Creates the threshold state map.
     *
     * @param groupName
     *            the group name
     * @param typeName
     *            the type name
     * @return the map
     */
    private Map<String, Set<ThresholdEntity>> createThresholdStateMap(String groupName, String typeName) {
        Map<String, Set<ThresholdEntity>> thresholdMap = new HashMap<String, Set<ThresholdEntity>>();
        fillThresholdStateMap(groupName, typeName, thresholdMap);
        return thresholdMap;
    }

    /**
     * Merge threshold state map.
     *
     * @param groupName
     *            the group name
     * @param type
     *            the type
     * @return the map
     */
    private Map<String, Set<ThresholdEntity>> mergeThresholdStateMap(String groupName, ThresholdResourceType type) {
        Map<String, Set<ThresholdEntity>> thresholdMap = type.getThresholdMap();
        fillThresholdStateMap(groupName, type.getDsType(), thresholdMap);
        return thresholdMap;
    }

    /**
     * Fill threshold state map.
     *
     * @param groupName
     *            the group name
     * @param typeName
     *            the type name
     * @param thresholdMap
     *            the threshold map
     */
    private void fillThresholdStateMap(String groupName, String typeName, Map<String, Set<ThresholdEntity>> thresholdMap) {
        boolean merge = !thresholdMap.isEmpty();
        for (Basethresholddef thresh : getThresholdingConfigFactory().getThresholds(groupName)) {
            // See if map entry already exists for this datasource; if not,
            // create a new one.
            if (thresh.getDsType().equals(typeName)) {
                try {
                    BaseThresholdDefConfigWrapper wrapper = BaseThresholdDefConfigWrapper.getConfigWrapper(thresh);
                    Set<ThresholdEntity> thresholdEntitySet = thresholdMap.get(wrapper.getDatasourceExpression());
                    // Found set for this DS type?
                    if (thresholdEntitySet == null) {
                        // Nope, create a new set
                        thresholdEntitySet = new LinkedHashSet<ThresholdEntity>();
                        thresholdMap.put(wrapper.getDatasourceExpression(), thresholdEntitySet);
                    }
                    try {
                        ThresholdEntity thresholdEntity = new ThresholdEntity();
                        thresholdEntity.addThreshold(wrapper);
                        if (merge) {
                            boolean updated = false;
                            for (ThresholdEntity e : thresholdEntitySet) {
                                // See implementation on
                                // BaseThresholdDefConfigWrapper equals are
                                // different from identical for this case.
                                if (thresholdEntity.getThresholdConfig().equals(e.getThresholdConfig())) {
                                    e.merge(thresholdEntity);
                                    updated = true;
                                }
                            }
                            if (!updated) // Does not exist!
                                thresholdEntitySet.add(thresholdEntity);
                        } else {
                            thresholdEntitySet.add(thresholdEntity);
                        }
                    } catch (IllegalStateException e) {
                        LOG.warn("fillThresholdStateMap: Encountered duplicate {} for datasource {}", thresh.getType(),
                                 wrapper.getDatasourceExpression(), e);
                    }
                } catch (ThresholdExpressionException e) {
                    LOG.warn("fillThresholdStateMap: Could not parse threshold expression", e);
                }
            }
        }
        // Search for deleted configuration
        if (merge) {
            LOG.debug("fillThresholdStateMap(merge): checking if definitions that are no longer exist for group {} using type {}",
                      groupName, typeName);
            for (String expression : thresholdMap.keySet()) {
                for (Iterator<ThresholdEntity> i = thresholdMap.get(expression).iterator(); i.hasNext();) {
                    ThresholdEntity entity = i.next();
                    boolean found = false;
                    for (Basethresholddef thresh : getThresholdingConfigFactory().getThresholds(groupName)) {
                        BaseThresholdDefConfigWrapper newConfig = null;
                        try {
                            newConfig = BaseThresholdDefConfigWrapper.getConfigWrapper(thresh);
                        } catch (ThresholdExpressionException e) {
                            LOG.warn("fillThresholdStateMap: Could not parse threshold expression", e);
                        }
                        if (newConfig.equals(entity.getThresholdConfig())) {
                            found = true;
                            continue;
                        }
                    }
                    if (!found) {
                        LOG.info("fillThresholdStateMap(merge): deleting entity {}", entity);
                        entity.delete();
                        i.remove();
                    }
                }
            }
        }
    }

    /**
     * Creates the type.
     *
     * @param groupName
     *            the group name
     * @param typeName
     *            the type name
     * @return the threshold resource type
     */
    private ThresholdResourceType createType(String groupName, String typeName) {
        ThresholdResourceType resourceType = new ThresholdResourceType(typeName);
        resourceType.setThresholdMap(createThresholdStateMap(groupName, typeName));
        return resourceType;
    }

    /**
     * Merge type.
     *
     * @param groupName
     *            the group name
     * @param typeName
     *            the type name
     * @param type
     *            the type
     * @return the threshold resource type
     */
    private ThresholdResourceType mergeType(String groupName, String typeName, ThresholdResourceType type) {
        ThresholdResourceType resourceType = new ThresholdResourceType(typeName);
        Map<String, Set<ThresholdEntity>> mergedStateMap = type == null ? createThresholdStateMap(groupName, typeName)
            : mergeThresholdStateMap(groupName, type);
        resourceType.setThresholdMap(mergedStateMap);
        return resourceType;
    }

    /**
     * <p>
     * getThresholdingConfigFactory
     * </p>
     * .
     *
     * @return a {@link org.opennms.netmgt.config.ThresholdingConfigFactory}
     *         object.
     */
    @Override
    public ThresholdingConfigFactory getThresholdingConfigFactory() {
        return m_thresholdingConfigFactory;
    }

    /**
     * <p>
     * setThresholdingConfigFactory
     * </p>
     * .
     *
     * @param thresholdingConfigFactory
     *            a {@link org.opennms.netmgt.config.ThresholdingConfigFactory}
     *            object.
     */
    public void setThresholdingConfigFactory(ThresholdingConfigFactory thresholdingConfigFactory) {
        m_thresholdingConfigFactory = thresholdingConfigFactory;
    }

    /**
     * <p>
     * afterPropertiesSet
     * </p>
     * .
     *
     * @throws Exception
     *             the exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.state(m_thresholdingConfigFactory != null, "thresholdingConfigFactory property not set");
    }

}
