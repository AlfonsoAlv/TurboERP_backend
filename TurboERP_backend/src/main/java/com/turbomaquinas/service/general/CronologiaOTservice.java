package com.turbomaquinas.service.general;

import java.util.List;

import com.turbomaquinas.POJO.general.CronologiaOT;

public interface CronologiaOTservice {
	public List<CronologiaOT> consultarPorOrden(int id);
}
