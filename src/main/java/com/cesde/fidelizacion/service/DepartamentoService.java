package com.cesde.fidelizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.model.Departamento;
import com.cesde.fidelizacion.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public List<Departamento> listarPorPais(Long paisId) {
		return departamentoRepository.findByPaisId(paisId);
	}
}