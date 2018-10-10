package com.turbomaquinas.POJO.general;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenInicioTrabajoVista {
	private int id;
	private String numero_orden;
	private String numero_oit;
	private String descripcion_orden;
	private String nombre_cliente;
	private String estado;
	private String descripcion_estado;
	private String tipo;
	private String origen;	
	private String prioridad;
	private String descripcion_prioridad;
	private float avance;	
	private String descripcion_equipo_recibido;
	private Date fecha_oit;
	private String alfresco_id;
	
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
