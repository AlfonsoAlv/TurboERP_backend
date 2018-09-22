package com.turbomaquinas.DAO.comercial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.comercial.Cotizacion;
import com.turbomaquinas.POJO.comercial.CotizacionVista;

@Repository
public class JDBCCotizacion implements CotizacionDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int crear(Cotizacion c) throws DataAccessException {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("encabezado");
		columnas.add("descripcion_general");
		columnas.add("pie_pagina");
		columnas.add("pie_pagina_usuario");
		columnas.add("descripcion_descto");
		columnas.add("moneda");
		columnas.add("creado_por");
		columnas.add("AREAS_id");
		columnas.add("PERSONAL_id");
		columnas.add("ORDENES_id");
		columnas.add("PRECOTIZACIONES_id");
		columnas.add("CONTACTOS_id");
		columnas.add("revision");
		columnas.add("COTIZACIONES_id_original");
		columnas.add("numero");
		columnas.add("anio");


		insert.setTableName("COTIZACIONES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("encabezado", c.getEncabezado());
		datos.put("descripcion_general", c.getDescripcion_general());
		datos.put("pie_pagina", c.getPie_pagina());
		datos.put("pie_pagina_usuario", c.getPie_pagina_usuario());
		datos.put("descripcion_descto", c.getDescripcion_descto());
		datos.put("moneda", c.getMoneda());
		datos.put("creado_por", c.getCreado_por());
		datos.put("AREAS_id", c.getAreas_id());
		datos.put("PERSONAL_id", c.getPersonal_id());
		datos.put("ORDENES_id", c.getOrdenes_id());
		datos.put("PRECOTIZACIONES_id", c.getPrecotizaciones_id());
		datos.put("CONTACTOS_id", c.getContactos_id());
		datos.put("revision", c.getRevision());
		datos.put("COTIZACIONES_id_original", c.getCotizaciones_id_original());
		datos.put("numero", c.getNumero());
		datos.put("anio", c.getAnio());
			
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public Cotizacion actualizar(Cotizacion c) throws DataAccessException {
		jdbcTemplate.update("UPDATE COTIZACIONES SET encabezado = ?, descripcion_general = ?, pie_pagina = ?, "
				+ "pie_pagina_usuario=?, descripcion_descto = ?, moneda = ?, modificado_por = ?, AREAS_id = ?, PERSONAL_id = ?, "
				+ "ORDENES_id = ?, PRECOTIZACIONES_id = ?, CONTACTOS_id = ? WHERE id = ?", 
				c.getEncabezado(), c.getDescripcion_general(), c.getPie_pagina(), c.getPie_pagina_usuario(), c.getDescripcion_descto(), 
				c.getMoneda(), c.getModificado_por(), c.getAreas_id(), c.getPersonal_id(),
				c.getOrdenes_id(), c.getPrecotizaciones_id(), c.getContactos_id(), c.getId());
		return c;
	}

	@Override
	public CotizacionVista buscar(int id) throws DataAccessException {
		CotizacionVista cot = jdbcTemplate.queryForObject("SELECT "
				+ "`c`.`id`                       AS `id`,"
				+ "`c`.`numero`                   AS `numero`,"
				+ "`c`.`anio`                     AS `anio`,"
				+ "CONCAT(`c`.`numero`,'/',`c`.`anio`) AS `numero_cotizacion`,"
				+ "`c`.`revision`                 AS `revision`,"
				+ "`c`.`encabezado`               AS `encabezado`,"
				+ "`c`.`descripcion_general`      AS `descripcion_general`,"
				+ "`c`.`pie_pagina`               AS `pie_pagina`,"
				+ "`c`.`pie_pagina_usuario`       AS `pie_pagina_usuario`,"
				+ "`c`.`fecha_cot`                AS `fecha_cot`,"
				+ "`c`.`hora_cot`                 AS `hora_cot`,"
				+ "`c`.`subtotal`                 AS `subtotal`,"
				+ "`c`.`descuento`                AS `descuento`,"
				+ "`c`.`descripcion_descto`       AS `descripcion_descto`,"
				+ "`c`.`iva`                      AS `iva`,"
				+ "`c`.`iva_retenido`             AS `iva_retenido`,"
				+ "`c`.`total`                    AS `total`,"
				+ "`c`.`moneda`                   AS `moneda`,"
				+ "`c`.`activo`                   AS `activo`,"
				+ "`c`.`AREAS_id`                 AS `areas_id`,"
				+ "`c`.`COTIZACIONES_id_original` AS `cotizaciones_id_original`,"
				+ "(SELECT `AREAS`.`numero` FROM `AREAS`"
				+ " WHERE (`AREAS`.`id` = `c`.`AREAS_id`)) AS `narea`,"
				+ "`c`.`PERSONAL_id`              AS `personal_id`,"
				+ "(SELECT CONCAT(`PERSONAL`.`nombre`,' ',`PERSONAL`.`paterno`,' ',`PERSONAL`.`materno`) FROM `PERSONAL`"
				+ " WHERE (`PERSONAL`.`id` = `c`.`PERSONAL_id`)) AS `personal`,"
				+ "`c`.`ORDENES_id`               AS `ordenes_id`,"
				+ "(SELECT `ORDENES`.`numero` FROM `ORDENES`"
				+ " WHERE (`ORDENES`.`id` = `c`.`ORDENES_id`)) AS `orden`,"
				+ "`c`.`PRECOTIZACIONES_id`       AS `precotizaciones_id`,"
				+ "(SELECT `PRECOTIZACIONES`.`numero` FROM `PRECOTIZACIONES`"
				+ " WHERE (`PRECOTIZACIONES`.`id` = `c`.`PRECOTIZACIONES_id`)) AS `precotizacion`,"
				+ "`c`.`CONTACTOS_id`             AS `contactos_id`,"
				+ "(SELECT `CONTACTOS`.`nombre_contacto` FROM `CONTACTOS`"
				+ " WHERE (`CONTACTOS`.`id` = `c`.`CONTACTOS_id`)) AS `contactos`"
				+ " FROM `COTIZACIONES` `c` "
				+ "WHERE (`c`.`activo` = 1) AND c.id = ?",
				new CotizacionVistaRM(), id);
		return cot;
	}

	@Override
	public List<CotizacionVista> consultar() throws DataAccessException {
		List<CotizacionVista> cotv = jdbcTemplate.query("SELECT * FROM COTIZACIONES_V", new CotizacionVistaRM());
		return cotv;
	}

	@Override
	public Cotizacion actuadescto(Cotizacion c) throws DataAccessException {
		jdbcTemplate.update("UPDATE COTIZACIONES SET descuento = ?, modificado_por = ? WHERE id = ?", 
				c.getDescuento(), c.getModificado_por(), c.getId());
		return c;
	}

	@Override
	public List<Integer> anioCot() throws DataAccessException{
		List<Integer> c = jdbcTemplate.queryForList("SELECT DISTINCT(anio) FROM COTIZACIONES ORDER BY anio DESC", 
				Integer.class);
		return c;
	}

	@Override
	public List<CotizacionVista> cotAnio(int anio) throws DataAccessException{
		List<CotizacionVista> ca = jdbcTemplate.query("SELECT * FROM COTIZACIONES_V WHERE anio=?", 
				new CotizacionVistaRM(), anio);
		return ca;
	}

	@Override
	public CotizacionVista buscarCotizacion(String numero) throws DataAccessException{
		CotizacionVista ca = jdbcTemplate.queryForObject("SELECT * FROM COTIZACIONES_V WHERE numero_cotizacion =? "
				+ "ORDER BY revision DESC LIMIT 1", 
				new CotizacionVistaRM(), numero);
		return ca;
	}
	
	@Override
	public int consultarRevision(int id) {
		int ultimarevision = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(revision), 0) FROM COTIZACIONES"
				+ " WHERE COTIZACIONES_id_original = ? AND activo = 1", Integer.class, id);
		return ultimarevision;
	}
	
	@Override
	public void actualizarReferencia(int id, int id_origen) throws DataAccessException {
		jdbcTemplate.update("UPDATE COTIZACIONES SET COTIZACIONES_id_original = ? "
				+ "WHERE id = ?", id_origen, id);
	}

	@Override
	public CotizacionVista buscarRevisionCotizacion(String numero, int rev) {
		CotizacionVista bvc = jdbcTemplate.queryForObject("SELECT * FROM COTIZACIONES_V WHERE numero_cotizacion = ? "
				+ " AND revision = ?", 
				new CotizacionVistaRM(), numero, rev);
		return bvc;
	}

	@Override
	public List<Integer> revisiones(int id) throws DataAccessException{
		List<Integer> lc = jdbcTemplate.queryForList("SELECT revision FROM COTIZACIONES_V WHERE cotizaciones_id_original=? ORDER BY revision DESC", 
				Integer.class, id);
		return lc;
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorPrecotizacion(int id) {
		List<CotizacionVista> bcp = jdbcTemplate.query("SELECT * FROM COTIZACIONES_V WHERE PRECOTIZACIONES_id = ?",
				new CotizacionVistaRM(), id);
		return bcp;
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorOrden(int id) {
		List<CotizacionVista> bco = jdbcTemplate.query("SELECT * FROM COTIZACIONES_V WHERE ORDENES_id = ?",
				new CotizacionVistaRM(), id);
		return bco;
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorClienteSinAutorizar(String moneda, int id) {
		/*List<Cotizacion> bcc = jdbcTemplate.query("SELECT * FROM COTIZACIONES c WHERE c.PRECOTIZACIONES_id "
				+ " IN (SELECT id FROM PRECOTIZACIONES WHERE CLIENTES_id = ?) "
				+ " AND c.id IN (SELECT COTIZACIONES_id FROM `ENCABEZADOS_COTIZACIONES` WHERE id IN "
				+ " (SELECT ENCABEZADOS_COTIZACIONES_id FROM DETALLE_COTIZACIONES dc "
				+ " WHERE NOT EXISTS (SELECT * FROM ACTIVIDADES_AUTORIZADAS "
				+ " WHERE DETALLES_COTIZACIONES_id = dc.id))) AND moneda = ? ",
				new CotizacionRM(), id, moneda);
		return bcc;*/
		String sql="SELECT c.id,c.numero,c.anio,CONCAT(c.numero, '/', c.anio) AS numero_cotizacion, "
				+ "c.revision,c.encabezado,c.descripcion_general,c.pie_pagina,c.pie_pagina_usuario, "
				+ "c.fecha_cot,c.hora_cot,c.subtotal,c.descuento,c.descripcion_descto, "
				+ "c.iva,c.iva_retenido,c.total,c.moneda,c.activo,c.AREAS_id AS areas_id, "
				+ "c.COTIZACIONES_id_original AS cotizaciones_id_original, "
				+ "(SELECT AREAS.numero FROM AREAS WHERE (AREAS.id = c.AREAS_id)) AS narea, "
				+ "c.PERSONAL_id AS personal_id, "
				+ "(SELECT CONCAT(PERSONAL.nombre,' ',PERSONAL.paterno,' ',PERSONAL.materno) FROM PERSONAL WHERE (PERSONAL.id = c.PERSONAL_id)) AS personal, "
				+ "c.ORDENES_id AS ordenes_id, (SELECT ORDENES.numero FROM ORDENES  WHERE (ORDENES.id = c.ORDENES_id)) AS orden, "
				+ "c.PRECOTIZACIONES_id AS precotizaciones_id, "
				+ "(SELECT PRECOTIZACIONES.numero FROM PRECOTIZACIONES WHERE (PRECOTIZACIONES.id = c.PRECOTIZACIONES_id)) AS precotizacion, "
				+ "c.CONTACTOS_id,(SELECT CONTACTOS.nombre_contacto FROM CONTACTOS WHERE (CONTACTOS.id = c.CONTACTOS_id)) AS contactos "
				+ "FROM COTIZACIONES c WHERE c.activo=1 "
				+ "AND c.PRECOTIZACIONES_id "
				+ " IN (SELECT id FROM PRECOTIZACIONES WHERE CLIENTES_id = ?) "
				+ " AND c.id IN (SELECT COTIZACIONES_id FROM `ENCABEZADOS_COTIZACIONES` WHERE id IN "
				+ " (SELECT ENCABEZADOS_COTIZACIONES_id FROM DETALLE_COTIZACIONES dc "
				+ " WHERE NOT EXISTS (SELECT * FROM ACTIVIDADES_AUTORIZADAS "
				+ " WHERE DETALLES_COTIZACIONES_id = dc.id))) AND moneda = ? ";
		List<CotizacionVista> bcosa = jdbcTemplate.query(sql,new CotizacionVistaRM(), id,moneda);
		return bcosa;
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorOrdenSinAutorizar(int id) {
		String sql="SELECT c.id,c.numero,c.anio,CONCAT(c.numero, '/', c.anio) AS numero_cotizacion, "
				+ "c.revision,c.encabezado,c.descripcion_general,c.pie_pagina,c.pie_pagina_usuario, "
				+ "c.fecha_cot,c.hora_cot,c.subtotal,c.descuento,c.descripcion_descto, "
				+ "c.iva,c.iva_retenido,c.total,c.moneda,c.activo,c.AREAS_id AS areas_id, "
				+ "c.COTIZACIONES_id_original AS cotizaciones_id_original, "
				+ "(SELECT AREAS.numero FROM AREAS WHERE (AREAS.id = c.AREAS_id)) AS narea, "
				+ "c.PERSONAL_id AS personal_id, "
				+ "(SELECT CONCAT(PERSONAL.nombre,' ',PERSONAL.paterno,' ',PERSONAL.materno) FROM PERSONAL WHERE (PERSONAL.id = c.PERSONAL_id)) AS personal, "
				+ "c.ORDENES_id AS ordenes_id, (SELECT ORDENES.numero FROM ORDENES  WHERE (ORDENES.id = c.ORDENES_id)) AS orden, "
				+ "c.PRECOTIZACIONES_id AS precotizaciones_id, "
				+ "(SELECT PRECOTIZACIONES.numero FROM PRECOTIZACIONES WHERE (PRECOTIZACIONES.id = c.PRECOTIZACIONES_id)) AS precotizacion, "
				+ "c.CONTACTOS_id,(SELECT CONTACTOS.nombre_contacto FROM CONTACTOS WHERE (CONTACTOS.id = c.CONTACTOS_id)) AS contactos "
				+ "FROM COTIZACIONES c WHERE c.activo=1 "
				+ "AND c.ORDENES_id = ? AND c.id IN (SELECT COTIZACIONES_id FROM ENCABEZADOS_COTIZACIONES WHERE id IN "
				+ "(SELECT ENCABEZADOS_COTIZACIONES_id FROM DETALLE_COTIZACIONES dc "
				+ "WHERE NOT EXISTS (SELECT * FROM ACTIVIDADES_AUTORIZADAS WHERE DETALLES_COTIZACIONES_id = dc.id)))";
		List<CotizacionVista> bcosa = jdbcTemplate.query(sql,new CotizacionVistaRM(), id);
		return bcosa;
	}


	
	
}
