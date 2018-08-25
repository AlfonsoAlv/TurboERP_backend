package com.turbomaquinas.service.calidad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.calidad.InsatisfaccionClienteDAO;
import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccionVista;

@Service
public class LogicaInsatisfaccionCliente implements InsatisfaccionClienteService{

	@Autowired
	InsatisfaccionClienteDAO repoInsatisfaccion;

	@Override
	public InsatisfaccionClienteVista crear(InsatisfaccionCliente insatisfaccion) throws DataAccessException {		
		int id = repoInsatisfaccion.crear(insatisfaccion);
		return repoInsatisfaccion.buscar(id);
	}

	@Override
	public InsatisfaccionClienteVista buscar(int id) throws DataAccessException {
		return repoInsatisfaccion.buscar(id);
	}

	@Override
	public List<InsatisfaccionClienteVista> consultar() throws DataAccessException {
		return repoInsatisfaccion.consultar();
	}

	@Override
	public InsatisfaccionClienteVista buscarPorFolio(int folio) throws DataAccessException {
		return repoInsatisfaccion.buscarPorFolio(folio);
	}

	@Override
	public void actualizarInsatisfaccionCliente(InsatisfaccionCliente insatisfaccion) throws DataAccessException {
		repoInsatisfaccion.actualizar(insatisfaccion);
	}

	@Override
	public SeguimientoInsatisfaccionVista crearSeguimiento(SeguimientoInsatisfaccion seguimiento) {
		int id = repoInsatisfaccion.crearSeguimiento(seguimiento);
		return repoInsatisfaccion.buscarSeguimiento(id);
	}

	@Override
	public List<SeguimientoInsatisfaccion> consultarSeguimientos(int id) throws DataAccessException {
		return repoInsatisfaccion.consultarSeguimientos(id);
	}

	@Override
	public SeguimientoInsatisfaccionVista buscarSeguimiento(int id) throws DataAccessException {
		return repoInsatisfaccion.buscarSeguimiento(id);
	}

	@Override
	public void agregarDocumentoAlfresco(int id, String alfresco_id, int creado_por,String descripcion) {
		repoInsatisfaccion.agregarDocumentoAlfresco(id,alfresco_id,creado_por,descripcion);
	}

	@Override
	public List<InsatisfaccionClienteVista> consultarPorFiltros(String estado, String numero_orden, String fecha_inicio,String fecha_fin) {
		return repoInsatisfaccion.consultarPorFiltros(estado,numero_orden,fecha_inicio,fecha_fin);
	}

	@Override
	public void actualizarEstado(int id,String estado) throws DataAccessException {
		repoInsatisfaccion.actualizarEstado(id,estado);
		
	}

	@Override
	public List<InsatisfaccionClienteVista> consultarPorOrden(String numeroOrden) throws DataAccessException {
		return repoInsatisfaccion.consultarPorOrden(numeroOrden);
	}
	
}
