package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.FacturaVarios;

public interface FacturaVariosDAO {
	
	public int crear(FacturaVarios fv);
	public FacturaVarios actualizar(FacturaVarios fv);
	public FacturaVarios buscar(int id);
	public List<FacturaVarios> consultar();
	public void cancelar(FacturaVarios fv); 
	public List<FacturaVarios> consultarFacturasVariosPendientesPorCliente(int id, String moneda); 

}
