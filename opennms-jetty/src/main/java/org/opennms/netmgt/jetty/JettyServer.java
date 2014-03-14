/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.jetty;

import java.io.File;
import java.util.Properties;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;
import org.opennms.netmgt.daemon.AbstractServiceDaemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements Web Application within OpenNMS as a Service Daemon.
 *
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @author <a href="mailto:david@opennms.org">David Hustace</a>
 */
public class JettyServer extends AbstractServiceDaemon {

    private static final Logger LOG = LoggerFactory.getLogger(JettyServer.class);

    private static final String LOG4J_CATEGORY = "jetty-server";

    int m_port = 8080;

    private Server m_server;

    /**
     * <p>Constructor for JettyServer.</p>
     */
    protected JettyServer() {
        super(LOG4J_CATEGORY);
    }

    /** {@inheritDoc} */
    @Override
    protected void onInit() {
        final Properties p = System.getProperties();

        final File homeDir = new File(p.getProperty("opennms.home"));
        final File webappsDir = new File(homeDir, "jetty-webapps");

        m_server = new Server();

        HttpConfiguration http_config = new HttpConfiguration();
        http_config.setOutputBufferSize(32768);
        final Integer requestHeaderSize = Integer.getInteger("org.opennms.netmgt.jetty.requestHeaderSize");
        if(requestHeaderSize != null) {
            http_config.setRequestHeaderSize(requestHeaderSize);
        }

        ServerConnector http = new ServerConnector(m_server, new HttpConnectionFactory(http_config));
        final Integer port = Integer.getInteger("org.opennms.netmgt.jetty.port", m_port);
        http.setPort(port);

        final String host = System.getProperty("org.opennms.netmgt.jetty.host");
        if (host != null) {
            http.setHost(host);
        }

        m_server.addConnector(http);

/*
        final Integer ajp_port = Integer.getInteger("org.opennms.netmgt.jetty.ajp-port");
        if (ajp_port != null) {
            final Ajp13SocketConnector ajpConnector = new Ajp13SocketConnector();
            ajpConnector.setPort(ajp_port);
            // Apache AJP connector freaks out with anything larger
            ajpConnector.setRequestHeaderSize(8096);
            m_server.addConnector(ajpConnector);
        }
*/

        final Integer https_port = Integer.getInteger("org.opennms.netmgt.jetty.https-port");
        if (https_port != null) {
            final String keyStorePath = System.getProperty("org.opennms.netmgt.jetty.https-keystore", homeDir+File.separator+"etc"+File.separator+"examples"+File.separator+"jetty.keystore");
            final String keyStorePassword = System.getProperty("org.opennms.netmgt.jetty.https-keystorepassword", "changeit");
            final String keyManagerPassword = System.getProperty("org.opennms.netmgt.jetty.https-keypassword", "changeit");
            final String certificateAlias = System.getProperty("org.opennms.netmgt.jetty.https-cert-alias", null);

            final SslContextFactory contextFactory = new SslContextFactory();
            contextFactory.setKeyStorePath(keyStorePath);
            contextFactory.setKeyStorePassword(keyStorePassword);
            contextFactory.setKeyManagerPassword(keyManagerPassword);
            if (certificateAlias != null && !"".equals(certificateAlias.trim())) {
                contextFactory.setCertAlias(certificateAlias);
            }

            excludeCipherSuites(contextFactory, https_port);

            http_config.setSecureScheme("https");
            http_config.setSecurePort(https_port);

            HttpConfiguration https_config = new HttpConfiguration(http_config);
            https_config.addCustomizer(new SecureRequestCustomizer());
            
            ServerConnector https = new ServerConnector(m_server,
                                                        new SslConnectionFactory(contextFactory,"http/1.1"),
                                                        new HttpConnectionFactory(https_config));
            https.setPort(https_port);
            https.setIdleTimeout(500000);

            final String httpsHost = System.getProperty("org.opennms.netmgt.jetty.https-host");
            if (httpsHost != null) {
                https.setHost(httpsHost);
            }

            m_server.addConnector(https);
        }

        final HandlerCollection handlers = new HandlerCollection();
        
        boolean enableRequestLogging = Boolean.getBoolean("org.opennms.netmgt.jetty.enableRequestLogging");
        if (enableRequestLogging) {
            
            File logsDir = new File(homeDir, "logs");
            String logFileTemplate = new File(logsDir, "jetty-yyyy_mm_dd.request.log").getAbsolutePath();
            
            RequestLogHandler requestLogHandler = new RequestLogHandler();
            
            NCSARequestLog requestLog = new NCSARequestLog(logFileTemplate);
            requestLogHandler.setRequestLog(requestLog);
            
            handlers.addHandler(requestLogHandler);
        }

        if (webappsDir.exists()) {
            File rootDir = null;
            for (final File file: webappsDir.listFiles()) {
                if (file.isDirectory()) {
                    final String contextPath;
                    if ("ROOT".equals(file.getName())) {
                        // Defer this to last to avoid nested context order problems
                        rootDir = file;
                        continue;
                    } else {
                        contextPath = "/" + file.getName();
                    }
                    addContext(handlers, file, contextPath);
                }
            }
            if (rootDir != null) {
                // If we deferred a ROOT context, handle that now
                addContext(handlers, rootDir, "/");
            }
        }

        m_server.setHandler(handlers);
        m_server.setStopAtShutdown(true);
    }

    /**
     * <p>addContext</p>
     *
     * @param handlers a {@link org.eclipse.jetty.server.handler.HandlerCollection} object.
     * @param name a {@link java.io.File} object.
     * @param contextPath a {@link java.lang.String} object.
     */
    protected void addContext(final HandlerCollection handlers, final File name, final String contextPath) {
        LOG.warn("adding context: {} -> {}", contextPath, name.getAbsolutePath());
        final WebAppContext wac = new WebAppContext();
        /*
         * Tell jetty to scan all of the jar files in the classpath for taglibs and other resources since
         * most of our jars are installed in ${opennms.home}/lib.  This is only required for jetty7
         * See: http://wiki.eclipse.org/Jetty/Howto/Configure_JSP
         */
        wac.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*\\.jar$");
        wac.setWar(name.getAbsolutePath());
        wac.setContextPath(contextPath);
        handlers.addHandler(wac);
    }

    protected void excludeCipherSuites(final SslContextFactory contextFactory, final Integer port) {
        String[] defaultExclSuites = {
                "SSL_DHE_DSS_WITH_DES_CBC_SHA",
                "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
                "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA",
                "SSL_DHE_RSA_WITH_DES_CBC_SHA",
                "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",
                "SSL_RSA_EXPORT_WITH_RC4_40_MD5",
                "SSL_RSA_WITH_3DES_EDE_CBC_SHA",
                "SSL_RSA_WITH_DES_CBC_SHA",
                "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
                "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA",
                "TLS_RSA_WITH_DES_CBC_SHA"
        };

        String[] exclSuites;
        final String exclSuitesString = System.getProperty("org.opennms.netmgt.jetty.https-exclude-cipher-suites");
        if (exclSuitesString == null) {
            LOG.warn("No excluded SSL/TLS cipher suites specified, using hard-coded defaults");
            exclSuites = defaultExclSuites;
        } else {
            exclSuites = exclSuitesString.split("\\s*:\\s*");
            LOG.warn("Excluding {} user-specified SSL/TLS cipher suites", exclSuites.length);
        }

        contextFactory.setExcludeCipherSuites(exclSuites);

        for (final String suite : exclSuites) {
            LOG.info("Excluded SSL/TLS cipher suite {} for connector on port {}", suite, port);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onStart() {
        try {
            m_server.start();
        } catch (final Throwable t) {
            LOG.error("Error starting Jetty Server", t);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onStop() {
        try {
            m_server.stop();
        } catch (final Throwable t) {
            LOG.error("Error stopping Jetty Server", t);
        }
    }

    public static String getLoggingCategory() {
        return LOG4J_CATEGORY;
    }
}
