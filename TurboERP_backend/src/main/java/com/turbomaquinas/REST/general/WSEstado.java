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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.general.Ciudad;
import com.turbomaquinas.POJO.general.Estado;
import com.turbomaquinas.service.general.EstadoService;

@RestController
@RequestMapping("/general/estados")
public class WSEstado {
	
	private static final Log bitacora = LogFactory.getLog(WSEstado.class);
	
	@Autowired
	EstadoService s;
	
	@GetMapping()
	public ResponseEntity<List<Estado>> consultar(){
		List<Estado> edos = s.consultar();
		if (edos == null)
			return new ResponseEntity<List<Estado>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Estado>>(edos, HttpStatus.OK);
	}
	
	@GetMapping("/{clave}")
	public ResponseEntity<Estado> buscar(@PathVariable String clave){
		Estado ev = null;
		try{
			ev = s.buscar(clave);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Estado>(ev, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/ciudades")
	public ResponseEntity<List<Ciudad>> consultarCiudades(@PathVariable int id){
		List<Ciudad> ciudades = null;
		try{
			ciudades = s.consultarCiudades(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<Ciudad>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/ciudades/{clave}")
	public ResponseEntity<Ciudad> consultarCiudadPorClaveYEstado(@PathVariable int id, @PathVariable String clave){
		Ciudad ciudad = null;
		try{
			ciudad = s.consultarCiudadPorClaveYEstado(id, clave);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Ciudad>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
	}
}
