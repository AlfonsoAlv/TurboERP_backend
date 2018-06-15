package com.turbomaquinas.REST.timbrado;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.turbomaquinas.service.comercial.FacturaFinalService;
import com.turbomaquinas.service.timbrado.LogicaTimbrado;
import com.turbomaquinas.service.timbrado.TimbradoService;

import twitter4j.JSONObject;


@RestController
@RequestMapping("/timbrado")
public class WSTimbrado {

	private static final Log bitacora = LogFactory.getLog(WSTimbrado.class);
	
	@Autowired
	TimbradoService ts;
	
	@Autowired
	FacturaFinalService ffs;
	
	@Autowired
	LogicaTimbrado lt;
	
	@PostMapping("/facturafinal/{id}")
	public ResponseEntity<String> timbrarFacturaFinal(@PathVariable int id,@RequestParam int numEmpleado,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			cfdi=ffs.obtenerJSONFacturaFinal(id,modo);//mandar modo
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
        try{
        	ResponseEntity<String> response=ts.timbrarFacturaFinal(cfdi,id,numEmpleado,modo);
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);}
        
	}
	
	@PostMapping("/facturafinal/{id}/cancelar")
	public ResponseEntity<String> cancelarCFDiFacturaFinal(@PathVariable int id,@RequestParam int numEmpleado,@RequestParam String modo,@RequestParam String justificacion) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			cfdi=ffs.obtenerJSONCancelarFacturaFinal(id,modo,justificacion);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		try{
        	ResponseEntity<String> response=ts.cancelarCFDiFacturaFinal(cfdi);
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);}
        
	}
	
	@GetMapping("/facturafinal/{id}")
	public ResponseEntity<String> buscarFacturaFinal(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			cfdi=ffs.obtenerJSONFacturaFinal(id,modo);//mandar modo
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
        try{
        	ResponseEntity<String> response=lt.timbrar(ffs.obtenerJSONFacturaFinal(id, modo));
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);}
        
	}
	
	
}
