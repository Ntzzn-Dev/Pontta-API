package com.jhonatan.pontta_api_v2.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v2.domain.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
