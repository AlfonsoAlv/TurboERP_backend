package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.DatosTimbradosDAO;
import com.turbomaquinas.DAO.comercial.NotaCreditoDAO;
import com.turbomaquinas.DAO.general.ServidorDAO;
import com.turbomaquinas.DAO.general.TipoCambioDAO;
import com.turbomaquinas.POJO.comercial.DatosTimbrados;
import com.turbomaquinas.POJO.comercial.DocumentoAplicarNotasCredito;
import com.turbomaquinas.POJO.comercial.NotaCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;

import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class LogicaNotaCredito implements NotaCreditoService {

	@Autowired
	NotaCreditoDAO repNc;
	
	@Autowired
	TipoCambioDAO repTC;
	
	@Autowired
	ServidorDAO repS;
	
	@Autowired
	DatosTimbradosDAO repDT;
	
		@Override
	public void actualizar(NotaCredito nc) throws DataAccessException {
		repNc.actualizar(nc);
		
	}

	@Override
	public NotaCreditoVista buscar(int id) throws DataAccessException {
		return repNc.buscar(id);
	}

	@Override
	public List<NotaCreditoVista> consultar() throws DataAccessException {
		return repNc.consultar();
	}

	@Override
	public NotaCreditoVista crearNotasCredito(DocumentoAplicarNotasCredito doc) {
		int id = repNc.crearNotasCredito(doc.toString());
		return repNc.buscar(id);
	}

	@Override
	public void RestablecerNotaCredito(int id, int modificado_por) {
		repNc.RestablecerNotaCredito(id, modificado_por);		
	}
	
	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		return repNc.obtenerJSONTimbrado(id,modo);
	}
	
	@Override
	public void actualizarNumero(int id, int opcion) {
		repNc.actualizarNumero(id,opcion);
	}

	@Override
	public NotaCreditoVista buscarPorNumero(int numero) {
		return repNc.buscarPorNumero(numero);
	}

	@Override
	public List<NotaCreditoVista> consultarSinTimbrar() {
		return repNc.consultarSinTimbrar();
	}

	@Override
	public Integer buscarUltimoId() {
		return repNc.buscarUltimoId();
	}

	@Override
	@Transactional
	public NotaCreditoVista timbrarDB(int id, String jsonAPI, int creado_por) throws JSONException, Exception {
	
		JSONObject jsonRespuesta = new JSONObject(jsonAPI);
	    String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		
		if(estatusDocumento.equalsIgnoreCase("aceptado")){
			NotaCreditoVista notaCredito=repNc.buscar(id);
		  	//Actualizar estado de la factura a Timbrado
			if(notaCredito.getEstado().equalsIgnoreCase("I")){
				actualizarEstado(id, "T");
				//int folioInterno=Integer.parseInt(json_AckEnlaceFiscal.getString("folioInterno"));
				//actualizarNumero(id,folioInterno);
			}
		   	
		   	//Actualizar el tipo_cambio de la Factura a cambio del dia que se genera en el JSON del PA
		   	if(notaCredito.getTipo_cambio().intValueExact() == 0){
		   		
		   		float tipo_cambio=1;
		   		
			   	if(!repNc.obtenerMoneda(id).equals("MXN")) {
			   		tipo_cambio=repTC.buscarPorFecha(repS.obtenerfecha()).getTipo_cambio();	
			   	}

		   		repNc.actualizarTipoCambio(id,tipo_cambio);
		   	}
		   	
		    //Insertar registro en Datos Timbrados
		   	if(notaCredito.getDatos_timbrado_id()==0){
		   		DatosTimbrados dt=new DatosTimbrados();
			   	dt.setFolio_fiscal((String) json_AckEnlaceFiscal.getString("folioFiscalUUID"));
			   	dt.setFecha((String) json_AckEnlaceFiscal.getString("fechaTFD"));
			   	dt.setSello_emisor((String) json_AckEnlaceFiscal.getString("selloCFDi"));
			   	dt.setCadena_original((String) json_AckEnlaceFiscal.getString("cadenaTFD"));
			   	dt.setSello_sat((String) json_AckEnlaceFiscal.getString("selloSAT"));
			   	dt.setLeyenda("leyenda");
			   	dt.setActivo(1);
			   	dt.setCreado_por(creado_por);
			   	int idDatosTimbrados=repDT.crear(dt);		    	
			   	//Actualizar DATOS_TIMBRADO_id
			   	repNc.actualizarIdDatosTimbrados(id, idDatosTimbrados);
		   	}
		   	
		}
		return repNc.buscar(id);
	}

	@Override
	public void actualizarEstado(int id, String estado) {
		repNc.actualizarEstado(id,estado);
	}

}
