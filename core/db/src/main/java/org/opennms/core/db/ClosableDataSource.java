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

import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * <p>
 * ClosableDataSource interface.
 * </p>
 */
public interface ClosableDataSource extends DataSource {

    /**
     * Close the datasource, if necessary.
     *
     * @throws SQLException
     *             the sQL exception
     */
    void close() throws SQLException;

    /**
     * How long, in seconds, an idle connection is kept in the pool before it is
     * removed.
     *
     * @param idleTimeout
     *            the new idle timeout
     */
    void setIdleTimeout(final int idleTimeout);

    /**
     * How long, in seconds, to attempt to make a connection to the database.
     *
     * @param loginTimeout
     *            the new login timeout
     * @throws SQLException
     *             the sQL exception
     */
    @Override
    void setLoginTimeout(final int loginTimeout) throws SQLException;

    /**
     * The minimum number of pooled connections to retain.
     *
     * @param minPool
     *            the new min pool
     */
    void setMinPool(final int minPool);

    /**
     * The maximum number of pooled connections to retain.
     *
     * @param maxPool
     *            the new max pool
     */
    void setMaxPool(final int maxPool);

    /**
     * The maximum number of connections that can be created.
     *
     * @param maxSize
     *            the new max size
     */
    void setMaxSize(final int maxSize);
}
