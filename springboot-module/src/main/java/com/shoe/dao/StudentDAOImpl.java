package com.shoe.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoe.dto.StudentDTO;

@Service
@Transactional
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<StudentDTO> getRecordsPerPage(int start, int total) {
		return null;
	}

	@Override
	public int tongsodong() {
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StudentDTO> getListStudent() {
		Session session = sessionFactory.getCurrentSession();		
		List<StudentDTO> list = (List<StudentDTO>) session.createQuery("from StudentDTO").list();
		return list;
	}

	@Override
	public int addStudent(StudentDTO student) {

		return 0;
	}

	@Override
	public int deleteStudent(StudentDTO student) {

		return 0;
	}

	@Override
	public int editStudent(StudentDTO student) {

		return 0;
	}

}
