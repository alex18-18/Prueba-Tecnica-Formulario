package com.cesde.fidelizacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.fidelizacion.dto.ClienteDTO;
import com.cesde.fidelizacion.model.Ciudad;
import com.cesde.fidelizacion.model.Cliente;
import com.cesde.fidelizacion.model.Departamento;
import com.cesde.fidelizacion.model.Marca;
import com.cesde.fidelizacion.model.Pais;
import com.cesde.fidelizacion.model.TipoIdentificacion;
import com.cesde.fidelizacion.repository.CiudadRepository;
import com.cesde.fidelizacion.repository.ClienteRepository;
import com.cesde.fidelizacion.repository.DepartamentoRepository;
import com.cesde.fidelizacion.repository.MarcaRepository;
import com.cesde.fidelizacion.repository.PaisRepository;
import com.cesde.fidelizacion.repository.TipoIdentificacionRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private CiudadRepository ciudadRepository;

	@Autowired
	private MarcaRepository marcaRepository;

	public Cliente guardar(ClienteDTO dto) {
		Cliente cliente = new Cliente();

		cliente.setTipoIdentificacion(dto.getTipoIdentificacionId() != null
				? tipoIdentificacionRepository.findById(dto.getTipoIdentificacionId()).orElse(null)
				: null);
		cliente.setNumeroDocumento(dto.getNumeroDocumento());
		cliente.setNombres(dto.getNombres());
		cliente.setApellidos(dto.getApellidos());
		cliente.setFechaNacimiento(dto.getFechaNacimiento());
		cliente.setDireccion(dto.getDireccion());
		cliente.setPais(dto.getPaisId() != null ? paisRepository.findById(dto.getPaisId()).orElse(null) : null);
		cliente.setDepartamento(dto.getDepartamentoId() != null
				? departamentoRepository.findById(dto.getDepartamentoId()).orElse(null)
				: null);
		cliente.setCiudad(dto.getCiudadId() != null ? ciudadRepository.findById(dto.getCiudadId()).orElse(null) : null);
		cliente.setMarca(dto.getMarcaId() != null ? marcaRepository.findById(dto.getMarcaId()).orElse(null) : null);

		return clienteRepository.save(cliente);
	}
}