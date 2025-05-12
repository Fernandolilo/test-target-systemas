package com.target.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaNewDTO;
import com.target.service.VendaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {

	private final VendaService service;
	
	@PostMapping
	public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaNewDTO dto) {
		VendaDTO result = service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@GetMapping
	public List<VendaDTO> findAll (){
		return service.vendas();
		
	}

}
