package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.comercial.DetalleCotizacionVista;

public class DetalleCotizacionVistaRM implements RowMapper<DetalleCotizacionVista> {

	@Override
	public DetalleCotizacionVista mapRow(ResultSet rs, int i) throws SQLException {

		DetalleCotizacionVista dcv = new DetalleCotizacionVista();
		dcv.setId(rs.getInt("id"));
		dcv.setDescripcion(rs.getString("descripcion"));
		dcv.setTipo_actividad(rs.getString("tipo_actividad"));
		dcv.setLugar(rs.getInt("lugar"));
		dcv.setSuministro(rs.getInt("suministro"));
		dcv.setPlanta(rs.getInt("planta"));
		dcv.setClase_actividad(rs.getString("clase_actividad"));
		dcv.setImporte(rs.getBigDecimal("importe"));
		dcv.setActivo(rs.getInt("activo"));
		dcv.setEncabezados_cotizaciones_id(rs.getInt("encabezados_cotizaciones_id"));
		dcv.setDetalle_diagnostico_id(rs.getInt("detalle_diagnostico_id"));
		dcv.setDescripcionEncabezado(rs.getString("descripcionencabezado"));
		dcv.setLugarEncabezado(rs.getInt("lugarencabezado"));
		dcv.setCotizaciones_id(rs.getInt("cotizaciones_id"));
		dcv.setNumerocotizacion(rs.getInt("numerocotizacion"));
		dcv.setAniocotizacion(rs.getInt("aniocotizacion"));
		dcv.setCant_subindices(rs.getInt("cant_subindices"));
		dcv.setAutorizado(rs.getInt("autorizado"));
		dcv.setFacturado(rs.getInt("facturado"));
		return dcv;
	}
	

}
