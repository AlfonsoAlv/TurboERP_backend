package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.SubindiceActividadAutorizada;

public class SubindiceActividadAutorizadaRM implements RowMapper<SubindiceActividadAutorizada>{

	@Override
	public SubindiceActividadAutorizada mapRow(ResultSet rs, int i) throws SQLException {
		SubindiceActividadAutorizada sa = new SubindiceActividadAutorizada();
		sa.setId(rs.getInt("id"));
		sa.setDescripcion(rs.getString("descripcion"));
		sa.setLugar(rs.getInt("lugar"));
		sa.setImporte(rs.getBigDecimal("importe"));
		sa.setTipo_actividad(rs.getString("tipo_actividad"));
		sa.setActivo(rs.getInt("activo"));
		sa.setCreado_por(rs.getInt("creado_por"));
		sa.setCreado(rs.getDate("creado"));
		sa.setModificado_por(rs.getInt("modificado_por"));
		sa.setModificado(rs.getDate("modificado"));
		sa.setActividades_autorizadas_id(rs.getInt("actividades_autorizadas_id"));
		return sa;
	}

}
