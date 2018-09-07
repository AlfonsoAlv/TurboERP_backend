package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;

public class EncabezadoGarantiaVistaRM implements RowMapper<EncabezadoGarantiaVista>{

	@Override
	public EncabezadoGarantiaVista mapRow(ResultSet rs, int i) throws SQLException {
		EncabezadoGarantiaVista ev = new EncabezadoGarantiaVista();
		ev.setId(rs.getInt("id"));
		ev.setDescripcion(rs.getString("descripcion"));
		ev.setLugar(rs.getInt("lugar"));
		ev.setActivo(rs.getInt("activo"));
		ev.setCreado_por(rs.getInt("creado_por"));
		ev.setCreado(rs.getDate("creado"));
		ev.setModificado_por(rs.getInt("modificado_por"));
		ev.setModificado(rs.getDate("modificado"));
		ev.setGarantias_id(rs.getInt("garantias_id"));
		ev.setCant_detalles(rs.getInt("cant_detalles"));
		return ev;
	}

}
