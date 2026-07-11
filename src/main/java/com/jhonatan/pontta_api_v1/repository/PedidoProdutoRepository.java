package com.jhonatan.pontta_api_v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v1.model.PedidoProduto;
import com.jhonatan.pontta_api_v1.model.PedidoProdutoId;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoId>{
    List<PedidoProduto> findByPedidoId(Long id);
}
