package com.turbomaquinas.REST.comercial;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.comercial.DocumentoAplicarNotasCredito;
import com.turbomaquinas.POJO.comercial.NotaCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;
import com.turbomaquinas.service.comercial.NotaCreditoService;

@RestController
@RequestMapping("/comercial/notacredito")
public class WSNotaCredito {
	
	private static final Log bitacora = LogFactory.getLog(WSNotaCredito.class);
	
	@Autowired
	NotaCreditoService s;

	@PutMapping
	public ResponseEntity<Void> actualizar(NotaCredito nc){
		bitacora.info(nc);
		try {
			s.actualizar(nc);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NotaCreditoVista> buscar(@PathVariable int id){
		NotaCreditoVista nc = null;
		try {
			nc = s.buscar(id);
			
			if (nc == null) {
				return new ResponseEntity<NotaCreditoVista> (HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<NotaCreditoVista> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<NotaCreditoVista> (nc, HttpStatus.OK);
	}
	
	@GetMapping("/numero/{numero}")
	public ResponseEntity<NotaCreditoVista> buscarPorNumero(@PathVariable int numero) {
		
		NotaCreditoVista nc = null;
		try {
			nc = s.buscarPorNumero(numero);
			
			if (nc == null) {
				return new ResponseEntity<NotaCreditoVista> (HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<NotaCreditoVista> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<NotaCreditoVista> (nc, HttpStatus.OK);
		
	}

	@GetMapping
	public ResponseEntity<List<NotaCreditoVista>> consultar(){
		
		List<NotaCreditoVista> lnc = s.consultar();
		if (lnc.isEmpty())
			return new ResponseEntity<List<NotaCreditoVista>> (HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<NotaCreditoVista>> (lnc, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<NotaCreditoVista> crear(@RequestBody DocumentoAplicarNotasCredito doc){
		NotaCreditoVista nc = null;
		try{
			nc = s.crearNotasCredito(doc);
			
			return new ResponseEntity<NotaCreditoVista>(nc, HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<NotaCreditoVista>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> restablecer(@PathVariable int id,@RequestParam int modificado_por){
		
		try{
			s.RestablecerNotaCredito(id,modificado_por);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
	}
	
	@GetMapping("/sintimbrar/ultimo")
	public ResponseEntity<Integer> buscarUltimoId(){
		
		Integer up = 0;
		try {
			up = s.buscarUltimoId();
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(up, HttpStatus.OK);
	}
	
	
	@GetMapping("/sintimbrar")
	public ResponseEntity<List<NotaCreditoVista>> consultarSinTimbrar(){
		List<NotaCreditoVista> lnc = s.consultarSinTimbrar();
		if (lnc.isEmpty())
			return new ResponseEntity<List<NotaCreditoVista>> (HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<NotaCreditoVista>> (lnc, HttpStatus.OK);
	}
	
	@PutMapping("{id}/timbrado")
	public ResponseEntity<NotaCreditoVista> timbrarDB(@PathVariable int id,@RequestBody String jsonAPI,@RequestParam int creado_por){
		NotaCreditoVista notaCredito=null;
		try {
			notaCredito=s.timbrarDB(id,jsonAPI,creado_por);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<NotaCreditoVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<NotaCreditoVista>(notaCredito,HttpStatus.OK);
	}
	
	@GetMapping("/fechas/{estado}")
	public ResponseEntity<List<NotaCreditoVista>> consultarPorFechas(@RequestParam String fechainicio, @RequestParam String fechafin, @PathVariable String estado){
		List<NotaCreditoVista> p = s.consultarPorFecha(fechainicio, fechafin, estado);
		if (p.isEmpty())
			return new ResponseEntity<List<NotaCreditoVista>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<NotaCreditoVista>>(p, HttpStatus.OK);

	}

}
