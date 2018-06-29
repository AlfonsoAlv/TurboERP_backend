package com.turbomaquinas.REST.proveedores;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turbomaquinas.POJO.proveedores.IndicadoresTotalesDeRequisiciones;
import com.turbomaquinas.REST.general.WSParametro;
import com.turbomaquinas.service.proveedores.IndicadoresTotalesDeRequisicionesService;

@RestController
@RequestMapping("/proveedores/IndicadoresRequisiciones")
public class WSIndicadoresTotalesDeRequisiciones {
	
	private static final Log bitacora = LogFactory.getLog(WSParametro.class);
	
	@Autowired
	IndicadoresTotalesDeRequisicionesService indts;
	
	@GetMapping()
	public ResponseEntity<List<IndicadoresTotalesDeRequisiciones>> consultar(){
		List<IndicadoresTotalesDeRequisiciones> indicadores = null; 
		try{
			indicadores = indts.consultar();
			
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<IndicadoresTotalesDeRequisiciones>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<IndicadoresTotalesDeRequisiciones>>(indicadores, HttpStatus.OK);
	}
	
	

}
