package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.PagosDetalleVista;

public class PagosDetalleVistaRM implements RowMapper<PagosDetalleVista> {

	@Override
	public PagosDetalleVista mapRow(ResultSet rs, int i) throws SQLException {
		
		PagosDetalleVista pdv = new PagosDetalleVista();
		pdv.setId(rs.getInt("id"));
		pdv.setImporte(rs.getBigDecimal("importe"));
		pdv.setTipo_cambio(rs.getFloat("tipo_cambio"));
		pdv.setActivo(rs.getInt("activo"));
		pdv.setCreado_por(rs.getInt("creado_por"));
		pdv.setCreado(rs.getDate("creado"));
		pdv.setModificado_por(rs.getInt("modificado_por"));
		pdv.setModificado(rs.getDate("modificado"));
		pdv.setFactura_final_id(rs.getInt("factura_final_id"));
		pdv.setFactura_final_tipo(rs.getString("factura_final_tipo"));
		pdv.setFactura_final_numero(rs.getInt("factura_final_numero"));
		pdv.setFactura_final_fecha(rs.getDate("factura_final_fecha"));
		pdv.setFactura_varios_id(rs.getInt("factura_varios_id"));
		pdv.setFactura_varios_tipo(rs.getString("factura_varios_tipo"));
		pdv.setFactura_varios_numero(rs.getInt("factura_varios_numero"));
		pdv.setFactura_varios_fecha(rs.getDate("factura_varios_fecha"));
		pdv.setFacturas_anticipo_id(rs.getInt("facturas_anticipo_id"));
		pdv.setFacturas_anticipo_tipo(rs.getString("facturas_anticipo_tipo"));
		pdv.setFacturas_anticipo_numero(rs.getInt("facturas_anticipo_numero"));
		pdv.setFecha_anticipo(rs.getDate("fecha_anticipo"));
		pdv.setPagos_id(rs.getInt("pagos_id"));
		pdv.setPagos_folio(rs.getInt("pagos_folio"));
		return pdv;
	}

}
