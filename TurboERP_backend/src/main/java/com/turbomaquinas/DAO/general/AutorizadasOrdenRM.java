package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.AutorizadasOrden;

public class AutorizadasOrdenRM implements RowMapper<AutorizadasOrden>{

	@Override
	public AutorizadasOrden mapRow(ResultSet rs, int i) throws SQLException {
		AutorizadasOrden ao = new AutorizadasOrden();
		ao.setActividad_autorizada_id(rs.getInt("actividad_autorizada_id"));
		ao.setAutorizacion_id(rs.getInt("autorizacion_id"));
		ao.setFolio(rs.getString("folio"));
		ao.setDetalle_id(rs.getInt("detalle_id"));
		ao.setDescripcion(rs.getString("descripcion"));
		ao.setLugar(rs.getInt("lugar"));
		return ao;
	}

}
