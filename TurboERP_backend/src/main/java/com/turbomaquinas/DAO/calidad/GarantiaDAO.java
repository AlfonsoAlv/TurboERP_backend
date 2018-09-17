package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.EstadoCierreFoco;
import com.turbomaquinas.POJO.calidad.PorcentajeActividades;
import com.turbomaquinas.POJO.calidad.GarantiaVista;

public interface GarantiaDAO {

	public GarantiaVista buscar(int id);
	public int crearActividadesGarantia(String obj_actividades_Garantia);
	public List<Integer> obtenerFocos(int id);
	public EstadoCierreFoco obtenerEstadoCierreFoco(int focoId);
	public PorcentajeActividades obtenerPorcentajeActividades(int focoId);
	
}
