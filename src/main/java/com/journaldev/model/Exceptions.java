package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="EXCEPTION_INST")
public class Exceptions {

	@Id
	@Column(name="EXC_INST")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int excInst;

	@Column(name="EXC_CATEGORY")
	private String excCategory;


	@Column(name="EXC_DESC")
	private String excDesc;

	public int getExcInst() {
		return excInst;
	}

	public void setExcInst(int excInst) {
		this.excInst = excInst;
	}

	public String getExcCategory() {
		return excCategory;
	}

	public void setExcCategory(String excCategory) {
		this.excCategory = excCategory;
	}

	public String getExcDesc() {
		return excDesc;
	}

	public void setExcDesc(String excDesc) {
		this.excDesc = excDesc;
	}
	
	@Override
	public String toString(){
		return "excInst="+ excInst +", excCategory="+ excCategory +", excDesc="+ excDesc;
	}
}
