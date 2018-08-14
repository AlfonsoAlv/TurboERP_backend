package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class PrePedido {
	private int id;
	private String numero;
	private Date fecha_prepedido;
	private String comentarios;
	private BigDecimal importe;
	private int revision;
	private int sustituye_id;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private String alfresco_id;
	private int clientes_id;
	
	public PrePedido() {
		super();
	}

	public PrePedido(int id, String numero, Date fecha_prepedido, String comentarios, BigDecimal importe, int revision,
			int sustituye_id, int activo, int creado_por, Date creado, int modificado_por, Date modificado,
			String alfresco_id, int clientes_id) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha_prepedido = fecha_prepedido;
		this.comentarios = comentarios;
		this.importe = importe;
		this.revision = revision;
		this.sustituye_id = sustituye_id;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.alfresco_id = alfresco_id;
		this.clientes_id = clientes_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha_prepedido() {
		return fecha_prepedido;
	}

	public void setFecha_prepedido(Date fecha_prepedido) {
		this.fecha_prepedido = fecha_prepedido;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
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

	public String getAlfresco_id() {
		return alfresco_id;
	}

	public void setAlfresco_id(String alfresco_id) {
		this.alfresco_id = alfresco_id;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}
}
