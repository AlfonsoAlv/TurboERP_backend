package com.turbomaquinas.service.general;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.turbomaquinas.DAO.general.JDBCActividadAutorizada.Facts;
import com.turbomaquinas.POJO.general.ActividadAutorizada;
import com.turbomaquinas.POJO.general.ActividadAutorizada.ListaFacts;
import com.turbomaquinas.POJO.general.ActividadAutorizadaFactura;
import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;
import com.turbomaquinas.POJO.general.AutorizadasOrden;
import com.turbomaquinas.POJO.general.DocumentoAAPedidoPrepedido;

public interface ActividadAutorizadaService {
	public ActividadAutorizadaVista crear(ActividadAutorizada a);
	public void actualizar(ActividadAutorizada a);
	public ActividadAutorizadaVista buscar(int id);
	public List<ActividadAutorizadaVista> consultar();
	public List<ActividadAutorizadaVista> consultarPorAutorizacion(int id);
	public List<ActividadAutorizadaVista> consultarPorCotizacion(int id);
	//public void actualizarPedidoPrepedido(DocumentoAAPedidoPrepedido doc);
	public void actualizarPedidoPrepedido(DocumentoAAPedidoPrepedido doc);
	public List<ActividadAutorizadaVista> consultarPorOrdenFiltradaPorClase(int id, String clase);
	public List<ActividadAutorizadaVista> consultarPorOrden(int id);
	public List<ActividadAutorizadaVista> consultarAAPorOrdenSinPedido(int id);
	public List<ActividadAutorizadaVista> consultarPorOtiSinAceptar(int id);
	public List<ActividadAutorizadaFactura> consultarAAPorOrdenPendienteFacturar(int id) throws DataAccessException;
	public void asignarFacts(int id, ListaFacts lista);
	public List<Facts> consultarFacts(int id);
	public List<ActividadAutorizadaFactura> consultarAAPorIds(List<Integer> idsActividades);
	public void actualizarBanderaImpAut(int idOrden_irre, int valorBandera);
	public List<AutorizadasOrden> consultarPorOrdenSinOIT(int idOrden, String planta, String suministro, String tipoActividad);
}
