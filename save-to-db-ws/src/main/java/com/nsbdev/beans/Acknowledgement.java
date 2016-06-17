package com.nsbdev.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Acknowledgement", propOrder = {
	    "documentId",
	    "functionCode",
	    "creationDateTime",
	    "deliveryNoteID",
	    "deliveryNoteDate",
	    "referenceDocument",
	    "shipper",
	    "receiver",
	    "errorOrAcknowledgement"
	})
public class Acknowledgement implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "DocumentID")
	private String documentId;

	@XmlElement(name = "FunctionCode")
	private String functionCode;

	@XmlElement(name = "CreationDateTime")
	private String creationDateTime;

	@XmlElement(name = "DeliveryNoteID")
	private String deliveryNoteID;

	@XmlElement(name = "DeliveryNoteDate")
	private String deliveryNoteDate;

	@XmlElement(name = "ReferenceDocument")
	private ReferenceDocument referenceDocument;

	@XmlElement(name = "Shipper")
	private Shipper shipper;

	@XmlElement(name = "Receiver")
	private Receiver receiver;

	@XmlElement(name = "ErrorOrAcknowledgement")
	private ErrorOrAcknowledgement errorOrAcknowledgement;

	public Acknowledgement(String documentId, String functionCode, String creationDateTime, String deliveryNoteID,
			String deliveryNoteDate, ReferenceDocument referenceDocument, Shipper shipper, Receiver receiver,
			ErrorOrAcknowledgement errorOrAcknowledgement) {
		super();
		this.documentId = documentId;
		this.functionCode = functionCode;
		this.creationDateTime = creationDateTime;
		this.deliveryNoteID = deliveryNoteID;
		this.deliveryNoteDate = deliveryNoteDate;
		this.referenceDocument = referenceDocument;
		this.shipper = shipper;
		this.receiver = receiver;
		this.errorOrAcknowledgement = errorOrAcknowledgement;
	}

	public Acknowledgement() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((deliveryNoteDate == null) ? 0 : deliveryNoteDate.hashCode());
		result = prime * result + ((deliveryNoteID == null) ? 0 : deliveryNoteID.hashCode());
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((errorOrAcknowledgement == null) ? 0 : errorOrAcknowledgement.hashCode());
		result = prime * result + ((functionCode == null) ? 0 : functionCode.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((referenceDocument == null) ? 0 : referenceDocument.hashCode());
		result = prime * result + ((shipper == null) ? 0 : shipper.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acknowledgement other = (Acknowledgement) obj;
		if (creationDateTime == null) {
			if (other.creationDateTime != null)
				return false;
		} else if (!creationDateTime.equals(other.creationDateTime))
			return false;
		if (deliveryNoteDate == null) {
			if (other.deliveryNoteDate != null)
				return false;
		} else if (!deliveryNoteDate.equals(other.deliveryNoteDate))
			return false;
		if (deliveryNoteID == null) {
			if (other.deliveryNoteID != null)
				return false;
		} else if (!deliveryNoteID.equals(other.deliveryNoteID))
			return false;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (errorOrAcknowledgement == null) {
			if (other.errorOrAcknowledgement != null)
				return false;
		} else if (!errorOrAcknowledgement.equals(other.errorOrAcknowledgement))
			return false;
		if (functionCode == null) {
			if (other.functionCode != null)
				return false;
		} else if (!functionCode.equals(other.functionCode))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (referenceDocument == null) {
			if (other.referenceDocument != null)
				return false;
		} else if (!referenceDocument.equals(other.referenceDocument))
			return false;
		if (shipper == null) {
			if (other.shipper != null)
				return false;
		} else if (!shipper.equals(other.shipper))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acknowledgement [documentId=" + documentId + ", functionCode=" + functionCode + ", creationDateTime="
				+ creationDateTime + ", deliveryNoteID=" + deliveryNoteID + ", deliveryNoteDate=" + deliveryNoteDate
				+ ", referenceDocument=" + referenceDocument + ", shipper=" + shipper + ", receiver=" + receiver
				+ ", errorOrAcknowledgement=" + errorOrAcknowledgement + "]";
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getDeliveryNoteID() {
		return deliveryNoteID;
	}

	public void setDeliveryNoteID(String deliveryNoteID) {
		this.deliveryNoteID = deliveryNoteID;
	}

	public String getDeliveryNoteDate() {
		return deliveryNoteDate;
	}

	public void setDeliveryNoteDate(String deliveryNoteDate) {
		this.deliveryNoteDate = deliveryNoteDate;
	}

	public ReferenceDocument getReferenceDocument() {
		return referenceDocument;
	}

	public void setReferenceDocument(ReferenceDocument referenceDocument) {
		this.referenceDocument = referenceDocument;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public ErrorOrAcknowledgement getErrorOrAcknowledgement() {
		return errorOrAcknowledgement;
	}

	public void setErrorOrAcknowledgement(ErrorOrAcknowledgement errorOrAcknowledgement) {
		this.errorOrAcknowledgement = errorOrAcknowledgement;
	}

}
