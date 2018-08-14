package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class DepositoRecibidoVista {
	
	private int id;
	private String comentarios;
	private String certificado_pago;
	private String cadena_pago;
	private String sello_pago;
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
	private String formas_pago_descripcion;
	private String formas_pago_clave;
	private int tipo_cadena_pago_id;
	private String tipo_cadena_pago_descripcion;
	private String tipo_cadena_pago_clave;
	private int cuentas_bancarias_id;
	private String cuentas_bancarias_descripcion;
	private long cuentas_bancarias_numero;
	private String bancos_rfc;
	private String bancos_cuenta;
	private int bancos_id_emisor;
	private String bancos_descripcion;
	private String bancos_clave;
	private String banco_destino;
	private int PAGOS_id;
	
	public DepositoRecibidoVista() {
		super();
	}

	public DepositoRecibidoVista(int id, String comentarios, String certificado_pago, String cadena_pago,
			String sello_pago, BigDecimal importe_deposito, Date fecha_deposito, String cuenta_emisor, int numero_operacion,
			int activo, int creado_por, Date creado, int modificado_por, Date modificado, int formas_pago_id,
			String formas_pago_descripcion, String formas_pago_clave, int tipo_cadena_pago_id,
			String tipo_cadena_pago_descripcion, String tipo_cadena_pago_clave, int cuentas_bancarias_id,
			String cuentas_bancarias_descripcion, long cuentas_bancarias_numero, String bancos_rfc,
			String bancos_cuenta, int bancos_id_emisor, String bancos_descripcion, String bancos_clave,
			String banco_destino, int PAGOS_id) {
		super();
		this.id = id;
		this.comentarios = comentarios;
		this.certificado_pago = certificado_pago;
		this.cadena_pago = cadena_pago;
		this.sello_pago = sello_pago;
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
		this.formas_pago_descripcion = formas_pago_descripcion;
		this.formas_pago_clave = formas_pago_clave;
		this.tipo_cadena_pago_id = tipo_cadena_pago_id;
		this.tipo_cadena_pago_descripcion = tipo_cadena_pago_descripcion;
		this.tipo_cadena_pago_clave = tipo_cadena_pago_clave;
		this.cuentas_bancarias_id = cuentas_bancarias_id;
		this.cuentas_bancarias_descripcion = cuentas_bancarias_descripcion;
		this.cuentas_bancarias_numero = cuentas_bancarias_numero;
		this.bancos_rfc = bancos_rfc;
		this.bancos_cuenta = bancos_cuenta;
		this.bancos_id_emisor = bancos_id_emisor;
		this.bancos_descripcion = bancos_descripcion;
		this.bancos_clave = bancos_clave;
		this.banco_destino = banco_destino;
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

	public String getFormas_pago_descripcion() {
		return formas_pago_descripcion;
	}

	public void setFormas_pago_descripcion(String formas_pago_descripcion) {
		this.formas_pago_descripcion = formas_pago_descripcion;
	}

	public String getFormas_pago_clave() {
		return formas_pago_clave;
	}

	public void setFormas_pago_clave(String formas_pago_clave) {
		this.formas_pago_clave = formas_pago_clave;
	}

	public int getTipo_cadena_pago_id() {
		return tipo_cadena_pago_id;
	}

	public void setTipo_cadena_pago_id(int tipo_cadena_pago_id) {
		this.tipo_cadena_pago_id = tipo_cadena_pago_id;
	}

	public String getTipo_cadena_pago_descripcion() {
		return tipo_cadena_pago_descripcion;
	}

	public void setTipo_cadena_pago_descripcion(String tipo_cadena_pago_descripcion) {
		this.tipo_cadena_pago_descripcion = tipo_cadena_pago_descripcion;
	}

	public String getTipo_cadena_pago_clave() {
		return tipo_cadena_pago_clave;
	}

	public void setTipo_cadena_pago_clave(String tipo_cadena_pago_clave) {
		this.tipo_cadena_pago_clave = tipo_cadena_pago_clave;
	}

	public int getCuentas_bancarias_id() {
		return cuentas_bancarias_id;
	}

	public void setCuentas_bancarias_id(int cuentas_bancarias_id) {
		this.cuentas_bancarias_id = cuentas_bancarias_id;
	}

	public String getCuentas_bancarias_descripcion() {
		return cuentas_bancarias_descripcion;
	}

	public void setCuentas_bancarias_descripcion(String cuentas_bancarias_descripcion) {
		this.cuentas_bancarias_descripcion = cuentas_bancarias_descripcion;
	}

	public long getCuentas_bancarias_numero() {
		return cuentas_bancarias_numero;
	}

	public void setCuentas_bancarias_numero(long cuentas_bancarias_numero) {
		this.cuentas_bancarias_numero = cuentas_bancarias_numero;
	}

	public String getBancos_rfc() {
		return bancos_rfc;
	}

	public void setBancos_rfc(String bancos_rfc) {
		this.bancos_rfc = bancos_rfc;
	}

	public String getBancos_cuenta() {
		return bancos_cuenta;
	}

	public void setBancos_cuenta(String bancos_cuenta) {
		this.bancos_cuenta = bancos_cuenta;
	}

	public int getBancos_id_emisor() {
		return bancos_id_emisor;
	}

	public void setBancos_id_emisor(int bancos_id_emisor) {
		this.bancos_id_emisor = bancos_id_emisor;
	}

	public String getBancos_descripcion() {
		return bancos_descripcion;
	}

	public void setBancos_descripcion(String bancos_descripcion) {
		this.bancos_descripcion = bancos_descripcion;
	}

	public String getBancos_clave() {
		return bancos_clave;
	}

	public void setBancos_clave(String bancos_clave) {
		this.bancos_clave = bancos_clave;
	}

	public String getBanco_destino() {
		return banco_destino;
	}

	public void setBanco_destino(String banco_destino) {
		this.banco_destino = banco_destino;
	}

	public int getPAGOS_id() {
		return PAGOS_id;
	}

	public void setPAGOS_id(int PAGOS_id) {
		this.PAGOS_id = PAGOS_id;
	}

	
}
