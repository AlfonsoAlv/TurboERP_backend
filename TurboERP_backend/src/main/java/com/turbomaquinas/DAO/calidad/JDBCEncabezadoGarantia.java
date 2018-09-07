package com.turbomaquinas.DAO.calidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;

@Repository
public class JDBCEncabezadoGarantia implements EncabezadoGarantiaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<EncabezadoGarantiaVista> consultarPorGarantia(int id) {
		List<EncabezadoGarantiaVista> ec = jdbcTemplate.query("SELECT "
				+ "`e`.`id`                             AS `id`, "
				+ "`e`.`descripcion`                    AS `descripcion`, "
				+ "`e`.`lugar`                          AS `lugar`,"
				+ "`e`.`activo`                         AS `activo`,"
				+ "`e`.`creado_por`                     AS `creado_por`,"
				+ "`e`.`creado`                         AS `creado`,"
				+ "`e`.`modificado_por`                 AS `modificado_por`,"
				+ "`e`.`modificado`                     AS `modificado`,"
				+ "`g`.`id`                             AS `garantias_id`,"
				+ "(SELECT COALESCE(COUNT(0),0) FROM `DETALLE_GARANTIAS`"
				+ " WHERE ((`DETALLE_GARANTIAS`.`ENCABEZADOS_GARANTIA_id` = `e`.`id`)"
				+ " AND (`DETALLE_GARANTIAS`.`activo` = 1))) AS `cant_detalles` " + " FROM (`ENCABEZADOS_GARANTIA` `e`"
				+ " JOIN `GARANTIAS` `g` ON ((`g`.`id` = `e`.`GARANTIAS_id`)))"
				+ " WHERE (`e`.`activo` = 1) AND g.id = ? ORDER BY lugar", new EncabezadoGarantiaVistaRM(), id);
		return ec;
	}

	@Override
	public int consultarCantidadporGarantia(int id) {
		int cantidad = jdbcTemplate.queryForObject("SELECT COALESCE(COUNT(*), 0) FROM ENCABEZADOS_GARANTIA "+
				"WHERE GARANTIAS_id = ? AND activo = 1", Integer.class, id);
		return cantidad;
	}
}
