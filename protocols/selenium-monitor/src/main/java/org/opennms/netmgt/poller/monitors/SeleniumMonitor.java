/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.poller.monitors;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.opennms.core.utils.TimeoutTracker;
import org.opennms.netmgt.junit.runner.SeleniumComputer;
import org.opennms.netmgt.model.PollStatus;
import org.opennms.netmgt.poller.MonitoredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class SeleniumMonitor.
 */
public class SeleniumMonitor extends AbstractServiceMonitor {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(SeleniumMonitor.class);

    /**
     * The Class BaseUrlUtils.
     */
    public static class BaseUrlUtils {

        /** The s_ip addr pattern. */
        private static Pattern s_ipAddrPattern = Pattern.compile("\\$\\{ipAddr\\}");

        /**
         * Replace ip addr.
         *
         * @param baseUrl
         *            the base url
         * @param monSvcIpAddr
         *            the mon svc ip addr
         * @return the string
         */
        public static String replaceIpAddr(String baseUrl, String monSvcIpAddr) {
            if (!baseUrl.contains("${ipAddr}")) {
                return baseUrl;
            }

            String finalUrl = "";
            Matcher matcher = s_ipAddrPattern.matcher(baseUrl);
            finalUrl = matcher.replaceAll(monSvcIpAddr);

            return finalUrl;
        }
    }

    /** The Constant DEFAULT_SEQUENCE_RETRY. */
    private static final int DEFAULT_SEQUENCE_RETRY = 0;

    /** The Constant DEFAULT_TIMEOUT. */
    private static final int DEFAULT_TIMEOUT = 3000;

    /* (non-Javadoc)
     * @see org.opennms.netmgt.poller.monitors.AbstractServiceMonitor#poll(org.opennms.netmgt.poller.MonitoredService, java.util.Map)
     */
    @Override
    public PollStatus poll(MonitoredService svc, Map<String, Object> parameters) {
        PollStatus serviceStatus = PollStatus.unavailable("Poll not completed yet");
        TimeoutTracker tracker = new TimeoutTracker(parameters, DEFAULT_SEQUENCE_RETRY, DEFAULT_TIMEOUT);

        for (tracker.reset(); tracker.shouldRetry() && !serviceStatus.isAvailable(); tracker.nextAttempt()) {
            String seleniumTestFilename = getGroovyFilename(parameters);
            try {

                Map<String, Number> responseTimes = new HashMap<String, Number>();
                responseTimes.put("response-time", Double.NaN);

                tracker.startAttempt();
                Result result = runTest(getBaseUrl(parameters, svc), getTimeout(parameters),
                                        createGroovyClass(seleniumTestFilename));
                double responseTime = tracker.elapsedTimeInMillis();
                responseTimes.put("response-time", responseTime);

                if (result.wasSuccessful()) {
                    serviceStatus = PollStatus.available();
                    serviceStatus.setProperties(responseTimes);
                } else {
                    serviceStatus = PollStatus.unavailable(getFailureMessage(result, svc));
                }
            } catch (CompilationFailedException e) {
                serviceStatus = PollStatus.unavailable("Selenium page sequence attempt on:" + svc.getIpAddr()
                        + " failed : selenium-test compilation error " + e.getMessage());
                String reason = "Selenium sequence failed: CompilationFailedException" + e.getMessage();
                SeleniumMonitor.LOG.debug(reason);
                PollStatus.unavailable(reason);
            } catch (IOException e) {
                serviceStatus = PollStatus.unavailable("Selenium page sequence attempt on " + svc.getIpAddr()
                        + " failed: IOException occurred, failed to find selenium-test: " + seleniumTestFilename);
                String reason = "Selenium sequence failed: IOException: " + e.getMessage();
                SeleniumMonitor.LOG.debug(reason);
                PollStatus.unavailable(reason);
            } catch (Exception e) {
                serviceStatus = PollStatus.unavailable("Selenium page sequence attempt on " + svc.getIpAddr()
                        + " failed:\n" + e.getMessage());
                String reason = "Selenium sequence failed: Exception: " + e.getMessage();
                SeleniumMonitor.LOG.debug(reason);
                PollStatus.unavailable(reason);
            }
        }

        return serviceStatus;
    }

    /**
     * Gets the timeout.
     *
     * @param parameters
     *            the parameters
     * @return the timeout
     */
    private int getTimeout(Map<String, Object> parameters) {
        if (parameters.containsKey("timeout")) {
            return Integer.parseInt("" + parameters.get("timeout"));
        } else {
            return 3;
        }
    }

    /**
     * Gets the base url.
     *
     * @param parameters
     *            the parameters
     * @param svc
     *            the svc
     * @return the base url
     */
    private String getBaseUrl(Map<String, Object> parameters, MonitoredService svc) {
        if (parameters.containsKey("base-url")) {
            String baseUrl = (String) parameters.get("base-url");

            if (!baseUrl.contains("http")) {
                baseUrl = "http://" + baseUrl;
            }

            if (baseUrl.contains("${ipAddr}")) {
                baseUrl = BaseUrlUtils.replaceIpAddr(baseUrl, svc.getIpAddr());
            }

            if (parameters.containsKey("port")) {
                String port = (String) parameters.get("port");
                baseUrl = baseUrl + ":" + port;
            }

            return baseUrl;
        } else {
            return null;
        }

    }

    /**
     * Gets the failure message.
     *
     * @param result
     *            the result
     * @param svc
     *            the svc
     * @return the failure message
     */
    private String getFailureMessage(Result result, MonitoredService svc) {
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append("Failed: ");
        for (Failure failure : result.getFailures()) {
            stringBuilder.append(" " + failure.getMessage() + "\n");
        }
        String reason = "Selenium sequence failed: " + stringBuilder.toString();
        SeleniumMonitor.LOG.debug(reason);

        PollStatus.unavailable(reason);
        return stringBuilder.toString();
    }

    /**
     * Run test.
     *
     * @param baseUrl
     *            the base url
     * @param timeoutInSeconds
     *            the timeout in seconds
     * @param clazz
     *            the clazz
     * @return the result
     */
    private Result runTest(String baseUrl, int timeoutInSeconds, Class<?> clazz) {
        return JUnitCore.runClasses(new SeleniumComputer(baseUrl, timeoutInSeconds), clazz);
    }

    /**
     * Gets the groovy filename.
     *
     * @param parameters
     *            the parameters
     * @return the groovy filename
     */
    private String getGroovyFilename(Map<String, Object> parameters) {
        if (parameters.containsKey("selenium-test")) {
            return (String) parameters.get("selenium-test");
        } else {
            return "";
        }

    }

    /**
     * Creates the groovy class.
     *
     * @param filename
     *            the filename
     * @return the class
     * @throws CompilationFailedException
     *             the compilation failed exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private Class<?> createGroovyClass(String filename) throws CompilationFailedException, IOException {
        GroovyClassLoader gcl = new GroovyClassLoader();

        String file = System.getProperty("opennms.home") + "/etc/selenium/" + filename;
        System.err.println("File name: " + file);
        return gcl.parseClass(new File(file));
    }

}
