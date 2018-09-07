package com.turbomaquinas.DAO.calidad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista.DepartamentosId;

public class DetalleGarantiaVistaRM implements RowMapper<DetalleGarantiaVista> {

	@Override
	public DetalleGarantiaVista mapRow(ResultSet rs, int i) throws SQLException {

		DetalleGarantiaVista dcv = new DetalleGarantiaVista();
		dcv.setId(rs.getInt("id"));
		dcv.setDescripcion(rs.getString("descripcion"));
		dcv.setLugar(rs.getInt("lugar"));
		dcv.setPlanta(rs.getInt("planta"));
		dcv.setActivo(rs.getInt("activo"));
		dcv.setEncabezados_garantias_id(rs.getInt("encabezados_garantias_id"));
		dcv.setDetalle_diagnostico_id(rs.getInt("DETALLE_DIAGNOSTICO_id"));
		dcv.setDescripcionEncabezado(rs.getString("descripcionencabezado"));
		dcv.setLugarEncabezado(rs.getInt("lugarencabezado"));
		dcv.setGarantias_id(rs.getInt("garantias_id"));
		dcv.setCant_subindices(rs.getInt("cant_subindices"));		
		dcv.setProcede(rs.getString("procede"));
		dcv.setMotivo_procede(rs.getString("motivo_procede"));
		dcv.setCreado_por(rs.getInt("creado_por"));
		dcv.setCreado(rs.getDate("creado"));
		dcv.setModificado_por(rs.getInt("modificado_por"));
		dcv.setModificado(rs.getDate("modificado"));
		dcv.setReferencia(rs.getInt("referencia"));
		dcv.setFecha_terminacion(rs.getDate("fecha_terminacion"));
		dcv.setPersonal_terminado_id(rs.getInt("PERSONAL_terminado_id"));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonDep=rs.getString("departamentos");
		DepartamentosId deptos=null;
		try {
			deptos = mapper.readValue(jsonDep, new TypeReference<DepartamentosId>(){});
		} catch (Exception e) {//System.out.println(e.getMessage());}
		}
		
		dcv.setDepartamentos(deptos);
		
		
		dcv.setEncabezados_garantia_id(rs.getInt("ENCABEZADOS_GARANTIA_id"));
		dcv.setInsatisfacciones_id(rs.getInt("INSATISFACCIONES_id"));
		dcv.setFolio_insatisfaccion(rs.getInt("folio_insatisfaccion"));
		dcv.setDescripcion_insatisfaccion(rs.getString("descripcion_insatisfaccion"));
		return dcv;
	}
	

}
