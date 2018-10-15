package com.turbomaquinas.service.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoDetalleGarantia;
import com.turbomaquinas.POJO.calidad.GarantiaOrden;

public interface DetalleGarantiaService {

	public DetalleGarantiaVista buscar(int id);
	public void actualizarDetalles(List<DocumentoDetalleGarantia> actividades);
	public List<GarantiaOrden> consultarPorOrdenSinOIT(int idOrden);

}
