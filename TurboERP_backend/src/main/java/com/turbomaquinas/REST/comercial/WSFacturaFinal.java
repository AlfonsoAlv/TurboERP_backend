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

import com.turbomaquinas.POJO.comercial.ActividadesFFVista;
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
	
	@GetMapping("/folio/{estado}/{tipo}")
	public ResponseEntity<FacturaFinalVista> buscarFacturaFolio(@RequestParam String folio, @PathVariable String estado, @PathVariable String tipo){
		FacturaFinalVista factura = null;
		try{
			factura = s.buscarFacturaFolio(folio, estado, tipo);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaFinalVista>(factura, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<FacturaFinalVista> creardoc(@RequestBody DocumentoFacturaFinal doc){
		FacturaFinalVista factura = null;
		try {
			factura = s.creardoc(doc);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<FacturaFinalVista>(factura, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/actividades")
   	public ResponseEntity<List<ActividadesFFVista>> buscarActividades(@PathVariable int id){
		List<ActividadesFFVista> actividades = null;
		try{
			actividades = s.consultarActividadesPorFactura(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadesFFVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadesFFVista>>(actividades, HttpStatus.OK);
       	
   	}
	
	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<FacturaFinalVista>> consultarPorEstado(@PathVariable String estado){
		List<FacturaFinalVista> ffv = null;
		try{
			ffv = s.consultarPorEstado(estado);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FacturaFinalVista>>(ffv, HttpStatus.OK);		
	}
	
	@GetMapping("/ids")
	public ResponseEntity<List<FacturaFinalVista>> consultarPorIds(@RequestParam List<Integer> lista){
		List<FacturaFinalVista> ffv = null;
		try{
			ffv = s.consultarPorIds(lista);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FacturaFinalVista>>(ffv, HttpStatus.OK);		
	}
	
	@PutMapping("/{id}/estado")
	public ResponseEntity<Void> actualizarEstado(@PathVariable int id,@RequestParam String estado){
		try {
			s.actualizarEstado(id,estado);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{tipo}/ultima")
	public ResponseEntity<FacturaFinalVista> buscarUltimaFacturaPorTipo(@PathVariable String tipo){
		FacturaFinalVista factura = null;
		try{
			factura = s.buscarUltimaFacturaPorTipo(tipo);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<FacturaFinalVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FacturaFinalVista>(factura, HttpStatus.OK);		
	}
	
	@PutMapping("/{id}/alfresco")
	public ResponseEntity<Void> actualizarIdsAlfresco(@PathVariable int id,@RequestParam String alfresco_id){
		try {
			s.actualizarIdAlfresco(id,alfresco_id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
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
	
	@DeleteMapping("{id}/baja")
	public ResponseEntity<Void> baja(@PathVariable int id, @RequestParam int modificado_por){
		try{
			s.baja(id, modificado_por);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	@PutMapping("{id}/timbrado")
	public ResponseEntity<Void> timbrarDB(@PathVariable int id,@RequestBody String jsonAPI,@RequestParam int creado_por){
		try {
			s.timbrarDB(id,jsonAPI,creado_por);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
