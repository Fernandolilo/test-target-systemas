package com.target.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.target.entity.Venda;
import com.target.repositories.VendaRepository;
import com.target.service.StartDB;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StarDBImpl implements StartDB {

	private final VendaRepository repository;

	@Override
	public void initDB() {

		List<Venda> pedidos = Arrays.asList(Venda.builder().dia(1).valor(22174.1664).build(),
				Venda.builder().dia(2).valor(24537.6698).build(), Venda.builder().dia(3).valor(26139.6134).build(),
				Venda.builder().dia(4).valor(0.0).build(), Venda.builder().dia(5).valor(0.0).build(),
				Venda.builder().dia(6).valor(26742.6612).build(), Venda.builder().dia(7).valor(0.0).build(),
				Venda.builder().dia(8).valor(42889.2258).build(), Venda.builder().dia(9).valor(46251.174).build(),
				Venda.builder().dia(10).valor(11191.4722).build(), Venda.builder().dia(11).valor(0.0).build(),
				Venda.builder().dia(12).valor(0.0).build(), Venda.builder().dia(13).valor(3847.4823).build(),
				Venda.builder().dia(14).valor(373.7838).build(), Venda.builder().dia(15).valor(2659.7563).build(),
				Venda.builder().dia(16).valor(48924.2448).build(), Venda.builder().dia(17).valor(18419.2614).build(),
				Venda.builder().dia(18).valor(0.0).build(), Venda.builder().dia(19).valor(0.0).build(),
				Venda.builder().dia(20).valor(35240.1826).build(), Venda.builder().dia(21).valor(43829.1667).build(),
				Venda.builder().dia(22).valor(18235.6852).build(), Venda.builder().dia(23).valor(4355.0662).build(),
				Venda.builder().dia(24).valor(13327.1025).build(), Venda.builder().dia(25).valor(0.0).build(),
				Venda.builder().dia(26).valor(0.0).build(), Venda.builder().dia(27).valor(25681.8318).build(),
				Venda.builder().dia(28).valor(1718.1221).build(), Venda.builder().dia(29).valor(13220.495).build(),
				Venda.builder().dia(30).valor(8414.61).build());

		repository.saveAll(pedidos);
		Venda ped = Venda.builder().dia(31).valor(8414.61).build();
		repository.save(ped);
	} 
	
}
