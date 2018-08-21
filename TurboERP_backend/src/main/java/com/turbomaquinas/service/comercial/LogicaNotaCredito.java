package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.comercial.NotaCreditoDAO;
import com.turbomaquinas.POJO.comercial.DocumentoAplicarNotasCredito;
import com.turbomaquinas.POJO.comercial.NotaCredito;
import com.turbomaquinas.POJO.comercial.NotaCreditoVista;

@Service
public class LogicaNotaCredito implements NotaCreditoService {

	@Autowired
	NotaCreditoDAO repNc;
	
		@Override
	public void actualizar(NotaCredito nc) throws DataAccessException {
		repNc.actualizar(nc);
		
	}

	@Override
	public NotaCreditoVista buscar(int id) throws DataAccessException {
		return repNc.buscar(id);
	}

	@Override
	public List<NotaCreditoVista> consultar() throws DataAccessException {
		return repNc.consultar();
	}

	@Override
	public NotaCreditoVista crearNotasCredito(DocumentoAplicarNotasCredito doc) {
		int id = repNc.crearNotasCredito(doc.toString());
		return repNc.buscar(id);
	}

	@Override
	public void RestablecerNotaCredito(int id, int modificado_por) {
		repNc.RestablecerNotaCredito(id, modificado_por);		
	}
	
	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		return repNc.obtenerJSONTimbrado(id,modo);
	}
	
	@Override
	public void actualizarNumero(int id, int opcion) {
		repNc.actualizarNumero(id,opcion);
	}

	@Override
	public NotaCreditoVista buscarPorNumero(int numero) {
		return repNc.buscarPorNumero(numero);
	}

	@Override
	public List<NotaCreditoVista> consultarSinTimbrar() {
		return repNc.consultarSinTimbrar();
	}

	@Override
	public Integer buscarUltimoId() {
		return repNc.buscarUltimoId();
	}

	@Override
	public List<NotaCreditoVista> consultarPorFecha(String fechainicio, String fechafin, String estado) {
		return repNc.consultarPorFecha(fechainicio, fechafin, estado);
	}

}
