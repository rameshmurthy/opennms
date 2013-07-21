/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2010-2012 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.jasper.jrobin;

/**
 * The Class ColonSplitter.
 */
class ColonSplitter {

    /** The cmd. */
    private String cmd;

    /** The Constant COLON. */
    private static final String COLON = "@#@";

    /**
     * Instantiates a new colon splitter.
     *
     * @param command
     *            the command
     */
    ColonSplitter(String command) {
        this.cmd = command;
    }

    /**
     * Split.
     *
     * @return the string[]
     */
    String[] split() {
        String[] tokens = cmd.replaceAll("\\\\:", COLON).split(":");
        for (int i = 0; i < tokens.length; i++) {
            String item = tokens[i];
            tokens[i] = tokens[i].replaceAll(COLON, ":");
        }
        return tokens;
    }
}
