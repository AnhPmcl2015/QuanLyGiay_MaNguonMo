package com.shoe.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhapForm {

	private String dateOfReciept;
	
	@NotNull
	private int brandId;
	
	@Min(1) 
	private int amount;
	
	@NotEmpty
	private List<ChiTietPhieuNhapForm> recieptDetails;
	
}