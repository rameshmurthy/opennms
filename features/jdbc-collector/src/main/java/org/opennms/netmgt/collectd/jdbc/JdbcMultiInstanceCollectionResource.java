/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2010-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.collectd.jdbc;

import java.io.File;

import org.opennms.netmgt.collectd.CollectionAgent;
import org.opennms.netmgt.model.RrdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class JdbcMultiInstanceCollectionResource.
 */
public class JdbcMultiInstanceCollectionResource extends JdbcCollectionResource {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(JdbcMultiInstanceCollectionResource.class);

    /** The m_inst. */
    private String m_inst;

    /** The m_name. */
    private String m_name;

    /**
     * Instantiates a new jdbc multi instance collection resource.
     *
     * @param agent
     *            the agent
     * @param instance
     *            the instance
     * @param name
     *            the name
     */
    public JdbcMultiInstanceCollectionResource(CollectionAgent agent, String instance, String name) {
        super(agent);
        m_inst = instance;
        m_name = name;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.collectd.AbstractCollectionResource#getResourceDir(org.opennms.netmgt.model.RrdRepository)
     */
    @Override
    public File getResourceDir(RrdRepository repository) {
        File rrdBaseDir = repository.getRrdBaseDir();
        File nodeDir = new File(rrdBaseDir, getParent());
        File typeDir = new File(nodeDir, m_name);
        File instDir = new File(
                                typeDir,
                                m_inst.replaceAll("\\s+", "_").replaceAll(":", "_").replaceAll("\\\\", "_").replaceAll("[\\[\\]]",
                                                                                                                       "_"));
        LOG.debug("getResourceDir: {}", instDir.toString());
        return instDir;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.collectd.jdbc.JdbcCollectionResource#getResourceTypeName()
     */
    @Override
    public String getResourceTypeName() {
        return m_name;
    }

    /* (non-Javadoc)
     * @see org.opennms.netmgt.collectd.jdbc.JdbcCollectionResource#getInstance()
     */
    @Override
    public String getInstance() {
        return m_inst;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Node[" + m_agent.getNodeId() + "]/type[" + m_name + "]/instance[" + m_inst + "]";
    }
}
