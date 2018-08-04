package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;

public class NotasCreditoPorOrden {

	private int id;
	private BigDecimal importe;
	private int factura_id;

	public NotasCreditoPorOrden() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotasCreditoPorOrden(int id, BigDecimal importe, int factura_id) {
		super();
		this.id = id;
		this.importe = importe;
		this.factura_id = factura_id;
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

	public int getFactura_id() {
		return factura_id;
	}

	public void setFactura_id(int factura_id) {
		this.factura_id = factura_id;
	}

	@Override
	public String toString() {
		return "NotasCreditoPorOrden [id=" + id + ", importe=" + importe + ", factura_id=" + factura_id + "]";
	}

}