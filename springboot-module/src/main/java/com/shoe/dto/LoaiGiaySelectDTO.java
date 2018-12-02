package com.shoe.dto;

import com.shoe.entities.HangSanXuat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGiaySelectDTO {

    private Integer idLoaiGiay;
    private String tenLoaiGiay;
}
