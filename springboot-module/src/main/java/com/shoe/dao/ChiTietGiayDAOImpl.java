package com.shoe.dao;

import com.shoe.jpa.JpaChiTietGiay;
import com.shoe.converter.ChiTietGiayConverter;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.entities.ChiTietGiay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ChiTietGiayDAOImpl implements ChiTietGiayDAO {

    @Autowired
    private ChiTietGiayConverter converter;

    @Autowired
    private JpaChiTietGiay jpa;

    @Autowired
    private EntityManager em;

    @Override
    public List<ChiTietGiayDTO> getAllListNoneDel() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ChiTietGiay> query = builder.createQuery(ChiTietGiay.class);
        Root<ChiTietGiay> from = query.from(ChiTietGiay.class);
        query.select(from).where(builder.isNull(from.get("deleteYmd")));
        TypedQuery<ChiTietGiay> typedQuery = em.createQuery(query);
        List<ChiTietGiayDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i -> {
            ChiTietGiayDTO dto = new ChiTietGiayDTO();
            converter.convertEntityToDto(i, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public void addDetailShoe(ChiTietGiayDTO giayDTO) {
        ChiTietGiay chiTietGiay = new ChiTietGiay();
        converter.convertDtoToEntity(giayDTO, chiTietGiay);
        jpa.save(chiTietGiay);
    }

    @Override
    public void updateDetailShoe(ChiTietGiayDTO giayDTO) {
        ChiTietGiay chiTietGiay = new ChiTietGiay();
        converter.convertDtoToEntity(giayDTO, chiTietGiay);
        jpa.save(chiTietGiay);
    }

    @Override
    public void deleteDetailShoe(ChiTietGiayDTO giayDTO) {

        Optional<ChiTietGiay> chiTietGiay = jpa.findById(giayDTO.getIdChiTietGiay());
        if (chiTietGiay.isPresent()) {
            ChiTietGiay ctgiay = chiTietGiay.get();
            ctgiay.setXoaFlag(true);
            jpa.save(ctgiay);
        }
    }
}
