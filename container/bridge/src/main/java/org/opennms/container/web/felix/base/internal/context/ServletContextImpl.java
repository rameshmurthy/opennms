/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opennms.container.web.felix.base.internal.context;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opennms.container.web.felix.base.internal.logger.SystemLogger;
import org.opennms.container.web.felix.base.internal.util.MimeTypes;
import org.osgi.framework.Bundle;
import org.osgi.service.http.HttpContext;

/**
 * The Class ServletContextImpl.
 */
public final class ServletContextImpl implements ExtServletContext {

    /** The bundle. */
    private final Bundle bundle;

    /** The context. */
    private final ServletContext context;

    /** The http context. */
    private final HttpContext httpContext;

    /** The attributes. */
    private final Map<String, Object> attributes;

    /** The attribute listener. */
    private final ServletContextAttributeListener attributeListener;

    /**
     * Instantiates a new servlet context impl.
     *
     * @param bundle
     *            the bundle
     * @param context
     *            the context
     * @param httpContext
     *            the http context
     * @param attributeListener
     *            the attribute listener
     * @param sharedAttributes
     *            the shared attributes
     */
    public ServletContextImpl(Bundle bundle, ServletContext context, HttpContext httpContext,
            ServletContextAttributeListener attributeListener, boolean sharedAttributes) {
        this.bundle = bundle;
        this.context = context;
        this.httpContext = httpContext;
        this.attributeListener = attributeListener;
        this.attributes = sharedAttributes ? null : new ConcurrentHashMap<String, Object>();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getContextPath()
     */
    @Override
    public String getContextPath() {
        return this.context.getContextPath();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getContext(java.lang.String)
     */
    @Override
    public ServletContext getContext(String uri) {
        return this.context.getContext(uri);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getMajorVersion()
     */
    @Override
    public int getMajorVersion() {
        return this.context.getMajorVersion();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getMinorVersion()
     */
    @Override
    public int getMinorVersion() {
        return this.context.getMinorVersion();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getResourcePaths(java.lang.String)
     */
    @Override
    public Set<String> getResourcePaths(String path) {
        Enumeration<?> paths = this.bundle.getEntryPaths(normalizePath(path));
        if ((paths == null) || !paths.hasMoreElements()) {
            return null;
        }

        Set<String> set = new HashSet<String>();
        while (paths.hasMoreElements()) {
            set.add((String) paths.nextElement());
        }

        return set;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getResource(java.lang.String)
     */
    @Override
    public URL getResource(String path) {
        return this.httpContext.getResource(normalizePath(path));
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getResourceAsStream(java.lang.String)
     */
    @Override
    public InputStream getResourceAsStream(String path) {
        URL res = getResource(path);
        if (res != null) {
            try {
                return res.openStream();
            } catch (IOException e) {
                // Do nothing
            }
        }

        return null;
    }

    /**
     * Normalize path.
     *
     * @param path
     *            the path
     * @return the string
     */
    private static String normalizePath(String path) {
        if (path == null) {
            return null;
        }

        String normalizedPath = path.trim().replaceAll("/+", "/");
        if (normalizedPath.startsWith("/") && (normalizedPath.length() > 1)) {
            normalizedPath = normalizedPath.substring(1);
        }

        return normalizedPath;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getRequestDispatcher(java.lang.String)
     */
    @Override
    public RequestDispatcher getRequestDispatcher(String uri) {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getNamedDispatcher(java.lang.String)
     */
    @Override
    public RequestDispatcher getNamedDispatcher(String name) {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {
        return this.context.getInitParameter(name);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getInitParameterNames()
     */
    @Override
    public Enumeration<?> getInitParameterNames() {
        return this.context.getInitParameterNames();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getAttribute(java.lang.String)
     */
    @Override
    public Object getAttribute(String name) {
        return (this.attributes != null) ? this.attributes.get(name) : this.context.getAttribute(name);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getAttributeNames()
     */
    @Override
    public Enumeration<?> getAttributeNames() {
        return (this.attributes != null) ? Collections.enumeration(this.attributes.keySet())
            : this.context.getAttributeNames();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#setAttribute(java.lang.String, java.lang.Object)
     */
    @Override
    public void setAttribute(String name, Object value) {
        if (value == null) {
            this.removeAttribute(name);
        } else if (name != null) {
            Object oldValue;
            if (this.attributes != null) {
                oldValue = this.attributes.put(name, value);
            } else {
                oldValue = this.context.getAttribute(name);
                this.context.setAttribute(name, value);
            }

            if (oldValue == null) {
                attributeListener.attributeAdded(new ServletContextAttributeEvent(this, name, value));
            } else {
                attributeListener.attributeReplaced(new ServletContextAttributeEvent(this, name, oldValue));
            }
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#removeAttribute(java.lang.String)
     */
    @Override
    public void removeAttribute(String name) {
        Object oldValue;
        if (this.attributes != null) {
            oldValue = this.attributes.remove(name);
        } else {
            oldValue = this.context.getAttribute(name);
            this.context.removeAttribute(name);
        }

        if (oldValue != null) {
            attributeListener.attributeRemoved(new ServletContextAttributeEvent(this, name, oldValue));
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getServlet(java.lang.String)
     */
    @Override
    public Servlet getServlet(String name) throws ServletException {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getServlets()
     */
    @Override
    public Enumeration<?> getServlets() {
        return Collections.enumeration(Collections.emptyList());
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getServletNames()
     */
    @Override
    public Enumeration<?> getServletNames() {
        return Collections.enumeration(Collections.emptyList());
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#log(java.lang.String)
     */
    @Override
    public void log(String message) {
        SystemLogger.info(message);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#log(java.lang.Exception, java.lang.String)
     */
    @Override
    public void log(Exception cause, String message) {
        SystemLogger.error(message, cause);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable cause) {
        SystemLogger.error(message, cause);
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getServletContextName()
     */
    @Override
    public String getServletContextName() {
        return this.context.getServletContextName();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getRealPath(java.lang.String)
     */
    @Override
    public String getRealPath(String name) {
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getServerInfo()
     */
    @Override
    public String getServerInfo() {
        return this.context.getServerInfo();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContext#getMimeType(java.lang.String)
     */
    @Override
    public String getMimeType(String file) {
        String type = this.httpContext.getMimeType(file);
        if (type != null) {
            return type;
        }

        return MimeTypes.get().getByFile(file);
    }

    /* (non-Javadoc)
     * @see org.opennms.container.web.felix.base.internal.context.ExtServletContext#handleSecurity(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public boolean handleSecurity(HttpServletRequest req, HttpServletResponse res) throws IOException {
        return this.httpContext.handleSecurity(req, res);
    }
}
