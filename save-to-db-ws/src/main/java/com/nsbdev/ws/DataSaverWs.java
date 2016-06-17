package com.nsbdev.ws;

import javax.jws.WebService;

import com.nsbdev.beans.TransferMessage;

@WebService
public interface DataSaverWs {

	public String saveToDB(TransferMessage transferMessage);
}
