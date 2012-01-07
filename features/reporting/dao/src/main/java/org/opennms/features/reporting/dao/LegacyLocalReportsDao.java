/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2011 The OpenNMS Group, Inc.
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

package org.opennms.features.reporting.dao;

import org.opennms.features.reporting.model.basicreport.BasicReportDefinition;
import org.opennms.features.reporting.model.basicreport.LegacyLocalReportsDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>LegacyLocalReportsDao class.</p>
 *
 * Class realize the data access and preserve compatibility to local-reports.xml.
 *
 * @author Markus Neumann <markus@opennms.com>
 * @author Ronny Trommer <ronny@opennms.com>
 * @version $Id: $
 * @since 1.8.1
 */
@ContextConfiguration(locations = {"classpath:reportingDao-context.xml"})
public class LegacyLocalReportsDao implements LocalReportsDao {

    /**
     * Logging
     */
    private Logger logger = LoggerFactory.getLogger(LegacyLocalReportsDao.class);

    /**
     * List of generic report definitions
     */
    private LegacyLocalReportsDefinition m_legacyLocalReportsDefinition;

    /**
     * Config resource for database reports configuration file
     */
    private Resource m_configResource;

    /**
     * <p>afterPropertiesSet</p>
     *
     * Sanity check for configuration file and load database-reports.xml
     *
     * @throws java.lang.Exception if any.
     */
    public void afterPropertiesSet() throws Exception {
        Assert.state(m_configResource != null, "property configResource must be set to a non-null value");
        loadLegacyLocalReports();
    }

    /**
     * <p>loadLegacyLocalReports</p>
     *
     * File handling for database-reports.xml and unmarshal in LegacyLocalReportsDefinition class
     *
     * @throws Exception
     */
    private void loadLegacyLocalReports() throws Exception {
        InputStream stream = null;
        long lastModified;

        File file = null;
        try {
            file = getConfigResource().getFile();
        } catch (IOException e) {
            logger.error("Resource '{}' does not seem to have an underlying File object.", getConfigResource());
        }

        if (file != null) {
            lastModified = file.lastModified();
            stream = new FileInputStream(file);
        } else {
            lastModified = System.currentTimeMillis();
            stream = getConfigResource().getInputStream();
        }
        setLegacyLocalReportsDefinition(JAXB.unmarshal(file, LegacyLocalReportsDefinition.class));
    }

    /** {@inheritDoc} */
    @Override
    public List<BasicReportDefinition> getReports() {
        ArrayList<BasicReportDefinition> resultList = new ArrayList<BasicReportDefinition>();
        for (BasicReportDefinition report : m_legacyLocalReportsDefinition.getReportList()) {
            resultList.add(report);
        }
        return resultList;
    }

    /** {@inheritDoc} */
    @Override
    public List<BasicReportDefinition> getOnlineReports() {
        List<BasicReportDefinition> onlineReports = new ArrayList<BasicReportDefinition>();
        for (BasicReportDefinition report : m_legacyLocalReportsDefinition.getReportList()) {
            if (report.getOnline()) {
                onlineReports.add(report);
            }
        }
        return onlineReports;
    }

    /** {@inheritDoc} */
    @Override
    public String getReportService(String id) {
        for (BasicReportDefinition report : m_legacyLocalReportsDefinition.getReportList()) {
            if (id.equals(report.getId())) {
                return report.getReportService();
            }
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String getDisplayName(String id) {
        for (BasicReportDefinition report : m_legacyLocalReportsDefinition.getReportList()) {
            if (id.equals(report.getId())) {
                return report.getDisplayName();
            }
        }
        return null;
    }

    /**
     * <p>setLegacyLocalReportsDefinition</p>
     *
     * Set list with legacy report definition
     *
     * @param legacyLocalReportsDefinition {@link org.opennms.features.reporting.model.basicreport.LegacyLocalReportsDefinition} object
     */
    public void setLegacyLocalReportsDefinition(LegacyLocalReportsDefinition legacyLocalReportsDefinition) {
        this.m_legacyLocalReportsDefinition = legacyLocalReportsDefinition;
    }

    /**
     * <p>getLegacyLocalReportsDefinition</p>
     *
     * Get list with legacy report definition
     *
     * @return a {@link org.opennms.features.reporting.model.basicreport.LegacyLocalReportsDefinition} object
     */
    public LegacyLocalReportsDefinition getLegacyLocalReportsDefinition() {
        return m_legacyLocalReportsDefinition;
    }

    /**
     * <p>setConfigResource</p>
     *
     * Set resource for local-reports.xml
     *
     * @param configResource a {@link org.springframework.core.io.Resource} object
     */
    public void setConfigResource(Resource configResource) {
        m_configResource = configResource;
    }

    /**
     * <p>getConfigResource</p>
     *
     * Get resource for local-reports.xml
     *
     * @return a {@link org.springframework.core.io.Resource} object
     */
    public Resource getConfigResource() {
        return m_configResource;
    }
}