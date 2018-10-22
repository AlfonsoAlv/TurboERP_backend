package com.turbomaquinas.service.general;

import java.util.List;

import com.turbomaquinas.POJO.general.DocumentoCrearOIT;
import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;

public interface OrdenInicioTrabajoService {
	
	public List<OrdenInicioTrabajoVista> consultarConFiltros(String numero_orden,String prioridad,String estado,String anio,String tipo);
	public List<Integer> anios();
	public void cancelar(int id, int modificado_por);
	public void crear(DocumentoCrearOIT p_obj_act_oit);
}
