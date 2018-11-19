package com.journaldev.service;

import com.journaldev.model.ExamResult;

import java.util.List;

public interface IExamResultService {

    void addExamResult(ExamResult user);
    /**
     * Gets User List
     *
     */
    List<ExamResult> getExamResult();
}
