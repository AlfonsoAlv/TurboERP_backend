package com.turbomaquinas.DAO.calidad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.calidad.EstadoCierreFoco;
import com.turbomaquinas.POJO.calidad.GarantiaVista;
import com.turbomaquinas.POJO.calidad.PorcentajeActividades;

@Repository
public class JDBCGarantia implements GarantiaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public GarantiaVista buscar(int id) throws DataAccessException {
		GarantiaVista garantia = jdbcTemplate.queryForObject("SELECT g.id,g.descripcion,g.activo,g.creado_por,g.creado,"
				+ "g.modificado_por,g.modificado,g.PERSONAL_id,o.id as ORDENES_id,"
				+ "o.numero_orden,o.descripcion as descripcion_orden,c.id as CLIENTES_id,"
				+ "IF(gi.numero<3,c.nombre_comercial,c.nombre_fiscal) AS nombre_cliente, "
				+ "gi.numero as numero_giro, c.numero as numero_cliente,"
				+ "CONCAT(p.nombre,' ',p.paterno,' ',p.materno) as elaboro "
				+ "FROM GARANTIAS g "
				+ "JOIN ORDENES o ON o.id=g.ORDENES_id "
				+ "JOIN CLIENTES c ON c.id=o.CLIENTES_id "
				+ "JOIN GIROS gi ON gi.id=c.GIROS_id "
				+ "JOIN PERSONAL p on p.id=g.PERSONAL_id "
				+ "WHERE g.id = ?",
				new GarantiaVistaRM(), id);
		return garantia;
	}


	@Override
	public int crearActividadesGarantia(String obj_actividades_Garantia) throws DataAccessException {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("CREAR_ACTIVIDADES_GARANTIA");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		
		inParamMap.put("obj_actividades_Garantia", obj_actividades_Garantia);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		int idGarantia=0;
		try{
			for (Entry<String, Object> entry : simpleJdbcCallResult.entrySet()) {
				if (entry.getKey().compareTo("p_idGarantia") == 0) {
					idGarantia=(int)entry.getValue();
		        }
		    }
			return idGarantia;
		}catch(Exception e){return 0;}
		
	}

	@Override
	public List<Integer> obtenerFocos(int id) {
		
		String sql = "SELECT DETALLE_GARANTIAS.INSATISFACCIONES_id " +
						" FROM DETALLE_GARANTIAS " +
						" WHERE ENCABEZADOS_GARANTIA_id IN " +
							" (SELECT ENCABEZADOS_GARANTIA.`id` " +  
							" FROM ENCABEZADOS_GARANTIA " + 
							" WHERE GARANTIAS_id = ?) " + 
						" GROUP BY DETALLE_GARANTIAS.`INSATISFACCIONES_id`;";
		
		return jdbcTemplate.queryForList(sql, Integer.class, id);
		
	}

	@Override
	public EstadoCierreFoco obtenerEstadoCierreFoco(int focoId) throws DataAccessException {
		
		String sql = "SELECT ? AS idIns, " +
					" (SELECT INSATISFACCIONES_CLIENTES.`estado` " +
							" FROM INSATISFACCIONES_CLIENTES " +
							" WHERE INSATISFACCIONES_CLIENTES.`id` = idIns) AS 'estadoFoco', " +
					" (SELECT `folio` FROM INSATISFACCIONES_CLIENTES WHERE id = idIns) AS folio, " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo` " +
					"	FROM `SEGUIMIENTO_INSATISFACCION` " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns " +
					"		AND (SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'VV' " +
					"			OR SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'VC')) AS 'estatusValidacion', " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo` " +
					"	FROM `SEGUIMIENTO_INSATISFACCION` " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns " +
					"		AND SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'VV' ) AS 'validadoComercial', " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo` " +
					"	FROM `SEGUIMIENTO_INSATISFACCION`  " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns  " +
					"		AND SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'VC' ) AS 'validadoCliente', " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo`  " +
					"	FROM `SEGUIMIENTO_INSATISFACCION`  " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns  " +
					"		AND (SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'IV'  " +
					"			OR SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'IC')) AS 'estatusClienteInformado', " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo`  " +
					"	FROM `SEGUIMIENTO_INSATISFACCION`  " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns  " +
					"		AND SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'IV' ) AS 'clienteInformadoComercial', " +
					" EXISTS (SELECT `SEGUIMIENTO_INSATISFACCION`.`tipo`  " +
					"	FROM `SEGUIMIENTO_INSATISFACCION`  " +
					"	WHERE SEGUIMIENTO_INSATISFACCION.`INSATISFACCIONES_CLIENTES_id` = idIns  " +
					"		AND SEGUIMIENTO_INSATISFACCION.`tipo` LIKE 'IC' ) AS 'clienteInformadoCalidad';";
		
		return jdbcTemplate.queryForObject(sql, new EstadoCierreFocoRM(), focoId);
	}


	@Override
	public PorcentajeActividades obtenerPorcentajeActividades(int focoId) throws DataAccessException {
		String sql = "SELECT " +
						"SUM(IF(DETALLE_GARANTIAS.`procede` = 'P',0,1)) AS 'definidas', " +
						"SUM(1) AS 'totales' " +
					"FROM DETALLE_GARANTIAS WHERE DETALLE_GARANTIAS.`INSATISFACCIONES_id` = ?";
		
		return jdbcTemplate.queryForObject(sql, new PorcentajeActividadesRM(), focoId);
		
	}
	
}
