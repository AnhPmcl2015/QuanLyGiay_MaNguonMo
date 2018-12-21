package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGiaySelectDTO {

    private Integer idLoaiGiay;
    private String tenLoaiGiay;
}
