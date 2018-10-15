package com.turbomaquinas.DAO.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;

@Repository
public class JDBCOrdenInicioTrabajo implements OrdenInicioTrabajoDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<OrdenInicioTrabajoVista> consultarConFiltros(String numero_orden,String prioridad,String estado,String anio,String tipo) throws DataAccessException {
		String sql="SELECT oit.id,o.numero_orden,oit.numero AS numero_oit, alfresco_id, "
				+ "o.descripcion AS descripcion_orden, "
				+ "(SELECT IF(((SELECT numero FROM GIROS g WHERE g.id=c.GIROS_id)) >2,c.nombre_fiscal,c.nombre_comercial) FROM CLIENTES c WHERE c.id=o.CLIENTES_id) AS nombre_cliente, "
				+ "oit.estado, "
				+ "(SELECT CASE WHEN oit.estado='I' THEN 'INICIADA' "
				+ "WHEN oit.estado='P' THEN 'EN PROCESO' "
				+ "WHEN oit.estado='S' THEN 'SUSPENDIDAS' "
				+ "WHEN oit.estado='T' THEN 'TERMINADAS' "
				+ "WHEN oit.estado='C' THEN 'CANCELADAS' "
				+ "END) AS descripcion_estado, "
				+ "o.tipo, "
				+ "(SELECT CASE WHEN o.tipo='' THEN 'COMERCIAL' "
				+ "WHEN o.tipo='G' THEN 'GARANTÍA' "
				+ "WHEN o.tipo='C' THEN 'CORTESIA' "
				+ "WHEN o.tipo='R' THEN 'REPROCESO' "
				+ "WHEN o.tipo='A' THEN 'ANTICIPADAS' "
				+ "END ) AS origen, "
				+ "oit.prioridad, "
				+ "(SELECT CASE WHEN oit.prioridad='A' THEN 'ALTA' "
				+ "WHEN oit.prioridad='M' THEN 'MEDIA' "
				+ "WHEN oit.prioridad='B' THEN 'BAJA' "
				+ "END ) AS descripcion_prioridad,  "
				+ "oit.avance, "
				+ "(SELECT descripcion_equipo FROM EQUIPO_RECIBIDO WHERE ORDENES_id=o.id) AS descripcion_equipo_recibido, oit.fecha "
				+ "FROM OIT oit "
				+ "JOIN ORDENES o ON o.id=oit.ORDENES_id "
				+ "JOIN CLIENTES c ON c.id=o.CLIENTES_id "
				+ "WHERE YEAR(fecha) LIKE ? AND tipo LIKE ? "
				+ "AND oit.estado LIKE ? AND prioridad LIKE ? "
				+ "AND numero_orden LIKE ?";
		List<OrdenInicioTrabajoVista> oit = jdbcTemplate.query(sql, new OrdenInicioTrabajoVistaRM(),anio,tipo,estado,prioridad,numero_orden);
		return oit;
	}


	@Override
	public List<Integer> anios() {
		List<Integer> o = jdbcTemplate.queryForList("SELECT DISTINCT(YEAR(fecha)) anio FROM OIT ORDER BY anio desc", Integer.class);
		return o;
	}


	@Override
	public void cancelar(int id, int modificado_por) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("BAJA_OIT");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_oit_id", id);
		inParamMap.put("p_modificado_por", modificado_por);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
	}


	@Override
	public void crearOIT(String p_obj_act_oit) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CREAR_OIT");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_obj_act_oit", p_obj_act_oit);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);
	}
}
