package com.turbomaquinas.service.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.DocumentoAplicarPago;
import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosDetalle;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

import twitter4j.JSONException;

public interface PagosService {
	
	public Pagos actualizar(Pagos p);
	public PagosVista buscar(int id);
	public List<PagosVista> consultar();
	public void aplicarPagos(DocumentoAplicarPago doc);
	public List<Pagos> pagosFecha(String fechainicio, String fechafin);
	public List<PagosFacturas> facturasPorPago(int id);
	public void restablecerPago(int id);
	public String obtenerJSONTimbrado(int id,String modo);
	public void actualizarNumero(int id, int opcion);
	public Integer ultimoPago();
	public List<Pagos> pendientesTimbrar();
	public PagosVista timbrarDB(int id, String jsonAPI, int creado_por) throws JSONException;
	public void actualizarEstado(int id, String estado);
	public List<PagosDetalle> detallesPago(int id);

}
