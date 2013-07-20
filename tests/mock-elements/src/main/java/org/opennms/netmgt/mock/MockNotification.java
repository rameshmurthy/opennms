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

package org.opennms.netmgt.mock;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Class MockNotification.
 *
 * @author david
 */
public class MockNotification {

    /** The m_subject. */
    private String m_subject;

    /** The m_email. */
    private String m_email;

    /** The m_pemail. */
    private String m_pemail;

    /** The m_text msg. */
    private String m_textMsg;

    /** The m_expected time. */
    private long m_expectedTime;

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 57).append(m_subject).append(m_email).append(m_pemail).append(m_textMsg).append(m_expectedTime).toHashCode();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object o) {

        if (o instanceof MockNotification) {
            final MockNotification m = (MockNotification) o;
            return (m_subject == null ? m.m_subject == null : m_subject.equals(m.m_subject))
                    && (m_textMsg == null ? m.m_textMsg == null : m_textMsg.equals(m.m_textMsg))
                    && (m_email == null ? m.m_email == null : m_email.equals(m.m_email))
                    && (m_pemail == null ? m.m_pemail == null : m_pemail.equals(m.m_pemail));
        }
        return false;

    }

    /**
     * Gets the email.
     *
     * @return Returns the email.
     */
    public String getEmail() {
        return m_email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            The email to set.
     */
    public void setEmail(final String email) {
        m_email = email;
    }

    /**
     * Gets the pmail.
     *
     * @return Returns the pmail.
     */
    public String getPmail() {
        return m_pemail;
    }

    /**
     * Sets the pmail.
     *
     * @param pmail
     *            The pmail to set.
     */
    public void setPmail(final String pmail) {
        m_pemail = pmail;
    }

    /**
     * Gets the subject.
     *
     * @return Returns the subject.
     */
    public String getSubject() {
        return m_subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject
     *            The subject to set.
     */
    public void setSubject(final String subject) {
        m_subject = subject;
    }

    /**
     * Gets the expected time.
     *
     * @return the expected time
     */
    public long getExpectedTime() {
        return m_expectedTime;
    }

    /**
     * Sets the expected time.
     *
     * @param expectedTime
     *            the new expected time
     */
    public void setExpectedTime(final long expectedTime) {
        m_expectedTime = expectedTime;
    }

    /**
     * Gets the text msg.
     *
     * @return Returns the m_textMsg.
     */
    public String getTextMsg() {
        return m_textMsg;
    }

    /**
     * Sets the text msg.
     *
     * @param textMsg
     *            The m_textMsg to set.
     */
    public void setTextMsg(final String textMsg) {
        m_textMsg = textMsg;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + " expectedTime = '" + m_expectedTime + "'" + " subject = '" + m_subject + "'" + " email = '"
                + m_email + "'" + " textMsg = '" + m_textMsg + "'" + "]";
    }

}
