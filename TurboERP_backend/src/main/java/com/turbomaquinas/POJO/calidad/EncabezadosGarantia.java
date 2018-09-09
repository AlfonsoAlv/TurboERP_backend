package com.turbomaquinas.POJO.calidad;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncabezadosGarantia {
	
	private int id;
	private String descripcion;
	private int activo;
	private int creado_por;
	private Date creado;
	private int lugar;
	private List<DetallesGarantia> actividades;
	

}
