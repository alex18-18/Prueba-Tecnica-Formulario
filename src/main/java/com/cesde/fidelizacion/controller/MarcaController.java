package com.cesde.fidelizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.model.Marca;
import com.cesde.fidelizacion.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@GetMapping
	public List<Marca> listar() {
		return marcaService.listarTodas();
	}
}