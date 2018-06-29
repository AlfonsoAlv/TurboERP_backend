package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletes;
import com.turbomaquinas.POJO.comercial.EquipoSolicitudFletesVista;

public interface EquipoSolicitudFletesDAO {
	
	public int crear(EquipoSolicitudFletes esf);
	public List<EquipoSolicitudFletesVista> consultarPorCliente(int id);
	public EquipoSolicitudFletes buscar(int id);
	
}
