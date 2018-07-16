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

import com.turbomaquinas.POJO.comercial.DetalleFacturaVariosVista;
import com.turbomaquinas.POJO.comercial.DocumentoFacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVariosVista;
import com.turbomaquinas.service.comercial.FacturaVariosService;

@RestController
@RequestMapping("/comercial/facturavarios")
public class WSFacturaVarios {

	private static final Log bitacora = LogFactory.getLog(WSFacturaVarios.class);
	
	@Autowired
	FacturaVariosService s;
	
	@PostMapping
	public ResponseEntity<FacturaVariosVista> crearDoc(@RequestBody DocumentoFacturaVarios doc){
		FacturaVariosVista factura = null;
		try {
			factura = s.crearDoc(doc);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaVariosVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<FacturaVariosVista>(factura, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody FacturaVarios fv){

		bitacora.info(fv);
		try {
			s.actualizar(fv);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FacturaVariosVista> buscar(@PathVariable int id){
		
		FacturaVariosVista fvb = null;
		try {
			fvb = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaVariosVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaVariosVista>(fvb, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FacturaVariosVista>> consultar(){
		
		List<FacturaVariosVista> fvl = s.consultar();
		if (fvl == null)
			return new ResponseEntity<List<FacturaVariosVista>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FacturaVariosVista>>(fvl,HttpStatus.OK);
	}	

	@DeleteMapping("{id}/cancelacion")
	public ResponseEntity<Void> cancelar(@PathVariable int id, @RequestParam int modificado_por){
		try{
			s.cancelar(id, modificado_por);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	@GetMapping("/cliente/{id}/{moneda}")
	public ResponseEntity<List<FacturaVariosVista>> consultarFacturasVariosPendientesPorCliente(@PathVariable int id,@PathVariable String moneda){
		List<FacturaVariosVista> fvl = null;
		try{
			fvl = s.consultarFacturasVariosPendientesPorCliente(id,moneda);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaVariosVista>>(HttpStatus.CONFLICT);
		}
		if (fvl.isEmpty()) {
			return new ResponseEntity<List<FacturaVariosVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FacturaVariosVista>>(fvl, HttpStatus.OK);
		
	}
	
	@GetMapping("/folio/{estado}/{tipo}")
	public ResponseEntity<FacturaVariosVista> buscarFacturaFolio(@RequestParam String folio, @PathVariable String estado, @PathVariable String tipo){
		FacturaVariosVista factura = null;
		try{
			factura = s.buscarFacturaFolio(folio, estado, tipo);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaVariosVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaVariosVista>(factura, HttpStatus.OK);
	}
	
	@GetMapping("factura/{tipo}/{numero}/{estado}")
	public ResponseEntity<FacturaVariosVista> buscarPorNumero(@PathVariable String tipo, @PathVariable int numero, @PathVariable String estado){
		FacturaVariosVista ffv = null;
		try{
			ffv = s.buscarPorTipoNumero(numero, tipo,estado);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaVariosVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaVariosVista>(ffv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/detalles")
	public ResponseEntity<List<DetalleFacturaVariosVista>> consultarDetalles(@PathVariable int id){
		List<DetalleFacturaVariosVista> fvdv = null;
		try {
			fvdv = s.consultarDetalles(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<DetalleFacturaVariosVista>> (HttpStatus.CONFLICT);
		}
		if (fvdv.isEmpty()) {
			return new ResponseEntity<List<DetalleFacturaVariosVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DetalleFacturaVariosVista>> (fvdv, HttpStatus.OK);
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<FacturaVariosVista>> consultarPorEstado(@PathVariable String estado){
		List<FacturaVariosVista> fvv = null;
		try{
			fvv = s.consultarPorEstado(estado);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaVariosVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FacturaVariosVista>>(fvv, HttpStatus.OK);		
	}
	
	@PutMapping("{id}/timbrado")
	public ResponseEntity<FacturaVariosVista> timbrarDB(@PathVariable int id,@RequestBody String jsonAPI,@RequestParam int creado_por){
		FacturaVariosVista factura=null;
		try {
			factura=s.timbrarDB(id,jsonAPI,creado_por);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaVariosVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<FacturaVariosVista>(factura,HttpStatus.OK);
	}
	
}
