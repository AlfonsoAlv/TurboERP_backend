package com.turbomaquinas.REST.comercial;

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
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.comercial.Cliente;
import com.turbomaquinas.POJO.comercial.ClienteVista;
import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletesVista;
import com.turbomaquinas.service.comercial.ClienteService;

@RestController
@RequestMapping("comercial/clientes")
public class WSCliente {
	
	private static final Log bitacora = LogFactory.getLog(WSCliente.class);

	@Autowired
	ClienteService s;
	
	@PostMapping
	public ResponseEntity<ClienteVista> crear(@RequestBody Cliente c) {
		ClienteVista respuesta = null;
		bitacora.info(c);
		try {
			respuesta = s.crear(c);
			return new ResponseEntity<ClienteVista>(respuesta, HttpStatus.CREATED);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<ClienteVista>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Cliente c) {
		bitacora.info(c);
		try {
			s.actualizar(c);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteVista> buscar(@PathVariable int id){
		ClienteVista ct = null;
		try {
			ct =  s.buscar(id);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<ClienteVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteVista>(ct, HttpStatus.OK);
	}

	@GetMapping("/{numero_giro}/{numero}")
	public ResponseEntity<ClienteVista> buscarPorNumero(@PathVariable int numero_giro, @PathVariable int numero){
		ClienteVista ct = null;
		try {
			ct =  s.buscar(numero_giro, numero);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<ClienteVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteVista>(ct, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<ClienteVista>> consultar() {
		List<ClienteVista> ctes = s.consultar();
		if (ctes == null)
			return new ResponseEntity<List<ClienteVista>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<ClienteVista>>(ctes, HttpStatus.OK);
	}
	
	@GetMapping("/precotizacion/cotizacion/{id}")
	public ResponseEntity<ClienteVista> buscarPorPrecotizacion(@PathVariable int id){
		ClienteVista c = null;
		try{
			c = s.buscarClientePorPrecotizacion(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<ClienteVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<ClienteVista>(c, HttpStatus.OK);	
	}

	@GetMapping("/orden/cotizacion/{id}")
	public ResponseEntity<ClienteVista> buscarPorOrden(@PathVariable int id){
		ClienteVista c = null;
		try{
			c = s.buscarClientePorOrden(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<ClienteVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<ClienteVista>(c, HttpStatus.OK);	
	}
	
	@GetMapping("/{id}/tipo")
	public ResponseEntity<String> buscarTipoCliente(@PathVariable int id){
		String tipo = null;
		try {
			tipo =  s.buscarTipoCliente(id);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		if(tipo == null) {
			return new ResponseEntity<String>(tipo, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(tipo, HttpStatus.OK);
	}
	

	@GetMapping("/{id}/EquipoSolicitudFletes")
	public ResponseEntity<List<EquipoSolicitudFletesVista>> consultarEqSolicitudPorCliente(@PathVariable int id){
		List<EquipoSolicitudFletesVista> esfl = null;
		try {
			esfl =  s.consultarPorCliente(id);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<EquipoSolicitudFletesVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<EquipoSolicitudFletesVista>>(esfl, HttpStatus.OK);
	}
	
	@GetMapping("/{numero_giro}/giro")
	public ResponseEntity<List<ClienteVista>> consultarPorGiro(@PathVariable int numero_giro) {
		List<ClienteVista> ctes = s.consultarPorGiro(numero_giro);
		if (ctes == null)
			return new ResponseEntity<List<ClienteVista>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<ClienteVista>>(ctes, HttpStatus.OK);

	}
}
