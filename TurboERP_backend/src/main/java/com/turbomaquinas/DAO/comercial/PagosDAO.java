package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosDetalle;
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
	public void actualizarNumero(int id, int opcion);
	public Integer obtenerUltimoIdPago();
	public List<Pagos> pendientesTimbrar();
	public void actualizarEstado(int id,String estado);
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados);
	public List<PagosDetalle> detallesPago(int id);
	public String obtenerJSONCancelarPagos(int id, String modo, String justificacion);
	public String obtenerJSONBuscarPagos(int id, String modo);
	public void cancelar(int id, int modificado_por);

}
