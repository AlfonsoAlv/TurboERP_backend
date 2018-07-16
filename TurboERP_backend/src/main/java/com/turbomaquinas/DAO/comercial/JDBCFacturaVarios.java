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

import com.turbomaquinas.POJO.comercial.FacturaVarios;
import com.turbomaquinas.POJO.comercial.FacturaVariosVista;

@Repository
public class JDBCFacturaVarios implements FacturaVariosDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void actualizar(FacturaVarios fv) throws DataAccessException {
		jdbcTemplate.update("UPDATE FACTURA_VARIOS SET fecha_baja = ?, mes_baja = ?, "
				+ " anio_baja = ?, activo = ?, modificado_por = ?, DATOS_TIMBRADO_id = ? WHERE id = ?",
				fv.getFecha_baja(), fv.getMes_baja(), fv.getAnio_baja(), fv.getActivo(),
				fv.getModificado_por(),	fv.getDatos_timbrado_id(), fv.getId());
	}

	@Override
	public FacturaVariosVista buscar(int id) throws DataAccessException {
		FacturaVariosVista fvb = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_VARIOS_V WHERE id = ?", 
				new FacturaVariosVistaRM(), id);
		return fvb;	
	}

	@Override
	public List<FacturaVariosVista> consultar() throws DataAccessException {
		List<FacturaVariosVista> fvl = jdbcTemplate.query("SELECT * FROM FACTURA_VARIOS_V", new FacturaVariosVistaRM());
		return fvl;	
	}

	@Override
	public List<FacturaVariosVista> consultarFacturasVariosPendientesPorCliente(int id, String moneda) throws DataAccessException {
		String filtradoMoneda = "";		
	   	if(!moneda.equals("*")){
			filtradoMoneda = "and moneda = ?";
		}	   	
		String sql = "SELECT * "
				+ "FROM FACTURA_VARIOS_V fv "
				+ "WHERE saldo > 0 AND estado_factura='T' AND CLIENTES_id=? "+filtradoMoneda;
		List<FacturaVariosVista> fvv = null;
	    
	    if(moneda.equals("*")){
	    	 fvv = jdbcTemplate.query(sql,new FacturaVariosVistaRM(), id);
		}
	    else{
			fvv = jdbcTemplate.query(sql,new FacturaVariosVistaRM(), id, moneda);
	    }			
		return fvv;
	}

	@Override
	public FacturaVariosVista buscarFacturaFolio(String folio, String estado, String tipo) {
		FacturaVariosVista factura = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_VARIOS_V WHERE folio_fiscal=? AND estado_factura=? AND tipo=?",new FacturaVariosVistaRM(), folio, estado, tipo);
		return factura;
	}

	@Override
	public FacturaVariosVista buscarPorTipoNumero(int numero, String tipo, String estado) {
		FacturaVariosVista ffv = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_VARIOS_V WHERE numero = ? and tipo = ? and estado_factura=?",
				new FacturaVariosVistaRM(), numero, tipo,estado);
		return ffv;
	}

	@Override
	public int crearDoc(String doc) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CREAR_FACTURA_VARIOS");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("doc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_factura_varios_id") == 0) {
	            return (Integer) entry.getValue();
	        }
	    }		
		return 0;
	}

	@Override
	public void cancelar(int id, int modificado_por) {
		jdbcTemplate.update("UPDATE FACTURA_VARIOS SET activo = 0, estado = 'C', modificado_por = ?, fecha_baja = NOW(),"
				+ "mes_baja = DATE_FORMAT(NOW(), '%m'), anio_baja = DATE_FORMAT(NOW(), '%Y')  where id = ?", modificado_por, id);
	}

	@Override
	public List<FacturaVariosVista> consultarPorEstado(String estado) {
		return jdbcTemplate.query("SELECT * FROM FACTURA_VARIOS_V WHERE estado_factura = ?", new FacturaVariosVistaRM(), estado);
	}

	
	@Override
	public String obtenerJSONFacturaVarios(int idFactura,String modo) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_TIMBRADO_FACTURA_VARIOS");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idFactura", idFactura);
		inParamMap.put("p_modo", modo);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		String json=null;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("jsonFactura") == 0) {
		            json=(String)entry.getValue();
		        }
		    }
			return json;
		}catch(Exception e){return null;}
	}
	
	@Override
	public void actualizarEstado(int id, String estado) {
		String sql="UPDATE FACTURA_VARIOS SET estado = ? WHERE id = ?";
		jdbcTemplate.update(sql,estado,id);
	}
	
	@Override
	public void actualizarTipoCambio(int id, float tipoCambio) {
		String sql="UPDATE FACTURA_VARIOS SET tipo_cambio = ? WHERE id = ?";
		jdbcTemplate.update(sql,tipoCambio,id);
	}
	
	@Override
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados) {
		String sql="UPDATE FACTURA_VARIOS SET DATOS_TIMBRADO_id = ? WHERE id = ?";
		jdbcTemplate.update(sql,idDatosTimbrados,id);
	}
	
	@Override
	public String obtenerJSONCancelarFacturaVarios(int idFactura,String modo,String justificacion) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_CANCELACION_FACTURA_VARIOS");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idFactura", idFactura);
		inParamMap.put("p_modo", modo);
		inParamMap.put("p_justificacion",justificacion);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		String json=null;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("jsonCancelacion") == 0) {
		            json=(String)entry.getValue();
		        }
		    }
			return json;
		}catch(Exception e){return null;}
	}

	@Override
	public String obtenerJSONBuscarFacturaVarios(int id, String modo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_BUSCAR_FACTURA_VARIOS");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idFactura", id);
		inParamMap.put("p_modo", modo);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		String json=null;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("jsonBusqueda") == 0) {
		            json=(String)entry.getValue();
		        }
		    }
			return json;
		}catch(Exception e){return null;}
	}
	
	@Override
	public void actualizarNumero(int id, int opcion) {
		String sql="UPDATE FACTURA_VARIOS SET numero = ULTIMO_NUM_FACT_FINAL(tipo) WHERE id = ?";
		if(opcion==0){
			sql="UPDATE FACTURA_VARIOS SET numero = NULL WHERE id = ?";
		}
		//System.out.println(opcion);
		jdbcTemplate.update(sql,id);
	}
	
}
