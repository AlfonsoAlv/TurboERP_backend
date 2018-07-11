package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.ActividadesFFDAO;
import com.turbomaquinas.DAO.comercial.DatosTimbradosDAO;
import com.turbomaquinas.DAO.comercial.FacturaFinalDAO;
import com.turbomaquinas.DAO.general.ServidorDAO;
import com.turbomaquinas.DAO.general.TipoCambioDAO;
import com.turbomaquinas.POJO.comercial.ActividadesFFVista;
import com.turbomaquinas.POJO.comercial.DatosTimbrados;
import com.turbomaquinas.POJO.comercial.DocumentoFacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.service.general.OrdenService;

import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class LogicaFacturaFinal implements FacturaFinalService {
	
	@Autowired
	FacturaFinalDAO repFF;
	
	@Autowired
	OrdenService serviceOrden;
	
	@Autowired
	ActividadesFFDAO repActividadesFF;
	
	@Autowired
	DatosTimbradosDAO repoDT;
	
	@Autowired
	TipoCambioDAO repoTC;
	
	@Autowired
	ServidorDAO repoS;

	
	@Override
	public FacturaFinal actualizar(FacturaFinal ff) throws DataAccessException {
		return repFF.actualizar(ff);
	}

	@Override
	public FacturaFinalVista buscar(int id) throws DataAccessException {
		return repFF.buscar(id);
	}

	@Override
	public List<FacturaFinalVista> consultar() throws DataAccessException {
		return repFF.consultar();
	}

	@Override
	public FacturaFinalVista buscarPorTipoNumero(int numero, String tipo,String estado) throws DataAccessException {
		return repFF.buscarPorTipoNumero(numero, tipo,estado);
	}
	
	@Override
	public List<FacturaFinalVista> consultarFacturasPendientesPorCliente(int id,String moneda) {		
		return repFF.consultarFacturasPendientesPorCliente(id,moneda);
	}

	@Override
	public List<OrdenFactura> consultarOrdenes(int id) {
		return serviceOrden.consultarOrdenesPorIdsFactura(repFF.consultarIdsOrdenesFactura(id),id);
	}

	@Override
	public FacturaFinalVista buscarFacturaFolio(String folio, String estado, String tipo) {
		return repFF.buscarFacturaFolio(folio, estado, tipo);
	}

	@Override
	@Transactional
	public FacturaFinalVista creardoc(DocumentoFacturaFinal doc) throws DataAccessException {
		int id = repFF.creardoc(doc.toString());
		return repFF.buscar(id);
	}

	@Override
	public List<ActividadesFFVista> consultarActividadesPorFactura(int id) {
		return repActividadesFF.consultarPorFactura(id);
	}

	@Override
	public List<FacturaFinalVista> consultarPorEstado(String estado) {
		return repFF.consultarPorEstado(estado);
	}

	@Override
	public List<FacturaFinalVista> consultarPorIds(List<Integer> lista) {
		return repFF.consultarFacturasPorIds(lista);
	}

	@Override
	public void actualizarEstado(int id, String estado) {
		repFF.actualizarEstado(id,estado);
	}

	@Override
	public FacturaFinalVista buscarUltimaFacturaPorTipo(String tipo) {
		return repFF.buscarUltimaFacturaPorTipo(tipo);
	}

	@Override
	public void actualizarIdAlfresco(int id, String alfresco_id) {
		repFF.actualizarIdAlfresco(id,alfresco_id);
	}
	
	@Override
	public String obtenerJSONFacturaFinal(int idFactura,String modo) throws DataAccessException {
		return repFF.obtenerJSONFacturaFinal(idFactura,modo);
	}

	@Override
	public String obtenerJSONCancelarFacturaFinal(int idFactura, String modo,String justificacion) {
		return repFF.obtenerJSONCancelarFacturaFinal(idFactura,modo,justificacion);
	}
	
	@Override
	public String obtenerJSONBuscarFacturaFinal(int idFactura, String modo) {
		return repFF.obtenerJSONBuscarFacturaFinal(idFactura,modo);
	}

	@Override
	@Transactional
	public void cancelar(int id, int modificado_por) {
		repFF.baja(id, modificado_por);	
		repFF.actualizarEstado(id, "C");
	}

	@Override
	public void baja(int id, int modificado_por) {
		repFF.baja(id, modificado_por);			
	}

	
	@Override
	@Transactional
	public void timbrarDB(int id, String jsonAPI,int creado_por) throws JSONException {
		JSONObject jsonRespuesta = new JSONObject(jsonAPI);
	    String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		if(estatusDocumento.equalsIgnoreCase("aceptado")){
		  	//Actualizar estado de la factura a Timbrado
		   	actualizarEstado(id, "T");
		   	//Actualizar el tipo_cambio de la Factura a cambio del dia que se genera en el JSON del PA
		   	FacturaFinalVista factura=repFF.buscar(id);
		   	float tipo_cambio=1;
		   	if(!factura.getMoneda().equals("MXN")){
		   		tipo_cambio=repoTC.buscarPorFecha(repoS.obtenerfecha()).getTipo_cambio();	
		   	}
		   	repFF.actualizarTipoCambio(id,tipo_cambio);
		   	
		    //Insertar registro en Datos Timbrados
		   	if(factura.getDatos_timbrado_id()==0){
		   		DatosTimbrados dt=new DatosTimbrados();
			   	dt.setFolio_fiscal((String) json_AckEnlaceFiscal.getString("folioFiscalUUID"));
			   	dt.setFecha((String) json_AckEnlaceFiscal.getString("fechaTFD"));
			   	dt.setSello_emisor((String) json_AckEnlaceFiscal.getString("selloCFDi"));
			   	dt.setCadena_original((String) json_AckEnlaceFiscal.getString("cadenaTFD"));
			   	dt.setSello_sat((String) json_AckEnlaceFiscal.getString("selloSAT"));
			   	dt.setLeyenda("leyenda");
			   	dt.setActivo(1);
			   	dt.setCreado_por(creado_por);
			   	int idDatosTimbrados=repoDT.crear(dt);		    	
			   	//Actualizar DATOS_TIMBRADO_id
			   	repFF.actualizarIdDatosTimbrados(id, idDatosTimbrados);
		   	}
		   	
		   	
		}
		
	}

	

}
