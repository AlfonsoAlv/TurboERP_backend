package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.DatosTimbradosDAO;
import com.turbomaquinas.DAO.comercial.DetalleFacturaVariosDAO;
import com.turbomaquinas.DAO.comercial.FacturaVariosDAO;
import com.turbomaquinas.DAO.general.ServidorDAO;
import com.turbomaquinas.DAO.general.TipoCambioDAO;
import com.turbomaquinas.POJO.comercial.DatosTimbrados;
import com.turbomaquinas.POJO.comercial.DetalleFacturaVariosVista;
import com.turbomaquinas.POJO.comercial.DocumentoFacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVariosVista;

import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class LogicaFacturaVarios implements FacturaVariosService {
	
	@Autowired
	FacturaVariosDAO repFV;
	
	@Autowired
	DetalleFacturaVariosDAO repoDetalles;
	
	@Autowired
	DatosTimbradosDAO repoDT;
	
	@Autowired
	TipoCambioDAO repoTC;
	
	@Autowired
	ServidorDAO repoS;

	@Override
	public void actualizar(FacturaVarios fv) throws DataAccessException {
		repFV.actualizar(fv);
	}

	@Override
	public FacturaVariosVista buscar(int id) throws DataAccessException {
		return repFV.buscar(id);
	}

	@Override
	public List<FacturaVariosVista> consultar() throws DataAccessException {
		return repFV.consultar();
	}

	@Override
	public List<FacturaVariosVista> consultarFacturasVariosPendientesPorCliente(int id, String moneda) {
		return repFV.consultarFacturasVariosPendientesPorCliente(id,moneda);
	}

	@Override
	public FacturaVariosVista buscarFacturaFolio(String folio, String estado, String tipo) {
		return repFV.buscarFacturaFolio(folio, estado, tipo);
	}

	@Override
	public FacturaVariosVista buscarPorTipoNumero(int numero, String tipo, String estado) {
		return repFV.buscarPorTipoNumero(numero, tipo,estado);
	}

	@Override
	@Transactional
	public FacturaVariosVista crearDoc(DocumentoFacturaVarios doc) {
		int id = repFV.crearDoc(doc.toString());
		return repFV.buscar(id);
	}

	@Override
	public List<DetalleFacturaVariosVista> consultarDetalles(int id) {
		return repoDetalles.consultarPorFacturaVarios(id);
	}

	@Override
	@Transactional
	public void cancelar(int id, int modificado_por) {
		repFV.cancelar(id, modificado_por);	
		repoDetalles.cancelarPorIdFactura(id, modificado_por);
	}

	@Override
	public List<FacturaVariosVista> consultarPorEstado(String estado) {
		return repFV.consultarPorEstado(estado);
	}

	@Override
	public String obtenerJSONFacturaVarios(int idFactura, String modo) {
		return repFV.obtenerJSONFacturaVarios(idFactura,modo);
	}
	
	@Override
	public String obtenerJSONCancelarFacturaVarios(int idFactura, String modo,String justificacion) {
		return repFV.obtenerJSONCancelarFacturaVarios(idFactura,modo,justificacion);
	}
	
	@Override
	public String obtenerJSONBuscarFacturaVarios(int id, String modo) {
		return repFV.obtenerJSONBuscarFacturaVarios(id,modo);
	}

	@Override
	@Transactional
	public FacturaVariosVista timbrarDB(int id, String jsonAPI, int creado_por) throws JSONException {
		JSONObject jsonRespuesta = new JSONObject(jsonAPI);
	    String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		if(estatusDocumento.equalsIgnoreCase("aceptado")){
			FacturaVariosVista factura=repFV.buscar(id);
		   	//Actualizar estado de la factura a Timbrado
			if(factura.getEstado_factura().equalsIgnoreCase("I")){
				repFV.actualizarEstado(id, "T");
			}
		   	//Actualizar el tipo_cambio de la Factura a cambio del dia que se genera en el JSON del PA
			if(factura.getTipo_cambio()==0){
				float tipo_cambio=1;
			   	if(!factura.getMoneda().equals("MXN")){
			   		tipo_cambio=repoTC.buscarPorFecha(repoS.obtenerfecha()).getTipo_cambio();	
			  	}
			   	repFV.actualizarTipoCambio(id,tipo_cambio);
			}
		   	
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
			    repFV.actualizarIdDatosTimbrados(id, idDatosTimbrados);
			}
			
		}//Lili
		return repFV.buscar(id);
		
	}
	
	@Override
	public void actualizarNumero(int id,int opcion) {
		repFV.actualizarNumero(id,opcion);
	}

	

}
