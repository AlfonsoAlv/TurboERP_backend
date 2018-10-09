package com.turbomaquinas.service.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.general.ActividadAutorizadaDAO;
import com.turbomaquinas.DAO.general.JDBCActividadAutorizada.Facts;
import com.turbomaquinas.DAO.general.ServidorDAO;
import com.turbomaquinas.POJO.general.ActividadAutorizada;
import com.turbomaquinas.POJO.general.ActividadAutorizada.ListaFacts;
import com.turbomaquinas.POJO.general.ActividadAutorizadaFactura;
import com.turbomaquinas.POJO.general.ActividadAutorizadaVista;
import com.turbomaquinas.POJO.general.AutorizadasOrden;
import com.turbomaquinas.POJO.general.DocumentoAAPedidoPrepedido;

@Service
public class LogicaActividadAutorizada implements ActividadAutorizadaService{

	@Autowired
	ActividadAutorizadaDAO repositorio;
	@Autowired
	ServidorDAO repoServidor;
	
	@Override
	public ActividadAutorizadaVista crear(ActividadAutorizada a) throws DataAccessException{
		int id = repositorio.crear(a);
		return repositorio.buscar(id);
	}

	@Override
	public void actualizar(ActividadAutorizada a) throws DataAccessException{
		repositorio.actualizar(a);
	}

	@Override
	public ActividadAutorizadaVista buscar(int id) throws DataAccessException{
		return repositorio.buscar(id);
	}

	@Override
	public List<ActividadAutorizadaVista> consultar() throws DataAccessException{
		return repositorio.consultar();
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorCotizacion(int id) throws DataAccessException {
		return repositorio.consultarPorCotizacion(id);
	}
	
	
	/*@Override
	public void actualizarPedidoPrepedido(DocumentoAAPedidoPrepedido doc) throws DataAccessException {
		int ordenId = repositorio.buscarOrdenPorAA(doc.getActividades().get(0).getId_actividad_autorizada());
		for (PedidoPrepedidoAA aa : doc.getActividades()) {
			String fechaRegulariza = repoServidor.obtenerfecha();
			repositorio.regularizarPedidoPrepedido(ordenId, aa.getId_pedido(), aa.getId_prepedido(), 
					doc.getModificado_por(), fechaRegulariza, aa.getId_actividad_autorizada());
			}
	}*/
	
	public void actualizarPedidoPrepedido(DocumentoAAPedidoPrepedido doc) throws DataAccessException {
		repositorio.regularizarPedidoPrepedido(doc.toString());
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorAutorizacion(int id) throws DataAccessException {
		return repositorio.consultarPorAutorizacion(id);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOrdenFiltradaPorClase(int id, String clase) throws DataAccessException {
		return repositorio.consultarPorOrdenFiltradaPorClase(id, clase);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOrden(int id) throws DataAccessException {
		return repositorio.consultarPorOrden(id);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarAAPorOrdenSinPedido(int id) throws DataAccessException{
		return repositorio.consultarAAPorOrdenSinPedido(id);
	}

	@Override
	public List<ActividadAutorizadaVista> consultarPorOtiSinAceptar(int id)throws DataAccessException{
		return repositorio.consultarPorOtiSinAceptar(id);
	}

	@Override
	public List<ActividadAutorizadaFactura> consultarAAPorOrdenPendienteFacturar(int id) throws DataAccessException{
		return repositorio.consultarAAPorOrdenPendienteFacturar(id);
	}

	@Override
	public void asignarFacts(int id, ListaFacts lista) {
		repositorio.asignarFacts(id, lista);
	}

	@Override
	public List<Facts> consultarFacts(int id) {
		return repositorio.consultarFacts(id);
	}

	@Override
	public List<ActividadAutorizadaFactura> consultarAAPorIds(List<Integer> idsActividades) {
		return repositorio.consultarAAPorIds(idsActividades);
	}

	@Override
	public void actualizarBanderaImpAut(int idOrden_irre, int valorBandera) {
		repositorio.actualizarBanderaImpAut(idOrden_irre,valorBandera);
	}

	@Override
	public List<AutorizadasOrden> consultarPorOrdenSinOIT(int idOrden, String planta, String suministro,
			String tipoActividad) {
		return repositorio.AutorizadasPorOrdenSinOIT(idOrden, planta, suministro, tipoActividad);
	}
}
