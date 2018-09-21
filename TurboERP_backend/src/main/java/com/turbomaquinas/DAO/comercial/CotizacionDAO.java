package com.turbomaquinas.DAO.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.Cotizacion;
import com.turbomaquinas.POJO.comercial.CotizacionVista;

public interface CotizacionDAO {

	public int crear(Cotizacion c);
	public Cotizacion actualizar(Cotizacion c);
	public CotizacionVista buscar(int id);
	public List<CotizacionVista> consultar();
	public Cotizacion actuadescto(Cotizacion c);
	public List<Integer> anioCot();
	public List<CotizacionVista> cotAnio(int anio);
	public CotizacionVista buscarCotizacion(String numero);
	public int consultarRevision(int id);
	public void actualizarReferencia(int id, int id_origen);
	public CotizacionVista buscarRevisionCotizacion(String numero, int rev);
	public List<Integer> revisiones(int id);
	public List<CotizacionVista> buscarCotizacionPorPrecotizacion(int id);
	public List<CotizacionVista> buscarCotizacionPorOrden(int id);
	public List<CotizacionVista> buscarCotizacionPorClienteSinAutorizar(String moneda, int id);
	public List<CotizacionVista> buscarCotizacionPorOrdenSinAutorizar(int id);
	
}
