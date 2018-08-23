package com.turbomaquinas.DAO.comercial;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.comercial.DocumentoAplicarNotasCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;

public class NotaCreditoVistaRM implements RowMapper<NotaCreditoVista> {

	@Override
	public NotaCreditoVista mapRow(ResultSet rs, int i) throws SQLException {
		
		NotaCreditoVista nc = new NotaCreditoVista();
		nc.setId(rs.getInt("id"));
		nc.setTipo(rs.getString("tipo"));
		nc.setNumero(rs.getInt("numero"));
		nc.setFecha(rs.getDate("fecha"));
		nc.setSubtotal(rs.getBigDecimal("subtotal"));
		nc.setIva(rs.getBigDecimal("iva"));
		nc.setTipo_cambio(rs.getBigDecimal("tipo_cambio"));
		nc.setFecha_baja(rs.getDate("fecha_baja"));
		nc.setMes_baja(rs.getInt("mes_baja"));
		nc.setAnio_baja(rs.getInt("anio_baja"));
		nc.setDescripcion(rs.getString("descripcion"));
		nc.setActivo(rs.getInt("activo"));
		nc.setCreado_por(rs.getInt("creado_por"));
		nc.setCreado(rs.getDate("creado"));
		nc.setDatos_timbrado_id(rs.getInt("DATOS_TIMBRADO_id"));
		nc.setUuid(rs.getString("UUID"));
		nc.setConceptos_facturacion_contable_id(rs.getInt("CONCEPTOS_FACTURACION_CONTABLE_id"));
		nc.setDescripcion_conceptos_facturacion_contable(rs.getString("descripcion_conceptos_facturacion_contable"));
		nc.setNotas_credito_id_sust(rs.getInt("NOTAS_CREDITO_id_sust"));
		nc.setImporte_total(rs.getBigDecimal("importe_total"));
		nc.setEstado(rs.getString("estado"));
		
		String json=rs.getString("facturas");
		
		ObjectMapper mapper = new ObjectMapper();
		List<DocumentoAplicarNotasCredito.Facturas> fact=null;
		try {
			fact = mapper.readValue(json, new TypeReference<List<DocumentoAplicarNotasCredito.Facturas>>(){});
		} catch (IOException e) {}
		nc.setFacturas(fact);
		return nc;
	}

}
