package com.shoe.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhapDTO{
    private int idPhieuNhap;
    private Date ngayNhap;
    private int tongSoLuong;
    private int idHangSanXuat;
}