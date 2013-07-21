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

package org.opennms.core.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

import javax.sql.DataSource;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.opennms.netmgt.config.opennmsDataSources.JdbcDataSource;
import org.opennms.netmgt.config.opennmsDataSources.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * <p>
 * C3P0ConnectionFactory class.
 * </p>
 */
public class C3P0ConnectionFactory extends BaseConnectionFactory {

    /** The Constant LOG. */
    public static final Logger LOG = LoggerFactory.getLogger(C3P0ConnectionFactory.class);

    /** The m_pool. */
    private ComboPooledDataSource m_pool;

    /**
     * Instantiates a new c3 p0 connection factory.
     *
     * @param stream
     *            the stream
     * @param dsName
     *            the ds name
     * @throws MarshalException
     *             the marshal exception
     * @throws ValidationException
     *             the validation exception
     * @throws PropertyVetoException
     *             the property veto exception
     * @throws SQLException
     *             the sQL exception
     */
    public C3P0ConnectionFactory(final InputStream stream, final String dsName) throws MarshalException,
            ValidationException, PropertyVetoException, SQLException {
        super(stream, dsName);
    }

    /**
     * Instantiates a new c3 p0 connection factory.
     *
     * @param configFile
     *            the config file
     * @param dsName
     *            the ds name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws MarshalException
     *             the marshal exception
     * @throws ValidationException
     *             the validation exception
     * @throws PropertyVetoException
     *             the property veto exception
     * @throws SQLException
     *             the sQL exception
     */
    public C3P0ConnectionFactory(final String configFile, final String dsName) throws IOException, MarshalException,
            ValidationException, PropertyVetoException, SQLException {
        super(configFile, dsName);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#initializePool(org.opennms.netmgt.config.opennmsDataSources.JdbcDataSource)
     */
    @Override
    protected void initializePool(final JdbcDataSource dataSource) throws SQLException {
        m_pool = new ComboPooledDataSource();
        m_pool.setPassword(dataSource.getPassword());
        m_pool.setUser(dataSource.getUserName());
        m_pool.setJdbcUrl(dataSource.getUrl());
        try {
            m_pool.setDriverClass(dataSource.getClassName());
        } catch (final PropertyVetoException e) {
            throw new SQLException("Unable to set driver class.", e);
        }

        final Properties properties = new Properties();
        for (final Param parameter : dataSource.getParamCollection()) {
            properties.put(parameter.getName(), parameter.getValue());
        }
        if (!properties.isEmpty()) {
            m_pool.setProperties(properties);
        }
    }

    /* (non-Javadoc)
     * @see javax.sql.DataSource#getConnection()
     */
    @Override
    public Connection getConnection() throws SQLException {
        return m_pool.getConnection();
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#getUrl()
     */
    @Override
    public String getUrl() {
        return m_pool.getJdbcUrl();
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#setUrl(java.lang.String)
     */
    @Override
    public void setUrl(final String url) {
        validateJdbcUrl(url);
        m_pool.setJdbcUrl(url);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#getUser()
     */
    @Override
    public String getUser() {
        return m_pool.getUser();
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#setUser(java.lang.String)
     */
    @Override
    public void setUser(final String user) {
        m_pool.setUser(user);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#getDataSource()
     */
    @Override
    public DataSource getDataSource() {
        return m_pool;
    }

    /* (non-Javadoc)
     * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
     */
    @Override
    public Connection getConnection(final String username, final String password) throws SQLException {
        return m_pool.getConnection(username, password);
    }

    /* (non-Javadoc)
     * @see javax.sql.CommonDataSource#getLogWriter()
     */
    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return m_pool.getLogWriter();
    }

    /* (non-Javadoc)
     * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
     */
    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        m_pool.setLogWriter(out);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.ClosableDataSource#setLoginTimeout(int)
     */
    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        m_pool.setLoginTimeout(seconds);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#getLoginTimeout()
     */
    @Override
    public int getLoginTimeout() throws SQLException {
        return m_pool.getLoginTimeout();
    }

    /** {@inheritDoc} */
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("getParentLogger not supported");
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.BaseConnectionFactory#close()
     */
    @Override
    public void close() throws SQLException {
        super.close();
        LOG.info("Closing C3P0 pool.");
        m_pool.close();
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.ClosableDataSource#setIdleTimeout(int)
     */
    @Override
    public void setIdleTimeout(final int idleTimeout) {
        m_pool.setMaxIdleTime(idleTimeout);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.ClosableDataSource#setMinPool(int)
     */
    @Override
    public void setMinPool(final int minPool) {
        LOG.debug("Because of a bug in C3P0, minPool should equal maxPool.  Ignoring.");
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.ClosableDataSource#setMaxPool(int)
     */
    @Override
    public void setMaxPool(final int maxPool) {
        m_pool.setMinPoolSize(maxPool);
        m_pool.setMaxPoolSize(maxPool);
    }

    /* (non-Javadoc)
     * @see org.opennms.core.db.ClosableDataSource#setMaxSize(int)
     */
    @Override
    public void setMaxSize(final int maxSize) {
        LOG.debug("C3P0 has no equivalent to setMaxSize.  Ignoring.");
    }
}
