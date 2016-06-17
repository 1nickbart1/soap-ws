package com.nsbdev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	private static final HibernateSession instance = new HibernateSession();

	private SessionFactory sessionFactory;

	private HibernateSession() {
		sessionFactory = createSessionFactory();
	}

	private SessionFactory createSessionFactory() {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		return sessionFactory;
	}

	public static HibernateSession getInstance() {
		return instance;
	}

	public Session openCurrSessionWithComm() {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrSessionWithComm(Session session) {
		session.getTransaction().commit();
		session.close();
	}
}
