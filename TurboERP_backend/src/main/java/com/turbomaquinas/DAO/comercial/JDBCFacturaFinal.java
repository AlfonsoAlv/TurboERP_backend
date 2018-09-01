package com.turbomaquinas.DAO.comercial;

import java.io.IOException;
import java.math.BigDecimal;
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

	//String sql de la vista de FF
	public static final String  VISTA_FF_SQL="SELECT `ff`.`id` AS `id`, "
			+ "`ff`.`tipo` AS `tipo`, "
			+ "`ff`.`numero` AS `numero`, "
			+ "`ff`.`fecha_factura` AS `fecha_factura`, "
			+ "`ff`.`fecha_vencimiento` AS `fecha_vencimiento`, "
			+ "`ff`.`subtotal` AS `subtotal`, "
			+ "`ff`.`descuento` AS `descuento`, "
			+ "`ff`.`iva` AS `iva`, "
			+ "`ff`.`iva_retenido` AS `iva_retenido`, "
			+ "`ff`.`total` AS `total`, "
			+ "`ff`.`tipo_cambio` AS `tipo_cambio`, "
			+ "`ff`.`moneda` AS `moneda`, "
			+ "`ff`.`condiciones_pago` AS `condiciones_pago`, "
			+ "`ff`.`saldo`                                      AS `saldo`, "
			+ "`ff`.`importe_timbrado`                           AS `importe_timbrado`, "
			+ "`ff`.`estado`                                     AS `estado_factura`, "
			+ "`ff`.`creado_por`                                 AS `creado_por`, "
			+ "`ff`.`extranjero`                                 AS `extranjero`, "
			+ "`ff`.`anticipo_relacionado`                       AS `anticipo_relacionado`, "
			+ "`ff`.`datos_timbrado_id`                          AS `DATOS_TIMBRADO_id`, "
			+ "(SELECT IF(( `ff`.`estado` = 'I' ), 'Iniciada', (SELECT IF(( `ff`.`estado` = 'T' ), 'Timbrada', "
			+ "(SELECT IF(( `ff`.`estado` = 'B' ), 'Baja', (SELECT IF(( `ff`.`estado` = 'C' ), 'Cancelada' , "
			+ "(SELECT IF(( `ff`.`estado` = 'L' ), 'Liquidada' , NULL))))))))))                  AS `desc_estado_fact`, "
			+ "`ff`.`comentario`                                 AS `comentario`, "
			+ "`ff`.`clientes_id`                                AS `CLIENTES_id`, "
			+ "(SELECT `dt`.`folio_fiscal` FROM   `DATOS_TIMBRADO` `dt` WHERE  ( `dt`.`id` = `ff`.`datos_timbrado_id` )) AS `folio_fiscal`, "
			+ "(SELECT `fp`.`clave` FROM   `FORMAS_PAGO` `fp` WHERE  ( `fp`.`id` = `ff`.`formas_pago_id` ))    AS `cve_formap`, "
			+ "(SELECT `fp`.`descripcion` FROM   `FORMAS_PAGO` `fp` WHERE  ( `fp`.`id` = `ff`.`formas_pago_id` ))    AS `des_formap`, "
			+ "(SELECT `mp`.`clave` FROM   `METODOS_PAGO` `mp` WHERE  ( `mp`.`id` = `ff`.`metodos_pago_id` ))   AS `cve_metodop`, "
			+ "(SELECT `mp`.`descripcion` FROM   `METODOS_PAGO` `mp` WHERE  ( `mp`.`id` = `ff`.`metodos_pago_id` ))   AS `des_metodop`, "
			+ "(SELECT `uc`.`clave` FROM   `USO_CFDI` `uc` WHERE  ( `uc`.`id` = `ff`.`uso_cfdi_id` ))       AS `cve_uso`, "
			+ "(SELECT `uc`.`descripcion` FROM   `USO_CFDI` `uc` WHERE  ( `uc`.`id` = `ff`.`uso_cfdi_id` ))       AS `des_uso`, "
			+ "`c`.`numero`                                      AS `numero_cliente`, "
			+ "(SELECT `GIROS`.`numero` FROM   `GIROS` WHERE  ( `GIROS`.`id` = `c`.`giros_id` ))        AS `num_giro`, "
			+ "`c`.`nombre_fiscal`                               AS `nombre`, "
			+ "`c`.`direccion_fiscal`                            AS `direccion`, "
			+ "`c`.`colonia_fiscal`                              AS `colonia`, "
			+ "`c`.`codigo_postal_fiscal`                        AS `codigo_postal`, "
			+ "(SELECT `CIUDADES`.`nombre` FROM   `CIUDADES` WHERE  ( `CIUDADES`.`id` = `c`.`ciudades_id` ))  AS `ciudad`, "
			+ "(SELECT `CIUDADES`.`estados_id` FROM   `CIUDADES` WHERE  ( `CIUDADES`.`id` = `c`.`ciudades_id` ))  AS `estado_id`, "
			+ "(SELECT `ESTADOS`.`nombre` FROM   `ESTADOS` WHERE  ( `ESTADOS`.`id` = `estado_id` ))         AS `estado`, "
			+ "(SELECT `ESTADOS`.`paises_id` FROM   `ESTADOS` WHERE  ( `ESTADOS`.`id` = `estado_id` ))         AS `pais_id`, "
			+ "(SELECT `PAISES`.`descripcion` FROM   `PAISES` WHERE  ( `PAISES`.`id` = `pais_id` ))            AS `pais`, "
			+ "`ff`.`activo`                                     AS `activo`, "
			+ "`ff`.`comprobantes_relacionados`                  AS `comprobantes_relacionados`, "
			+ "`ff`.`alfresco_id`                                AS `alfresco_id_previa` , "
			+ "(SELECT `dt`.`alfresco_id_pdf` FROM   `DATOS_TIMBRADO` `dt` WHERE  ( `dt`.`id` = `ff`.`datos_timbrado_id` )) AS `alfresco_id_timbrado_pdf`, "
			+ "(SELECT `dt`.`alfresco_id_xml` FROM   `DATOS_TIMBRADO` `dt` WHERE  ( `dt`.`id` = `ff`.`datos_timbrado_id` )) AS `alfresco_id_timbrado_xml`, "
			+ "(SELECT `dt`.`alfresco_id_pdf_cancelacion` FROM   `DATOS_TIMBRADO` `dt` WHERE  ( `dt`.`id` = `ff`.`datos_timbrado_id` )) AS `alfresco_id_timbrado_pdf_cancelacion`, "
			+ "(SELECT `dt`.`alfresco_id_xml_cancelacion` FROM   `DATOS_TIMBRADO` `dt` WHERE  ( `dt`.`id` = `ff`.`datos_timbrado_id` )) AS `alfresco_id_timbrado_xml_cancelacion` "
			+ "FROM   (`FACTURA_FINAL` `ff` JOIN `CLIENTES` `c` ON (( `c`.`id` = `ff`.`clientes_id` ))) ";
	
	@Override
	public FacturaFinalVista buscar(int id) throws DataAccessException {
		FacturaFinalVista ffb = jdbcTemplate.queryForObject(VISTA_FF_SQL+" WHERE ff.id = ?", 
				new FacturaFinalVistaRM(), id);
		return ffb;
	}

	@Override
	public List<FacturaFinalVista> consultar() throws DataAccessException {
		List<FacturaFinalVista> ffl = jdbcTemplate.query(VISTA_FF_SQL, new FacturaFinalVistaRM());
		return ffl;
	}

	@Override
	public FacturaFinalVista buscarPorTipoNumero(int numero, String tipo,String estado) {
		FacturaFinalVista ffv = jdbcTemplate.queryForObject(VISTA_FF_SQL+" WHERE ff.numero = ? and ff.tipo = ? and ff.estado=?",
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
	public List<Integer> creardoc(String doc) throws DataAccessException {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CREAR_FACTURA_FINAL");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("arraydoc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		//simpleJdbcCall.execute(in);
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		List<Integer> listaIdsFactura = new ArrayList<Integer>();
		
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_factura_final_id") == 0) {
	        	System.out.println((String)entry.getValue());
	        	String[] idsFactura =((String)entry.getValue()).split(", |\\ |\\[|\\]");	        	
	        	for(int i=0;i<idsFactura.length;i++){
	        		if(!idsFactura[i].equals("")){
	        			listaIdsFactura.add(Integer.parseInt(idsFactura[i].toString()));
	        		}	
	    		}
	        }
	    }
		return listaIdsFactura;
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
		List<FacturaFinalVista> facturas = jdbcTemplate.query(VISTA_FF_SQL+" WHERE ff.id IN("+lista+")", new FacturaFinalVistaRM());
		return facturas;
	}

	@Override
	public List<FacturaFinalVista> consultarPorEstado(String estado) {
		return jdbcTemplate.query(VISTA_FF_SQL+" WHERE ff.estado = ?", new FacturaFinalVistaRM(), estado);
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
	public FacturaFinalVista buscarUltimaFacturaPorTipoEstado(int extranjero,String estado) {
		String sql="SELECT * FROM FACTURA_FINAL_V "
				+ "WHERE extranjero = ? AND estado_factura=? AND activo=1 "
				+ "ORDER BY id DESC LIMIT 1";
		return jdbcTemplate.queryForObject(sql,new FacturaFinalVistaRM(),extranjero,estado);
	}

	@Override
	public void actualizarIdAlfresco(int id, String alfresco_id) {
		jdbcTemplate.update("UPDATE FACTURA_FINAL SET alfresco_id = ? WHERE id = ?", alfresco_id,id);
	}
	
	@Override
	public String obtenerJSONFacturaFinal(int idFactura,String modo) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_TIMBRADO_FACTURA_FINAL");

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
	public String obtenerJSONCancelarFacturaFinal(int idFactura,String modo,String justificacion) throws DataAccessException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_CANCELACION_FACTURA_FINAL");

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
	public String obtenerJSONBuscarFacturaFinal(int idFactura, String modo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("JSON_BUSCAR_FACTURA_FINAL");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idFactura", idFactura);
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
	public void baja(String p_facturas_id, int modificado_por) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("BAJA_FACTURA_FINAL");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_facturas_id", p_facturas_id);
		inParamMap.put("p_modificado_por", modificado_por);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		//Map<String, Object> simpleJdbcCallResult = 
		simpleJdbcCall.execute(in);
		
		/*
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
			if (entry.getKey().compareTo("p_salida") == 0) {
	            System.out.println(entry.getValue());
	        }
	    }*/
	}
	
	@Override
	public void actualizarNumero(int id, int numero) {
		String sql="UPDATE FACTURA_FINAL SET numero = ULTIMO_NUM_FACT_FINAL(tipo) WHERE id = ?";
		if(numero==0){
			sql="UPDATE FACTURA_FINAL SET numero = NULL WHERE id = ?";
		}
		
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void actualizarParcialidadImporteTimbrado(BigDecimal impTimbrado,int id) {
		String sql="UPDATE FACTURA_FINAL SET parcialidad = (parcialidad + 1),importe_timbrado=(importe_timbrado+?) WHERE id=?";
		jdbcTemplate.update(sql,impTimbrado,id);
	}

	@Override
	public void cancelar(String p_facturas_id, int modificado_por) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CANCELAR_FACTURA_FINAL");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_facturas_id", p_facturas_id);
		inParamMap.put("p_modificado_por", modificado_por);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
	}

	@Override
	public FacturaFinalVista buscarFacturaPorFolioEstado(String folio, String estado) {
		String sql=VISTA_FF_SQL
				+ " WHERE CONCAT(ff.numero,ff.tipo)=? AND ff.estado=?";
		return jdbcTemplate.queryForObject(sql,new FacturaFinalVistaRM(),folio,estado);
	}

}
