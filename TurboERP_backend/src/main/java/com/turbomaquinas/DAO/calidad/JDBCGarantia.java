package com.turbomaquinas.DAO.calidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.calidad.GarantiaVista;

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

	
	
}
