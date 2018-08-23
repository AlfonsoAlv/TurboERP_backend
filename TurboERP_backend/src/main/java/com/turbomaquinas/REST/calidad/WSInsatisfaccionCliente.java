package com.turbomaquinas.REST.calidad;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccionVista;
import com.turbomaquinas.service.calidad.InsatisfaccionClienteService;

@RestController
@RequestMapping("calidad/insatisfaccion")
public class WSInsatisfaccionCliente {

	private static final Log bitacora = LogFactory.getLog(WSInsatisfaccionCliente.class);

	@Autowired
	InsatisfaccionClienteService ics;

	@GetMapping
	public ResponseEntity<List<InsatisfaccionClienteVista>> consultar() {
		List<InsatisfaccionClienteVista> listaInsatisfacciones = new ArrayList<>();
		try {
			listaInsatisfacciones = ics.consultar();
			if (listaInsatisfacciones.isEmpty()) {
				return new ResponseEntity<List<InsatisfaccionClienteVista>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<InsatisfaccionClienteVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<InsatisfaccionClienteVista>>(listaInsatisfacciones, HttpStatus.OK);
	}
	
	@GetMapping("/filtros")
	public ResponseEntity<List<InsatisfaccionClienteVista>> consultarPorFiltros(@RequestParam String estado,@RequestParam String numero_orden,@RequestParam String fecha_inicio,@RequestParam String fecha_fin) {
		List<InsatisfaccionClienteVista> listaInsatisfacciones = new ArrayList<>();
		try {
			listaInsatisfacciones = ics.consultarPorFiltros(estado,numero_orden,fecha_inicio,fecha_fin);
			if (listaInsatisfacciones.isEmpty()) {
				return new ResponseEntity<List<InsatisfaccionClienteVista>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<InsatisfaccionClienteVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<InsatisfaccionClienteVista>>(listaInsatisfacciones, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InsatisfaccionClienteVista> buscar(@PathVariable int id) {
		InsatisfaccionClienteVista insatisfaccionCliente;
		try {
			insatisfaccionCliente = ics.buscar(id);
			if (insatisfaccionCliente == null) {
				return new ResponseEntity<InsatisfaccionClienteVista>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<InsatisfaccionClienteVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<InsatisfaccionClienteVista>(insatisfaccionCliente, HttpStatus.OK);
	}
	
	@GetMapping("/folio/{folio}")
	public ResponseEntity<InsatisfaccionClienteVista> buscarPorFolio(@PathVariable int folio) {
		InsatisfaccionClienteVista insatisfaccionCliente;
		try {
			insatisfaccionCliente = ics.buscarPorFolio(folio);
			if (insatisfaccionCliente == null) {
				return new ResponseEntity<InsatisfaccionClienteVista>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<InsatisfaccionClienteVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<InsatisfaccionClienteVista>(insatisfaccionCliente, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<InsatisfaccionClienteVista> crear(@RequestBody InsatisfaccionCliente insatisfaccion) {
		InsatisfaccionClienteVista insatisfaccionCliente;
		bitacora.info(insatisfaccion);
		try {
			insatisfaccionCliente = ics.crear(insatisfaccion);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<InsatisfaccionClienteVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<InsatisfaccionClienteVista>(insatisfaccionCliente, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizarInsatisfaccionCliente (@RequestBody InsatisfaccionCliente insatisfaccion) {		
		bitacora.info(insatisfaccion);
		try {
			ics.actualizarInsatisfaccionCliente(insatisfaccion);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/seguimiento")
	public ResponseEntity<SeguimientoInsatisfaccionVista> crearSeguimiento(@RequestBody SeguimientoInsatisfaccion seguimiento) {
		bitacora.info(seguimiento);
		SeguimientoInsatisfaccionVista seguimiento_v=null;
		try {
			seguimiento_v=ics.crearSeguimiento(seguimiento);
		} catch (Exception e) {
		
			bitacora.error(e.getMessage());
			return new ResponseEntity<SeguimientoInsatisfaccionVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SeguimientoInsatisfaccionVista>(seguimiento_v,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/seguimientos")
	public ResponseEntity<List<SeguimientoInsatisfaccion>> consultarSeguimientos(@PathVariable int id) {
		List<SeguimientoInsatisfaccion> lista = new ArrayList<>();
		try {
			lista = ics.consultarSeguimientos(id);
			if (lista.isEmpty()) {
				return new ResponseEntity<List<SeguimientoInsatisfaccion>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<SeguimientoInsatisfaccion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<SeguimientoInsatisfaccion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/seguimiento/{id}")
	public ResponseEntity<SeguimientoInsatisfaccionVista> buscarSeguimiento(@PathVariable int id) {
		SeguimientoInsatisfaccionVista seguimiento;
		try {
			seguimiento = ics.buscarSeguimiento(id);
			if (seguimiento == null) {
				return new ResponseEntity<SeguimientoInsatisfaccionVista>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<SeguimientoInsatisfaccionVista>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SeguimientoInsatisfaccionVista>(seguimiento, HttpStatus.OK);
	}
	
	@PutMapping("/seguimiento/{id}/alfresco")
	public ResponseEntity<Void> agregarDocumentoAlfresco(@PathVariable int id,@RequestParam String alfresco_id,@RequestParam int creado_por,@RequestParam String descripcion) {
		try {
			ics.agregarDocumentoAlfresco(id,alfresco_id,creado_por,descripcion);
		} catch (Exception e) {
		
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/{id}/estado")
	public ResponseEntity<Void> actualizarEstado(@PathVariable int id,@RequestParam String estado){
		try {
			ics.actualizarEstado(id,estado);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
