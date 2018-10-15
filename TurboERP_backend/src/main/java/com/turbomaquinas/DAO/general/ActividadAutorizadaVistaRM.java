package com.turbomaquinas.DAO.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;

public class ActividadAutorizadaVistaRM implements RowMapper<ActividadAutorizadaVista>{

	@Override
	public ActividadAutorizadaVista mapRow(ResultSet rs, int i) throws SQLException {
		ActividadAutorizadaVista ac = new ActividadAutorizadaVista();
		ac.setId(rs.getInt("id"));
		ac.setTipo_actividad(rs.getString("tipo_actividad"));
		ac.setSuministro(rs.getInt("suministro"));
		ac.setPlanta(rs.getInt("planta"));
		ac.setClase_actividad(rs.getString("clase_actividad"));
		ac.setImporte_autorizado(rs.getBigDecimal("importe_autorizado"));
		ac.setImporte_baja(rs.getBigDecimal("importe_baja"));
		ac.setImporte_anticipo(rs.getBigDecimal("importe_anticipo"));
		ac.setImporte_factura(rs.getBigDecimal("importe_factura"));
		ac.setImporte_pendiente(rs.getBigDecimal("importe_pendiente"));
		ac.setDescuento(rs.getBigDecimal("descuento"));
		ac.setActivo(rs.getInt("activo"));
		ac.setSolicitud_bajas_actividades_id(rs.getInt("solicitud_bajas_actividades_id"));
		ac.setSolicitud_bajas_actividades_folio(rs.getInt("solicitud_bajas_actividades_folio"));
		ac.setDetalle_cotizaciones_id(rs.getInt("detalle_cotizaciones_id"));
		ac.setDetalle_descripcion(rs.getString("detalle_descripcion"));
		ac.setDetalle_lugar(rs.getInt("detalle_lugar"));
		ac.setDetalle_tipo_actividad(rs.getString("detalle_tipo_actividad"));
		ac.setDetalle_suministro(rs.getInt("detalle_suministro"));
		ac.setDetalle_planta(rs.getInt("detalle_planta"));
		ac.setDetalle_clase_actividad(rs.getString("detalle_clase_actividad"));
		ac.setImporte(rs.getBigDecimal("importe"));
		ac.setPedidos_id(rs.getInt("pedidos_id"));
		ac.setPedidos_numero(rs.getString("pedidos_numero"));
		ac.setPedidos_comentarios(rs.getString("pedidos_comentarios"));
		ac.setPedidos_importe(rs.getBigDecimal("pedidos_importe"));
		ac.setRevision(rs.getInt("revision"));
		ac.setSustituye_id(rs.getInt("sustituye_id"));
		ac.setPre_pedidos_id(rs.getInt("pre_pedidos_id"));
		ac.setOt_irregulares_id(rs.getInt("ot_irregulares_id"));
		ac.setAutorizaciones_id(rs.getInt("autorizaciones_id"));
		ac.setAutorizaciones_folio(rs.getString("autorizaciones_folio"));
		ac.setPre_pedidos_numero(rs.getString("pre_pedidos_numero"));
		ac.setPre_pedidos_comentarios(rs.getString("pre_pedidos_comentarios"));
		ac.setPre_pedidos_importe(rs.getBigDecimal("pre_pedidos_importe"));
		ac.setPre_pedidos_revision(rs.getInt("pre_pedidos_revision"));
		ac.setPre_pedidos_sustituye_id(rs.getInt("pre_pedidos_sustituye_id"));
		ac.setEncabezados_cotizaciones_id(rs.getInt("encabezados_cotizaciones_id"));
		ac.setEncabezados_cotizaciones_descripcion(rs.getString("encabezados_cotizaciones_descripcion"));
		ac.setCotizaciones_id(rs.getInt("cotizaciones_id"));
		ac.setCotizaciones_numero(rs.getInt("cotizaciones_numero"));
		ac.setCotizaciones_revision(rs.getInt("cotizaciones_revision"));
		return ac;
	}

}
