package com.turbomaquinas.service.calidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.calidad.DetalleGarantiaDAO;
import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoDetalleGarantia;

@Service
public class LogicaDetalleGarantia implements DetalleGarantiaService{

	@Autowired
	DetalleGarantiaDAO repositorio;
	
	
	@Override
	public DetalleGarantiaVista buscar(int id) {
		return repositorio.buscar(id);
	}


	@Override
	public void actualizarDetalles(List<DocumentoDetalleGarantia> actividades) {
		repositorio.actualizarDetalles(actividades.toString());
	}
}
