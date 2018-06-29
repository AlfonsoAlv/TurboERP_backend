package com.turbomaquinas.DAO.general;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.general.CronologiaOT;

@Repository
public class JDBCCronologiaOT implements CronologiaOTDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CronologiaOT> consultarPorOrden(int id) throws DataAccessException{		
		List<CronologiaOT> cron = jdbcTemplate.query("SELECT * FROM CRONOLOGIA_OT_V WHERE ORDENES_id = ? ORDER BY fecha, creado", 
				new CronologiaOTRM(), id);
		return cron;
	}

	@Override
	public List<CronologiaOT> consultarPorOrdenyTipo(int id, String tipo) throws DataAccessException {
		List<CronologiaOT> crono = jdbcTemplate.query("SELECT * FROM CRONOLOGIA_OT_V WHERE ORDENES_id = ? and tipo = ? ORDER BY fecha, creado", 
				new CronologiaOTRM(), id, tipo);
		return crono;
	}

	@Override
	public List<CronologiaOT> consultaCronologia(int id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_CRONOLOGIA_ORDEN");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_ordenes_id", id);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		List<CronologiaOT> cron=new ArrayList<CronologiaOT>(); 
		try{
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_json") == 0) {
	        	ObjectMapper mapper = new ObjectMapper();
	            String json=(String)entry.getValue();
	            //System.out.println(json);
	    		try {
	    			cron = mapper.readValue(json, new TypeReference<List<CronologiaOT>>(){});
	    		} catch (IOException e) {/*System.out.println(e);*/}
	    		return cron;
	        }
	    }		
		return null;
		}catch(Exception e){return null;}
	}
	
	
	
}
