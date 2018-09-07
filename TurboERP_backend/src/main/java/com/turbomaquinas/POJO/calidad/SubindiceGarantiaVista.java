package com.turbomaquinas.POJO.calidad;

import java.util.Date;

public class SubindiceGarantiaVista {
	private int id;
	private String descripcion;
	private int lugar;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int detalle_garantias_id;
	private String detalle_descripcion;
	private int detalle_lugar;
	private int encabezados_garantias_id;
	private String descripcion_encabezado;
	private int lugar_encabezado;
	private int garantias_id;
	
	public SubindiceGarantiaVista() {
		super();
	}

	public SubindiceGarantiaVista(int id, String descripcion, int lugar, int activo, int creado_por, Date creado,
			int modificado_por, Date modificado, int detalle_garantias_id, String detalle_descripcion,
			int detalle_lugar, int encabezados_garantias_id, String descripcion_encabezado, int lugar_encabezado,
			int garantias_id) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.detalle_garantias_id = detalle_garantias_id;
		this.detalle_descripcion = detalle_descripcion;
		this.detalle_lugar = detalle_lugar;
		this.encabezados_garantias_id = encabezados_garantias_id;
		this.descripcion_encabezado = descripcion_encabezado;
		this.lugar_encabezado = lugar_encabezado;
		this.garantias_id = garantias_id;
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

	public int getDetalle_garantias_id() {
		return detalle_garantias_id;
	}

	public void setDetalle_garantias_id(int detalle_garantias_id) {
		this.detalle_garantias_id = detalle_garantias_id;
	}

	public String getDetalle_descripcion() {
		return detalle_descripcion;
	}

	public void setDetalle_descripcion(String detalle_descripcion) {
		this.detalle_descripcion = detalle_descripcion;
	}

	public int getDetalle_lugar() {
		return detalle_lugar;
	}

	public void setDetalle_lugar(int detalle_lugar) {
		this.detalle_lugar = detalle_lugar;
	}

	public int getEncabezados_garantias_id() {
		return encabezados_garantias_id;
	}

	public void setEncabezados_garantias_id(int encabezados_garantias_id) {
		this.encabezados_garantias_id = encabezados_garantias_id;
	}

	public String getDescripcion_encabezado() {
		return descripcion_encabezado;
	}

	public void setDescripcion_encabezado(String descripcion_encabezado) {
		this.descripcion_encabezado = descripcion_encabezado;
	}

	public int getLugar_encabezado() {
		return lugar_encabezado;
	}

	public void setLugar_encabezado(int lugar_encabezado) {
		this.lugar_encabezado = lugar_encabezado;
	}

	public int getGarantias_id() {
		return garantias_id;
	}

	public void setGarantias_id(int garantias_id) {
		this.garantias_id = garantias_id;
	}

	
}
