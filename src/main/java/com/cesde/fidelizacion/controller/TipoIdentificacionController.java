package com.cesde.fidelizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.model.TipoIdentificacion;
import com.cesde.fidelizacion.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api/tipos-identificacion")
@CrossOrigin(origins = "*")
public class TipoIdentificacionController {

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	@GetMapping
	public List<TipoIdentificacion> listar() {
		return tipoIdentificacionService.listarTodos();
	}
}