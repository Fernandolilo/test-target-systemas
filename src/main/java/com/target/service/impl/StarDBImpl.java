package com.target.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.target.entity.Pedido;
import com.target.repositories.PedidoRepository;
import com.target.service.StartDB;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StarDBImpl implements StartDB{

	private final PedidoRepository repository;
	
	@Override
	public void initDB() {
		
		  List<Pedido> pedidos = Arrays.asList(
		            Pedido.builder().dia(1).valor(22174.1664).build(),
		            Pedido.builder().dia(2).valor(24537.6698).build(),
		            Pedido.builder().dia(3).valor(26139.6134).build(),
		            Pedido.builder().dia(4).valor(0.0).build(),
		            Pedido.builder().dia(5).valor(0.0).build(),
		            Pedido.builder().dia(6).valor(26742.6612).build(),
		            Pedido.builder().dia(7).valor(0.0).build(),
		            Pedido.builder().dia(8).valor(42889.2258).build(),
		            Pedido.builder().dia(9).valor(46251.174).build(),
		            Pedido.builder().dia(10).valor(11191.4722).build(),
		            Pedido.builder().dia(11).valor(0.0).build(),
		            Pedido.builder().dia(12).valor(0.0).build(),
		            Pedido.builder().dia(13).valor(3847.4823).build(),
		            Pedido.builder().dia(14).valor(373.7838).build(),
		            Pedido.builder().dia(15).valor(2659.7563).build(),
		            Pedido.builder().dia(16).valor(48924.2448).build(),
		            Pedido.builder().dia(17).valor(18419.2614).build(),
		            Pedido.builder().dia(18).valor(0.0).build(),
		            Pedido.builder().dia(19).valor(0.0).build(),
		            Pedido.builder().dia(20).valor(35240.1826).build(),
		            Pedido.builder().dia(21).valor(43829.1667).build(),
		            Pedido.builder().dia(22).valor(18235.6852).build(),
		            Pedido.builder().dia(23).valor(4355.0662).build(),
		            Pedido.builder().dia(24).valor(13327.1025).build(),
		            Pedido.builder().dia(25).valor(0.0).build(),
		            Pedido.builder().dia(26).valor(0.0).build(),
		            Pedido.builder().dia(27).valor(25681.8318).build(),
		            Pedido.builder().dia(28).valor(1718.1221).build(),
		            Pedido.builder().dia(29).valor(13220.495).build(),
		            Pedido.builder().dia(30).valor(8414.61).build()
		        );

		        repository.saveAll(pedidos);
		
	}

}
