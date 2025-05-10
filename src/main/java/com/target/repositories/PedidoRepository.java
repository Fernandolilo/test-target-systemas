package com.target.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
