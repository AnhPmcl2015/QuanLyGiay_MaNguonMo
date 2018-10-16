package com.shoe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoe.dto.SubjectDTO;
@Service
@Transactional
public class SubjectDAOImpl implements SubjectDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectDTO> getListSubject() {
		Session session = sessionFactory.getCurrentSession();
		List<SubjectDTO> list = (List<SubjectDTO>) session.createQuery("from SubjectDTO").list();
		return list;
	}

}
