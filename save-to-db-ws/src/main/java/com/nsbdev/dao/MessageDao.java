package com.nsbdev.dao;

import com.nsbdev.entity.Message;

public interface MessageDao {

	public void saveMessage(Message message);
	
	public Message selectMessage(Long id);
	
	public void updateMessage(Message message);
	
	public void deleteMessage(Long id);
	
	
	
}
