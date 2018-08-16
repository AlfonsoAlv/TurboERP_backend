package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;
import java.util.Date;

public class SubindiceActividadAutorizadaVista {
	private int id;
	private String descripcion;
	private int lugar;
	private BigDecimal importe;
	private String tipo_actividad_subindice;
	private int activo;
	private int actividades_autorizadas_id;
	private String actividades_descripcion;
	private int actividades_lugar;
	private String tipo_actividad;
	private int suministro;
	private int planta;
	private String clase_actividad;
	private Date fecha_autorizado;
	private BigDecimal importe_autorizado;
	private BigDecimal importe_baja;
	private BigDecimal importe_anticipo;
	private BigDecimal importe_factura;
	private BigDecimal importe_pendiente;
	private int actividad_activo;
	
	public SubindiceActividadAutorizadaVista() {
		super();
	}

	public SubindiceActividadAutorizadaVista(int id, String descripcion, int lugar, BigDecimal importe,
			String tipo_actividad_subindice, int activo, int actividades_autorizadas_id, String actividades_descripcion,
			int actividades_lugar, String tipo_actividad, int suministro, int planta, String clase_actividad,
			Date fecha_autorizado, BigDecimal importe_autorizado, BigDecimal importe_baja, BigDecimal importe_anticipo,
			BigDecimal importe_factura, BigDecimal importe_pendiente, int actividad_activo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.importe = importe;
		this.tipo_actividad_subindice = tipo_actividad_subindice;
		this.activo = activo;
		this.actividades_autorizadas_id = actividades_autorizadas_id;
		this.actividades_descripcion = actividades_descripcion;
		this.actividades_lugar = actividades_lugar;
		this.tipo_actividad = tipo_actividad;
		this.suministro = suministro;
		this.planta = planta;
		this.clase_actividad = clase_actividad;
		this.fecha_autorizado = fecha_autorizado;
		this.importe_autorizado = importe_autorizado;
		this.importe_baja = importe_baja;
		this.importe_anticipo = importe_anticipo;
		this.importe_factura = importe_factura;
		this.importe_pendiente = importe_pendiente;
		this.actividad_activo = actividad_activo;
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

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getTipo_actividad_subindice() {
		return tipo_actividad_subindice;
	}

	public void setTipo_actividad_subindice(String tipo_actividad_subindice) {
		this.tipo_actividad_subindice = tipo_actividad_subindice;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getActividades_autorizadas_id() {
		return actividades_autorizadas_id;
	}

	public void setActividades_autorizadas_id(int actividades_autorizadas_id) {
		this.actividades_autorizadas_id = actividades_autorizadas_id;
	}

	public String getActividades_descripcion() {
		return actividades_descripcion;
	}

	public void setActividades_descripcion(String actividades_descripcion) {
		this.actividades_descripcion = actividades_descripcion;
	}

	public int getActividades_lugar() {
		return actividades_lugar;
	}

	public void setActividades_lugar(int actividades_lugar) {
		this.actividades_lugar = actividades_lugar;
	}

	public String getTipo_actividad() {
		return tipo_actividad;
	}

	public void setTipo_actividad(String tipo_actividad) {
		this.tipo_actividad = tipo_actividad;
	}

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getClase_actividad() {
		return clase_actividad;
	}

	public void setClase_actividad(String clase_actividad) {
		this.clase_actividad = clase_actividad;
	}

	public Date getFecha_autorizado() {
		return fecha_autorizado;
	}

	public void setFecha_autorizado(Date fecha_autorizado) {
		this.fecha_autorizado = fecha_autorizado;
	}

	public BigDecimal getImporte_autorizado() {
		return importe_autorizado;
	}

	public void setImporte_autorizado(BigDecimal importe_autorizado) {
		this.importe_autorizado = importe_autorizado;
	}

	public BigDecimal getImporte_baja() {
		return importe_baja;
	}

	public void setImporte_baja(BigDecimal importe_baja) {
		this.importe_baja = importe_baja;
	}

	public BigDecimal getImporte_anticipo() {
		return importe_anticipo;
	}

	public void setImporte_anticipo(BigDecimal importe_anticipo) {
		this.importe_anticipo = importe_anticipo;
	}

	public BigDecimal getImporte_factura() {
		return importe_factura;
	}

	public void setImporte_factura(BigDecimal importe_factura) {
		this.importe_factura = importe_factura;
	}

	public BigDecimal getImporte_pendiente() {
		return importe_pendiente;
	}

	public void setImporte_pendiente(BigDecimal importe_pendiente) {
		this.importe_pendiente = importe_pendiente;
	}

	public int getActividad_activo() {
		return actividad_activo;
	}

	public void setActividad_activo(int actividad_activo) {
		this.actividad_activo = actividad_activo;
	}
}
