package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.Autorizacion;

public class AutorizacionRM implements RowMapper<Autorizacion>{

	@Override
	public Autorizacion mapRow(ResultSet rs, int i) throws SQLException {
		Autorizacion a = new Autorizacion();
		a.setId(rs.getInt("id"));
		a.setFecha(rs.getDate("fecha"));
		a.setAnio(rs.getInt("anio"));
		a.setNumero(rs.getInt("numero"));
		a.setFolio(rs.getString("folio"));
		a.setImporte_pedido(rs.getBigDecimal("importe_pedido"));
		a.setImporte_irregular(rs.getBigDecimal("importe_irregular"));
		a.setImporte_total(rs.getBigDecimal("importe_total"));
		a.setOrdenes_id(rs.getInt("ordenes_id"));
		return a;
	}

}
