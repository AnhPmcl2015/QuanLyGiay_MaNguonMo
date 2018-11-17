package com.shoe.com.shoe.jpa;

import com.shoe.entities.HangSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHangSanXuat extends JpaRepository<HangSanXuat, Integer> {
}
