package com.shoe.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

import com.shoe.com.shoe.jpa.JpaGiay;
import com.shoe.converter.GiayConverter;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.Session;

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
    public void addShoe(GiayDTO giayDto) {
        Giay giay = new Giay();
        converter.convertDtoToEntity(giayDto,giay);
        jpa.save(giay);
    }

    @Override
    public boolean FindByAtribute(String key, String value) {
        return false;
    }

    @Override
    public List<GiayDTO> getAllListNoneDel() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Giay> query = builder.createQuery(Giay.class);
        Root<Giay> from = query.from(Giay.class);

        query.select(from).where(builder.isNull(from.get("deleteYmd")));
        TypedQuery<Giay> typedQuery = em.createQuery(query);

        List<GiayDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i->{
            GiayDTO dto = new GiayDTO();
            converter.convertEntityToDto(i,dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public boolean deleteShoe(GiayDTO giayDto) {
        Optional<Giay> giay = jpa.findById(giayDto.getIdGiay());
        if(giay.isPresent()){
            Giay entity = giay.get();
            entity.setDeleteYmd(Calendar.getInstance().getTime());
            jpa.save(entity);
            return true;
        }
        return false;
    }
}
