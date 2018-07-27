package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class PagosDetalle {
	
	public int id;
	public BigDecimal importe;
	public float tipo_cambio;
	public int activo;
	public int creado_por;
	public Date creado;
	public int modificado_por;
	public Date modificado;
	public int factura_final_id;
	public int factura_varios_id;
	public int facturas_anticipo_id;
	public int pagos_id;
	
	public PagosDetalle() {
		super();
	}

	public PagosDetalle(int id, BigDecimal importe, float tipo_cambio, int activo, int creado_por, Date creado,
			int modificado_por, Date modificado, int factura_final_id, int factura_varios_id, int facturas_anticipo_id,
			int pagos_id) {
		super();
		this.id = id;
		this.importe = importe;
		this.tipo_cambio = tipo_cambio;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.factura_final_id = factura_final_id;
		this.factura_varios_id = factura_varios_id;
		this.facturas_anticipo_id = facturas_anticipo_id;
		this.pagos_id = pagos_id;
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

	public int getFactura_varios_id() {
		return factura_varios_id;
	}

	public void setFactura_varios_id(int factura_varios_id) {
		this.factura_varios_id = factura_varios_id;
	}

	public int getFacturas_anticipo_id() {
		return facturas_anticipo_id;
	}

	public void setFacturas_anticipo_id(int facturas_anticipo_id) {
		this.facturas_anticipo_id = facturas_anticipo_id;
	}

	public int getPagos_id() {
		return pagos_id;
	}

	public void setPagos_id(int pagos_id) {
		this.pagos_id = pagos_id;
	}

}
