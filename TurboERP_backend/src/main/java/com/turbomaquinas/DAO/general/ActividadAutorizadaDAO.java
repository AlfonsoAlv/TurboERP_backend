package com.turbomaquinas.DAO.general;

import java.util.List;

import com.turbomaquinas.DAO.general.JDBCActividadAutorizada.Facts;
import com.turbomaquinas.POJO.general.ActividadAutorizada;
import com.turbomaquinas.POJO.general.ActividadAutorizada.ListaFacts;
import com.turbomaquinas.POJO.general.ActividadAutorizadaFactura;
import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;

public interface ActividadAutorizadaDAO {
	public int crear(ActividadAutorizada a);
	public void actualizar(ActividadAutorizada a);
	public ActividadAutorizadaVista buscar(int id);
	public List<ActividadAutorizadaVista> consultar();
	public List<ActividadAutorizadaVista> consultarPorAutorizacion(int id);
	public List<ActividadAutorizadaVista> consultarPorCotizacion(int id);
	//public void regularizarPedidoPrepedido(int ordenId,int pedidosid, int prepedidosid, int modificadopor, String fecharegularizacion, int id);
	public void regularizarPedidoPrepedido(String jsonRegularizar);
	public List<ActividadAutorizadaVista> consultarPorOrdenFiltradaPorClase(int id, String clase);
	public List<ActividadAutorizadaVista> consultarPorOrden(int id);
	public void actualizarSolicitudBaja(int idSolicitud, List<Integer> actividadesIds);
	public List<ActividadAutorizadaVista> consultarAAPorOrdenSinPedido(int id);
	public void actualizarOTIrregular(int ordenId, int idOTirregular, List<Integer> actividadesIds);
	public List<ActividadAutorizadaVista> consultarPorOtiSinAceptar(int id);
	public List<ActividadAutorizadaFactura> consultarAAPorOrdenPendienteFacturar(int id);
	public void asignarFacts(int id, ListaFacts lista);
	public List<Facts> consultarFacts(int id);
	public int buscarOrdenPorAAOTI(Integer idAA);
	public int buscarOrdenPorAA(int id_actividad_autorizada);
	public List<ActividadAutorizadaFactura> consultarAAPorIds(List<Integer> actividadesIds);
	public void actualizarImporteBaja(int id);
	public void desactivarAAPorSolicitud(int idSolicitud);

}
