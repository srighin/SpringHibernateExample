package com.journaldev;


import com.journaldev.model.ExamResult;
import org.springframework.batch.item.ItemProcessor;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	

	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :"+result);


		/*
		 * Only return results which are more than 80%
		 * 
		 */
		/*if(result.getPercentage() < 80){
			return null;
		}*/
		result.setPercentage(100);
		return result;
	}

}
