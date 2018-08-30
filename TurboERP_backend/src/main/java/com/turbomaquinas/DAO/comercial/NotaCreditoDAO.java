package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.NotaCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;

public interface NotaCreditoDAO {

	public int crearNotasCredito(String doc);
	public void actualizar(NotaCredito nc);
	public NotaCreditoVista buscar(int id);
	public List<NotaCreditoVista> consultar();
	public void RestablecerNotaCredito(int id, int modificado_por);
	public void actualizarNumero(int id, int opcion);
	public String obtenerJSONTimbrado(int id, String modo);
	public NotaCreditoVista buscarPorNumero(int numero);
	public List<NotaCreditoVista> consultarSinTimbrar();
	public Integer buscarUltimoId();
	public void actualizarEstado(int id, String estado);
	public void actualizarTipoCambio(int id, float tipoCambio);
	public void actualizarIdDatosTimbrados(int id, int idDatosTimbrados);
	public String obtenerMoneda(int nc_id);
	public List<NotaCreditoVista> consultarPorFecha(String fechainicio, String fechafin, String estado);
	public String obtenerJSONCancelarNotaCredito(int idNota, String modo, String justificacion);
	public String obtenerJSONBuscarNotaCredito(int idNota, String modo);
	public void cancelar(int id, int modificado_por);
	
}
