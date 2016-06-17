package com.nsbdev.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferMessage", propOrder = {
    "fileName",
    "blrapn",
    "key"
})
public class TransferMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "FileName")
	private String fileName;

	@XmlElement(name = "BLRAPN")
	private BLRAPN blrapn;

	@XmlElement(name = "Key")
	private String key;

	public TransferMessage(String fileName, BLRAPN fileInfo, String key) {
		super();
		this.fileName = fileName;
		this.blrapn = fileInfo;
		this.key = key;
	}

	public TransferMessage() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blrapn == null) ? 0 : blrapn.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		TransferMessage other = (TransferMessage) obj;
		if (blrapn == null) {
			if (other.blrapn != null)
				return false;
		} else if (!blrapn.equals(other.blrapn))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransferMessage [fileName=" + fileName + ", fileInfo=" + blrapn + ", key=" + key + "]";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BLRAPN getFileInfo() {
		return blrapn;
	}

	public void setFileInfo(BLRAPN fileInfo) {
		this.blrapn = fileInfo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
