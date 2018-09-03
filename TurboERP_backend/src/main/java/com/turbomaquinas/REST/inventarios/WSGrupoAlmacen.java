package com.turbomaquinas.REST.inventarios;

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

import com.turbomaquinas.POJO.inventarios.GrupoAlmacen;
import com.turbomaquinas.service.inventarios.GrupoAlmacenService;

@RestController
@RequestMapping("/inventarios/gruposalmacen")
public class WSGrupoAlmacen {
	
	
private static final Log bitacora = LogFactory.getLog(WSGrupoAlmacen.class);
	
	@Autowired
	GrupoAlmacenService gms;
	

	@GetMapping()
	public ResponseEntity<List<GrupoAlmacen>> consultar(){
		List<GrupoAlmacen> g = null;
		try{
			g = gms.consultar();
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<GrupoAlmacen>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<GrupoAlmacen>>(g, HttpStatus.OK);
	}
	
	@GetMapping("/clavenumerica/{clave}")
	public ResponseEntity<GrupoAlmacen> buscarPorClaveNumerica(@PathVariable int clave){
		GrupoAlmacen g = null;
		try{
			g = gms.buscarPorClaveNumerica(clave);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<GrupoAlmacen>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<GrupoAlmacen>(g, HttpStatus.OK);
	}

}
