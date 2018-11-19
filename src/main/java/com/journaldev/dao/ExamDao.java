package com.journaldev.dao;

import com.journaldev.model.ExamResult;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamDao implements IExamDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void addExamResult(ExamResult result) {
        getSessionFactory().getCurrentSession().save(result);
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
