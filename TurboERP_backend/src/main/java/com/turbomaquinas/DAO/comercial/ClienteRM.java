package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.Cliente;

public class ClienteRM implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int i) throws SQLException {
		Cliente ct = new Cliente();
		ct.setId(rs.getInt("id"));
		ct.setNumero(rs.getInt("numero"));
		ct.setNombre_fiscal(rs.getString("nombre_fiscal"));
		ct.setDireccion_fiscal(rs.getString("direccion_fiscal"));
		ct.setColonia_fiscal(rs.getString("colonia_fiscal"));
		ct.setCodigo_postal_fiscal(rs.getString("codigo_postal_fiscal"));
		ct.setRfc(rs.getString("rfc"));
		ct.setDias_credito(rs.getInt("dias_credito"));
		ct.setNombre_comercial(rs.getString("nombre_comercial"));
		ct.setDireccion_planta(rs.getString("direccion_planta"));
		ct.setColonia_planta(rs.getString("colonia_planta"));
		ct.setActivo(rs.getInt("activo"));
		ct.setCreado_por(rs.getInt("creado_por"));
		ct.setCreado(rs.getDate("creado"));
		ct.setModificado_por(rs.getInt("modificado_por"));
		ct.setModificado(rs.getDate("modificado"));
		ct.setCiudades_id(rs.getInt("CIUDADES_id"));
		ct.setGiros_id(rs.getInt("GIROS_id"));
		ct.setPersonal_id(rs.getInt("PERSONAL_id"));
		ct.setCiudad_comercial_id(rs.getInt("CIUDAD_COMERCIAL_id"));
		ct.setFormas_pago_id(rs.getInt("FORMAS_PAGO_id"));
		ct.setMetodos_pago_id(rs.getInt("METODOS_PAGO_id"));
		ct.setUso_cfdi_id(rs.getInt("USO_CFDI_id"));
		ct.setComisionista(rs.getString("comisionista"));
		return ct;
	}
	
}
