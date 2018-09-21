package com.turbomaquinas.service.comercial;

import java.math.BigDecimal;
import java.util.List;

import com.turbomaquinas.POJO.comercial.Cotizacion;
import com.turbomaquinas.POJO.comercial.CotizacionVista;
import com.turbomaquinas.POJO.comercial.DetalleCotizacionVista;
import com.turbomaquinas.POJO.comercial.EncabezadoCotizacionVista;
import com.turbomaquinas.POJO.comercial.SubindiceCotizacionVista;

public interface CotizacionService {
	
	public CotizacionVista crear(Cotizacion c);
	public Cotizacion actualizar(Cotizacion c);
	public CotizacionVista buscar(int id);
	public List<CotizacionVista> consultar();
	public List<EncabezadoCotizacionVista> consultarEncabezados(int id);
	public List<DetalleCotizacionVista> consultarDetalles(int id);
	public List<SubindiceCotizacionVista> consultarSubindices(int id);
	public int consultarCantidadEncabezados(int id);
	public void importar(List<Integer> lista, int id, int creado_por);
	public void actuadescto(int id_cotiza, BigDecimal descuento, int modificado_por);
	public void importardiag(List<Integer> lista, int id, int creado_por);
	public List<Integer> anioCot();
	public List<CotizacionVista> cotAnio(int anio);
	public CotizacionVista buscarCotizacion(String numero);
	public void importarcot(List<Integer> lista, int id, int creado_por);
	public CotizacionVista buscarRevisionCotizacion(String numero, int rev);
	public List<Integer> revisiones(int id);
	public List<CotizacionVista> buscarCotizacionPorPrecotizacion(int id);
	public List<CotizacionVista> buscarCotizacionPorOrden(int id);
	public List<CotizacionVista> buscarCotizacionPorClienteSinAutorizar(String moneda, int id);
	public List<CotizacionVista> buscarCotizacionPorOrdenSinAutorizar(int id);
}
