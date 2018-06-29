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

import com.turbomaquinas.POJO.general.CronologiaOT;
import com.turbomaquinas.service.general.CronologiaOTservice;

@RestController
@RequestMapping("/general/cronos")
public class WSCronologiaOT {

	private static final Log bitacora = LogFactory.getLog(WSCronologiaOT.class);
	
	@Autowired
	CronologiaOTservice s;
	
	@GetMapping("/orden/{id}")
	public ResponseEntity<List<CronologiaOT>> ConsultarPorOrden(@PathVariable int id){
		List<CronologiaOT> c = null;
		try {
			c = s.consultarPorOrden(id);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CronologiaOT>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CronologiaOT>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/orden/{id}/{tipo}")
	public ResponseEntity<List<CronologiaOT>> ConsultarPorOrdenyTipo(@PathVariable int id, @PathVariable String tipo){
		List<CronologiaOT> c = null;
		try {
			c = s.consultarPorOrdenyTipo(id, tipo);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CronologiaOT>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CronologiaOT>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/Orden/{id}")
	public ResponseEntity<List<CronologiaOT>> ConsultarCronologia(@PathVariable int id){
		List<CronologiaOT> c = null;
		try {
			c = s.consultaCronologia(id);
		} catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CronologiaOT>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CronologiaOT>>(c, HttpStatus.OK);
	}
}
