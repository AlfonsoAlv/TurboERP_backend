package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.calidad.EstadoCierreFoco;

public class EstadoCierreFocoRM implements RowMapper<EstadoCierreFoco> {

	@Override
	public EstadoCierreFoco mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return EstadoCierreFoco
				.builder()
				.folio(rs.getInt("folio"))
				.estadoFoco(rs.getString("estadoFoco"))
				.estatusValidacion(rs.getInt("estatusValidacion"))
				.validadoComercial(rs.getInt("validadoComercial"))
				.validadoCliente(rs.getInt("validadoCliente"))
				.estatusClienteInformado(rs.getInt("estatusClienteInformado"))
				.clienteInformadoCalidad(rs.getInt("clienteInformadoComercial"))
				.clienteInformadoComercial(rs.getInt("clienteInformadoCalidad"))
				.build();
		
	}

}
