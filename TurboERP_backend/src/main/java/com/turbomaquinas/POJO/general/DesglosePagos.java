package com.turbomaquinas.POJO.general;

import java.util.List;

import com.turbomaquinas.POJO.comercial.FacturasPagadas;

public class DesglosePagos {
	
	private int depositos_recibidos_id;
	private List<FacturasPagadas> facturas;
	
	public DesglosePagos() {
		super();
	}

	public DesglosePagos(int depositos_recibidos_id, List<FacturasPagadas> facturas) {
		super();
		this.depositos_recibidos_id = depositos_recibidos_id;
		this.facturas = facturas;
	}

	public int getDepositos_recibidos_id() {
		return depositos_recibidos_id;
	}

	public void setDepositos_recibidos_id(int depositos_recibidos_id) {
		this.depositos_recibidos_id = depositos_recibidos_id;
	}

	public List<FacturasPagadas> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturasPagadas> facturas) {
		this.facturas = facturas;
	}
	
	

}
