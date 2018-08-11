package com.turbomaquinas.REST.general;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.DAO.general.JDBCActividadAutorizada.Facts;
import com.turbomaquinas.POJO.general.ActividadAutorizada;
import com.turbomaquinas.POJO.general.ActividadAutorizada.ListaFacts;
import com.turbomaquinas.POJO.general.ActividadAutorizadaFactura;
import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;
import com.turbomaquinas.POJO.general.DocumentoAAPedidoPrepedido;
import com.turbomaquinas.service.general.ActividadAutorizadaService;

@RestController
@RequestMapping("/general/actividadautorizada")
public class WSActividadAutorizada {
	
	private static final Log bitacora = LogFactory.getLog(WSActividadAutorizada.class);
	
	@Autowired
	ActividadAutorizadaService s;
	
	@PostMapping()
	public ResponseEntity<ActividadAutorizadaVista> crear(@RequestBody ActividadAutorizada actividadAutorizada){
		ActividadAutorizadaVista respuesta = null;
		bitacora.info(actividadAutorizada);
		try{
			respuesta = s.crear(actividadAutorizada);
			return new ResponseEntity<ActividadAutorizadaVista>(respuesta, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<ActividadAutorizadaVista>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping()
	public ResponseEntity<Void> actualizar(@RequestBody ActividadAutorizada actividadAutorizada){
		bitacora.info(actividadAutorizada);
		try{
		s.actualizar(actividadAutorizada);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<ActividadAutorizadaVista>> consultar(){
		List<ActividadAutorizadaVista> av = null;
		try{
			av = s.consultar();
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(av, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ActividadAutorizadaVista> buscar(@PathVariable ("id") int id){
		ActividadAutorizadaVista av = null;
		try{
			av = s.buscar(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<ActividadAutorizadaVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ActividadAutorizadaVista>(av, HttpStatus.OK);
	}

	@GetMapping("/autorizaciones/{id}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorAutorizacion(@PathVariable ("id") int id){
		List<ActividadAutorizadaVista> apa = null;
		try{
			apa = s.consultarPorAutorizacion(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(apa, HttpStatus.OK);
	}
	
	@GetMapping("/cotizaciones/{id}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorCotizacion(@PathVariable ("id") int id){
		List<ActividadAutorizadaVista> apc = null;
		try{
			apc = s.consultarPorCotizacion(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(apc, HttpStatus.OK);
	}
	
	@PutMapping("/pedido")
	public ResponseEntity<Void> regularizarPedidoPrepedido(@RequestBody DocumentoAAPedidoPrepedido doc){
		//bitacora.info(doc);
		try{
			s.actualizarPedidoPrepedido(doc);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/ordenes/{id}/clase/{clase}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorOrdenFiltradaPorClase(@PathVariable ("id") int id, @PathVariable ("clase") String clase){
		List<ActividadAutorizadaVista> apo = null;
		try{
			apo = s.consultarPorOrdenFiltradaPorClase(id, clase);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(apo, HttpStatus.OK);
	}
	
	@GetMapping("/ordenes/{id}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorOrden(@PathVariable ("id") int id){
		List<ActividadAutorizadaVista> apo = null;
		try{
			apo = s.consultarPorOrden(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(apo, HttpStatus.OK);
	}
	
	@GetMapping("/sinpedido/ordenes/{id}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorOrdenSinPedido(@PathVariable int id){
		List<ActividadAutorizadaVista> a = null;
		try{
			a = s.consultarAAPorOrdenSinPedido(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(a, HttpStatus.OK);
	}
	
	@GetMapping("/otirregular/{id}")
	public ResponseEntity<List<ActividadAutorizadaVista>> consultarPorOTI(@PathVariable int id){
		List<ActividadAutorizadaVista> av = null;
		try{
			av = s.consultarPorOtiSinAceptar(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ActividadAutorizadaVista>>(av, HttpStatus.OK);
	}
	
	@GetMapping("/factura/pendiente/ordenes/{id}")
	public ResponseEntity<List<ActividadAutorizadaFactura>> consultarAAPorOrdenPendienteFacturar(@PathVariable int id){
		List<ActividadAutorizadaFactura> aaof = null;
		try{
			aaof = s.consultarAAPorOrdenPendienteFacturar(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaFactura>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActividadAutorizadaFactura>>(aaof, HttpStatus.OK);
	}

	@PutMapping("/{id}/facturas")
	public ResponseEntity<Void> asignarFacts(@PathVariable int id, @RequestBody ListaFacts lista){
		bitacora.info(lista);
		try {
			s.asignarFacts(id, lista);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/{id}/facturas")
	public ResponseEntity<List<Facts>> consultarFacts(@PathVariable int id){
		List<Facts> facts = null;
		try {
			facts = s.consultarFacts(id);
			return new ResponseEntity<List<Facts>>(facts, HttpStatus.OK);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Facts>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/actividades")
	public ResponseEntity<List<ActividadAutorizadaFactura>> consultarAAPorIds(@RequestParam List<Integer> idsActividades){
		List<ActividadAutorizadaFactura> actividades = null;
		try {
			actividades = s.consultarAAPorIds(idsActividades);
			return new ResponseEntity<List<ActividadAutorizadaFactura>>(actividades, HttpStatus.OK);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<ActividadAutorizadaFactura>>(HttpStatus.NOT_FOUND);
		}
	}

}
