package com.nsbdev.ws;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.jws.WebService;

import com.nsbdev.beans.BLRAPN;
import com.nsbdev.beans.TransferMessage;
import com.nsbdev.service.DataDbSaver;
import com.nsbdev.service.SignatureValidator;
import com.nsbdev.thread.DataDbSaverThread;

@WebService(endpointInterface = "com.nsbdev.ws.DataSaverWs")
public class DataSaverWsImpl implements DataSaverWs {

	@Override
	public String saveToDB(TransferMessage transferMessage) {
		boolean resultOfValidation;
		StringBuilder response = new StringBuilder();
		try {

			BLRAPN blrApn =  transferMessage.getFileInfo();
			String textForSaving = blrApn.toString();
			String key = transferMessage.getKey();
			SignatureValidator signValid = new SignatureValidator(textForSaving, key);
			signValid.validateText();
			resultOfValidation = signValid.getResultOfValidation();
			
			if(!resultOfValidation){
				response.append("invalid signature");
				
				return response.toString();
			}			
			
			response.append("ok");
			DataDbSaverThread dbSaverThread = new DataDbSaverThread(blrApn,key);
			new Thread(dbSaverThread).start();			
		
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			response.append(errors.toString());
		}

		return response.toString();

	}

}
