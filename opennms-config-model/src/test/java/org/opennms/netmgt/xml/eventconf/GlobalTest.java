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

package org.opennms.netmgt.xml.eventconf;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;
import org.opennms.core.test.xml.XmlTestNoCastor;

public class GlobalTest extends XmlTestNoCastor<Global> {

    public GlobalTest(final Global sampleObject, final String sampleXml, final String schemaFile) {
        super(sampleObject, sampleXml, schemaFile);
    }

    @Parameters
    public static Collection<Object[]> data() throws ParseException {
        Global global0 = new Global();
        Security security0 = new Security();
        security0.addDoNotOverride("I'm very important, don't mess with me!");
        global0.setSecurity(security0);
        Global global1 = new Global();
        Security security1 = new Security();
        security1.addDoNotOverride("I'm very important, don't mess with me!");
        security1.addDoNotOverride("Also important");
        global1.setSecurity(security1);
        return Arrays.asList(new Object[][] {
                {
                        global0,
                        "<global>" + "<security>"
                                + "<doNotOverride>I'm very important, don't mess with me!</doNotOverride>"
                                + "</security>" + "</global>", "target/classes/xsds/eventconf.xsd" },
                {
                        global1,
                        "<global>" + "<security>"
                                + "<doNotOverride>I'm very important, don't mess with me!</doNotOverride>"
                                + "<doNotOverride>Also important</doNotOverride>" + "</security>" + "</global>",
                        "target/classes/xsds/eventconf.xsd" }, });
    }

}
