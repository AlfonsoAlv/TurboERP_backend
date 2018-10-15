package com.turbomaquinas.POJO.general;

import java.math.BigDecimal;

public class ActividadAutorizadaVista {
	private int id;
	private int numero_referencia;
	private String tipo_actividad;
	private int suministro;
	private int planta;
	private String clase_actividad;
	private BigDecimal importe_autorizado;
	private BigDecimal importe_baja;
	private BigDecimal importe_anticipo;
	private BigDecimal importe_factura;
	private BigDecimal importe_pendiente;
	private BigDecimal descuento;
	private int activo;
	private int solicitud_bajas_actividades_id;
	private int solicitud_bajas_actividades_folio;
	private int detalle_cotizaciones_id;
	private String detalle_descripcion;
	private int detalle_lugar;
	private String detalle_tipo_actividad;
	private int detalle_suministro;
	private int detalle_planta;
	private String detalle_clase_actividad;
	private BigDecimal importe;
	private int pedidos_id;
	private int ot_irregulares_id;
	private int autorizaciones_id;
	private String autorizaciones_folio;
	private String pedidos_numero;
	private String pedidos_comentarios;
	private BigDecimal pedidos_importe;
	private int revision;
	private int sustituye_id;
	private int pre_pedidos_id;
	private String pre_pedidos_numero;
	private String pre_pedidos_comentarios;
	private BigDecimal pre_pedidos_importe;
	private int pre_pedidos_revision;
	private int pre_pedidos_sustituye_id;
	private int encabezados_cotizaciones_id;
	private String encabezados_cotizaciones_descripcion;
	private int cotizaciones_id;
	private int cotizaciones_numero;
	private int cotizaciones_revision;

	public ActividadAutorizadaVista() {
		super();
	}

	public ActividadAutorizadaVista(int id, String tipo_actividad, int suministro, int planta,
			String clase_actividad, BigDecimal importe_autorizado, BigDecimal importe_baja, BigDecimal importe_anticipo,
			BigDecimal importe_factura, BigDecimal importe_pendiente, BigDecimal descuento, int activo,
			int solicitud_bajas_actividades_id, int solicitud_bajas_actividades_folio, int detalle_cotizaciones_id,
			String detalle_descripcion, int detalle_lugar, String detalle_tipo_actividad, int detalle_suministro,
			int detalle_planta, String detalle_clase_actividad, BigDecimal importe, int pedidos_id, int ot_irregulares_id,
			int autorizaciones_id, String autorizaciones_folio, String pedidos_numero, String pedidos_comentarios,
			BigDecimal pedidos_importe, int revision, int sustituye_id, int pre_pedidos_id, String pre_pedidos_numero,
			String pre_pedidos_comentarios, BigDecimal pre_pedidos_importe, int pre_pedidos_revision,
			int pre_pedidos_sustituye_id, int encabezados_cotizaciones_id, String encabezados_cotizaciones_descripcion,
			int cotizaciones_id, int cotizaciones_numero, int cotizaciones_revision) {
		super();
		this.id = id;
		this.tipo_actividad = tipo_actividad;
		this.suministro = suministro;
		this.planta = planta;
		this.clase_actividad = clase_actividad;
		this.importe_autorizado = importe_autorizado;
		this.importe_baja = importe_baja;
		this.importe_anticipo = importe_anticipo;
		this.importe_factura = importe_factura;
		this.importe_pendiente = importe_pendiente;
		this.descuento = descuento;
		this.activo = activo;
		this.solicitud_bajas_actividades_id = solicitud_bajas_actividades_id;
		this.solicitud_bajas_actividades_folio = solicitud_bajas_actividades_folio;
		this.detalle_cotizaciones_id = detalle_cotizaciones_id;
		this.detalle_descripcion = detalle_descripcion;
		this.detalle_lugar = detalle_lugar;
		this.detalle_tipo_actividad = detalle_tipo_actividad;
		this.detalle_suministro = detalle_suministro;
		this.detalle_planta = detalle_planta;
		this.detalle_clase_actividad = detalle_clase_actividad;
		this.importe = importe;
		this.pedidos_id = pedidos_id;
		this.ot_irregulares_id = ot_irregulares_id;
		this.autorizaciones_id = autorizaciones_id;
		this.autorizaciones_folio = autorizaciones_folio;
		this.pedidos_numero = pedidos_numero;
		this.pedidos_comentarios = pedidos_comentarios;
		this.pedidos_importe = pedidos_importe;
		this.revision = revision;
		this.sustituye_id = sustituye_id;
		this.pre_pedidos_id = pre_pedidos_id;
		this.pre_pedidos_numero = pre_pedidos_numero;
		this.pre_pedidos_comentarios = pre_pedidos_comentarios;
		this.pre_pedidos_importe = pre_pedidos_importe;
		this.pre_pedidos_revision = pre_pedidos_revision;
		this.pre_pedidos_sustituye_id = pre_pedidos_sustituye_id;
		this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
		this.encabezados_cotizaciones_descripcion = encabezados_cotizaciones_descripcion;
		this.cotizaciones_id = cotizaciones_id;
		this.cotizaciones_numero = cotizaciones_numero;
		this.cotizaciones_revision = cotizaciones_revision;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_referencia() {
		return numero_referencia;
	}

	public void setNumero_referencia(int numero_referencia) {
		this.numero_referencia = numero_referencia;
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

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getSolicitud_bajas_actividades_id() {
		return solicitud_bajas_actividades_id;
	}

	public void setSolicitud_bajas_actividades_id(int solicitud_bajas_actividades_id) {
		this.solicitud_bajas_actividades_id = solicitud_bajas_actividades_id;
	}

	public int getSolicitud_bajas_actividades_folio() {
		return solicitud_bajas_actividades_folio;
	}

	public void setSolicitud_bajas_actividades_folio(int solicitud_bajas_actividades_folio) {
		this.solicitud_bajas_actividades_folio = solicitud_bajas_actividades_folio;
	}

	public int getDetalle_cotizaciones_id() {
		return detalle_cotizaciones_id;
	}

	public void setDetalle_cotizaciones_id(int detalle_cotizaciones_id) {
		this.detalle_cotizaciones_id = detalle_cotizaciones_id;
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

	public String getDetalle_tipo_actividad() {
		return detalle_tipo_actividad;
	}

	public void setDetalle_tipo_actividad(String detalle_tipo_actividad) {
		this.detalle_tipo_actividad = detalle_tipo_actividad;
	}

	public int getDetalle_suministro() {
		return detalle_suministro;
	}

	public void setDetalle_suministro(int detalle_suministro) {
		this.detalle_suministro = detalle_suministro;
	}

	public int getDetalle_planta() {
		return detalle_planta;
	}

	public void setDetalle_planta(int detalle_planta) {
		this.detalle_planta = detalle_planta;
	}

	public String getDetalle_clase_actividad() {
		return detalle_clase_actividad;
	}

	public void setDetalle_clase_actividad(String detalle_clase_actividad) {
		this.detalle_clase_actividad = detalle_clase_actividad;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public int getPedidos_id() {
		return pedidos_id;
	}

	public void setPedidos_id(int pedidos_id) {
		this.pedidos_id = pedidos_id;
	}

	public int getOt_irregulares_id() {
		return ot_irregulares_id;
	}

	public void setOt_irregulares_id(int ot_irregulares_id) {
		this.ot_irregulares_id = ot_irregulares_id;
	}

	public int getAutorizaciones_id() {
		return autorizaciones_id;
	}

	public void setAutorizaciones_id(int autorizaciones_id) {
		this.autorizaciones_id = autorizaciones_id;
	}

	public String getAutorizaciones_folio() {
		return autorizaciones_folio;
	}

	public void setAutorizaciones_folio(String autorizaciones_folio) {
		this.autorizaciones_folio = autorizaciones_folio;
	}

	public String getPedidos_numero() {
		return pedidos_numero;
	}

	public void setPedidos_numero(String pedidos_numero) {
		this.pedidos_numero = pedidos_numero;
	}

	public String getPedidos_comentarios() {
		return pedidos_comentarios;
	}

	public void setPedidos_comentarios(String pedidos_comentarios) {
		this.pedidos_comentarios = pedidos_comentarios;
	}

	public BigDecimal getPedidos_importe() {
		return pedidos_importe;
	}

	public void setPedidos_importe(BigDecimal pedidos_importe) {
		this.pedidos_importe = pedidos_importe;
	}

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public int getSustituye_id() {
		return sustituye_id;
	}

	public void setSustituye_id(int sustituye_id) {
		this.sustituye_id = sustituye_id;
	}

	public int getPre_pedidos_id() {
		return pre_pedidos_id;
	}

	public void setPre_pedidos_id(int pre_pedidos_id) {
		this.pre_pedidos_id = pre_pedidos_id;
	}

	public String getPre_pedidos_numero() {
		return pre_pedidos_numero;
	}

	public void setPre_pedidos_numero(String pre_pedidos_numero) {
		this.pre_pedidos_numero = pre_pedidos_numero;
	}

	public String getPre_pedidos_comentarios() {
		return pre_pedidos_comentarios;
	}

	public void setPre_pedidos_comentarios(String pre_pedidos_comentarios) {
		this.pre_pedidos_comentarios = pre_pedidos_comentarios;
	}

	public BigDecimal getPre_pedidos_importe() {
		return pre_pedidos_importe;
	}

	public void setPre_pedidos_importe(BigDecimal pre_pedidos_importe) {
		this.pre_pedidos_importe = pre_pedidos_importe;
	}

	public int getPre_pedidos_revision() {
		return pre_pedidos_revision;
	}

	public void setPre_pedidos_revision(int pre_pedidos_revision) {
		this.pre_pedidos_revision = pre_pedidos_revision;
	}

	public int getPre_pedidos_sustituye_id() {
		return pre_pedidos_sustituye_id;
	}

	public void setPre_pedidos_sustituye_id(int pre_pedidos_sustituye_id) {
		this.pre_pedidos_sustituye_id = pre_pedidos_sustituye_id;
	}

	public int getEncabezados_cotizaciones_id() {
		return encabezados_cotizaciones_id;
	}

	public void setEncabezados_cotizaciones_id(int encabezados_cotizaciones_id) {
		this.encabezados_cotizaciones_id = encabezados_cotizaciones_id;
	}

	public String getEncabezados_cotizaciones_descripcion() {
		return encabezados_cotizaciones_descripcion;
	}

	public void setEncabezados_cotizaciones_descripcion(String encabezados_cotizaciones_descripcion) {
		this.encabezados_cotizaciones_descripcion = encabezados_cotizaciones_descripcion;
	}

	public int getCotizaciones_id() {
		return cotizaciones_id;
	}

	public void setCotizaciones_id(int cotizaciones_id) {
		this.cotizaciones_id = cotizaciones_id;
	}

	public int getCotizaciones_numero() {
		return cotizaciones_numero;
	}

	public void setCotizaciones_numero(int cotizaciones_numero) {
		this.cotizaciones_numero = cotizaciones_numero;
	}

	public int getCotizaciones_revision() {
		return cotizaciones_revision;
	}

	public void setCotizaciones_revision(int cotizaciones_revision) {
		this.cotizaciones_revision = cotizaciones_revision;
	}
	
}
