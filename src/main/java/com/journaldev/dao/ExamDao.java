package com.journaldev.dao;

import com.journaldev.model.ExamResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ExamDao implements IExamDao {

    private SessionFactory sessionFactory;


    public void addExamResult(ExamResult result) {

        Session session=getSessionFactory().getCurrentSession();
        Transaction trans=session.beginTransaction();
        session.saveOrUpdate(result);
        trans.commit();
    }

    public List<ExamResult> getExamResult() {


        List<ExamResult> list = getSessionFactory().getCurrentSession().createQuery("from PA.EXAM_RESULT").list();
        return list;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
