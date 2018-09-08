package com.turbomaquinas.POJO.calidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubindicesGarantia {
	
	private String descripcion;
	private int activo;
	private int creado_por;
	private int detalle_garantias_id;
	private int lugar;
	

}
