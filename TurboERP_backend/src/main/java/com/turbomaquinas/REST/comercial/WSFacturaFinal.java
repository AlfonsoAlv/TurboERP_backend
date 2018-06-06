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

import com.turbomaquinas.POJO.comercial.DocumentoFacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.service.comercial.FacturaFinalService;

@RestController
@RequestMapping("/comercial/facturafinal")
public class WSFacturaFinal {
	
	private static final Log bitacora = LogFactory.getLog(WSFacturaFinal.class);
	
	@Autowired
	FacturaFinalService s;
	
	
//	@PostMapping
//	public ResponseEntity<FacturaFinalVista> crear(@RequestBody DocumentoFacturaFinal documento){
//		FacturaFinalVista respuesta = null;
//		bitacora.info(documento);
//		try {
//			 respuesta = ds.crear(documento);
//		} catch (Exception e) {
//			bitacora.error(e.getMessage());
//			return new ResponseEntity<FacturaFinalVista>(HttpStatus.CONFLICT);
//		}
//		return new ResponseEntity<FacturaFinalVista>(respuesta, HttpStatus.CREATED);
//	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody FacturaFinal ff){
		bitacora.info(ff);
		try {
			s.actualizar(ff);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FacturaFinalVista> buscar(@PathVariable int id){
		FacturaFinalVista ffb = null;
		try {
			ffb = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaFinalVista>(ffb, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FacturaFinalVista>> consultar(){
		List<FacturaFinalVista> ffl = s.consultar();
		if (ffl == null)
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FacturaFinalVista>>(ffl, HttpStatus.OK);
		
	}
	
	@DeleteMapping()
	public ResponseEntity<Void> cancelar(@RequestBody FacturaFinal ff){
		try{
			s.cancelar(ff);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.OK);		
	}

	@GetMapping("factura/{tipo}/{numero}/{estado}")
	public ResponseEntity<FacturaFinalVista> buscarPorNumero(@PathVariable String tipo, @PathVariable int numero, @PathVariable String estado){
		FacturaFinalVista ffv = null;
		try{
			ffv = s.buscarPorTipoNumero(numero, tipo,estado);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaFinalVista>(ffv, HttpStatus.OK);
		
	}
	
	@GetMapping("/cliente/{id}/{moneda}")
	public ResponseEntity<List<FacturaFinalVista>> consultarFacturasPendientesPorCliente(@PathVariable int id,@PathVariable String moneda){
		List<FacturaFinalVista> ffl = null;
		try{
			ffl = s.consultarFacturasPendientesPorCliente(id,moneda);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NOT_FOUND);
		}
		if (ffl.isEmpty()) {
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FacturaFinalVista>>(ffl, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/ordenes")
	public ResponseEntity<List<OrdenFactura>> consultarOrdenes(@PathVariable int id){
		List<OrdenFactura> ordenes = null;
		try{
			ordenes = s.consultarOrdenes(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<OrdenFactura>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrdenFactura>>(ordenes, HttpStatus.OK);
		
	}
	
	@GetMapping("/folio")
	public ResponseEntity<FacturaFinalVista> buscarFacturaFolio(@RequestParam String folio,@RequestParam String estado){
		FacturaFinalVista factura = null;
		try{
			factura = s.buscarFacturaFolio(folio,estado);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaFinalVista>(factura, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> creardoc(@RequestBody DocumentoFacturaFinal doc){
		bitacora.info(doc);
		try {
			s.creardoc(doc);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
