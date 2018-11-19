package com.journaldev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.model.Exceptions;

public class ExceptionsDaoImpl implements ExceptionsDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void save(Exceptions p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Exceptions> list() {
		Session session = this.sessionFactory.openSession();
		List<Exceptions> exceptionsList = session.createQuery("from Exceptions").list();
		session.close();
		return exceptionsList;
	}

}
