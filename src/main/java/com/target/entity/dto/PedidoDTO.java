package com.target.entity.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int dia;
	private double valor;

}
