package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;
import java.util.Date;

public class Orden {

	private int id;
	private int numero;
	private int anio;
	private String tipo;
	private String moneda;
	private String descripcion;
	private BigDecimal importe_autorizado;
	private BigDecimal importe_bajas;
	private BigDecimal importe_facturado;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int clientes_id;
	private int marcas_equipos_id;
	private int modelos_equipos_id;
	private String numero_orden;
	private String alfresco_id;
	private int cliente_factura_id;

	public Orden() {
		super();
	}

	

	public Orden(int id, int numero, int anio, String tipo, String moneda, String descripcion, BigDecimal importe_autorizado,
			BigDecimal importe_bajas, BigDecimal importe_facturado, int activo, int creado_por, Date creado, int modificado_por,
			Date modificado, int clientes_id, int marcas_equipos_id, int modelos_equipos_id, String numero_orden,
			String alfresco_id, int cliente_factura_id) {
		super();
		this.id = id;
		this.numero = numero;
		this.anio = anio;
		this.tipo = tipo;
		this.moneda = moneda;
		this.descripcion = descripcion;
		this.importe_autorizado = importe_autorizado;
		this.importe_bajas = importe_bajas;
		this.importe_facturado = importe_facturado;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.clientes_id = clientes_id;
		this.marcas_equipos_id = marcas_equipos_id;
		this.modelos_equipos_id = modelos_equipos_id;
		this.numero_orden = numero_orden;
		this.alfresco_id = alfresco_id;
		this.cliente_factura_id = cliente_factura_id;
	}
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public int getAnio() {
		return anio;
	}



	public void setAnio(int anio) {
		this.anio = anio;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public BigDecimal getImporte_autorizado() {
		return importe_autorizado;
	}



	public void setImporte_autorizado(BigDecimal importe_autorizado) {
		this.importe_autorizado = importe_autorizado;
	}



	public BigDecimal getImporte_bajas() {
		return importe_bajas;
	}



	public void setImporte_bajas(BigDecimal importe_bajas) {
		this.importe_bajas = importe_bajas;
	}



	public BigDecimal getImporte_facturado() {
		return importe_facturado;
	}



	public void setImporte_facturado(BigDecimal importe_facturado) {
		this.importe_facturado = importe_facturado;
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



	public int getClientes_id() {
		return clientes_id;
	}



	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}



	public int getMarcas_equipos_id() {
		return marcas_equipos_id;
	}



	public void setMarcas_equipos_id(int marcas_equipos_id) {
		this.marcas_equipos_id = marcas_equipos_id;
	}



	public int getModelos_equipos_id() {
		return modelos_equipos_id;
	}



	public void setModelos_equipos_id(int modelos_equipos_id) {
		this.modelos_equipos_id = modelos_equipos_id;
	}



	public String getNumero_orden() {
		return numero_orden;
	}



	public void setNumero_orden(String numero_orden) {
		this.numero_orden = numero_orden;
	}



	public String getAlfresco_id() {
		return alfresco_id;
	}



	public void setAlfresco_id(String alfresco_id) {
		this.alfresco_id = alfresco_id;
	}



	public int getCliente_factura_id() {
		return cliente_factura_id;
	}



	public void setCliente_factura_id(int cliente_factura_id) {
		this.cliente_factura_id = cliente_factura_id;
	}



	@Override
	public String toString() {
		return "Orden [id=" + id + ", numero=" + numero + ", anio=" + anio + ", tipo=" + tipo + ", moneda=" + moneda
				+ ", descripcion=" + descripcion + ", importe_autorizado=" + importe_autorizado + ", importe_bajas="
				+ importe_bajas + ", importe_facturado=" + importe_facturado + ", activo=" + activo + ", creado_por="
				+ creado_por + ", creado=" + creado + ", modificado_por=" + modificado_por + ", modificado="
				+ modificado + ", clientes_id=" + clientes_id + ", marcas_equipos_id=" + marcas_equipos_id
				+ ", modelos_equipos_id=" + modelos_equipos_id + ", numero_orden=" + numero_orden + ", alfresco_id="
				+ alfresco_id + ", cliente_factura_id=" + cliente_factura_id + "]";
	}

	}
