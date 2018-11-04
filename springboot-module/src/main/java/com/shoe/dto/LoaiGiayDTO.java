package com.shoe.dto;

import java.util.List;

import com.shoe.entities.HangSanXuat;
import com.shoe.entities.LoaiGiay;

import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGiayDTO {
	private Integer idLoaiGiay;
    private HangSanXuat hangSanXuat;
    private String maLoaiGiay;
    private String tenLoaiGiay;
}
