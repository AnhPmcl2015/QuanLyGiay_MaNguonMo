package com.shoe.dao;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import com.shoe.entities.Giay;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.Session;

@Repository
@Transactional
public class GiayDAOImpl implements GiayDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Giay> getList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Giay.class);
        List<Giay> results = (List<Giay>) crit.list();
        return results;
    }

    @Override
    public int addShoe(Giay giay){
        int status;
        try{
            Session session = sessionFactory.getCurrentSession();
            session.save(giay);
            status = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            status = 2;
        }
        return status;
    }
}
