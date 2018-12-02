package com.shoe.validator;

import com.shoe.entities.Giay;
import com.shoe.jpa.JpaGiay;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class ServiceValidator {
    @Autowired
    EntityManager em;


    public boolean isUnique(Object value, String fieldName, String tableName) {

        try {
            Object ob =
                    em.createQuery("select c from " + tableName + " c" + " where c." + fieldName + "='" + value.toString() + "'")
                            .getSingleResult();
            return false;
        } catch (NoResultException ex) {

        }

        return true;
    }
}
