package com.shoe.jpa;

import com.shoe.entities.Giay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGiay extends JpaRepository<Giay, Integer> {

}
