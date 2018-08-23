package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
public class InsatisfaccionClienteRM implements RowMapper<InsatisfaccionCliente> {

	@Override
	public InsatisfaccionCliente mapRow(ResultSet rs, int rowNum) throws SQLException {

		InsatisfaccionCliente insatisfaccion = new InsatisfaccionCliente();

		insatisfaccion.setActivo(rs.getInt("activo"));
		insatisfaccion.setCreado(rs.getDate("creado"));
		insatisfaccion.setCreado_por(rs.getInt("creado_por"));
		insatisfaccion.setDescripcion_insatisfaccion(rs.getString("descripcion_insatisfaccion"));
		insatisfaccion.setDescripcion_otro(rs.getString("descripcion_otro"));
		insatisfaccion.setEquipo(rs.getString("equipo"));
		insatisfaccion.setFecha_insatisfaccion(rs.getDate("fecha_insatisfaccion"));
		insatisfaccion.setFecha_operacion(rs.getDate("fecha_operacion"));
		insatisfaccion.setFolio(rs.getInt("folio"));
		insatisfaccion.setGrado_insatisfaccion(rs.getString("grado_insatisfaccion"));
		insatisfaccion.setId(rs.getInt("id"));
		insatisfaccion.setModificado(rs.getDate("modificado"));
		insatisfaccion.setModificado_por(rs.getInt("modificado_por"));
		insatisfaccion.setOrdenes_id(rs.getInt("ORDENES_id"));
		insatisfaccion.setPersonal_id(rs.getInt("PERSONAL_id"));
		insatisfaccion.setTipo_insatisfaccion(rs.getString("tipo_insatisfaccion"));
		insatisfaccion.setUbicacion(rs.getString("ubicacion"));
		
		String json=rs.getString("actividades");
		
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> act = null;
		try {
			act = mapper.readValue(json, new TypeReference<List<Integer>>(){});
		} catch (Exception e) {}
		insatisfaccion.setActividades(act);

		return insatisfaccion;
	}

}
