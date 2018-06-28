package com.turbomaquinas.service.general;

import java.util.List;

import com.turbomaquinas.DAO.general.JDBCOrden.FoliosOrdenes;
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


public interface OrdenService {
	public OrdenVista crear(Orden o);
	public void actualizar(Orden o);
	public OrdenVista buscar(int id);
	public List<OrdenVista> consultar();
	public OrdenVista buscarOrden(String numeroOrden);
	public List<AreasVista> buscarAreasPorOrden(int id);
	public List<Integer> anioOrden();
	public List<OrdenVista> ordenAnio(int anio);
	public DTOrdenes buscarDatosTecnicos(int id);
	public Autorizacion autorizarActividades(DocumentoActividadesAutorizadas doc, int ordenId);
	public OT buscarporNumero(String numeroOrden);
	public SolicitudDesautorizacionAA desautorizacionActividades(int ordenId, DocumentoSolicitudBajaAA doc);
	public List<FoliosOrdenes> consultarActividadesProduccion(int id);
	public void actualizarAlfresco(int idOrden,String alfrescoID);
	public void actualizarCambioCliente(int id,String cliente);
	public void actualizarCambioMoneda(int id,String moneda);
	public void actualizarClienteOriginal(int id, int clienteId, int modificado_por);
	public void actualizarMonedaOriginal(int id, String moneda, int modificado_por);
	public ClienteVista buscarClienteEspeciales(int id);
	public AtributoEspecialConsulta buscarMonedaEspeciales(int id);
	public ClienteVista buscarClienteFacturacion(int id);
	public AtributoEspecialConsulta buscarMonedaFacturacion(int id);
	public OrdenFechasVista buscarFechasPorOrden (String numOrden);
	public List<OrdenFactura> consultarOrdenAAPendientesFacturar(int id,String moneda,String idClienteFacturar);
	public OrdenFactura buscarOrdenFacturar(int id,String moneda,String idCliente);
	public List<OrdenFactura> consultarOrdenesPorIds(List<Integer> ids, String moneda, String idCliente);
	public List<OrdenFactura> consultarOrdenesPorIdsFactura(List<Integer> ids,int idFactura);
	public List<FacturaFinalVista> consultarFacturas(int id);
	public List<CotizacionVista> consultarCotizacionesAutorizadas(int id);
	public List<OrdenVista> OrdenesporCliente(int id,int anio);
	public List<Integer> anioOrdenCliente(int id);
	public List<PagosConsultaOrdenes> pagosAplicadosOrdenes(int id);
}
