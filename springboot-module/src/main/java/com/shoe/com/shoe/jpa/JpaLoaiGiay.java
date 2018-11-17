package com.shoe.com.shoe.jpa;

import com.shoe.entities.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLoaiGiay extends JpaRepository<LoaiGiay, Integer> {

}
