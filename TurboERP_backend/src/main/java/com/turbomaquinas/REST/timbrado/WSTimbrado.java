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
import com.turbomaquinas.service.comercial.FacturaVariosService;
import com.turbomaquinas.service.comercial.NotaCreditoService;
import com.turbomaquinas.service.comercial.PagosService;
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
	
	@Autowired
	FacturaVariosService fvs;
	
	@Autowired
	PagosService ps;
	
	@Autowired
	NotaCreditoService ncs;
	
	
	//FACTURA FINAL/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/facturafinal/{id}")
	public ResponseEntity<String> timbrarFacturaFinal(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			if(modo.equals("produccion") && ffs.buscar(id).getNumero()==0){
				ffs.actualizarNumero(id,1);
			}
			cfdi=ffs.obtenerJSONFacturaFinal(id,modo);//mandar modo
			//cfdi=cfdi+"}";
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        try{
        	ResponseEntity<String> response=ts.timbrarFacturaFinal(cfdi);
        	System.out.println(response.getBody());
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	ffs.actualizarNumero(id,0);
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){
        	ffs.actualizarNumero(id,0);
        	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }
        
	}
	
	@PostMapping("/facturafinal/{id}/cancelacion")
	public ResponseEntity<String> cancelarCFDiFacturaFinal(@PathVariable int id,@RequestParam String modo,@RequestParam String justificacion) throws JsonParseException, JsonMappingException, IOException{
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
			cfdi=ffs.obtenerJSONBuscarFacturaFinal(id,modo);//mandar modo
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
        try{
        	ResponseEntity<String> response=ts.buscarFacturaFinal(cfdi);
        	System.out.println(response.getBody());
        	JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NO_CONTENT);
		    }else{
		    	return null;
		    }
        }catch(Exception e){return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);}
        
	}
	
	
	//FACTURA VARIOS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/facturavarios/{id}")
	public ResponseEntity<String> timbrarFacturaVarios(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			if(modo.equals("produccion") && fvs.buscar(id).getNumero()==0){
				fvs.actualizarNumero(id,1);
			}
			cfdi=fvs.obtenerJSONFacturaVarios(id,modo);//mandar modo
			//cfdi=cfdi+"}";
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        try{
        	ResponseEntity<String> response=ts.timbrarFacturaVarios(cfdi);
        	System.out.println(response.getBody());
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	fvs.actualizarNumero(id,0);
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){
        	fvs.actualizarNumero(id,0);
        	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }
        
	}
	
	@PostMapping("/facturavarios/{id}/cancelacion")
	public ResponseEntity<String> cancelarCFDiFacturaVarios(@PathVariable int id,@RequestParam String modo,@RequestParam String justificacion) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			cfdi=fvs.obtenerJSONCancelarFacturaVarios(id,modo,justificacion);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		try{
        	ResponseEntity<String> response=ts.cancelarCFDiFacturaVarios(cfdi);
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
	
	@GetMapping("/facturavarios/{id}")
	public ResponseEntity<String> buscarFacturaVarios(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			cfdi=fvs.obtenerJSONBuscarFacturaVarios(id,modo);//mandar modo
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
        try{
        	ResponseEntity<String> response=ts.buscarFacturaVarios(cfdi);
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NO_CONTENT);
		    }else{
		    	return null;
		    }
        }catch(Exception e){return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);}
        
	}
	
	
	//PAGOS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/pago/{id}")
	public ResponseEntity<String> timbrarPago(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			if(modo.equals("produccion") && ps.buscar(id).getNumero()==0){
				ps.actualizarNumero(id,1);
			}
			cfdi=ps.obtenerJSONTimbrado(id,modo);//mandar modo
			//cfdi=cfdi+"}";
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        try{
        	ResponseEntity<String> response=ts.timbrarPago(cfdi);
        	System.out.println(response.getBody());
	        JSONObject jsonRespuesta = new JSONObject(response.getBody());
	        String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
		    JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
		    String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
		    if(estatusDocumento.equalsIgnoreCase("aceptado")){
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
		    }else if(estatusDocumento.equalsIgnoreCase("rechazado")){
		    	ffs.actualizarNumero(id,0);
		    	return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
		    }else{
		    	return null;
		    }
        }catch(Exception e){
        	ps.actualizarNumero(id,0);
        	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }        
	}
	
	
	
	
	
	//Nota de Credito/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/notacredito/{id}")
	public ResponseEntity<String> timbrarNotaCredito(@PathVariable int id,@RequestParam String modo) throws JsonParseException, JsonMappingException, IOException{
		//Recuperar JSON del PA TIMBRADO_FACTURA		
		String cfdi=null;
		try{
			if(modo.equals("produccion") && ncs.buscar(id).getNumero()==0){
				ncs.actualizarNumero(id,1);
			}
			cfdi=ncs.obtenerJSONTimbrado(id,modo);
			//cfdi=cfdi+"}";
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    try{
	    	ResponseEntity<String> response=ts.timbrarNotaCredito(cfdi);
	        System.out.println(response.getBody());
		    JSONObject jsonRespuesta = new JSONObject(response.getBody());
		    String AckEnlaceFiscal=(String) jsonRespuesta.getString("AckEnlaceFiscal");
			JSONObject json_AckEnlaceFiscal = new JSONObject(AckEnlaceFiscal);
			String estatusDocumento=(String) json_AckEnlaceFiscal.getString("estatusDocumento");
			if(estatusDocumento.equalsIgnoreCase("aceptado")){
				return new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
			}else if(estatusDocumento.equalsIgnoreCase("rechazado")){
				ffs.actualizarNumero(id,0);
			    return new ResponseEntity<String>(response.getBody(),HttpStatus.NOT_ACCEPTABLE);
			}else{
			   	return null;
			}
	    }catch(Exception e){
	       	ncs.actualizarNumero(id,0);
	       	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE); 
	    }
	}
	
	
}
