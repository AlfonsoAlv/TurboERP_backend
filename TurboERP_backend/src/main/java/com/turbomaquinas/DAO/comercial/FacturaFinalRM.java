package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinal.ComprobanteRelacionado;
import com.turbomaquinas.POJO.comercial.FacturaFinal.Orden;

public class FacturaFinalRM implements RowMapper<FacturaFinal> {
	
	@Override
	public FacturaFinal mapRow(ResultSet rs, int i) throws SQLException {
		FacturaFinal ff = new FacturaFinal();
		ff.setId(rs.getInt("id"));
		ff.setTipo(rs.getString("tipo"));
		ff.setNumero(rs.getInt("numero"));
		ff.setFecha_factura(rs.getDate("fecha_factura"));
		ff.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
		ff.setSubtotal(rs.getBigDecimal("subtotal"));
		ff.setDescuento(rs.getBigDecimal("descuento"));
		ff.setIva(rs.getBigDecimal("iva"));
		ff.setImporte_anticipo(rs.getBigDecimal("importe_anticipo"));
		ff.setIva_retenido(rs.getBigDecimal("iva_retenido"));
		ff.setTotal(rs.getBigDecimal("total"));
		ff.setImporte_pagado(rs.getBigDecimal("importe_pagado"));
		ff.setSaldo(rs.getBigDecimal("saldo"));
		ff.setComentario(rs.getString("comentario"));
		ff.setMoneda(rs.getString("moneda"));
		ff.setTipo_cambio(rs.getFloat("tipo_cambio"));
		ff.setCondiciones_pago(rs.getString("condiciones_pago"));
		ff.setFecha_baja(rs.getDate("fecha_baja"));
		ff.setMes_baja(rs.getInt("mes_baja"));
		ff.setAnio_baja(rs.getInt("anio_baja"));
		ff.setActivo(rs.getInt("activo"));
		ff.setCreado_por(rs.getInt("creado_por"));
		ff.setCreado(rs.getDate("creado"));
		ff.setModificado_por(rs.getInt("modificado_por"));
		ff.setModificado(rs.getDate("modificado"));
		ff.setDatos_timbrado_id(rs.getInt("datos_timbrado_id"));
		ff.setFormas_pago_id(rs.getInt("formas_pago_id"));
		ff.setMetodos_pago_id(rs.getInt("metodos_timbrado_id"));
		ff.setUso_cfdi_id(rs.getInt("uso_cfdi_id"));
		ff.setClientes_id(rs.getInt("CLIENTES_id"));
		ff.setEstado(rs.getString("estado"));
		ff.setDescuento_neto(rs.getInt("descuento_neto"));
		ff.setExtranjero(rs.getInt("extranjero"));
		ff.setAnticipo_relacionado(rs.getInt("anticipo_relacionado"));
		ObjectMapper mapper = new ObjectMapper();
		try {
			ff.setComprobantes_relacionados(mapper.readValue(rs.getString("comprobantes_relacionados"), ComprobanteRelacionado.class));
		} catch (Exception e) {
			ff.setComprobantes_relacionados(null); 
		}
		
		try {
			ff.setOrdenes(mapper.readValue(rs.getString("ordenes"), Orden.class));
		} catch (Exception e) {
			ff.setOrdenes(null); 
		}
		
		return ff;
	}
	

}
