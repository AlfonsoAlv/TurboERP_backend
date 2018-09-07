package com.turbomaquinas.POJO.calidad;


import java.util.Date;

public class GarantiaVista {
	
	private int id;
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int personal_id;
	private int ordenes_id;
	private String numero_orden;
	private String descripcion_orden;
	private int clientes_id;
	private String nombre_cliente;
	private int numero_giro;
	private int numero_cliente;
	private String elaboro;
	
	public GarantiaVista() {
		super();
	}

	public GarantiaVista(int id, String descripcion, int activo, int creado_por, Date creado, int modificado_por,
			Date modificado, int personal_id, int ordenes_id, String numero_orden, String descripcion_orden,
			int clientes_id, String nombre_cliente, int numero_giro, int numero_cliente, String elaboro) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.personal_id = personal_id;
		this.ordenes_id = ordenes_id;
		this.numero_orden = numero_orden;
		this.descripcion_orden = descripcion_orden;
		this.clientes_id = clientes_id;
		this.nombre_cliente = nombre_cliente;
		this.numero_giro = numero_giro;
		this.numero_cliente = numero_cliente;
		this.elaboro = elaboro;
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

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public int getOrdenes_id() {
		return ordenes_id;
	}

	public void setOrdenes_id(int ordenes_id) {
		this.ordenes_id = ordenes_id;
	}

	public String getNumero_orden() {
		return numero_orden;
	}

	public void setNumero_orden(String numero_orden) {
		this.numero_orden = numero_orden;
	}

	public String getDescripcion_orden() {
		return descripcion_orden;
	}

	public void setDescripcion_orden(String descripcion_orden) {
		this.descripcion_orden = descripcion_orden;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public int getNumero_giro() {
		return numero_giro;
	}

	public void setNumero_giro(int numero_giro) {
		this.numero_giro = numero_giro;
	}

	public int getNumero_cliente() {
		return numero_cliente;
	}

	public void setNumero_cliente(int numero_cliente) {
		this.numero_cliente = numero_cliente;
	}

	public String getElaboro() {
		return elaboro;
	}

	public void setElaboro(String elaboro) {
		this.elaboro = elaboro;
	}

	
	
}
