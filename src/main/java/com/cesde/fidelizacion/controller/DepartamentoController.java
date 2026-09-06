package com.cesde.fidelizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.model.Departamento;
import com.cesde.fidelizacion.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/{paisId}")
	public List<Departamento> listarPorPais(@PathVariable Long paisId) {
		return departamentoService.listarPorPais(paisId);
	}
}