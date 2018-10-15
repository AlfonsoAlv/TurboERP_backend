package com.turbomaquinas.POJO.general;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoCrearOIT {
	
	private int tipo_origen;
	private int orden_id;
	private int actividad_id[];
	
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
