package com.turbomaquinas.DAO.calidad;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccionVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccionVista.Alfresco_ids;

public class SeguimientoInsatisfaccionVistaRM implements RowMapper<SeguimientoInsatisfaccionVista> {

	@Override
	public SeguimientoInsatisfaccionVista mapRow(ResultSet rs, int rowNum) throws SQLException {
		SeguimientoInsatisfaccionVista seguimiento = new SeguimientoInsatisfaccionVista();
		seguimiento.setId(rs.getInt("id"));
		seguimiento.setFecha(rs.getDate("fecha"));
		seguimiento.setDescripcion(rs.getString("descripcion"));
		seguimiento.setTipo(rs.getString("tipo"));
		seguimiento.setTrabajo_realizar(rs.getString("trabajo_realizar"));
		seguimiento.setActivo(rs.getInt("activo"));
		seguimiento.setCreado(rs.getDate("creado"));
		seguimiento.setCreado_por(rs.getInt("creado_por"));
		seguimiento.setModificado(rs.getDate("modificado"));
		seguimiento.setModificado_por(rs.getInt("modificado_por"));
		seguimiento.setInsatisfacciones_clientes_id(rs.getInt("INSATISFACCIONES_CLIENTES_id"));
		
		//seguimiento.setAlfresco_ids(rs.getString("alfresco_ids"));
		
		String json=rs.getString("alfresco_ids");
		ObjectMapper mapper = new ObjectMapper();
		List<Alfresco_ids> alfresco=null;
		try {
			alfresco = mapper.readValue(json, new TypeReference<List<Alfresco_ids>>(){});
		} catch (IOException e) {System.out.println(e);}
		seguimiento.setAlfresco_ids(alfresco);
		
		seguimiento.setCantidad_Documentos(rs.getInt("cantidad_Documentos"));
		seguimiento.setFolio_insatisfaccion(rs.getInt("folio_insatisfaccion"));
		seguimiento.setORDENES_id(rs.getInt("ORDENES_id"));
		
		return seguimiento;
	}
}
