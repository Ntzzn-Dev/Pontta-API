package com.jhonatan.pontta_api_v2.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v2.domain.entities.PedidoProduto;
import com.jhonatan.pontta_api_v2.domain.entities.PedidoProdutoId;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoId>{
    List<PedidoProduto> findByPedidoId(Long id);
}
