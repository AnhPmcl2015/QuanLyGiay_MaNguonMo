package com.shoe.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeverResponse{
	private Boolean isSuccess;
    private String messsage;
}