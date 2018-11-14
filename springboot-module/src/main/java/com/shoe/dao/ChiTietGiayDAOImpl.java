package com.shoe.dao;

import com.shoe.com.shoe.jpa.JpaChiTietGiay;
import com.shoe.converter.ChiTietGiayConverter;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.entities.ChiTietGiay;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ChiTietGiayDAOImpl implements ChiTietGiayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ChiTietGiayConverter converter;
    

    @Override
    public List<ChiTietGiayDTO> getAllListNoneDel() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(ChiTietGiay.class);
        List<ChiTietGiay> list_entity = crit.add(Restrictions.isNull("deleteYmd")).list();
        List<ChiTietGiayDTO> list_dto = new ArrayList<>();
        list_entity.forEach(i -> {
            ChiTietGiayDTO dto = new ChiTietGiayDTO();
            converter.convertEntityToDto(i, dto);
            list_dto.add(dto);
        });
        jpaChiTietGiay.findAll();
        return list_dto;
    }
}
