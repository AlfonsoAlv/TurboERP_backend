package com.turbomaquinas.POJO.calidad;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoActividadesGarantia {
	
	private int id;
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int personal_id;
	private int ordenes_id;
	private List<EncabezadosGarantia> encabezados;
	
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
