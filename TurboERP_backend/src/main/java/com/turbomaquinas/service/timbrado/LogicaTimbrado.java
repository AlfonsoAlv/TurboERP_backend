package com.turbomaquinas.service.timbrado;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.turbomaquinas.DAO.comercial.DatosTimbradosDAO;
import com.turbomaquinas.DAO.comercial.FacturaFinalDAO;
import com.turbomaquinas.DAO.comercial.FacturaVariosDAO;


@Service
public class LogicaTimbrado implements TimbradoService{
	
	@Autowired
	FacturaFinalDAO repoFF;
	
	@Autowired
	FacturaVariosDAO repoFV;
	
	@Autowired
	DatosTimbradosDAO repoDT;
	
	private String user="AAA010101AAA";
	private String pass="7aa16d2e055554fcf3d182758db23c91";
	private String userpass = user+":"+pass;
	private String headerValue = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));	
	
	private String urlGenerarCfdi = "https://api.enlacefiscal.com/v6/generarCfdi";
	private String urlCancelarCfdi = "https://api.enlacefiscal.com/v6/cancelarCfdi";
	private String urlBuscarCfdi = "https://api.enlacefiscal.com/v6/informacionCfdi";
	
	public HttpHeaders configurarPeticionAPIEnlaceFiscal(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", headerValue);
        headers.add("x-api-key", "7aa16d2e055554fcf3d182758db23c91");
        return headers;
	}
	
	public ResponseEntity<String> timbrar(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlGenerarCfdi, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	private ResponseEntity<String> cancelarCFDi(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlCancelarCfdi, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	public ResponseEntity<String> buscar(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlBuscarCfdi, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	
	@Override
	public ResponseEntity<String> timbrarFacturaFinal(String cfdi) {
		return timbrar(cfdi);
	}
	
	@Override
	public ResponseEntity<String> cancelarCFDiFacturaFinal(String jsonCancelarfactura) {
		return cancelarCFDi(jsonCancelarfactura);
	}
	
	@Override
	public ResponseEntity<String> buscarFacturaFinal(String cfdi) {
		return buscar(cfdi);
	}
	
	@Override
	public ResponseEntity<String> timbrarFacturaVarios(String cfdi) {
		return timbrar(cfdi);
	}
	
	@Override
	@Transactional
	public ResponseEntity<String> cancelarCFDiFacturaVarios(String jsonCancelarfactura) {
		return cancelarCFDi(jsonCancelarfactura);
	}
	
	@Override
	public ResponseEntity<String> buscarFacturaVarios(String cfdi) {
		return buscar(cfdi);
	}
	
	
}
