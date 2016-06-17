
package com.nsbdev.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.nsbdev.beans.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nsbdev.ws package. 
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

    private final static QName _TransferMessage_QNAME = new QName("http://ws.nsbdev.com/", "transferMessage");
    private final static QName _SaveToDB_QNAME = new QName("http://ws.nsbdev.com/", "saveToDB");
    private final static QName _SaveToDBResponse_QNAME = new QName("http://ws.nsbdev.com/", "saveToDBResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nsbdev.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveToDB }
     * 
     */
    public SaveToDB createSaveToDB() {
        return new SaveToDB();
    }

    /**
     * Create an instance of {@link SaveToDBResponse }
     * 
     */
    public SaveToDBResponse createSaveToDBResponse() {
        return new SaveToDBResponse();
    }

    /**
     * Create an instance of {@link TransferMessage }
     * 
     */
    public TransferMessage createTransferMessage() {
        return new TransferMessage();
    }

    /**
     * Create an instance of {@link Acknowledgement }
     * 
     */
    public Acknowledgement createAcknowledgement() {
        return new Acknowledgement();
    }

    /**
     * Create an instance of {@link BLRAPN }
     * 
     */
    public BLRAPN createBLRAPN() {
        return new BLRAPN();
    }

    /**
     * Create an instance of {@link ReferenceDocument }
     * 
     */
    public ReferenceDocument createReferenceDocument() {
        return new ReferenceDocument();
    }

    /**
     * Create an instance of {@link ErrorOrAcknowledgement }
     * 
     */
    public ErrorOrAcknowledgement createErrorOrAcknowledgement() {
        return new ErrorOrAcknowledgement();
    }

    /**
     * Create an instance of {@link Shipper }
     * 
     */
    public Shipper createShipper() {
        return new Shipper();
    }

    /**
     * Create an instance of {@link Receiver }
     * 
     */
    public Receiver createReceiver() {
        return new Receiver();
    }

    /**
     * Create an instance of {@link MessageHeader }
     * 
     */
    public MessageHeader createMessageHeader() {
        return new MessageHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.nsbdev.com/", name = "transferMessage")
    public JAXBElement<TransferMessage> createTransferMessage(TransferMessage value) {
        return new JAXBElement<TransferMessage>(_TransferMessage_QNAME, TransferMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveToDB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.nsbdev.com/", name = "saveToDB")
    public JAXBElement<SaveToDB> createSaveToDB(SaveToDB value) {
        return new JAXBElement<SaveToDB>(_SaveToDB_QNAME, SaveToDB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveToDBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.nsbdev.com/", name = "saveToDBResponse")
    public JAXBElement<SaveToDBResponse> createSaveToDBResponse(SaveToDBResponse value) {
        return new JAXBElement<SaveToDBResponse>(_SaveToDBResponse_QNAME, SaveToDBResponse.class, null, value);
    }

}
