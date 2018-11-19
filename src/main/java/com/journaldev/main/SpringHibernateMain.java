package com.journaldev.main;

import java.util.List;

import com.journaldev.dao.ExceptionsDao;
import com.journaldev.model.Exceptions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		ExceptionsDao exceptionsDao = context.getBean(ExceptionsDao.class);
		
		Exceptions exceptions = new Exceptions();
		exceptions.setExcCategory("Connector SVC");
		exceptions.setExcDesc("This is 2nd exception");
		
		exceptionsDao.save(exceptions);
		
		System.out.println("Exceptions::"+ exceptions);
		
		List<Exceptions> list = exceptionsDao.list();
		
		for(Exceptions p : list){
			System.out.println("Exceptions List::"+p);
		}
		
		context.close();
		
	}

}
