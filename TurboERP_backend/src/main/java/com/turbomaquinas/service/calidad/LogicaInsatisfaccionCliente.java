package com.turbomaquinas.service.calidad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.calidad.InsatisfaccionClienteDAO;
import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;

@Service
public class LogicaInsatisfaccionCliente implements InsatisfaccionClienteService{

	@Autowired
	InsatisfaccionClienteDAO insatisfaccionClienteDAO;

	@Override
	public InsatisfaccionClienteVista crear(InsatisfaccionCliente insatisfaccion) {
		
		int id = insatisfaccionClienteDAO.crear(insatisfaccion);
		
		return insatisfaccionClienteDAO.buscar(id);
	}

	@Override
	public InsatisfaccionClienteVista buscar(int id) {

		return insatisfaccionClienteDAO.buscar(id);
		
	}

	@Override
	public List<InsatisfaccionClienteVista> consultar() {

		return insatisfaccionClienteDAO.consultar();

	}

	@Override
	public InsatisfaccionClienteVista buscarPorFolio(int folio) {
		return insatisfaccionClienteDAO.buscarPorFolio(folio);
	}

	@Override
	public void actualizarInsatisfaccionCliente(InsatisfaccionCliente insatisfaccion) throws DataAccessException {
		insatisfaccionClienteDAO.actualizarInsatisfaccionCliente(insatisfaccion);
	}
	
}
