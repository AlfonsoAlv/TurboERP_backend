package com.turbomaquinas.POJO.calidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PorcentajeActividades {
	@Getter @Setter
	private int actividadesDefinidas;
	@Getter @Setter
	private int actividadesTotales;
	@Getter @Setter
	private float porcentajeCompletado;

}