package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.turbomaquinas.POJO.calidad.PorcentajeActividades;

public class PorcentajeActividadesRM implements RowMapper<PorcentajeActividades>{

	@Override
	public PorcentajeActividades mapRow(ResultSet rs, int rowNum) throws SQLException {
		PorcentajeActividades pa = new PorcentajeActividades();
		pa.setActividadesDefinidas(rs.getInt("definidas"));
		pa.setActividadesTotales(rs.getInt("totales"));
		try {
			System.out.println(pa.getActividadesDefinidas());
			System.out.println(pa.getActividadesTotales());
			float porcentaje = pa.getActividadesDefinidas() / pa.getActividadesTotales();
			System.out.println(porcentaje);
			porcentaje *= 100;
			pa.setPorcentajeCompletado(porcentaje);
		} catch (Exception e) { e.printStackTrace();}
		
		return pa;
	}
	
}
