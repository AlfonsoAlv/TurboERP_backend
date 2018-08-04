package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;
import java.util.List;

public class DocumentoAplicarNotasCredito {
	
	private BigDecimal subtotal;
	private String fecha;
	private BigDecimal iva;
	private BigDecimal tipo_cambio;
	private String descripcion;
	private int activo;
	private int creado_por;
	private int datos_timbrado_id;
	private int conceptos_facturacion_contable_id;
	private int notas_credito_id_sust;
	private List<DocumentoAplicarNotasCredito.Facturas> facturas;
	
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
	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
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
	public int getDatos_timbrado_id() {
		return datos_timbrado_id;
	}
	public void setDatos_timbrado_id(int datos_timbrado_id) {
		this.datos_timbrado_id = datos_timbrado_id;
	}
	public int getConceptos_facturacion_contable_id() {
		return conceptos_facturacion_contable_id;
	}
	public void setConceptos_facturacion_contable_id(int conceptos_facturacion_contable_id) {
		this.conceptos_facturacion_contable_id = conceptos_facturacion_contable_id;
	}
	public int getNotas_credito_id_sust() {
		return notas_credito_id_sust;
	}
	public void setNotas_credito_id_sust(int notas_credito_id_sust) {
		this.notas_credito_id_sust = notas_credito_id_sust;
	}
	public List<DocumentoAplicarNotasCredito.Facturas> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<DocumentoAplicarNotasCredito.Facturas> facturas) {
		this.facturas = facturas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	
	public static class Facturas {
		
		private int idFactura;
		private String tipoFactura;
		private BigDecimal importe;
		private List<Orden> ordenes;
		
		public Facturas() {
			super();
		}
		public Facturas(int idFactura, String tipoFactura, BigDecimal importe, List<Orden> ordenes) {
			super();
			this.idFactura = idFactura;
			this.tipoFactura = tipoFactura;
			this.importe = importe;
			this.ordenes = ordenes;
		}
		public int getIdFactura() {
			return idFactura;
		}
		public void setIdFactura(int idFactura) {
			this.idFactura = idFactura;
		}
		public String getTipoFactura() {
			return tipoFactura;
		}
		public void setTipoFactura(String tipoFactura) {
			this.tipoFactura = tipoFactura;
		}
		public BigDecimal getImporte() {
			return importe;
		}
		public void setImporte(BigDecimal importe) {
			this.importe = importe;
		}
		
		public List<Orden> getOrdenes() {
			return ordenes;
		}
		
		public void setOrdenes(List<Orden> ordenes) {
			this.ordenes = ordenes;
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
		
		public static class Orden {

			private int id;
			private BigDecimal importe;

			public Orden(int id, BigDecimal importe) {
				super();
				this.id = id;
				this.importe = importe;
			}

			public Orden() {
				super();
				// TODO Auto-generated constructor stub
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

			@Override
			public String toString() {
				try {
					return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter()
							.writeValueAsString(this);
				} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
					e.printStackTrace();
				}
				return null;
			}
		}
		
	}

}
