package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;

public interface SubindiceGarantiaDAO {
	public List<SubindiceGarantiaVista> consultarPorGarantia(int id);
}
