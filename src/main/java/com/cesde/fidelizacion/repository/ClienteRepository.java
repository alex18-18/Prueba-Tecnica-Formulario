package com.cesde.fidelizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesde.fidelizacion.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}