package com.turbomaquinas.POJO.calidad;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GarantiaOrden {
	
	private int garantia_id;
	private String descripcion_garantia;
	private int encabezado_garantia_id;
	private String descripcion_encabezado;
	private int detalle_garantia_id;
	private String descripcion_detalle;
	private Date fecha_terminacion;

}
