package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;

public interface DetalleGarantiaDAO {	
	public List<DetalleGarantiaVista> consultarPorGarantia(int id);
	public DetalleGarantiaVista buscar(int id);
	public void actualizarDetalles(String detallesJSON);

}
