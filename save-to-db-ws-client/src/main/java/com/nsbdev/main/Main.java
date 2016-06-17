package com.nsbdev.main;


import javax.xml.bind.JAXBException;

import com.nsbdev.service.ClientLogic;


public class Main {

	
	public static void main(String[] args) throws JAXBException {

		ClientLogic.makeSoapRequest();

	}

}
