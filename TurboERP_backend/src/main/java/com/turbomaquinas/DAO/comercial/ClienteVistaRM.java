package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.ClienteVista;

public class ClienteVistaRM implements  RowMapper<ClienteVista>{

	@Override
	public ClienteVista mapRow(ResultSet rs, int i) throws SQLException {
		ClienteVista cv = new ClienteVista();  
		cv.setId(rs.getInt("id"));
		cv.setNumero(rs.getInt("numero"));
		cv.setNombre_fiscal(rs.getString("nombre_fiscal"));
		cv.setDireccion_fiscal(rs.getString("direccion_fiscal"));
		cv.setColonia_fiscal(rs.getString("colonia_fiscal"));
		cv.setCodigo_postal_fiscal(rs.getString("codigo_postal_fiscal"));
		cv.setRfc(rs.getString("rfc"));
		cv.setDias_credito(rs.getInt("dias_credito"));
		cv.setNombre_comercial(rs.getString("nombre_comercial"));
		cv.setDireccion_planta(rs.getString("direccion_planta"));
		cv.setColonia_planta(rs.getString("colonia_planta"));
		cv.setActivo(rs.getInt("activo"));
		cv.setCiudades_id(rs.getInt("CIUDADES_id"));
		cv.setCiudad(rs.getString("ciudad"));
		cv.setEstados_id(rs.getInt("estado_id"));
		cv.setEstado(rs.getString("estado"));
		cv.setPais_id(rs.getInt("pais_id"));
		cv.setPais(rs.getString("pais"));
		cv.setGiros_id(rs.getInt("GIROS_id"));
		cv.setNum_giro(rs.getInt("num_giro"));
		cv.setDes_giro(rs.getString("des_giro"));
		cv.setPersonal_id(rs.getInt("PERSONAL_id"));
		cv.setPersonal(rs.getString("personal"));
		cv.setCiudad_comercial_id(rs.getInt("CIUDAD_COMERCIAL_id"));
		cv.setCiudad_c(rs.getString("ciudad_c"));
		cv.setEstado_c_id(rs.getInt("estado_c_id"));
		cv.setEstado_c(rs.getString("estado_c"));
		cv.setNom_formaP(rs.getString("nom_formaP"));
		cv.setCve_formaP(rs.getString("cve_formaP"));
		cv.setNom_metodoP(rs.getString("nom_metodoP"));
		cv.setCve_metodoP(rs.getString("cve_metodoP"));
		cv.setNom_usocfdi(rs.getString("nom_usocfdi"));
		cv.setCve_usocfdi(rs.getString("cve_usocfdi"));
		cv.setMetodos_pago_id(rs.getInt("METODOS_PAGO_id"));
		cv.setFormas_pago_id(rs.getInt("FORMAS_PAGO_id"));
		cv.setUso_cfdi_id(rs.getInt("USO_CFDI_id"));
		cv.setComisionista(rs.getString("comisionista"));
		return cv;
	}
}
