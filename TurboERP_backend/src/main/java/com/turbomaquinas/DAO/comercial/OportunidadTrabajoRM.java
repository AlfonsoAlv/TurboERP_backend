package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.OportunidadTrabajo;

public class OportunidadTrabajoRM implements RowMapper<OportunidadTrabajo>{

	@Override
	public OportunidadTrabajo mapRow(ResultSet rs, int i) throws SQLException {
		OportunidadTrabajo op = new OportunidadTrabajo();
		op.setId(rs.getInt("id"));
		op.setNumero(rs.getInt("numero"));
		op.setIniciales(rs.getString("iniciales"));
		op.setAnio(rs.getInt("anio"));
		op.setFecha_oportunidad(rs.getDate("fecha_oportunidad"));
		op.setFecha_posible(rs.getDate("fecha_posible"));
		op.setDescripcion(rs.getString("descripcion"));
		op.setComentario(rs.getString("comentario"));
		op.setProbabilidad(rs.getString("probabilidad"));
		op.setMonto(rs.getBigDecimal("monto"));
		op.setMoneda(rs.getString("moneda"));
		op.setUsuario_cierre(rs.getInt("usuario_cierre"));
		op.setFecha_cierre(rs.getDate("fecha_cierre"));
		op.setActivo(rs.getInt("activo"));
		op.setCreado_por(rs.getInt("creado_por"));
		op.setCreado(rs.getDate("creado"));
		op.setModificado_por(rs.getInt("modificado_por"));
		op.setModificado(rs.getDate("modificado"));
		op.setClientes_id(rs.getInt("clientes_id"));
		op.setContactos_id(rs.getInt("contactos_id"));
		return op;
	}

}
