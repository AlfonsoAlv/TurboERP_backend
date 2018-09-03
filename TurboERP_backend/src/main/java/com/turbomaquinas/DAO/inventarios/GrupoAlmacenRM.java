package com.turbomaquinas.DAO.inventarios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.inventarios.GrupoAlmacen;

public class GrupoAlmacenRM implements RowMapper<GrupoAlmacen>{
	
	@Override
	public GrupoAlmacen mapRow(ResultSet rs, int i) throws SQLException {
		GrupoAlmacen gm = new GrupoAlmacen();
		gm.setId(rs.getInt("id"));
		gm.setDescripcion(rs.getString("descripcion"));
		gm.setActivo(rs.getInt("activo"));
		gm.setCreado_por(rs.getInt("creado_por"));
		gm.setCreado(rs.getDate("creado"));
		gm.setModificado_por(rs.getInt("modificado_por"));
		gm.setModificado(rs.getDate("modificado"));
		gm.setTipos_almacen_id(rs.getInt("TIPOS_ALMACEN_id"));
		gm.setClave_num(rs.getString("clave_num"));
		gm.setClave_grupo(rs.getString("clave_grupo"));
		return gm;
	}
}
