package com.turbomaquinas.service.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.ActividadesFFVista;
import com.turbomaquinas.POJO.comercial.DocumentoFacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.OrdenFactura;

import twitter4j.JSONException;

public interface FacturaFinalService {

	public FacturaFinal actualizar(FacturaFinal ff);
	public FacturaFinalVista buscar(int id);
	public List<FacturaFinalVista> consultar();
	public FacturaFinalVista buscarPorTipoNumero (int numero, String tipo,String estado);
	public List<FacturaFinalVista> consultarFacturasPendientesPorCliente(int id,String moneda);
	public List<OrdenFactura> consultarOrdenes(int id);
	public FacturaFinalVista buscarFacturaFolio(String folio, String estado, String tipo);
	public FacturaFinalVista creardoc(DocumentoFacturaFinal doc);
	public List<ActividadesFFVista> consultarActividadesPorFactura(int id);
	public List<FacturaFinalVista> consultarPorEstado(String estado);
	public List<FacturaFinalVista> consultarPorIds(List<Integer> lista);
	public void actualizarEstado(int id,String estado);
	public void actualizarNumero(int id,int numero);
	public FacturaFinalVista buscarUltimaFacturaPorTipo(String tipo);
	public void actualizarIdAlfresco(int id, String alfresco_id);
	public String obtenerJSONFacturaFinal(int idFactura,String modo);
	public String obtenerJSONCancelarFacturaFinal(int idFactura,String modo,String justificacion);
	public String obtenerJSONBuscarFacturaFinal(int idFactura,String modo);
	public void cancelar(int id, int modificado_por);
	public void baja(int id, int modificado_por);
	public FacturaFinalVista timbrarDB(int id, String jsonAPI,int creado_por) throws JSONException;
	
}
