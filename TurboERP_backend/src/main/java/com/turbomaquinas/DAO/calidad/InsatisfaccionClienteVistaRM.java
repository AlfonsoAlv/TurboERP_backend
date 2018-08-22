package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;

public class InsatisfaccionClienteVistaRM implements RowMapper<InsatisfaccionClienteVista>{

	@Override
	public InsatisfaccionClienteVista mapRow(ResultSet rs, int rowNum) throws SQLException {

		InsatisfaccionClienteVista insatisfaccion = new InsatisfaccionClienteVista();
		
		insatisfaccion.setCliente_nombre_comercial(rs.getString("cliente_nombre_comercial"));
		insatisfaccion.setCliente_nombre_fiscal(rs.getString("cliente_nombre_fiscal"));
		insatisfaccion.setDescripcion_insatisfaccion(rs.getString("descripcion_insatisfaccion"));
		insatisfaccion.setDescripcion_orden(rs.getString("descripcion_orden"));
		insatisfaccion.setDescripcion_otro(rs.getString("descripcion_otro"));
		insatisfaccion.setEquipo(rs.getString("equipo"));
		insatisfaccion.setFecha_insatisfaccion(rs.getDate("fecha_insatisfaccion"));
		insatisfaccion.setFecha_operacion(rs.getDate("fecha_operacion"));
		insatisfaccion.setFolio(rs.getInt("folio"));
		insatisfaccion.setGrado_insatisfaccion(rs.getString("grado_insatisfaccion"));
		insatisfaccion.setInsatisfaccion_id(rs.getInt("insatisfaccion_id"));
		insatisfaccion.setNumero_orden(rs.getString("numero_orden"));
		insatisfaccion.setOrdenes_id(rs.getInt("ORDENES_id"));
		insatisfaccion.setPersonal_id(rs.getInt("PERSONAL_id"));
		insatisfaccion.setTipo_insatisfaccion(rs.getString("tipo_insatisfaccion"));
		insatisfaccion.setUbicacion(rs.getString("ubicacion"));
		insatisfaccion.setNumero_cliente(rs.getInt("numero_cliente"));
		insatisfaccion.setNumero_giro(rs.getInt("numero_giro"));
		insatisfaccion.setNombre_personal(rs.getString("nombre_personal"));
		insatisfaccion.setClientes_id(rs.getInt("clientes_id"));
		insatisfaccion.setEstado(rs.getString("estado"));
		insatisfaccion.setProcede_garantia(rs.getInt("procede_garantia"));
		insatisfaccion.setDias_antiguedad(rs.getInt("dias_antiguedad"));
		
		String json=rs.getString("actividades");
		
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> act = null;
		
		try {
			act = mapper.readValue(json, new TypeReference<List<Integer>>(){});
			insatisfaccion.setActividades(act);
		} catch (Exception e) { }
		

		
		return insatisfaccion;
	}
	
}
