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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoDetalleGarantia;
import com.turbomaquinas.POJO.calidad.GarantiaOrden;
import com.turbomaquinas.service.calidad.DetalleGarantiaService;

@RestController
@RequestMapping("/calidad/detalle-garantia")
public class WSDetalleGarantia {
	
	private static final Log bitacora = LogFactory.getLog(WSGarantias.class);
	
	@Autowired
	DetalleGarantiaService dgs;
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleGarantiaVista> buscarDetalleGarantia(@PathVariable int id){
		DetalleGarantiaVista dgv = null;
		try {
			dgv = dgs.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<DetalleGarantiaVista> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<DetalleGarantiaVista> (dgv, HttpStatus.OK);
	}
	
	
	@PutMapping("/actualizar")
	public ResponseEntity<List<DocumentoDetalleGarantia>> actualizarDetalles(@RequestBody List<DocumentoDetalleGarantia> actividades){
		try {
			dgs.actualizarDetalles(actividades);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<DocumentoDetalleGarantia>> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<DocumentoDetalleGarantia>> (HttpStatus.OK);
	}
	
	@GetMapping("/sinOIT/orden/{idOrden}")
	public ResponseEntity<List<GarantiaOrden>> consultarPorOrdenSinOIT(@PathVariable int idOrden){
		List<GarantiaOrden> go = null;
		try{
			go = dgs.consultarPorOrdenSinOIT(idOrden);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<GarantiaOrden>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<GarantiaOrden>>(go, HttpStatus.OK);
	}
}
