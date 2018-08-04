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
				" (SELECT CLIENTES.`nombre_comercial` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_comercial', " + 
				" (SELECT CLIENTES.`nombre_fiscal` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_fiscal', " + 
				" (SELECT CLIENTES.`PERSONAL_id` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS atc_default_id, " +
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
				"`ubicacion`, " +
				"`ORDENES`.`id` AS ORDENES_id, " + 
				" ORDENES.`numero_orden`, " +
				" ORDENES.`descripcion` AS descripcion_orden, " +
				" (SELECT CLIENTES.`nombre_comercial` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_comercial', " + 
				" (SELECT CLIENTES.`nombre_fiscal` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS 'cliente_nombre_fiscal', " + 
				" (SELECT CLIENTES.`PERSONAL_id` FROM CLIENTES WHERE CLIENTES.`id` = ORDENES.`CLIENTES_id`) AS atc_default_id, " +
				" `PERSONAL_id` " +
				"FROM INSATISFACCIONES_CLIENTES " +
				"LEFT JOIN ORDENES ON ORDENES.`id` = INSATISFACCIONES_CLIENTES.`ORDENES_id` " + 
				"LEFT JOIN PERSONAL ON PERSONAL.`id` = INSATISFACCIONES_CLIENTES.`PERSONAL_id` ", 
				new InsatisfaccionClienteVistaRM());

	}

}
