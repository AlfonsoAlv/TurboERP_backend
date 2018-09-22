package com.turbomaquinas.DAO.inventarios;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.turbomaquinas.POJO.inventarios.CatalogoArticulosVista;

@Repository
public class JDBCCatalogoArticulos implements CatalogoArticulosDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CatalogoArticulosVista> consultarArtPorAlmacen(int id) {
		String sql = "SELECT * "
				+ "FROM CATALOGO_ARTICULOS_V "
				+ "WHERE almacen"+id+"=? and CATALOGO_ARTICULOS_agrupa_id=0";
		List<CatalogoArticulosVista> ca = jdbcTemplate.query(sql, new CatalogoArticulosVistaRM(),id);
		return ca;
	}

	@Override
	public void actualizarExistenciaFisica(int articulo_id, int almacen_id, float cantidad) {
		String sql="UPDATE CATALOGO_ARTICULOS SET existencia=(JSON_REPLACE(existencia,RECUPERAR_PATH_FISICO_ALMACEN(existencia,?), ?)) WHERE id=?";
		jdbcTemplate.update(sql,almacen_id,cantidad,articulo_id);
	}

	@Override
	public CatalogoArticulosVista buscar(int id) {
		CatalogoArticulosVista articulo = jdbcTemplate.queryForObject("SELECT * FROM CATALOGO_ARTICULOS_V WHERE id = ?",
				new CatalogoArticulosVistaRM(), id);
		return articulo;
	}

	@Override
	public List<CatalogoArticulosVista> consultarSubindicesAlmacen(int id,int agrupa_id) {
		String sql = "SELECT * "
				+ "FROM CATALOGO_ARTICULOS_V "
				+ "WHERE almacen"+id+"=? and CATALOGO_ARTICULOS_agrupa_id=?";
		List<CatalogoArticulosVista> ca = jdbcTemplate.query(sql, new CatalogoArticulosVistaRM(),id,agrupa_id);
		return ca;
	}
	
	
	@Override
	public void actualizarUbicacion(int articulo_id, int almacen_id, String ubicaciones[]) {
		String lista = null;
		for (String ubi: ubicaciones) {
			if(lista == null){
				lista = ubi;
			}else{
				lista = lista+","+ubi;
			}				
		}
		String sql="UPDATE CATALOGO_ARTICULOS SET existencia=(JSON_REPLACE(existencia,((SELECT CONCAT(SUBSTRING(JSON_SEARCH(existencia,'all',?,NULL,'$[*].almacen_id'),2,5),'ubicaciones'))), JSON_ARRAY("+lista+"))) WHERE id=?";
		jdbcTemplate.update(sql,almacen_id,articulo_id);
	}
	
	@Override
	public List<CatalogoArticulosVista> consultarArtPorGrupo(int almacen_id,int grupo_id) {
		String sql = "SELECT * "
				+ "FROM CATALOGO_ARTICULOS_V "
				+ "WHERE almacen"+almacen_id+"=? and CATALOGO_ARTICULOS_agrupa_id=0 and GRUPOS_ALMACEN_id=?";
		List<CatalogoArticulosVista> ca = jdbcTemplate.query(sql, new CatalogoArticulosVistaRM(),almacen_id,grupo_id);
		return ca;
	}

	@Override
	public List<CatalogoArticulosVista> consultarArtPorCodigo(int almacen_id,String codigo) {
		String sql = "SELECT * "
				+ "FROM CATALOGO_ARTICULOS_V "
				+ "WHERE almacen"+almacen_id+"=? and codigo= ? ";
		List<CatalogoArticulosVista> ca = jdbcTemplate.query(sql, new CatalogoArticulosVistaRM(),almacen_id,codigo);
		return ca;
	}

	@Override
	public void sincronizar(String accion) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("SINCRONIZAR_CATALOGO_ARTICULOS");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("p_accion", accion);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		simpleJdbcCall.execute(in);		
	}

}
