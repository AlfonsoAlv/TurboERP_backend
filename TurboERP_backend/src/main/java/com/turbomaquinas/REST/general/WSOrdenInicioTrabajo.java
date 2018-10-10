package com.turbomaquinas.REST.general;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;
import com.turbomaquinas.service.general.OrdenInicioTrabajoService;

@RestController
@RequestMapping("/general/oit")
public class WSOrdenInicioTrabajo {
	
	private static final Log bitacora = LogFactory.getLog(WSOrden.class);
	
	@Autowired
	OrdenInicioTrabajoService oits;
	
	@GetMapping("/consultar-filtros")
	public ResponseEntity<List<OrdenInicioTrabajoVista>> consultarConFiltros(@RequestParam String numero_orden, @RequestParam String prioridad, @RequestParam String estado, @RequestParam String anio, @RequestParam String tipo){
		List<OrdenInicioTrabajoVista> oit = null;
		try{
			oit = oits.consultarConFiltros(numero_orden,prioridad,estado,anio,tipo);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<OrdenInicioTrabajoVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrdenInicioTrabajoVista>>(oit, HttpStatus.OK);
	}
	
	@GetMapping("/anios")
	public ResponseEntity<List<Integer>> anios(){
		List<Integer> anios = oits.anios();
		if (anios == null)
			return new ResponseEntity<List<Integer>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Integer>>(anios, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}/cancelacion")
	public ResponseEntity<Void> cancelar(@PathVariable int id, @RequestParam int modificado_por){
		try{
			oits.cancelar(id, modificado_por);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.OK);		
	}
}
