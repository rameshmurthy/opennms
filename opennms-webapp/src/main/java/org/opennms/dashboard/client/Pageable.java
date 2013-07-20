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

package org.opennms.dashboard.client;

/**
 * <p>
 * Pageable interface.
 * </p>
 *
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @version $Id: $
 * @since 1.8.1
 */
public interface Pageable {

    /**
     * <p>
     * getCurrentElement
     * </p>
     *
     * @return a int.
     */
    int getCurrentElement();

    /**
     * <p>
     * setCurrentElement
     * </p>
     *
     * @param element
     *            a int.
     */
    void setCurrentElement(int element);

    /**
     * <p>
     * getPageSize
     * </p>
     *
     * @return a int.
     */
    int getPageSize();

    /**
     * <p>
     * getElementCount
     * </p>
     *
     * @return a int.
     */
    int getElementCount();

}
