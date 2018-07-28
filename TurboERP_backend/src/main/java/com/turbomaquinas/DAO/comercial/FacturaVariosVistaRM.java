package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.FacturaVariosVista;

public class FacturaVariosVistaRM implements RowMapper<FacturaVariosVista> {

	@Override
	public FacturaVariosVista mapRow(ResultSet rs, int i) throws SQLException {
		
		FacturaVariosVista fv = new  FacturaVariosVista();
		fv.setId(rs.getInt("id"));
		fv.setTipo(rs.getString("tipo"));
		fv.setNumero(rs.getInt("numero"));
		fv.setFecha_factura(rs.getDate("fecha_factura"));
		fv.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
		fv.setSubtotal(rs.getBigDecimal("subtotal"));
		fv.setIva(rs.getBigDecimal("iva"));
		fv.setTotal(rs.getBigDecimal("total"));
		fv.setImporte_pagado(rs.getBigDecimal("importe_pagado"));
		fv.setSaldo(rs.getBigDecimal("saldo"));
		fv.setMoneda(rs.getString("moneda"));
		fv.setTipo_cambio(rs.getFloat("tipo_cambio"));
		fv.setCondiciones_pago(rs.getString("condiciones_pago"));
		fv.setObservaciones(rs.getString("observaciones"));
		fv.setPredial(rs.getString("predial"));
		fv.setEstado_factura(rs.getString("estado_factura"));
		fv.setDesc_estado_fact(rs.getString("desc_estado_fact"));
		fv.setFactura_varios_id_sust(rs.getInt("factura_varios_id_sust"));
		fv.setNumero_sustitucion(rs.getInt("numero_sustitucion"));
		fv.setTipo_sustitucion(rs.getString("tipo_sustitucion"));
		fv.setDes_conceptos_facturacion_contable(rs.getString("des_conceptos_facturacion_contable"));
		fv.setClientes_id(rs.getInt("clientes_id"));
		fv.setFolio_fiscal(rs.getString("folio_fiscal"));
		fv.setCve_formap(rs.getString("cve_formap"));
		fv.setDes_formap(rs.getString("des_formap"));
		fv.setCve_metodop(rs.getString("cve_metodop"));
		fv.setDes_metodop(rs.getString("des_metodop"));
		fv.setCve_uso(rs.getString("cve_uso"));
		fv.setDes_uso(rs.getString("des_uso"));
		fv.setNumero_cliente(rs.getInt("numero_cliente"));
		fv.setNumero_giro(rs.getInt("num_giro"));
		fv.setNombre(rs.getString("nombre"));
		fv.setDireccion(rs.getString("direccion"));
		fv.setColonia(rs.getString("colonia"));
		fv.setCodigo_postal(rs.getString("codigo_postal"));
		fv.setCiudad(rs.getString("ciudad"));
		fv.setEstado(rs.getString("estado"));
		fv.setEstado_id(rs.getInt("estado_id"));
		fv.setPais(rs.getString("pais"));
		fv.setPais_id(rs.getInt("pais_id"));
		fv.setActivo(rs.getInt("activo"));
		fv.setDatos_timbrado_id(rs.getInt("DATOS_TIMBRADO_id"));
		fv.setNota_cargo(rs.getInt("nota_cargo"));
				
		return fv;
	}

}
