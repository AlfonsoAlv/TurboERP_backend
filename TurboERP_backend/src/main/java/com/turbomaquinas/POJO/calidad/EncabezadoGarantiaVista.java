package com.turbomaquinas.POJO.calidad;

import java.util.Date;

public class EncabezadoGarantiaVista {
	private int id;
	private String descripcion;
	private int lugar;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int garantias_id;
	private int cant_detalles;
	
	public EncabezadoGarantiaVista() {
		super();
	}

	public EncabezadoGarantiaVista(int id, String descripcion, int lugar, int activo, int creado_por, Date creado,
			int modificado_por, Date modificado, int garantias_id, int cant_detalles) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.garantias_id = garantias_id;
		this.cant_detalles = cant_detalles;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
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

	public int getGarantias_id() {
		return garantias_id;
	}

	public void setGarantias_id(int garantias_id) {
		this.garantias_id = garantias_id;
	}

	public int getCant_detalles() {
		return cant_detalles;
	}

	public void setCant_detalles(int cant_detalles) {
		this.cant_detalles = cant_detalles;
	}

}
