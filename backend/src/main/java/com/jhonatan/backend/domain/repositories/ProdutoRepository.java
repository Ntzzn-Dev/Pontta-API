package com.jhonatan.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.backend.domain.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
