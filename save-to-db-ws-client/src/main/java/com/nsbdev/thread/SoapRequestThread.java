package com.nsbdev.thread;

import com.nsbdev.beans.TransferMessage;
import com.nsbdev.ws.DataSaverWs;
import com.nsbdev.ws.DataSaverWsImplService;

public class SoapRequestThread implements Runnable{
	private TransferMessage message;
	private String response;
	
	public SoapRequestThread(TransferMessage message) {
		super();
		this.message = message;
		response = null;
	}
	
    public String getResponse(){
    	return response;
    }
	
	
	@Override
	public void run() {
		DataSaverWsImplService dataSaverService = new DataSaverWsImplService();
		DataSaverWs dataSaverWs = dataSaverService.getDataSaverWsImplPort();
		response = dataSaverWs.saveToDB(message);
		
	}
	
	
	

}
