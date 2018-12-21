package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayTableDTO {
    private int idGiay;
    private String tenGiay;
    private String maGiay;
    private String tenGioiTinh;
    private String tenLoaiGiay;
    private String tenHangSanXuat;
    private String giaban;
}
