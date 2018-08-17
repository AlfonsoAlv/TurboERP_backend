package com.turbomaquinas.POJO.calidad;

import java.util.Date;

public class SeguimientoInsatisfaccionVista {
	
	private int id;
	private Date fecha;
	private String descripcion;
	private String tipo;
	private String trabajo_realizar;
	private int activo;	
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int insatisfacciones_clientes_id;
	private String alfresco_ids;
	private int cantidad_Documentos;
	private int folio_insatisfaccion;
	private int ORDENES_id;
	
	public SeguimientoInsatisfaccionVista(int id, Date fecha, String descripcion, String tipo, String trabajo_realizar,
			int activo, int creado_por, Date creado, int modificado_por, Date modificado,
			int insatisfacciones_clientes_id, String alfresco_ids, int cantidad_Documentos, int folio_insatisfaccion,
			int oRDENES_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.trabajo_realizar = trabajo_realizar;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.insatisfacciones_clientes_id = insatisfacciones_clientes_id;
		this.alfresco_ids = alfresco_ids;
		this.cantidad_Documentos = cantidad_Documentos;
		this.folio_insatisfaccion = folio_insatisfaccion;
		ORDENES_id = oRDENES_id;
	}

	public SeguimientoInsatisfaccionVista() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTrabajo_realizar() {
		return trabajo_realizar;
	}

	public void setTrabajo_realizar(String trabajo_realizar) {
		this.trabajo_realizar = trabajo_realizar;
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

	public int getInsatisfacciones_clientes_id() {
		return insatisfacciones_clientes_id;
	}

	public void setInsatisfacciones_clientes_id(int insatisfacciones_clientes_id) {
		this.insatisfacciones_clientes_id = insatisfacciones_clientes_id;
	}

	public String getAlfresco_ids() {
		return alfresco_ids;
	}

	public void setAlfresco_ids(String alfresco_ids) {
		this.alfresco_ids = alfresco_ids;
	}

	public int getCantidad_Documentos() {
		return cantidad_Documentos;
	}

	public void setCantidad_Documentos(int cantidad_Documentos) {
		this.cantidad_Documentos = cantidad_Documentos;
	}

	public int getFolio_insatisfaccion() {
		return folio_insatisfaccion;
	}

	public void setFolio_insatisfaccion(int folio_insatisfaccion) {
		this.folio_insatisfaccion = folio_insatisfaccion;
	}

	public int getORDENES_id() {
		return ORDENES_id;
	}

	public void setORDENES_id(int oRDENES_id) {
		ORDENES_id = oRDENES_id;
	}

	@Override
	public String toString() {
		return "SeguimientoInsatisfaccionVista [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", tipo=" + tipo + ", trabajo_realizar=" + trabajo_realizar + ", activo=" + activo + ", creado_por="
				+ creado_por + ", creado=" + creado + ", modificado_por=" + modificado_por + ", modificado="
				+ modificado + ", insatisfacciones_clientes_id=" + insatisfacciones_clientes_id + ", alfresco_ids="
				+ alfresco_ids + ", cantidad_Documentos=" + cantidad_Documentos + ", folio_insatisfaccion="
				+ folio_insatisfaccion + ", ORDENES_id=" + ORDENES_id + "]";
	}
	
	
	
}
