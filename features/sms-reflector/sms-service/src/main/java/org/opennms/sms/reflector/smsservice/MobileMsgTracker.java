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

package org.opennms.sms.reflector.smsservice;

import org.smslib.OutboundMessage;
import org.smslib.USSDRequest;

/**
 * MobileMsgTracker
 *
 * @author brozow
 * @version $Id: $
 */
public interface MobileMsgTracker {

    /**
     * <p>
     * sendSmsRequest
     * </p>
     *
     * @param msg
     *            a {@link org.smslib.OutboundMessage} object.
     * @param timeout
     *            a long.
     * @param retries
     *            a int.
     * @param cb
     *            a
     *            {@link org.opennms.sms.reflector.smsservice.MobileMsgResponseCallback}
     *            object.
     * @param matcher
     *            a
     *            {@link org.opennms.sms.reflector.smsservice.MobileMsgResponseMatcher}
     *            object.
     * @return a {@link org.opennms.sms.reflector.smsservice.MobileMsgRequest}
     *         object.
     * @throws java.lang.Exception
     *             if any.
     */
    public abstract MobileMsgRequest sendSmsRequest(OutboundMessage msg, long timeout, int retries,
            MobileMsgResponseCallback cb, MobileMsgResponseMatcher matcher) throws Exception;

    /**
     * <p>
     * sendUssdRequest
     * </p>
     *
     * @param msg
     *            a {@link org.smslib.USSDRequest} object.
     * @param timeout
     *            a long.
     * @param retries
     *            a int.
     * @param cb
     *            a
     *            {@link org.opennms.sms.reflector.smsservice.MobileMsgResponseCallback}
     *            object.
     * @param matcher
     *            a
     *            {@link org.opennms.sms.reflector.smsservice.MobileMsgResponseMatcher}
     *            object.
     * @return a {@link org.opennms.sms.reflector.smsservice.MobileMsgRequest}
     *         object.
     * @throws java.lang.Exception
     *             if any.
     */
    public abstract MobileMsgRequest sendUssdRequest(USSDRequest msg, long timeout, int retries,
            MobileMsgResponseCallback cb, MobileMsgResponseMatcher matcher) throws Exception;

}
