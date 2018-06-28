package com.turbomaquinas.DAO.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.general.Ciudad;
import com.turbomaquinas.POJO.general.CiudadVista;

@Repository
public class JDBCCiudad implements CiudadDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int crear(Ciudad c) throws DataAccessException {
	
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("clave");
		columnas.add("nombre");
		columnas.add("creado_por");
		columnas.add("ESTADOS_id");
		
		insert.setTableName("CIUDADES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		
		datos.put("clave",c.getClave());
		datos.put("nombre", c.getNombre());
		datos.put("creado_por", c.getCreado_por());
		datos.put("ESTADOS_id", c.getEstados_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public Ciudad actualizar(Ciudad c) throws DataAccessException{
		
		jdbcTemplate.update("UPDATE CIUDADES set clave = ?, nombre = ?, modificado_por = ?, ESTADOS_id = ? WHERE id = ?", c.getClave(),
				c.getNombre(), c.getModificado_por(), c.getEstados_id(), c.getId());

		return c;
	}
	
	@Override
	public List<Ciudad> consultarPorEstado(int id) throws DataAccessException {
		List<Ciudad> ciudades = jdbcTemplate.query("SELECT * FROM CIUDADES WHERE ESTADOS_id IN "
				+ "(SELECT id FROM ESTADOS WHERE id = ?)", new CiudadRM(), id);
		return ciudades;
	}

	@Override
	public CiudadVista buscar(int id) throws DataAccessException {
		CiudadVista cv = jdbcTemplate.queryForObject("SELECT * FROM CIUDADES_V WHERE id = ?",
				new CiudadVistaRM(), id);
		return cv;
	}

	@Override
	public List<CiudadVista> consultar() throws DataAccessException {
		List<CiudadVista> cius = jdbcTemplate.query("SELECT * FROM CIUDADES_V",
				new CiudadVistaRM());
		return cius;
	}

	@Override
	public Ciudad consultarCiudadPorClaveYEstado(int id, String clave) {
		Ciudad c = jdbcTemplate.queryForObject("SELECT * FROM turbomaquinas.CIUDADES where clave =? and ESTADOS_id = ?  ",
				new CiudadRM(), clave, id);
		return c;
	}

}
