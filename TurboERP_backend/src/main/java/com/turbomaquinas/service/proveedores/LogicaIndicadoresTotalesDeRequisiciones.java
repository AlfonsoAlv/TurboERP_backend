package com.turbomaquinas.service.proveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.proveedores.IndicadoresTotalesDeRequisicionesDAO;
import com.turbomaquinas.POJO.proveedores.IndicadoresTotalesDeRequisiciones;

@Service
public class LogicaIndicadoresTotalesDeRequisiciones implements IndicadoresTotalesDeRequisicionesService{
	
	@Autowired
	IndicadoresTotalesDeRequisicionesDAO indtr;

	@Override
	public List<IndicadoresTotalesDeRequisiciones> consultar() {
		return indtr.consultar();
	}
	
	
	

}
