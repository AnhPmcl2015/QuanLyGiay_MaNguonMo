package com.shoe.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.ChiTietGiay;

@Repository
public interface JpaChiTietGiay extends JpaRepository<ChiTietGiay, Integer> {

}
