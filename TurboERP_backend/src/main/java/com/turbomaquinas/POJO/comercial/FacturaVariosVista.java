package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.Date;

public class FacturaVariosVista {

	private int id;
	private String tipo;
	private int numero;
	private Date fecha_factura;
	private Date fecha_vencimiento;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	private BigDecimal importe_pagado;
	private BigDecimal saldo;
	private String moneda;
	private float tipo_cambio;
	private String condiciones_pago;
	private String observaciones;
	private String predial;
	private String estado_factura;
	private String desc_estado_fact;
	private int factura_varios_id_sust;
	private int numero_sustitucion;
	private String tipo_sustitucion;
    private String des_conceptos_facturacion_contable;
	private int clientes_id;
	private String folio_fiscal;
	private String cve_formap;
	private String des_formap;
	private String cve_metodop;
	private String des_metodop;
	private String cve_uso;
	private String des_uso;
	private int numero_cliente;
	private int numero_giro;
	private String nombre;
	private String direccion;
	private String colonia;
	private String codigo_postal;
	private String ciudad;
	private int estado_id;
	private String estado;
	private int pais_id;
	private String pais;
	private int activo;
	private int datos_timbrado_id;
	private int nota_cargo;
	
	public FacturaVariosVista() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FacturaVariosVista(int id, String tipo, int numero, Date fecha_factura, Date fecha_vencimiento,
			BigDecimal subtotal, BigDecimal iva, BigDecimal total, BigDecimal importe_pagado, BigDecimal saldo,
			String moneda, float tipo_cambio, String condiciones_pago, String observaciones, String predial,
			String estado_factura, String desc_estado_fact, int factura_varios_id_sust, int numero_sustitucion,
			String tipo_sustitucion, String des_conceptos_facturacion_contable, int clientes_id, String folio_fiscal,
			String cve_formap, String des_formap, String cve_metodop, String des_metodop, String cve_uso,
			String des_uso, int numero_cliente, int numero_giro, String nombre, String direccion, String colonia,
			String codigo_postal, String ciudad, int estado_id, String estado, int pais_id, String pais, int activo,
			int datos_timbrado_id, int nota_cargo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.fecha_factura = fecha_factura;
		this.fecha_vencimiento = fecha_vencimiento;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.importe_pagado = importe_pagado;
		this.saldo = saldo;
		this.moneda = moneda;
		this.tipo_cambio = tipo_cambio;
		this.condiciones_pago = condiciones_pago;
		this.observaciones = observaciones;
		this.predial = predial;
		this.estado_factura = estado_factura;
		this.desc_estado_fact = desc_estado_fact;
		this.factura_varios_id_sust = factura_varios_id_sust;
		this.numero_sustitucion = numero_sustitucion;
		this.tipo_sustitucion = tipo_sustitucion;
		this.des_conceptos_facturacion_contable = des_conceptos_facturacion_contable;
		this.clientes_id = clientes_id;
		this.folio_fiscal = folio_fiscal;
		this.cve_formap = cve_formap;
		this.des_formap = des_formap;
		this.cve_metodop = cve_metodop;
		this.des_metodop = des_metodop;
		this.cve_uso = cve_uso;
		this.des_uso = des_uso;
		this.numero_cliente = numero_cliente;
		this.numero_giro = numero_giro;
		this.nombre = nombre;
		this.direccion = direccion;
		this.colonia = colonia;
		this.codigo_postal = codigo_postal;
		this.ciudad = ciudad;
		this.estado_id = estado_id;
		this.estado = estado;
		this.pais_id = pais_id;
		this.pais = pais;
		this.activo = activo;
		this.datos_timbrado_id = datos_timbrado_id;
		this.nota_cargo = nota_cargo;
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

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPredial() {
		return predial;
	}

	public void setPredial(String predial) {
		this.predial = predial;
	}

	public String getEstado_factura() {
		return estado_factura;
	}

	public void setEstado_factura(String estado_factura) {
		this.estado_factura = estado_factura;
	}

	public String getDesc_estado_fact() {
		return desc_estado_fact;
	}

	public void setDesc_estado_fact(String desc_estado_fact) {
		this.desc_estado_fact = desc_estado_fact;
	}

	public int getFactura_varios_id_sust() {
		return factura_varios_id_sust;
	}

	public void setFactura_varios_id_sust(int factura_varios_id_sust) {
		this.factura_varios_id_sust = factura_varios_id_sust;
	}

	public int getNumero_sustitucion() {
		return numero_sustitucion;
	}

	public void setNumero_sustitucion(int numero_sustitucion) {
		this.numero_sustitucion = numero_sustitucion;
	}

	public String getTipo_sustitucion() {
		return tipo_sustitucion;
	}

	public void setTipo_sustitucion(String tipo_sustitucion) {
		this.tipo_sustitucion = tipo_sustitucion;
	}

	public String getDes_conceptos_facturacion_contable() {
		return des_conceptos_facturacion_contable;
	}

	public void setDes_conceptos_facturacion_contable(String des_conceptos_facturacion_contable) {
		this.des_conceptos_facturacion_contable = des_conceptos_facturacion_contable;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

	public String getFolio_fiscal() {
		return folio_fiscal;
	}

	public void setFolio_fiscal(String folio_fiscal) {
		this.folio_fiscal = folio_fiscal;
	}

	public String getCve_formap() {
		return cve_formap;
	}

	public void setCve_formap(String cve_formap) {
		this.cve_formap = cve_formap;
	}

	public String getDes_formap() {
		return des_formap;
	}

	public void setDes_formap(String des_formap) {
		this.des_formap = des_formap;
	}

	public String getCve_metodop() {
		return cve_metodop;
	}

	public void setCve_metodop(String cve_metodop) {
		this.cve_metodop = cve_metodop;
	}

	public String getDes_metodop() {
		return des_metodop;
	}

	public void setDes_metodop(String des_metodop) {
		this.des_metodop = des_metodop;
	}

	public String getCve_uso() {
		return cve_uso;
	}

	public void setCve_uso(String cve_uso) {
		this.cve_uso = cve_uso;
	}

	public String getDes_uso() {
		return des_uso;
	}

	public void setDes_uso(String des_uso) {
		this.des_uso = des_uso;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPais_id() {
		return pais_id;
	}

	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}


	public int getDatos_timbrado_id() {
		return datos_timbrado_id;
	}

	public void setDatos_timbrado_id(int datos_timbrado_id) {
		this.datos_timbrado_id = datos_timbrado_id;
	}

	public int getNota_cargo() {
		return nota_cargo;
	}

	public void setNota_cargo(int nota_cargo) {
		this.nota_cargo = nota_cargo;
	}

	@Override
	public String toString() {
		return "FacturaVariosVista [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", fecha_factura="
				+ fecha_factura + ", fecha_vencimiento=" + fecha_vencimiento + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", total=" + total + ", importe_pagado=" + importe_pagado + ", saldo=" + saldo + ", moneda=" + moneda
				+ ", tipo_cambio=" + tipo_cambio + ", condiciones_pago=" + condiciones_pago + ", observaciones="
				+ observaciones + ", predial=" + predial + ", estado_factura=" + estado_factura + ", desc_estado_fact="
				+ desc_estado_fact + ", factura_varios_id_sust=" + factura_varios_id_sust + ", numero_sustitucion="
				+ numero_sustitucion + ", tipo_sustitucion=" + tipo_sustitucion
				+ ", des_conceptos_facturacion_contable=" + des_conceptos_facturacion_contable + ", clientes_id="
				+ clientes_id + ", folio_fiscal=" + folio_fiscal + ", cve_formap=" + cve_formap + ", des_formap="
				+ des_formap + ", cve_metodop=" + cve_metodop + ", des_metodop=" + des_metodop + ", cve_uso=" + cve_uso
				+ ", des_uso=" + des_uso + ", numero_cliente=" + numero_cliente + ", numero_giro=" + numero_giro
				+ ", nombre=" + nombre + ", direccion=" + direccion + ", colonia=" + colonia + ", codigo_postal="
				+ codigo_postal + ", ciudad=" + ciudad + ", estado_id=" + estado_id + ", estado=" + estado
				+ ", pais_id=" + pais_id + ", pais=" + pais + ", activo=" + activo + ", datos_timbrado_id="
				+ datos_timbrado_id + ", nota_cargo=" + nota_cargo + "]";
	}
	
}
