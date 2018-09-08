package com.turbomaquinas.service.calidad;

import java.util.List;

import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoActividadesGarantia;
import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;
import com.turbomaquinas.POJO.calidad.GarantiaVista;
import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;

public interface GarantiaService {
	
	public List<EncabezadoGarantiaVista> consultarEncabezados(int id);
	public List<DetalleGarantiaVista> consultarDetalles(int id);
	public List<SubindiceGarantiaVista> consultarSubindices(int id);
	public int consultarCantidadEncabezados(int id);
	public GarantiaVista buscarGarantia(int id);
	public int crearActividadesGarantia(DocumentoActividadesGarantia obj_actividades_Garantia);	
}
