package com.nsbdev.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeader", propOrder = {
    "messageID",
    "msgDateTime",
    "messageType",
    "msgSenderID",
    "msgReceiverID"
})
public class MessageHeader implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "MessageID")
	private String messageID;

	@XmlElement(name = "MsgDateTime")
	private String msgDateTime;

	@XmlElement(name = "MessageType")
	private String messageType;

	@XmlElement(name = "MsgSenderID")
	private String msgSenderID;

	@XmlElement(name = "MsgReceiverID")
	private String msgReceiverID;

	public MessageHeader() {
		super();
	}

	public MessageHeader(String messageID, String msgDateTime, String messageType, String msgSenderID,
			String msgReceiverID) {
		super();
		this.messageID = messageID;
		this.msgDateTime = msgDateTime;
		this.messageType = messageType;
		this.msgSenderID = msgSenderID;
		this.msgReceiverID = msgReceiverID;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getMsgDateTime() {
		return msgDateTime;
	}

	public void setMsgDateTime(String msgDateTime) {
		this.msgDateTime = msgDateTime;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMsgSenderID() {
		return msgSenderID;
	}

	public void setMsgSenderID(String msgSenderID) {
		this.msgSenderID = msgSenderID;
	}

	public String getMsgReceiverID() {
		return msgReceiverID;
	}

	public void setMsgReceiverID(String msgReceiverID) {
		this.msgReceiverID = msgReceiverID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageID == null) ? 0 : messageID.hashCode());
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result + ((msgDateTime == null) ? 0 : msgDateTime.hashCode());
		result = prime * result + ((msgReceiverID == null) ? 0 : msgReceiverID.hashCode());
		result = prime * result + ((msgSenderID == null) ? 0 : msgSenderID.hashCode());
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
		MessageHeader other = (MessageHeader) obj;
		if (messageID == null) {
			if (other.messageID != null)
				return false;
		} else if (!messageID.equals(other.messageID))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		if (msgDateTime == null) {
			if (other.msgDateTime != null)
				return false;
		} else if (!msgDateTime.equals(other.msgDateTime))
			return false;
		if (msgReceiverID == null) {
			if (other.msgReceiverID != null)
				return false;
		} else if (!msgReceiverID.equals(other.msgReceiverID))
			return false;
		if (msgSenderID == null) {
			if (other.msgSenderID != null)
				return false;
		} else if (!msgSenderID.equals(other.msgSenderID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessageHeader [messageID=" + messageID + ", msgDateTime=" + msgDateTime + ", messageType=" + messageType
				+ ", msgSenderID=" + msgSenderID + ", msgReceiverID=" + msgReceiverID + "]";
	}

}
