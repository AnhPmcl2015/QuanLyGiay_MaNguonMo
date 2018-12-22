package com.shoe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangPwdForm {

    private String id;
    @NotEmpty
    private String oldPwd;
    @NotEmpty
    private String newPwd;
}
