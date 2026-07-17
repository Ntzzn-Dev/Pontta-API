package com.jhonatan.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.backend.domain.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
