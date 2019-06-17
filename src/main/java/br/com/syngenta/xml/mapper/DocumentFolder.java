
package br.com.syngenta.xml.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="receiverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="functionalAcknowledgementRequest">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="functionalAcknowledgeRequestTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="isIncludeOriginalMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="documentFolderDetail" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="documentFolderReference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="subMessageId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="messageFunctionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="subscriptionEvent">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="eventTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="eventRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="eventDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="deliveryNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                   &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                   &lt;element name="shipmentNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                   &lt;element name="documentFolderURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="party" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="partyRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="identification">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="document">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="encodingCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="documentTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "documentFolderDetail"
})
@XmlRootElement(name = "DocumentFolder")
public class DocumentFolder {

    @XmlElement(required = true)
    protected DocumentFolder.Header header;
    @XmlElement(required = true)
    protected List<DocumentFolder.DocumentFolderDetail> documentFolderDetail;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentFolder.Header }
     *     
     */
    public DocumentFolder.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentFolder.Header }
     *     
     */
    public void setHeader(DocumentFolder.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the documentFolderDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentFolderDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentFolderDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentFolder.DocumentFolderDetail }
     * 
     * 
     */
    public List<DocumentFolder.DocumentFolderDetail> getDocumentFolderDetail() {
        if (documentFolderDetail == null) {
            documentFolderDetail = new ArrayList<DocumentFolder.DocumentFolderDetail>();
        }
        return this.documentFolderDetail;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="documentFolderReference" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="subMessageId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="messageFunctionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="subscriptionEvent">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="eventTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="eventRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="eventDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="deliveryNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *         &lt;element name="shipmentNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *         &lt;element name="documentFolderURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="party" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="partyRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="identification">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="document">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="encodingCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="documentTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentFolderReference",
        "subMessageId",
        "messageFunctionCode",
        "subscriptionEvent",
        "deliveryNumber",
        "orderNumber",
        "shipmentNumber",
        "documentFolderURL",
        "party",
        "document"
    })
    public static class DocumentFolderDetail {

        @XmlElement(required = true)
        protected String documentFolderReference;
        protected Integer subMessageId;
        @XmlElement(required = true)
        protected String messageFunctionCode;
        @XmlElement(required = true)
        protected DocumentFolder.DocumentFolderDetail.SubscriptionEvent subscriptionEvent;
        @XmlElement(required = true)
        protected List<String> deliveryNumber;
        @XmlElement(required = true)
        protected List<String> orderNumber;
        @XmlElement(required = true)
        protected List<String> shipmentNumber;
        @XmlElement(required = true)
        protected String documentFolderURL;
        @XmlElement(required = true)
        protected List<DocumentFolder.DocumentFolderDetail.Party> party;
        @XmlElement(required = true)
        protected DocumentFolder.DocumentFolderDetail.Document document;

        /**
         * Gets the value of the documentFolderReference property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentFolderReference() {
            return documentFolderReference;
        }

        /**
         * Sets the value of the documentFolderReference property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentFolderReference(String value) {
            this.documentFolderReference = value;
        }

        /**
         * Gets the value of the subMessageId property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getSubMessageId() {
            return subMessageId;
        }

        /**
         * Sets the value of the subMessageId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setSubMessageId(Integer value) {
            this.subMessageId = value;
        }

        /**
         * Gets the value of the messageFunctionCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageFunctionCode() {
            return messageFunctionCode;
        }

        /**
         * Sets the value of the messageFunctionCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageFunctionCode(String value) {
            this.messageFunctionCode = value;
        }

        /**
         * Gets the value of the subscriptionEvent property.
         * 
         * @return
         *     possible object is
         *     {@link DocumentFolder.DocumentFolderDetail.SubscriptionEvent }
         *     
         */
        public DocumentFolder.DocumentFolderDetail.SubscriptionEvent getSubscriptionEvent() {
            return subscriptionEvent;
        }

        /**
         * Sets the value of the subscriptionEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentFolder.DocumentFolderDetail.SubscriptionEvent }
         *     
         */
        public void setSubscriptionEvent(DocumentFolder.DocumentFolderDetail.SubscriptionEvent value) {
            this.subscriptionEvent = value;
        }

        /**
         * Gets the value of the deliveryNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the deliveryNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeliveryNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDeliveryNumber() {
            if (deliveryNumber == null) {
                deliveryNumber = new ArrayList<String>();
            }
            return this.deliveryNumber;
        }

        /**
         * Gets the value of the orderNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the orderNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrderNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOrderNumber() {
            if (orderNumber == null) {
                orderNumber = new ArrayList<String>();
            }
            return this.orderNumber;
        }

        /**
         * Gets the value of the shipmentNumber property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shipmentNumber property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShipmentNumber().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getShipmentNumber() {
            if (shipmentNumber == null) {
                shipmentNumber = new ArrayList<String>();
            }
            return this.shipmentNumber;
        }

        /**
         * Gets the value of the documentFolderURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentFolderURL() {
            return documentFolderURL;
        }

        /**
         * Sets the value of the documentFolderURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentFolderURL(String value) {
            this.documentFolderURL = value;
        }

        /**
         * Gets the value of the party property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the party property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentFolder.DocumentFolderDetail.Party }
         * 
         * 
         */
        public List<DocumentFolder.DocumentFolderDetail.Party> getParty() {
            if (party == null) {
                party = new ArrayList<DocumentFolder.DocumentFolderDetail.Party>();
            }
            return this.party;
        }

        /**
         * Gets the value of the document property.
         * 
         * @return
         *     possible object is
         *     {@link DocumentFolder.DocumentFolderDetail.Document }
         *     
         */
        public DocumentFolder.DocumentFolderDetail.Document getDocument() {
            return document;
        }

        /**
         * Sets the value of the document property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentFolder.DocumentFolderDetail.Document }
         *     
         */
        public void setDocument(DocumentFolder.DocumentFolderDetail.Document value) {
            this.document = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="encodingCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="documentTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "revisionNumber",
            "name",
            "encodingCode",
            "mimeType",
            "documentTypeCode",
            "content"
        })
        public static class Document {

            protected Integer revisionNumber;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String encodingCode;
            @XmlElement(required = true)
            protected String mimeType;
            @XmlElement(required = true)
            protected String documentTypeCode;
            @XmlElement(required = true)
            protected String content;

            /**
             * Gets the value of the revisionNumber property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getRevisionNumber() {
                return revisionNumber;
            }

            /**
             * Sets the value of the revisionNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setRevisionNumber(Integer value) {
                this.revisionNumber = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the encodingCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEncodingCode() {
                return encodingCode;
            }

            /**
             * Sets the value of the encodingCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEncodingCode(String value) {
                this.encodingCode = value;
            }

            /**
             * Gets the value of the mimeType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMimeType() {
                return mimeType;
            }

            /**
             * Sets the value of the mimeType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMimeType(String value) {
                this.mimeType = value;
            }

            /**
             * Gets the value of the documentTypeCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocumentTypeCode() {
                return documentTypeCode;
            }

            /**
             * Sets the value of the documentTypeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocumentTypeCode(String value) {
                this.documentTypeCode = value;
            }

            /**
             * Gets the value of the content property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContent() {
                return content;
            }

            /**
             * Sets the value of the content property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContent(String value) {
                this.content = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="partyRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="identification">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "partyRoleCode",
            "identification"
        })
        public static class Party {

            @XmlElement(required = true)
            protected String partyRoleCode;
            @XmlElement(required = true)
            protected DocumentFolder.DocumentFolderDetail.Party.Identification identification;

            /**
             * Gets the value of the partyRoleCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPartyRoleCode() {
                return partyRoleCode;
            }

            /**
             * Sets the value of the partyRoleCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPartyRoleCode(String value) {
                this.partyRoleCode = value;
            }

            /**
             * Gets the value of the identification property.
             * 
             * @return
             *     possible object is
             *     {@link DocumentFolder.DocumentFolderDetail.Party.Identification }
             *     
             */
            public DocumentFolder.DocumentFolderDetail.Party.Identification getIdentification() {
                return identification;
            }

            /**
             * Sets the value of the identification property.
             * 
             * @param value
             *     allowed object is
             *     {@link DocumentFolder.DocumentFolderDetail.Party.Identification }
             *     
             */
            public void setIdentification(DocumentFolder.DocumentFolderDetail.Party.Identification value) {
                this.identification = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "type",
                "value"
            })
            public static class Identification {

                @XmlElement(required = true)
                protected String type;
                @XmlElement(required = true)
                protected String value;

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="eventTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="eventRoleCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="eventDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "eventTypeCode",
            "eventRoleCode",
            "eventDate",
            "eventDateTime"
        })
        public static class SubscriptionEvent {

            @XmlElement(required = true)
            protected String eventTypeCode;
            @XmlElement(required = true)
            protected String eventRoleCode;
            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar eventDate;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar eventDateTime;

            /**
             * Gets the value of the eventTypeCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEventTypeCode() {
                return eventTypeCode;
            }

            /**
             * Sets the value of the eventTypeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEventTypeCode(String value) {
                this.eventTypeCode = value;
            }

            /**
             * Gets the value of the eventRoleCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEventRoleCode() {
                return eventRoleCode;
            }

            /**
             * Sets the value of the eventRoleCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEventRoleCode(String value) {
                this.eventRoleCode = value;
            }

            /**
             * Gets the value of the eventDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEventDate() {
                return eventDate;
            }

            /**
             * Sets the value of the eventDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEventDate(XMLGregorianCalendar value) {
                this.eventDate = value;
            }

            /**
             * Gets the value of the eventDateTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEventDateTime() {
                return eventDateTime;
            }

            /**
             * Sets the value of the eventDateTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEventDateTime(XMLGregorianCalendar value) {
                this.eventDateTime = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="receiverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="functionalAcknowledgementRequest">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="functionalAcknowledgeRequestTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="isIncludeOriginalMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "version",
        "documentType",
        "messageId",
        "senderId",
        "receiverId",
        "count",
        "functionalAcknowledgementRequest"
    })
    public static class Header {

        protected int version;
        @XmlElement(required = true)
        protected String documentType;
        protected Integer messageId;
        @XmlElement(required = true)
        protected String senderId;
        @XmlElement(required = true)
        protected String receiverId;
        protected Integer count;
        @XmlElement(required = true)
        protected DocumentFolder.Header.FunctionalAcknowledgementRequest functionalAcknowledgementRequest;

        /**
         * Gets the value of the version property.
         * 
         */
        public int getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         * 
         */
        public void setVersion(int value) {
            this.version = value;
        }

        /**
         * Gets the value of the documentType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentType() {
            return documentType;
        }

        /**
         * Sets the value of the documentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentType(String value) {
            this.documentType = value;
        }

        /**
         * Gets the value of the messageId property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMessageId() {
            return messageId;
        }

        /**
         * Sets the value of the messageId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMessageId(Integer value) {
            this.messageId = value;
        }

        /**
         * Gets the value of the senderId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSenderId() {
            return senderId;
        }

        /**
         * Sets the value of the senderId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSenderId(String value) {
            this.senderId = value;
        }

        /**
         * Gets the value of the receiverId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReceiverId() {
            return receiverId;
        }

        /**
         * Sets the value of the receiverId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReceiverId(String value) {
            this.receiverId = value;
        }

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCount(Integer value) {
            this.count = value;
        }

        /**
         * Gets the value of the functionalAcknowledgementRequest property.
         * 
         * @return
         *     possible object is
         *     {@link DocumentFolder.Header.FunctionalAcknowledgementRequest }
         *     
         */
        public DocumentFolder.Header.FunctionalAcknowledgementRequest getFunctionalAcknowledgementRequest() {
            return functionalAcknowledgementRequest;
        }

        /**
         * Sets the value of the functionalAcknowledgementRequest property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentFolder.Header.FunctionalAcknowledgementRequest }
         *     
         */
        public void setFunctionalAcknowledgementRequest(DocumentFolder.Header.FunctionalAcknowledgementRequest value) {
            this.functionalAcknowledgementRequest = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="functionalAcknowledgeRequestTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="isIncludeOriginalMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "functionalAcknowledgeRequestTypeCode",
            "isIncludeOriginalMessage"
        })
        public static class FunctionalAcknowledgementRequest {

            @XmlElement(required = true)
            protected String functionalAcknowledgeRequestTypeCode;
            @XmlElement(required = true)
            protected String isIncludeOriginalMessage;

            /**
             * Gets the value of the functionalAcknowledgeRequestTypeCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFunctionalAcknowledgeRequestTypeCode() {
                return functionalAcknowledgeRequestTypeCode;
            }

            /**
             * Sets the value of the functionalAcknowledgeRequestTypeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFunctionalAcknowledgeRequestTypeCode(String value) {
                this.functionalAcknowledgeRequestTypeCode = value;
            }

            /**
             * Gets the value of the isIncludeOriginalMessage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsIncludeOriginalMessage() {
                return isIncludeOriginalMessage;
            }

            /**
             * Sets the value of the isIncludeOriginalMessage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsIncludeOriginalMessage(String value) {
                this.isIncludeOriginalMessage = value;
            }

        }

    }

}
