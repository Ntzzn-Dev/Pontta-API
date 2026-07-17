package com.jhonatan.backend.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.backend.domain.entities.PedidoProduto;
import com.jhonatan.backend.domain.entities.PedidoProdutoId;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoId>{
    List<PedidoProduto> findByPedidoId(Long id);
}
