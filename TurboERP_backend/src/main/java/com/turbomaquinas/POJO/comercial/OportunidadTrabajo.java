package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class OportunidadTrabajo {
	private int id;
	private int numero;
	private String iniciales;
	private int anio;
	private Date fecha_oportunidad;
	private Date fecha_posible;
	private String descripcion;
	private String comentario;
	private String probabilidad;
	private BigDecimal monto;
	private String moneda;
	private int usuario_cierre;
	private Date fecha_cierre;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int clientes_id;
	private int contactos_id;
	
	public OportunidadTrabajo() {
		super();
}

	public OportunidadTrabajo(int id, int numero, String iniciales, int anio, Date fecha_oportunidad,
			Date fecha_posible, String descripcion, String comentario, String probabilidad, BigDecimal monto, String moneda,
			int usuario_cierre, Date fecha_cierre, int activo, int creado_por, Date creado, int modificado_por,
			Date modificado, int clientes_id, int contactos_id) {
		super();
		this.id = id;
		this.numero = numero;
		this.iniciales = iniciales;
		this.anio = anio;
		this.fecha_oportunidad = fecha_oportunidad;
		this.fecha_posible = fecha_posible;
		this.descripcion = descripcion;
		this.comentario = comentario;
		this.probabilidad = probabilidad;
		this.monto = monto;
		this.moneda = moneda;
		this.usuario_cierre = usuario_cierre;
		this.fecha_cierre = fecha_cierre;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.clientes_id = clientes_id;
		this.contactos_id = contactos_id;
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

	public String getIniciales() {
		return iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Date getFecha_oportunidad() {
		return fecha_oportunidad;
	}

	public void setFecha_oportunidad(Date fecha_oportunidad) {
		this.fecha_oportunidad = fecha_oportunidad;
	}

	public Date getFecha_posible() {
		return fecha_posible;
	}

	public void setFecha_posible(Date fecha_posible) {
		this.fecha_posible = fecha_posible;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(String probabilidad) {
		this.probabilidad = probabilidad;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getUsuario_cierre() {
		return usuario_cierre;
	}

	public void setUsuario_cierre(int usuario_cierre) {
		this.usuario_cierre = usuario_cierre;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
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

	public int getContactos_id() {
		return contactos_id;
	}

	public void setContactos_id(int contactos_id) {
		this.contactos_id = contactos_id;
	}
}
