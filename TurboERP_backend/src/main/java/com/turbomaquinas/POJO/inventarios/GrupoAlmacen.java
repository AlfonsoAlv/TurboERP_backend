package com.turbomaquinas.POJO.inventarios;

import java.util.Date;

public class GrupoAlmacen {
	private int id;
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int tipos_almacen_id;
	private String clave_num;
	private String clave_grupo;
	
	public GrupoAlmacen() {
		super();
	}

	public GrupoAlmacen(int id, String descripcion, int activo, int creado_por, Date creado, int modificado_por,
			Date modificado, int tipos_almacen_id, String clave_num, String clave_grupo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.tipos_almacen_id = tipos_almacen_id;
		this.clave_num = clave_num;
		this.clave_grupo = clave_grupo;
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

	public int getTipos_almacen_id() {
		return tipos_almacen_id;
	}

	public void setTipos_almacen_id(int tipos_almacen_id) {
		this.tipos_almacen_id = tipos_almacen_id;
	}

	public String getClave_num() {
		return clave_num;
	}

	public void setClave_num(String clave_num) {
		this.clave_num = clave_num;
	}

	public String getClave_grupo() {
		return clave_grupo;
	}

	public void setClave_grupo(String clave_grupo) {
		this.clave_grupo = clave_grupo;
	}
}
