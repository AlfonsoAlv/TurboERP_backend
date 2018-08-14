package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class DepositoRecibido {
	
	private int id;
	private String comentarios;
	private BigDecimal importe_deposito;
	private Date fecha_deposito;
	private String cuenta_emisor;
	private int numero_operacion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int formas_pago_id;
	private int cuentas_bancarias_id;
	private int bancos_id_emisor;
	private int tipos_cadena_pago;
	private String certificado_pago;
	private String cadena_pago;
	private String sello_pago;
	private int PAGOS_id;
	
	public DepositoRecibido() {
		super();
	}

	public DepositoRecibido(int id, String comentarios, BigDecimal importe_deposito, Date fecha_deposito,
			String cuenta_emisor, int numero_operacion, int activo, int creado_por, Date creado, int modificado_por,
			Date modificado, int formas_pago_id, int cuentas_bancarias_id, int bancos_id_emisor, int tipos_cadena_pago,
			String certificado_pago, String cadena_pago, String sello_pago, int PAGOS_id) {
		super();
		this.id = id;
		this.comentarios = comentarios;
		this.importe_deposito = importe_deposito;
		this.fecha_deposito = fecha_deposito;
		this.cuenta_emisor = cuenta_emisor;
		this.numero_operacion = numero_operacion;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.formas_pago_id = formas_pago_id;
		this.cuentas_bancarias_id = cuentas_bancarias_id;
		this.bancos_id_emisor = bancos_id_emisor;
		this.tipos_cadena_pago = tipos_cadena_pago;
		this.certificado_pago = certificado_pago;
		this.cadena_pago = cadena_pago;
		this.sello_pago = sello_pago;
		this.PAGOS_id = PAGOS_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public BigDecimal getImporte_deposito() {
		return importe_deposito;
	}

	public void setImporte_deposito(BigDecimal importe_deposito) {
		this.importe_deposito = importe_deposito;
	}

	public Date getFecha_deposito() {
		return fecha_deposito;
	}

	public void setFecha_deposito(Date fecha_deposito) {
		this.fecha_deposito = fecha_deposito;
	}

	public String getCuenta_emisor() {
		return cuenta_emisor;
	}

	public void setCuenta_emisor(String cuenta_emisor) {
		this.cuenta_emisor = cuenta_emisor;
	}

	public int getNumero_operacion() {
		return numero_operacion;
	}

	public void setNumero_operacion(int numero_operacion) {
		this.numero_operacion = numero_operacion;
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

	public int getFormas_pago_id() {
		return formas_pago_id;
	}

	public void setFormas_pago_id(int formas_pago_id) {
		this.formas_pago_id = formas_pago_id;
	}

	public int getCuentas_bancarias_id() {
		return cuentas_bancarias_id;
	}

	public void setCuentas_bancarias_id(int cuentas_bancarias_id) {
		this.cuentas_bancarias_id = cuentas_bancarias_id;
	}

	public int getBancos_id_emisor() {
		return bancos_id_emisor;
	}

	public void setBancos_id_emisor(int bancos_id_emisor) {
		this.bancos_id_emisor = bancos_id_emisor;
	}

	public int getTipos_cadena_pago() {
		return tipos_cadena_pago;
	}

	public void setTipos_cadena_pago(int tipos_cadena_pago) {
		this.tipos_cadena_pago = tipos_cadena_pago;
	}

	public String getCertificado_pago() {
		return certificado_pago;
	}

	public void setCertificado_pago(String certificado_pago) {
		this.certificado_pago = certificado_pago;
	}

	public String getCadena_pago() {
		return cadena_pago;
	}

	public void setCadena_pago(String cadena_pago) {
		this.cadena_pago = cadena_pago;
	}

	public String getSello_pago() {
		return sello_pago;
	}

	public void setSello_pago(String sello_pago) {
		this.sello_pago = sello_pago;
	}

	public int getPAGOS_id() {
		return PAGOS_id;
	}

	public void setPAGOS_id(int PAGOS_id) {
		this.PAGOS_id = PAGOS_id;
	}

}
