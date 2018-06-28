package com.turbomaquinas.DAO.general;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.DAO.comercial.CotizacionVistaRM;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.general.AtributoEspecialConsulta;
import com.turbomaquinas.POJO.general.OT;
import com.turbomaquinas.POJO.general.Orden;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.POJO.general.OrdenFactura.Facturas;
import com.turbomaquinas.POJO.general.OrdenFechasVista;
import com.turbomaquinas.POJO.general.OrdenVista;
import com.turbomaquinas.POJO.general.PagosConsultaOrdenes;

@Repository
public class JDBCOrden implements OrdenDAO {
	
	public class FoliosOrdenes{
		private int id;
		private String folio;
		private Date fecha;

		public FoliosOrdenes(int id, String folio, Date fecha) {
			super();
			this.id = id;
			this.folio = folio;
			this.fecha = fecha;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFolio() {
			return folio;
		}

		public void setFolio(String folio) {
			this.folio = folio;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int crear(Orden o) throws DataAccessException{
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("descripcion");
		columnas.add("tipo");
		columnas.add("creado_por");
		columnas.add("CLIENTES_id");
		columnas.add("MARCAS_EQUIPOS_id");
		columnas.add("MODELOS_EQUIPOS_id");
		
		insert.setTableName("ORDENES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("descripcion", o.getDescripcion());
		datos.put("tipo", o.getTipo());
		datos.put("creado_por", o.getCreado_por());
		datos.put("CLIENTES_id", o.getClientes_id());
		datos.put("MARCAS_EQUIPOS_id", o.getMarcas_equipos_id());
		datos.put("MODELOS_EQUIPOS_id", o.getModelos_equipos_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public void actualizar(Orden o) throws DataAccessException{
		jdbcTemplate.update("UPDATE ORDENES SET descripcion=?, CLIENTES_id=?, MARCAS_EQUIPOS_id=?, MODELOS_EQUIPOS_id=? WHERE id=?", 
				o.getDescripcion(), o.getClientes_id(), o.getMarcas_equipos_id(), o.getModelos_equipos_id(), o.getId());
	}
	
	@Override
	public OrdenVista buscar(int id) throws DataAccessException{
		OrdenVista ov = jdbcTemplate.queryForObject("SELECT * FROM ORDENES_V WHERE id=?", 
				new OrdenVistaRM(), id);
		return ov;
	}

	@Override
	public List<OrdenVista> consultar() throws DataAccessException{
		List<OrdenVista> o = jdbcTemplate.query("SELECT * FROM ORDENES_V ", 
				new OrdenVistaRM());
			return o;
	}

	@Override
	public OrdenVista buscarOrden(String numeroOrden) throws DataAccessException{
		OrdenVista ov = jdbcTemplate.queryForObject("SELECT * FROM ORDENES_V WHERE numero_orden=?", 
				new OrdenVistaRM(), numeroOrden);
		return ov;
	}

	@Override
	public List<Integer> anioOrden() throws DataAccessException{
		List<Integer> o = jdbcTemplate.queryForList("SELECT DISTINCT(anio) FROM ORDENES ORDER BY anio DESC", 
				Integer.class);
		return o;
	}

	@Override
	public List<OrdenVista> ordenAnio(int anio) throws DataAccessException{
		List<OrdenVista> ov = jdbcTemplate.query("SELECT * FROM ORDENES_V WHERE anio=?", 
				new OrdenVistaRM(), anio);
		return ov;
	}

	@Override
	public void actualizarMoneda(int id, String moneda) throws DataAccessException {
		jdbcTemplate.update("UPDATE ORDENES SET moneda=? WHERE id=?", moneda, id);
	}

	@Override
	public OT buscarPorNumero(String numero) throws DataAccessException {
		OT o = jdbcTemplate.queryForObject("SELECT o.id, o.descripcion, o.CLIENTES_id clientes_id, o.moneda, o.importe_autorizado, o.importe_pedido, o.numero_orden, "+ 
				"(SELECT numero FROM CLIENTES WHERE id = o.CLIENTES_id) numero_cliente, "+ 
				"(SELECT nombre_comercial FROM CLIENTES WHERE id = o.CLIENTES_id) comercial, "+ 
				"(SELECT nombre_fiscal FROM CLIENTES WHERE id = o.CLIENTES_id) fiscal, "+
			    "(SELECT numero FROM GIROS WHERE id  = (SELECT GIROS_id FROM CLIENTES WHERE id = o.CLIENTES_id)) giro "+
			    "FROM ORDENES o "+
			    "WHERE o.numero_orden = ?", 
				new OTRM(), numero);
		return o;
	}

	@Override
	public int autorizarActividades(int ordenId, String doc) throws DataAccessException  {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("AUTORIZAR_ACTIVIDADES");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_orden_id", ordenId);
		inParamMap.put("doc", doc);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
	        if (entry.getKey().compareTo("p_autorizacion_id") == 0) {
	            return (Integer) entry.getValue();
	        }
	    }		
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoliosOrdenes> consultarFoliosporOrden(int id) {
		String sql ="SELECT a.id as id, a.folio as folio, a.fecha as fecha"
				+ " FROM ORDENES o"
				+ " JOIN AUTORIZACIONES a ON a.ORDENES_id=o.id"
				+ " WHERE o.id = ?";
	
		List<? extends Object> folios = jdbcTemplate.query(sql, new RowMapper<Object>() {

			@Override
			public Object mapRow(ResultSet rs, int i) throws SQLException {
				return new FoliosOrdenes(
						rs.getInt("id"),
						rs.getString("folio"),
						rs.getDate("fecha"));
			}
		}, id);
		
		return (List<FoliosOrdenes>) folios;
	}

	@Override
	public void actualizarAlfresco(int idOrden, String alfresco_id) throws DataAccessException{
		jdbcTemplate.update("UPDATE ORDENES SET alfresco_id_OIT=? WHERE id=?", 
				alfresco_id, idOrden);
		
	}

	


	@Override
	public void actualizarCambioCliente(int id,String cliente) throws DataAccessException{
		String sql="UPDATE ORDENES set especiales=(SELECT JSON_ESPECIALES_ORDENES_CAMBIOS(?,id,'$.cambios','cambios')) where id=?";
		jdbcTemplate.update(sql,cliente,id);
	}
	
	@Override
	public void actualizarCambioMoneda(int id,String moneda) throws DataAccessException{
		String sql="UPDATE ORDENES set especiales=(SELECT JSON_ESPECIALES_ORDENES_CAMBIOS(?,id,'$.cambios','cambios')) where id=?";
		jdbcTemplate.update(sql,moneda,id);
	}

	@Override
	public void actualizarClienteOriginal(int id, int clienteId, int modificado_por) throws DataAccessException{
		String sql="UPDATE ORDENES set CLIENTES_id = ?, modificado_por = ? where id=?";
		jdbcTemplate.update(sql,clienteId,modificado_por,id);
	}
	
	@Override
	public void actualizarMonedaOriginal(int id, String moneda, int modificado_por) throws DataAccessException{
		String sql="UPDATE ORDENES set moneda = ?, modificado_por = ? where id=?";
		jdbcTemplate.update(sql,moneda,modificado_por,id);
	}

	@Override
	public AtributoEspecialConsulta buscarClienteEspeciales(int id) throws DataAccessException{
		String json = jdbcTemplate.queryForObject("SELECT JSON_CONSULTA_ULT_CAMBIO(?,'CLIENTE')",String.class, id);
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		mapper.setDateFormat(dateFormat);
		AtributoEspecialConsulta cliente=null;
		try {
			cliente = mapper.readValue(json, new TypeReference<AtributoEspecialConsulta>(){});
		} catch (Exception e) {}
		return cliente;
	}

	@Override
	public AtributoEspecialConsulta buscarMonedaEspeciales(int id) throws DataAccessException{
		String json = jdbcTemplate.queryForObject("SELECT JSON_CONSULTA_ULT_CAMBIO(?,'MONEDA')",String.class, id);
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		mapper.setDateFormat(dateFormat);
		AtributoEspecialConsulta moneda=null;
		try {
			moneda = mapper.readValue(json, new TypeReference<AtributoEspecialConsulta>(){});
		} catch (Exception e) {}
		return moneda;
	}

	@Override
	public OrdenFechasVista buscarFechasPorOrden(String numOrden) {
		OrdenFechasVista ofv = jdbcTemplate.queryForObject("SELECT * FROM ORDENES_FECHAS_V WHERE numero_orden=?",
				new OrdenFechasRM(), numOrden);
		return ofv;
	}
	
	@Override
	public List<Integer> consultarOrdenAAPendientesFacturar(int id) throws DataAccessException {
	   	String sql = "select DISTINCT(o.id)"
				+ " from ORDENES o"
				+ " join CLIENTES c on o.clientes_id=c.id"
				+ " join MARCAS_EQUIPOS ma on ma.id=o.MARCAS_EQUIPOS_id"
				+ " join MODELOS_EQUIPOS mo on mo.id=o.MODELOS_EQUIPOS_id"
				+ " join GIROS g on g.id=c.GIROS_id"
				+ " join AUTORIZACIONES a  on a.ORDENES_id=o.id"
				+ " join ACTIVIDADES_AUTORIZADAS aa on aa.AUTORIZACIONES_id=a.id"
				+ " where c.id=? and aa.importe_pendiente > 0 ";	    
	    return jdbcTemplate.queryForList(sql,Integer.class, id);
	}

	
	@Override
	public OrdenFactura buscarDatosFacturacion(int orden_id,String moneda,String idClienteFacturar) throws DataAccessException  {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("BUSCA_DATOS_FACT_ORDEN");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_id", orden_id);
		inParamMap.put("p_mon", moneda);
		inParamMap.put("p_idC", idClienteFacturar);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		OrdenFactura datos=new OrdenFactura();
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("p_id_orden") == 0) {
		            datos.setId_orden((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_numero_orden") == 0) {
		            datos.setNumero_orden((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_descripcion") == 0) {
		            datos.setDescripcion((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_id_cliente") == 0) {
		            datos.setId_cliente((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_nombre_fiscal") == 0) {
		            datos.setNombre_fiscal((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_id_cliente_facturar") == 0) {
		            datos.setId_cliente_facturar((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_nombre_fiscal_facturar") == 0) {
		            datos.setNombre_fiscal_facturar((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_moneda_facturar") == 0) {
		            datos.setMoneda_facturar((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_cotizado_facturar") == 0) {
		            datos.setImporte_cotizado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_autorizado_facturar") == 0) {
		            datos.setImporte_autorizado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_bajas_facturar") == 0) {
		            datos.setImporte_bajas_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_anticipo_facturar") == 0) {
		            datos.setImporte_anticipo_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_facturado_facturar") == 0) {
		            datos.setImporte_facturado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_descuento_facturar") == 0) {
		            datos.setImporte_descuento_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pagado_facturar") == 0) {
		            datos.setImporte_pagado_facturar((BigDecimal) entry.getValue());;
		        }else if (entry.getKey().compareTo("p_importe_pedido_facturar") == 0) {
		            datos.setImporte_pedido_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pendiente_facturar") == 0) {
		            datos.setImporte_pendiente_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_tipo_cambio") == 0) {
		            datos.setTipo_cambio((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_tipo_cambio_calculado") == 0) {
		            datos.setTipo_cambio_calculado((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pendiente_pago_facturar") == 0) {
		            datos.setImporte_pendiente_pago_facturar((BigDecimal) entry.getValue());
		        }
		    }
			return datos;
		}catch(Exception e){return null;}
	}

	@Override
	public OrdenFactura buscarDatosFacturacion(int orden_id, int idFactura) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("BUSCA_DATOS_FACT_ORDEN_PAGOS");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_idOrden", orden_id);
		inParamMap.put("p_idFactura", idFactura);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
	
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		OrdenFactura datos=new OrdenFactura();
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("p_id_orden") == 0) {
		            datos.setId_orden((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_numero_orden") == 0) {
		            datos.setNumero_orden((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_descripcion") == 0) {
		            datos.setDescripcion((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_id_cliente") == 0) {
		            datos.setId_cliente((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_nombre_fiscal") == 0) {
		            datos.setNombre_fiscal((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_id_cliente_facturar") == 0) {
		            datos.setId_cliente_facturar((Integer)entry.getValue());
		        }else if (entry.getKey().compareTo("p_nombre_fiscal_facturar") == 0) {
		            datos.setNombre_fiscal_facturar((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_moneda_facturar") == 0) {
		            datos.setMoneda_facturar((String)entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_cotizado_facturar") == 0) {
		            datos.setImporte_cotizado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_autorizado_facturar") == 0) {
		            datos.setImporte_autorizado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_bajas_facturar") == 0) {
		            datos.setImporte_bajas_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_anticipo_facturar") == 0) {
		            datos.setImporte_anticipo_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_facturado_facturar") == 0) {
		            datos.setImporte_facturado_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_descuento_facturar") == 0) {
		            datos.setImporte_descuento_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pagado_facturar") == 0) {
		            datos.setImporte_pagado_facturar((BigDecimal) entry.getValue());;
		        }else if (entry.getKey().compareTo("p_importe_pedido_facturar") == 0) {
		            datos.setImporte_pedido_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pendiente_facturar") == 0) {
		            datos.setImporte_pendiente_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_tipo_cambio") == 0) {
		            datos.setTipo_cambio((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_tipo_cambio_calculado") == 0) {
		            datos.setTipo_cambio_calculado((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_importe_pendiente_pago_facturar") == 0) {
		            datos.setImporte_pendiente_pago_facturar((BigDecimal) entry.getValue());
		        }else if (entry.getKey().compareTo("p_facturas") == 0) {
		        	ObjectMapper mapper = new ObjectMapper();
		    		try {
		    			datos.setFacturas(mapper.readValue((String)entry.getValue(),Facturas[].class));
		    		} catch (Exception e) {
		    			datos.setFacturas(null); 
		    		}
		        }
		    }
			return datos;
		}catch(Exception e){return null;}
	}

	@Override
	public void sumarImporteBaja(int orden_id, BigDecimal importe_bajas) {
		String sql="UPDATE ORDENES set importe_bajas = (importe_bajas+?) WHERE id=?";
		jdbcTemplate.update(sql,importe_bajas,orden_id);
	}

	@Override
	public void restarImporteAutorizado(int orden_id, BigDecimal importe_autorizado) {
		String sql="UPDATE ORDENES set importe_autorizado = (importe_autorizado-?) WHERE id=?";
		jdbcTemplate.update(sql,importe_autorizado,orden_id);
	}

	@Override
	public List<Integer> consultarIdsFacturas(int orden_id) {
		String sql="SELECT REPLACE(REPLACE(REPLACE(JSON_EXTRACT(facturas,'$[*].id'),'\"\',''),'[',''),']','') FROM ORDENES o WHERE o.id=?";
		String ids= jdbcTemplate.queryForObject(sql, String.class,orden_id);
		if(ids!=null){
			String[] idsF = ids.split(", ");
			
			List<Integer> idsFactura=new ArrayList<Integer>();
			for (String id : idsF ) {
				idsFactura.add(Integer.parseInt(id));
			}
			return idsFactura;
		}else{
			return null;
		}
		
	}

	@Override
	public List<CotizacionVista> consultarCotizacionesAutorizadas(int id) {
		String sql="SELECT c.id,c.numero,c.anio,CONCAT(c.numero,'/',c.anio) AS numero_cotizacion,c.revision,"
				+ "c.encabezado,c.descripcion_general,c.fecha_cot,c.pie_pagina, c.pie_pagina_usuario,c.hora_cot,"
				+ "c.subtotal,c.descuento,c.descripcion_descto,c.iva,c.iva_retenido,"
				+ "c.total,c.moneda,c.activo,c.AREAS_id AS areas_id,"
				+ "c.COTIZACIONES_id_original AS cotizaciones_id_original,"
				+ "(SELECT AREAS.numero FROM AREAS WHERE (AREAS.id = c.AREAS_id)) AS narea,"
				+ "c.PERSONAL_id AS personal_id,"
				+ "(SELECT CONCAT(PERSONAL.nombre,' ',PERSONAL.paterno,' ',PERSONAL.materno) FROM PERSONAL WHERE (PERSONAL.id = c.PERSONAL_id)) AS personal,"
				+ "c.ORDENES_id AS ordenes_id,(SELECT ORDENES.numero FROM ORDENES WHERE (ORDENES.id = c.ORDENES_id)) AS orden,"
				+ "c.PRECOTIZACIONES_id AS precotizaciones_id,"
				+ "(SELECT PRECOTIZACIONES.numero FROM PRECOTIZACIONES WHERE (PRECOTIZACIONES.id = c.PRECOTIZACIONES_id)) AS precotizacion,"
				+ "c.CONTACTOS_id AS contactos_id,(SELECT CONTACTOS.nombre_contacto FROM CONTACTOS WHERE (CONTACTOS.id = c.CONTACTOS_id)) AS contactos "
				+ "FROM COTIZACIONES c "
				+ "WHERE c.id IN "
				+ "(SELECT COTIZACIONES_id FROM ENCABEZADOS_COTIZACIONES ec "
				+ "JOIN DETALLE_COTIZACIONES dc ON dc.ENCABEZADOS_COTIZACIONES_id=ec.id "
				+ "JOIN ACTIVIDADES_AUTORIZADAS aa ON aa.DETALLES_COTIZACIONES_id=dc.id "
				+ "JOIN AUTORIZACIONES a WHERE a.id=aa.AUTORIZACIONES_id AND a.ORDENES_id=?)";
		List<CotizacionVista> cotizaciones = jdbcTemplate.query(sql,new CotizacionVistaRM(),id);
		return cotizaciones;
	}

	@Override
	public List<OrdenVista> OrdenesporCliente(int idCliente,int anio) throws DataAccessException{
		List<OrdenVista> ov = jdbcTemplate.query("SELECT * FROM ORDENES_V ov WHERE ov.clientes_id=? and ov.anio=?", 
				new OrdenVistaRM(), idCliente,anio);
		return ov;
	}

	@Override
	public List<Integer> anioOrdenCliente(int idCliente) {
		List<Integer> o = jdbcTemplate.queryForList("SELECT DISTINCT(anio) FROM ORDENES where clientes_id=? ORDER BY anio DESC", 
				Integer.class,idCliente);
		return o;
	}

	@Override
	public List<PagosConsultaOrdenes> PagosporOrden(int idOrden) {
		String sql="select ff.id facturafinal_id, ff.tipo tipo_factura,ff.numero factura,ff.tipo_cambio tipo_cambio_factura, "
				+ "ff.fecha_factura, pd.id pagodetalle_id, p.id pago_id,p.fecha_pago,p.importe,p.folio pago, "
				+ "p.tipo_cambio_cliente tipo_cambio_fecha_pago, p.afectacion "
				+ "from   FACTURA_FINAL ff "
				+ "JOIN   PAGOS_DETALLE pd ON ((pd.FACTURA_FINAL_id = ff.id)) "
				+ "JOIN   PAGOS p ON ((p.id = pd.PAGOS_id)) "
				+ "where (FIND_IN_SET(ff.id,(SELECT IDS_FACTURAS_POR_ORDEN(?))) AND (p.activo = 1))";
		List<PagosConsultaOrdenes> p = jdbcTemplate.query(sql,new PagosConsultaOrdenesRM(),idOrden);
		return p;
	}
	
	
	
}
