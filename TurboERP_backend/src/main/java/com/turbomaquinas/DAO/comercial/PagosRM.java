package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.Pagos;

public class PagosRM implements RowMapper<Pagos> {

	@Override
	public Pagos mapRow(ResultSet rs, int i) throws SQLException {

		Pagos p = new Pagos();
		p.setId(rs.getInt("id"));
		p.setFolio(rs.getInt("folio"));
		p.setFecha_pago(rs.getDate("fecha_pago"));
		p.setImporte(rs.getBigDecimal("importe"));
		p.setTipo_cambio_cliente(rs.getFloat("tipo_cambio_cliente"));
		p.setFecha_baja(rs.getDate("fecha_baja"));
		p.setMes_baja(rs.getInt("mes_baja"));
		p.setAnio_baja(rs.getInt("anio_baja"));
		p.setObservaciones(rs.getString("observaciones"));
		p.setCreado_por(rs.getInt("creado_por"));
		p.setCreado(rs.getDate("creado"));
		p.setModificado_por(rs.getInt("modificado_por"));
		p.setModificado(rs.getDate("modificado"));
		p.setDepositos_recibidos_id(rs.getInt("depositos_recibidos_id"));
		return p;
		
	}
	

}
