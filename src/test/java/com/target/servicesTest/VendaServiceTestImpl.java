package com.target.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.target.entity.Venda;
import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaNewDTO;
import com.target.repositories.VendaRepository;
import com.target.service.exceptions.ObjectNotFoundException;
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
	
	@Test
	public void findAll() {
		List<Venda> pedidos = Arrays.asList(Venda.builder().dia(1).valor(22174.1664).build(),
				Venda.builder().dia(2).valor(24537.6698).build(), Venda.builder().dia(3).valor(26139.6134).build(),
				Venda.builder().dia(4).valor(0.0).build(), Venda.builder().dia(5).valor(0.0).build(),
				Venda.builder().dia(6).valor(26742.6612).build(), Venda.builder().dia(7).valor(0.0).build(),
				Venda.builder().dia(8).valor(42889.2258).build(), Venda.builder().dia(9).valor(46251.174).build(),
				Venda.builder().dia(10).valor(11191.4722).build(), Venda.builder().dia(11).valor(0.0).build(),
				Venda.builder().dia(12).valor(0.0).build(), Venda.builder().dia(13).valor(3847.4823).build(),
				Venda.builder().dia(14).valor(373.7838).build(), Venda.builder().dia(15).valor(2659.7563).build());
		when(repository.findAll()).thenReturn(pedidos);
	}
	
	public void findAllNotFound() {
		
		Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());
		ObjectNotFoundException ex = assertThrows(ObjectNotFoundException.class, ()->{
			service.vendas();
		});
		assertEquals("Não há vendas", ex.getMessage());
	}
}
