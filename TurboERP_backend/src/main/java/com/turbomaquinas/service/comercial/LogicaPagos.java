package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.DatosTimbradosDAO;
import com.turbomaquinas.DAO.comercial.FacturaFinalDAO;
import com.turbomaquinas.DAO.comercial.FacturaVariosDAO;
import com.turbomaquinas.DAO.comercial.PagosDAO;
import com.turbomaquinas.POJO.comercial.DatosTimbrados;
import com.turbomaquinas.POJO.comercial.DocumentoAplicarPago;
import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosDetalle;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class LogicaPagos implements PagosService {

	@Autowired
	PagosDAO resPago;
	
	@Autowired
	DatosTimbradosDAO repoDT;
	
	@Autowired
	FacturaFinalDAO repFF;
	
	@Autowired
	FacturaVariosDAO repFV;
	

	@Override
	public Pagos actualizar(Pagos p) throws DataAccessException {
		return resPago.actualizar(p);
	}

	@Override
	public PagosVista buscar(int id) throws DataAccessException {
		return resPago.buscar(id);
	}

	@Override
	public List<PagosVista> consultar() throws DataAccessException {
		return resPago.consultar();
	}

	@Override
	public void aplicarPagos(DocumentoAplicarPago doc) throws DataAccessException{
		
		resPago.AplicarPagos(doc.toString());
		
		
	}

	@Override
	public List<Pagos> pagosFecha(String fechainicio, String fechafin) throws DataAccessException {
		
		return resPago.pagoRangoFecha(fechainicio, fechafin);
	}

	@Override
	public List<PagosFacturas> facturasPorPago(int id) throws DataAccessException{
		
		return resPago.facturasPagadas(id);
	}

	@Override
	public void restablecerPago(int id) {
		resPago.RestablecerPago(id);
		
	}
	
	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		return resPago.obtenerJSONTimbrado(id,modo);
	}

	@Override
	public Integer ultimoPago() {
		return resPago.obtenerUltimoIdPago();
	}

	@Override
	public List<Pagos> pendientesTimbrar() {
		return resPago.pendientesTimbrar();
	}
	
	@Override
	public void actualizarNumero(int id, int opcion) {
		resPago.actualizarNumero(id,opcion);
	}

	@Override
	@Transactional
	public PagosVista timbrarDB(int id, String jsonAPI, int creado_por) throws JSONException{
		//System.out.println(id+"-"+jsonAPI+"-"+creado_por);
		
		JSONObject jsonRespuesta = new JSONObject(jsonAPI);
	    String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		
		if(estatusDocumento.equalsIgnoreCase("aceptado")){
			//System.out.println("B");
			PagosVista pago=resPago.buscar(id);
		  	//Actualizar estado de la factura a Timbrado
			if(pago.getEstado().equalsIgnoreCase("I")){
				actualizarEstado(id, "T");
				//actualizarNumero(id,folioInterno);
			}
		   	
			//Actualizar parcialidad e importe_timbrado en factura final y varios
			List<PagosDetalle> pd=resPago.detallesPago(pago.getId());
			for(PagosDetalle pagoDetalle:pd){
				if(pagoDetalle.getFactura_final_id()!=0){
					repFF.actualizarParcialidadImporteTimbrado(pagoDetalle.getImporte(),pagoDetalle.getFactura_final_id());
					
				}else if(pagoDetalle.getFactura_varios_id()!=0){
					repFV.actualizarParcialidadImporteTimbrado(pagoDetalle.getImporte(),pagoDetalle.getFactura_varios_id());
				}
			}
		   	
		    //Insertar registro en Datos Timbrados
		   	if(pago.getDatos_timbrado_id()==0){
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
			   	resPago.actualizarIdDatosTimbrados(id, idDatosTimbrados);
		   	}
		   	
		   	
		}
		return resPago.buscar(id);
	}

	@Override
	public void actualizarEstado(int id, String estado) {
		resPago.actualizarEstado(id,estado);
		
	}

	@Override
	public List<PagosDetalle> detallesPago(int id) {
		return resPago.detallesPago(id);
	}

	@Override
	public String obtenerJSONCancelarPagos(int id, String modo, String justificacion) {
		return resPago.obtenerJSONCancelarPagos(id,modo,justificacion);
	}

	@Override
	public String obtenerJSONBuscarPagos(int id, String modo) {
		return resPago.obtenerJSONBuscarPagos(id,modo);
	}

	@Override
	public void cancelar(int id, int modificado_por) {
		resPago.cancelar(id, modificado_por);
	}
	

}
