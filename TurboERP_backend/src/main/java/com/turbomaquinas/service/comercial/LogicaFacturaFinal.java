package com.turbomaquinas.service.comercial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.turbomaquinas.DAO.comercial.FacturaFinalDAO;
import com.turbomaquinas.POJO.comercial.DocumentoFacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinal;
import com.turbomaquinas.POJO.comercial.FacturaFinalVista;
import com.turbomaquinas.POJO.general.OrdenFactura;
import com.turbomaquinas.service.general.OrdenService;

@Service
public class LogicaFacturaFinal implements FacturaFinalService {
	
	@Autowired
	FacturaFinalDAO repFF;
	
	@Autowired
	OrdenService serviceOrden;

	@Override
	public FacturaFinalVista crear(FacturaFinal ff) throws DataAccessException {
		int id = repFF.crear(ff);
		return repFF.buscar(id);
	}

	@Override
	public FacturaFinal actualizar(FacturaFinal ff) throws DataAccessException {
		return repFF.actualizar(ff);
	}

	@Override
	public FacturaFinalVista buscar(int id) throws DataAccessException {
		return repFF.buscar(id);
	}

	@Override
	public List<FacturaFinalVista> consultar() throws DataAccessException {
		return repFF.consultar();
	}

	@Override
	public void cancelar(FacturaFinal ff) throws DataAccessException {
			repFF.cancelar(ff);
	}

	@Override
	public FacturaFinalVista buscarPorTipoNumero(int numero, String tipo,String estado) throws DataAccessException {
		return repFF.buscarPorTipoNumero(numero, tipo,estado);
	}
	
	@Override
	public List<FacturaFinalVista> consultarFacturasPendientesPorCliente(int id,String moneda) {		
		return repFF.consultarFacturasPendientesPorCliente(id,moneda);
	}

	@Override
	public List<OrdenFactura> consultarOrdenes(int id) {
		return serviceOrden.consultarOrdenesPorIdsFactura(repFF.consultarIdsOrdenesFactura(id),id);
	}

	@Override
	public FacturaFinalVista buscarFacturaFolio(String folio,String estado) {
		return repFF.buscarFacturaFolio(folio,estado);
	}

	@Override
	public void creardoc(DocumentoFacturaFinal doc) throws DataAccessException {
		repFF.creardoc(doc.toString());
	}

}
