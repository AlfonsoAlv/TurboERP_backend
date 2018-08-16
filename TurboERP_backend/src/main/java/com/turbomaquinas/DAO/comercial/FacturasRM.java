package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.Facturas;

public class FacturasRM implements RowMapper<Facturas> {

	@Override
	public Facturas mapRow(ResultSet rs, int i) throws SQLException {
		Facturas fv = new Facturas();
		fv.setId(rs.getInt("id"));
		fv.setTipo(rs.getString("tipo"));
		fv.setNumero(rs.getInt("numero"));
		fv.setSaldo(rs.getBigDecimal("saldo"));
		fv.setMoneda(rs.getString("moneda"));
		fv.setClientes_id(rs.getInt("clientes_id"));
		fv.setEstado(rs.getString("estado"));
		return fv;
	}

}
