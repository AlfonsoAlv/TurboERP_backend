package com.turbomaquinas.service.SGC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.SGC.SolicitudCambioDAO;
import com.turbomaquinas.DAO.SGC.SolicitudCambioVistaDAO;
import com.turbomaquinas.POJO.SGC.SolicitudCambio;
import com.turbomaquinas.POJO.SGC.SolicitudCambioVista;

@Service
public class LogicaSolicitudCambio implements SolicitudCambioService {
	
	@Autowired
	SolicitudCambioDAO repositorio;
	
	@Autowired
	SolicitudCambioVistaDAO repositorioVista;
	
	@Override
	public SolicitudCambioVista crear(SolicitudCambio solicitud) throws DataAccessException {
		
		int id = repositorio.crear(solicitud);
		return repositorioVista.buscar(id);
		
	}

	@Override
	public SolicitudCambioVista buscar(int id) throws DataAccessException{
		return repositorioVista.buscar(id);
	}

	@Override
	public List<SolicitudCambioVista> consultar() throws DataAccessException{
		return repositorioVista.consultar();
	}

	@Override
	public List<SolicitudCambioVista> consultarporEstado(String estado, String rol) {
		return repositorioVista.consultarporEstado(estado, rol);
	}

	@Override
	public void actualizarEvaluacion(SolicitudCambio solicitud) {
		repositorio.actualizarEvaluacion(solicitud);
	}

	@Override
	public void actualizarResolucion(SolicitudCambio solicitud) {
		repositorio.actualizarResolucion(solicitud);
		
	}
	
	@Override
	public void actualizarVerificacion(SolicitudCambio solicitud) {
		repositorio.actualizarVerificacion(solicitud);
		
	}

}
