package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.DepositoRecibido;

public class DepositoRecibidoRM implements RowMapper<DepositoRecibido>{

	@Override
	public DepositoRecibido mapRow(ResultSet rs, int i) throws SQLException {
		DepositoRecibido d = new DepositoRecibido();
		d.setId(rs.getInt("id"));
		d.setComentarios(rs.getString("comentarios"));
		d.setImporte_deposito(rs.getBigDecimal("importe_deposito"));
		d.setFecha_deposito(rs.getDate("fecha_deposito"));
		d.setCuenta_emisor(rs.getString("cuenta_emisor"));
		d.setNumero_operacion(rs.getInt("numero_operacion"));
		d.setActivo(rs.getInt("activo"));
		d.setCreado_por(rs.getInt("creado_por"));
		d.setCreado(rs.getDate("creado"));
		d.setModificado_por(rs.getInt("modificado_por"));
		d.setModificado(rs.getDate("modificado"));
		d.setTipos_cadena_pago(rs.getInt("tipos_cadena_pago"));
		d.setCertificado_pago(rs.getString("certificado_pago"));
		d.setCadena_pago(rs.getString("cadena_pago"));
		d.setSello_pago(rs.getString("sello_pago"));
		d.setFormas_pago_id(rs.getInt("formas_pago_id"));
		d.setCuentas_bancarias_id(rs.getInt("cuentas_bancarias_id"));
		d.setBancos_id_emisor(rs.getInt("bancos_id_emisor"));
		d.setPAGOS_id(rs.getInt("PAGOS_id"));
		return d;
	}

}
