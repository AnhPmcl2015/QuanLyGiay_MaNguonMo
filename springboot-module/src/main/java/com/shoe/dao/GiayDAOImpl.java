package com.shoe.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

import com.shoe.dto.ShoeImage;
import com.shoe.entities.Giay_;
import com.shoe.form.GiayForm;
import com.shoe.jpa.JpaGiay;
import com.shoe.converter.ShoeConverter;
import com.shoe.dto.ShoeDTO;
import com.shoe.entities.Giay;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GiayDAOImpl implements GiayDAO {

    @Autowired
    private ShoeConverter converter;

    @Autowired
    private JpaGiay jpa;

    @Autowired
    private EntityManager em;

    @Override
    public void saveShoe(ShoeDTO giayDto) {
        Giay giay = new Giay();
        converter.convertDtoToEntity(giayDto, giay);
        giay.setXoaFlag(false);
        jpa.save(giay);
    }

    public ShoeDTO getGiayById(Integer id) {
        Optional<Giay> giay = jpa.findById(id);
        if (giay.isPresent()) {
            ShoeDTO dto = new ShoeDTO();
            converter.convertEntityToDto(giay.get(),dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean checkUniqueOnEdit(GiayForm giay) {
        if(GenericValidator.isInt(giay.getId())){
            Integer id = Integer.parseInt(giay.getId());
            Optional<Giay> entity = jpa.findById(id);
            if(entity.isPresent()){
                Giay e = entity.get();
                return e.getMaGiay().equals(giay.getMaGiay());
            }
        }

        return false;
    }

    @Override
    public ShoeImage getImageById(Integer id) {
        ShoeImage img = new ShoeImage();
        Optional<Giay> giayOpt = jpa.findById(id);
        if(giayOpt.isPresent()){
            Giay giay = giayOpt.get();
            img.setId(giay.getIdGiay()+"");
            img.setImg1(giay.getImg1());
            img.setImg2(giay.getImg2());
            img.setImg3(giay.getImg3());
            img.setImg4(giay.getImg4());
        }
        return img;
    }


    @Override
    public List<ShoeDTO> getAllListNoneDel() {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Giay> query = builder.createQuery(Giay.class);
        Root<Giay> from = query.from(Giay.class);

        query.select(from).where(builder.isFalse(from.get(Giay_.xoaFlag)));
        TypedQuery<Giay> typedQuery = em.createQuery(query);
        System.out.println(typedQuery.getResultList().size());
        List<ShoeDTO> list = new ArrayList<>();
        typedQuery.getResultList().forEach(i -> {
            ShoeDTO dto = new ShoeDTO();
            converter.convertEntityToDto(i, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public boolean deleteShoe(ShoeDTO giayDto) {
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
