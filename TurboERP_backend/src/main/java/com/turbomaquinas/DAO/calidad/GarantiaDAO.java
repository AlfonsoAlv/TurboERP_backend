package com.turbomaquinas.DAO.calidad;

import com.turbomaquinas.POJO.calidad.GarantiaVista;

public interface GarantiaDAO {

	public GarantiaVista buscar(int id);
	public int crearActividadesGarantia(String obj_actividades_Garantia);
	
}
