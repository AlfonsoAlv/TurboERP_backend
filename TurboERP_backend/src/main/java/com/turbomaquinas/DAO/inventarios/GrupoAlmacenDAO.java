package com.turbomaquinas.DAO.inventarios;

import java.util.List;

import com.turbomaquinas.POJO.inventarios.GrupoAlmacen;

public interface GrupoAlmacenDAO {
	public List<GrupoAlmacen> consultar();
	public GrupoAlmacen buscarPorClaveNumerica(int clave_num);	
}
