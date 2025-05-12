package com.target.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.controller.VendaController;
import com.target.entity.Venda;
import com.target.entity.dto.VendaDTO;
import com.target.entity.dto.VendaDTOWrapper;
import com.target.entity.dto.VendaNewDTO;
import com.target.service.VendaService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(VendaController.class)
@AutoConfigureMockMvc
public class VendaControllerTest {

	static String API = "/vendas";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VendaService service;

	@MockBean
	private ModelMapper modelMapper;

	@Test
	public void create() throws Exception {
		VendaNewDTO vendaNewDTO = VendaNewDTO.builder().dia(1).valor(100.0).build();

		VendaDTO vendaDTO = VendaDTO.builder().valor(vendaNewDTO.getValor()).dia(vendaNewDTO.getDia()).build();

		Venda venda = Venda.builder().valor(vendaDTO.getValor()).dia(vendaDTO.getDia()).build();

		BDDMockito.given(modelMapper.map(Mockito.any(VendaNewDTO.class), Mockito.eq(Venda.class))).willReturn(venda);

		String json = new ObjectMapper().writeValueAsString(vendaNewDTO);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(API).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json);

		mockMvc.perform(request).andExpect(status().isCreated());

	}
	
	@Test
	public void findAll() throws Exception {
		VendaDTO vendaDTO = VendaDTO.builder().dia(1).valor(1.1).build();
		VendaDTOWrapper wrapper = new VendaDTOWrapper();
		
		wrapper.setVendas(List.of(vendaDTO));
		when(service.vendas()).thenReturn(List.of(wrapper));
		
		String json = new ObjectMapper().writeValueAsString(wrapper);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(API).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json);
		
		mockMvc.perform(request).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].vendas[0].dia").value(1))
        .andExpect(jsonPath("$[0].vendas[0].valor").value(1.1));
	}
	
	public void findAllNotFounf() throws Exception {
		VendaDTO vendaDTO = VendaDTO.builder().build();
		VendaDTOWrapper wrapper = new VendaDTOWrapper();
		
		wrapper.setVendas(List.of(vendaDTO));
		when(service.vendas()).thenReturn(List.of(wrapper));
		
		String json = new ObjectMapper().writeValueAsString(wrapper);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(API).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json);
		
		mockMvc.perform(request).andExpect(status().isNotFound());
	}


}
