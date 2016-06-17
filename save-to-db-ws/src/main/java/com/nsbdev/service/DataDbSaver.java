package com.nsbdev.service;

import com.nsbdev.beans.BLRAPN;
import com.nsbdev.dao.MessageDao;
import com.nsbdev.dao.MessageDaoImpl;
import com.nsbdev.entity.Message;
import com.nsbdev.utils.StringUtils;

public class DataDbSaver {
	private byte[] originalData;
	private byte[] encodingData;	
	private byte[] key;
	private String messageId;


	public DataDbSaver(BLRAPN blrApn, String key)  {
		String blrApnInString = blrApn.toString();
		
		this.originalData = blrApnInString.getBytes();
		this.encodingData =StringUtils.getBytesInCP866(blrApnInString);
		this.key = StringUtils.convertStringToByteMas(key);
		this.messageId = blrApn.getMessageHeader().getMessageID();
	}
	
	public void saveToDb(){
		
		Message message=new Message(messageId,originalData, key, encodingData);
		MessageDao dao = new MessageDaoImpl();
	    dao.saveMessage(message);
	    
	
	}

}
