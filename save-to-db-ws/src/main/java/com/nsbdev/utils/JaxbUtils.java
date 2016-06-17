package com.nsbdev.utils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbUtils {

	public static String marshallToString(Object objectToMarshall) throws JAXBException{
		
		JAXBContext jc = JAXBContext.newInstance(objectToMarshall.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshaller.marshal(objectToMarshall, sw);
		
		return sw.toString();
	}
}
