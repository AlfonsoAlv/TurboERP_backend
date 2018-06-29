package com.turbomaquinas.POJO.proveedores;

public class IndicadoresTotalesDeRequisiciones {
	
	private int id;
	private int favor_requeridosentiempo;
	private int encontra_requeridosentiempo;
	private int favor_plandeproduccion;
	private int encontra_plandeproduccion;
	private int favor_entregasentiempo;
	private int encontra_entregasentiempo;
	private int liberadas;
	private int rechazadas;
	
	public IndicadoresTotalesDeRequisiciones() {
		super();
	}

	
	public IndicadoresTotalesDeRequisiciones(int id, int favor_requeridosentiempo, int encontra_requeridosentiempo,
			int favor_plandeproduccion, int encontra_plandeproduccion, int favor_entregasentiempo,
			int encontra_entregasentiempo, int liberadas, int rechazadas) {
		super();
		this.id = id;
		this.favor_requeridosentiempo = favor_requeridosentiempo;
		this.encontra_requeridosentiempo = encontra_requeridosentiempo;
		this.favor_plandeproduccion = favor_plandeproduccion;
		this.encontra_plandeproduccion = encontra_plandeproduccion;
		this.favor_entregasentiempo = favor_entregasentiempo;
		this.encontra_entregasentiempo = encontra_entregasentiempo;
		this.liberadas = liberadas;
		this.rechazadas = rechazadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFavor_requeridosentiempo() {
		return favor_requeridosentiempo;
	}

	public void setFavor_requeridosentiempo(int favor_requeridosentiempo) {
		this.favor_requeridosentiempo = favor_requeridosentiempo;
	}

	public int getEncontra_requeridosentiempo() {
		return encontra_requeridosentiempo;
	}

	public void setEncontra_requeridosentiempo(int encontra_requeridosentiempo) {
		this.encontra_requeridosentiempo = encontra_requeridosentiempo;
	}

	public int getFavor_plandeproduccion() {
		return favor_plandeproduccion;
	}

	public void setFavor_plandeproduccion(int favor_plandeproduccion) {
		this.favor_plandeproduccion = favor_plandeproduccion;
	}

	public int getEncontra_plandeproduccion() {
		return encontra_plandeproduccion;
	}

	public void setEncontra_plandeproduccion(int encontra_plandeproduccion) {
		this.encontra_plandeproduccion = encontra_plandeproduccion;
	}

	public int getFavor_entregasentiempo() {
		return favor_entregasentiempo;
	}

	public void setFavor_entregasentiempo(int favor_entregasentiempo) {
		this.favor_entregasentiempo = favor_entregasentiempo;
	}

	public int getEncontra_entregasentiempo() {
		return encontra_entregasentiempo;
	}

	public void setEncontra_entregasentiempo(int encontra_entregasentiempo) {
		this.encontra_entregasentiempo = encontra_entregasentiempo;
	}

	public int getLiberadas() {
		return liberadas;
	}

	public void setLiberadas(int liberadas) {
		this.liberadas = liberadas;
	}

	public int getRechazadas() {
		return rechazadas;
	}

	public void setRechazadas(int rechazadas) {
		this.rechazadas = rechazadas;
	}


}
