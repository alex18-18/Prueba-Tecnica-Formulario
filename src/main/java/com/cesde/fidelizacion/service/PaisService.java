package com.cesde.fidelizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.model.Pais;
import com.cesde.fidelizacion.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> listarTodos() {
		return paisRepository.findAll();
	}
}