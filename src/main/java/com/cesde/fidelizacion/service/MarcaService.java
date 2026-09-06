package com.cesde.fidelizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.model.Marca;
import com.cesde.fidelizacion.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public List<Marca> listarTodas() {
		return marcaRepository.findAll();
	}
}