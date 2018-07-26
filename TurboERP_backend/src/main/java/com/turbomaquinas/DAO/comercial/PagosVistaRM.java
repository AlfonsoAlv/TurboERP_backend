package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.PagosVista;

public class PagosVistaRM implements RowMapper<PagosVista> {

	@Override
	public PagosVista mapRow(ResultSet rs, int i) throws SQLException {
		PagosVista pv = new PagosVista();
		pv.setId(rs.getInt("id"));
		pv.setFolio(rs.getInt("folio"));
		pv.setNumero(rs.getInt("numero"));
		pv.setTipo(rs.getString("tipo"));
		pv.setFecha_pago(rs.getDate("fecha_pago"));
		pv.setImporte(rs.getFloat("importe"));
		pv.setTipo_cambio_cliente(rs.getFloat("tipo_cambio_cliente"));
		pv.setFecha_baja(rs.getDate("fecha_baja"));
		pv.setMes_baja(rs.getInt("mes_baja"));
		pv.setAnio_baja(rs.getInt("anio_baja"));
		pv.setObservaciones(rs.getString("observaciones"));
		pv.setCreado_por(rs.getInt("creado_por"));
		pv.setCreado(rs.getDate("creado"));
		pv.setModificado_por(rs.getInt("modificado_por"));
		pv.setModificado(rs.getDate("modificado"));
		pv.setDepositos_recibidos_id(rs.getInt("depositos_recibidos_id"));
		pv.setComentarios(rs.getString("comentarios"));
		return pv;	
		}

}
