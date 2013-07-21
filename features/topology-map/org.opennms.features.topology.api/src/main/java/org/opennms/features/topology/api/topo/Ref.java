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

package org.opennms.features.topology.api.topo;

/**
 * The Interface Ref.
 */
public interface Ref extends Comparable<Ref> {

    /**
     * An identifier unique to the provider that 'owns' this reference.
     *
     * @return the id
     */
    public String getId();

    /**
     * A string used to identify the provider this belongs to.
     * May only container characters that make for a reasonable java identifier
     * such as letters digits and underscore (no colons, periods, commans etc.)
     *
     * @return the namespace
     */
    public String getNamespace();

    /**
     * A human-readable label for the reference.
     *
     * @return the label
     */
    public String getLabel();

}
