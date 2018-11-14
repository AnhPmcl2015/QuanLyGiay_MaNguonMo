package com.shoe.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;
import com.shoe.converter.GiayConverter;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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

    @Autowired
    private GiayConverter converter;

    @Override
    public void addShoe(GiayDTO giayDto) {
        Session session = sessionFactory.getCurrentSession();
        Giay giay = new Giay();
        converter.convertDtoToEntity(giayDto, giay);
        session.save(giay);
    }

    @Override
    public boolean FindByAtribute(String key, String value) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Giay.class);
        return crit.add(Restrictions.eq(key, value)).setProjection(Projections.property(key)).uniqueResult() != null;
    }

    @Override
    public List<GiayDTO> getAllListNoneDel() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Giay.class);
        crit.add(Restrictions.isNull("deleteYmd"));
        List<Giay> list_giay = (List<Giay>) crit.list();
        List<GiayDTO> list_giayDto = new ArrayList<>();
        list_giay.forEach(i -> {
            GiayDTO dto = new GiayDTO();
            converter.convertEntityToDto(i, dto);
            list_giayDto.add(dto);
        });
        return list_giayDto;
    }

    @Override
    public boolean deleteShoe(GiayDTO giay) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Giay.class);
        Giay entity = (Giay) session.get(Giay.class, giay.getIdGiay());
        if(entity != null){
            entity.setDeleteYmd(Calendar.getInstance().getTime());
            session.update(entity);
            return true;
        }
        return false;
    }
}
