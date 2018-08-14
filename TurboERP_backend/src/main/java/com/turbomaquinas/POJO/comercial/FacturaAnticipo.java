package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class FacturaAnticipo {
	
	private int id;
	private String tipo;
	private int numero;
	private Date fecha_anticipo;
	private Date fecha_vencimiento;
	private String descripcion;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal iva_retenido;
	private BigDecimal importe_pagado;
	private BigDecimal saldo;
	private String moneda;
	private float tipo_cambio;
	private String condiciones_pago;
	private Date fecha_baja;
	private int mes_baja;
	private int anio_baja;
	private int activo;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int facturas_anticipo_id_sust;
	private int datos_timbrado_id;
	private int productos_sat_id;
	private int formas_pago_id;
	private int metodos_pago_id;
	private int uso_cfdi_id;
	private int clientes_id;
	private float total;
	
	public FacturaAnticipo() {
		super();
	}

	public FacturaAnticipo(int id, String tipo, int numero, Date fecha_anticipo, Date fecha_vencimiento,
			String descripcion, BigDecimal subtotal, BigDecimal iva, BigDecimal iva_retenido, BigDecimal importe_pagado, BigDecimal saldo,
			String moneda, float tipo_cambio, String condiciones_pago, Date fecha_baja, int mes_baja, int anio_baja,
			int activo, int creado_por, Date creado, int modificado_por, Date modificado, int facturas_anticipo_id_sust,
			int datos_timbrado_id, int productos_sat_id, int formas_pago_id, int metodos_pago_id, int uso_cfdi_id,
			int clientes_id, float total) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.fecha_anticipo = fecha_anticipo;
		this.fecha_vencimiento = fecha_vencimiento;
		this.descripcion = descripcion;
		this.subtotal = subtotal;
		this.iva = iva;
		this.iva_retenido = iva_retenido;
		this.importe_pagado = importe_pagado;
		this.saldo = saldo;
		this.moneda = moneda;
		this.tipo_cambio = tipo_cambio;
		this.condiciones_pago = condiciones_pago;
		this.fecha_baja = fecha_baja;
		this.mes_baja = mes_baja;
		this.anio_baja = anio_baja;
		this.activo = activo;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.facturas_anticipo_id_sust = facturas_anticipo_id_sust;
		this.datos_timbrado_id = datos_timbrado_id;
		this.productos_sat_id = productos_sat_id;
		this.formas_pago_id = formas_pago_id;
		this.metodos_pago_id = metodos_pago_id;
		this.uso_cfdi_id = uso_cfdi_id;
		this.clientes_id = clientes_id;
		this.total = total;
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

	public Date getFecha_anticipo() {
		return fecha_anticipo;
	}

	public void setFecha_anticipo(Date fecha_anticipo) {
		this.fecha_anticipo = fecha_anticipo;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public BigDecimal getIva_retenido() {
		return iva_retenido;
	}

	public void setIva_retenido(BigDecimal iva_retenido) {
		this.iva_retenido = iva_retenido;
	}

	public BigDecimal getImporte_pagado() {
		return importe_pagado;
	}

	public void setImporte_pagado(BigDecimal importe_pagado) {
		this.importe_pagado = importe_pagado;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public float getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(float tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public String getCondiciones_pago() {
		return condiciones_pago;
	}

	public void setCondiciones_pago(String condiciones_pago) {
		this.condiciones_pago = condiciones_pago;
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

	public int getFacturas_anticipo_id_sust() {
		return facturas_anticipo_id_sust;
	}

	public void setFacturas_anticipo_id_sust(int facturas_anticipo_id_sust) {
		this.facturas_anticipo_id_sust = facturas_anticipo_id_sust;
	}

	public int getDatos_timbrado_id() {
		return datos_timbrado_id;
	}

	public void setDatos_timbrado_id(int datos_timbrado_id) {
		this.datos_timbrado_id = datos_timbrado_id;
	}

	public int getProductos_sat_id() {
		return productos_sat_id;
	}

	public void setProductos_sat_id(int productos_sat_id) {
		this.productos_sat_id = productos_sat_id;
	}

	public int getFormas_pago_id() {
		return formas_pago_id;
	}

	public void setFormas_pago_id(int formas_pago_id) {
		this.formas_pago_id = formas_pago_id;
	}

	public int getMetodos_pago_id() {
		return metodos_pago_id;
	}

	public void setMetodos_pago_id(int metodos_pago_id) {
		this.metodos_pago_id = metodos_pago_id;
	}

	public int getUso_cfdi_id() {
		return uso_cfdi_id;
	}

	public void setUso_cfdi_id(int uso_cfdi_id) {
		this.uso_cfdi_id = uso_cfdi_id;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "FacturaAnticipo [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", fecha_anticipo="
				+ fecha_anticipo + ", fecha_vencimiento=" + fecha_vencimiento + ", descripcion=" + descripcion
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", iva_retenido=" + iva_retenido + ", importe_pagado="
				+ importe_pagado + ", saldo=" + saldo + ", moneda=" + moneda + ", tipo_cambio=" + tipo_cambio
				+ ", condiciones_pago=" + condiciones_pago + ", fecha_baja=" + fecha_baja + ", mes_baja=" + mes_baja
				+ ", anio_baja=" + anio_baja + ", activo=" + activo + ", creado_por=" + creado_por + ", creado="
				+ creado + ", modificado_por=" + modificado_por + ", modificado=" + modificado
				+ ", facturas_anticipo_id_sust=" + facturas_anticipo_id_sust + ", datos_timbrado_id="
				+ datos_timbrado_id + ", productos_sat_id=" + productos_sat_id + ", formas_pago_id=" + formas_pago_id
				+ ", metodos_pago_id=" + metodos_pago_id + ", uso_cfdi_id=" + uso_cfdi_id + ", clientes_id="
				+ clientes_id + ", total=" + total + "]";
	}
}
