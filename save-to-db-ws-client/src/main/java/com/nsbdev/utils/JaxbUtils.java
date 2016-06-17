package com.nsbdev.utils;

import java.io.File;
import java.io.StringWriter;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nsbdev.beans.BLRAPN;

public class JaxbUtils {

	public static String marshallToString(Object objectToMarshall) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(objectToMarshall.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshaller.marshal(objectToMarshall, sw);

		return sw.toString();
	}

	public static <T> T unMarshall(Path pathToXml, T objectToUnMarshall) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(BLRAPN.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File sourseXml = new File(pathToXml.toString());
		objectToUnMarshall = (T) unmarshaller.unmarshal(sourseXml);

		return objectToUnMarshall;

	}
}
