package com.turbomaquinas.service.general;

import java.util.List;

import com.turbomaquinas.POJO.general.Ciudad;
import com.turbomaquinas.POJO.general.Estado;

public interface EstadoService {
	public Estado buscar(String clave);
	public List<Estado> consultar();
	public List<Ciudad> consultarCiudades(int id);
	public Ciudad consultarCiudadPorClaveYEstado(int id, String clave);
}
