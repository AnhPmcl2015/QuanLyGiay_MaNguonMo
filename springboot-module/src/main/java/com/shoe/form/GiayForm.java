package com.shoe.form;

import org.hibernate.validator.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayForm {
    @NotEmpty
    private String maGiay;
    @NotEmpty
    private String tenGiay;
    private String id_gioi_tinh;
    @NotEmpty
    private String id_loai_giay;
    private String ghiChu;
    private String giaBan;
    @NotEmpty
    private String img1;
    private String img2;
    private String img3;
    private String img4;
}