package com.target.repositoriesTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.target.entity.Venda;
import com.target.repositories.VendaRepository;

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
	
}
