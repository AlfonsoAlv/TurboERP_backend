package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.comercial.PagosDAO;
import com.turbomaquinas.POJO.comercial.DocumentoAplicarPago;
import com.turbomaquinas.POJO.comercial.Pagos;
import com.turbomaquinas.POJO.comercial.PagosFacturas;
import com.turbomaquinas.POJO.comercial.PagosVista;

@Service
public class LogicaPagos implements PagosService {

	@Autowired
	PagosDAO resPago;
	

	@Override
	public Pagos actualizar(Pagos p) throws DataAccessException {
		return resPago.actualizar(p);
	}

	@Override
	public PagosVista buscar(int id) throws DataAccessException {
		return resPago.buscar(id);
	}

	@Override
	public List<PagosVista> consultar() throws DataAccessException {
		return resPago.consultar();
	}

	@Override
	public void aplicarPagos(DocumentoAplicarPago doc) throws DataAccessException{
		
		resPago.AplicarPagos(doc.toString());
		
		
	}

	@Override
	public List<Pagos> pagosFecha(String fechainicio, String fechafin) throws DataAccessException {
		
		return resPago.pagoRangoFecha(fechainicio, fechafin);
	}

	@Override
	public List<PagosFacturas> facturasPorPago(int id) throws DataAccessException{
		
		return resPago.facturasPagadas(id);
	}

	@Override
	public void restablecerPago(int id) {
		resPago.RestablecerPago(id);
		
	}
	
	@Override
	public String obtenerJSONTimbrado(int id, String modo) {
		return resPago.obtenerJSONTimbrado(id,modo);
	}

	@Override
	public Integer ultimoPago() {
		return resPago.obtenerUltimoIdPago();
	}

	@Override
	public List<Pagos> pendientesTimbrar() {
		return resPago.pendientesTimbrar();
	}
	
	

}
