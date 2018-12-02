package com.shoe.dto;

import com.shoe.entities.LoaiGiay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HangSanXuatSelectDTO {

    private String tenHangSanXuat;
    private List<LoaiGiaySelectDTO> loaiGiays;
}
