package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.OT;

public class OTRM implements RowMapper<OT>{
	
	@Override
	public OT mapRow(ResultSet rs, int i) throws SQLException {
		OT o = new OT();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));
		o.setClientes_id(rs.getInt("clientes_id"));
		o.setMoneda(rs.getString("moneda"));
		o.setImporte_autorizado(rs.getBigDecimal("importe_autorizado"));
		o.setImporte_pedido(rs.getBigDecimal("importe_pedido"));
		o.setNumero_orden(rs.getString("numero_orden"));
		o.setCliente_no(rs.getInt("numero_cliente"));
		o.setNombre_comercial(rs.getString("comercial"));
		o.setNombre_fiscal(rs.getString("fiscal"));
		o.setCliente(rs.getString("cliente"));
		o.setGiro(rs.getString("giro"));
		return o;
	}


}
