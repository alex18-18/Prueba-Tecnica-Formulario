package com.cesde.fidelizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.model.Ciudad;
import com.cesde.fidelizacion.repository.CiudadRepository;

@Service
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;

	public List<Ciudad> listarPorDepartamento(Long departamentoId) {
		return ciudadRepository.findByDepartamentoId(departamentoId);
	}
}