/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2008-2013 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2013 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.provision.detector.datagram;

import java.io.IOException;
import java.net.DatagramPacket;

import org.opennms.netmgt.provision.detector.datagram.client.DatagramClient;
import org.opennms.netmgt.provision.support.BasicDetector;
import org.opennms.netmgt.provision.support.Client;
import org.opennms.netmgt.provision.support.ResponseValidator;
import org.opennms.netmgt.provision.support.dns.DNSAddressRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <p>
 * DnsDetector class.
 * </p>
 *
 * @author brozow
 * @version $Id: $
 */

@Component
@Scope("prototype")
public class DnsDetector extends BasicDetector<DatagramPacket, DatagramPacket> {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DnsDetector.class);

    /** The Constant DEFAULT_SERVICE_NAME. */
    private static final String DEFAULT_SERVICE_NAME = "DNS";

    /** The Constant DEFAULT_PORT. */
    private static final int DEFAULT_PORT = 53;

    /** The Constant DEFAULT_LOOKUP. */
    private static final String DEFAULT_LOOKUP = "localhost";

    /** The m_lookup. */
    private String m_lookup = DEFAULT_LOOKUP;

    /**
     * Default constructor.
     */
    public DnsDetector() {
        super(DEFAULT_SERVICE_NAME, DEFAULT_PORT);
    }

    /**
     * Constructor for creating a non-default service based on this protocol.
     *
     * @param serviceName
     *            a {@link java.lang.String} object.
     * @param port
     *            a int.
     */
    public DnsDetector(final String serviceName, final int port) {
        super(serviceName, port);
    }

    /**
     * <p>
     * onInit
     * </p>
     * .
     */
    @Override
    protected void onInit() {
        final DNSAddressRequest req = addrRequest(getLookup());
        send(encode(req), verifyResponse(req));
    }

    /**
     * Verify response.
     *
     * @param request
     *            the request
     * @return the response validator
     */
    private static ResponseValidator<DatagramPacket> verifyResponse(final DNSAddressRequest request) {

        return new ResponseValidator<DatagramPacket>() {

            @Override
            public boolean validate(final DatagramPacket response) {

                try {
                    request.verifyResponse(response.getData(), response.getLength());
                } catch (final IOException e) {
                    LOG.info("failed to connect", e);
                    return false;
                }

                return true;
            }

        };
    }

    /**
     * Addr request.
     *
     * @param host
     *            the host
     * @return the dNS address request
     */
    private static DNSAddressRequest addrRequest(final String host) {
        return new DNSAddressRequest(host);
    }

    /**
     * Encode.
     *
     * @param dnsPacket
     *            the dns packet
     * @return the datagram packet
     */
    private static DatagramPacket encode(final DNSAddressRequest dnsPacket) {
        final byte[] data = buildRequest(dnsPacket);
        return new DatagramPacket(data, data.length);
    }

    /**
     * Builds the request.
     *
     * @param request
     *            the request
     * @return the byte[]
     */
    private static byte[] buildRequest(final DNSAddressRequest request) {
        try {
            return request.buildRequest();
        } catch (final IOException e) {
            // this shouldn't really happen
            throw new IllegalStateException("Unable to build dnsRequest!!! This shouldn't happen!!");
        }
    }

    /*
     * (non-Javadoc)
     * @see org.opennms.netmgt.provision.detector.BasicDetector#getClient()
     */
    /** {@inheritDoc} */
    @Override
    protected Client<DatagramPacket, DatagramPacket> getClient() {
        return new DatagramClient();
    }

    /**
     * <p>
     * setLookup
     * </p>
     * .
     *
     * @param lookup
     *            the lookup to set
     */
    public void setLookup(final String lookup) {
        m_lookup = lookup;
    }

    /**
     * <p>
     * getLookup
     * </p>
     * .
     *
     * @return the lookup
     */
    public String getLookup() {
        return m_lookup;
    }
}
