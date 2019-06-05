//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementacao de Referencia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificaces neste arquivo serao perdidas apos recompilacao do esquema de origem. 
// Gerado em: 2019.05.22 �s 02:38:59 PM BRT 
//


package br.com.syngenta.xml.mapper;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.syngenta.xml.mapper package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.syngenta.xml.mapper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentFolder }
     * 
     */
    public DocumentFolder createDocumentFolder() {
        return new DocumentFolder();
    }

    /**
     * Create an instance of {@link DocumentFolder.DocumentFolderDetail }
     * 
     */
    public DocumentFolder.DocumentFolderDetail createDocumentFolderDocumentFolderDetail() {
        return new DocumentFolder.DocumentFolderDetail();
    }

    /**
     * Create an instance of {@link DocumentFolder.DocumentFolderDetail.Party }
     * 
     */
    public DocumentFolder.DocumentFolderDetail.Party createDocumentFolderDocumentFolderDetailParty() {
        return new DocumentFolder.DocumentFolderDetail.Party();
    }

    /**
     * Create an instance of {@link DocumentFolder.Header }
     * 
     */
    public DocumentFolder.Header createDocumentFolderHeader() {
        return new DocumentFolder.Header();
    }

    /**
     * Create an instance of {@link DocumentFolder.DocumentFolderDetail.SubscriptionEvent }
     * 
     */
    public DocumentFolder.DocumentFolderDetail.SubscriptionEvent createDocumentFolderDocumentFolderDetailSubscriptionEvent() {
        return new DocumentFolder.DocumentFolderDetail.SubscriptionEvent();
    }

    /**
     * Create an instance of {@link DocumentFolder.DocumentFolderDetail.Document }
     * 
     */
    public DocumentFolder.DocumentFolderDetail.Document createDocumentFolderDocumentFolderDetailDocument() {
        return new DocumentFolder.DocumentFolderDetail.Document();
    }

    /**
     * Create an instance of {@link DocumentFolder.DocumentFolderDetail.Party.Identification }
     * 
     */
    public DocumentFolder.DocumentFolderDetail.Party.Identification createDocumentFolderDocumentFolderDetailPartyIdentification() {
        return new DocumentFolder.DocumentFolderDetail.Party.Identification();
    }

    /**
     * Create an instance of {@link DocumentFolder.Header.FunctionalAcknowledgementRequest }
     * 
     */
    public DocumentFolder.Header.FunctionalAcknowledgementRequest createDocumentFolderHeaderFunctionalAcknowledgementRequest() {
        return new DocumentFolder.Header.FunctionalAcknowledgementRequest();
    }

}
