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

package org.opennms.netmgt.jasper.resource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class ResourceQueryExecuterTest.
 */
public class ResourceQueryExecuterTest {

    /** The m_jasper report. */
    private JasperReport m_jasperReport;

    /** The m_jasper print. */
    private JasperPrint m_jasperPrint;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        File reportDir = new File("target/reports");
        reportDir.mkdirs();
    }

    /**
     * Test.
     *
     * @throws JRException
     *             the jR exception
     */
    @Test
    public void test() throws JRException {
        compile();
        fill();
        pdf();
        xhtml();
    }

    /**
     * Xhtml.
     *
     * @throws JRException
     *             the jR exception
     */
    private void xhtml() throws JRException {
        File destFile = new File("target/reports/ResourceTypeTest.x.html");

        JRXhtmlExporter exporter = new JRXhtmlExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, m_jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());

        exporter.exportReport();
    }

    /**
     * Pdf.
     *
     * @throws JRException
     *             the jR exception
     */
    private void pdf() throws JRException {
        JasperExportManager.exportReportToPdfFile(m_jasperPrint, "target/reports/ResourceTypeTest.pdf");
    }

    /**
     * Fill.
     *
     * @throws JRException
     *             the jR exception
     */
    private void fill() throws JRException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nodeid", 1);
        params.put("resourceType", "nsVpnMonitor");

        m_jasperPrint = JasperFillManager.fillReport(m_jasperReport, params);
    }

    /**
     * Compile.
     *
     * @throws JRException
     *             the jR exception
     */
    private void compile() throws JRException {
        m_jasperReport = JasperCompileManager.compileReport("src/test/resources/ResourceTest.jrxml");
    }

}
