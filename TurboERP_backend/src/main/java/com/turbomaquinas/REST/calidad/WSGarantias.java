package com.turbomaquinas.REST.calidad;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoActividadesGarantia;
import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;
import com.turbomaquinas.POJO.calidad.EstadoCierreFoco;
import com.turbomaquinas.POJO.calidad.GarantiaVista;
import com.turbomaquinas.POJO.calidad.PorcentajeActividades;
import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;
import com.turbomaquinas.service.calidad.GarantiaService;

@RestController
@RequestMapping("calidad/garantias")
public class WSGarantias {
	
	private static final Log bitacora = LogFactory.getLog(WSGarantias.class);

	@Autowired
	GarantiaService gs;
	
	@GetMapping("/{id}")
	public ResponseEntity<GarantiaVista> buscarGarantia(@PathVariable int id){
		GarantiaVista gv = null;
		try {
			gv = gs.buscarGarantia(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<GarantiaVista> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<GarantiaVista> (gv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/encabezados")
	public ResponseEntity<List<EncabezadoGarantiaVista>> consultarEncabezados(@PathVariable int id){
		List<EncabezadoGarantiaVista> egv = null;
		try {
			egv = gs.consultarEncabezados(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<EncabezadoGarantiaVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EncabezadoGarantiaVista>> (egv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/detalles")
	public ResponseEntity<List<DetalleGarantiaVista>> consultarDetalles(@PathVariable int id){
		List<DetalleGarantiaVista> dgv = null;
		try {
			dgv = gs.consultarDetalles(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<DetalleGarantiaVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DetalleGarantiaVista>> (dgv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/subindices")
	public ResponseEntity<List<SubindiceGarantiaVista>> consultarSubindices(@PathVariable int id){
		List<SubindiceGarantiaVista> sgv = null;
		try {
			sgv = gs.consultarSubindices(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<SubindiceGarantiaVista>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SubindiceGarantiaVista>> (sgv, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/cantidad")
	public ResponseEntity<Integer> contarEncabezados(@PathVariable int id){
		int cantidad = 0;
		try {
			cantidad = gs.consultarCantidadEncabezados(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Integer> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Integer> (cantidad, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/focos")
	public ResponseEntity<List<Integer>> focosPorGarantia(@PathVariable("id") int id) {
		
		List<Integer> focosIds;
		
		try {
			focosIds = gs.obtenerFocos(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Integer>>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<List<Integer>> (focosIds, HttpStatus.OK);
		
	}
	
	@GetMapping("/estadocierre/foco/{focoId}")
	public ResponseEntity<EstadoCierreFoco> obtenerEstadoCierreFoco(@PathVariable("focoId") int focoId) {
		
		EstadoCierreFoco ecf = null;
		
		try {
			ecf = gs.obtenerEstadoCierreFoco(focoId);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<EstadoCierreFoco>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EstadoCierreFoco>(ecf, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/porcentajeactividades")
	public ResponseEntity<PorcentajeActividades> obtenerPorcentajeActividades(@PathVariable("id") int garantiaId) {
		
		PorcentajeActividades pa = new PorcentajeActividades();
		
		try {
			pa = gs.obtenerPorcentajeActividades(garantiaId);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<PorcentajeActividades>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PorcentajeActividades>(pa, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Integer> crear(@RequestBody DocumentoActividadesGarantia obj_actividades_Garantia){
		
		int idGarantia = 0;
		try{
			idGarantia = gs.crearActividadesGarantia(obj_actividades_Garantia);
			
			return new ResponseEntity<Integer>(idGarantia,HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
		}
	}

}
