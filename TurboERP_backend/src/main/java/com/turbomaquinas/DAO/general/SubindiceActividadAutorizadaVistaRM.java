package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.SubindiceActividadAutorizadaVista;

public class SubindiceActividadAutorizadaVistaRM implements RowMapper<SubindiceActividadAutorizadaVista>{

	@Override
	public SubindiceActividadAutorizadaVista mapRow(ResultSet rs, int i) throws SQLException {
		SubindiceActividadAutorizadaVista sa = new SubindiceActividadAutorizadaVista();
		sa.setId(rs.getInt("id"));
		sa.setDescripcion(rs.getString("descripcion"));
		sa.setLugar(rs.getInt("lugar"));
		sa.setImporte(rs.getBigDecimal("importe"));
		sa.setTipo_actividad_subindice(rs.getString("tipo_actividad_subindice"));
		sa.setActivo(rs.getInt("activo"));
		sa.setActividades_autorizadas_id(rs.getInt("actividades_autorizadas_id"));
		sa.setActividades_descripcion(rs.getString("actividades_descripcion"));
		sa.setActividades_lugar(rs.getInt("actividades_lugar"));
		sa.setTipo_actividad(rs.getString("tipo_actividad"));
		sa.setSuministro(rs.getInt("suministro"));
		sa.setPlanta(rs.getInt("planta"));
		sa.setClase_actividad(rs.getString("clase_actividad"));
		sa.setFecha_autorizado(rs.getDate("fecha_autorizado"));
		sa.setImporte_autorizado(rs.getBigDecimal("importe_autorizado"));
		sa.setImporte_baja(rs.getBigDecimal("importe_baja"));
		sa.setImporte_anticipo(rs.getBigDecimal("importe_anticipo"));
		sa.setImporte_factura(rs.getBigDecimal("importe_factura"));
		sa.setImporte_pendiente(rs.getBigDecimal("importe_pendiente"));
		sa.setActividad_activo(rs.getInt("actividad_activo"));
		return sa;
	}

}
