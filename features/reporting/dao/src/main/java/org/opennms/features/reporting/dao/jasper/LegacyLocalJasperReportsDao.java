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

package org.opennms.features.reporting.dao.jasper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXB;

import org.opennms.features.reporting.model.jasperreport.JasperReportDefinition;
import org.opennms.features.reporting.model.jasperreport.LocalJasperReports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

/**
 * <p>
 * LegacyLocalJasperReportsDao class.
 * </p>
 * <p/>
 * Class realize the data access and preserve compatibility to
 * jasper-reports.xml.
 *
 * @author Markus Neumann <markus@opennms.com>
 * @author Ronny Trommer <ronny@opennms.com>
 * @version $Id: $
 * @since 1.8.1
 */
@ContextConfiguration(locations = { "classpath:META-INF/opennms/applicationContext-reportingDao.xml" })
public class LegacyLocalJasperReportsDao implements LocalJasperReportsDao {

    /** Logging. */
    private Logger logger = LoggerFactory.getLogger("OpenNMS.Report." + LegacyLocalJasperReportsDao.class.getName());

    /** List of generic report definitions. */

    private LocalJasperReports m_LocalJasperReports;

    /** Config resource for database reports configuration file. */
    private Resource m_configResource;

    /** Config resource for jasper report templates. */
    private Resource m_jrTemplateResource;

    /**
     * Instantiates a new legacy local jasper reports dao.
     *
     * @param configResource
     *            the config resource
     * @param jrTemplateResource
     *            the jr template resource
     */
    public LegacyLocalJasperReportsDao(Resource configResource, Resource jrTemplateResource) {
        m_configResource = configResource;
        Assert.notNull(m_configResource, "property configResource must be set to a non-null value");

        m_jrTemplateResource = jrTemplateResource;
        Assert.notNull(m_jrTemplateResource, "property configResource must be sot to a non-null value");

        try {
            loadConfiguration();
        } catch (Exception e) {
            logger.error("Error could not load jasper-reports.xml. Error message: '{}'", e.getMessage());
        }
        logger.debug("Configuration '{}' successfully loaded and unmarshalled.", m_configResource.getFilename());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loadConfiguration() throws Exception {
        InputStream stream = null;
        long lastModified;

        File file = null;
        try {
            file = m_configResource.getFile();
        } catch (IOException e) {
            logger.error("Resource '{}' does not seem to have an underlying File object.", m_configResource);
        }

        if (file != null) {
            lastModified = file.lastModified();
            stream = new FileInputStream(file);
        } else {
            lastModified = System.currentTimeMillis();
            stream = m_configResource.getInputStream();
        }
        setLocalJasperReports(JAXB.unmarshal(file, LocalJasperReports.class));
        Assert.notNull(m_LocalJasperReports, "unmarshall config file returned a null value.");
        logger.debug("Unmarshalling config file '{}'", file.getAbsolutePath());
        logger.debug("Local report definitions assigned: '{}'", m_LocalJasperReports.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setConfigResource(Resource configResource) {
        m_configResource = configResource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resource getConfigResource() {
        return m_configResource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setJrTemplateResource(Resource jrTemplateResource) {
        m_jrTemplateResource = jrTemplateResource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resource getJrTemplateResource() {
        return m_jrTemplateResource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTemplateLocation(String id) {
        for (JasperReportDefinition report : m_LocalJasperReports.getReportList()) {
            if (id.equals(report.getId())) {
                return report.getTemplate();
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEngine(String id) {
        for (JasperReportDefinition report : m_LocalJasperReports.getReportList()) {
            if (id.equals(report.getId())) {
                return report.getEngine();
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getTemplateStream(String id) {
        InputStream reportTemplateStream = null;

        try {
            String reportTemplateFolder = m_jrTemplateResource.getFile().getPath();

            for (JasperReportDefinition report : m_LocalJasperReports.getReportList()) {
                if (id.equals(report.getId())) {
                    try {
                        reportTemplateStream = new FileInputStream(new File(reportTemplateFolder + "/"
                                + report.getTemplate()));
                    } catch (FileNotFoundException e) {
                        logger.error("Template file '{}' at folder '{}' not found.", report.getTemplate(),
                                     reportTemplateFolder);

                        // TODO indigo: Add e.message to error message
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
                                 // Settings | File Templates.
        }
        return reportTemplateStream;
    }

    /**
     * <p>
     * getLocalJasperReports
     * </p>
     * Get local jasper reports.
     *
     * @return a
     *         {@link org.opennms.features.reporting.model.jasperreport.LocalJasperReports}
     *         object
     */
    public LocalJasperReports getLocalJasperReports() {
        return m_LocalJasperReports;
    }

    /**
     * <p>
     * setLocalJasperReports
     * </p>
     * Set local jasper reports.
     *
     * @param localJasperReports
     *            a
     *            {@link org.opennms.features.reporting.model.jasperreport.LocalJasperReports}
     *            object
     */
    public void setLocalJasperReports(LocalJasperReports localJasperReports) {
        m_LocalJasperReports = localJasperReports;
    }
}
