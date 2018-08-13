package com.turbomaquinas.service.calidad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.calidad.InsatisfaccionClienteDAO;
import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;

@Service
public class LogicaInsatisfaccionCliente implements InsatisfaccionClienteService{

	@Autowired
	InsatisfaccionClienteDAO repoInsatisfaccion;

	@Override
	public InsatisfaccionClienteVista crear(InsatisfaccionCliente insatisfaccion) {		
		int id = repoInsatisfaccion.crear(insatisfaccion);
		return repoInsatisfaccion.buscar(id);
	}

	@Override
	public InsatisfaccionClienteVista buscar(int id) {
		return repoInsatisfaccion.buscar(id);
	}

	@Override
	public List<InsatisfaccionClienteVista> consultar() {
		return repoInsatisfaccion.consultar();
	}

	@Override
	public InsatisfaccionClienteVista buscarPorFolio(int folio) {
		return repoInsatisfaccion.buscarPorFolio(folio);
	}

	@Override
	public void actualizarInsatisfaccionCliente(InsatisfaccionCliente insatisfaccion) throws DataAccessException {
		repoInsatisfaccion.actualizar(insatisfaccion);
	}

	@Override
	public void crearSeguimiento(SeguimientoInsatisfaccion seguimiento) {
		repoInsatisfaccion.crearSeguimiento(seguimiento);	
	}

	@Override
	public List<SeguimientoInsatisfaccion> consultarSeguimientos(int id) {
		return repoInsatisfaccion.consultarSeguimientos(id);
	}
	
}
