package com.target.entity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer dia;
    private Double valor;

}


