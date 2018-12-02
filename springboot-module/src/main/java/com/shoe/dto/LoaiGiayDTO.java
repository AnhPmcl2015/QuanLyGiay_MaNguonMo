package com.shoe.dto;

import java.util.List;

import com.shoe.entities.HangSanXuat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGiayDTO {
	private Integer idLoaiGiay;
    private HangSanXuatDTO hangSanXuat;
    private String tenLoaiGiay;
}
