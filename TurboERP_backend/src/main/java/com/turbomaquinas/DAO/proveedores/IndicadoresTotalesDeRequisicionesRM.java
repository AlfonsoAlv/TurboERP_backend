package com.turbomaquinas.DAO.proveedores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.proveedores.IndicadoresTotalesDeRequisiciones;

public class IndicadoresTotalesDeRequisicionesRM implements RowMapper<IndicadoresTotalesDeRequisiciones> {

	@Override
	public IndicadoresTotalesDeRequisiciones mapRow(ResultSet rs, int i) throws SQLException {
		
		IndicadoresTotalesDeRequisiciones intr = new IndicadoresTotalesDeRequisiciones();
		intr.setId(rs.getInt("id"));
		intr.setFavor_requeridosentiempo(rs.getInt("favor_requeridosentiempo"));
		intr.setEncontra_requeridosentiempo(rs.getInt("encontra_requeridosentiempo"));
		intr.setFavor_plandeproduccion(rs.getInt("favor_plandeproduccion"));
		intr.setEncontra_plandeproduccion(rs.getInt("encontra_plandeproduccion"));
		intr.setFavor_entregasentiempo(rs.getInt("favor_entregasentiempo"));
		intr.setEncontra_entregasentiempo(rs.getInt("encontra_entregasentiempo"));
		intr.setLiberadas(rs.getInt("liberadas"));
		intr.setRechazadas(rs.getInt("rechazadas"));
		return intr;
	}
	
	

}
