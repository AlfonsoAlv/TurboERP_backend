package com.turbomaquinas.POJO.general;

import java.util.List;

public class DocumentoAAPedidoPrepedido {
	private int modificado_por;
	private List<PedidoPrepedidoAA> actividades;
	
	public int getModificado_por() {
		return modificado_por;
	}
	public void setModificado_por(int modificado_por) {
		this.modificado_por = modificado_por;
	}
	public List<PedidoPrepedidoAA> getActividades() {
		return actividades;
	}
	public void setActividades(List<PedidoPrepedidoAA> actividades) {
		this.actividades = actividades;
	}
	
	/*@Override
	public String toString() {
		return "DocumentoAAPedidoPrepedido [modificado_por=" + modificado_por + ", actividades=" + actividades + "]";
	}*/
	@Override
	public String toString() {
		try {
	        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
   }
}
