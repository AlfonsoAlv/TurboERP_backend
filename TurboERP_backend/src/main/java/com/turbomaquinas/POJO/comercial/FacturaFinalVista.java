package com.turbomaquinas.POJO.comercial;

import java.util.Date;

public class FacturaFinalVista {
	
	private int id;
	private String tipo;
	private int numero;
	private Date fecha_factura;
	private Date fecha_vencimiento;
	private float subtotal;
	private float descuento;
	private float iva;
	private float iva_retenido;
	private float total;
	private String moneda;
	private float tipo_cambio;
	private String condiciones_pago;
	private float saldo;
	private String folio_fiscal;
	private String estado_factura;
	private String desc_estado_fact;
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
	private String estado;
	private String pais;
	private int activo;
	private int clientes_id;
	private ComprobantesRelacionados comprobantes_relacionados;
	private String comentario;
	private int creado_por;
	private String alfresco_id_previa;
	private String alfresco_id_timbrado_pdf;
	private String alfresco_id_timbrado_xml;
	private int datos_timbrado_id;
	
	public FacturaFinalVista() {
		super();
	}	

	public FacturaFinalVista(int id, String tipo, int numero, Date fecha_factura, Date fecha_vencimiento,
			float subtotal, float descuento, float iva, float iva_retenido, float total, String moneda,
			float tipo_cambio, String condiciones_pago, float saldo, String folio_fiscal, String estado_factura,
			String desc_estado_fact, String cve_formap, String des_formap, String cve_metodop, String des_metodop,
			String cve_uso, String des_uso, int numero_cliente, int numero_giro, String nombre, String direccion,
			String colonia, String codigo_postal, String ciudad, String estado, String pais, int activo,
			int clientes_id, ComprobantesRelacionados comprobantes_relacionados, String comentario, int creado_por,
			String alfresco_id_previa, String alfresco_id_timbrado_pdf, String alfresco_id_timbrado_xml,int datos_timbrado_id) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.fecha_factura = fecha_factura;
		this.fecha_vencimiento = fecha_vencimiento;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.iva = iva;
		this.iva_retenido = iva_retenido;
		this.total = total;
		this.moneda = moneda;
		this.tipo_cambio = tipo_cambio;
		this.condiciones_pago = condiciones_pago;
		this.saldo = saldo;
		this.folio_fiscal = folio_fiscal;
		this.estado_factura = estado_factura;
		this.desc_estado_fact = desc_estado_fact;
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
		this.estado = estado;
		this.pais = pais;
		this.activo = activo;
		this.clientes_id = clientes_id;
		this.comprobantes_relacionados = comprobantes_relacionados;
		this.comentario = comentario;
		this.creado_por = creado_por;
		this.alfresco_id_previa = alfresco_id_previa;
		this.alfresco_id_timbrado_pdf = alfresco_id_timbrado_pdf;
		this.alfresco_id_timbrado_xml = alfresco_id_timbrado_xml;
		this.datos_timbrado_id=datos_timbrado_id;
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

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getIva_retenido() {
		return iva_retenido;
	}

	public void setIva_retenido(float iva_retenido) {
		this.iva_retenido = iva_retenido;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}
	
	public ComprobantesRelacionados getComprobantes_relacionados() {
		return comprobantes_relacionados;
	}

	public void setComprobantes_relacionados(ComprobantesRelacionados comprobantes_relacionados) {
		this.comprobantes_relacionados = comprobantes_relacionados;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(int creado_por) {
		this.creado_por = creado_por;
	}
	
	public String getAlfresco_id_previa() {
		return alfresco_id_previa;
	}

	public void setAlfresco_id_previa(String alfresco_id_previa) {
		this.alfresco_id_previa = alfresco_id_previa;
	}

	public String getAlfresco_id_timbrado_pdf() {
		return alfresco_id_timbrado_pdf;
	}

	public void setAlfresco_id_timbrado_pdf(String alfresco_id_timbrado_pdf) {
		this.alfresco_id_timbrado_pdf = alfresco_id_timbrado_pdf;
	}

	public String getAlfresco_id_timbrado_xml() {
		return alfresco_id_timbrado_xml;
	}

	public void setAlfresco_id_timbrado_xml(String alfresco_id_timbrado_xml) {
		this.alfresco_id_timbrado_xml = alfresco_id_timbrado_xml;
	}
	
	public int getDatos_timbrado_id() {
		return datos_timbrado_id;
	}

	public void setDatos_timbrado_id(int datos_timbrado_id) {
		this.datos_timbrado_id = datos_timbrado_id;
	}






	public static class ComprobantesRelacionados{
		private String tipoRelacion;
		private int comprobantes [];
		
		public ComprobantesRelacionados() {
			super();
		}

		public ComprobantesRelacionados(String tipoRelacion, int[] comprobantes) {
			super();
			this.tipoRelacion = tipoRelacion;
			this.comprobantes = comprobantes;
		}

		public String getTipoRelacion() {
			return tipoRelacion;
		}

		public void setTipoRelacion(String tipoRelacion) {
			this.tipoRelacion = tipoRelacion;
		}

		public int[] getComprobantes() {
			return comprobantes;
		}

		public void setComprobantes(int[] comprobantes) {
			this.comprobantes = comprobantes;
		}
		
			
	}
		
	
}
