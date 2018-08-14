package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.turbomaquinas.POJO.comercial.DocumentoAplicarNotasCredito.Facturas;

public class NotaCreditoVista {
	
	private int id;
	private String tipo;
	private int numero;
	private Date fecha;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal tipo_cambio;
	private Date fecha_baja;
	private int mes_baja;
	private int anio_baja;
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int datos_timbrado_id;
	private String uuid;
	private int conceptos_facturacion_contable_id;
	private String descripcion_conceptos_facturacion_contable;
	private int notas_credito_id_sust;
	private List<DocumentoAplicarNotasCredito.Facturas> facturas;
	private BigDecimal importe_total;
	private String estado;

	public NotaCreditoVista() {
		super();
	}
	
	public NotaCreditoVista(int id, String tipo, int numero, Date fecha, BigDecimal subtotal, BigDecimal iva,
			BigDecimal tipo_cambio, Date fecha_baja, int mes_baja, int anio_baja, String descripcion, int activo,
			int creado_por, Date creado, int datos_timbrado_id, String uuid, int conceptos_facturacion_contable_id,
			String descripcion_conceptos_facturacion_contable, int notas_credito_id_sust, List<Facturas> facturas,
			BigDecimal importe_total, String estado) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.tipo_cambio = tipo_cambio;
		this.fecha_baja = fecha_baja;
		this.mes_baja = mes_baja;
		this.anio_baja = anio_baja;
		this.descripcion = descripcion;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.datos_timbrado_id = datos_timbrado_id;
		this.uuid = uuid;
		this.conceptos_facturacion_contable_id = conceptos_facturacion_contable_id;
		this.descripcion_conceptos_facturacion_contable = descripcion_conceptos_facturacion_contable;
		this.notas_credito_id_sust = notas_credito_id_sust;
		this.facturas = facturas;
		this.importe_total = importe_total;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getMes_baja() {
		return mes_baja;
	}

	public void setMes_baja(int mes_baja) {
		this.mes_baja = mes_baja;
	}

	public int getAnio_baja() {
		return anio_baja;
	}

	public void setAnio_baja(int anio_baja) {
		this.anio_baja = anio_baja;
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

	public int getDatos_timbrado_id() {
		return datos_timbrado_id;
	}

	public void setDatos_timbrado_id(int datos_timbrado_id) {
		this.datos_timbrado_id = datos_timbrado_id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getConceptos_facturacion_contable_id() {
		return conceptos_facturacion_contable_id;
	}

	public void setConceptos_facturacion_contable_id(int conceptos_facturacion_contable_id) {
		this.conceptos_facturacion_contable_id = conceptos_facturacion_contable_id;
	}

	public String getDescripcion_conceptos_facturacion_contable() {
		return descripcion_conceptos_facturacion_contable;
	}

	public void setDescripcion_conceptos_facturacion_contable(String descripcion_conceptos_facturacion_contable) {
		this.descripcion_conceptos_facturacion_contable = descripcion_conceptos_facturacion_contable;
	}

	public int getNotas_credito_id_sust() {
		return notas_credito_id_sust;
	}

	public void setNotas_credito_id_sust(int notas_credito_id_sust) {
		this.notas_credito_id_sust = notas_credito_id_sust;
	}

	public List<DocumentoAplicarNotasCredito.Facturas> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<DocumentoAplicarNotasCredito.Facturas> facturas) {
		this.facturas = facturas;
	}

	public BigDecimal getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(BigDecimal importe_total) {
		this.importe_total = importe_total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		try {
	        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	

}
