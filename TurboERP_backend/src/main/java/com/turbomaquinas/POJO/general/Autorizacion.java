package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;
import java.util.Date;

public class Autorizacion {
	private int id;
	private Date fecha;
	private int anio;
	private int numero;
	private String folio;
	private BigDecimal importe_pedido;
	private BigDecimal importe_irregular;
	private BigDecimal importe_total;
	private int ordenes_id;
	
	public Autorizacion() {
		super();
	}

	public Autorizacion(int id, Date fecha, BigDecimal importe_pedido, BigDecimal importe_irregular, BigDecimal importe_total,
			int ordenes_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.importe_pedido = importe_pedido;
		this.importe_irregular = importe_irregular;
		this.importe_total = importe_total;
		this.ordenes_id = ordenes_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte_pedido() {
		return importe_pedido;
	}

	public void setImporte_pedido(BigDecimal importe_pedido) {
		this.importe_pedido = importe_pedido;
	}

	public BigDecimal getImporte_irregular() {
		return importe_irregular;
	}

	public void setImporte_irregular(BigDecimal importe_irregular) {
		this.importe_irregular = importe_irregular;
	}

	public BigDecimal getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(BigDecimal importe_total) {
		this.importe_total = importe_total;
	}

	public int getOrdenes_id() {
		return ordenes_id;
	}

	public void setOrdenes_id(int ordenes_id) {
		this.ordenes_id = ordenes_id;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
	
}
