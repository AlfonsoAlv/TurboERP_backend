package com.turbomaquinas.DAO.calidad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.GarantiaOrden;

@Repository
public class JDBCDetalleGarantia implements DetalleGarantiaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DetalleGarantiaVista> consultarPorGarantia(int id) throws DataAccessException {
		List<DetalleGarantiaVista> dv = jdbcTemplate.query("SELECT"
				+ "`d`.`id`                     AS `id`,"
				+ "`d`.`descripcion`            AS `descripcion`,"
				+ "`d`.`lugar`                  AS `lugar`,"
				+ "`d`.`planta`                 AS `planta`,"
				+ "`d`.`activo`                 AS `activo`,"
				+ "`d`.`DETALLE_DIAGNOSTICO_id` AS `detalle_diagnostico_id`,"
				+ "`e`.`id`                     AS `encabezados_garantias_id`,"
				+ "`e`.`descripcion`            AS `descripcionEncabezado`,"
				+ "`e`.`lugar`                  AS `lugarEncabezado`,"
				+ "`g`.`id`                     AS `garantias_id`,"
				+"d.procede,d.motivo_procede,d.creado_por,d.creado,d.modificado_por,"
				+ "d.modificado,d.referencia,d.fecha_terminacion,d.PERSONAL_terminado_id as personal_terminado_id,"
				+ "d.departamentos,d.ENCABEZADOS_GARANTIA_id encabezados_garantia_id,d.INSATISFACCIONES_id as insatisfacciones_id,"
				+ "(SELECT i.descripcion_insatisfaccion FROM INSATISFACCIONES_CLIENTES i WHERE i.id=d.INSATISFACCIONES_id) AS descripcion_insatisfaccion,"
				+ "(SELECT i.folio FROM INSATISFACCIONES_CLIENTES i WHERE i.id=d.INSATISFACCIONES_id) AS folio_insatisfaccion,"
				+ "(SELECT COALESCE(COUNT(0),0) FROM `SUBINDICES_GARANTIA` "
				+ "WHERE ((`SUBINDICES_GARANTIA`.`DETALLE_GARANTIAS_id` = `d`.`id`) "
				+ "AND (`SUBINDICES_GARANTIA`.`activo` = 1))) AS `cant_subindices` "
				+ "FROM ((`DETALLE_GARANTIAS` `d` "
				+ "JOIN `ENCABEZADOS_GARANTIA` `e` "
				+ "ON ((`e`.`id` = `d`.`ENCABEZADOS_GARANTIA_id`))) "
				+ "JOIN `GARANTIAS` `g` "
				+ "ON ((`g`.`id` = `e`.`GARANTIAS_id`))) WHERE (`d`.`activo` = 1) AND g.id= ? "
				+ "ORDER BY lugarEncabezado, lugar", 
		new DetalleGarantiaVistaRM(), id);
		return dv;
	}

	@Override
	public DetalleGarantiaVista buscar(int id) {
		DetalleGarantiaVista dv = jdbcTemplate.queryForObject("SELECT"
				+ "`d`.`id`                     AS `id`,"
				+ "`d`.`descripcion`            AS `descripcion`,"
				+ "`d`.`lugar`                  AS `lugar`,"
				+ "`d`.`planta`                 AS `planta`,"
				+ "`d`.`activo`                 AS `activo`,"
				+ "`d`.`DETALLE_DIAGNOSTICO_id` AS `detalle_diagnostico_id`,"
				+ "`e`.`id`                     AS `encabezados_garantias_id`,"
				+ "`e`.`descripcion`            AS `descripcionEncabezado`,"
				+ "`e`.`lugar`                  AS `lugarEncabezado`,"
				+ "`g`.`id`                     AS `garantias_id`,"
				+"d.procede,d.motivo_procede,d.creado_por,d.creado,d.modificado_por,"
				+ "d.modificado,d.referencia,d.fecha_terminacion,d.PERSONAL_terminado_id as personal_terminado_id,"
				+ "d.departamentos,d.ENCABEZADOS_GARANTIA_id encabezados_garantia_id,d.INSATISFACCIONES_id as insatisfacciones_id,"
				+ "(SELECT i.descripcion_insatisfaccion FROM INSATISFACCIONES_CLIENTES i WHERE i.id=d.INSATISFACCIONES_id) AS descripcion_insatisfaccion,"
				+ "(SELECT i.folio FROM INSATISFACCIONES_CLIENTES i WHERE i.id=d.INSATISFACCIONES_id) AS folio_insatisfaccion,"
				+ "(SELECT COALESCE(COUNT(0),0) FROM `SUBINDICES_GARANTIA` "
				+ "WHERE ((`SUBINDICES_GARANTIA`.`DETALLE_GARANTIAS_id` = `d`.`id`) "
				+ "AND (`SUBINDICES_GARANTIA`.`activo` = 1))) AS `cant_subindices` "
				+ "FROM ((`DETALLE_GARANTIAS` `d` "
				+ "JOIN `ENCABEZADOS_GARANTIA` `e` "
				+ "ON ((`e`.`id` = `d`.`ENCABEZADOS_GARANTIA_id`))) "
				+ "JOIN `GARANTIAS` `g` "
				+ "ON ((`g`.`id` = `e`.`GARANTIAS_id`))) WHERE (`d`.`activo` = 1) AND d.id = ? "
				+ "ORDER BY lugarEncabezado, lugar", new DetalleGarantiaVistaRM(), id);
		return dv;
	}

	@Override
	public void actualizarDetalles(String detallesJSON) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("ACTUALIZAR_DETALLES_GARANTIA");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("detallesJSON", detallesJSON);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);	
		simpleJdbcCall.execute(in);
	}
	
	@Override
	public List<GarantiaOrden> consultarPorOrdenSinOIT(int idOrden) throws DataAccessException{
		String sql = "SELECT g.id garantia_id, g.descripcion descripcion_garantia, eg.id encabezado_garantia_id, eg.descripcion descripcion_encabezado, "
				+ "dg.id detalle_garantia_id, dg.descripcion descripcion_detalle, dg.fecha_terminacion "
				+ "FROM GARANTIAS g "
				+ "JOIN ENCABEZADOS_GARANTIA eg ON eg.GARANTIAS_id=g.id "
				+ "JOIN DETALLE_GARANTIAS dg ON eg.id=dg.ENCABEZADOS_GARANTIA_id "
				+ "WHERE g.ORDENES_id=? "
				+ "AND NOT EXISTS (SELECT * FROM ORIGEN_GARANTIA WHERE DETALLE_GARANTIAS_id = dg.id)";
		List<GarantiaOrden> go = jdbcTemplate.query(sql, new GarantiaOrdenRM(),idOrden);
		return go;
	}
	
	
	
}
