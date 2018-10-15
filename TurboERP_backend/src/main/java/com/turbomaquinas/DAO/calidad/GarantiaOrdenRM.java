package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.GarantiaOrden;

public class GarantiaOrdenRM implements RowMapper<GarantiaOrden>{

	@Override
	public GarantiaOrden mapRow(ResultSet rs, int i) throws SQLException {
		GarantiaOrden go = new GarantiaOrden();
		go.setGarantia_id(rs.getInt("garantia_id"));
		go.setDescripcion_garantia(rs.getString("descripcion_garantia"));
		go.setEncabezado_garantia_id(rs.getInt("encabezado_garantia_id"));
		go.setDescripcion_encabezado(rs.getString("descripcion_encabezado"));
		go.setDetalle_garantia_id(rs.getInt("detalle_garantia_id"));
		go.setDescripcion_detalle(rs.getString("descripcion_garantia"));
		go.setFecha_terminacion(rs.getDate("fecha_terminacion"));
		return go;
	}

}
