package com.turbomaquinas.service.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.general.CiudadDAO;
import com.turbomaquinas.DAO.general.EstadoDAO;
import com.turbomaquinas.POJO.general.Ciudad;
import com.turbomaquinas.POJO.general.Estado;

@Service
public class LogicaEstado implements EstadoService{

	@Autowired
	EstadoDAO repEstado;
	@Autowired
	CiudadDAO repositorioCiudad;
	
	@Override
	public Estado buscar(String clave) throws DataAccessException {
		return repEstado.buscar(clave);
	}

	@Override
	public List<Estado> consultar() throws DataAccessException {
		return repEstado.consultar();
	}

	@Override
	public List<Ciudad> consultarCiudades(int id) throws DataAccessException {
		return repositorioCiudad.consultarPorEstado(id);
	}

	@Override
	public Ciudad consultarCiudadPorClaveYEstado(int id, String clave) {
		return repositorioCiudad.consultarCiudadPorClaveYEstado(id, clave);
	}

}
