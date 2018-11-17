package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.shoe.com.shoe.jpa.JpaGioiTinh;
import com.shoe.com.shoe.jpa.JpaLoaiGiay;
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
    private JpaGioiTinh jpa;

    @Autowired
    private EntityManager em;

    @Override
	public List<GioiTinhDTO> getList(){

        List<GioiTinh> listGender = jpa.findAll();
        List<GioiTinhDTO> listGenderDto = new ArrayList<>();
        listGender.forEach(i->{
            GioiTinhDTO dto = new GioiTinhDTO(i.getIdGioiTinh(),i.getTenGioiTinh());
            listGenderDto.add(dto);
        });
        return listGenderDto;
    }
}
