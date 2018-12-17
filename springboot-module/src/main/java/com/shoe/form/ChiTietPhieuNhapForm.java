package com.shoe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhapForm {
	private int key;
	private String shoeName;
	private int amount;
	private String price;
	private int total;
}