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

package org.opennms.protocols.jmx.connectors;

import java.net.InetAddress;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.opennms.core.utils.InetAddressUtils;
import org.opennms.core.utils.ParameterMap;
import org.opennms.core.utils.ThreadCategory;

/**
 * <p>JMXSecureConnectionFactory class.</p>
 *
 * @author ranger
 * @version $Id: $
 */
public class JMXSecureConnectionFactory
{
    static ThreadCategory log = ThreadCategory.getInstance(JMXSecureConnectionFactory.class);

    /**
     * <p>getMBeanServerConnection</p>
     *
     * @param propertiesMap a {@link java.util.Map} object.
     * @param address a {@link java.net.InetAddress} object.
     * @return a {@link org.opennms.protocols.jmx.connectors.Jsr160ConnectionWrapper} object.
     */
    @SuppressWarnings("restriction")
	public static Jsr160ConnectionWrapper getMBeanServerConnection(Map<?,?> propertiesMap, InetAddress address)
    {
        Jsr160ConnectionWrapper connectionWrapper = null;

        JMXServiceURL url = null;

        String factory = ParameterMap.getKeyedString(propertiesMap, "factory", "SASL");
        int port = ParameterMap.getKeyedInteger(propertiesMap, "port", 11162);
        String protocol = ParameterMap.getKeyedString(propertiesMap, "protocol", "jmxmp");
        String urlPath = ParameterMap.getKeyedString(propertiesMap, "urlPath", "");
        String sunCacao = ParameterMap.getKeyedString(propertiesMap, "sunCacao", "false");

        log.debug("JMX: " + factory + " - service:" + protocol + "//" + InetAddressUtils.str(address) + ":" + port + urlPath);

        if (factory.equals("SASL"))
        {
            try
            {
                String username = ParameterMap.getKeyedString(propertiesMap, "username", null);
                String password = ParameterMap.getKeyedString(propertiesMap, "password", null);

                HashMap<String, Object> env = new HashMap<String, Object>();

                while (true)
                {
                    AnyServerX509TrustManager tm;
                    KeyStore ks;

                    try
                    {
                        ks = KeyStore.getInstance(KeyStore.getDefaultType());
                        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        tmf.init(ks);
                        @SuppressWarnings("unused")
						X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
                        tm = new AnyServerX509TrustManager();
                        SSLContext ctx = SSLContext.getInstance("TLSv1");
                        ctx.init(null, new TrustManager[]{tm}, null);
                        SSLSocketFactory ssf = ctx.getSocketFactory();
                        env.put("jmx.remote.tls.socket.factory", ssf);
                    }
                    catch (Throwable e)
                    {
                        log.error("Something bad occured: " + e.getMessage());
                        throw e;
                    }

                    Security.addProvider(new com.sun.security.sasl.Provider());
                    String[] creds;
                    if (sunCacao.equals("true"))
                        creds = new String[]{"com.sun.cacao.user\001" + username, password};
                    else
                        creds = new String[]{username, password};
                    env.put("jmx.remote.profiles", "TLS SASL/PLAIN");
                    env.put("jmx.remote.credentials", creds);

                    // Create an JMXMP connector client and
                    // connect it to the JMXMP connector server
                    //
                    url = new JMXServiceURL(protocol, InetAddressUtils.str(address), port, urlPath);

                    JMXConnector connector = JMXConnectorFactory.newJMXConnector(url, null);

                    // Connect and invoke an operation on the remote MBeanServer
                    try
                    {
                        connector.connect(env);
                    }
                    catch (SSLException e)
                    {
                        continue;
                    }
                    catch (SecurityException x)
                    {
                        log.error("Security exception: bad credentials");
                        throw x;
                    }
                    MBeanServerConnection connection = connector.getMBeanServerConnection();
                    connectionWrapper = new Jsr160ConnectionWrapper(connector, connection);
                    break;
                }
            }
            catch (Throwable e)
            {
                log.error("Unable to get MBeanServerConnection: " + url);
            }
        }
        return connectionWrapper;
    }

    private static class AnyServerX509TrustManager implements X509TrustManager
    {
        // Documented in X509TrustManager
        public X509Certificate[] getAcceptedIssuers()
        {
            // since client authentication is not supported by this
            // trust manager, there's no certicate authority trusted
            // for authenticating peers
            return new X509Certificate[0];
        }

        // Documented in X509TrustManager
        public void checkClientTrusted(X509Certificate[] certs, String authType)
                throws CertificateException
        {
            // this trust manager is dedicated to server authentication
            throw new CertificateException("not supported");
        }

        // Documented in X509TrustManager
        public void checkServerTrusted(X509Certificate[] certs, String authType)
                throws CertificateException
        {
            // any certificate sent by the server is automatically accepted
        }
    }

}
