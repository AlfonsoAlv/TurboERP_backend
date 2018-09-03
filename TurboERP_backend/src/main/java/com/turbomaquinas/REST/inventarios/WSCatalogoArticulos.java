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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.inventarios.CatalogoArticulosVista;
import com.turbomaquinas.service.inventarios.CatalogoArticulosService;

@RestController
@RequestMapping("/inventarios/catalogoarticulos")
public class WSCatalogoArticulos {
	
	private static final Log bitacora = LogFactory.getLog(WSCatalogoArticulos.class);
	
	@Autowired
	CatalogoArticulosService s;
	

	@GetMapping("/almacen/{id}")
	public ResponseEntity<List<CatalogoArticulosVista>> consultarArtPorAlmacen(@PathVariable int id){
		List<CatalogoArticulosVista> ca = null;
		try{
			ca = s.consultarArtPorAlmacen(id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CatalogoArticulosVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CatalogoArticulosVista>>(ca, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/existencia")
	public ResponseEntity<Void> actualizarExistenciaFisica(@PathVariable int id,@RequestParam int almacen_id,@RequestParam float cantidad){
		try{
			s.actualizarExistenciaFisica(id, almacen_id, cantidad);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<CatalogoArticulosVista> buscar(@PathVariable int id){
		CatalogoArticulosVista articulo = null;
		try {
			articulo = s.buscar(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<CatalogoArticulosVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CatalogoArticulosVista>(articulo, HttpStatus.OK);
	}
	
	@GetMapping("/almacen/{id}/subindices")
	public ResponseEntity<List<CatalogoArticulosVista>> consultarSubindicesAlmacen(@PathVariable int id,@RequestParam int agrupa_id){
		List<CatalogoArticulosVista> ca = null;
		try{
			ca = s.consultarSubindicesAlmacen(id, agrupa_id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CatalogoArticulosVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CatalogoArticulosVista>>(ca, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/ubicacion")
	public ResponseEntity<Void> actualizarUbicacion(@PathVariable int id,@RequestParam int almacen_id,@RequestParam String ubicaciones[]){
		try{
			s.actualizarUbicacion(id, almacen_id, ubicaciones);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/almacen/{id}/grupo")
	public ResponseEntity<List<CatalogoArticulosVista>> consultarArtPorGrupo(@PathVariable int id,@RequestParam int grupo_id){
		List<CatalogoArticulosVista> ca = null;
		try{
			ca = s.consultarArtPorGrupo(id,grupo_id);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CatalogoArticulosVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CatalogoArticulosVista>>(ca, HttpStatus.OK);
	}
	
	@GetMapping("/almacen/{almacen_id}/codigobarras/")
	public ResponseEntity<List<CatalogoArticulosVista>> consultarArtPorCodigoDeBarras(@PathVariable int almacen_id,@RequestParam String codigo_barras){
		List<CatalogoArticulosVista> ca = null;
		try{
			ca = s.consultarArtPorCodigoDeBarras(almacen_id,codigo_barras);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CatalogoArticulosVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CatalogoArticulosVista>>(ca, HttpStatus.OK);
	}

}
