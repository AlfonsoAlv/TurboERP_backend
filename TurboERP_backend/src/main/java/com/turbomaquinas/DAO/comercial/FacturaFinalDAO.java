package com.turbomaquinas.DAO.comercial;

import java.math.BigDecimal;
import java.util.List;

import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;

public interface FacturaFinalDAO {

	public FacturaFinal actualizar(FacturaFinal ff);
	public FacturaFinalVista buscar(int id);
	public List<FacturaFinalVista> consultar();
	public FacturaFinalVista buscarPorTipoNumero (int numero, String tipo,String estado);
	public List<FacturaFinalVista> consultarFacturasPendientesPorCliente(int id, String moneda);
	public List<Integer> consultarIdsOrdenesFactura(int id);
	public FacturaFinalVista buscarFacturaFolio(String folio, String estado, String tipo);
	public int creardoc(String doc);
	public List<FacturaFinalVista> consultarFacturasPorIds(List<Integer> ids);
	public List<FacturaFinalVista> consultarPorEstado(String estado);
	public void actualizarEstado(int id, String estado);
	public void actualizarTipoCambio(int id, float tipoCambio);
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados);
	public FacturaFinalVista buscarUltimaFacturaPorTipo(String tipo);
	public void actualizarIdAlfresco(int id, String alfresco_id);
	public String obtenerJSONFacturaFinal(int idFactura,String modo);
	public String obtenerJSONCancelarFacturaFinal(int idFactura, String modo,String justificacion);
	public String obtenerJSONBuscarFacturaFinal(int idFactura, String modo);
	public void baja(int id, int modificado_por);
	public void actualizarNumero(int id,int numero);
	public void actualizarParcialidadImporteTimbrado(BigDecimal impTimbrado,int id);
	
}
