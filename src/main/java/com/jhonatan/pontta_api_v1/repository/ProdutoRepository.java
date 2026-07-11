package com.jhonatan.pontta_api_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v1.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
