package com.nsbdev.service;

import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import com.nsbdev.beans.BLRAPN;
import com.nsbdev.beans.TransferMessage;
import com.nsbdev.properties.Property;
import com.nsbdev.service.exception.ServiceException;
import com.nsbdev.thread.SoapRequestThread;
import com.nsbdev.utils.JaxbUtils;
import com.nsbdev.utils.PathUtils;

public class ClientLogic {

	public ClientLogic() {

	}

	private static BLRAPN unMarshallXml() {
		Path pathToFile = Property.getPropery().getRealPathToFile();
		BLRAPN blrApn = new BLRAPN();

		try {
			blrApn = JaxbUtils.unMarshall(pathToFile, blrApn);
		} catch (JAXBException e) {
			throw new ServiceException("error in unmarshalling data", e);
		}

		return blrApn;
	}

	private static String getSignInString(BLRAPN blrApn) {
		SignatureCreator signCreator = new SignatureCreator(blrApn.toString());
		String sign = signCreator.getStringRealSig();

		return sign;

	}

	private static TransferMessage makeTransferMessage() {
		Path pathToFile = Property.getPropery().getRealPathToFile();
		String fileName = PathUtils.getFileNameFromPath(pathToFile);
		BLRAPN blrApn = unMarshallXml();
		String sign = getSignInString(blrApn);

		TransferMessage message = new TransferMessage(fileName, blrApn, sign);

		return message;

	}

	public static void makeSoapRequest() {
		if (!WsAnalyzer.isStart()) {
			System.out.println("Service stopped");
			return;
		}

		TransferMessage message = makeTransferMessage();

		SoapRequestThread soapThread = new SoapRequestThread(message);
		new Thread(soapThread).start();		
		String response = getResponse(soapThread);
		System.out.println(response);

	}

	private static String getResponse(SoapRequestThread soapThread) {
		String response = soapThread.getResponse();
		while (response == null) {
			System.out.println("processing");
			response = soapThread.getResponse();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new ServiceException("error in waiting", e);
			}
		}
		
		return response;
	}

}
