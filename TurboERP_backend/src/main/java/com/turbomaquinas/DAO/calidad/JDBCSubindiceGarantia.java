package com.turbomaquinas.DAO.calidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;

@Repository
public class JDBCSubindiceGarantia implements SubindiceGarantiaDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<SubindiceGarantiaVista> consultarPorGarantia(int id) throws DataAccessException {
		List<SubindiceGarantiaVista> sv = jdbcTemplate.query("SELECT "
				+ "`s`.`id`             AS `id`,"
				+ "`s`.`descripcion`    AS `descripcion`,"
				+ "`s`.`lugar`          AS `lugar`,"
				+ "`s`.`activo`         AS `activo`,"
				+ "`s`.`creado_por`     AS `creado_por`,"
				+ "`s`.`creado`         AS `creado`,"
				+ "`s`.`modificado_por` AS `modificado_por`,"
				+ "`s`.`modificado`     AS `modificado`,"
				+ "`d`.`id`             AS `detalle_garantias_id`,"
				+ "`d`.`descripcion`    AS `detalle_descripcion`,"
				+ "`d`.`lugar`          AS `detalle_lugar`,"
				+ "`e`.`id`             AS `encabezados_garantias_id`,"
				+ "`e`.`descripcion`    AS `descripcion_encabezado`,"
				+ "`e`.`lugar`          AS `lugar_encabezado`,"
				+ "`g`.`id`             AS `garantias_id`"
				+ "FROM (((`SUBINDICES_GARANTIA` `s` "
				+ "JOIN `DETALLE_GARANTIAS` `d` "
				+ "ON ((`d`.`id` = `s`.`DETALLE_GARANTIAS_id`))) "
				+ "JOIN `ENCABEZADOS_GARANTIA` `e` "
				+ "ON ((`e`.`id` = `d`.`ENCABEZADOS_GARANTIA_id`))) "
				+ "JOIN `GARANTIAS` `g` "
				+ "ON ((`g`.`id` = `e`.`GARANTIAS_id`))) "
				+ "WHERE (`s`.`activo` = 1) AND g.id= ? ORDER BY lugar_encabezado, detalle_lugar, lugar", 
				new SubindiceGarantiaVistaRM(), id);
		return sv;
	}
	
	
}
