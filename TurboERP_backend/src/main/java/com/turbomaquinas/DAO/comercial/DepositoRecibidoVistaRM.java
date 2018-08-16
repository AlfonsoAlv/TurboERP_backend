package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.DepositoRecibidoVista;

public class DepositoRecibidoVistaRM implements RowMapper<DepositoRecibidoVista>{

	@Override
	public DepositoRecibidoVista mapRow(ResultSet rs, int i) throws SQLException {
		DepositoRecibidoVista d = new DepositoRecibidoVista();
		d.setId(rs.getInt("id"));
		d.setComentarios(rs.getString("comentarios"));
		d.setCertificado_pago(rs.getString("certificado_pago"));
		d.setCadena_pago(rs.getString("cadena_pago"));
		d.setSello_pago(rs.getString("sello_pago"));
		d.setImporte_deposito(rs.getBigDecimal("importe_deposito"));
		d.setFecha_deposito(rs.getDate("fecha_deposito"));
		d.setCuenta_emisor(rs.getString("cuenta_emisor"));
		d.setNumero_operacion(rs.getInt("numero_operacion"));
		d.setActivo(rs.getInt("activo"));
		d.setCreado_por(rs.getInt("creado_por"));
		d.setCreado(rs.getDate("creado"));
		d.setModificado_por(rs.getInt("modificado_por"));
		d.setModificado(rs.getDate("modificado"));
		d.setFormas_pago_id(rs.getInt("formas_pago_id"));
		d.setFormas_pago_descripcion(rs.getString("formas_pago_descripcion"));
		d.setFormas_pago_clave(rs.getString("formas_pago_clave"));
		d.setTipo_cadena_pago_id(rs.getInt("tipo_cadena_pago_id"));
		d.setTipo_cadena_pago_descripcion(rs.getString("tipo_cadena_pago_descripcion"));
		d.setTipo_cadena_pago_clave(rs.getString("tipo_cadena_pago_clave"));
		d.setCuentas_bancarias_id(rs.getInt("cuentas_bancarias_id"));
		d.setCuentas_bancarias_descripcion(rs.getString("cuentas_bancarias_descripcion"));
		d.setCuentas_bancarias_numero(rs.getLong("cuentas_bancarias_numero"));
		d.setBancos_rfc(rs.getString("bancos_rfc"));
		d.setBancos_cuenta(rs.getString("bancos_cuenta"));
		d.setBancos_id_emisor(rs.getInt("bancos_id_emisor"));
		d.setBancos_clave(rs.getString("bancos_clave"));
		d.setBancos_descripcion(rs.getString("bancos_descripcion"));
		d.setBanco_destino(rs.getString("banco_destino"));
		d.setPAGOS_id(rs.getInt("PAGOS_id"));
		return d;
	}

}
