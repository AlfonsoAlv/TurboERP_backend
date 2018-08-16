package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.Orden;

public class OrdenRM implements RowMapper<Orden>{

	@Override
	public Orden mapRow(ResultSet rs, int i) throws SQLException {
		Orden o = new Orden();
		o.setId(rs.getInt("id"));
		o.setNumero(rs.getInt("numero"));
		o.setAnio(rs.getInt("anio"));
		o.setDescripcion(rs.getString("descripcion"));
		o.setTipo(rs.getString("tipo"));
		o.setMoneda(rs.getString("moneda"));
		o.setImporte_autorizado(rs.getBigDecimal("importe_autorizado"));
		o.setImporte_bajas(rs.getBigDecimal("importe_bajas"));
		o.setImporte_facturado(rs.getBigDecimal("importe_facturado"));
		o.setActivo(rs.getInt("activo"));
		o.setCreado_por(rs.getInt("creado_por"));
		o.setCreado(rs.getTimestamp("creado"));
		o.setModificado_por(rs.getInt("modificado_por"));
		o.setModificado(rs.getTimestamp("modificado"));
		o.setClientes_id(rs.getInt("clientes_id"));
		o.setMarcas_equipos_id(rs.getInt("marcas_equipos_id"));
		o.setModelos_equipos_id(rs.getInt("modelos_equipos_id"));
		o.setNumero_orden(rs.getString("numero_orden"));
		return o;
	}

}
