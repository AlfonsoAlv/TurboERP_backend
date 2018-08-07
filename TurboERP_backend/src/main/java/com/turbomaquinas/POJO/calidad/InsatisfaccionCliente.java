package com.turbomaquinas.POJO.calidad;

import java.util.Date;

public class InsatisfaccionCliente {

	private int id;
	private int folio;
	private Date fecha_insatisfaccion;
	private Date fecha_operacion;
	private String equipo;
	private String descripcion_insatisfaccion;
	private String tipo_insatisfaccion; // char (1)
	private String descripcion_otro;
	private String grado_insatisfaccion; // char(1)
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private String ubicacion;
	private int ordenes_id;
	private int personal_id;

	public InsatisfaccionCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsatisfaccionCliente(int id, int folio, Date fecha_insatisfaccion, Date fecha_operacion, String equipo,
			String descripcion_insatisfaccion, String tipo_insatisfaccion, String descripcion_otro,
			String grado_insatisfaccion, int activo, int creado_por, Date creado, int modificado_por, Date modificado,
			int ordenes_id, int personal_id) {
		super();
		this.id = id;
		this.folio = folio;
		this.fecha_insatisfaccion = fecha_insatisfaccion;
		this.fecha_operacion = fecha_operacion;
		this.equipo = equipo;
		this.descripcion_insatisfaccion = descripcion_insatisfaccion;
		this.tipo_insatisfaccion = tipo_insatisfaccion;
		this.descripcion_otro = descripcion_otro;
		this.grado_insatisfaccion = grado_insatisfaccion;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.ordenes_id = ordenes_id;
		this.personal_id = personal_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public Date getFecha_insatisfaccion() {
		return fecha_insatisfaccion;
	}

	public void setFecha_insatisfaccion(Date fecha_insatisfaccion) {
		this.fecha_insatisfaccion = fecha_insatisfaccion;
	}

	public Date getFecha_operacion() {
		return fecha_operacion;
	}

	public void setFecha_operacion(Date fecha_operacion) {
		this.fecha_operacion = fecha_operacion;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getDescripcion_insatisfaccion() {
		return descripcion_insatisfaccion;
	}

	public void setDescripcion_insatisfaccion(String descripcion_insatisfaccion) {
		this.descripcion_insatisfaccion = descripcion_insatisfaccion;
	}

	public String getTipo_insatisfaccion() {
		return tipo_insatisfaccion;
	}

	public void setTipo_insatisfaccion(String tipo_insatisfaccion) {
		this.tipo_insatisfaccion = tipo_insatisfaccion;
	}

	public String getDescripcion_otro() {
		return descripcion_otro;
	}

	public void setDescripcion_otro(String descripcion_otro) {
		this.descripcion_otro = descripcion_otro;
	}

	public String getGrado_insatisfaccion() {
		return grado_insatisfaccion;
	}

	public void setGrado_insatisfaccion(String grado_insatisfaccion) {
		this.grado_insatisfaccion = grado_insatisfaccion;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getOrdenes_id() {
		return ordenes_id;
	}

	public void setOrdenes_id(int ordenes_id) {
		this.ordenes_id = ordenes_id;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	@Override
	public String toString() {
		return "InsatisfaccionCliente [id=" + id + ", folio=" + folio + ", fecha_insatisfaccion=" + fecha_insatisfaccion
				+ ", fecha_operacion=" + fecha_operacion + ", equipo=" + equipo + ", descripcion_insatisfaccion="
				+ descripcion_insatisfaccion + ", tipo_insatisfaccion=" + tipo_insatisfaccion + ", descripcion_otro="
				+ descripcion_otro + ", grado_insatisfaccion=" + grado_insatisfaccion + ", activo=" + activo
				+ ", creado_por=" + creado_por + ", creado=" + creado + ", modificado_por=" + modificado_por
				+ ", modificado=" + modificado + ", ubicacion=" + ubicacion + ", ordenes_id=" + ordenes_id
				+ ", personal_id=" + personal_id + "]";
	}

}
