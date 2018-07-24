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

import com.turbomaquinas.POJO.comercial.DocumentoAplicarPago;
import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;
import com.turbomaquinas.service.comercial.PagosService;

@RestController
@RequestMapping("/comercial/pagos")
public class WSPagos {
	
	private static final Log bitacora = LogFactory.getLog(WSPagos.class);
	
	@Autowired
	PagosService s;
	

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Pagos p){
		
		bitacora.info(p);
		try {
			s.actualizar(p);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PagosVista> buscar(@PathVariable int id){
		
		PagosVista pb = null;
		try {
			pb = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<PagosVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PagosVista>(pb, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PagosVista>> consultar(){
		List<PagosVista> pl = s.consultar();
		if ( pl == null)
			return new ResponseEntity<List<PagosVista>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PagosVista>>(pl, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> aplicar(@RequestBody DocumentoAplicarPago doc){
		
		
		try{
			s.aplicarPagos(doc);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/fechas")
	public ResponseEntity<List<Pagos>> consultarPorFechas(@RequestParam String fechainicio,@RequestParam String fechafin){
		List<Pagos> p = s.pagosFecha(fechainicio,fechafin);
		if (p.isEmpty())
			return new ResponseEntity<List<Pagos>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Pagos>>(p, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/facturas")
	public ResponseEntity<List<PagosFacturas>> facturasPagadas(@PathVariable int id){
		List<PagosFacturas> pf = s.facturasPorPago(id);
		if ( pf == null)
			return new ResponseEntity<List<PagosFacturas>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PagosFacturas>>(pf, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> restablecer(@PathVariable int id){
		
		
		try{
			s.restablecerPago(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/ultimo")
	public ResponseEntity<Integer> buscarIdUltimoPago(){
		
		Integer up = 0;
		try {
			up = s.ultimoPago();
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(up, HttpStatus.OK);
	}
}