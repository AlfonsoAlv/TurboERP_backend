package com.turbomaquinas.service.inventarios;

import java.util.List;

import com.turbomaquinas.POJO.inventarios.GrupoAlmacen;

public interface GrupoAlmacenService {
	
	public List<GrupoAlmacen> consultar();
	public GrupoAlmacen buscarPorClaveNumerica(int clave_num);
	

}
