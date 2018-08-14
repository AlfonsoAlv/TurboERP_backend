package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.FacturaAnticipo;

public class FacturaAnticipoRM implements RowMapper<FacturaAnticipo> {

	@Override
	public FacturaAnticipo mapRow(ResultSet rs, int i) throws SQLException {
		
		FacturaAnticipo fa = new FacturaAnticipo();
		fa.setId(rs.getInt("id"));
		fa.setTipo(rs.getString("tipo"));
		fa.setNumero(rs.getInt("numero"));
		fa.setFecha_anticipo(rs.getDate("fecha_anticipo"));
		fa.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
		fa.setDescripcion(rs.getString("descripcion"));
		fa.setSubtotal(rs.getBigDecimal("subtotal"));
		fa.setIva(rs.getBigDecimal("iva"));
		fa.setIva_retenido(rs.getBigDecimal("iva_retenido"));
		fa.setImporte_pagado(rs.getBigDecimal("importe_pagado"));
		fa.setSaldo(rs.getBigDecimal("saldo"));
		fa.setMoneda(rs.getString("moneda"));
		fa.setTipo_cambio(rs.getFloat("tipo_cambio"));
		fa.setCondiciones_pago(rs.getString("condiciones_pago"));
		fa.setFecha_baja(rs.getDate("fecha_baja"));
		fa.setMes_baja(rs.getInt("mes_baja"));
		fa.setAnio_baja(rs.getInt("anio_baja"));
		fa.setActivo(rs.getInt("activo"));
		fa.setCreado_por(rs.getInt("creado_por"));
		fa.setCreado(rs.getDate("creado"));
		fa.setModificado_por(rs.getInt("modificado_por"));
		fa.setModificado(rs.getDate("modificado"));
		fa.setFacturas_anticipo_id_sust(rs.getInt("facturas_anticipo_id_sust"));
		fa.setDatos_timbrado_id(rs.getInt("datos_timbrado_id"));
		fa.setProductos_sat_id(rs.getInt("productos_sat_id"));
		fa.setFormas_pago_id(rs.getInt("formas_pago_id"));
		fa.setMetodos_pago_id(rs.getInt("metodos_pago_id"));
		fa.setUso_cfdi_id(rs.getInt("uso_cfdi_id"));
		fa.setClientes_id(rs.getInt("clientes_id"));
		fa.setTotal(rs.getFloat("total"));
		return fa;
	}

}
