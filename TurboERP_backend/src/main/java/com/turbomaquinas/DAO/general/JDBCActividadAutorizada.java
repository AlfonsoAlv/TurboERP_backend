package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.general.ActividadAutorizada;
import com.turbomaquinas.POJO.general.ActividadAutorizada.ListaFacts;
import com.turbomaquinas.POJO.general.ActividadAutorizadaFactura;
import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;

@Repository
public class JDBCActividadAutorizada implements ActividadAutorizadaDAO{
	
	public class Facts {

		private int id;  
		private int numero;
		
		public Facts() {
			super();
		}

		public Facts(int id, int numero) {
			this.id = id;
			this.numero = numero;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}
		
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int crear(ActividadAutorizada a) throws DataAccessException{
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("numero_referencia");
		columnas.add("tipo_actividad");
		columnas.add("suministro");
		columnas.add("planta");
		columnas.add("clase_actividad");
		columnas.add("importe_autorizado");
		columnas.add("importe_baja");
		columnas.add("importe_anticipo");
		columnas.add("importe_factura");
		columnas.add("creado_por");
		columnas.add("pedidos_id");
		columnas.add("pre_pedidos_id");
		columnas.add("OT_IRREGULARES_id");
		columnas.add("AUTORIZACIONES_id");
		columnas.add("DETALLES_COTIZACIONES_id");
		
		insert.setTableName("ACTIVIDADES_AUTORIZADAS");
		insert.setColumnNames(columnas);
	
		Map<String, Object> datos = new HashMap<>();
		datos.put("numero_referencia", a.getNumero_referencia());
		datos.put("tipo_actividad", a.getTipo_actividad());
		datos.put("suministro", a.getSuministro());
		datos.put("planta", a.getPlanta());
		datos.put("clase_actividad", a.getClase_actividad());
		datos.put("importe_autorizado", a.getImporte_autorizado());
		datos.put("importe_baja", a.getImporte_baja());
		datos.put("importe_anticipo", a.getImporte_anticipo());
		datos.put("importe_factura", a.getImporte_factura());
		datos.put("creado_por", a.getCreado_por());
		datos.put("pedidos_id", a.getPedidos_id());
		datos.put("pre_pedidos_id", a.getPre_pedidos_id());
		datos.put("ot_irregulares_id", a.getOt_irregulares_id());
		datos.put("autorizaciones_id", a.getAutorizaciones_id());
		datos.put("detalles_cotizaciones_id", a.getDetalles_cotizaciones_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public void actualizar(ActividadAutorizada a) throws DataAccessException{
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET "
				+ "numero_referencia=?, "
				+ "tipo_actividad=?, "
				+ "suministro=?, "
				+ "planta=?, "
				+ "clase_actividad=?, "
				+ "importe_autorizado=?, "
				+ "importe_baja=?, "
				+ "importe_anticipo=?, "
				+ "importe_factura=?, "
				+ "modificado_por=?, "
				+ "OT_IRREGULARES_id=?, "
				+ "AUTORIZACIONES_id=?, "
				+ "DETALLES_COTIZACIONES_id=? "
				+ "WHERE id=?", 
				a.getNumero_referencia(),
				a.getTipo_actividad(), 
				a.getSuministro(), 
				a.getPlanta(), 
				a.getClase_actividad(), 
				a.getImporte_autorizado(), 
				a.getImporte_baja(), 
				a.getImporte_anticipo(), 
				a.getImporte_factura(),
				a.getModificado_por(),
				a.getOt_irregulares_id(),
				a.getAutorizaciones_id(),
				a.getDetalles_cotizaciones_id(),
				a.getId());
	}

	@Override
	public ActividadAutorizadaVista buscar(int id) throws DataAccessException{
		ActividadAutorizadaVista av = jdbcTemplate.queryForObject("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V WHERE id=?", 
				new ActividadAutorizadaVistaRM(), id);
		return av;
	}

	@Override
	public List<ActividadAutorizadaVista> consultar() throws DataAccessException{
		List<ActividadAutorizadaVista> av = jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V", 
				new ActividadAutorizadaVistaRM());
		return av;
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorCotizacion(int id) throws DataAccessException {
		List<ActividadAutorizadaVista> apc= jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V a "
				+ " WHERE cotizaciones_id = ?", 
				new ActividadAutorizadaVistaRM(), id);
		return apc;
	}
	
	@Override
	public void regularizarPedidoPrepedido(int ordenId, int pedidosid, int prepedidosid, int modificadopor, String fecharegularizacion, int id) throws DataAccessException{
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET PEDIDOS_id=?, PRE_PEDIDOS_id=?, modificado_por=?, fecha_regularizacion=?, numero_referencia = ULTIMA_REF_OT(?) + 1 WHERE id=?", 
				pedidosid, prepedidosid, modificadopor, fecharegularizacion,ordenId, id);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorAutorizacion(int id) throws DataAccessException {
		List<ActividadAutorizadaVista> apa= jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V a "
				+ " WHERE autorizaciones_id = ?", 
				new ActividadAutorizadaVistaRM(), id);
		return apa;
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOrdenFiltradaPorClase(int id, String clase) throws DataAccessException {
		List<ActividadAutorizadaVista> apo= jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V aa "
				+ " JOIN AUTORIZACIONES a ON (a.id = aa.AUTORIZACIONES_id) WHERE a.ORDENES_ID = ? AND aa.clase_actividad= ?", 
				new ActividadAutorizadaVistaRM(), id, clase);
		return apo;
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOrden(int id) throws DataAccessException {
		List<ActividadAutorizadaVista> apo= jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V aa "
				+ " JOIN AUTORIZACIONES a ON (a.id = aa.AUTORIZACIONES_id) WHERE a.ORDENES_ID = ? ", 
				new ActividadAutorizadaVistaRM(), id);
		return apo;
	}

	@Override
	public void actualizarSolicitudBaja(int idSolicitud, List<Integer> actividadesIds) throws DataAccessException{
		String lista = null;
		for (int id: actividadesIds) {
			if(lista == null){
				lista = id+",";
			}else{
				lista = lista+id+",";
			}
				
		}
		lista = lista.substring(0, lista.length()-1);
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET SOLICITUD_BAJAS_ACTIVIDADES_id=? WHERE id IN ("+lista+")", 
				idSolicitud);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarAAPorOrdenSinPedido(int id) throws DataAccessException{
		List<ActividadAutorizadaVista> a = jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V AA WHERE EXISTS "
				+ "(SELECT * FROM AUTORIZACIONES A "
				+ "WHERE A.id = AA.AUTORIZACIONES_id AND ORDENES_id=?) AND pedidos_id IS NULL AND pre_pedidos_id IS NULL AND ot_irregulares_id=0", 
				new ActividadAutorizadaVistaRM(), id);
		return a;
	}
	
	@Override
	public void actualizarOTIrregular(int ordenId, int idOTirregular, List<Integer> actividadesIds) {
		String lista = null;
		for (int id: actividadesIds) {
			if(lista == null){
				lista = id+",";
			}else{
				lista = lista+id+",";
			}
				
		}
		lista = lista.substring(0, lista.length()-1);
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET OT_IRREGULARES_id=?, numero_referencia = ULTIMA_REF_OT(?) + 1 WHERE id IN ("+lista+")", 
				idOTirregular,ordenId);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOtiSinAceptar(int id) throws DataAccessException {
		List<ActividadAutorizadaVista> t = jdbcTemplate.query("SELECT * FROM ACTIVIDADES_AUTORIZADAS_V AA WHERE EXISTS "
				+ "(SELECT * FROM OT_IRREGULARES_V O "
				+ "WHERE O.id = AA.ot_irregulares_id  AND O.id = ?)", new ActividadAutorizadaVistaRM(), id);
		return t;
	}

	@Override
	public List<ActividadAutorizadaFactura> consultarAAPorOrdenPendienteFacturar (int id) throws DataAccessException{
		String sql="SELECT aa.id,(SELECT d.descripcion FROM DETALLE_COTIZACIONES d WHERE d.id=aa.DETALLES_COTIZACIONES_id) as descripcion, "
				+ "aa.tipo_actividad, e.id as encabezados_cotizaciones_id,e.descripcion as encabezados_cotizaciones_descripcion, "
				+ "(SELECT IF ((JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(?, 'MONEDA'),'$.tipo_cambio_calculado') IS NULL),importe_a_facturar,(importe_a_facturar*JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(?, 'MONEDA'),'$.tipo_cambio_calculado')))) AS importe_a_facturar, "
				+ "(SELECT IF ((JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(?, 'MONEDA'),'$.tipo_cambio_calculado') IS NULL),descuento_disponible,(descuento_disponible*JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(?, 'MONEDA'),'$.tipo_cambio_calculado')))) AS descuento_disponible "
				+ "FROM ACTIVIDADES_AUTORIZADAS aa "
				+ "JOIN DETALLE_COTIZACIONES d on aa.DETALLES_COTIZACIONES_id=d.id "
				+ "JOIN ENCABEZADOS_COTIZACIONES e on e.id=d.ENCABEZADOS_COTIZACIONES_id "
				+ "WHERE EXISTS (SELECT * FROM AUTORIZACIONES A WHERE A.id = aa.AUTORIZACIONES_id AND ORDENES_id=?) AND importe_a_facturar > 0 AND importe_baja=0";
		return jdbcTemplate.query(sql,new ActividadAutorizadaFacturaRM(), id,id,id,id,id);
	}

	@Override
	public void asignarFacts(int id, ListaFacts lista) throws DataAccessException {
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET facturas = ? WHERE id = ? ",
		lista.toString(), id);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facts> consultarFacts(int id) throws DataAccessException {
		String sql = "SELECT f.id, f.numero "
				+ "FROM ACTIVIDADES_AUTORIZADAS aa "
				+ "LEFT JOIN FACTURA_FINAL f ON JSON_CONTAINS(aa.facturas, CAST(f.id AS JSON), '$.ids') "
				+ "WHERE aa.id = ?";
		List<? extends Object> facts = jdbcTemplate.query(sql, 
			new RowMapper<Object>() {
			@Override
			public Object mapRow(ResultSet rs, int i) throws SQLException {
				return new Facts(rs.getInt("id"), rs.getInt("numero"));
			}
		}, id);
		return (List<Facts>) facts;
	}


    @Override
	public int buscarOrdenPorAAOTI(Integer idAA) {
		String sql = "SELECT ORDENES_id FROM AUTORIZACIONES WHERE id = (SELECT AUTORIZACIONES_id FROM ACTIVIDADES_AUTORIZADAS WHERE id = ?)";
		int id = jdbcTemplate.queryForObject(sql, Integer.class,idAA);
		return id;
	}

	@Override
	public int buscarOrdenPorAA(int id_actividad_autorizada) {
		String sql = "SELECT ORDENES_id FROM AUTORIZACIONES WHERE id = (SELECT AUTORIZACIONES_id FROM ACTIVIDADES_AUTORIZADAS WHERE id = ?)";
		int id = jdbcTemplate.queryForObject(sql, Integer.class, id_actividad_autorizada);
		return id;
	}

	@Override
	public List<ActividadAutorizadaFactura> consultarAAPorIds(List<Integer> actividadesIds) {
		String lista = null;
		for (int id: actividadesIds) {
			if(lista == null){
				lista = ""+id;
			}else{
				lista = lista+","+id;
			}				
		}		
		lista+=")"; 
		String sql="SELECT aa.id,(SELECT d.descripcion FROM DETALLE_COTIZACIONES d WHERE d.id=aa.DETALLES_COTIZACIONES_id) as descripcion,  "
				+ "aa.tipo_actividad, e.id as encabezados_cotizaciones_id,e.descripcion as encabezados_cotizaciones_descripcion, "
				+ "(SELECT IF ((JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(a.ORDENES_id, 'MONEDA'),'$.tipo_cambio_calculado') IS NULL),importe_a_facturar,(importe_a_facturar*JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(a.ORDENES_id, 'MONEDA'),'$.tipo_cambio_calculado')))) AS importe_a_facturar,  "
				+ "(SELECT IF ((JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(a.ORDENES_id, 'MONEDA'),'$.tipo_cambio_calculado') IS NULL),descuento_disponible,(descuento_disponible*JSON_EXTRACT(JSON_CONSULTA_ULT_CAMBIO(a.ORDENES_id, 'MONEDA'),'$.tipo_cambio_calculado')))) AS descuento_disponible  "
				+ "FROM ACTIVIDADES_AUTORIZADAS aa "
				+ "JOIN AUTORIZACIONES a ON a.id=aa.AUTORIZACIONES_id "
				+ "JOIN DETALLE_COTIZACIONES d on aa.DETALLES_COTIZACIONES_id=d.id "
				+ "JOIN ENCABEZADOS_COTIZACIONES e on e.id=d.ENCABEZADOS_COTIZACIONES_id "
				+ "WHERE aa.id IN ("+lista;
		return jdbcTemplate.query(sql,new ActividadAutorizadaFacturaRM());
	}

	@Override
	public void actualizarImporteBaja(int idSolicitud) {
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET importe_baja= importe_autorizado WHERE SOLICITUD_BAJAS_ACTIVIDADES_id = ?",idSolicitud);
	}

	@Override
	public void desactivarAAPorSolicitud(int idSolicitud) {
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET activo=0 WHERE SOLICITUD_BAJAS_ACTIVIDADES_id = ?",idSolicitud);
	}


}
