package com.turbomaquinas.DAO.general;

import java.util.List;

import com.turbomaquinas.POJO.general.OrdenInicioTrabajoVista;

public interface OrdenInicioTrabajoDAO {
	public List<OrdenInicioTrabajoVista> consultarConFiltros(String numero_orden,String prioridad,String estado,String anio,String tipo);
	public List<Integer> anios();
	public void cancelar(int id, int modificado_por);
	public void crearOIT (String p_obj_act_oit);
}
