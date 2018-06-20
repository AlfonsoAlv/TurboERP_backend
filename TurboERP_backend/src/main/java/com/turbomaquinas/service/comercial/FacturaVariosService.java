package com.turbomaquinas.service.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.DocumentoFacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVarios;
import com.turbomaquinas.POJO.comercial.DetalleFacturaVariosVista;
import com.turbomaquinas.POJO.comercial.FacturaVariosVista;

public interface FacturaVariosService {

	public void actualizar(FacturaVarios fv);
	public FacturaVariosVista buscar(int id);
	public List<FacturaVariosVista> consultar();
	public List<FacturaVariosVista> consultarFacturasVariosPendientesPorCliente(int id, String moneda);
	public FacturaVariosVista buscarFacturaFolio(String folio, String estado, String tipo);
	public FacturaVariosVista buscarPorTipoNumero(int numero, String tipo, String estado);
	public FacturaVariosVista crearDoc(DocumentoFacturaVarios doc);
	public List<DetalleFacturaVariosVista> consultarDetalles(int id);
	public void cancelar(int id, int modificado_por);
	public List<FacturaVariosVista> consultarPorEstado(String estado); 	
	public String obtenerJSONFacturaVarios(int idFactura,String modo);
	public String obtenerJSONCancelarFacturaVarios(int idFactura,String modo,String justificacion);
	public void timbrarDB(int id, String jsonAPI, int creado_por);
}
