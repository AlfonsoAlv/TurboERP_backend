package com.turbomaquinas.POJO.comercial;

public class EquipoSolicitudFletesVista {

	private int id;
	private String descripcion;
	private Float peso;
	private int unidades;
	private int equipo_por_recibir_id;
	private int equipo_recibido_id;
	private int solicitud_flete_id;
	private int medidas_equipos_id;
	private int clientes_id;

	public EquipoSolicitudFletesVista() {
		super();
	}

	public EquipoSolicitudFletesVista(int id, String descripcion, Float peso, int unidades, int equipo_por_recibir_id,
			int equipo_recibido_id, int solicitud_flete_id, int medidas_equipos_id, int clientes_id) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.peso = peso;
		this.unidades = unidades;
		this.equipo_por_recibir_id = equipo_por_recibir_id;
		this.equipo_recibido_id = equipo_recibido_id;
		this.solicitud_flete_id = solicitud_flete_id;
		this.medidas_equipos_id = medidas_equipos_id;
		this.clientes_id = clientes_id;
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

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

}
