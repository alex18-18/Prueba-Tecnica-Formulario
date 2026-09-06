package com.cesde.fidelizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.model.TipoIdentificacion;
import com.cesde.fidelizacion.repository.TipoIdentificacionRepository;

@Service
public class TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	public List<TipoIdentificacion> listarTodos() {
		return tipoIdentificacionRepository.findAll();
	}
}