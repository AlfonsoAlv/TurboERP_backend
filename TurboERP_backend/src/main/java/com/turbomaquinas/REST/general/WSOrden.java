package com.turbomaquinas.REST.general;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.turbomaquinas.JsonViewSerializeUtils;
import com.turbomaquinas.DAO.general.JDBCOrden.FoliosOrdenes;
import com.turbomaquinas.POJO.comercial.ClienteVista;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.AtributoEspecialConsulta;
import com.turbomaquinas.POJO.general.AtributoEspecialConsultaVistaJSON;
import com.turbomaquinas.POJO.general.AtributoEspecialInsercion;
import com.turbomaquinas.POJO.general.AtributoEspecialInsercionVistaJSON;
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
import com.turbomaquinas.service.general.OrdenService;
import com.turbomaquinas.service.general.ServidorService;


@RestController
@RequestMapping("/general/ordenes")
public class WSOrden {

	private static final Log bitacora = LogFactory.getLog(WSOrden.class);
	
	@Autowired
	OrdenService os;
	
	@Autowired
	ServidorService ss;
	
	@PostMapping()
	public ResponseEntity<OrdenVista> crear(@RequestBody Orden orden){
		OrdenVista respuesta = null;
		bitacora.info(orden);
		try{
			 respuesta = os.crear(orden);	
			return new ResponseEntity<OrdenVista>(respuesta, HttpStatus.CREATED);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OrdenVista>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping()
	public ResponseEntity<Void> actualizar(@RequestBody Orden orden){
		bitacora.info(orden);
		try{
			os.actualizar(orden);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdenVista> buscar(@PathVariable("id") int id){
		OrdenVista ov = null;
		try{
			ov = os.buscar(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OrdenVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrdenVista>(ov, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrdenVista>> consultar(){
		List<OrdenVista> ov = null;
		try{
			ov = os.consultar();
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<OrdenVista>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrdenVista>>(ov, HttpStatus.OK);
	}
	
	@GetMapping("/numero")
	public ResponseEntity<OrdenVista> buscarOrden(@RequestParam String numeroOrden){
		OrdenVista ov = null;
		try{
			ov = os.buscarOrden(numeroOrden);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OrdenVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrdenVista>(ov, HttpStatus.OK);
	}
	
	@GetMapping("/numero-orden")
	public ResponseEntity<OT> buscarPorNumero(@RequestParam String numeroOrden){
		OT o = null;
		try{
			o = os.buscarporNumero(numeroOrden);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OT>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OT>(o, HttpStatus.OK);
	}

	@GetMapping("/{id}/areasorden")
	public ResponseEntity<List<AreasVista>> buscarAreasPorOrden(@PathVariable int id){
		List<AreasVista> areaso = os.buscarAreasPorOrden(id);
		if (areaso.isEmpty())
			return new ResponseEntity<List<AreasVista>> (HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<AreasVista>>(areaso, HttpStatus.OK);
	}
	
	@GetMapping("/años")
	public ResponseEntity<List<Integer>> anioOrdenes(){
		List<Integer> anios = os.anioOrden();
		if (anios == null)
			return new ResponseEntity<List<Integer>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Integer>>(anios, HttpStatus.OK);
	}
	
	@GetMapping("/filtradas/{anio}")
	public ResponseEntity<List<OrdenVista>> ordenesAnio(@PathVariable int anio){
		List<OrdenVista> o = os.ordenAnio(anio);
		if (o == null)
			return new ResponseEntity<List<OrdenVista>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<OrdenVista>>(o, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/dtorden")
	public ResponseEntity<DTOrdenes> consultarDatosTecnicos(@PathVariable int id){
		DTOrdenes dto = null;
		try {
			dto = os.buscarDatosTecnicos(id);
		} catch (Exception e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<DTOrdenes> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DTOrdenes> (dto, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/actividadesautorizadas")
	public ResponseEntity<Autorizacion> autorizar(@PathVariable int id, @RequestBody DocumentoActividadesAutorizadas doc){
		// bitacora.info(doc);
		Autorizacion a = null;
		try{
			a = os.autorizarActividades(doc, id);	
			return new ResponseEntity<Autorizacion>(a, HttpStatus.OK);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Autorizacion>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/{id}/bajaactividadautorizada")
	public ResponseEntity<SolicitudDesautorizacionAA> desautorizar(@PathVariable int id, @RequestBody DocumentoSolicitudBajaAA doc){
		SolicitudDesautorizacionAA solicitud;
		try{
			solicitud = os.desautorizacionActividades(id, doc);
			return new ResponseEntity<SolicitudDesautorizacionAA>(solicitud, HttpStatus.OK);
		}catch (DataAccessException e) {
			bitacora.error(e.getMessage());
			return new ResponseEntity<SolicitudDesautorizacionAA>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/{id}/folios")
	public ResponseEntity<List<FoliosOrdenes>> consultarFoliosporOrden(@PathVariable int id){
		
		List<FoliosOrdenes> folio = null;
		try{
			folio = os.consultarActividadesProduccion(id);
		}catch (DataAccessException e) {
				bitacora.error(e.getMessage());
				return new ResponseEntity<List<FoliosOrdenes>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FoliosOrdenes>>(folio, HttpStatus.OK);	
	}
	
	@PutMapping("/{id}/alfresco")
	public ResponseEntity<Void> actualizarAlfresco(@PathVariable("id") int id, @RequestParam String alfrescoId){
		bitacora.info(id);
		try{
			os.actualizarAlfresco(id, alfrescoId);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	@JsonView(AtributoEspecialInsercionVistaJSON.AtributoCliente.class)
	@PutMapping("/{id}/cliente")
	public ResponseEntity<Void> actualizarCambioCliente(@PathVariable int id,@RequestBody AtributoEspecialInsercion cliente) throws JsonProcessingException, IOException{
		String jsonCliente = JsonViewSerializeUtils.serializeObjectToString(cliente, AtributoEspecialInsercionVistaJSON.AtributoCliente.class);
        try{
			os.actualizarCambioCliente(id, jsonCliente);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@JsonView(AtributoEspecialInsercionVistaJSON.AtributoMoneda.class)
	@PutMapping("/{id}/moneda")
	public ResponseEntity<Void> actualizarCambioMoneda(@PathVariable int id,@RequestBody AtributoEspecialInsercion moneda) throws JsonProcessingException, IOException{
		String jsonMoneda = JsonViewSerializeUtils.serializeObjectToString(moneda, AtributoEspecialInsercionVistaJSON.AtributoMoneda.class);
		try{
			os.actualizarCambioMoneda(id, jsonMoneda);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}/clienteoriginal")
	public ResponseEntity<Void> actualizarClienteOriginal(@PathVariable int id, @RequestParam int clienteId,@RequestParam int modificado_por){
		try{
			os.actualizarClienteOriginal(id, clienteId,modificado_por);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}/monedaoriginal")
	public ResponseEntity<Void> actualizarMonedaOriginal(@PathVariable int id, @RequestParam String moneda,@RequestParam int modificado_por){
		try{
			os.actualizarMonedaOriginal(id, moneda,modificado_por);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	
	@GetMapping("/{id}/clientefacturacion")
	public ResponseEntity<ClienteVista> buscarClienteFacturacion(@PathVariable("id") int id){
		ClienteVista cliente = null;
		try{
			cliente = os.buscarClienteFacturacion(id);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<ClienteVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteVista>(cliente, HttpStatus.OK);
	}
	
	@JsonView(AtributoEspecialConsultaVistaJSON.AtributoVistaMoneda.class)
	@GetMapping("/{id}/monedafacturacion")
	public ResponseEntity<AtributoEspecialConsulta> buscarMonedaFacturacion(@PathVariable("id") int id){
		AtributoEspecialConsulta moneda = null;
		try{
			moneda = os.buscarMonedaFacturacion(id);
		}catch(Exception e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<AtributoEspecialConsulta>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AtributoEspecialConsulta>(moneda, HttpStatus.OK);
	}
	
	
	@GetMapping("/fechas")
	public ResponseEntity<OrdenFechasVista> buscarFechasPorOrden(@RequestParam String numOrden){
		OrdenFechasVista of = null;
		try{
			of = os.buscarFechasPorOrden(numOrden);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OrdenFechasVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrdenFechasVista>(of, HttpStatus.OK);
		
	}
	
	@GetMapping("/factura/pendiente/clientes/{id}")
	public ResponseEntity<List<OrdenFactura>> consultarOrdenesAAPendienteFacturar(@PathVariable int id, @RequestParam String moneda,@RequestParam String idClienteFacturar){
		List<OrdenFactura> ordenes=null;
		try{
			ordenes=os.consultarOrdenAAPendientesFacturar(id,moneda,idClienteFacturar);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<OrdenFactura>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrdenFactura>>(ordenes, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/finanzas")
	public ResponseEntity<OrdenFactura> buscarFinanzasOrden(@PathVariable int id){
		OrdenFactura orden=null;
		try{
			orden=os.buscarOrdenFacturar(id,"%","%");
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<OrdenFactura>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<OrdenFactura>(orden, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}/facturas")
	public ResponseEntity<List<FacturaFinalVista>> consultarFacturas(@PathVariable int id){
		List<FacturaFinalVista> facturas=null;
		try{
			facturas=os.consultarFacturas(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NO_CONTENT);
		}
		if(facturas!=null)
			return new ResponseEntity<List<FacturaFinalVista>>(facturas, HttpStatus.OK);
		else
			return new ResponseEntity<List<FacturaFinalVista>>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}/cotizaciones/autorizadas")
	public ResponseEntity<List<CotizacionVista>> consultarCotizacionesAutorizadas(@PathVariable int id){
		List<CotizacionVista> cotizaciones = null;
		try{
			cotizaciones = os.consultarCotizacionesAutorizadas(id);
		}catch(DataAccessException e){
			bitacora.error(e.getMessage());
			return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NO_CONTENT);
		}
		if(cotizaciones.isEmpty()){
			return new ResponseEntity<List<CotizacionVista>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CotizacionVista>>(cotizaciones, HttpStatus.OK);
	}
	
	@GetMapping("/cliente/{id}/filtradas/{anio}")
	public ResponseEntity<List<OrdenVista>> ordenesCliente(@PathVariable int id,@PathVariable int anio){
		List<OrdenVista> o = os.OrdenesporCliente(id,anio);
		if (o == null)
			return new ResponseEntity<List<OrdenVista>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<OrdenVista>>(o, HttpStatus.OK);
	}
	
	@GetMapping("/años/cliente/{id}")
	public ResponseEntity<List<Integer>> anios(@PathVariable int id){
		List<Integer> anios = os.anioOrdenCliente(id);
		if (anios == null)
			return new ResponseEntity<List<Integer>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Integer>>(anios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/pagosaplicados")
	public ResponseEntity<List<PagosConsultaOrdenes>> pagosAplicados(@PathVariable int id){
		List<PagosConsultaOrdenes> pco = os.pagosAplicadosOrdenes(id);
		if (pco == null)
			return new ResponseEntity<List<PagosConsultaOrdenes>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<PagosConsultaOrdenes>>(pco, HttpStatus.OK);
	}
	
}
