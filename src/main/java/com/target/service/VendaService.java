package com.target.service;

import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaNewDTO;

public interface VendaService {
    VendaDTO save(VendaNewDTO dto);
}
