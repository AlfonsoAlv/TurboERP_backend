package com.turbomaquinas.service.comercial;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turbomaquinas.DAO.comercial.CotizacionDAO;
import com.turbomaquinas.DAO.comercial.DetalleCotizacionDAO;
import com.turbomaquinas.DAO.comercial.DetallePrecotizacionDAO;
import com.turbomaquinas.DAO.comercial.EncabezadoCotizacionDAO;
import com.turbomaquinas.DAO.comercial.EncabezadoPrecotizacionDAO;
import com.turbomaquinas.DAO.comercial.SubindiceCotizacionDAO;
import com.turbomaquinas.DAO.comercial.SubindicePrecotizacionDAO;
import com.turbomaquinas.DAO.diagnostico.DetalleDiagnosticoDAO;
import com.turbomaquinas.DAO.diagnostico.EncabezadoDiagnosticoDAO;
import com.turbomaquinas.DAO.diagnostico.SubindiceDiagnosticoDAO;
import com.turbomaquinas.POJO.comercial.Cotizacion;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.comercial.DetalleCotizacion;
import com.turbomaquinas.POJO.comercial.DetalleCotizacionVista;
import com.turbomaquinas.POJO.comercial.DetallePrecotizacionVista;
import com.turbomaquinas.POJO.comercial.EncabezadoCotizacion;
import com.turbomaquinas.POJO.comercial.EncabezadoCotizacionVista;
import com.turbomaquinas.POJO.comercial.EncabezadoPrecotizacionVista;
import com.turbomaquinas.POJO.comercial.SubindiceCotizacion;
import com.turbomaquinas.POJO.comercial.SubindiceCotizacionVista;
import com.turbomaquinas.POJO.comercial.SubindicePrecotizacionVista;
import com.turbomaquinas.POJO.diagnostico.DetalleDiagnosticoVista;
import com.turbomaquinas.POJO.diagnostico.EncabezadoDiagnosticoVista;
import com.turbomaquinas.POJO.diagnostico.SubindiceDiagnosticoVista;

@Service
public class LogicaCotizacion implements CotizacionService {

	@Autowired
	CotizacionDAO repCotiza;

	@Autowired
	EncabezadoCotizacionDAO repoEncabezado;
	@Autowired
	EncabezadoCotizacionService serEncabezado;

	@Autowired
	DetalleCotizacionDAO repoDetalles;
	@Autowired
	DetalleCotizacionService serDetalles;
	
	@Autowired
	SubindiceCotizacionDAO repoSubindices;
	@Autowired
	SubindiceCotizacionService serSubindice;
	
	@Autowired
	EncabezadoPrecotizacionDAO repoEncaPre;
	@Autowired
	DetallePrecotizacionDAO repoDetPre;
	@Autowired
	SubindicePrecotizacionDAO repoSubPre;
	
	@Autowired
	EncabezadoDiagnosticoDAO repoEncaDiag;
	@Autowired
	DetalleDiagnosticoDAO repoDetDiag;
	@Autowired
	SubindiceDiagnosticoDAO repoSubDiag;
	
	@Override
	public CotizacionVista crear(Cotizacion c) throws DataAccessException {
		int id = 0;
		if (c.getCotizaciones_id_original() == 0){
			c.setRevision(0);
			id = repCotiza.crear(c);
			repCotiza.actualizarReferencia(id, id);
		} else{
			c.setRevision(repCotiza.consultarRevision(c.getCotizaciones_id_original()) + 1); 
			id = repCotiza.crear(c);
		}
		return repCotiza.buscar(id);
	}

	@Override
	public Cotizacion actualizar(Cotizacion c) throws DataAccessException {
		return repCotiza.actualizar(c);
	}

	@Override
	public CotizacionVista buscar(int id) throws DataAccessException {
		return repCotiza.buscar(id);
	}

	@Override
	public List<CotizacionVista> consultar() throws DataAccessException {
		return repCotiza.consultar();
	}

	@Override
	public List<EncabezadoCotizacionVista> consultarEncabezados(int id) throws DataAccessException {
		return repoEncabezado.consultarPorCotizacion(id);
	}

	@Override
	public List<DetalleCotizacionVista> consultarDetalles(int id) throws DataAccessException {
		return repoDetalles.consultarPorCotizacion(id);
	}

	@Override
	public List<SubindiceCotizacionVista> consultarSubindices(int id) throws DataAccessException {
		return repoSubindices.consultarPorCotizacion(id);
	}

	@Override
	public int consultarCantidadEncabezados(int id) throws DataAccessException {
		return repoEncabezado.consultarCantidadporCotizacion(id);
	}

	@Override
	@Transactional
	public void importar(List<Integer> lista, int id_cotiza, int creado_por) {
		
		for (Integer id : lista) {
			EncabezadoPrecotizacionVista encabezado = repoEncaPre.buscar(id);
			EncabezadoCotizacion enca_cotiza = new EncabezadoCotizacion();
			enca_cotiza.setDescripcion(encabezado.getDescripcion());
			enca_cotiza.setCotizaciones_id(id_cotiza);
			enca_cotiza.setCreado_por(creado_por);
			enca_cotiza.setEncabezados_diagnostico_id(0);
			enca_cotiza.setEncabezados_precotizaciones_id(encabezado.getId());
//			int id_enca = repoEncabezado.crear(enca_cotiza);
			int id_enca = (serEncabezado.crear(enca_cotiza)).getId();
			
			List<DetallePrecotizacionVista> listadetalles = repoDetPre.consultarPorEncabezado(id);
			
			for (DetallePrecotizacionVista detalle : listadetalles) {
				DetalleCotizacion deta_cotiza = new DetalleCotizacion();
				deta_cotiza.setDescripcion(detalle.getDescripcion());
				deta_cotiza.setTipo_actividad(detalle.getTipoActividad());
				deta_cotiza.setSuministro(detalle.getSuministro());
				deta_cotiza.setPlanta(detalle.getPlanta());
				deta_cotiza.setClase_actividad("N");
				deta_cotiza.setImporte(new BigDecimal(0));
				deta_cotiza.setCreado_por(creado_por);
				deta_cotiza.setEncabezados_cotizaciones_id(id_enca);
//				int id_deta = repoDetalles.crear(deta_cotiza);
				int id_deta = (serDetalles.crear(deta_cotiza)).getId();
				
				List<SubindicePrecotizacionVista> listasubindices = repoSubPre.consultarPorDetalle(detalle.getId());
				
				for (SubindicePrecotizacionVista subindice : listasubindices) {
					SubindiceCotizacion sub_cotiza = new SubindiceCotizacion();
					sub_cotiza.setDescripcion(subindice.getDescripcion());
					sub_cotiza.setTipo_actividad(subindice.getTipo_actividad());
					sub_cotiza.setImporte(new BigDecimal(0.0));
					sub_cotiza.setCreado_por(creado_por);
					sub_cotiza.setDetalle_cotizaciones_id(id_deta);
//					repoSubindices.crear(sub_cotiza);
					serSubindice.crear(sub_cotiza);
				}
			}
		}
	}

	@Override
	public void actuadescto(int id_cotiza, BigDecimal descuento, int modificado_por) {
		Cotizacion cotiza = new Cotizacion();
		cotiza.setId(id_cotiza);
		cotiza.setDescuento((BigDecimal)descuento);
		cotiza.setModificado_por(modificado_por);
		repCotiza.actuadescto(cotiza);
	}

	@Transactional
	@Override
	public void importardiag(List<Integer> lista, int id_cotiza, int creado_por) {
		for (Integer id : lista) {
			EncabezadoDiagnosticoVista encabezado = repoEncaDiag.buscar(id);
			EncabezadoCotizacion enca_cotiza = new EncabezadoCotizacion();
			enca_cotiza.setDescripcion(encabezado.getDescripcion());
			enca_cotiza.setCotizaciones_id(id_cotiza);
			enca_cotiza.setCreado_por(creado_por);
			enca_cotiza.setEncabezados_diagnostico_id(encabezado.getId());
			enca_cotiza.setEncabezados_precotizaciones_id(0);
			int id_enca = (serEncabezado.crear(enca_cotiza)).getId();
			
			List<DetalleDiagnosticoVista> listadetalles = repoDetDiag.consultarPorEncabezado(id);
			
			for (DetalleDiagnosticoVista detalle : listadetalles) {
				DetalleCotizacion deta_cotiza = new DetalleCotizacion();
				deta_cotiza.setDescripcion(detalle.getDescripcion());
				deta_cotiza.setTipo_actividad(detalle.getTipo_actividad());
				deta_cotiza.setSuministro(detalle.getSuministro());
				deta_cotiza.setPlanta(1);
				deta_cotiza.setClase_actividad("N");
				deta_cotiza.setImporte(new BigDecimal(0));
				deta_cotiza.setCreado_por(creado_por);
				deta_cotiza.setEncabezados_cotizaciones_id(id_enca);
				deta_cotiza.setDetalle_diagnostico_id(detalle.getId());
				int id_deta = (serDetalles.crear(deta_cotiza)).getId();
				
				List<SubindiceDiagnosticoVista> listasubindices = repoSubDiag.consultarPorDetalle(detalle.getId());
				
				for (SubindiceDiagnosticoVista subindice : listasubindices) {
					SubindiceCotizacion sub_cotiza = new SubindiceCotizacion();
					sub_cotiza.setDescripcion(subindice.getDescripcion());
					sub_cotiza.setTipo_actividad(subindice.getTipo_actividad());
					sub_cotiza.setImporte(new BigDecimal(0.0));
					sub_cotiza.setCreado_por(creado_por);
					sub_cotiza.setDetalle_cotizaciones_id(id_deta);
					serSubindice.crear(sub_cotiza);
				}
			}
		}
	}
	
	@Override
	public List<Integer> anioCot() throws DataAccessException{
		return repCotiza.anioCot();
	}

	@Override
	public List<CotizacionVista> cotAnio(int anio) throws DataAccessException{
		return repCotiza.cotAnio(anio);
	}

	@Override
	public CotizacionVista buscarCotizacion(String numero) throws DataAccessException{
		return repCotiza.buscarCotizacion(numero);
	}

	@Override
	public void importarcot(List<Integer> lista, int id_cotiza, int creado_por) {
		for (Integer id : lista) {
			EncabezadoCotizacionVista encabezado = repoEncabezado.buscar(id);
			EncabezadoCotizacion enca_cotiza = new EncabezadoCotizacion();
			enca_cotiza.setDescripcion(encabezado.getDescripcion());
			enca_cotiza.setCotizaciones_id(id_cotiza);
			enca_cotiza.setCreado_por(creado_por);
			enca_cotiza.setEncabezados_diagnostico_id(encabezado.getEncabezados_diagnostico_id());
			enca_cotiza.setEncabezados_precotizaciones_id(encabezado.getEncabezados_precotizaciones_id());
			int id_enca = (serEncabezado.crear(enca_cotiza)).getId();
			
			List<DetalleCotizacionVista> listadetalles = repoDetalles.consultarPorEncabezado(id);

			for (DetalleCotizacionVista detalle : listadetalles) {
				DetalleCotizacion deta_cotiza = new DetalleCotizacion();
				deta_cotiza.setDescripcion(detalle.getDescripcion());
				deta_cotiza.setTipo_actividad(detalle.getTipo_actividad());
				deta_cotiza.setSuministro(detalle.getSuministro());
				deta_cotiza.setPlanta(detalle.getPlanta());
				deta_cotiza.setClase_actividad("N");
				deta_cotiza.setImporte(detalle.getImporte());
				deta_cotiza.setCreado_por(creado_por);
				deta_cotiza.setEncabezados_cotizaciones_id(id_enca);
				deta_cotiza.setDetalle_diagnostico_id(detalle.getDetalle_diagnostico_id());
				int id_deta = (serDetalles.crear(deta_cotiza)).getId();
				
				List<SubindiceCotizacionVista> listasubindices = repoSubindices.consultarPorDetalle(detalle.getId());
				
				for (SubindiceCotizacionVista subindice : listasubindices) {
					SubindiceCotizacion sub_cotiza = new SubindiceCotizacion();
					sub_cotiza.setDescripcion(subindice.getDescripcion());
					sub_cotiza.setTipo_actividad(subindice.getTipo_actividad());
					sub_cotiza.setImporte(subindice.getImporte());
					sub_cotiza.setCreado_por(creado_por);
					sub_cotiza.setDetalle_cotizaciones_id(id_deta);
					serSubindice.crear(sub_cotiza);
				}
			}
		}
	}

	@Override
	public CotizacionVista buscarRevisionCotizacion(String numero, int rev) throws DataAccessException {
		return repCotiza.buscarRevisionCotizacion(numero, rev);
	}

	@Override
	public List<Integer> revisiones(int id) throws DataAccessException{
		return repCotiza.revisiones(id);
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorPrecotizacion(int id) throws DataAccessException {
		return repCotiza.buscarCotizacionPorPrecotizacion(id);
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorOrden(int id) throws DataAccessException {
		return repCotiza.buscarCotizacionPorOrden(id);
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorClienteSinAutorizar(String moneda, int id) {
		return repCotiza.buscarCotizacionPorClienteSinAutorizar(moneda, id);
	}

	@Override
	public List<CotizacionVista> buscarCotizacionPorOrdenSinAutorizar(int id) {
		return repCotiza.buscarCotizacionPorOrdenSinAutorizar(id);
	}

}
