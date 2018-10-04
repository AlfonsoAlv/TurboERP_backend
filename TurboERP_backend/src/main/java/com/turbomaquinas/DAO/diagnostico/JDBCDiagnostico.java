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

import com.turbomaquinas.POJO.diagnostico.DetalleDiagnosticoVista;
import com.turbomaquinas.POJO.diagnostico.Diagnostico;
import com.turbomaquinas.POJO.diagnostico.DiagnosticoVista;

@Repository
public class JDBCDiagnostico implements DiagnosticoDAO{
	
	public class ActividadProduccion {
		private int actividades_produccion_id;
		private int detalle_diagnostico_id;
		private String detalle_descripcion;
		private int lugar;
		private int encabezado_diagnostico_id;
		private String encabezado_descripcion;
		
		public ActividadProduccion(int actividades_produccion_id, int detalle_diagnostico_id,
				String detalle_descripcion, int lugar, int encabezado_diagnostico_id, String encabezado_descripcion) {
			super();
			this.actividades_produccion_id = actividades_produccion_id;
			this.detalle_diagnostico_id = detalle_diagnostico_id;
			this.detalle_descripcion = detalle_descripcion;
			this.lugar = lugar;
			this.encabezado_diagnostico_id = encabezado_diagnostico_id;
			this.encabezado_descripcion = encabezado_descripcion;
		}
		public int getActividades_produccion_id() {
			return actividades_produccion_id;
		}
		public void setActividades_produccion_id(int actividades_produccion_id) {
			this.actividades_produccion_id = actividades_produccion_id;
		}
		public int getDetalle_diagnostico_id() {
			return detalle_diagnostico_id;
		}
		public void setDetalle_diagnostico_id(int detalle_diagnostico_id) {
			this.detalle_diagnostico_id = detalle_diagnostico_id;
		}
		public String getDetalle_descripcion() {
			return detalle_descripcion;
		}
		public void setDetalle_descripcion(String detalle_descripcion) {
			this.detalle_descripcion = detalle_descripcion;
		}
		public int getLugar() {
			return lugar;
		}
		public void setLugar(int lugar) {
			this.lugar = lugar;
		}
		public int getEncabezado_diagnostico_id() {
			return encabezado_diagnostico_id;
		}
		public void setEncabezado_diagnostico_id(int encabezado_diagnostico_id) {
			this.encabezado_diagnostico_id = encabezado_diagnostico_id;
		}
		public String getEncabezado_descripcion() {
			return encabezado_descripcion;
		}
		public void setEncabezado_descripcion(String encabezado_descripcion) {
			this.encabezado_descripcion = encabezado_descripcion;
		}
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int crear(Diagnostico d) throws DataAccessException {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columnas = new ArrayList<>();
		columnas.add("consecutivo");
		columnas.add("creado_por");
		columnas.add("AREAS_id");
		columnas.add("ORDENES_id");
		columnas.add("PERSONAL_id");

		insert.setTableName("DIAGNOSTICO");
		insert.setColumnNames(columnas);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("consecutivo", d.getConsecutivo());
		datos.put("creado_por", d.getCreado_por());
		datos.put("AREAS_id", d.getAreas_id());
		datos.put("ORDENES_id", d.getOrdenes_id());
		datos.put("PERSONAL_id", d.getPersonal_id());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);

		return id.intValue();
	}

	@Override
	public Diagnostico actualizar(Diagnostico d) throws DataAccessException {
		jdbcTemplate.update("UPDATE DIAGNOSTICO SET consecutivo = ?, modificado_por = ?, AREAS_id = ?, "
				+ "ORDENES_id = ?, PERSONAL_id = ?, activo = ? WHERE id = ?", d.getConsecutivo(), d.getModificado_por(),
				d.getAreas_id(), d.getOrdenes_id(), d.getPersonal_id(), d.getActivo(), d.getId());
		
		return d;
	}

	@Override
	public DiagnosticoVista buscar(int id) throws DataAccessException {
		DiagnosticoVista diag = jdbcTemplate.queryForObject("SELECT * FROM DIAGNOSTICO_V WHERE id = ?", 
				new DiagnosticoVistaRM(), id);
		return diag;
	}

	@Override
	public List<DiagnosticoVista> consultar() throws DataAccessException {
		List<DiagnosticoVista> diagl = jdbcTemplate.query("SELECT * FROM DIAGNOSTICO_V", 
				new DiagnosticoVistaRM());
		return diagl;
	}

	@Override
	public DiagnosticoVista buscarDiagnostico(String numeroOrden) throws DataAccessException{
		DiagnosticoVista pv = jdbcTemplate.queryForObject("SELECT * FROM DIAGNOSTICO_V WHERE numero_orden=?", 
				new DiagnosticoVistaRM(), numeroOrden);
		return pv;
	}

	@Override
	public List<Integer> aniosRecomendaciones() throws DataAccessException {
		List<Integer> d = jdbcTemplate.queryForList("SELECT DISTINCT(anioorden) FROM DIAGNOSTICO_V ORDER BY anioorden DESC", 
				Integer.class);
		return d;
	}

	@Override
	public List<DiagnosticoVista> recomendacionesAnio(int anio) throws DataAccessException {
		List<DiagnosticoVista> dv = jdbcTemplate.query("SELECT * FROM DIAGNOSTICO_V WHERE anioorden=?", 
				new DiagnosticoVistaRM(), anio);
		return dv;
	}

	@Override
	public List<DiagnosticoVista> buscarDiagnosticoPorOrdenSinAutorizar(int id) {
		List<DiagnosticoVista> bdo = jdbcTemplate.query("SELECT * FROM DIAGNOSTICO_V d WHERE d.ordenes_id = ? "
				+ " AND d.id IN (SELECT diagnostico_id FROM DETALLE_DIAGNOSTICO_V ddv WHERE "
				+ "	NOT EXISTS (SELECT * FROM DETALLE_DIAGNOSTICO_AA WHERE DETALLE_DIAGNOSTICO_id = ddv.id))",
				new DiagnosticoVistaRM(), id);
		return bdo;
	}

	@Override
	public List<DiagnosticoVista> buscarPorOrden(int id) {
		List<DiagnosticoVista> bdvo = jdbcTemplate.query("SELECT * FROM DIAGNOSTICO_V d WHERE d.ordenes_id = ? "
				,new DiagnosticoVistaRM(), id);
		return bdvo;
	}

	@Override
	public List<DetalleDiagnosticoVista> consultarActividadesPendientesAutorizar(int id) {
		List<DetalleDiagnosticoVista> capa = jdbcTemplate.query("SELECT * FROM DETALLE_DIAGNOSTICO_V ddv "
				+ "WHERE diagnostico_id = ? AND NOT EXISTS (SELECT * FROM DETALLE_DIAGNOSTICO_AA WHERE DETALLE_DIAGNOSTICO_id = ddv.id)"
				,new DetalleDiagnosticoVistaRM(), id);
		return capa;
	}

	@Override
	public List<ActividadProduccion> consultarActividadesProduccion(int id) {		
		String sql ="SELECT (SELECT ACTIVIDADES_PRODUCCION_id FROM ORIGEN_AA AP WHERE DD.id = AP.DETALLE_DIAGNOSTICO_id LIMIT 1) actividades_produccion_id, "
				+ " DD.id detalle_diagnostico_id, DD.descripcion detalle_descripcion, DD.lugar, ED.id encabezado_diagnostico_id, ED.descripcion encabezado_descripcion "
				+ " FROM DETALLE_DIAGNOSTICO DD "
				+ " JOIN ENCABEZADOS_DIAGNOSTICO ED ON (ED.id = DD.ENCABEZADOS_DIAGNOSTICO_id AND ED.DIAGNOSTICO_id = ?) "
				+ " WHERE EXISTS (SELECT * FROM ORIGEN_AA AP WHERE DD.id = AP.DETALLE_DIAGNOSTICO_id) "
				+ " ORDER BY ED.id";
	
		List<ActividadProduccion> actividades = jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int i) throws SQLException {
				return new ActividadProduccion(
						rs.getInt("actividades_produccion_id"), 
						rs.getInt("detalle_diagnostico_id"), 
						rs.getString("detalle_descripcion"), 
						rs.getInt("lugar"), 
						rs.getInt("encabezado_diagnostico_id"), 
						rs.getString("encabezado_descripcion"));
			}
		}, id);
		return actividades;
	}

}
