package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;

public interface EncabezadoGarantiaDAO {
	public List<EncabezadoGarantiaVista> consultarPorGarantia(int id);
	public int consultarCantidadporGarantia(int id);
}
