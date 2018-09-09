package com.turbomaquinas.POJO.calidad;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallesGarantia {
	
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int encabezados_garantia_id;
	private int detalle_diagnostico_id;
	private int lugar;
	private List<SubindicesGarantia> subindices;

}
