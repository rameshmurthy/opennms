/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2009-2012 The OpenNMS Group, Inc.
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

package org.opennms.report.inventory;

/**
 * <p>
 * InventoryCalculationException class.
 * </p>
 *
 * @author ranger
 * @version $Id: $
 */
public class InventoryCalculationException extends Exception {

    private static final long serialVersionUID = -8290071295128513350L;

    /**
     * <p>
     * Constructor for InventoryCalculationException.
     * </p>
     *
     * @param message
     *            a {@link java.lang.String} object.
     * @param cause
     *            a {@link java.lang.Throwable} object.
     */
    public InventoryCalculationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>
     * Constructor for InventoryCalculationException.
     * </p>
     *
     * @param message
     *            a {@link java.lang.String} object.
     */
    public InventoryCalculationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>
     * Constructor for InventoryCalculationException.
     * </p>
     *
     * @param cause
     *            a {@link java.lang.Throwable} object.
     */
    public InventoryCalculationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
