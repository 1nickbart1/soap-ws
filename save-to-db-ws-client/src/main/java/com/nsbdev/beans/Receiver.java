package com.nsbdev.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Receiver implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "GLN")
	private String gln;

	public Receiver(String gln) {
		super();
		this.gln = gln;
	}

	public Receiver() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gln == null) ? 0 : gln.hashCode());
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
		Receiver other = (Receiver) obj;
		if (gln == null) {
			if (other.getGln() != null)
				return false;
		} else if (!gln.equals(other.getGln()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shipper [gln=" + gln + "]";
	}

	public String getGln() {
		return gln;
	}

}
