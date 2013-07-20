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

package org.opennms.netmgt.config;

import java.io.IOException;
import java.util.Iterator;

import junit.framework.TestCase;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.opennms.netmgt.config.xmlrpcd.ExternalServers;
import org.opennms.netmgt.config.xmlrpcd.Subscription;

public class XmlrpcdConfigFactoryTest extends TestCase {

    public void testReadOldStyleConfiguration() throws MarshalException, ValidationException, IOException {
        XmlrpcdConfigFactory f = new XmlrpcdConfigFactory(
                                                          this.getClass().getResourceAsStream("xmlrpcd-configuration-old.xml"));

        // should have exactly one external server entry, and one subscription
        // entry
        assertEquals("one external server", 1, f.getExternalServerCollection().size());
        assertEquals("one subscription", 1, f.getSubscriptionCollection().size());

        // check the subscription references
        ExternalServers e = f.getExternalServerCollection().iterator().next();
        assertEquals("one subscription", 1, e.getServerSubscriptionCount());
        assertTrue("subscription should be autogenerated",
                   e.getServerSubscription(0).startsWith("legacyServerSubscription-"));

        // subscription should match the one from the first external server
        Subscription s = f.getSubscriptionCollection().iterator().next();
        assertEquals("subscription name matches external-servers entry", e.getServerSubscription(0), s.getName());

        // subscription should have 6 UEIs
        assertEquals("subscription should have 6 UEIs", 6, s.getSubscribedEventCount());
    }

    public void testReadNewStyleConfiguration() throws MarshalException, ValidationException, IOException {
        XmlrpcdConfigFactory f = new XmlrpcdConfigFactory(
                                                          this.getClass().getResourceAsStream("xmlrpcd-configuration-new.xml"));
        ExternalServers e = null;
        Subscription s = null;

        // check entries
        assertEquals("number of external-server entries", 2, f.getExternalServerCollection().size());
        assertEquals("number of subscriptions", 3, f.getSubscriptionCollection().size());

        Iterator<ExternalServers> es = f.getExternalServerCollection().iterator();

        // first external-server should have 2 subscriptions
        e = es.next();
        assertEquals("two subscriptions", 2, e.getServerSubscriptionCount());
        assertTrue("first subscription should be serviceEvents", e.getServerSubscription(0).equals("serviceEvents"));

        // second one should be automatically generated
        e = es.next();
        assertEquals("should have one serverSubscription", 1, e.getServerSubscriptionCount());
        assertTrue("should be autogenerated", e.getServerSubscription(0).startsWith("legacyServerSubscription-"));

        Iterator<Subscription> is = f.getSubscriptionCollection().iterator();

        // first entry, serviceEvents
        s = is.next();
        assertEquals("first entry is serviceEvents", "serviceEvents", s.getName());
        assertEquals("serviceEvents has 2 entries", 2, s.getSubscribedEventCount());

        // second entry, otherEvents
        s = is.next();
        assertEquals("second entry is otherEvents", "otherEvents", s.getName());
        assertEquals("otherEvents has 5 entries", 7, s.getSubscribedEventCount());

        // third entry, generated
        s = is.next();
        assertEquals("third entry is generated", e.getServerSubscription(0), s.getName());
        assertEquals("autogenerated entries have 9 UEIs", 9, s.getSubscribedEventCount());

    }

}
