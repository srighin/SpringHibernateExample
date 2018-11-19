package com.journaldev.dao;

import java.util.List;

import com.journaldev.model.Exceptions;


public interface ExceptionsDao {

	public void save(Exceptions p);
	
	public List<Exceptions> list();
	
}
