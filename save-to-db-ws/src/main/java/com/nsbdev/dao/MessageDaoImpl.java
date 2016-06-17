package com.nsbdev.dao;


import org.hibernate.Session;

import com.nsbdev.entity.Message;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void saveMessage(Message message) {
		 Session session =  HibernateSession.getInstance().openCurrSessionWithComm();
		 session.save(message);
		 HibernateSession.getInstance().closeCurrSessionWithComm(session);

	}

	@Override
	public Message selectMessage(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateMessage(Message message) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void deleteMessage(Long id) {
		throw new UnsupportedOperationException();

	}

}
