package com.turbomaquinas.service.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.ClienteDAO;
import com.turbomaquinas.DAO.comercial.FacturaFinalDAO;
import com.turbomaquinas.DAO.general.ActividadAutorizadaDAO;
import com.turbomaquinas.DAO.general.AutorizacionDAO;
import com.turbomaquinas.DAO.general.DTOrdenesDAO;
import com.turbomaquinas.DAO.general.JDBCOrden.FoliosOrdenes;
import com.turbomaquinas.DAO.general.OrdenDAO;
import com.turbomaquinas.DAO.general.SolicitudDesautorizacionAADAO;
import com.turbomaquinas.DAO.produccion.AreasVistaDAO;
import com.turbomaquinas.POJO.comercial.ClienteVista;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.AtributoEspecialConsulta;
import com.turbomaquinas.POJO.general.Autorizacion;
import com.turbomaquinas.POJO.general.DTOrdenes;
import com.turbomaquinas.POJO.general.DocumentoActividadesAutorizadas;
import com.turbomaquinas.POJO.general.DocumentoSolicitudBajaAA;
import com.turbomaquinas.POJO.general.OT;
import com.turbomaquinas.POJO.general.Orden;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.POJO.general.OrdenFechasVista;
import com.turbomaquinas.POJO.general.OrdenVista;
import com.turbomaquinas.POJO.general.PagosConsultaOrdenes;
import com.turbomaquinas.POJO.general.SolicitudDesautorizacionAA;
import com.turbomaquinas.POJO.produccion.AreasVista;

@Service
public class LogicaOrdenService implements OrdenService{

	@Autowired
	OrdenDAO repositorio;
	@Autowired
	AreasVistaDAO repoAreasOrden;
	@Autowired
	DTOrdenesDAO repoDT;
	@Autowired
	SolicitudDesautorizacionAADAO repoSol;
	@Autowired
	ActividadAutorizadaDAO repoAA;
	@Autowired
	AutorizacionDAO repoAutoriza;
	@Autowired
	ClienteDAO repoCliente;
	@Autowired
	FacturaFinalDAO repoFacturaFinal;
	
	@Override
	public OrdenVista crear(Orden o) throws DataAccessException{
		int id = repositorio.crear(o);
		return repositorio.buscar(id);
	}
	
	@Override
	public void actualizar(Orden o) throws DataAccessException{
		repositorio.actualizar(o);
	}

	@Override
	public OrdenVista buscar(int id) throws DataAccessException{
		return repositorio.buscar(id);
	}


	@Override
	public List<OrdenVista> consultar() throws DataAccessException{
		return repositorio.consultar();
	}

	@Override
	public OrdenVista buscarOrden(String numeroOrden) throws DataAccessException {
		return repositorio.buscarOrden(numeroOrden);
	}

	@Override
	public List<AreasVista> buscarAreasPorOrden(int id) throws DataAccessException {
		return repoAreasOrden.buscarPorOrden(id);
	}

	@Override
	public List<Integer> anioOrden() throws DataAccessException{
		return repositorio.anioOrden();
	}

	@Override
	public List<OrdenVista> ordenAnio(int anio) throws DataAccessException{
		return repositorio.ordenAnio(anio);
	}

	@Override
	public DTOrdenes buscarDatosTecnicos(int id) throws DataAccessException {
		return repoDT.buscarPorOrden(id);
	}

	@Override
	public Autorizacion autorizarActividades(DocumentoActividadesAutorizadas doc, int ordenId) throws DataAccessException {
		int id = repositorio.autorizarActividades(ordenId, doc.toString());
		return repoAutoriza.buscar(id);
	}

	@Override
	public OT buscarporNumero(String numeroOrden) throws DataAccessException {
		return repositorio.buscarPorNumero(numeroOrden);
	}

	@Override
	@Transactional
	public SolicitudDesautorizacionAA desautorizacionActividades(int ordenId, DocumentoSolicitudBajaAA doc) throws DataAccessException {
		int id = repoSol.crear(ordenId, doc.getMotivo(), doc.getTipo(), doc.getCreado_por());
		repoAA.actualizarSolicitudBaja(id, doc.getActividades_ids());
		return repoSol.buscar(id);
	}

	@Override
	public List<FoliosOrdenes> consultarActividadesProduccion(int id) throws DataAccessException{
		
		return repositorio.consultarFoliosporOrden(id);
	}

	@Override
	public void actualizarAlfresco(int idOrden,String alfrescoID) throws DataAccessException{
		repositorio.actualizarAlfresco(idOrden,alfrescoID);
		
	}

	
	@Override
	public void actualizarCambioCliente(int id,String cliente) throws DataAccessException{
		repositorio.actualizarCambioCliente(id,cliente);		
	}
	
	@Override
	public void actualizarCambioMoneda(int id,String moneda) throws DataAccessException{
		repositorio.actualizarCambioMoneda(id,moneda);		
	}

	@Override
	public void actualizarClienteOriginal(int id, int clienteId, int modificado_por) throws DataAccessException{
		repositorio.actualizarClienteOriginal(id,clienteId,modificado_por);
	}
	
	@Override
	public void actualizarMonedaOriginal(int id, String moneda, int modificado_por) throws DataAccessException{
		repositorio.actualizarMonedaOriginal(id,moneda,modificado_por);
	}

	@Override
	public ClienteVista buscarClienteEspeciales(int id) throws DataAccessException{
		return repoCliente.buscar(Integer.parseInt(repositorio.buscarClienteEspeciales(id).valor));
	}
	
	@Override
	public AtributoEspecialConsulta buscarMonedaEspeciales(int id) throws DataAccessException{
		return repositorio.buscarMonedaEspeciales(id);
	}
	
	@Override
	public ClienteVista buscarClienteFacturacion(int id){
		AtributoEspecialConsulta cliente=repositorio.buscarClienteEspeciales(id);
		if(cliente!=null){
			return repoCliente.buscar(Integer.parseInt(cliente.valor));
		}else{
			return repoCliente.buscar(repositorio.buscar(id).getClientes_id());
		}
	}
	
	@Override
	public AtributoEspecialConsulta buscarMonedaFacturacion(int id){
		AtributoEspecialConsulta moneda=repositorio.buscarMonedaEspeciales(id);
		if(moneda!=null){
			return moneda;
		}else{
			OrdenVista orden=repositorio.buscar(id);	
			AtributoEspecialConsulta mon=new AtributoEspecialConsulta();
			mon.atributo="MONEDA";
			mon.valor=orden.getMoneda();
			mon.creado_por=orden.getCreado_por();
			mon.fecha=orden.getCreado();
			mon.tipo_cambio=1;
			mon.tipo_cambio_calculado=1;
			return mon;
		}
	}

	@Override
	public OrdenFechasVista buscarFechasPorOrden(String numOrden) throws DataAccessException{
		return repositorio.buscarFechasPorOrden(numOrden);
	}
	
	@Override
	public List<OrdenFactura> consultarOrdenAAPendientesFacturar(int id,String moneda,String idClienteFacturar) throws DataAccessException{
		return consultarOrdenesPorIds(repositorio.consultarOrdenAAPendientesFacturar(id),moneda,idClienteFacturar);
	}
	
	@Override
	public List<OrdenFactura> consultarOrdenesPorIds(List<Integer> ids,String moneda,String idClienteFacturar) throws DataAccessException{
		List<OrdenFactura> o=new ArrayList<OrdenFactura>();
		for(int i: ids){
			OrdenFactura orden=repositorio.buscarDatosFacturacion(i,moneda,idClienteFacturar);
			if(orden!=null){
				o.add(orden);
			}			
		}
		return o;
	}
	
	@Override
	public OrdenFactura buscarOrdenFacturar(int id,String moneda,String idCliente) throws DataAccessException{
		return repositorio.buscarDatosFacturacion(id,moneda,idCliente);		
	}
	
	@Override
	public List<OrdenFactura> consultarOrdenesPorIdsFactura(List<Integer> ids,int idFactura) throws DataAccessException{
		List<OrdenFactura> o=new ArrayList<OrdenFactura>();
		for(int i: ids){
			OrdenFactura orden=repositorio.buscarDatosFacturacion(i,idFactura);
			if(orden!=null){
				o.add(orden);
			}			
		}
		return o;
	}

	@Override
	public List<FacturaFinalVista> consultarFacturas(int id) {
		List<Integer> ids=repositorio.consultarIdsFacturas(id);
		if(ids!=null){
			return repoFacturaFinal.consultarFacturasPorIds(ids);
		}else{
			return null;
		}
		
	}

	@Override
	public List<CotizacionVista> consultarCotizacionesAutorizadas(int id) {
		return repositorio.consultarCotizacionesAutorizadas(id);
	}

	@Override
	public List<OrdenVista> OrdenesporCliente(int id,int anio) {
		
		return repositorio.OrdenesporCliente(id,anio);
	}

	@Override
	public List<Integer> anioOrdenCliente(int id) throws DataAccessException{
		return repositorio.anioOrdenCliente(id);
	}

	@Override
	public List<PagosConsultaOrdenes> pagosAplicadosOrdenes(int id) {
		return repositorio.PagosporOrden(id);
	}
	
}
