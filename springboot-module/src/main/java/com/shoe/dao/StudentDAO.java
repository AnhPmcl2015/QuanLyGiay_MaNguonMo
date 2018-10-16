package com.shoe.dao;

import java.util.List;

import com.shoe.dto.StudentDTO;

public interface StudentDAO {
	public List<StudentDTO> getRecordsPerPage(int start, int total);

	public int tongsodong();

	public List<StudentDTO> getListStudent();

	public int addStudent(StudentDTO student);

	public int deleteStudent(StudentDTO student);

	public int editStudent(StudentDTO student);
}
