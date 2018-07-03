package com.turbomaquinas.REST.comercial;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.comercial.ActividadesFA;
import com.turbomaquinas.service.comercial.ActividadesFAService;

@RestController
@RequestMapping("comercial/actividadesfa")
public class WSActividadesFA {

	private static final Log bitacora = LogFactory.getLog(WSActividadesFA.class);

	@Autowired
	ActividadesFAService s;
	
	@PostMapping
	public ResponseEntity<ActividadesFA> crear(@RequestBody ActividadesFA afa) {
		
		ActividadesFA respuesta = null;
		bitacora.info(afa);
		try {
			respuesta = s.crear(afa);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<ActividadesFA>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<ActividadesFA>(respuesta, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody ActividadesFA afa){
		
		bitacora.info(afa);
		try {
			s.actualizar(afa);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ActividadesFA> buscar(@PathVariable int id){
		
		ActividadesFA afab = null;
		try {
			afab = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<ActividadesFA>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ActividadesFA>(afab, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ActividadesFA>> consultar(){
	
		List<ActividadesFA> afal = s.consultar();
		if (afal == null)
			return new ResponseEntity<List<ActividadesFA>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<ActividadesFA>>(afal, HttpStatus.OK);
	}
	
}
