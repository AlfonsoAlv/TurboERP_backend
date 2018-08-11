package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;

public interface InsatisfaccionClienteDAO {
	
	public int crear(InsatisfaccionCliente insatisfaccion);
	public InsatisfaccionClienteVista buscar(int id);
	public InsatisfaccionClienteVista buscarPorFolio(int folio);
	public List<InsatisfaccionClienteVista> consultar();
	public void actualizar(InsatisfaccionCliente insatisfaccion);
	public void crearSeguimiento(SeguimientoInsatisfaccion seguimiento);
}
