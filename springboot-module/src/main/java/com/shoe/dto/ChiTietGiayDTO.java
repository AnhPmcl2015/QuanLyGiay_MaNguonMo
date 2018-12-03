package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietGiayDTO {
    private int idChiTietGiay;
    private GiayDTO giay;
    private int size;
    private int soLuong;
}
