package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class PagosDetalleVista {
	
	public int id;
	public BigDecimal importe;
	public float tipo_cambio;
	public int activo;
	public int creado_por;
	public Date creado;
	public int modificado_por;
	public Date modificado;
	public int factura_final_id;
	public String factura_final_tipo;
	public int factura_final_numero;
	public Date factura_final_fecha;
	public int factura_varios_id;
	public String factura_varios_tipo;
	public int factura_varios_numero;
	public Date factura_varios_fecha;
	public int facturas_anticipo_id;
	public String facturas_anticipo_tipo;
	public int facturas_anticipo_numero;
	public Date fecha_anticipo;
	public int pagos_id;	
	public int pagos_folio;

	public PagosDetalleVista() {
		super();
	}

	public PagosDetalleVista(int id, BigDecimal importe, float tipo_cambio, int activo, int creado_por, Date creado,
			int modificado_por, Date modificado, int factura_final_id, String factura_final_tipo,
			int factura_final_numero, Date factura_final_fecha, int factura_varios_id, String factura_varios_tipo,
			int factura_varios_numero, Date factura_varios_fecha, int facturas_anticipo_id,
			String facturas_anticipo_tipo, int facturas_anticipo_numero, Date fecha_anticipo, int pagos_id,
			int pagos_folio) {
		this.id = id;
		this.importe = importe;
		this.tipo_cambio = tipo_cambio;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.factura_final_id = factura_final_id;
		this.factura_final_tipo = factura_final_tipo;
		this.factura_final_numero = factura_final_numero;
		this.factura_final_fecha = factura_final_fecha;
		this.factura_varios_id = factura_varios_id;
		this.factura_varios_tipo = factura_varios_tipo;
		this.factura_varios_numero = factura_varios_numero;
		this.factura_varios_fecha = factura_varios_fecha;
		this.facturas_anticipo_id = facturas_anticipo_id;
		this.facturas_anticipo_tipo = facturas_anticipo_tipo;
		this.facturas_anticipo_numero = facturas_anticipo_numero;
		this.fecha_anticipo = fecha_anticipo;
		this.pagos_id = pagos_id;
		this.pagos_folio = pagos_folio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public float getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(float tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(int creado_por) {
		this.creado_por = creado_por;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public int getModificado_por() {
		return modificado_por;
	}

	public void setModificado_por(int modificado_por) {
		this.modificado_por = modificado_por;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public int getFactura_final_id() {
		return factura_final_id;
	}

	public void setFactura_final_id(int factura_final_id) {
		this.factura_final_id = factura_final_id;
	}

	public String getFactura_final_tipo() {
		return factura_final_tipo;
	}

	public void setFactura_final_tipo(String factura_final_tipo) {
		this.factura_final_tipo = factura_final_tipo;
	}

	public int getFactura_final_numero() {
		return factura_final_numero;
	}

	public void setFactura_final_numero(int factura_final_numero) {
		this.factura_final_numero = factura_final_numero;
	}

	public Date getFactura_final_fecha() {
		return factura_final_fecha;
	}

	public void setFactura_final_fecha(Date factura_final_fecha) {
		this.factura_final_fecha = factura_final_fecha;
	}

	public int getFactura_varios_id() {
		return factura_varios_id;
	}

	public void setFactura_varios_id(int factura_varios_id) {
		this.factura_varios_id = factura_varios_id;
	}

	public String getFactura_varios_tipo() {
		return factura_varios_tipo;
	}

	public void setFactura_varios_tipo(String factura_varios_tipo) {
		this.factura_varios_tipo = factura_varios_tipo;
	}

	public int getFactura_varios_numero() {
		return factura_varios_numero;
	}

	public void setFactura_varios_numero(int factura_varios_numero) {
		this.factura_varios_numero = factura_varios_numero;
	}

	public Date getFactura_varios_fecha() {
		return factura_varios_fecha;
	}

	public void setFactura_varios_fecha(Date factura_varios_fecha) {
		this.factura_varios_fecha = factura_varios_fecha;
	}

	public int getFacturas_anticipo_id() {
		return facturas_anticipo_id;
	}

	public void setFacturas_anticipo_id(int facturas_anticipo_id) {
		this.facturas_anticipo_id = facturas_anticipo_id;
	}

	public String getFacturas_anticipo_tipo() {
		return facturas_anticipo_tipo;
	}

	public void setFacturas_anticipo_tipo(String facturas_anticipo_tipo) {
		this.facturas_anticipo_tipo = facturas_anticipo_tipo;
	}

	public int getFacturas_anticipo_numero() {
		return facturas_anticipo_numero;
	}

	public void setFacturas_anticipo_numero(int facturas_anticipo_numero) {
		this.facturas_anticipo_numero = facturas_anticipo_numero;
	}

	public Date getFecha_anticipo() {
		return fecha_anticipo;
	}

	public void setFecha_anticipo(Date fecha_anticipo) {
		this.fecha_anticipo = fecha_anticipo;
	}

	public int getPagos_id() {
		return pagos_id;
	}

	public void setPagos_id(int pagos_id) {
		this.pagos_id = pagos_id;
	}

	public int getPagos_folio() {
		return pagos_folio;
	}

	public void setPagos_folio(int pagos_folio) {
		this.pagos_folio = pagos_folio;
	}

}
