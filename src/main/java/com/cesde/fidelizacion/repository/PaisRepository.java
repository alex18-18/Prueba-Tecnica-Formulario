package com.cesde.fidelizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesde.fidelizacion.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}