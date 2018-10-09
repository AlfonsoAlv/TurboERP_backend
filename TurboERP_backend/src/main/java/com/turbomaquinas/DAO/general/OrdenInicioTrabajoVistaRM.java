package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;

public class OrdenInicioTrabajoVistaRM implements RowMapper<OrdenInicioTrabajoVista>{
	@Override
	public OrdenInicioTrabajoVista mapRow(ResultSet rs, int i) throws SQLException {
		OrdenInicioTrabajoVista oit = new OrdenInicioTrabajoVista();
		oit.setId(rs.getInt("id"));
		oit.setNumero_orden(rs.getString("numero_orden"));
		oit.setNumero_oit(rs.getString("numero_oit"));
		oit.setDescripcion_orden(rs.getString("descripcion_orden"));
		oit.setNombre_cliente(rs.getString("nombre_cliente"));
		oit.setEstado(rs.getString("estado"));
		oit.setDescripcion_estado(rs.getString("descripcion_estado"));
		oit.setTipo(rs.getString("tipo"));
		oit.setOrigen(rs.getString("origen"));
		oit.setPrioridad(rs.getString("prioridad"));
		oit.setDescripcion_prioridad(rs.getString("descripcion_prioridad"));
		oit.setAvance(rs.getFloat("avance"));
		oit.setDescripcion_equipo_recibido(rs.getString("descripcion_equipo_recibido"));
		oit.setFecha_oit(rs.getDate("fecha"));
		oit.setAlfresco_id(rs.getString("alfresco_id"));
		return oit;
	}
}
