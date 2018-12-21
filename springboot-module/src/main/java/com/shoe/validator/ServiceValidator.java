package com.shoe.validator;

import com.shoe.entities.Giay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Service
public class ServiceValidator {
    @Autowired
    EntityManager em;


    public boolean isUnique(Object value, String fieldName, String tableName) {

        try {
            Object ob =
                    em.createQuery("select c from " + tableName + " c" + " where c." + fieldName + "='" + value.toString() + "'")
                            .getSingleResult();
            Giay shoe = (Giay) ob;
            return false;
        } catch (NoResultException ex) {

        }

        return true;
    }
}
