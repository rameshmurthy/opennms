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
package org.opennms.features.vaadin.nodemaps.ui;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opennms.features.geocoder.Coordinates;
import org.opennms.features.geocoder.GeocoderService;
import org.opennms.features.vaadin.nodemaps.internal.MapWidgetComponent;
import org.opennms.netmgt.dao.api.AlarmDao;
import org.opennms.netmgt.dao.api.AssetRecordDao;
import org.opennms.netmgt.dao.api.NodeDao;
import org.opennms.netmgt.model.OnmsAssetRecord;
import org.opennms.netmgt.model.OnmsGeolocation;
import org.opennms.netmgt.model.OnmsNode;

import com.vaadin.server.PaintTarget;

/**
 * The Class OpenlayersWidgetCompontentTest.
 */
public class OpenlayersWidgetCompontentTest {

    /** The m_node dao. */
    private NodeDao m_nodeDao;

    /** The m_asset dao. */
    private AssetRecordDao m_assetDao;

    /** The m_alarm dao. */
    private AlarmDao m_alarmDao;

    /** The m_geocoder. */
    private GeocoderService m_geocoder;

    /** The m_component. */
    @SuppressWarnings("unused")
    private MapWidgetComponent m_component;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        m_nodeDao = EasyMock.createMock(NodeDao.class);
        m_assetDao = EasyMock.createMock(AssetRecordDao.class);
        m_alarmDao = EasyMock.createMock(AlarmDao.class);
        m_geocoder = EasyMock.createMock(GeocoderService.class);
        m_component = new MapWidgetComponent();
    }

    /**
     * Test geolocation.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @Ignore
    public void testGeolocation() throws Exception {
        final OnmsNode node = new OnmsNode();
        final OnmsAssetRecord asset = new OnmsAssetRecord();
        final OnmsGeolocation geo = new OnmsGeolocation();

        node.setId(1);
        node.setAssetRecord(asset);
        asset.setGeolocation(geo);

        geo.setAddress1("220 Chatham Business Dr.");
        geo.setCity("Pittsboro");
        geo.setState("NC");
        geo.setZip("27312");

        assertEquals("220 Chatham Business Dr., Pittsboro, NC 27312", geo.asAddressString());

        EasyMock.expect(m_geocoder.getCoordinates(geo.asAddressString())).andReturn(new Coordinates(-1.0f, 1.0f)).times(1);
        final PaintTarget target = EasyMock.createMock(PaintTarget.class);

        m_assetDao.saveOrUpdate(EasyMock.isA(OnmsAssetRecord.class));

        target.startTag(EasyMock.eq("1"));
        target.addAttribute(EasyMock.eq("longitude"), EasyMock.eq("-1.0"));
        target.addAttribute(EasyMock.eq("latitude"), EasyMock.eq("1.0"));
        target.endTag(EasyMock.eq("1"));

        EasyMock.replay(m_nodeDao, m_assetDao, m_geocoder, target);

        // m_component.paintNode(target, node);

        EasyMock.verify(m_nodeDao, m_assetDao, m_geocoder, target);
    }
}
