package com.turbomaquinas.DAO.diagnostico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.diagnostico.DetalleDiagnostico;
import com.turbomaquinas.POJO.diagnostico.DetalleDiagnostico.ListaDeptos;
import com.turbomaquinas.POJO.diagnostico.DetalleDiagnosticoVista;

@Repository
public class JDBCDetalleDiagnostico implements DetalleDiagnosticoDAO{
	
	public class Deptos{
		private int id;
		private String clave;
		
		public Deptos() {
			super();
		}
		public Deptos(int id, String clave) {
			super();
			this.id = id;
			this.clave = clave;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public int crear(DetalleDiagnostico dd) throws DataAccessException {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("descripcion");
		columnas.add("tipo_actividad");
		columnas.add("lugar");
		columnas.add("suministro");
		columnas.add("creado_por");
		columnas.add("ENCABEZADOS_DIAGNOSTICO_id");
		columnas.add("planta");
		columnas.add("unidades");
		
		insert.setTableName("DETALLE_DIAGNOSTICO");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("descripcion", dd.getDescripcion());
		datos.put("tipo_actividad", dd.getTipo_actividad());
		datos.put("lugar", dd.getLugar());
		datos.put("suministro", dd.getSuministro());
		datos.put("creado_por", dd.getCreado_por());
		datos.put("ENCABEZADOS_DIAGNOSTICO_id", dd.getEncabezados_diagnostico_id());
		datos.put("planta", dd.getPlanta());
		datos.put("unidades", dd.getUnidades());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		return id.intValue();
	}

	@Override
	public void actualizar(DetalleDiagnostico dd) throws DataAccessException {
		jdbcTemplate.update("UPDATE DETALLE_DIAGNOSTICO SET descripcion = ?, tipo_actividad = ?, "
				+ "lugar = ?, suministro=?, modificado_por = ?, ENCABEZADOS_DIAGNOSTICO_id = ?, planta = ?, unidades = ?, activo = ? WHERE id = ? ",
				dd.getDescripcion(), dd.getTipo_actividad(), dd.getLugar(), dd.getSuministro(), dd.getModificado_por(),
				dd.getEncabezados_diagnostico_id(), dd.getPlanta(), dd.getUnidades(), dd.getActivo(), dd.getId());
	}

	@Override
	public DetalleDiagnosticoVista buscar(int id) throws DataAccessException {
		DetalleDiagnosticoVista ddv = jdbcTemplate.queryForObject("SELECT * FROM DETALLE_DIAGNOSTICO_V "
				+ "WHERE id = ?", new DetalleDiagnosticoVistaRM(), id);
		return ddv;
	}

	@Override
	public List<DetalleDiagnosticoVista> consultar() throws DataAccessException {
		List<DetalleDiagnosticoVista> ddvl = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V", 
				new DetalleDiagnosticoVistaRM());
		return ddvl;
	}

	@Override
	public int recuperarUltimoLugar(int encabezadoID) throws DataAccessException {
		int maximo = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(lugar), 0) FROM DETALLE_DIAGNOSTICO "+
				"WHERE ENCABEZADOS_DIAGNOSTICO_id = ? AND activo = 1", Integer.class, encabezadoID);
		return maximo;
	}

	@Override
	public List<DetalleDiagnosticoVista> consultarPorEncabezado(int id) throws DataAccessException{
		List<DetalleDiagnosticoVista> dd = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V "
				+ "WHERE ENCABEZADOS_DIAGNOSTICO_id = ? ORDER BY lugar", new DetalleDiagnosticoVistaRM(), id);
		return dd;
	}

	@Override
	public List<DetalleDiagnosticoVista> consultarPorDiagnostico(int id) throws DataAccessException{
		List<DetalleDiagnosticoVista> dv = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V "
				+ "WHERE diagnostico_id = ? "
				+ "ORDER BY lugarEncabezado, lugar", 
				new DetalleDiagnosticoVistaRM(), id);
		return dv;
	}

	@Override
	public int consultarCantidadPorEncabezado(int id){
		int cantidad = jdbcTemplate.queryForObject("SELECT COALESCE(COUNT(*), 0) FROM DETALLE_DIAGNOSTICO "+
				"WHERE ENCABEZADOS_DIAGNOSTICO_id = ? AND activo = 1", Integer.class, id);
		return cantidad;
	}

	@Override
	public void reordenar_actualiza(int encabezados_diagnostico_id, int lugarDestino, int lugarOrigen) {
		jdbcTemplate.update("CALL REORDENA_DD_LUGAR_ACTUALIZA(?, ?, ?)", 
				encabezados_diagnostico_id, lugarDestino, lugarOrigen);	
	}

	@Override
	public void reordenar_elimina(int encabezados_diagnostico_id, int lugarOrigen) {
		jdbcTemplate.update("CALL REORDENA_DD_LUGAR_ELIMINA(?, ?)", 
				encabezados_diagnostico_id, lugarOrigen);
	}

	@Override
	public List<DetalleDiagnosticoVista> consultarPorListaId(List<Integer> ids) throws DataAccessException {
		String lista = null;
		for (int id: ids) {
			if(lista == null){
				lista = id+",";
			}else{
				lista = lista+id+",";
			}
				
		}
		lista = lista.substring(0, lista.length()-1);
		List<DetalleDiagnosticoVista> detalles = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V WHERE id IN ("+lista+")", new DetalleDiagnosticoVistaRM());
		return detalles;
	}

	@Override
	public DetalleDiagnostico obtener(int id) throws DataAccessException {
		DetalleDiagnostico dd = jdbcTemplate.queryForObject("SELECT * FROM DETALLE_DIAGNOSTICO "
				+ "WHERE id = ?", new DetalleDiagnosticoRM(), id);
		return dd;
	}

	@Override
	public List<DetalleDiagnosticoVista> consultarAutorizadosPorDetalleCO(int id) throws DataAccessException {
			List<DetalleDiagnosticoVista> dv = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V "
				+ "WHERE id IN "
				+ "(SELECT `DETALLE_DIAGNOSTICO_id` FROM `ACTIVIDADES_PRODUCCION` "
				+ "WHERE ACTIVIDADES_AUTORIZADAS_id IN (SELECT id FROM ACTIVIDADES_AUTORIZADAS WHERE `DETALLES_COTIZACIONES_id` = ?)) "
				+ "ORDER BY lugarEncabezado, lugar", 
				new DetalleDiagnosticoVistaRM(), id);
		return dv;
	}
	
	@Override
	public List<DetalleDiagnosticoVista> consultarAutorizadosPorDetalleDI(int id) throws DataAccessException {
		/*"SELECT * FROM DETALLE_DIAGNOSTICO_V dd"
				+ " WHERE diagnostico_id = ? AND EXISTS (SELECT * FROM ACTIVIDADES_PRODUCCION WHERE DETALLE_DIAGNOSTICO_id = dd.id)"
				+ " ORDER BY lugar"*/
		
		String sql="SELECT * FROM DETALLE_DIAGNOSTICO_V dd "
				+ "WHERE diagnostico_id = ? AND (EXISTS (SELECT * FROM ACTIVIDADES_PRODUCCION ap JOIN ORIGEN_AA oa ON oa.ACTIVIDADES_PRODUCCION_id=ap.id WHERE oa.DETALLE_DIAGNOSTICO_id = dd.id) "
				+ "OR (EXISTS (SELECT * FROM ACTIVIDADES_PRODUCCION ap JOIN ORIGEN_ANTICIPADAS oa ON oa.ACTIVIDADES_PRODUCCION_id=ap.id WHERE oa.DETALLE_DIAGNOSTICO_id = dd.id))) ORDER BY lugar";
		List<DetalleDiagnosticoVista> ddv = jdbcTemplate.query(sql, 
				new DetalleDiagnosticoVistaRM(), id);
		return ddv;
	}

	@Override
	public void asignarDeptos(int id, ListaDeptos lista) throws DataAccessException {
		jdbcTemplate.update("UPDATE DETALLE_DIAGNOSTICO SET departamentos = ? WHERE id = ? ",
		lista.toString(), id);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deptos> consultarDeptos(int id) {
		String sql = "SELECT d.id, d.clave "
				+ "FROM DETALLE_DIAGNOSTICO dd "
				+ "LEFT JOIN DEPARTAMENTOS d ON JSON_CONTAINS(dd.departamentos, CAST(d.id AS JSON), '$.ids') "
				+ "WHERE dd.id = ?";
		List<? extends Object> deptos = jdbcTemplate.query(sql, 
			new RowMapper<Object>() {
			@Override
			public Object mapRow(ResultSet rs, int i) throws SQLException {
				return new Deptos(rs.getInt("id"), rs.getString("clave"));
			}
		}, id);
		return (List<Deptos>) deptos;
	}
}
