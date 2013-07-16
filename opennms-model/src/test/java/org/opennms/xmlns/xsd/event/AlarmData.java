/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.03.17 at 12:58:43 PM EDT
//


package org.opennms.xmlns.xsd.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="reduction-key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="alarm-type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="clear-key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="auto-clean" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="x733-alarm-type" type="{http://xmlns.opennms.org/xsd/event}x733-alarm-type" />
 *       &lt;attribute name="x733-probable-cause" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "alarm-data")
public class AlarmData {

    @XmlAttribute(name = "reduction-key", required = true)
    protected String reductionKey;
    @XmlAttribute(name = "alarm-type", required = true)
    protected int alarmType;
    @XmlAttribute(name = "clear-key")
    protected String clearKey;
    @XmlAttribute(name = "auto-clean")
    protected Boolean autoClean;
    @XmlAttribute(name = "x733-alarm-type")
    protected String x733AlarmType;
    @XmlAttribute(name = "x733-probable-cause")
    protected Integer x733ProbableCause;

    /**
     * Gets the value of the reductionKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReductionKey() {
        return reductionKey;
    }

    /**
     * Sets the value of the reductionKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReductionKey(String value) {
        this.reductionKey = value;
    }

    /**
     * Gets the value of the alarmType property.
     *
     */
    public int getAlarmType() {
        return alarmType;
    }

    /**
     * Sets the value of the alarmType property.
     *
     */
    public void setAlarmType(int value) {
        this.alarmType = value;
    }

    /**
     * Gets the value of the clearKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClearKey() {
        return clearKey;
    }

    /**
     * Sets the value of the clearKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClearKey(String value) {
        this.clearKey = value;
    }

    /**
     * Gets the value of the autoClean property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isAutoClean() {
        if (autoClean == null) {
            return false;
        } else {
            return autoClean;
        }
    }

    /**
     * Sets the value of the autoClean property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAutoClean(Boolean value) {
        this.autoClean = value;
    }

    /**
     * Gets the value of the x733AlarmType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getX733AlarmType() {
        return x733AlarmType;
    }

    /**
     * Sets the value of the x733AlarmType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setX733AlarmType(String value) {
        this.x733AlarmType = value;
    }

    /**
     * Gets the value of the x733ProbableCause property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getX733ProbableCause() {
        return x733ProbableCause;
    }

    /**
     * Sets the value of the x733ProbableCause property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setX733ProbableCause(Integer value) {
        this.x733ProbableCause = value;
    }

}
