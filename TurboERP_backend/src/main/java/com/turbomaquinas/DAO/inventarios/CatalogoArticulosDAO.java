package com.turbomaquinas.DAO.inventarios;

import java.util.List;

import com.turbomaquinas.POJO.inventarios.CatalogoArticulosVista;

public interface CatalogoArticulosDAO {
	
	public List<CatalogoArticulosVista> consultarArtPorAlmacen(int id);
	public void actualizarExistenciaFisica(int articulo_id, int almacen_id,float cantidad);
	public CatalogoArticulosVista buscar(int id);
	public List<CatalogoArticulosVista> consultarSubindicesAlmacen(int id,int agrupa_id);
	public void actualizarUbicacion(int articulo_id, int almacen_id, String ubicaciones[]);
	public List<CatalogoArticulosVista> consultarArtPorGrupo(int almacen_id,int grupo_id);
	public List<CatalogoArticulosVista> consultarArtPorCodigo(int almacen_id,String codigo);
	public void sincronizar(String accion);
}

