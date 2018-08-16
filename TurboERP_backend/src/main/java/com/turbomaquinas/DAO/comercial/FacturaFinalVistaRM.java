package com.turbomaquinas.DAO.comercial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista.ComprobantesRelacionados;

public class FacturaFinalVistaRM implements RowMapper<FacturaFinalVista>{

	@Override
	public FacturaFinalVista mapRow(ResultSet rs, int i) throws SQLException {
		
		FacturaFinalVista ffv = new FacturaFinalVista();
		ffv.setId(rs.getInt("id"));
		ffv.setTipo(rs.getString("tipo"));
		ffv.setNumero(rs.getInt("numero"));
		ffv.setFecha_factura(rs.getDate("fecha_factura"));
		ffv.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
		ffv.setSubtotal(rs.getBigDecimal("subtotal"));
		ffv.setDescuento(rs.getBigDecimal("descuento"));
		ffv.setIva(rs.getBigDecimal("iva"));
		ffv.setIva_retenido(rs.getBigDecimal("iva_retenido"));
		ffv.setTotal(rs.getBigDecimal("total"));
		ffv.setTipo_cambio(rs.getFloat("tipo_cambio"));
		ffv.setMoneda(rs.getString("moneda"));
		ffv.setCondiciones_pago(rs.getString("condiciones_pago"));
		ffv.setSaldo(rs.getBigDecimal("saldo"));
		ffv.setFolio_fiscal(rs.getString("folio_fiscal"));
		ffv.setCve_formap(rs.getString("cve_formap"));
		ffv.setDes_formap(rs.getString("des_formap"));
		ffv.setCve_metodop(rs.getString("cve_metodop"));
		ffv.setDes_metodop(rs.getString("des_metodop"));
		ffv.setCve_uso(rs.getString("cve_uso"));
		ffv.setDes_uso(rs.getString("des_uso"));
		ffv.setNumero_cliente(rs.getInt("numero_cliente"));
		ffv.setNumero_giro(rs.getInt("num_giro"));
		ffv.setNombre(rs.getString("nombre"));
		ffv.setDireccion(rs.getString("direccion"));
		ffv.setColonia(rs.getString("colonia"));
		ffv.setCodigo_postal(rs.getString("codigo_postal"));
		ffv.setCiudad(rs.getString("ciudad"));
		ffv.setEstado(rs.getString("estado"));
		ffv.setPais(rs.getString("pais"));
		ffv.setActivo(rs.getInt("activo"));
		ffv.setClientes_id(rs.getInt("CLIENTES_id"));
		ffv.setEstado_factura(rs.getString("estado_factura"));
		ffv.setDesc_estado_fact(rs.getString("desc_estado_fact"));
		ffv.setCreado_por(rs.getInt("creado_por"));
		ObjectMapper mapper = new ObjectMapper();
		try {
			ffv.setComprobantes_relacionados(mapper.readValue(rs.getString("comprobantes_relacionados"), ComprobantesRelacionados.class));
		} catch (Exception e) {
			ffv.setComprobantes_relacionados(null); 
		}
		ffv.setComentario(rs.getString("comentario"));
		ffv.setAlfresco_id_previa(rs.getString("alfresco_id_previa"));
		ffv.setAlfresco_id_timbrado_pdf(rs.getString("alfresco_id_timbrado_pdf"));
		ffv.setAlfresco_id_timbrado_xml(rs.getString("alfresco_id_timbrado_xml"));
		ffv.setDatos_timbrado_id(rs.getInt("datos_timbrado_id"));
		ffv.setExtranjero(rs.getInt("extranjero"));
		ffv.setAnticipo_relacionado(rs.getInt("anticipo_relacionado"));
		return ffv;
	}

}
