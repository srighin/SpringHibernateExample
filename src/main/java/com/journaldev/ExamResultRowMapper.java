package com.journaldev;

import com.journaldev.model.ExamResult;
import org.joda.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamResultRowMapper implements RowMapper<ExamResult> {


	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {

		ExamResult result = new ExamResult();
		result.setId(rs.getInt("ID"));
		result.setStudentName(rs.getString("student_name"));
		LocalDate dob = new LocalDate(rs.getDate("dob"));
		result.setDob(dob.toDate());
		result.setPercentage(rs.getDouble("percentage"));

		System.out.println("development 2s");


		return result;
	} 

}
