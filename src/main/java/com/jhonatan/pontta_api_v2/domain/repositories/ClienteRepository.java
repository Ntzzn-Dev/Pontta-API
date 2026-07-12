package com.jhonatan.pontta_api_v2.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v2.domain.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
