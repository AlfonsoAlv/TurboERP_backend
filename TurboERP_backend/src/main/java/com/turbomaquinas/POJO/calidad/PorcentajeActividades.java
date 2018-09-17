package com.turbomaquinas.POJO.calidad;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PorcentajeActividades {
	private int actividadesDefinidas;
	private int actividadesTotales;
	private float porcentajeCompletado;
}