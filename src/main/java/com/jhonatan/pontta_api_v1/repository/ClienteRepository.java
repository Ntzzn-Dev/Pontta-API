package com.jhonatan.pontta_api_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.pontta_api_v1.model.Cliente;

public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

        boolean existsByNome(String nome);
}