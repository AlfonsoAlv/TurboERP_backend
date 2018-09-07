package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.GarantiaVista;

public class GarantiaVistaRM implements RowMapper<GarantiaVista>{

	@Override
	public GarantiaVista mapRow(ResultSet rs, int i) throws SQLException {

		GarantiaVista g = new GarantiaVista();
		g.setId(rs.getInt("id"));
		g.setActivo(rs.getInt("activo"));
		g.setCreado_por(rs.getInt("creado_por"));
		g.setCreado(rs.getDate("creado"));
		g.setModificado_por(rs.getInt("modificado_por"));
		g.setModificado(rs.getDate("modificado"));
		g.setDescripcion(rs.getString("descripcion"));
		g.setPersonal_id(rs.getInt("PERSONAL_id"));
		g.setOrdenes_id(rs.getInt("ORDENES_id"));
		g.setNumero_orden(rs.getString("numero_orden"));
		g.setDescripcion_orden(rs.getString("descripcion_orden"));
		g.setClientes_id(rs.getInt("CLIENTES_id"));
		g.setNombre_cliente(rs.getString("nombre_cliente"));
		g.setNumero_giro(rs.getInt("numero_giro"));
		g.setNumero_cliente(rs.getInt("numero_cliente"));
		g.setElaboro(rs.getString("elaboro"));
		return g;
	}
}
