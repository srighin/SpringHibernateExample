package com.journaldev.service;

import com.journaldev.dao.IExamDao;
import com.journaldev.model.ExamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamResultService implements IExamResultService{

    @Autowired
    IExamDao examDao;

    public void addExamResult (ExamResult examResult){
        getExamDao().addExamResult(examResult);
    }
    /**
     * Gets User List
     *
     */
    public List<ExamResult> getExamResult(){
        return getExamDao().getExamResult();
    }

    public IExamDao getExamDao() {
        return examDao;
    }

    public void setExamDao(IExamDao examDao) {
        this.examDao = examDao;
    }
}
