package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletes;

public class EquipoSolicitudFletesRM implements RowMapper<EquipoSolicitudFletes>{

	@Override
	public EquipoSolicitudFletes mapRow(ResultSet rs, int i) throws SQLException {
		EquipoSolicitudFletes esf = new EquipoSolicitudFletes();
		esf.setId(rs.getInt("id"));
		esf.setDescripcion(rs.getString("descripcion"));
		esf.setPeso(rs.getFloat("peso"));
		esf.setUnidades(rs.getInt("unidades"));
		esf.setActivo(rs.getInt("activo"));
		esf.setCreado_por(rs.getInt("creado_por"));
		esf.setCreado(rs.getDate("creado"));
		esf.setModificado_por(rs.getInt("modificado_por"));
		esf.setModificado(rs.getDate("modificado"));
		esf.setEquipo_por_recibir_id(rs.getInt("EQUIPO_POR_RECIBIR_id"));
		esf.setEquipo_recibido_id(rs.getInt("EQUIPO_RECIBIDO_id"));
		esf.setMedidas_equipos_id(rs.getInt("MEDIDAS_EQUIPOS_id"));
		esf.setSolicitud_flete_id(rs.getInt("SOLICITUD_FLETES_id"));
		return esf;
	}

}
