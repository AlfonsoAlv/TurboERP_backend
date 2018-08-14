package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.Pedido;

public class PedidoRM implements RowMapper<Pedido>  {

	@Override
	public Pedido mapRow(ResultSet rs, int i) throws SQLException {

		Pedido p = new Pedido();
		p.setId(rs.getInt("id"));
		p.setNumero(rs.getString("numero"));
		p.setFecha_pedido(rs.getDate("fecha_pedido"));
		p.setComentarios(rs.getString("comentarios"));
		p.setImporte(rs.getBigDecimal("importe"));
		p.setRevision(rs.getInt("revision"));
		p.setSustituye_id(rs.getInt("sustituye_id"));
		p.setActivo(rs.getInt("activo"));
		p.setCreado_por(rs.getInt("creado_por"));
		p.setCreado(rs.getDate("creado"));
		p.setModificado_por(rs.getInt("modificado_por"));
		p.setModificado(rs.getDate("modificado"));
		p.setAlfresco_id(rs.getString("alfresco_id"));
		p.setClientes_id(rs.getInt("CLIENTES_id"));
		return p;
	}
}
