package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HangSanXuatSelectDTO {

    private String tenHangSanXuat;
    private List<LoaiGiaySelectDTO> loaiGiays;
}
