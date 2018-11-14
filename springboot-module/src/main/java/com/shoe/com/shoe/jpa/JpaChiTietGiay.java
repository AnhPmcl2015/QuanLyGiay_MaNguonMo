package com.shoe.com.shoe.jpa;

import com.shoe.entities.ChiTietGiay;
import com.shoe.entities.Giay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaChiTietGiay extends JpaRepository<ChiTietGiay, Integer> {

}
