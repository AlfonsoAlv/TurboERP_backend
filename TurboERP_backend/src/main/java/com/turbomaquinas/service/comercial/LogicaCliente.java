package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.comercial.ClienteDAO;
import com.turbomaquinas.DAO.comercial.EquipoSolicitudFletesDAO;
import com.turbomaquinas.POJO.comercial.Cliente;
import com.turbomaquinas.POJO.comercial.ClienteVista;
import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletesVista;

@Service
public class LogicaCliente implements ClienteService {
	
	@Autowired
	ClienteDAO repCliente;
	
	@Autowired
	EquipoSolicitudFletesDAO repositorio;
	
	@Override
	public ClienteVista crear(Cliente c) throws DataAccessException{
		int id = repCliente.crear(c);
		return repCliente.buscar(id);
	}
	
	@Override
	public Cliente actualizar(Cliente c) throws DataAccessException{
		return repCliente.actualizar(c);
	}

	@Override
	public ClienteVista buscar(int id) throws DataAccessException {
		return repCliente.buscar(id);	
	}

	@Override
	public List<ClienteVista> consultar() throws DataAccessException {
		return repCliente.consultar();
	}

	@Override
	public ClienteVista buscar(int numero_giro, int numero) {
		return repCliente.buscar(numero_giro, numero);
	}
	
	@Override
	public ClienteVista buscarClientePorPrecotizacion(int id) throws DataAccessException{
		return repCliente.buscarClientePorPrecotizacion(id);
	}

	@Override
	public ClienteVista buscarClientePorOrden(int id) throws DataAccessException{
		return repCliente.buscarClientePorOrden(id);
	}

	@Override
	public String buscarTipoCliente(int id) {
		return repCliente.buscarTipoCliente(id);
	}
	
	@Override
	public List<EquipoSolicitudFletesVista> consultarPorCliente(int id) {
		return repositorio.consultarPorCliente(id);
	}

	@Override
	public List<ClienteVista> consultarPorGiro(int numero_giro) {
		return repCliente.consultarPorGiro(numero_giro);
	}

	
}
