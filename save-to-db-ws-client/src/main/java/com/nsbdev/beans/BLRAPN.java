package com.nsbdev.beans;

import java.io.Serializable;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

import com.nsbdev.utils.JaxbUtils;

@XmlRootElement(name = "BLRAPN")
@XmlAccessorType(XmlAccessType.FIELD)
public class BLRAPN implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "MessageHeader")
	private MessageHeader messageHeader;

	@XmlElement(name = "Acknowledgement")
	private Acknowledgement acknowledgement;

	public BLRAPN(MessageHeader messageHeader, Acknowledgement acknowledgement) {
		super();
		this.messageHeader = messageHeader;
		this.acknowledgement = acknowledgement;
	}

	public BLRAPN() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acknowledgement == null) ? 0 : acknowledgement.hashCode());
		result = prime * result + ((messageHeader == null) ? 0 : messageHeader.hashCode());
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
		BLRAPN other = (BLRAPN) obj;
		if (acknowledgement == null) {
			if (other.acknowledgement != null)
				return false;
		} else if (!acknowledgement.equals(other.acknowledgement))
			return false;
		if (messageHeader == null) {
			if (other.messageHeader != null)
				return false;
		} else if (!messageHeader.equals(other.messageHeader))
			return false;
		return true;
	}

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	@Override
	public String toString() {
		try {
			return JaxbUtils.marshallToString(this);
		} catch (JAXBException e) {
			throw new RuntimeException("error in marhalling", e);
		}
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public Acknowledgement getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(Acknowledgement acknowledgement) {
		this.acknowledgement = acknowledgement;
	}

}
