package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.PagosDetalle;

public class PagosDetalleRM implements RowMapper<PagosDetalle>{

	@Override
	public PagosDetalle mapRow(ResultSet rs, int i) throws SQLException {

		PagosDetalle pd = new PagosDetalle();
		pd.setId(rs.getInt("id"));
		pd.setImporte(rs.getBigDecimal("importe"));
		pd.setTipo_cambio(rs.getFloat("tipo_cambio"));
		pd.setActivo(rs.getInt("activo"));
		pd.setCreado_por(rs.getInt("creado_por"));
		pd.setCreado(rs.getDate("creado"));
		pd.setModificado_por(rs.getInt("modificado_por"));
		pd.setModificado(rs.getDate("modificado"));
		pd.setFactura_final_id(rs.getInt("factura_final_id"));
		pd.setFactura_varios_id(rs.getInt("factura_varios_id"));
		pd.setFacturas_anticipo_id(rs.getInt("facturas_anticipo_id"));
		pd.setPagos_id(rs.getInt("pagos_id"));
		return pd;
	}
	
	

}
