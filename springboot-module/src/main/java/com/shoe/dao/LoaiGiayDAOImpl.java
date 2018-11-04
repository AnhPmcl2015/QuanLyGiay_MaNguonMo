package com.shoe.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.shoe.entities.LoaiGiay;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.hibernate.Criteria;
import org.hibernate.Session;

@Repository
@Transactional
public class LoaiGiayDAOImpl implements LoaiGiayDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
	public List<LoaiGiay> getList(){
        Session session = sessionFactory.getCurrentSession();	
        Criteria crit = session.createCriteria(LoaiGiay.class);
        List<LoaiGiay> results = (List<LoaiGiay>)crit.list();   
        return results;
    }
}
