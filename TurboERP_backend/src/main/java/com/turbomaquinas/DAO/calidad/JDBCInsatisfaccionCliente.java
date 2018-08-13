package com.turbomaquinas.DAO.calidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;

@Repository
public class JDBCInsatisfaccionCliente implements InsatisfaccionClienteDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int crear(InsatisfaccionCliente insatisfaccion) throws DataAccessException {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("fecha_insatisfaccion");
		columnas.add("fecha_operacion");
		columnas.add("equipo");
		columnas.add("descripcion_insatisfaccion");
		columnas.add("tipo_insatisfaccion");
		columnas.add("descripcion_otro");
		columnas.add("grado_insatisfaccion");
		columnas.add("creado_por");
		columnas.add("creado");
		columnas.add("modificado_por");
		columnas.add("modificado");
		columnas.add("ubicacion");
		columnas.add("ORDENES_id");
		columnas.add("PERSONAL_id");
		
		insert.setTableName("INSATISFACCIONES_CLIENTES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		
		datos.put("fecha_insatisfaccion", insatisfaccion.getFecha_insatisfaccion());
		datos.put("fecha_operacion", insatisfaccion.getFecha_operacion());
		datos.put("equipo", insatisfaccion.getEquipo());
		datos.put("descripcion_insatisfaccion", insatisfaccion.getDescripcion_insatisfaccion());
		datos.put("tipo_insatisfaccion", insatisfaccion.getTipo_insatisfaccion());
		datos.put("descripcion_otro", insatisfaccion.getDescripcion_otro());
		datos.put("grado_insatisfaccion", insatisfaccion.getGrado_insatisfaccion());
		datos.put("creado_por", insatisfaccion.getCreado_por());
		datos.put("creado", insatisfaccion.getCreado());
		datos.put("modificado_por", insatisfaccion.getModificado_por());
		datos.put("modificado", insatisfaccion.getModificado());
		datos.put("ubicacion", insatisfaccion.getUbicacion());
		datos.put("ORDENES_id", insatisfaccion.getOrdenes_id());
		datos.put("PERSONAL_id", insatisfaccion.getPersonal_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public InsatisfaccionClienteVista buscar(int id) throws DataAccessException {
		return jdbcTemplate.queryForObject(
				"SELECT 	`INSATISFACCIONES_CLIENTES`.`id` AS insatisfaccion_id, " +
				"`folio`, " +
				"`fecha_insatisfaccion`, " + 
				"`fecha_operacion`, " +
				"`equipo`, " +
				"`descripcion_insatisfaccion`, " + 
				"`tipo_insatisfaccion`, " + 
				"`descripcion_otro`, " + 
				"`grado_insatisfaccion`, " +
				"`ORDENES`.`id` AS ORDENES_id, " + 
				" ORDENES.`numero_orden`, " +
				" ORDENES.`descripcion` AS descripcion_orden, " +
				"`ubicacion`, " +
				"ORDENES.`CLIENTES_id` AS clientes_id, " +
				" (SELECT CLIENTES.`numero` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_cliente', " + 
				" (SELECT (SELECT GIROS.`numero` FROM GIROS WHERE `GIROS`.`id` = CLIENTES.`GIROS_id`) FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_giro', " + 
				" (SELECT CLIENTES.`nombre_comercial` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_comercial', " + 
				" (SELECT CLIENTES.`nombre_fiscal` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_fiscal', " + 
				" (SELECT CLIENTES.`PERSONAL_id` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS atc_default_id, " +
				" (SELECT CONCAT(PERSONAL.`nombre`, ' ', PERSONAL.`paterno`, ' ' , PERSONAL.`materno`) FROM PERSONAL WHERE `PERSONAL`.`id` = `PERSONAL_id`) AS nombre_personal, " +
				" `PERSONAL_id` " +
				"FROM INSATISFACCIONES_CLIENTES " +
				"LEFT JOIN ORDENES ON ORDENES.`id` = INSATISFACCIONES_CLIENTES.`ORDENES_id` " + 
				"LEFT JOIN PERSONAL ON PERSONAL.`id` = INSATISFACCIONES_CLIENTES.`PERSONAL_id` " + 
				"WHERE INSATISFACCIONES_CLIENTES.id = ?", 
				new InsatisfaccionClienteVistaRM(), id);
	}

	@Override
	public List<InsatisfaccionClienteVista> consultar() throws DataAccessException {
		
		return jdbcTemplate.query(
				"SELECT 	`INSATISFACCIONES_CLIENTES`.`id` AS insatisfaccion_id, " +
				"`folio`, " +
				"`fecha_insatisfaccion`, " + 
				"`fecha_operacion`, " +
				"`equipo`, " +
				"`descripcion_insatisfaccion`, " + 
				"`tipo_insatisfaccion`, " + 
				"`descripcion_otro`, " + 
				"`grado_insatisfaccion`, " +
				"`ORDENES`.`id` AS ORDENES_id, " + 
				" ORDENES.`numero_orden`, " +
				" ORDENES.`descripcion` AS descripcion_orden, " +
				"`ubicacion`, " +
				"ORDENES.`CLIENTES_id` AS clientes_id, " +
				" (SELECT CLIENTES.`numero` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_cliente', " + 
				" (SELECT (SELECT GIROS.`numero` FROM GIROS WHERE `GIROS`.`id` = CLIENTES.`GIROS_id`) FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_giro', " + 
				" (SELECT CLIENTES.`nombre_comercial` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_comercial', " + 
				" (SELECT CLIENTES.`nombre_fiscal` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_fiscal', " + 
				" (SELECT CLIENTES.`PERSONAL_id` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS atc_default_id, " +
				" (SELECT CONCAT(PERSONAL.`nombre`, ' ', PERSONAL.`paterno`, ' ' , PERSONAL.`materno`) FROM PERSONAL WHERE `PERSONAL`.`id` = `PERSONAL_id`) AS nombre_personal, " +
				" `PERSONAL_id` " +
				"FROM INSATISFACCIONES_CLIENTES " +
				"LEFT JOIN ORDENES ON ORDENES.`id` = INSATISFACCIONES_CLIENTES.`ORDENES_id` " + 
				"LEFT JOIN PERSONAL ON PERSONAL.`id` = INSATISFACCIONES_CLIENTES.`PERSONAL_id` ", 
				new InsatisfaccionClienteVistaRM());

	}

	@Override
	public InsatisfaccionClienteVista buscarPorFolio(int folio) {
		return jdbcTemplate.queryForObject(
				"SELECT 	`INSATISFACCIONES_CLIENTES`.`id` AS insatisfaccion_id, " +
				"`folio`, " +
				"`fecha_insatisfaccion`, " + 
				"`fecha_operacion`, " +
				"`equipo`, " +
				"`descripcion_insatisfaccion`, " + 
				"`tipo_insatisfaccion`, " + 
				"`descripcion_otro`, " + 
				"`grado_insatisfaccion`, " +
				"`ORDENES`.`id` AS ORDENES_id, " + 
				" ORDENES.`numero_orden`, " +
				" ORDENES.`descripcion` AS descripcion_orden, " +
				"`ubicacion`, " +
				"ORDENES.`CLIENTES_id` AS clientes_id, " +
				" (SELECT CLIENTES.`numero` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_cliente', " + 
				" (SELECT (SELECT GIROS.`numero` FROM GIROS WHERE `GIROS`.`id` = CLIENTES.`GIROS_id`) FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'numero_giro', " + 
				" (SELECT CLIENTES.`nombre_comercial` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_comercial', " + 
				" (SELECT CLIENTES.`nombre_fiscal` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_fiscal', " + 
				" (SELECT CLIENTES.`PERSONAL_id` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS atc_default_id, " +
				" (SELECT CONCAT(PERSONAL.`nombre`, ' ', PERSONAL.`paterno`, ' ' , PERSONAL.`materno`) FROM PERSONAL WHERE `PERSONAL`.`id` = `PERSONAL_id`) AS nombre_personal, " +
				" `PERSONAL_id` " +
				"FROM INSATISFACCIONES_CLIENTES " +
				"LEFT JOIN ORDENES ON ORDENES.`id` = INSATISFACCIONES_CLIENTES.`ORDENES_id` " + 
				"LEFT JOIN PERSONAL ON PERSONAL.`id` = INSATISFACCIONES_CLIENTES.`PERSONAL_id` " + 
				"WHERE INSATISFACCIONES_CLIENTES.folio = ?", 
				new InsatisfaccionClienteVistaRM(), folio);
	}

	@Override
	public void actualizar(InsatisfaccionCliente insatisfaccion) throws DataAccessException {
		
		jdbcTemplate.update(""
				+ "UPDATE INSATISFACCIONES_CLIENTES "
				+ "SET ubicacion = ?, "
				+ "fecha_operacion = ?, "
				+ "equipo = ?, "
				+ "descripcion_insatisfaccion = ?, "
				+ "tipo_insatisfaccion = ?, "
				+ "descripcion_otro = ?, "
				+ "grado_insatisfaccion = ?, "
				+ "modificado_por = ?, "
				+ "PERSONAL_id = ? "
				+ "WHERE INSATISFACCIONES_CLIENTES.id = ?",
				insatisfaccion.getUbicacion(),
				insatisfaccion.getFecha_operacion(),
				insatisfaccion.getEquipo(),
				insatisfaccion.getDescripcion_insatisfaccion(),
				insatisfaccion.getTipo_insatisfaccion(),
				insatisfaccion.getDescripcion_otro(),
				insatisfaccion.getGrado_insatisfaccion(),
				insatisfaccion.getModificado_por(),
				insatisfaccion.getPersonal_id(),
				insatisfaccion.getId());
		
	}

	@Override
	public void crearSeguimiento(SeguimientoInsatisfaccion seguimiento) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("fecha");
		columnas.add("descripcion");
		columnas.add("tipo");
		columnas.add("trabajo_realizar");
		columnas.add("creado_por");
		columnas.add("INSATISFACCIONES_CLIENTES_id");
		
		insert.setTableName("SEGUIMIENTO_INSATISFACCION");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		
		datos.put("fecha", seguimiento.getFecha());
		datos.put("descripcion", seguimiento.getDescripcion());
		datos.put("tipo", seguimiento.getTipo());
		datos.put("trabajo_realizar", seguimiento.getTrabajo_realizar());
		datos.put("creado_por", seguimiento.getCreado_por());
		datos.put("INSATISFACCIONES_CLIENTES_id", seguimiento.getInsatisfacciones_clientes_id());
		
		insert.execute(datos);
	}

}
