package com.turbomaquinas.service.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;

public interface InsatisfaccionClienteService {

	public InsatisfaccionClienteVista crear (InsatisfaccionCliente insatisfaccion);
	public InsatisfaccionClienteVista buscar (int id);
	public List<InsatisfaccionClienteVista> consultar();
}
