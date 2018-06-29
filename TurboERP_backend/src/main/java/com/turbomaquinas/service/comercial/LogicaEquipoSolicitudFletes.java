package com.turbomaquinas.service.comercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.comercial.EquipoSolicitudFletesDAO;
import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletes;

@Service
public class LogicaEquipoSolicitudFletes implements EquipoSolicitudFletesService {
	
	@Autowired
	EquipoSolicitudFletesDAO repositorio;
	
	@Override
	public EquipoSolicitudFletes crear(EquipoSolicitudFletes esf) {
		int id = repositorio.crear(esf);
		return repositorio.buscar(id);
	}

	@Override
	public EquipoSolicitudFletes buscar(int id) {
		return repositorio.buscar(id);
	}

}
