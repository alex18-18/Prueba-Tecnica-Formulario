package com.cesde.fidelizacion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.fidelizacion.dto.ClienteDTO;
import com.cesde.fidelizacion.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Map<String, String>> registrar(@RequestBody ClienteDTO dto) {
		try {
			clienteService.guardar(dto);

			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Cliente registrado correctamente");
			return ResponseEntity.ok(respuesta);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("mensaje", "Error al registrar el cliente: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
}