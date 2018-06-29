package com.turbomaquinas.DAO.general;

import java.util.List;

import com.turbomaquinas.POJO.general.CronologiaOT;

public interface CronologiaOTDAO {
	public List<CronologiaOT> consultarPorOrden(int id); 
	public List<CronologiaOT> consultarPorOrdenyTipo(int id, String tipo);
	public List<CronologiaOT> consultaCronologia(int id);
}
