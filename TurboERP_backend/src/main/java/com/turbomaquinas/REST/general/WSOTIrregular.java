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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.DAO.general.ActividadAutorizadaDAO;
import com.turbomaquinas.POJO.general.DocumentoOTIrregular;
import com.turbomaquinas.POJO.general.OTIrregular;
import com.turbomaquinas.POJO.general.OTIrregularVista;
import com.turbomaquinas.service.general.ActividadAutorizadaService;
import com.turbomaquinas.service.general.OTIrregularService;

@RestController
@RequestMapping("/general/ordenesi")
public class WSOTIrregular {
	
	@Autowired
	OTIrregularService s;
	
	@Autowired
	ActividadAutorizadaService aas;

	private static final Log bitacora = LogFactory.getLog(WSOTIrregular.class);
	
	@PostMapping()
	public ResponseEntity<OTIrregularVista> crear(@RequestBody DocumentoOTIrregular doc){
		OTIrregularVista respuesta = null;
		try{
			 respuesta = s.crearOTIrregular(doc);	
			return new ResponseEntity<OTIrregularVista>(respuesta, HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OTIrregularVista>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping()
	public ResponseEntity<Void> actualizar(@RequestBody OTIrregular oti){
		bitacora.info(oti);
		try{
			s.actualizar(oti);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OTIrregularVista> buscar(@PathVariable("id") int id){
		OTIrregularVista otiv = null;
		try{
			otiv = s.buscar(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OTIrregularVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OTIrregularVista>(otiv, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OTIrregularVista>> consultar(){
		List<OTIrregularVista> otiv = null;
		try{
			otiv = s.consultar();
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<OTIrregularVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OTIrregularVista>>(otiv, HttpStatus.OK);
	}
	
	@GetMapping("/folio")
	public ResponseEntity<OTIrregularVista> buscarOTI(@RequestParam String folio){
		OTIrregularVista o = null;
		try{
			o = s.buscarOTIrregular(folio);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OTIrregularVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OTIrregularVista>(o, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/{usuarioAcepta}")
	public ResponseEntity<Void> aceptaOTI(@PathVariable int id, @PathVariable int usuarioAcepta, @RequestParam String estado){
		try{
			s.aceptaOTI(id, usuarioAcepta, estado);
			if(estado.equalsIgnoreCase("C")){
				aas.actualizarBanderaImpAut(id,0);
			}
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
