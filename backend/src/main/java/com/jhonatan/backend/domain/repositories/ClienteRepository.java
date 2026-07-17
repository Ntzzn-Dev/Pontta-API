package com.jhonatan.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.backend.domain.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
