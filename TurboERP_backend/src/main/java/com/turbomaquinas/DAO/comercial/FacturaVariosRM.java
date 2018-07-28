package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.FacturaVarios;

public class FacturaVariosRM implements RowMapper<FacturaVarios> {

	@Override
	public FacturaVarios mapRow(ResultSet rs, int i) throws SQLException {
		
		FacturaVarios fv = new  FacturaVarios();
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
		fv.setFecha_baja(rs.getDate("fecha_baja"));
		fv.setMes_baja(rs.getInt("mes_baja"));
		fv.setAnio_baja(rs.getInt("anio_baja"));
		fv.setObservaciones(rs.getString("observaciones"));
		fv.setPredial(rs.getString("predial"));
		fv.setActivo(rs.getInt("activo"));
		fv.setCreado_por(rs.getInt("creado_por"));
		fv.setCreado(rs.getDate("creado"));
		fv.setModificado_por(rs.getInt("modificado_por"));
		fv.setModificado(rs.getDate("modificado"));
		fv.setFactura_varios_id_sust(rs.getInt("factura_varios_id_sust"));
		fv.setDatos_timbrado_id(rs.getInt("datos_timbrado_id"));
		fv.setFormas_pago_id(rs.getInt("formas_pago_id"));
		fv.setMetodos_pago_id(rs.getInt("metodos_pago_id"));
		fv.setUso_cfdi_id(rs.getInt("uso_cfdi_id"));
		fv.setClientes_id(rs.getInt("clientes_id"));
		fv.setEstado(rs.getString("estado"));
		fv.setNota_cargo(rs.getInt("nota_cargo"));
		fv.setParcialidad(rs.getInt("parcialidad"));
		return fv;
	}

}
