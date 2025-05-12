package com.target.service;

import java.util.List;

import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaDTOWrapper;
import com.target.entity.dto.VendaNewDTO;

public interface VendaService {
	VendaDTO save(VendaNewDTO dto);

	List<VendaDTOWrapper> vendas();
}
