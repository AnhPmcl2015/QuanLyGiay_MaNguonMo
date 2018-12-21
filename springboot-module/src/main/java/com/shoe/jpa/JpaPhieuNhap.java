package com.shoe.jpa;

import com.shoe.entities.PhieuNhap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPhieuNhap extends JpaRepository<PhieuNhap, Integer> {

}
