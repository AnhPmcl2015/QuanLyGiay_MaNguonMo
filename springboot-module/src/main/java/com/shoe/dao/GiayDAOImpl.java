package com.shoe.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

import com.shoe.entities.Giay_;
import com.shoe.jpa.JpaGiay;
import com.shoe.converter.GiayConverter;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GiayDAOImpl implements GiayDAO {

    @Autowired
    private GiayConverter converter;

    @Autowired
    private JpaGiay jpa;

    @Autowired
    private EntityManager em;

    @Override
    public void saveShoe(GiayDTO giayDto) {
        Giay giay = new Giay();
        converter.convertDtoToEntity(giayDto, giay);
        giay.setXoaFlag(false);
        jpa.save(giay);
    }

    public GiayDTO getGiayById(Integer id) {
        Optional<Giay> giay = jpa.findById(id);
        if (giay.isPresent()) {
            GiayDTO dto = new GiayDTO();
            converter.convertEntityToDto(giay.get(),dto);
            return dto;
        }
        return null;
    }

    @Override
    public List<GiayDTO> getAllListNoneDel() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Giay> query = builder.createQuery(Giay.class);
        Root<Giay> from = query.from(Giay.class);

        query.select(from).where(builder.isFalse(from.get(Giay_.xoaFlag)));
        TypedQuery<Giay> typedQuery = em.createQuery(query);
        System.out.println(typedQuery.getResultList().size());
        List<GiayDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i -> {
            GiayDTO dto = new GiayDTO();
            converter.convertEntityToDto(i, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public boolean deleteShoe(GiayDTO giayDto) {
        Optional<Giay> giay = jpa.findById(giayDto.getIdGiay());
        if (giay.isPresent()) {
            Giay entity = giay.get();
            entity.setXoaFlag(true);
            jpa.save(entity);
            return true;
        }
        return false;
    }
}
