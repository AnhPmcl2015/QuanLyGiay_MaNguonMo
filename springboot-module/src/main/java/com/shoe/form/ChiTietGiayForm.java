package com.shoe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietGiayForm {
    @NotEmpty
    private String idChiTietGiay;
    @NotEmpty
    private String size;
    @NotEmpty
    private String soluong;
    @NotEmpty
    private String idGiay;
}
