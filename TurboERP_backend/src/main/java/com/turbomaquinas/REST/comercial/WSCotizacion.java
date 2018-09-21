package com.turbomaquinas.REST.comercial;

import java.math.BigDecimal;
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

import com.turbomaquinas.POJO.comercial.Cotizacion;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.comercial.DetalleCotizacionVista;
import com.turbomaquinas.POJO.comercial.EncabezadoCotizacionVista;
import com.turbomaquinas.POJO.comercial.SubindiceCotizacionVista;
import com.turbomaquinas.service.comercial.CotizacionService;

@RestController
@RequestMapping("/comercial/cotizacion")
public class WSCotizacion {
	
	private static final Log bitacora = LogFactory.getLog(WSCotizacion.class);
	
	@Autowired
	CotizacionService s;
	
	@PostMapping
	public ResponseEntity<CotizacionVista> crear(@RequestBody Cotizacion c) {
		
		CotizacionVista respuesta = null;
		bitacora.info(c);
		try {
			respuesta = s.crear(c);
			return new ResponseEntity<CotizacionVista>(respuesta, HttpStatus.CREATED);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<CotizacionVista>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Cotizacion c){
		bitacora.info(c);
		try {
			s.actualizar(c);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CotizacionVista> buscar(@PathVariable int id){
		CotizacionVista cv = null;
		try {
			cv = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<CotizacionVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CotizacionVista>(cv, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CotizacionVista>> consultar(){
		List<CotizacionVista> col = s.consultar();
		if (col == null)
			return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<CotizacionVista>>(col, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/encabezados")
	public ResponseEntity<List<EncabezadoCotizacionVista>> consultarEncabezados(@PathVariable int id){
		List<EncabezadoCotizacionVista> epv = null;
		try {
			epv = s.consultarEncabezados(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<EncabezadoCotizacionVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EncabezadoCotizacionVista>> (epv, HttpStatus.OK);
	}

	@GetMapping("/{id}/detalles")
	public ResponseEntity<List<DetalleCotizacionVista>> consultarDetalles(@PathVariable int id){
		List<DetalleCotizacionVista> dpv = null;
		try {
			dpv = s.consultarDetalles(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<DetalleCotizacionVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DetalleCotizacionVista>> (dpv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/subindices")
	public ResponseEntity<List<SubindiceCotizacionVista>> consultarSubindices(@PathVariable int id){
		List<SubindiceCotizacionVista> spv = null;
		try {
			spv = s.consultarSubindices(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<SubindiceCotizacionVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SubindiceCotizacionVista>> (spv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/cantidad")
	public ResponseEntity<Integer> contarEncabezados(@PathVariable int id){
		int cantidad = 0;
		try {
			cantidad = s.consultarCantidadEncabezados(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Integer> (cantidad, HttpStatus.OK);
	}
	
	
	@PostMapping("/{id}/encabezados_preco")
	public ResponseEntity<Void> importarPrecotizacion(@RequestBody List<Integer> lista, @PathVariable int id, @RequestParam int creado_por ){
		try {
			s.importar(lista, id, creado_por); 
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarDescuento(@PathVariable int id, @RequestParam BigDecimal descuento, @RequestParam int modificado_por ){
		try {
			bitacora.info(descuento);
			s.actuadescto(id, descuento, modificado_por);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/{id}/encabezados_diag")
	public ResponseEntity<Void> importarDiagnostico(@RequestBody List<Integer> lista, @PathVariable int id, @RequestParam int creado_por ){
		try {
			s.importardiag(lista, id, creado_por); 
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/años")
	public ResponseEntity<List<Integer>> aniosCotizados(){
		List<Integer> anios = s.anioCot();
		if (anios == null)
			return new ResponseEntity<List<Integer>> (HttpStatus.CONFLICT);
		return new ResponseEntity<List<Integer>>(anios, HttpStatus.OK);
	}
	
	@GetMapping("/filtradas/{anio}")
	public ResponseEntity<List<CotizacionVista>> cotizacionPorAnio(@PathVariable int anio){
		List<CotizacionVista> cv = s.cotAnio(anio);
		if (cv == null)
			return new ResponseEntity<List<CotizacionVista>> (HttpStatus.CONFLICT);
		return new ResponseEntity<List<CotizacionVista>>(cv, HttpStatus.OK);
	}
	
	@GetMapping("/numero")
	public ResponseEntity<CotizacionVista> buscarPorNumero(@RequestParam String numeroCotizacion){
		CotizacionVista cv = null;
		try{
			cv = s.buscarCotizacion(numeroCotizacion);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<CotizacionVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CotizacionVista>(cv, HttpStatus.OK);
	}

	@PostMapping("/{id}/encabezados_cotiza")
	public ResponseEntity<Void> importarCotizacion(@RequestBody List<Integer> lista, @PathVariable int id, @RequestParam int creado_por ){
		try {
			s.importarcot(lista, id, creado_por);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/version")
	public ResponseEntity<CotizacionVista> buscarPorVersion(@RequestParam String numeroCot, int rev){
		CotizacionVista cvv = null;
		try{
			cvv = s.buscarRevisionCotizacion(numeroCot, rev);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<CotizacionVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CotizacionVista>(cvv, HttpStatus.OK);
	}

	@GetMapping("/{id_original}/revisiones")
	public ResponseEntity<List<Integer>> consultarRevisiones(@PathVariable int id_original){
		List<Integer> cv = s.revisiones(id_original);
		if (cv == null)
			return new ResponseEntity<List<Integer>> (HttpStatus.CONFLICT);
		return new ResponseEntity<List<Integer>>(cv, HttpStatus.OK);
	}

	@GetMapping("/precotizacion/{id}")
	public ResponseEntity<List<CotizacionVista>> buscarPorPrecotizacion(@PathVariable int id){
		List<CotizacionVista> cv = null;
		try{
			cv = s.buscarCotizacionPorPrecotizacion(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CotizacionVista>>(cv, HttpStatus.OK);	
	}

	@GetMapping("/orden/{id}")
	public ResponseEntity<List<CotizacionVista>> buscarPorOrden(@PathVariable int id){
		List<CotizacionVista> cv = null;
		try{
			cv = s.buscarCotizacionPorOrden(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CotizacionVista>>(cv, HttpStatus.OK);	
	}

	@GetMapping("/sinautorizar/cliente/{id}/{moneda}")
	public ResponseEntity<List<CotizacionVista>> buscarCotizacionPorClienteSinAutorizar(@PathVariable int id, @PathVariable String moneda){
		List<CotizacionVista> cvc = null;
		try{
			cvc = s.buscarCotizacionPorClienteSinAutorizar(moneda, id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CotizacionVista>>(cvc, HttpStatus.OK);	
	}

	@GetMapping("/sinautorizar/orden/{id}")
	public ResponseEntity<List<CotizacionVista>> buscarCotizacionPorOrdenSinAutorizar(@PathVariable int id){
		List<CotizacionVista> cvo = null;
		try{
			cvo = s.buscarCotizacionPorOrdenSinAutorizar(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CotizacionVista>>(cvo, HttpStatus.OK);	
	}
}
