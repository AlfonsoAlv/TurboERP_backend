package com.turbomaquinas.service.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;

public interface InsatisfaccionClienteService {

	public InsatisfaccionClienteVista crear (InsatisfaccionCliente insatisfaccion);
	public InsatisfaccionClienteVista buscar (int id);
	public InsatisfaccionClienteVista buscarPorFolio(int folio);
	public List<InsatisfaccionClienteVista> consultar();
	public void actualizarInsatisfaccionCliente (InsatisfaccionCliente insatisfaccion);
	public void crearSeguimiento(SeguimientoInsatisfaccion seguimiento);
}
