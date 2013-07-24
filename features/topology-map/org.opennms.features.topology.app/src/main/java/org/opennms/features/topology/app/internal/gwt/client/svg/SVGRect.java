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

package org.opennms.features.topology.app.internal.gwt.client.svg;

import com.google.gwt.dom.client.Element;

/**
 * The Class SVGRect.
 */
public class SVGRect extends Element {

    /**
     * Instantiates a new sVG rect.
     */
    protected SVGRect() {
    };

    /**
     * Gets the height.
     *
     * @return the height
     */
    public final native int getHeight() /*-{
                                        return this.height;
                                        }-*/;

    /**
     * Gets the width.
     *
     * @return the width
     */
    public final native int getWidth() /*-{
                                       return this.width;
                                       }-*/;

    /**
     * Gets the x.
     *
     * @return the x
     */
    public final native int getX() /*-{
                                   return this.x;
                                   }-*/;

    /**
     * Gets the y.
     *
     * @return the y
     */
    public final native int getY() /*-{
                                   return this.y;
                                   }-*/;

}
