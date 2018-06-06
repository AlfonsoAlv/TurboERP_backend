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
		List<FacturaVariosVista> fvl = jdbcTemplate.query("SELECT * FROM FACTURA_VARIOS", new FacturaVariosVistaRM());
		return fvl;	}

	@Override
	public void cancelar(FacturaVarios fv) throws DataAccessException{
		fv.setActivo(0);
		jdbcTemplate.update("UPDATE FACTURA_VARIOS SET fecha_baja = ?, mes_baja = ?, "
				+ " anio_baja = ?, activo = ?, modificado_por = ? WHERE id = ?",
				fv.getFecha_baja(), fv.getMes_baja(), fv.getAnio_baja(), fv.getActivo(),
				fv.getModificado_por(), fv.getId());
	}

	@Override
	public List<FacturaVariosVista> consultarFacturasVariosPendientesPorCliente(int id, String moneda) throws DataAccessException {
		String filtradoMoneda = "";		
	   	if(!moneda.equals("*")){
			filtradoMoneda = "and moneda = ?";
		}	   	
		String sql = "SELECT * "
				+ "FROM FACTURA_VARIOS fv "
				+ "WHERE saldo > 0 AND estado='T' AND CLIENTES_id=? "+filtradoMoneda;
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
	
}
