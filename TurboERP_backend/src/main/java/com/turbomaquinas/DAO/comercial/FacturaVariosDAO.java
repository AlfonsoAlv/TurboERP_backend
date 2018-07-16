package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.FacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVariosVista;

public interface FacturaVariosDAO {
	
	public void actualizar(FacturaVarios fv);
	public FacturaVariosVista buscar(int id);
	public List<FacturaVariosVista> consultar();
	public List<FacturaVariosVista> consultarFacturasVariosPendientesPorCliente(int id, String moneda);
	public FacturaVariosVista buscarFacturaFolio(String folio, String estado, String tipo);
	public FacturaVariosVista buscarPorTipoNumero(int numero, String tipo, String estado);
	public int crearDoc(String doc);
	public void cancelar(int id, int modificado_por);
	public String obtenerJSONFacturaVarios(int idFactura, String modo);
	public void actualizarEstado(int id, String estado);
	public void actualizarTipoCambio(int id, float tipoCambio);
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados);
	public String obtenerJSONCancelarFacturaVarios(int idFactura, String modo,String justificacion);
	public String obtenerJSONBuscarFacturaVarios(int id, String modo);
	public List<FacturaVariosVista> consultarPorEstado(String estado);
	public void actualizarNumero(int id, int opcion);
	
}
