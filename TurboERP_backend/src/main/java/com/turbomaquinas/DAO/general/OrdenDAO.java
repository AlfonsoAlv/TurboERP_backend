package com.turbomaquinas.DAO.general;


import java.math.BigDecimal;
import java.util.List;

import com.turbomaquinas.DAO.general.JDBCOrden.FoliosOrdenes;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.general.AtributoEspecialConsulta;
import com.turbomaquinas.POJO.general.OT;
import com.turbomaquinas.POJO.general.Orden;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.POJO.general.OrdenFechasVista;
import com.turbomaquinas.POJO.general.OrdenVista;
import com.turbomaquinas.POJO.general.PagosConsultaOrdenes;

public interface OrdenDAO {
	public int crear(Orden o);
	public void actualizar(Orden o);
	public OrdenVista buscar(int id);
	public List<OrdenVista> consultar();
	public OrdenVista buscarOrden(String numeroOrden);
	public List<Integer> anioOrden();
	public List<OrdenVista> ordenAnio(int anio);
	public void actualizarMoneda(int id, String moneda);
	public OT buscarPorNumero(String numero);
	public int autorizarActividades(int ordenId, String doc);
	public List<FoliosOrdenes> consultarFoliosporOrden(int id);
	public void actualizarAlfresco(int idOrden, String alfresco_id);
	public void actualizarCambioCliente(int id,String cliente);
	public void actualizarCambioMoneda(int id,String moneda);
	public void actualizarClienteOriginal(int id, int clienteId, int modificado_por);
	public void actualizarMonedaOriginal(int id, String moneda, int modificado_por);
	public AtributoEspecialConsulta buscarClienteEspeciales(int id);
	public AtributoEspecialConsulta buscarMonedaEspeciales(int id);
	public OrdenFechasVista buscarFechasPorOrden (String numOrden);
	public List<Integer> consultarOrdenAAPendientesFacturar(int idCliente); 
	public OrdenFactura buscarDatosFacturacion(int orden_id,String moneda,String idClienteFacturar);
	public OrdenFactura buscarDatosFacturacion(int orden_id,int idFactura);
	public void sumarImporteBaja(int orden_id, BigDecimal importe_baja);
	public void restarImporteAutorizado(int orden_id, BigDecimal importe_autorizado);
	public List<Integer> consultarIdsFacturas(int orden_id);
	public List<CotizacionVista> consultarCotizacionesAutorizadas(int id);
	public List<OrdenVista> OrdenesporCliente(int idCliente,int anio);
	public List<Integer> anioOrdenCliente(int idCliente);
	public List<PagosConsultaOrdenes> PagosporOrden(int idOrden);
}
