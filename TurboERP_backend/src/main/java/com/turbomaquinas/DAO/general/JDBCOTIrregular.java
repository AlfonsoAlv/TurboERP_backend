package com.turbomaquinas.DAO.general;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.general.OTIrregular;
import com.turbomaquinas.POJO.general.OTIrregularVista;

@Repository
public class JDBCOTIrregular implements OTIrregularDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int crear(String iniciales, Date fechaRegularizacion, String comentarios, String proceso, int creadoPor,
			int ordenId, int contactoID) throws DataAccessException{
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("iniciales");
		columnas.add("fecha_regularizacion");
		columnas.add("comentarios");
		columnas.add("proceso");
		columnas.add("creado_por");
		columnas.add("ORDENES_id");
		columnas.add("CONTACTOS_id");
		
		insert.setTableName("OT_IRREGULARES");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("iniciales", iniciales);
		datos.put("fecha_regularizacion", fechaRegularizacion);
		datos.put("comentarios", comentarios);
		datos.put("proceso", proceso);
		datos.put("creado_por", creadoPor);
		datos.put("ORDENES_id", ordenId);
		datos.put("CONTACTOS_id", contactoID);
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}	

	@Override
	public void actualizar(OTIrregular oti) throws DataAccessException {
		jdbcTemplate.update("UPDATE OT_IRREGULARES SET usuario_acepta=?, fecha_acepta=?, modificado_por=? "
				+ "WHERE id=?", oti.getUsuario_acepta(), oti.getFecha_acepta(), oti.getModificado_por(),
				oti.getId());
	}

	@Override
	public OTIrregularVista buscar(int id) throws DataAccessException {
		OTIrregularVista otiv = jdbcTemplate.queryForObject("SELECT * FROM OT_IRREGULARES_V WHERE id=?", 
				new OTIrregularVistaRM(), id);
		return otiv;
	}

	@Override
	public List<OTIrregularVista> consultar() throws DataAccessException {
		List<OTIrregularVista> oti = jdbcTemplate.query("SELECT * FROM OT_IRREGULARES_V ", 
				new OTIrregularVistaRM());
			return oti;
	}

	@Override
	public OTIrregularVista buscarOTIrregular(String Folio) throws DataAccessException{
		OTIrregularVista ot = jdbcTemplate.queryForObject("SELECT * FROM OT_IRREGULARES_V WHERE folio=?", 
				new OTIrregularVistaRM(), Folio);
		return ot;
	}

	@Override
	public void aceptaOTI(int id, int usuarioAcepta, String estado) throws DataAccessException {
		jdbcTemplate.update("UPDATE OT_IRREGULARES SET usuario_acepta=?, estado=? WHERE id=?", usuarioAcepta, estado, id);
		jdbcTemplate.update("UPDATE ORDENES SET importe_autorizado=(importe_autorizado+(SELECT SUM(importe_autorizado) FROM ACTIVIDADES_AUTORIZADAS WHERE OT_IRREGULARES_id=?)) WHERE id=(SELECT ORDENES_id FROM OT_IRREGULARES WHERE id=?)", id, id);
	}

}
