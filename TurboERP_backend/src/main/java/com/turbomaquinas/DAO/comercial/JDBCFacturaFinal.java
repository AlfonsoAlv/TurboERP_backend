package com.turbomaquinas.DAO.comercial;

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
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;

@Repository
public class JDBCFacturaFinal implements FacturaFinalDAO {
	
	public static class OrdenFacturaFinal{
		private int id;
		private float tipo_cambio;
		private float tipo_cambio_calculado;
		
		public OrdenFacturaFinal() {
			super();
		}

		public OrdenFacturaFinal(int id, float tipo_cambio, float tipo_cambio_calculado) {
			super();
			this.id = id;
			this.tipo_cambio = tipo_cambio;
			this.tipo_cambio_calculado = tipo_cambio_calculado;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public float getTipo_cambio() {
			return tipo_cambio;
		}

		public void setTipo_cambio(float tipo_cambio) {
			this.tipo_cambio = tipo_cambio;
		}

		public float getTipo_cambio_calculado() {
			return tipo_cambio_calculado;
		}

		public void setTipo_cambio_calculado(float tipo_cambio_calculado) {
			this.tipo_cambio_calculado = tipo_cambio_calculado;
		}		
		
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public FacturaFinal actualizar(FacturaFinal ff) throws DataAccessException {
		jdbcTemplate.update("UPDATE FACTURA_FINAL SET fecha_baja = ?, mes_baja = ?, "
				+ " anio_baja = ?, activo = ?, modificado_por = ?, DATOS_TIMBRADO_id = ? WHERE id = ?",
				ff.getFecha_baja(), ff.getMes_baja(), ff.getAnio_baja(), ff.getActivo(),
				ff.getModificado_por(),	ff.getDatos_timbrado_id(), ff.getId());
		return ff;
	}

	@Override
	public FacturaFinalVista buscar(int id) throws DataAccessException {
		FacturaFinalVista ffb = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_FINAL_V WHERE id = ?", 
				new FacturaFinalVistaRM(), id);
		return ffb;
	}

	@Override
	public List<FacturaFinalVista> consultar() throws DataAccessException {
		List<FacturaFinalVista> ffl = jdbcTemplate.query("SELECT * FROM FACTURA_FINAL_V", new FacturaFinalVistaRM());
		return ffl;
	}

	@Override
	public void cancelar(FacturaFinal ff) throws DataAccessException{
		ff.setActivo(0);
		jdbcTemplate.update("UPDATE FACTURA_FINAL SET fecha_baja = ?, mes_baja = ?, "
				+ " anio_baja = ?, activo = ?, modificado_por = ? WHERE id = ?",
				ff.getFecha_baja(), ff.getMes_baja(), ff.getAnio_baja(), ff.getActivo(),
				ff.getModificado_por(), ff.getId());
	}

	@Override
	public FacturaFinalVista buscarPorTipoNumero(int numero, String tipo,String estado) {
		FacturaFinalVista ffv = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_FINAL_V WHERE numero = ? and tipo = ? and estado_factura=?",
				new FacturaFinalVistaRM(), numero, tipo,estado);
		return ffv;
	}
	
	@Override
	public List<FacturaFinalVista> consultarFacturasPendientesPorCliente(int id, String moneda) throws DataAccessException {
		String filtradoMoneda = "";		
	   	if(!moneda.equals("*")){
			filtradoMoneda = "and moneda = ?";
		}	   	
		String sql = "SELECT * "
				+ "FROM FACTURAS_V ff "
				+ "WHERE saldo > 0 AND estado_factura='T' AND CLIENTES_id=? "+filtradoMoneda;
		List<FacturaFinalVista> ff = null;
	    
	    if(moneda.equals("*")){
	    	 ff = jdbcTemplate.query(sql,new FacturaFinalVistaRM(), id);
		}
	    else{
			ff = jdbcTemplate.query(sql,new FacturaFinalVistaRM(), id, moneda);
	    }			
		return ff;
	}

	@Override
	public List<Integer> consultarIdsOrdenesFactura(int id) {
		List<OrdenFacturaFinal> ordenes=null;
		String jsonLista= jdbcTemplate.queryForObject("SELECT JSON_EXTRACT(ordenes,'$.ordenes') FROM FACTURA_FINAL WHERE id="+id, String.class);
		ObjectMapper om = new ObjectMapper();
		try {
			ordenes = om.readValue(jsonLista, new TypeReference<List<OrdenFacturaFinal>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> idsOrden=new ArrayList<Integer>();
		for(OrdenFacturaFinal orden:ordenes){
			idsOrden.add(orden.getId());
		}	
		return idsOrden;
	}

	@Override
	public FacturaFinalVista buscarFacturaFolio(String folio, String estado, String tipo) {
		FacturaFinalVista factura = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_FINAL_V ff WHERE folio_fiscal=? AND estado_factura=? AND tipo=?",new FacturaFinalVistaRM(), folio, estado, tipo);
		return factura;
	}

	@Override
	public int creardoc(String doc) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CREAR_FACTURA_FINAL");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("doc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_factura_final_id") == 0) {
	            return (Integer) entry.getValue();
	        }
	    }		
		return 0;
	}

	@Override
	public List<FacturaFinalVista> consultarFacturasPorIds(List<Integer> ids) {
		String lista = null;
		for (int id: ids) {
			if(lista == null){
				lista = ""+id;
			}else{
				lista = lista+","+id;
			}
				
		}
		List<FacturaFinalVista> facturas = jdbcTemplate.query("SELECT * FROM FACTURA_FINAL_V WHERE id IN("+lista+")", new FacturaFinalVistaRM());
		return facturas;
	}

	@Override
	public List<FacturaFinalVista> consultarPorEstado(String estado) {
		return jdbcTemplate.query("SELECT * FROM FACTURA_FINAL_V WHERE estado_factura = ?", new FacturaFinalVistaRM(), estado);
	}

	@Override
	public void actualizarEstado(int id, String estado) {
		String sql="UPDATE FACTURA_FINAL SET estado = ? WHERE id = ?";
		jdbcTemplate.update(sql,estado,id);
	}

	@Override
	public void actualizarTipoCambio(int id, float tipoCambio) {
		String sql="UPDATE FACTURA_FINAL SET tipo_cambio = ? WHERE id = ?";
		jdbcTemplate.update(sql,tipoCambio,id);
	}
	
	@Override
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados) {
		String sql="UPDATE FACTURA_FINAL SET DATOS_TIMBRADO_id = ? WHERE id = ?";
		jdbcTemplate.update(sql,idDatosTimbrados,id);
	}

	@Override
	public FacturaFinalVista buscarUltimaFacturaPorTipo(String tipo) {
		String sql="SELECT * FROM FACTURA_FINAL_V "
				+ "WHERE tipo = ? and estado_factura='I' "
				+ "ORDER BY id DESC LIMIT 1";
		return jdbcTemplate.queryForObject(sql,new FacturaFinalVistaRM(),tipo);
	}

}
