package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.shoe.converter.HangSanXuatConverter;
import com.shoe.converter.LoaiGiayConverter;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.entities.HangSanXuat;
import com.shoe.entities.LoaiGiay_;
import com.shoe.jpa.JpaLoaiGiay;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.LoaiGiay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoaiGiayDAOImpl implements LoaiGiayDAO {

    @Autowired
    private JpaLoaiGiay jpa;

    @Autowired
    private EntityManager em;

    @Autowired
    private LoaiGiayConverter converter;

    @Override
    public List<LoaiGiayDTO> getList() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<LoaiGiay> query = builder.createQuery(LoaiGiay.class);
        Root<LoaiGiay> from = query.from(LoaiGiay.class);
        query.select(from).where(builder.isFalse(from.get(LoaiGiay_.xoaFlag)));
        TypedQuery<LoaiGiay> typedQuery = em.createQuery(query);
        List<LoaiGiayDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i -> {
            LoaiGiayDTO dto = new LoaiGiayDTO();
            converter.convertEntityToDto(i, dto);
            list.add(dto);
        });
        return list;
    }

}
