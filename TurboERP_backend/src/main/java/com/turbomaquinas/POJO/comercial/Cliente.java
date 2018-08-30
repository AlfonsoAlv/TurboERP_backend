package com.turbomaquinas.POJO.comercial;

import java.util.Date;

public class Cliente {
	
	private int id;
	private int numero;
	private String nombre_fiscal;
    private String direccion_fiscal;
    private String colonia_fiscal;
    private String codigo_postal_fiscal;
    private String rfc;
    private int dias_credito;
    private String nombre_comercial;
    private String direccion_planta;
    private String colonia_planta;
    private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int ciudades_id;
	private int giros_id;
	private int personal_id;
	private int ciudad_comercial_id;
	private int metodos_pago_id;
	private int formas_pago_id;
	private int uso_cfdi_id;
	private String comisionista;

	public Cliente() {
		super();
	}

	public Cliente(int id, int numero, String nombre_fiscal, String direccion_fiscal, String colonia_fiscal,
			String codigo_postal_fiscal, String rfc, int dias_credito, String nombre_comercial, String direccion_planta,
			String colonia_planta, int activo, int creado_por, Date creado, int modificado_por, Date modificado,
			int ciudades_id, int giros_id, int personal_id, int ciudad_comercial_id, int metodos_pago_id,
			int formas_pago_id, int uso_cfdi_id, String comisionista) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre_fiscal = nombre_fiscal;
		this.direccion_fiscal = direccion_fiscal;
		this.colonia_fiscal = colonia_fiscal;
		this.codigo_postal_fiscal = codigo_postal_fiscal;
		this.rfc = rfc;
		this.dias_credito = dias_credito;
		this.nombre_comercial = nombre_comercial;
		this.direccion_planta = direccion_planta;
		this.colonia_planta = colonia_planta;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.ciudades_id = ciudades_id;
		this.giros_id = giros_id;
		this.personal_id = personal_id;
		this.ciudad_comercial_id = ciudad_comercial_id;
		this.metodos_pago_id = metodos_pago_id;
		this.formas_pago_id = formas_pago_id;
		this.uso_cfdi_id = uso_cfdi_id;
		this.comisionista = comisionista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre_fiscal() {
		return nombre_fiscal;
	}

	public void setNombre_fiscal(String nombre_fiscal) {
		this.nombre_fiscal = nombre_fiscal;
	}

	public String getDireccion_fiscal() {
		return direccion_fiscal;
	}

	public void setDireccion_fiscal(String direccion_fiscal) {
		this.direccion_fiscal = direccion_fiscal;
	}

	public String getColonia_fiscal() {
		return colonia_fiscal;
	}

	public void setColonia_fiscal(String colonia_fiscal) {
		this.colonia_fiscal = colonia_fiscal;
	}

	public String getCodigo_postal_fiscal() {
		return codigo_postal_fiscal;
	}

	public void setCodigo_postal_fiscal(String codigo_postal_fiscal) {
		this.codigo_postal_fiscal = codigo_postal_fiscal;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public int getDias_credito() {
		return dias_credito;
	}

	public void setDias_credito(int dias_credito) {
		this.dias_credito = dias_credito;
	}

	public String getNombre_comercial() {
		return nombre_comercial;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getDireccion_planta() {
		return direccion_planta;
	}

	public void setDireccion_planta(String direccion_planta) {
		this.direccion_planta = direccion_planta;
	}

	public String getColonia_planta() {
		return colonia_planta;
	}

	public void setColonia_planta(String colonia_planta) {
		this.colonia_planta = colonia_planta;
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

	public int getCiudades_id() {
		return ciudades_id;
	}

	public void setCiudades_id(int ciudades_id) {
		this.ciudades_id = ciudades_id;
	}

	public int getGiros_id() {
		return giros_id;
	}

	public void setGiros_id(int giros_id) {
		this.giros_id = giros_id;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public int getCiudad_comercial_id() {
		return ciudad_comercial_id;
	}

	public void setCiudad_comercial_id(int ciudad_comercial_id) {
		this.ciudad_comercial_id = ciudad_comercial_id;
	}

	public int getMetodos_pago_id() {
		return metodos_pago_id;
	}

	public void setMetodos_pago_id(int metodos_pago_id) {
		this.metodos_pago_id = metodos_pago_id;
	}

	public int getFormas_pago_id() {
		return formas_pago_id;
	}

	public void setFormas_pago_id(int formas_pago_id) {
		this.formas_pago_id = formas_pago_id;
	}

	public int getUso_cfdi_id() {
		return uso_cfdi_id;
	}

	public void setUso_cfdi_id(int uso_cfdi_id) {
		this.uso_cfdi_id = uso_cfdi_id;
	}

	public String getComisionista() {
		return comisionista;
	}

	public void setComisionista(String comisionista) {
		this.comisionista = comisionista;
	}
	
}
