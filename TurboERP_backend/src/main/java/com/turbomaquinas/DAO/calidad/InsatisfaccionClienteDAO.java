package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;

public interface InsatisfaccionClienteDAO {
	
	public int crear(InsatisfaccionCliente insatisfaccion);
	public InsatisfaccionClienteVista buscar(int id);
	public List<InsatisfaccionClienteVista> consultar();

}
