package com.journaldev.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EXAM_RESULT")
public class ExamResult implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "student_name")
	private String studentName;
	private Date dob;
	private double percentage;

	private String usg;


	public String getUsg() {
		return usg;
	}

	public void setUsg(String usg) {
		this.usg = usg;
	}

	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExamResult{" +
				"id=" + id +
				", studentName='" + studentName + '\'' +
				", dob=" + dob +
				", percentage=" + percentage +
				", usg='" + usg + '\'' +
				'}';
	}
}
