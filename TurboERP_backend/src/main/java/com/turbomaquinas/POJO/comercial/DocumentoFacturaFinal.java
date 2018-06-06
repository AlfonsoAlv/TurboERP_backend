package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.List;

public class DocumentoFacturaFinal {

	private int creado_por;
	private int formato_especial;
	private Factura factura;
	private List<Partida> actividades;
	private List<ActividadAutorizada> aa;
	
	public DocumentoFacturaFinal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentoFacturaFinal(int creado_por, int formato_especial, Factura factura, List<Partida> actividades,
			List<ActividadAutorizada> aa) {
		super();
		this.creado_por = creado_por;
		this.formato_especial = formato_especial;
		this.factura = factura;
		this.actividades = actividades;
		this.aa = aa;
	}

	public int getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(int creado_por) {
		this.creado_por = creado_por;
	}

	public int getFormato_especial() {
		return formato_especial;
	}

	public void setFormato_especial(int formato_especial) {
		this.formato_especial = formato_especial;
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

	public List<ActividadAutorizada> getAa() {
		return aa;
	}

	public void setAa(List<ActividadAutorizada> aa) {
		this.aa = aa;
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
		private String condiciones_pago;
		private String comentarios;
		private String moneda;
		private int descuento_neto;
		private ComprobanteRelacionado comprobantes_relacionados;
		
		public Factura() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Factura(int clientes_id, int formas_pago_id, int metodos_pago_id, int uso_cfdi_id,
				String condiciones_pago, String comentarios, String moneda, int descuento_neto,
				ComprobanteRelacionado comprobantes_relacionados) {
			super();
			this.clientes_id = clientes_id;
			this.formas_pago_id = formas_pago_id;
			this.metodos_pago_id = metodos_pago_id;
			this.uso_cfdi_id = uso_cfdi_id;
			this.condiciones_pago = condiciones_pago;
			this.comentarios = comentarios;
			this.moneda = moneda;
			this.descuento_neto = descuento_neto;
			this.comprobantes_relacionados = comprobantes_relacionados;
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

		public ComprobanteRelacionado getComprobantes_relacionados() {
			return comprobantes_relacionados;
		}

		public void setComprobantes_relacionados(ComprobanteRelacionado comprobantes_relacionados) {
			this.comprobantes_relacionados = comprobantes_relacionados;
		}

		public String getCondiciones_pago() {
			return condiciones_pago;
		}

		public void setCondiciones_pago(String condiciones_pago) {
			this.condiciones_pago = condiciones_pago;
		}

		public String getComentarios() {
			return comentarios;
		}

		public void setComentarios(String comentarios) {
			this.comentarios = comentarios;
		}

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public int getDescuento_neto() {
			return descuento_neto;
		}

		public void setDescuento_neto(int descuento_neto) {
			this.descuento_neto = descuento_neto;
		}


		public static class ComprobanteRelacionado {
			
			private String tipo_relacion;
			private int[] comprobantes;
			
			public ComprobanteRelacionado() {
				super();
				// TODO Auto-generated constructor stub
			}

			public ComprobanteRelacionado(String tipo_relacion, int[] comprobantes) {
				super();
				this.tipo_relacion = tipo_relacion;
				this.comprobantes = comprobantes;
			}

			public String getTipo_relacion() {
				return tipo_relacion;
			}

			public void setTipo_relacion(String tipo_relacion) {
				this.tipo_relacion = tipo_relacion;
			}

			public int[] getComprobantes() {
				return comprobantes;
			}

			public void setComprobantes(int[] comprobantes) {
				this.comprobantes = comprobantes;
			}

		}
		
	}
	
	public static class Partida {
		
		private int id;
		private String descripcion;
		private BigDecimal importe;
		private BigDecimal descuento;
		private String tipo_actividad;
		private int concepto_facturacion_id;
		
		public Partida() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Partida(int id, String descripcion, BigDecimal importe, BigDecimal descuento, String tipo_actividad,
				int concepto_facturacion_id) {
			super();
			this.id = id;
			this.descripcion = descripcion;
			this.importe = importe;
			this.descuento = descuento;
			this.tipo_actividad = tipo_actividad;
			this.concepto_facturacion_id = concepto_facturacion_id;
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

		public BigDecimal getImporte() {
			return importe;
		}

		public void setImporte(BigDecimal importe) {
			this.importe = importe;
		}

		public BigDecimal getDescuento() {
			return descuento;
		}

		public void setDescuento(BigDecimal descuento) {
			this.descuento = descuento;
		}

		public String getTipo_actividad() {
			return tipo_actividad;
		}

		public void setTipo_actividad(String tipo_actividad) {
			this.tipo_actividad = tipo_actividad;
		}

		public int getConcepto_facturacion_id() {
			return concepto_facturacion_id;
		}

		public void setConcepto_facturacion_id(int concepto_facturacion_id) {
			this.concepto_facturacion_id = concepto_facturacion_id;
		}
		
	}
	
	public static class ActividadAutorizada {
		private int ordenes_id;
		private List<Actividad> actividades;
		
		
		public ActividadAutorizada() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ActividadAutorizada(int ordenes_id, List<Actividad> actividades) {
			super();
			this.ordenes_id = ordenes_id;
			this.actividades = actividades;
		}

		public int getOrdenes_id() {
			return ordenes_id;
		}

		public void setOrdenes_id(int ordenes_id) {
			this.ordenes_id = ordenes_id;
		}

		public List<Actividad> getActividades() {
			return actividades;
		}

		public void setActividades(List<Actividad> actividades) {
			this.actividades = actividades;
		}

		public static class Actividad {
			private int id;
			private BigDecimal importe;
			private BigDecimal descuento;
			
			public Actividad() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Actividad(int id, BigDecimal importe, BigDecimal descuento) {
				super();
				this.id = id;
				this.importe = importe;
				this.descuento = descuento;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public BigDecimal getImporte() {
				return importe;
			}

			public void setImporte(BigDecimal importe) {
				this.importe = importe;
			}

			public BigDecimal getDescuento() {
				return descuento;
			}

			public void setDescuento(BigDecimal descuento) {
				this.descuento = descuento;
			}
			
		}
	}

	
}
