package com.turbomaquinas.DAO.comercial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletes;
import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletesVista;

@Repository
public class JDBCEquipoSolicitudFletes implements EquipoSolicitudFletesDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int crear(EquipoSolicitudFletes esf) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("descripcion");
		columnas.add("peso");
		columnas.add("unidades");
		columnas.add("activo");
		columnas.add("creado_por");
		columnas.add("EQUIPO_POR_RECIBIR_id");
		columnas.add("EQUIPO_RECIBIDO_id");
		columnas.add("MEDIDAS_EQUIPOS_id");
		columnas.add("SOLICITUD_FLETES_id");

		insert.setTableName("EQUIPOS_SOLICITUD_FLETES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("descripcion", esf.getDescripcion());
		datos.put("peso", esf.getPeso());
		datos.put("unidades", esf.getUnidades());
		datos.put("activo", esf.getActivo());
		datos.put("creado_por", esf.getCreado_por());
		datos.put("EQUIPO_POR_RECIBIR_id", esf.getEquipo_por_recibir_id());
		datos.put("EQUIPO_RECIBIDO_id", esf.getEquipo_recibido_id());
		datos.put("MEDIDAS_EQUIPOS_id", esf.getMedidas_equipos_id());
		datos.put("SOLICITUD_FLETES_id", esf.getSolicitud_flete_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public List<EquipoSolicitudFletesVista> consultarPorCliente(int id) {
		List<EquipoSolicitudFletesVista> esfv = jdbcTemplate.query("SELECT * FROM turbomaquinas.EQUIPOS_SOLICITUD_FLETES_V where clientes_id = ?", 
				new EquipoSolicitudFletesVistaRM(), id);
		return esfv;
	}

	@Override
	public EquipoSolicitudFletes buscar(int id) {
		EquipoSolicitudFletes esf = jdbcTemplate.queryForObject("SELECT * FROM turbomaquinas.EQUIPOS_SOLICITUD_FLETES where id =?", 
				new EquipoSolicitudFletesRM(), id);
		return esf;
	}

}
