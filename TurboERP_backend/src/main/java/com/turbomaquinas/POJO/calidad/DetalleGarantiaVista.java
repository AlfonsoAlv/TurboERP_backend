package com.turbomaquinas.POJO.calidad;

import java.sql.Date;

public class DetalleGarantiaVista {
	
	private int id;
	private String descripcion;
	private int lugar;
	private int planta;
	private int activo;
	private int encabezados_garantias_id;
	private int detalle_diagnostico_id;
	private String descripcionEncabezado;
	private int lugarEncabezado;
	private int garantias_id;
	private int cant_subindices;
	
	private String procede;
	private String motivo_procede;
	private int creado_por;
	private Date creado;
	private int modificado_por;
	private Date modificado;
	private int referencia;
	private Date fecha_terminacion;
	private int personal_terminado_id;
	private DepartamentosId departamentos;
	private int encabezados_garantia_id;
	private int insatisfacciones_id;
	private int folio_insatisfaccion;
	private String descripcion_insatisfaccion;
	
	public static class DepartamentosId{
		int [] ids;
		
		public DepartamentosId() {
			super();
		}

		public DepartamentosId(int[] ids) {
			super();
			this.ids = ids;
		}

		public int[] getIds() {
			return ids;
		}

		public void setIds(int[] ids) {
			this.ids = ids;
		}
		
		
	}
	
	public DetalleGarantiaVista() {
		super();
	}

	public DetalleGarantiaVista(int id, String descripcion, int lugar, int planta, int activo,
			int encabezados_garantias_id, int detalle_diagnostico_id, String descripcionEncabezado, int lugarEncabezado,
			int garantias_id, int cant_subindices, String procede, String motivo_procede, int creado_por, Date creado,
			int modificado_por, Date modificado, int referencia, Date fecha_terminacion, int personal_terminado_id,
			DepartamentosId departamentos, int encabezados_garantia_id, int insatisfacciones_id,
			int folio_insatisfaccion, String descripcion_insatisfaccion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.planta = planta;
		this.activo = activo;
		this.encabezados_garantias_id = encabezados_garantias_id;
		this.detalle_diagnostico_id = detalle_diagnostico_id;
		this.descripcionEncabezado = descripcionEncabezado;
		this.lugarEncabezado = lugarEncabezado;
		this.garantias_id = garantias_id;
		this.cant_subindices = cant_subindices;
		this.procede = procede;
		this.motivo_procede = motivo_procede;
		this.creado_por = creado_por;
		this.creado = creado;
		this.modificado_por = modificado_por;
		this.modificado = modificado;
		this.referencia = referencia;
		this.fecha_terminacion = fecha_terminacion;
		this.personal_terminado_id = personal_terminado_id;
		this.departamentos = departamentos;
		this.encabezados_garantia_id = encabezados_garantia_id;
		this.insatisfacciones_id = insatisfacciones_id;
		this.folio_insatisfaccion = folio_insatisfaccion;
		this.descripcion_insatisfaccion = descripcion_insatisfaccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getEncabezados_garantias_id() {
		return encabezados_garantias_id;
	}

	public void setEncabezados_garantias_id(int encabezados_garantias_id) {
		this.encabezados_garantias_id = encabezados_garantias_id;
	}

	public String getDescripcionEncabezado() {
		return descripcionEncabezado;
	}

	public void setDescripcionEncabezado(String descripcionEncabezado) {
		this.descripcionEncabezado = descripcionEncabezado;
	}

	public int getLugarEncabezado() {
		return lugarEncabezado;
	}

	public void setLugarEncabezado(int lugarEncabezado) {
		this.lugarEncabezado = lugarEncabezado;
	}

	public int getGarantias_id() {
		return garantias_id;
	}

	public void setGarantias_id(int garantias_id) {
		this.garantias_id = garantias_id;
	}

	public int getCant_subindices() {
		return cant_subindices;
	}

	public void setCant_subindices(int cant_subindices) {
		this.cant_subindices = cant_subindices;
	}

	public int getDetalle_diagnostico_id() {
		return detalle_diagnostico_id;
	}

	public void setDetalle_diagnostico_id(int detalle_diagnostico_id) {
		this.detalle_diagnostico_id = detalle_diagnostico_id;
	}

	public String getProcede() {
		return procede;
	}

	public void setProcede(String procede) {
		this.procede = procede;
	}

	public String getMotivo_procede() {
		return motivo_procede;
	}

	public void setMotivo_procede(String motivo_procede) {
		this.motivo_procede = motivo_procede;
	}

	public int getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(int creado_por) {
		this.creado_por = creado_por;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public int getModificado_por() {
		return modificado_por;
	}

	public void setModificado_por(int modificado_por) {
		this.modificado_por = modificado_por;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public Date getFecha_terminacion() {
		return fecha_terminacion;
	}

	public void setFecha_terminacion(Date fecha_terminacion) {
		this.fecha_terminacion = fecha_terminacion;
	}

	public int getPersonal_terminado_id() {
		return personal_terminado_id;
	}

	public void setPersonal_terminado_id(int personal_terminado_id) {
		this.personal_terminado_id = personal_terminado_id;
	}

	public DepartamentosId getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(DepartamentosId departamentos) {
		this.departamentos = departamentos;
	}

	public int getEncabezados_garantia_id() {
		return encabezados_garantia_id;
	}

	public void setEncabezados_garantia_id(int encabezados_garantia_id) {
		this.encabezados_garantia_id = encabezados_garantia_id;
	}

	public int getInsatisfacciones_id() {
		return insatisfacciones_id;
	}

	public void setInsatisfacciones_id(int insatisfacciones_id) {
		this.insatisfacciones_id = insatisfacciones_id;
	}

	public int getFolio_insatisfaccion() {
		return folio_insatisfaccion;
	}

	public void setFolio_insatisfaccion(int folio_insatisfaccion) {
		this.folio_insatisfaccion = folio_insatisfaccion;
	}

	public String getDescripcion_insatisfaccion() {
		return descripcion_insatisfaccion;
	}

	public void setDescripcion_insatisfaccion(String descripcion_insatisfaccion) {
		this.descripcion_insatisfaccion = descripcion_insatisfaccion;
	}	
	
}
