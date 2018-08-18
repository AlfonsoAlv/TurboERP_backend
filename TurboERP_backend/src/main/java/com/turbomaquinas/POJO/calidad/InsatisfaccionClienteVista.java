package com.turbomaquinas.POJO.calidad;

import java.util.Date;

public class InsatisfaccionClienteVista {

	private int insatisfaccion_id;
	private int folio;
	private Date fecha_insatisfaccion;
	private Date fecha_operacion;
	private String equipo;
	private String descripcion_insatisfaccion;
	private String tipo_insatisfaccion;
	private String descripcion_otro;
	private String grado_insatisfaccion;
	private String estado;
	private int procede_garantia;
	private int días_antiguedad;
	private int ordenes_id;
	private String numero_orden;
	private String descripcion_orden;
	private String cliente_nombre_comercial;
	private String cliente_nombre_fiscal;
	private int personal_id;
	private String nombre_personal;
	private String ubicacion;
	private int clientes_id;
	private int numero_cliente;
	private int numero_giro;
	
	
	
	public InsatisfaccionClienteVista() {

	}



	public InsatisfaccionClienteVista(int insatisfaccion_id, int folio, Date fecha_insatisfaccion, Date fecha_operacion,
			String equipo, String descripcion_insatisfaccion, String tipo_insatisfaccion, String descripcion_otro,
			String grado_insatisfaccion, String estado, int procede_garantia, int días_antiguedad, int ordenes_id,
			String numero_orden, String descripcion_orden, String cliente_nombre_comercial,
			String cliente_nombre_fiscal, int personal_id, String nombre_personal, String ubicacion, int clientes_id,
			int numero_cliente, int numero_giro) {
		super();
		this.insatisfaccion_id = insatisfaccion_id;
		this.folio = folio;
		this.fecha_insatisfaccion = fecha_insatisfaccion;
		this.fecha_operacion = fecha_operacion;
		this.equipo = equipo;
		this.descripcion_insatisfaccion = descripcion_insatisfaccion;
		this.tipo_insatisfaccion = tipo_insatisfaccion;
		this.descripcion_otro = descripcion_otro;
		this.grado_insatisfaccion = grado_insatisfaccion;
		this.estado = estado;
		this.procede_garantia = procede_garantia;
		this.días_antiguedad = días_antiguedad;
		this.ordenes_id = ordenes_id;
		this.numero_orden = numero_orden;
		this.descripcion_orden = descripcion_orden;
		this.cliente_nombre_comercial = cliente_nombre_comercial;
		this.cliente_nombre_fiscal = cliente_nombre_fiscal;
		this.personal_id = personal_id;
		this.nombre_personal = nombre_personal;
		this.ubicacion = ubicacion;
		this.clientes_id = clientes_id;
		this.numero_cliente = numero_cliente;
		this.numero_giro = numero_giro;
	}



	public int getInsatisfaccion_id() {
		return insatisfaccion_id;
	}

	public void setInsatisfaccion_id(int insatisfaccion_id) {
		this.insatisfaccion_id = insatisfaccion_id;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getProcede_garantia() {
		return procede_garantia;
	}

	public void setProcede_garantia(int procede_garantia) {
		this.procede_garantia = procede_garantia;
	}

	public int getDías_antiguedad() {
		return días_antiguedad;
	}

	public void setDías_antiguedad(int días_antiguedad) {
		this.días_antiguedad = días_antiguedad;
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

	public String getCliente_nombre_comercial() {
		return cliente_nombre_comercial;
	}

	public void setCliente_nombre_comercial(String cliente_nombre_comercial) {
		this.cliente_nombre_comercial = cliente_nombre_comercial;
	}

	public String getCliente_nombre_fiscal() {
		return cliente_nombre_fiscal;
	}

	public void setCliente_nombre_fiscal(String cliente_nombre_fiscal) {
		this.cliente_nombre_fiscal = cliente_nombre_fiscal;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public String getNombre_personal() {
		return nombre_personal;
	}

	public void setNombre_personal(String nombre_personal) {
		this.nombre_personal = nombre_personal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

	public int getNumero_cliente() {
		return numero_cliente;
	}

	public void setNumero_cliente(int numero_cliente) {
		this.numero_cliente = numero_cliente;
	}

	public int getNumero_giro() {
		return numero_giro;
	}

	public void setNumero_giro(int numero_giro) {
		this.numero_giro = numero_giro;
	}



	@Override
	public String toString() {
		return "InsatisfaccionClienteVista [insatisfaccion_id=" + insatisfaccion_id + ", folio=" + folio
				+ ", fecha_insatisfaccion=" + fecha_insatisfaccion + ", fecha_operacion=" + fecha_operacion
				+ ", equipo=" + equipo + ", descripcion_insatisfaccion=" + descripcion_insatisfaccion
				+ ", tipo_insatisfaccion=" + tipo_insatisfaccion + ", descripcion_otro=" + descripcion_otro
				+ ", grado_insatisfaccion=" + grado_insatisfaccion + ", estado=" + estado + ", procede_garantia="
				+ procede_garantia + ", días_antiguedad=" + días_antiguedad + ", ordenes_id=" + ordenes_id
				+ ", numero_orden=" + numero_orden + ", descripcion_orden=" + descripcion_orden
				+ ", cliente_nombre_comercial=" + cliente_nombre_comercial + ", cliente_nombre_fiscal="
				+ cliente_nombre_fiscal + ", personal_id=" + personal_id + ", nombre_personal=" + nombre_personal
				+ ", ubicacion=" + ubicacion + ", clientes_id=" + clientes_id + ", numero_cliente=" + numero_cliente
				+ ", numero_giro=" + numero_giro + "]";
	}

	
}
