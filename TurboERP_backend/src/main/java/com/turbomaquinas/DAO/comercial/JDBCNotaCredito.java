package com.turbomaquinas.DAO.comercial;

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

import com.turbomaquinas.POJO.comercial.NotaCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;

@Repository
public class JDBCNotaCredito implements NotaCreditoDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void actualizar(NotaCredito nc) throws DataAccessException {
		jdbcTemplate.update("UPDATE NOTAS_CREDITO set fecha_baja = ?, modificado_por = ?, "
				+ " DATOS_TIMBRADO_id = ?"
				+ "NOTAS_CREDITO_id_sust = ?  WHERE id = ?", nc.getFecha_baja(), nc.getModificado_por(),
				nc.getDatos_timbrado_id(), 
				nc.getNotas_credito_id_sust(), nc.getId());
	}

	@Override
	public NotaCreditoVista buscar(int id) throws DataAccessException {
		NotaCreditoVista nc = jdbcTemplate.queryForObject("SELECT * FROM NOTAS_CREDITO_V WHERE id = ?", 
				new NotaCreditoVistaRM(), id);
		return nc;
	}

	@Override
	public List<NotaCreditoVista> consultar() throws DataAccessException {
		List<NotaCreditoVista> ncl = jdbcTemplate.query("SELECT * FROM NOTAS_CREDITO_V", new NotaCreditoVistaRM());
		return ncl;
	}

	@Override
	public int crearNotasCredito(String doc) throws DataAccessException {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("APLICAR_NOTAS_CREDITO");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_nota_credito_id", 0);
		inParamMap.put("doc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_nota_credito_id") == 0) {
	            return (Integer) entry.getValue();
	        }
	    }		
		return 0;
	}

	@Override
	public void RestablecerNotaCredito(int id, int modificado_por) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("RESTABLECER_NOTA_CREDITO");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		
		inParamMap.put("id", id);
		inParamMap.put("modificado_por", modificado_por);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
		
	}
	
	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_TIMBRADO_NOTA_CREDITO");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idNotaCred", id);
		inParamMap.put("p_modo", modo);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		String json=null;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("jsonNotaCredito") == 0) {
		            json=(String)entry.getValue();
		        }
		    }
			return json;
		}catch(Exception e){return null;}
	}
	
	@Override
	public void actualizarNumero(int id, int opcion) {
		String sql="UPDATE NOTAS_CREDITO SET numero = ULTIMO_NUM_NOTA_CREDITO() WHERE id = ?";
		if(opcion==0){
			sql="UPDATE NOTAS_CREDITO SET numero = NULL WHERE id = ?";
		}
		jdbcTemplate.update(sql,id);
	}

	

	
}
