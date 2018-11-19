package com.journaldev.dao;

import com.journaldev.model.ExamResult;

import java.util.List;

public interface IExamDao {

    void addExamResult(ExamResult user);
    /**
     * Gets User List
     *
     */
    List<ExamResult> getExamResult();
}
