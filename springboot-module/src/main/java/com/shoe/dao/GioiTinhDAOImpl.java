package com.shoe.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.shoe.dto.GioiTinhDTO;
import com.shoe.entities.GioiTinh;
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
public class GioiTinhDAOImpl implements GioiTinhDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
	public List<GioiTinh> getList(){
        Session session = sessionFactory.getCurrentSession();	
        Criteria crit = session.createCriteria(GioiTinh.class);
        List<GioiTinh> results = (List<GioiTinh>)crit.list();   
        return results;
    }
}
