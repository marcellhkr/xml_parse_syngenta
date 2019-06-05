//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementacao de Referencia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificaces neste arquivo serao perdidas apos recompilacao do esquema de origem. 
// Gerado em: 2019.05.22 �s 02:38:59 PM BRT 
//


package br.com.syngenta.xml.mapper;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de anonymous complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
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
 *                   &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="receiverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
 *                   &lt;element name="subMessageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
 *                             &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
     * Obt�m o valor da propriedade header.
     *
     * @return possible object is
     * {@link DocumentFolder.Header }
     */
    public DocumentFolder.Header getHeader() {
        return header;
    }

    /**
     * Define o valor da propriedade header.
     *
     * @param value allowed object is
     *              {@link DocumentFolder.Header }
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
     */
    public List<DocumentFolder.DocumentFolderDetail> getDocumentFolderDetail() {
        if (documentFolderDetail == null) {
            documentFolderDetail = new ArrayList<DocumentFolder.DocumentFolderDetail>();
        }
        return this.documentFolderDetail;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="documentFolderReference" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="subMessageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
     *                   &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        protected int subMessageId;
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
         * Obt�m o valor da propriedade documentFolderReference.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDocumentFolderReference() {
            return documentFolderReference;
        }

        /**
         * Define o valor da propriedade documentFolderReference.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDocumentFolderReference(String value) {
            this.documentFolderReference = value;
        }

        /**
         * Obt�m o valor da propriedade subMessageId.
         */
        public int getSubMessageId() {
            return subMessageId;
        }

        /**
         * Define o valor da propriedade subMessageId.
         */
        public void setSubMessageId(int value) {
            this.subMessageId = value;
        }

        /**
         * Obt�m o valor da propriedade messageFunctionCode.
         *
         * @return possible object is
         * {@link String }
         */
        public String getMessageFunctionCode() {
            return messageFunctionCode;
        }

        /**
         * Define o valor da propriedade messageFunctionCode.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setMessageFunctionCode(String value) {
            this.messageFunctionCode = value;
        }

        /**
         * Obt�m o valor da propriedade subscriptionEvent.
         *
         * @return possible object is
         * {@link DocumentFolder.DocumentFolderDetail.SubscriptionEvent }
         */
        public DocumentFolder.DocumentFolderDetail.SubscriptionEvent getSubscriptionEvent() {
            return subscriptionEvent;
        }

        /**
         * Define o valor da propriedade subscriptionEvent.
         *
         * @param value allowed object is
         *              {@link DocumentFolder.DocumentFolderDetail.SubscriptionEvent }
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
         */
        public List<String> getShipmentNumber() {
            if (shipmentNumber == null) {
                shipmentNumber = new ArrayList<String>();
            }
            return this.shipmentNumber;
        }

        /**
         * Obt�m o valor da propriedade documentFolderURL.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDocumentFolderURL() {
            return documentFolderURL;
        }

        /**
         * Define o valor da propriedade documentFolderURL.
         *
         * @param value allowed object is
         *              {@link String }
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
         */
        public List<DocumentFolder.DocumentFolderDetail.Party> getParty() {
            if (party == null) {
                party = new ArrayList<DocumentFolder.DocumentFolderDetail.Party>();
            }
            return this.party;
        }

        /**
         * Obt�m o valor da propriedade document.
         *
         * @return possible object is
         * {@link DocumentFolder.DocumentFolderDetail.Document }
         */
        public DocumentFolder.DocumentFolderDetail.Document getDocument() {
            return document;
        }

        /**
         * Define o valor da propriedade document.
         *
         * @param value allowed object is
         *              {@link DocumentFolder.DocumentFolderDetail.Document }
         */
        public void setDocument(DocumentFolder.DocumentFolderDetail.Document value) {
            this.document = value;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         *
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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

            protected int revisionNumber;
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
             * Obt�m o valor da propriedade revisionNumber.
             */
            public int getRevisionNumber() {
                return revisionNumber;
            }

            /**
             * Define o valor da propriedade revisionNumber.
             */
            public void setRevisionNumber(int value) {
                this.revisionNumber = value;
            }

            /**
             * Obt�m o valor da propriedade name.
             *
             * @return possible object is
             * {@link String }
             */
            public String getName() {
                return name;
            }

            /**
             * Define o valor da propriedade name.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obt�m o valor da propriedade encodingCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getEncodingCode() {
                return encodingCode;
            }

            /**
             * Define o valor da propriedade encodingCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setEncodingCode(String value) {
                this.encodingCode = value;
            }

            /**
             * Obt�m o valor da propriedade mimeType.
             *
             * @return possible object is
             * {@link String }
             */
            public String getMimeType() {
                return mimeType;
            }

            /**
             * Define o valor da propriedade mimeType.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setMimeType(String value) {
                this.mimeType = value;
            }

            /**
             * Obt�m o valor da propriedade documentTypeCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getDocumentTypeCode() {
                return documentTypeCode;
            }

            /**
             * Define o valor da propriedade documentTypeCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setDocumentTypeCode(String value) {
                this.documentTypeCode = value;
            }

            /**
             * Obt�m o valor da propriedade content.
             *
             * @return possible object is
             * {@link String }
             */
            public String getContent() {
                return content;
            }

            /**
             * Define o valor da propriedade content.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setContent(String value) {
                this.content = value;
            }

        }


        /**
         * <p>Classe Java de anonymous complex type.
         *
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
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
             * Obt�m o valor da propriedade partyRoleCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getPartyRoleCode() {
                return partyRoleCode;
            }

            /**
             * Define o valor da propriedade partyRoleCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setPartyRoleCode(String value) {
                this.partyRoleCode = value;
            }

            /**
             * Obt�m o valor da propriedade identification.
             *
             * @return possible object is
             * {@link DocumentFolder.DocumentFolderDetail.Party.Identification }
             */
            public DocumentFolder.DocumentFolderDetail.Party.Identification getIdentification() {
                return identification;
            }

            /**
             * Define o valor da propriedade identification.
             *
             * @param value allowed object is
             *              {@link DocumentFolder.DocumentFolderDetail.Party.Identification }
             */
            public void setIdentification(DocumentFolder.DocumentFolderDetail.Party.Identification value) {
                this.identification = value;
            }


            /**
             * <p>Classe Java de anonymous complex type.
             *
             * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
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
                 * Obt�m o valor da propriedade type.
                 *
                 * @return possible object is
                 * {@link String }
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Define o valor da propriedade type.
                 *
                 * @param value allowed object is
                 *              {@link String }
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Obt�m o valor da propriedade value.
                 *
                 * @return possible object is
                 * {@link String }
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Define o valor da propriedade value.
                 *
                 * @param value allowed object is
                 *              {@link String }
                 */
                public void setValue(String value) {
                    this.value = value;
                }

            }

        }


        /**
         * <p>Classe Java de anonymous complex type.
         *
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
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
             * Obt�m o valor da propriedade eventTypeCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getEventTypeCode() {
                return eventTypeCode;
            }

            /**
             * Define o valor da propriedade eventTypeCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setEventTypeCode(String value) {
                this.eventTypeCode = value;
            }

            /**
             * Obt�m o valor da propriedade eventRoleCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getEventRoleCode() {
                return eventRoleCode;
            }

            /**
             * Define o valor da propriedade eventRoleCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setEventRoleCode(String value) {
                this.eventRoleCode = value;
            }

            /**
             * Obt�m o valor da propriedade eventDate.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getEventDate() {
                return eventDate;
            }

            /**
             * Define o valor da propriedade eventDate.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setEventDate(XMLGregorianCalendar value) {
                this.eventDate = value;
            }

            /**
             * Obt�m o valor da propriedade eventDateTime.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getEventDateTime() {
                return eventDateTime;
            }

            /**
             * Define o valor da propriedade eventDateTime.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setEventDateTime(XMLGregorianCalendar value) {
                this.eventDateTime = value;
            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="receiverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        protected int messageId;
        @XmlElement(required = true)
        protected String senderId;
        @XmlElement(required = true)
        protected String receiverId;
        protected int count;
        @XmlElement(required = true)
        protected DocumentFolder.Header.FunctionalAcknowledgementRequest functionalAcknowledgementRequest;

        /**
         * Obt�m o valor da propriedade version.
         */
        public int getVersion() {
            return version;
        }

        /**
         * Define o valor da propriedade version.
         */
        public void setVersion(int value) {
            this.version = value;
        }

        /**
         * Obt�m o valor da propriedade documentType.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDocumentType() {
            return documentType;
        }

        /**
         * Define o valor da propriedade documentType.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDocumentType(String value) {
            this.documentType = value;
        }

        /**
         * Obt�m o valor da propriedade messageId.
         */
        public int getMessageId() {
            return messageId;
        }

        /**
         * Define o valor da propriedade messageId.
         */
        public void setMessageId(int value) {
            this.messageId = value;
        }

        /**
         * Obt�m o valor da propriedade senderId.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSenderId() {
            return senderId;
        }

        /**
         * Define o valor da propriedade senderId.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSenderId(String value) {
            this.senderId = value;
        }

        /**
         * Obt�m o valor da propriedade receiverId.
         *
         * @return possible object is
         * {@link String }
         */
        public String getReceiverId() {
            return receiverId;
        }

        /**
         * Define o valor da propriedade receiverId.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setReceiverId(String value) {
            this.receiverId = value;
        }

        /**
         * Obt�m o valor da propriedade count.
         */
        public int getCount() {
            return count;
        }

        /**
         * Define o valor da propriedade count.
         */
        public void setCount(int value) {
            this.count = value;
        }

        /**
         * Obt�m o valor da propriedade functionalAcknowledgementRequest.
         *
         * @return possible object is
         * {@link DocumentFolder.Header.FunctionalAcknowledgementRequest }
         */
        public DocumentFolder.Header.FunctionalAcknowledgementRequest getFunctionalAcknowledgementRequest() {
            return functionalAcknowledgementRequest;
        }

        /**
         * Define o valor da propriedade functionalAcknowledgementRequest.
         *
         * @param value allowed object is
         *              {@link DocumentFolder.Header.FunctionalAcknowledgementRequest }
         */
        public void setFunctionalAcknowledgementRequest(DocumentFolder.Header.FunctionalAcknowledgementRequest value) {
            this.functionalAcknowledgementRequest = value;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         *
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
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
             * Obt�m o valor da propriedade functionalAcknowledgeRequestTypeCode.
             *
             * @return possible object is
             * {@link String }
             */
            public String getFunctionalAcknowledgeRequestTypeCode() {
                return functionalAcknowledgeRequestTypeCode;
            }

            /**
             * Define o valor da propriedade functionalAcknowledgeRequestTypeCode.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setFunctionalAcknowledgeRequestTypeCode(String value) {
                this.functionalAcknowledgeRequestTypeCode = value;
            }

            /**
             * Obt�m o valor da propriedade isIncludeOriginalMessage.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIsIncludeOriginalMessage() {
                return isIncludeOriginalMessage;
            }

            /**
             * Define o valor da propriedade isIncludeOriginalMessage.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIsIncludeOriginalMessage(String value) {
                this.isIncludeOriginalMessage = value;
            }

        }

    }

}
