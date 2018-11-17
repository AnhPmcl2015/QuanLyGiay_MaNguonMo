package com.shoe.jpa;

import com.shoe.entities.ChiTietGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaChiTietGiay extends JpaRepository<ChiTietGiay, Integer> {

}
