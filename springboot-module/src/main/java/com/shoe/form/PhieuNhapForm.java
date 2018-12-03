package com.shoe.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhapForm {

	@DateTimeFormat(pattern="yyyy-MM-dd")	
	@NotNull 
	private Date ngayNhap;
	
	@Min(0)
	private int idHangSanXuat;
}