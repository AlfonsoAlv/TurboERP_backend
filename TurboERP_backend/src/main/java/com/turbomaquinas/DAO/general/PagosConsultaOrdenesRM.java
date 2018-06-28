package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.general.DesglosePagos;
import com.turbomaquinas.POJO.general.PagosConsultaOrdenes;

public class PagosConsultaOrdenesRM implements RowMapper<PagosConsultaOrdenes>{

	@Override
	public PagosConsultaOrdenes mapRow(ResultSet rs, int i) throws SQLException {
		PagosConsultaOrdenes pco = new PagosConsultaOrdenes();
		pco.setFacturafinal_id(rs.getInt("facturafinal_id"));
		pco.setTipo_factura(rs.getString("tipo_factura"));
		pco.setFactura(rs.getInt("factura"));
		pco.setTipo_cambio_factura(rs.getBigDecimal("tipo_cambio_factura"));
		pco.setFecha_factura(rs.getDate("fecha_factura"));
		pco.setPagodetalle_id(rs.getInt("pagodetalle_id"));
		pco.setPago_id(rs.getInt("pago_id"));
		pco.setFecha_pago(rs.getDate("fecha_pago"));
		pco.setImporte(rs.getBigDecimal("importe"));
		pco.setPago(rs.getInt("pago"));
		pco.setTipo_cambio_fecha_pago(rs.getBigDecimal("tipo_cambio_fecha_pago"));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			pco.setAfectacion(mapper.readValue(rs.getString("afectacion"), DesglosePagos.class));
		} catch (Exception e) {
			pco.setAfectacion(null); 
		}
		
		return pco;
	}

}
