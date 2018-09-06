package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;

public class DetalleCotizacionVista {
	
	private int id;
	private String descripcion;
	private String tipo_actividad;
	private int lugar;
	private int suministro;
	private int planta;
	private String clase_actividad;
	private BigDecimal importe;
	private int activo;
	private int encabezados_cotizaciones_id;
	private int detalle_diagnostico_id;
	private String descripcionEncabezado;
	private int lugarEncabezado;
	private int cotizaciones_id;
	private int numerocotizacion;
	private int aniocotizacion;
	private int cant_subindices;
	private int autorizado;	
	private int facturado;
	
	public DetalleCotizacionVista() {
		super();
	}

	public DetalleCotizacionVista(int id, String descripcion, String tipo_actividad, int lugar, int suministro,
			int planta, String clase_actividad, BigDecimal importe, int activo, int encabezados_cotizaciones_id,
			String descripcionEncabezado, int lugarEncabezado, int cotizaciones_id, int numerocotizacion,
			int aniocotizacion, int cant_subindices) {
		this.id = id;
		this.descripcion = descripcion;
		this.tipo_actividad = tipo_actividad;
		this.lugar = lugar;
		this.suministro = suministro;
		this.planta = planta;
		this.clase_actividad = clase_actividad;
		this.importe = importe;
		this.activo = activo;
		this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
		this.descripcionEncabezado = descripcionEncabezado;
		this.lugarEncabezado = lugarEncabezado;
		this.cotizaciones_id = cotizaciones_id;
		this.numerocotizacion = numerocotizacion;
		this.aniocotizacion = aniocotizacion;
		this.cant_subindices = cant_subindices;
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

	public String getTipo_actividad() {
		return tipo_actividad;
	}

	public void setTipo_actividad(String tipo_actividad) {
		this.tipo_actividad = tipo_actividad;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
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

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getEncabezados_cotizaciones_id() {
		return encabezados_cotizaciones_id;
	}

	public void setEncabezados_cotizaciones_id(int encabezados_cotizaciones_id) {
		this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
	}

	public String getDescripcionEncabezado() {
		return descripcionEncabezado;
	}

	public void setDescripcionEncabezado(String descripcionEncabezado) {
		this.descripcionEncabezado = descripcionEncabezado;
	}

	public int getLugarEncabezado() {
		return lugarEncabezado;
	}

	public void setLugarEncabezado(int lugarEncabezado) {
		this.lugarEncabezado = lugarEncabezado;
	}

	public int getCotizaciones_id() {
		return cotizaciones_id;
	}

	public void setCotizaciones_id(int cotizaciones_id) {
		this.cotizaciones_id = cotizaciones_id;
	}

	public int getNumerocotizacion() {
		return numerocotizacion;
	}

	public void setNumerocotizacion(int numerocotizacion) {
		this.numerocotizacion = numerocotizacion;
	}

	public int getAniocotizacion() {
		return aniocotizacion;
	}

	public void setAniocotizacion(int aniocotizacion) {
		this.aniocotizacion = aniocotizacion;
	}

	public int getCant_subindices() {
		return cant_subindices;
	}

	public void setCant_subindices(int cant_subindices) {
		this.cant_subindices = cant_subindices;
	}

	public int getDetalle_diagnostico_id() {
		return detalle_diagnostico_id;
	}

	public void setDetalle_diagnostico_id(int detalle_diagnostico_id) {
		this.detalle_diagnostico_id = detalle_diagnostico_id;
	}

	public int getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(int autorizado) {
		this.autorizado = autorizado;
	}

	public int getFacturado() {
		return facturado;
	}

	public void setFacturado(int facturado) {
		this.facturado = facturado;
	}
	
}
