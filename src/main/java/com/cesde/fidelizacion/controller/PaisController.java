package com.cesde.fidelizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.model.Pais;
import com.cesde.fidelizacion.service.PaisService;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisController {

	@Autowired
	private PaisService paisService;

	@GetMapping
	public List<Pais> listar() {
		return paisService.listarTodos();
	}
}