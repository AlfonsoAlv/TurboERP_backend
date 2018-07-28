package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.List;

public class DocumentoFacturaVarios {

	private int creado_por;
	private Factura factura;
	private List<Partida> actividades;
	
	public DocumentoFacturaVarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentoFacturaVarios(int creado_por, Factura factura, List<Partida> actividades) {
		super();
		this.creado_por = creado_por;
		this.factura = factura;
		this.actividades = actividades;
	}

	public int getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(int creado_por) {
		this.creado_por = creado_por;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Partida> getActividades() {
		return actividades;
	}

	public void setActividades(List<Partida> actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		try {
	        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public static class Factura {
		private int clientes_id;
		private int formas_pago_id;
		private int metodos_pago_id;
		private int uso_cfdi_id;
		private int concepto_facturacion_contable_id;
		private String condiciones_pago;
		private String observaciones;
		private String moneda;
		private String predial;
		private int nota_cargo;
		private int factura_varios_id_sust;
		
		public Factura() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Factura(int clientes_id, int formas_pago_id, int metodos_pago_id, int uso_cfdi_id,
				int concepto_facturacion_contable_id, String condiciones_pago, String observaciones, String moneda,
				String predial, int nota_cargo, int factura_varios_id_sust) {
			super();
			this.clientes_id = clientes_id;
			this.formas_pago_id = formas_pago_id;
			this.metodos_pago_id = metodos_pago_id;
			this.uso_cfdi_id = uso_cfdi_id;
			this.concepto_facturacion_contable_id = concepto_facturacion_contable_id;
			this.condiciones_pago = condiciones_pago;
			this.observaciones = observaciones;
			this.moneda = moneda;
			this.predial = predial;
			this.nota_cargo = nota_cargo;
			this.factura_varios_id_sust = factura_varios_id_sust;
		}

		public int getClientes_id() {
			return clientes_id;
		}

		public void setClientes_id(int clientes_id) {
			this.clientes_id = clientes_id;
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

		public int getConcepto_facturacion_contable_id() {
			return concepto_facturacion_contable_id;
		}

		public void setConcepto_facturacion_contable_id(int concepto_facturacion_contable_id) {
			this.concepto_facturacion_contable_id = concepto_facturacion_contable_id;
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

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public String getPredial() {
			return predial;
		}

		public void setPredial(String predial) {
			this.predial = predial;
		}

		public int getFactura_varios_id_sust() {
			return factura_varios_id_sust;
		}

		public void setFactura_varios_id_sust(int factura_varios_id_sust) {
			this.factura_varios_id_sust = factura_varios_id_sust;
		}

		public int getNota_cargo() {
			return nota_cargo;
		}

		public void setNota_cargo(int nota_cargo) {
			this.nota_cargo = nota_cargo;
		}
		
	}
	
	public static class Partida {
		
		private String descripcion;
		private int cantidad;
		private BigDecimal precio_unitario;
		private int concepto_facturacion_id;
		
		public Partida() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Partida(String descripcion, int cantidad, BigDecimal precio_unitario, int concepto_facturacion_id) {
			super();
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precio_unitario = precio_unitario;
			this.concepto_facturacion_id = concepto_facturacion_id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public BigDecimal getPrecio_unitario() {
			return precio_unitario;
		}

		public void setPrecio_unitario(BigDecimal precio_unitario) {
			this.precio_unitario = precio_unitario;
		}

		public int getConcepto_facturacion_id() {
			return concepto_facturacion_id;
		}

		public void setConcepto_facturacion_id(int concepto_facturacion_id) {
			this.concepto_facturacion_id = concepto_facturacion_id;
		}
		
	}
	
}
