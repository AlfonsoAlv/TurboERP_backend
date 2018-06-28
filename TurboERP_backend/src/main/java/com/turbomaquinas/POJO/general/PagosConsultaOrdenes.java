package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;
import java.util.Date;

public class PagosConsultaOrdenes {
	
	private int facturafinal_id;
	private String tipo_factura;
	private int factura;
	private BigDecimal tipo_cambio_factura;
	private Date fecha_factura;
	private int pagodetalle_id;
	private int pago_id;
	private Date fecha_pago;
	private BigDecimal importe;
	private int pago;
	private BigDecimal tipo_cambio_fecha_pago;
	private DesglosePagos afectacion;
	
	public PagosConsultaOrdenes() {
		super();
	}

	public PagosConsultaOrdenes(int facturafinal_id, String tipo_factura, int factura, BigDecimal tipo_cambio_factura,
			Date fecha_factura, int pagodetalle_id, int pago_id, Date fecha_pago, BigDecimal importe, int pago,
			BigDecimal tipo_cambio_fecha_pago, DesglosePagos afectacion) {
		super();
		this.facturafinal_id = facturafinal_id;
		this.tipo_factura = tipo_factura;
		this.factura = factura;
		this.tipo_cambio_factura = tipo_cambio_factura;
		this.fecha_factura = fecha_factura;
		this.pagodetalle_id = pagodetalle_id;
		this.pago_id = pago_id;
		this.fecha_pago = fecha_pago;
		this.importe = importe;
		this.pago = pago;
		this.tipo_cambio_fecha_pago = tipo_cambio_fecha_pago;
		this.afectacion = afectacion;
	}

	public int getFacturafinal_id() {
		return facturafinal_id;
	}

	public void setFacturafinal_id(int facturafinal_id) {
		this.facturafinal_id = facturafinal_id;
	}

	public String getTipo_factura() {
		return tipo_factura;
	}

	public void setTipo_factura(String tipo_factura) {
		this.tipo_factura = tipo_factura;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int factura) {
		this.factura = factura;
	}

	public BigDecimal getTipo_cambio_factura() {
		return tipo_cambio_factura;
	}

	public void setTipo_cambio_factura(BigDecimal tipo_cambio_factura) {
		this.tipo_cambio_factura = tipo_cambio_factura;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public int getPagodetalle_id() {
		return pagodetalle_id;
	}

	public void setPagodetalle_id(int pagodetalle_id) {
		this.pagodetalle_id = pagodetalle_id;
	}

	public int getPago_id() {
		return pago_id;
	}

	public void setPago_id(int pago_id) {
		this.pago_id = pago_id;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public BigDecimal getTipo_cambio_fecha_pago() {
		return tipo_cambio_fecha_pago;
	}

	public void setTipo_cambio_fecha_pago(BigDecimal tipo_cambio_fecha_pago) {
		this.tipo_cambio_fecha_pago = tipo_cambio_fecha_pago;
	}

	public DesglosePagos getAfectacion() {
		return afectacion;
	}

	public void setAfectacion(DesglosePagos afectacion) {
		this.afectacion = afectacion;
	}
	
	

}
