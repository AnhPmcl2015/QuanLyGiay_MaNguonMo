package com.shoe.form;

import com.shoe.validator.ServiceValidator;
import com.shoe.validator.Unique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayForm {

    private String id;
    @NotEmpty
    @Unique(fieldName = "maGiay",tableName = "Giay", service = ServiceValidator.class)
    private String maGiay;
    @NotEmpty
    private String tenGiay;
    private String id_gioi_tinh;
    @NotEmpty
    private String id_loai_giay;
    private String ghiChu;
    private String giaBan;
}