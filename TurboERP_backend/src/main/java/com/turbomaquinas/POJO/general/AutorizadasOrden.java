package com.turbomaquinas.POJO.general;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorizadasOrden {
	
	private int actividad_autorizada_id;
	private int autorizacion_id;
	private String folio;
	private int detalle_id;
	private String descripcion;
	private int lugar;
	
	@Override
	public String toString() {
		return "AutorizadasOrden [actividad_autorizada_id=" + actividad_autorizada_id + ", autorizacion_id="
				+ autorizacion_id + ", folio=" + folio + ", detalle_id=" + detalle_id + ", descripcion=" + descripcion
				+ ", lugar=" + lugar + "]";
	}

}
