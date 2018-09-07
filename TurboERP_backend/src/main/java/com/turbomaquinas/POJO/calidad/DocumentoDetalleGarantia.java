package com.turbomaquinas.POJO.calidad;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista.DepartamentosId;

public class DocumentoDetalleGarantia {
	private int id;
	private String procede;
	private String motivo;
	private int planta;
	private int insatisfacciones_id;
	private DepartamentosId departamentos;
	
	public DocumentoDetalleGarantia() {
		super();
	}

	public DocumentoDetalleGarantia(int id, String procede, String motivo, int planta, int insatisfacciones_id,
			DepartamentosId departamentos) {
		super();
		this.id = id;
		this.procede = procede;
		this.motivo = motivo;
		this.planta = planta;
		this.insatisfacciones_id = insatisfacciones_id;
		this.departamentos = departamentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcede() {
		return procede;
	}

	public void setProcede(String procede) {
		this.procede = procede;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getInsatisfacciones_id() {
		return insatisfacciones_id;
	}

	public void setInsatisfacciones_id(int insatisfacciones_id) {
		this.insatisfacciones_id = insatisfacciones_id;
	}

	public DepartamentosId getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(DepartamentosId departamentos) {
		this.departamentos = departamentos;
	}
	
	@Override
	public String toString() {
		try {
	        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
   }
	

}
