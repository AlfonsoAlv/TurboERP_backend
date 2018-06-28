package com.turbomaquinas.DAO.general;

import java.util.List;

import com.turbomaquinas.POJO.general.Ciudad;
import com.turbomaquinas.POJO.general.CiudadVista;

public interface CiudadDAO {
	public int crear(Ciudad c);
	public Ciudad actualizar(Ciudad c);
	public List<Ciudad> consultarPorEstado(int id);
	public CiudadVista buscar(int id);
	public List<CiudadVista> consultar();
	public Ciudad consultarCiudadPorClaveYEstado(int id, String clave);
}
