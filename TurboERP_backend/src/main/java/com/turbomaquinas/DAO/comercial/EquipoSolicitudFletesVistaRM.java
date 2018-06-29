package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletesVista;

public class EquipoSolicitudFletesVistaRM implements RowMapper<EquipoSolicitudFletesVista>{

	@Override
	public EquipoSolicitudFletesVista mapRow(ResultSet rs, int i) throws SQLException {
		EquipoSolicitudFletesVista esfv = new EquipoSolicitudFletesVista();
		esfv.setId(rs.getInt("id"));
		esfv.setDescripcion(rs.getString("descripcion"));
		esfv.setPeso(rs.getFloat("peso"));
		esfv.setUnidades(rs.getInt("unidades"));
		esfv.setEquipo_por_recibir_id(rs.getInt("equipo_por_recibir_id"));
		esfv.setEquipo_recibido_id(rs.getInt("equipo_recibido_id"));
		esfv.setMedidas_equipos_id(rs.getInt("medidas_equipos_id"));
		esfv.setSolicitud_flete_id(rs.getInt("solicitud_fletes_id"));
		esfv.setClientes_id(rs.getInt("clientes_id"));
		return esfv;
	}
}
