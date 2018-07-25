package com.turbomaquinas.service.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.DocumentoAplicarPago;
import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

public interface PagosService {
	
	public Pagos actualizar(Pagos p);
	public PagosVista buscar(int id);
	public List<PagosVista> consultar();
	public void aplicarPagos(DocumentoAplicarPago doc);
	public List<Pagos> pagosFecha(String fechainicio, String fechafin);
	public List<PagosFacturas> facturasPorPago(int id);
	public void restablecerPago(int id);
	public String obtenerJSONTimbrado(int id,String modo);
	public Integer ultimoPago();
	public List<Pagos> pendientesTimbrar();

}
