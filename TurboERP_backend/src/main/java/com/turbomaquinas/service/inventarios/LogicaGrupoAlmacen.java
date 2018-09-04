package com.turbomaquinas.service.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.turbomaquinas.DAO.inventarios.GrupoAlmacenDAO;
import com.turbomaquinas.POJO.inventarios.GrupoAlmacen;

@Service
public class LogicaGrupoAlmacen implements GrupoAlmacenService{
	
	@Autowired
	GrupoAlmacenDAO repositorio;
	
	@Override
	public List<GrupoAlmacen> consultar() throws DataAccessException{
		return repositorio.consultar();
	}
	
	@Override
	public GrupoAlmacen buscarPorClaveNumerica(int clave_num) throws DataAccessException{
		return repositorio.buscarPorClaveNumerica(clave_num);
	}

}
