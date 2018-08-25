package com.turbomaquinas.DAO.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.InsatisfaccionCliente;
import com.turbomaquinas.POJO.calidad.InsatisfaccionClienteVista;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccion;
import com.turbomaquinas.POJO.calidad.SeguimientoInsatisfaccionVista;

public interface InsatisfaccionClienteDAO {
	
	public int crear(InsatisfaccionCliente insatisfaccion);
	public InsatisfaccionClienteVista buscar(int id);
	public InsatisfaccionClienteVista buscarPorFolio(int folio);
	public List<InsatisfaccionClienteVista> consultar();
	public void actualizar(InsatisfaccionCliente insatisfaccion);
	public int crearSeguimiento(SeguimientoInsatisfaccion seguimiento);
	public List<SeguimientoInsatisfaccion> consultarSeguimientos(int id);
	public SeguimientoInsatisfaccionVista buscarSeguimiento(int id);
	public void agregarDocumentoAlfresco(int id, String alfresco_id, int creado_por,String descripcion);
	public List<InsatisfaccionClienteVista> consultarPorFiltros(String estado, String numero_orden,String fecha_inicio,String fecha_fin);
	public void actualizarEstado(int id,String estado);
	public List<InsatisfaccionClienteVista> consultarPorOrden(String numeroOrden);
}
