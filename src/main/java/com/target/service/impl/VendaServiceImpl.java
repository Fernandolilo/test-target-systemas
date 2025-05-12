package com.target.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.target.entity.Venda;
import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaNewDTO;
import com.target.repositories.VendaRepository;
import com.target.service.VendaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VendaServiceImpl implements VendaService {

	private final VendaRepository repository;
	private final ModelMapper mapper;

	@Override
	public VendaDTO save(VendaNewDTO dto) {
		Venda venda = mapper.map(dto, Venda.class);
		venda = repository.save(venda);
		return mapper.map(venda, VendaDTO.class);
	}

	@Override
	public List<VendaDTO> vendas() {
		List<Venda> vendas = repository.findAll();
		
		// ordena por dia comparator.comparin ordena por dia,
		List<VendaDTO> vendasDTO = vendas.stream()
				.sorted(Comparator.comparing(Venda::getDia)) 
																								// crescente
				.map(venda -> mapper.map(venda, VendaDTO.class)).collect(Collectors.toList());
		return vendasDTO;
	}
}
