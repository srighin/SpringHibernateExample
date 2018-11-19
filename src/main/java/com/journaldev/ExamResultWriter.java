package com.journaldev;

import com.journaldev.model.ExamResult;
import com.journaldev.service.IExamResultService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ExamResultWriter implements ItemWriter<ExamResult> {

    @Autowired
    IExamResultService service;


    public void write(List<? extends ExamResult> items) throws Exception {

        for (ExamResult item :
                items) {
            System.out.println("During write : "+item);
            item.setPercentage(100);
            getService().addExamResult(item);

        }
    }

    public IExamResultService getService() {
        return service;
    }

    public void setService(IExamResultService service) {
        this.service = service;
    }
}
