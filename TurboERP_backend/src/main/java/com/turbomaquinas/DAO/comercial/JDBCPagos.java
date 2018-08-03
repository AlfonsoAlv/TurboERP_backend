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

import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosDetalle;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

@Repository
public class JDBCPagos implements PagosDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public Pagos actualizar(Pagos p) throws DataAccessException {
		jdbcTemplate.update("UPDATE PAGOS SET fecha_baja = ?, mes_baja = ?, anio_baja = ?, activo = ?,"
				+ "modificado_por = ?, depositos_recibidos_id = ? WHERE id = ? ", p.getFecha_baja(), p.getMes_baja(),
				p.getAnio_baja(), p.getActivo(), p.getModificado_por(), p.getDepositos_recibidos_id(), p.getId());
		return p;
	}

	@Override
	public PagosVista buscar(int id) throws DataAccessException {
		PagosVista pvb = jdbcTemplate.queryForObject("SELECT * FROM PAGOS_V WHERE id = ?", new PagosVistaRM(), id);
		return pvb;
	}

	@Override
	public List<PagosVista> consultar() throws DataAccessException {
		List<PagosVista> pvl = jdbcTemplate.query("SELECT * FROM PAGOS_V ", new PagosVistaRM());
		return pvl;
	}

	@Override
	public void AplicarPagos(String doc) throws DataAccessException{
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("APLICAR_PAGO");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		
		inParamMap.put("doc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
		
	}

	@Override
	public List<Pagos> pagoRangoFecha(String fecha_pagoInicio, String fecha_pagoFin) throws DataAccessException{
			
		String sql = "select *"
				+ " from PAGOS p"
				+ " where fecha_pago between ? and ? and activo=1 ";
		
		List<Pagos> dv = jdbcTemplate.query(sql, new PagosRM(),fecha_pagoInicio,fecha_pagoFin);			
		
		return dv;
	}

	@Override
	public List<PagosFacturas> facturasPagadas(int idPago) {
		String sql = "select p.id as pago_id, pd.tipo_cambio, p.folio as folio,"
				+ " (select ff.id from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.id from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as factura_id,"
				+ " (select ff.total from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.total from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as total,"
				+ " (select ff.tipo from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.tipo from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as tipo,"
				+ " (select ff.numero from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.numero from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as numero,"
				+ " (select ff.moneda from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.moneda from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as moneda,"
				+ " (select ff.importe_pagado from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.importe_pagado from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as importe_pagado,"
				+ " (select ff.saldo from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.saldo from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as saldo,"
				+ " (select ff.CLIENTES_id from FACTURA_FINAL ff where ff.id=pd.FACTURA_FINAL_id union select fv.CLIENTES_id from FACTURA_VARIOS fv where fv.id=pd.FACTURA_VARIOS_id) as cliente_id"
				+ " from PAGOS_DETALLE pd"
				+ " join PAGOS p on p.id=pd.PAGOS_id"
				+ " where p.id=? and p.activo=1";
		
		List<PagosFacturas> pf = jdbcTemplate.query(sql, new PagosFacturasRM(),idPago);			
		
		return pf;
	}

	@Override
	public void RestablecerPago(int id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("RESTABLECER_PAGO");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		
		inParamMap.put("id", id);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
		
	}

	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_TIMBRADO_PAGO");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idPago", id);
		inParamMap.put("p_modo", modo);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		String json=null;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("jsonPago") == 0) {
		            json=(String)entry.getValue();
		        }
		    }
			return json;
		}catch(Exception e){return null;}
	}

	@Override
	public void actualizarNumero(int id, int opcion) {
		String sql="UPDATE PAGOS SET numero = ULTIMO_NUM_PAGO() WHERE id = ?";
		if(opcion==0){
			sql="UPDATE FACTURA_VARIOS SET numero = NULL WHERE id = ?";
		}
		//System.out.println(opcion);
		jdbcTemplate.update(sql,id);
	}
	
  	@Override
	public Integer obtenerUltimoIdPago() {
		String sql = "select p.id id "
				+ "from PAGOS p "
				+ "where activo=1 and estado='I' "
				+ "ORDER BY id DESC LIMIT 1";
		
		Integer id=jdbcTemplate.queryForObject(sql, Integer.class);
		
		return id;
	}

	@Override
	public List<Pagos> pendientesTimbrar() {
		String sql="select * "
				+ "from PAGOS p "
				+ "where p.activo=1 and p.estado='I' ";
		List<Pagos> ptes = jdbcTemplate.query(sql, new PagosRM());
		return ptes;
	}

	@Override
	public void actualizarEstado(int id, String estado) {
		String sql="UPDATE PAGOS SET estado = ? WHERE id = ?";
		jdbcTemplate.update(sql,estado,id);
	}

	@Override
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados) {
		String sql="UPDATE PAGOS SET DATOS_TIMBRADO_id = ? WHERE id = ?";
		jdbcTemplate.update(sql,idDatosTimbrados,id);
	}

	@Override
	public List<PagosDetalle> detallesPago(int id) {
		String sql="select * from PAGOS_DETALLE pd where pd.PAGOS_id=?";
		List<PagosDetalle> dp = jdbcTemplate.query(sql,new PagosDetalleRM(), id);
		return dp;
	}

	@Override
	public String obtenerJSONCancelarPagos(int id, String modo, String justificacion) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_CANCELACION_PAGO");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idPago", id);
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
	public String obtenerJSONBuscarPagos(int id, String modo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_BUSCAR_PAGO");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idPago", id);
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
	public void cancelar(int id, int modificado_por) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("RESTABLECER_PAGO");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		
		inParamMap.put("id", id);
		inParamMap.put("p_modificado_por", modificado_por);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
	}

	@Override
	public Pagos buscarPagoTimbradoNumero(int numero) throws DataAccessException{
		String sql="SELECT * "
				+ "FROM PAGOS p "
				+ "where numero=? and activo=1 and estado='T' ";
		Pagos pagoNumero = jdbcTemplate.queryForObject(sql, new PagosRM(),numero);
		return pagoNumero;
	}
	
	

}
