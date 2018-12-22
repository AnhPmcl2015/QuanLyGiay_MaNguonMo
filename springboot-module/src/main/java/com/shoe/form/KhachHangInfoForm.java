package com.shoe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangInfoForm {

    @NotEmpty
    private String tenKhachHang;
    @NotEmpty
    private String soDienThoai;
    @NotEmpty
    private String diaChi;
}
