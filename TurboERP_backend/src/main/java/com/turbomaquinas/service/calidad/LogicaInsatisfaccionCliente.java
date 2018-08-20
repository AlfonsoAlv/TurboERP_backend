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
	public SeguimientoInsatisfaccionVista crearSeguimiento(SeguimientoInsatisfaccion seguimiento) {
		int id = repoInsatisfaccion.crearSeguimiento(seguimiento);
		return repoInsatisfaccion.buscarSeguimiento(id);
	}

	@Override
	public List<SeguimientoInsatisfaccion> consultarSeguimientos(int id) {
		return repoInsatisfaccion.consultarSeguimientos(id);
	}

	@Override
	public SeguimientoInsatisfaccionVista buscarSeguimiento(int id) {
		return repoInsatisfaccion.buscarSeguimiento(id);
	}

	@Override
	public void agregarDocumentoAlfresco(int id, String alfresco_id, int creado_por) {
		repoInsatisfaccion.agregarDocumentoAlfresco(id,alfresco_id,creado_por);
	}

	@Override
	public List<InsatisfaccionClienteVista> consultarPorFiltros(String estado, String numero_orden, String fecha_inicio,String fecha_fin) {
		return repoInsatisfaccion.consultarPorFiltros(estado,numero_orden,fecha_inicio,fecha_fin);
	}
	
}
