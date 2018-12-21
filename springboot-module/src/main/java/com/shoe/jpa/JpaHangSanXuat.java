package com.shoe.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.HangSanXuat;

@Repository
public interface JpaHangSanXuat extends JpaRepository<HangSanXuat, Integer> {
}
