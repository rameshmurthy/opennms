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

package org.opennms.sms.monitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * UssdMessageParsing.
 *
 * @author brozow
 */
public class UssdMessageParsingTest {

    /**
     * Test ussd single line.
     */
    @Test
    public void testUssdSingleLine() {
        parseMessage("+CUSD: 2,\"a message\"\r", 2, "2", "a message", null);
    }

    /**
     * Test ussd single line space after status.
     */
    @Test
    public void testUssdSingleLineSpaceAfterStatus() {
        parseMessage("+CUSD: 2, \"a message\"\r", 2, "2", "a message", null);
    }

    /**
     * Test ussd single line with encoding.
     */
    @Test
    public void testUssdSingleLineWithEncoding() {
        parseMessage("+CUSD: 2,\"a message with an encoding\",15\r", 2, "2", "a message with an encoding", "15");
    }

    /**
     * Test ussd single line with encoding space before encoding.
     */
    @Test
    public void testUssdSingleLineWithEncodingSpaceBeforeEncoding() {
        parseMessage("+CUSD: 2,\"a message with an encoding\", 15\r", 2, "2", "a message with an encoding", "15");
    }

    /**
     * Test operation not supprted.
     */
    @Test
    public void testOperationNotSupprted() {
        parseMessage("+CUSD: 4\r", 2, "4", null, null);
    }

    /**
     * Parses the message.
     *
     * @param msg
     *            the msg
     * @param expectedCount
     *            the expected count
     * @param status
     *            the status
     * @param content
     *            the content
     * @param encoding
     *            the encoding
     */
    public void parseMessage(String msg, int expectedCount, String status, String content, String encoding) {
        // Pattern MSG_PATTERN =
        // Pattern.compile("(?s)^\\+CUSD:\\s+(\\d),\"(.*)(\"(,(\\d+))?\r)?$");
        Pattern MSG_PATTERN = Pattern.compile("(?s)^\\+CUSD:\\s+(\\d)(?:,\\s*\"([^\"]*))?(?:\",\\s*(\\d+))?(?:\"\r|\r)$");
        int STATUS_INDEX = 1;
        int CONTENT_INDEX = 2;
        int ENCODING_INDEX = 3;

        Matcher matcher = MSG_PATTERN.matcher(msg);
        assertTrue(matcher.matches());
        // assertEquals(expectedCount, matcher.groupCount());

        assertEquals(status, group(matcher, STATUS_INDEX));
        assertEquals(content, group(matcher, CONTENT_INDEX));
        assertEquals(encoding, group(matcher, ENCODING_INDEX));

    }

    /**
     * Group.
     *
     * @param matcher
     *            the matcher
     * @param index
     *            the index
     * @return the string
     */
    private String group(Matcher matcher, int index) {
        return matcher.groupCount() >= index ? matcher.group(index) : null;
    }

}
