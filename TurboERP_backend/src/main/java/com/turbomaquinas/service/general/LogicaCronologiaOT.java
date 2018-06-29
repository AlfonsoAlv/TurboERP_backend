package com.turbomaquinas.service.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.general.CronologiaOTDAO;
import com.turbomaquinas.POJO.general.CronologiaOT;

@Service
public class LogicaCronologiaOT implements CronologiaOTservice{

	@Autowired
	CronologiaOTDAO repositorio;
	
	@Override
	public List<CronologiaOT> consultarPorOrden(int id) throws DataAccessException{
		return repositorio.consultarPorOrden(id);
	}

	@Override
	public List<CronologiaOT> consultarPorOrdenyTipo(int id, String tipo) {
		return repositorio.consultarPorOrdenyTipo(id, tipo);
	}

	@Override
	public List<CronologiaOT> consultaCronologia(int id) {
		return repositorio.consultaCronologia(id);
	}
}
