package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

public interface PagosDAO {
	
	public Pagos actualizar(Pagos p);
	public PagosVista buscar(int id);
	public List<PagosVista> consultar();
	
	public void AplicarPagos(String doc);
	public void RestablecerPago(int id);
	public List<Pagos> pagoRangoFecha(String fecha_pagoInicio,String fecha_pagoFin);
	public List<PagosFacturas> facturasPagadas(int idPago);
	public String obtenerJSONTimbrado(int id, String modo);
	public Integer obtenerUltimoIdPago();

}
