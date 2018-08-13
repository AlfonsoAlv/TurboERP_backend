package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;

public class SeguimientoInsatisfaccionRM implements RowMapper<SeguimientoInsatisfaccion> {

	@Override
	public SeguimientoInsatisfaccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		SeguimientoInsatisfaccion seguimiento = new SeguimientoInsatisfaccion();
		seguimiento.setId(rs.getInt("id"));
		seguimiento.setFecha(rs.getDate("fecha"));
		seguimiento.setDescripcion(rs.getString("descripcion"));
		seguimiento.setTipo(rs.getString("tipo"));
		seguimiento.setTrabajo_realizar(rs.getString("trabajo_realizar"));
		seguimiento.setActivo(rs.getInt("activo"));
		seguimiento.setCreado(rs.getDate("creado"));
		seguimiento.setCreado_por(rs.getInt("creado_por"));
		seguimiento.setModificado(rs.getDate("modificado"));
		seguimiento.setModificado_por(rs.getInt("modificado_por"));
		seguimiento.setInsatisfacciones_clientes_id(rs.getInt("INSATISFACCIONES_CLIENTES_id"));
		return seguimiento;
	}
	
}
