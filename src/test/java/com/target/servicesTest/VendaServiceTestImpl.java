package com.target.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.target.entity.Venda;
import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaNewDTO;
import com.target.repositories.VendaRepository;
import com.target.service.impl.VendaServiceImpl;

public class VendaServiceTestImpl {

	@Mock
    private ModelMapper mapper;

    @Mock
    private VendaRepository repository;

    @InjectMocks
    private VendaServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	public void save() {
        VendaNewDTO vendaNewDTO = VendaNewDTO.builder().dia(1).valor(100.0).build();
        Venda venda = new Venda();
        venda.setDia(1);
        venda.setValor(100.0);

        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setDia(1);
        vendaDTO.setValor(100.0);

        when(mapper.map(vendaNewDTO, Venda.class)).thenReturn(venda);
        when(repository.save(venda)).thenReturn(venda);
        when(mapper.map(venda, VendaDTO.class)).thenReturn(vendaDTO);

        VendaDTO result = service.save(vendaNewDTO);
        
        assertThat(result).isNotNull();
        assertThat(result.getDia()).isEqualTo(1);
        assertThat(result.getValor()).isEqualTo(100.0);

        // Verifica se os métodos foram chamados
        verify(mapper).map(vendaNewDTO, Venda.class);
        verify(repository).save(venda);
        verify(mapper).map(venda, VendaDTO.class);
    }
}
