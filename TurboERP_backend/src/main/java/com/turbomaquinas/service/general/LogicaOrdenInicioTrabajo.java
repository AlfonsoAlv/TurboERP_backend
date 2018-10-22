package com.turbomaquinas.service.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.general.OrdenInicioTrabajoDAO;
import com.turbomaquinas.POJO.general.DocumentoCrearOIT;
import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;

@Service
public class LogicaOrdenInicioTrabajo implements OrdenInicioTrabajoService{
	
	@Autowired
	OrdenInicioTrabajoDAO repositorio;
	
	@Override
	public List<OrdenInicioTrabajoVista> consultarConFiltros(String numero_orden,String prioridad,String estado,String anio,String tipo) {
		return repositorio.consultarConFiltros(numero_orden,prioridad,estado,anio,tipo);
	}

	@Override
	public List<Integer> anios() {
		return repositorio.anios();
	}

	@Override
	public void cancelar(int id, int modificado_por) {
		repositorio.cancelar(id,modificado_por);
	}

	@Override
	public void crear(DocumentoCrearOIT p_obj_act_oit) throws DataAccessException{
		repositorio.crearOIT(p_obj_act_oit.toString());
		
	}
}
