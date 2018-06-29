package com.turbomaquinas.DAO.proveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.proveedores.IndicadoresTotalesDeRequisiciones;

@Repository
public class JDBCIndicadoresTotalesDeRequisiciones implements  IndicadoresTotalesDeRequisicionesDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<IndicadoresTotalesDeRequisiciones> consultar() {
		String sql = "SELECT * FROM INDICADORES_TOTALES_DE_REQUISICIONES";
		List<IndicadoresTotalesDeRequisiciones> indtr = jdbcTemplate.query(sql,new IndicadoresTotalesDeRequisicionesRM());
		return indtr;
	}

}
