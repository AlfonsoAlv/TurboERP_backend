package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;

public class SubindiceGarantiaVistaRM implements RowMapper<SubindiceGarantiaVista>{

	@Override
	public SubindiceGarantiaVista mapRow(ResultSet rs, int i) throws SQLException {
		SubindiceGarantiaVista sv = new SubindiceGarantiaVista();
		sv.setId(rs.getInt("id"));
		sv.setDescripcion(rs.getString("descripcion"));
		sv.setLugar(rs.getInt("lugar"));
		sv.setActivo(rs.getInt("activo"));
		sv.setCreado_por(rs.getInt("creado_por"));
		sv.setCreado(rs.getDate("creado"));
		sv.setModificado_por(rs.getInt("modificado_por"));
		sv.setModificado(rs.getDate("modificado"));
		sv.setDetalle_garantias_id(rs.getInt("detalle_garantias_id"));
		sv.setDetalle_descripcion(rs.getString("detalle_descripcion"));
		sv.setDetalle_lugar(rs.getInt("detalle_lugar"));
		sv.setEncabezados_garantias_id(rs.getInt("encabezados_garantias_id"));
		sv.setDescripcion_encabezado(rs.getString("descripcion_encabezado"));
		sv.setLugar_encabezado(rs.getInt("lugar_encabezado"));
		sv.setGarantias_id(rs.getInt("garantias_id"));
		return sv;
	}

}
