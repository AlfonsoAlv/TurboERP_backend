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
	public List<NotaCreditoVista> consultarPorFecha(String fechainicio, String fechafin, String estado);
}
