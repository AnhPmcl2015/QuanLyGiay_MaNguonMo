package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoanhThuHangSanXuatDTO {
    private String tenHangSanXuat;
    private Long doanhThu;
}
