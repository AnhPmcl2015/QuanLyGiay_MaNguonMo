package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.shoe.com.shoe.jpa.JpaLoaiGiay;
import com.shoe.dto.LoaiGiayDTO;
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
public class LoaiGiayDAOImpl implements LoaiGiayDAO {

    @Autowired
    private JpaLoaiGiay jpa;

    @Autowired
    private EntityManager em;

    @Override
    public List<LoaiGiayDTO> getList() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<LoaiGiay> query = builder.createQuery(LoaiGiay.class);
        Root<LoaiGiay> from = query.from(LoaiGiay.class);
        query.select(from);
        TypedQuery<LoaiGiay> typedQuery = em.createQuery(query);
        List<LoaiGiayDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i -> {
            LoaiGiayDTO dto = new LoaiGiayDTO(i.getIdLoaiGiay(), i.getHangSanXuat(), i.getMaLoaiGiay(), i.getTenLoaiGiay());
            list.add(dto);
        });
        return list;
    }
}
