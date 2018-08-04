package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.turbomaquinas.POJO.general.NotasCreditoPorOrden;

public class NotasCreditoPorOrdenRM implements RowMapper<List<NotasCreditoPorOrden>>{

	@Override
	public List<NotasCreditoPorOrden> mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		List<NotasCreditoPorOrden> ncpo = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		    CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, NotasCreditoPorOrden.class);
		    ncpo = mapper.readValue(rs.getString("notas_credito"), javaType);
		} catch (Exception e) {
			return null;
		}
		    	 
		return ncpo;
	}

}
