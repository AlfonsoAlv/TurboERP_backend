package com.turbomaquinas.REST.comercial;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletes;
import com.turbomaquinas.service.comercial.EquipoSolicitudFletesService;

@RestController
@RequestMapping("/comercial/eqsolicitud-fletes")
public class WSEquipoSolicitudFletes {
	
private static final Log bitacora = LogFactory.getLog(WSEquipoSolicitudFletes.class);
	
	@Autowired
	EquipoSolicitudFletesService ers;
	
	@PostMapping
	public ResponseEntity<EquipoSolicitudFletes> crear(@RequestBody EquipoSolicitudFletes esf){
		EquipoSolicitudFletes respuesta = null;
		bitacora.info(esf);
		try {
			respuesta = ers.crear(esf);
			return new ResponseEntity<EquipoSolicitudFletes>(respuesta, HttpStatus.CREATED);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<EquipoSolicitudFletes>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EquipoSolicitudFletes> buscar(@PathVariable int id){
		EquipoSolicitudFletes esf = null;
		try {
			esf = ers.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<EquipoSolicitudFletes> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EquipoSolicitudFletes> (esf, HttpStatus.OK);
	}
	

}
