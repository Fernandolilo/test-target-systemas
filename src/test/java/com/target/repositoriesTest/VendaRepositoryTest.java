package com.target.repositoriesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.target.entity.Venda;
import com.target.repositories.VendaRepository;
import com.target.service.VendaService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class VendaRepositoryTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	VendaRepository repository;

	@Test
	public void create() {
		Venda venda = Venda.builder().dia(1).valor(1.1).build();
		entityManager.flush();
		entityManager.persist(venda);
		assertThat(venda.getDia()).isEqualTo(1);
		assertThat(venda.getValor()).isEqualTo(1.1);
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
		repository.saveAll(pedidos);

		List<Venda> vendas = repository.findAll();

		assertThat(vendas).isEqualTo(pedidos);
	}

}
