package com.turbomaquinas.POJO.comercial;

import java.util.Date;

public class EquipoSolicitudFletes {

	private int id;
	private String descripcion;
	private Float peso;
	private int unidades;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int equipo_por_recibir_id;
	private int equipo_recibido_id;
	private int solicitud_flete_id;
	private int medidas_equipos_id;

	public EquipoSolicitudFletes() {
		super();
	}

	public EquipoSolicitudFletes(int id, String descripcion, Float peso, int unidades, int activo, int creado_por,
			Date creado, int modificado_por, Date modificado, int equipo_por_recibir_id, int equipo_recibido_id,
			int solicitud_flete_id, int medidas_equipos_id) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.peso = peso;
		this.unidades = unidades;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.equipo_por_recibir_id = equipo_por_recibir_id;
		this.equipo_recibido_id = equipo_recibido_id;
		this.solicitud_flete_id = solicitud_flete_id;
		this.medidas_equipos_id = medidas_equipos_id;
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

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
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

	public int getEquipo_por_recibir_id() {
		return equipo_por_recibir_id;
	}

	public void setEquipo_por_recibir_id(int equipo_por_recibir_id) {
		this.equipo_por_recibir_id = equipo_por_recibir_id;
	}

	public int getEquipo_recibido_id() {
		return equipo_recibido_id;
	}

	public void setEquipo_recibido_id(int equipo_recibido_id) {
		this.equipo_recibido_id = equipo_recibido_id;
	}

	public int getSolicitud_flete_id() {
		return solicitud_flete_id;
	}

	public void setSolicitud_flete_id(int solicitud_flete_id) {
		this.solicitud_flete_id = solicitud_flete_id;
	}

	public int getMedidas_equipos_id() {
		return medidas_equipos_id;
	}

	public void setMedidas_equipos_id(int medidas_equipos_id) {
		this.medidas_equipos_id = medidas_equipos_id;
	}
	
}
