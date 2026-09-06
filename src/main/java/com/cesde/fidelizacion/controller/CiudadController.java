package com.cesde.fidelizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.model.Ciudad;
import com.cesde.fidelizacion.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;

	@GetMapping("/{departamentoId}")
	public List<Ciudad> listarPorDepartamento(@PathVariable Long departamentoId) {
		return ciudadService.listarPorDepartamento(departamentoId);
	}
}