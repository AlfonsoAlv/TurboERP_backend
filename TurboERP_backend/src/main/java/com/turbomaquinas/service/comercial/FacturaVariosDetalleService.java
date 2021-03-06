package com.turbomaquinas.service.comercial;

import java.util.List;

import com.turbomaquinas.POJO.comercial.FacturaVariosDetalle;

public interface FacturaVariosDetalleService {
	public FacturaVariosDetalle crear(FacturaVariosDetalle fvd);
	public FacturaVariosDetalle actualizar(FacturaVariosDetalle fvd);
	public FacturaVariosDetalle buscar(int id);
	public List<FacturaVariosDetalle> consultar();
}
