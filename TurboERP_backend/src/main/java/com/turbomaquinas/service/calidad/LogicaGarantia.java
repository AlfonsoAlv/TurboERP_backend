package com.turbomaquinas.service.calidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.calidad.DetalleGarantiaDAO;
import com.turbomaquinas.DAO.calidad.EncabezadoGarantiaDAO;
import com.turbomaquinas.DAO.calidad.GarantiaDAO;
import com.turbomaquinas.DAO.calidad.SubindiceGarantiaDAO;
import com.turbomaquinas.POJO.calidad.DetalleGarantiaVista;
import com.turbomaquinas.POJO.calidad.DocumentoActividadesGarantia;
import com.turbomaquinas.POJO.calidad.EncabezadoGarantiaVista;
import com.turbomaquinas.POJO.calidad.EstadoCierreFoco;
import com.turbomaquinas.POJO.calidad.GarantiaVista;
import com.turbomaquinas.POJO.calidad.PorcentajeActividades;
import com.turbomaquinas.POJO.calidad.SubindiceGarantiaVista;

@Service
public class LogicaGarantia implements GarantiaService {
	
	@Autowired
	GarantiaDAO repositorio;

	@Autowired
	EncabezadoGarantiaDAO repoEncabezado;

	@Autowired
	DetalleGarantiaDAO repoDetalles;
	
	@Autowired
	SubindiceGarantiaDAO repoSubindices;
	
	
	

	@Override
	public List<EncabezadoGarantiaVista> consultarEncabezados(int id) throws DataAccessException {
		return repoEncabezado.consultarPorGarantia(id);
	}

	@Override
	public List<DetalleGarantiaVista> consultarDetalles(int id) throws DataAccessException {
		return repoDetalles.consultarPorGarantia(id);
	}

	@Override
	public List<SubindiceGarantiaVista> consultarSubindices(int id) throws DataAccessException {
		return repoSubindices.consultarPorGarantia(id);
	}

	@Override
	public int consultarCantidadEncabezados(int id) throws DataAccessException {
		return repoEncabezado.consultarCantidadporGarantia(id);
	}

	@Override
	public GarantiaVista buscarGarantia(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public int crearActividadesGarantia(DocumentoActividadesGarantia obj_actividades_Garantia) {
		// TODO Auto-generated method stub
		return repositorio.crearActividadesGarantia(obj_actividades_Garantia.toString());
	}

	@Override
	public List<Integer> obtenerFocos(int id) {
		return repositorio.obtenerFocos(id);
	}

	@Override
	public EstadoCierreFoco obtenerEstadoCierreFoco(int focoId) {
		return repositorio.obtenerEstadoCierreFoco(focoId);
	}

	@Override
	public PorcentajeActividades obtenerPorcentajeActividades(int focoId) {
		return repositorio.obtenerPorcentajeActividades(focoId);
	}

}
