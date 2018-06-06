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
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
	public int crear(FacturaFinal ff) throws DataAccessException {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		
		columnas.add("subtotal");
		columnas.add("descuento");
		columnas.add("iva");
		columnas.add("importe_anticipo");
		columnas.add("iva_retenido");
		columnas.add("moneda");
		columnas.add("tipo_cambio");
		columnas.add("condiciones_pago");
		columnas.add("creado_por");
		columnas.add("factura_final_id_sust");
		columnas.add("formas_pago_id");
		columnas.add("metodos_pago_id");
		columnas.add("uso_cfdi_id");
		columnas.add("clientes_id");
		
		insert.setTableName("FACTURA_FINAL");
		insert.setColumnNames(columnas);
		Map<String, Object> datos = new HashMap<>();
		
		datos.put("subtotal", ff.getSubtotal());
		datos.put("descuento", ff.getDescuento());
		datos.put("iva", ff.getIva());
		datos.put("importe_anticipo", ff.getImporte_anticipo());
		datos.put("iva_retenido", ff.getIva_retenido());
		datos.put("moneda", ff.getMoneda());
		datos.put("tipo_cambio", ff.getTipo_cambio());
		datos.put("condiciones_pago", ff.getCondiciones_pago());
		datos.put("creado_por", ff.getCreado_por());
		datos.put("factura_final_id_sust", ff.getFactura_final_id_sust());
		datos.put("formas_pago_id", ff.getFormas_pago_id());
		datos.put("metodos_pago_id", ff.getMetodos_pago_id());
		datos.put("uso_cfdi_id", ff.getUso_cfdi_id());
		datos.put("clientes_id", ff.getClientes_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

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
	public FacturaFinalVista buscarFacturaFolio(String folio,String estado) {
		FacturaFinalVista factura = jdbcTemplate.queryForObject("SELECT * FROM FACTURA_FINAL_V ff WHERE folio_fiscal=? AND estado_factura=?",new FacturaFinalVistaRM(), folio,estado);
		return factura;
	}

	@Override
	public int creardoc(String doc) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("FACTURA_FINAL");

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

}
