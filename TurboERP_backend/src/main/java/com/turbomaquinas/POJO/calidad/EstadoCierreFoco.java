package com.turbomaquinas.POJO.calidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCierreFoco {
	
	private int folio;
	private String estadoFoco;
	private int estatusValidacion;
	private int validadoComercial;
	private int validadoCliente;
	private int estatusClienteInformado;
	private int clienteInformadoComercial;
	private int clienteInformadoCalidad;
	
}