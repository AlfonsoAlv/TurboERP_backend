package com.turbomaquinas.DAO.comercial;

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

import com.turbomaquinas.POJO.comercial.DetalleCotizacion;
import com.turbomaquinas.POJO.comercial.DetalleCotizacionVista;

@Repository
public class JDBCDetalleCotizacion implements DetalleCotizacionDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public class ActividadCotizacion {
		private int id;
		private String descripcion;
		private int planta;
		private float importe;
		private int encabezados_cotizaciones_id;
		private String descripcionEncabezado;
		private int detalle_diagnostico_id;
		
		public ActividadCotizacion(int id, String descripcion, int planta, float importe,
				int encabezados_cotizaciones_id, String descripcionEncabezado, int detalle_diag_id) {
			super();
			this.id = id;
			this.descripcion = descripcion;
			this.planta = planta;
			this.importe = importe;
			this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
			this.descripcionEncabezado = descripcionEncabezado;
			this.detalle_diagnostico_id = detalle_diag_id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getPlanta() {
			return planta;
		}

		public void setPlanta(int planta) {
			this.planta = planta;
		}

		public float getImporte() {
			return importe;
		}

		public void setImporte(float importe) {
			this.importe = importe;
		}

		public int getEncabezados_cotizaciones_id() {
			return encabezados_cotizaciones_id;
		}

		public void setEncabezados_cotizaciones_id(int encabezados_cotizaciones_id) {
			this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
		}

		public String getDescripcionEncabezado() {
			return descripcionEncabezado;
		}

		public void setDescripcionEncabezado(String descripcionEncabezado) {
			this.descripcionEncabezado = descripcionEncabezado;
		}

		public int getDetalle_diagnostico_id() {
			return detalle_diagnostico_id;
		}

		public void setDetalle_diagnostico_id(int detalle_diagnostico_id) {
			this.detalle_diagnostico_id = detalle_diagnostico_id;
		}		
		
	}

	@Override
	public int crear(DetalleCotizacion dc) throws DataAccessException {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("descripcion");
		columnas.add("tipo_actividad");
		columnas.add("lugar");
		columnas.add("suministro");
		columnas.add("planta");
		columnas.add("clase_actividad");
		columnas.add("importe");
		columnas.add("creado_por");
		columnas.add("ENCABEZADOS_COTIZACIONES_id");
		columnas.add("DETALLE_DIAGNOSTICO_id");

		insert.setTableName("DETALLE_COTIZACIONES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("descripcion", dc.getDescripcion());
		datos.put("tipo_actividad", dc.getTipo_actividad());
		datos.put("lugar", dc.getLugar());
		datos.put("suministro", dc.getSuministro());
		datos.put("planta", dc.getPlanta());
		datos.put("clase_actividad", dc.getClase_actividad());
		datos.put("importe", dc.getImporte());
		datos.put("creado_por", dc.getCreado_por());
		datos.put("ENCABEZADOS_COTIZACIONES_id", dc.getEncabezados_cotizaciones_id());
		datos.put("DETALLE_DIAGNOSTICO_id", dc.getDetalle_diagnostico_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public void actualizar(DetalleCotizacion dc) throws DataAccessException {
		jdbcTemplate.update("UPDATE DETALLE_COTIZACIONES SET "
				+ "descripcion=?, "
				+ "tipo_actividad=?, "
				+ "lugar=?, "
				+ "suministro=?, "
				+ "planta=?, "
				+ "clase_actividad=?, "
				+ "importe=?, "
				+ "activo=?, "
				+ "modificado_por=? "
				+ "WHERE id=?", 
				dc.getDescripcion(), 
				dc.getTipo_actividad(), 
				dc.getLugar(), 
				dc.getSuministro(), 
				dc.getPlanta(), 
				dc.getClase_actividad(), 
				dc.getImporte(), 
				dc.getActivo(), 
				dc.getModificado_por(), 
				dc.getId());
	}

	@Override
	public DetalleCotizacionVista buscar(int id) throws DataAccessException {
		DetalleCotizacionVista dcv = jdbcTemplate.queryForObject("SELECT"
				+ "`d`.`id`                     AS `id`,"
				+ "`d`.`descripcion`            AS `descripcion`,"
				+ "`d`.`tipo_actividad`         AS `tipo_actividad`,"
				+ "`d`.`lugar`                  AS `lugar`,"
				+ "`d`.`suministro`             AS `suministro`,"
				+ "`d`.`planta`                 AS `planta`,"
				+ "`d`.`importe`                AS `importe`,"
				+ "`d`.`clase_actividad`        AS `clase_actividad`,"
				+ "`d`.`activo`                 AS `activo`,"
				+ "`d`.`DETALLE_DIAGNOSTICO_id` AS `detalle_diagnostico_id`,"
				+ "`e`.`id`                     AS `encabezados_cotizaciones_id`,"
				+ "`e`.`descripcion`            AS `descripcionEncabezado`,"
				+ "`e`.`lugar`                  AS `lugarEncabezado`,"
				+ "`c`.`id`                     AS `cotizaciones_id`,"
				+ "`c`.`numero`                 AS `numerocotizacion`,"
				+ "`c`.`anio`                   AS `aniocotizacion`, "
				+ "(SELECT "
				+ "(CASE WHEN EXISTS(SELECT 1 FROM `ACTIVIDADES_AUTORIZADAS` "
				+ "WHERE (`ACTIVIDADES_AUTORIZADAS`.`DETALLES_COTIZACIONES_id` = `d`.`id` AND JSON_LENGTH(ACTIVIDADES_AUTORIZADAS.`facturas`) > 0)) "
				+ "THEN 1 ELSE 0 END)) AS `facturado`, "
				+ "(SELECT "
				+ "(CASE WHEN EXISTS(SELECT 1 FROM `ACTIVIDADES_AUTORIZADAS` "
				+ "WHERE (`ACTIVIDADES_AUTORIZADAS`.`DETALLES_COTIZACIONES_id` = `d`.`id`)) THEN 1 ELSE 0 END)) AS `autorizado`,"
				+ "(SELECT COALESCE(COUNT(0),0) FROM `SUBINDICES_COTIZACIONES` "
				+ "WHERE ((`SUBINDICES_COTIZACIONES`.`DETALLE_COTIZACIONES_id` = `d`.`id`) "
				+ "AND (`SUBINDICES_COTIZACIONES`.`activo` = 1))) AS `cant_subindices` "
				+ "FROM ((`DETALLE_COTIZACIONES` `d` "
				+ "JOIN `ENCABEZADOS_COTIZACIONES` `e` "
				+ "ON ((`e`.`id` = `d`.`ENCABEZADOS_COTIZACIONES_id`))) "
				+ "JOIN `COTIZACIONES` `c` "
				+ "ON ((`c`.`id` = `e`.`COTIZACIONES_id`))) WHERE (`d`.`activo` = 1) AND d.id=?", 
				new DetalleCotizacionVistaRM(), id);
		return dcv;
	}

	@Override
	public List<DetalleCotizacionVista> consultar() throws DataAccessException {
		List<DetalleCotizacionVista> dcl = jdbcTemplate.query("SELECT * FROM DETALLE_COTIZACIONES_V ",
				new DetalleCotizacionVistaRM());
		return dcl;
	}

	@Override
	public int recuperarUltimoLugar(int encabezadoID) throws DataAccessException {
		int maximo = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(lugar), 0) FROM DETALLE_COTIZACIONES "+
				"WHERE ENCABEZADOS_COTIZACIONES_id = ? AND activo = 1", Integer.class, encabezadoID);
		return maximo;
	}

	@Override
	public List<DetalleCotizacionVista> consultarPorCotizacion(int id) throws DataAccessException {
		List<DetalleCotizacionVista> dv = jdbcTemplate.query("SELECT"
				+ "`d`.`id`                     AS `id`,"
				+ "`d`.`descripcion`            AS `descripcion`,"
				+ "`d`.`tipo_actividad`         AS `tipo_actividad`,"
				+ "`d`.`lugar`                  AS `lugar`,"
				+ "`d`.`suministro`             AS `suministro`,"
				+ "`d`.`planta`                 AS `planta`,"
				+ "`d`.`importe`                AS `importe`,"
				+ "`d`.`clase_actividad`        AS `clase_actividad`,"
				+ "`d`.`activo`                 AS `activo`,"
				+ "`d`.`DETALLE_DIAGNOSTICO_id` AS `detalle_diagnostico_id`,"
				+ "`e`.`id`                     AS `encabezados_cotizaciones_id`,"
				+ "`e`.`descripcion`            AS `descripcionEncabezado`,"
				+ "`e`.`lugar`                  AS `lugarEncabezado`,"
				+ "`c`.`id`                     AS `cotizaciones_id`,"
				+ "`c`.`numero`                 AS `numerocotizacion`,"
				+ "`c`.`anio`                   AS `aniocotizacion`, "
				+ "(SELECT "
				+ "(CASE WHEN EXISTS(SELECT 1 FROM `ACTIVIDADES_AUTORIZADAS` "
				+ "WHERE (`ACTIVIDADES_AUTORIZADAS`.`DETALLES_COTIZACIONES_id` = `d`.`id` AND JSON_LENGTH(ACTIVIDADES_AUTORIZADAS.`facturas`) > 0)) "
				+ "THEN 1 ELSE 0 END)) AS `facturado`, "
				+ "(SELECT "
				+ "(CASE WHEN EXISTS(SELECT 1 FROM `ACTIVIDADES_AUTORIZADAS` "
				+ "WHERE (`ACTIVIDADES_AUTORIZADAS`.`DETALLES_COTIZACIONES_id` = `d`.`id`)) THEN 1 ELSE 0 END)) AS `autorizado`,"
				+ "(SELECT COALESCE(COUNT(0),0) FROM `SUBINDICES_COTIZACIONES` "
				+ "WHERE ((`SUBINDICES_COTIZACIONES`.`DETALLE_COTIZACIONES_id` = `d`.`id`) "
				+ "AND (`SUBINDICES_COTIZACIONES`.`activo` = 1))) AS `cant_subindices` "
				+ "FROM ((`DETALLE_COTIZACIONES` `d` "
				+ "JOIN `ENCABEZADOS_COTIZACIONES` `e` "
				+ "ON ((`e`.`id` = `d`.`ENCABEZADOS_COTIZACIONES_id`))) "
				+ "JOIN `COTIZACIONES` `c` "
				+ "ON ((`c`.`id` = `e`.`COTIZACIONES_id`))) WHERE (`d`.`activo` = 1) AND c.id=? "
				+ "ORDER BY lugarEncabezado, lugar", 
		new DetalleCotizacionVistaRM(), id);
		return dv;
	}
	
	@Override
	public int consultarCantidadPorEncabezado(int id) {
		int cantidad = jdbcTemplate.queryForObject("SELECT COALESCE(COUNT(*), 0) FROM DETALLE_COTIZACIONES "+
				"WHERE ENCABEZADOS_COTIZACIONES_id = ? AND activo = 1", Integer.class, id);
		return cantidad;
	}
	
	@Override
	public void reordenar_actualiza(int encabezadoID, int lugarDestino, int lugarOrigen) {
		jdbcTemplate.update("CALL REORDENA_DC_LUGAR_ACTUALIZA(?, ?, ?)", 
							encabezadoID, lugarDestino, lugarOrigen);	
	}
	
	@Override
	public void reordenar_elimina(int encabezados_cotizaciones_id, int lugarOrigen) {
		jdbcTemplate.update("CALL REORDENA_DC_LUGAR_ELIMINA(?, ?)", 
				encabezados_cotizaciones_id, lugarOrigen);
	}

	@Override
	public List<DetalleCotizacionVista> consultarPorEncabezado(int id) {
		List<DetalleCotizacionVista> dc = jdbcTemplate.query("SELECT * FROM DETALLE_COTIZACIONES_V "
				+ "WHERE ENCABEZADOS_COTIZACIONES_id = ? ORDER BY lugar", new DetalleCotizacionVistaRM(), id);
		return dc;
	}

	@Override
	public List<DetalleCotizacionVista> consultarSinAutorizar(int id) {
		String sql="SELECT d.id,d.descripcion,d.tipo_actividad,d.lugar,d.suministro,d.planta, "
				+ "d.importe,d.clase_actividad,d.activo,d.DETALLE_DIAGNOSTICO_id AS detalle_diagnostico_id, "
				+ "e.id AS encabezados_cotizaciones_id, e.descripcion AS descripcionEncabezado, "
				+ "e.lugar AS lugarEncabezado,c.id AS cotizaciones_id, c.numero AS numerocotizacion, c.anio AS aniocotizacion, "
				+ "(SELECT COALESCE(COUNT(0), 0) FROM SUBINDICES_COTIZACIONES WHERE((SUBINDICES_COTIZACIONES.DETALLE_COTIZACIONES_id = d.id) AND (SUBINDICES_COTIZACIONES.activo = 1))) AS cant_subindices, "
				+ "(SELECT (CASE WHEN EXISTS( SELECT  1  FROM ACTIVIDADES_AUTORIZADAS WHERE (ACTIVIDADES_AUTORIZADAS.DETALLES_COTIZACIONES_id = d.id)) THEN 1 ELSE 0 END)) AS autorizado "
				+ "FROM DETALLE_COTIZACIONES d "
				+ "JOIN ENCABEZADOS_COTIZACIONES e ON e.id=d.ENCABEZADOS_COTIZACIONES_id "
				+ "JOIN COTIZACIONES c on c.id=e.COTIZACIONES_id "
				+ "WHERE d.activo=1 AND cotizaciones_id = ? AND "
				+ "NOT EXISTS (SELECT * FROM ACTIVIDADES_AUTORIZADAS WHERE DETALLES_COTIZACIONES_id = d.id) "
				+ "ORDER BY lugarEncabezado, lugar";
		List<DetalleCotizacionVista> dcv = jdbcTemplate.query(sql, new DetalleCotizacionVistaRM(), id);
		return dcv;
	}

	@Override
	public boolean esPlanta(int detalleCotizacionId) {
		int planta = jdbcTemplate.queryForObject("SELECT planta FROM `DETALLE_COTIZACIONES` d WHERE d.`id` = ?", Integer.class, detalleCotizacionId);
		return (planta == 1);
	}
	
	@Override
	public void actualizarImporte(int id, float importe) {
		jdbcTemplate.update("UPDATE DETALLE_COTIZACIONES SET importe = ? WHERE id = ?", importe, id);
		jdbcTemplate.update("UPDATE ACTIVIDADES_AUTORIZADAS SET importe_autorizado = ? WHERE DETALLES_COTIZACIONES_id = ?",
					importe, id);
	}

	@Override
	public List<ActividadCotizacion> consultarPorListaId(List<Integer> ids) {
		String lista = null;
		for (int id: ids) {
			if(lista == null){
				lista = id+",";
			}else{
				lista = lista+id+",";
			}
				
		}
		lista = lista.substring(0, lista.length()-1);
		// List<DetalleCotizacionVista> detalles = jdbcTemplate.query("SELECT D.id, D.`descripcion`, D.`planta`, D.importe, D.`ENCABEZADOS_COTIZACIONES_id` encabezados_cotizaciones_id, E.`descripcion` descripcionEncabezado FROM DETALLE_COTIZACIONES D JOIN `ENCABEZADOS_COTIZACIONES` E ON (E.`id` = D.`ENCABEZADOS_COTIZACIONES_id`) WHERE D.id IN ("+lista+")", new DetalleCotizacionVistaRM());
		String sql = "SELECT D.id, D.descripcion, D.planta, D.importe, D.ENCABEZADOS_COTIZACIONES_id encabezados_cotizaciones_id, E.descripcion descripcionEncabezado, D.DETALLE_DIAGNOSTICO_id detalle_diagnostico_id FROM DETALLE_COTIZACIONES D JOIN `ENCABEZADOS_COTIZACIONES` E ON (E.`id` = D.`ENCABEZADOS_COTIZACIONES_id`) WHERE D.id IN ("+lista+")";
		List<ActividadCotizacion> detalles = jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int i) throws SQLException {
				return new ActividadCotizacion(rs.getInt("id"), 
											   rs.getString("descripcion"),
											   rs.getInt("planta"),
											   rs.getFloat("importe"),
											   rs.getInt("encabezados_cotizaciones_id"),
											   rs.getString("descripcionEncabezado"),
											   rs.getInt("detalle_diagnostico_id")
											   );
			}
			
		});
		
		return detalles;
	}
}
