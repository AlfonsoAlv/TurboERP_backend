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
	
	private String user="TUR6208201E7";
	private String token_pass="2e23bc76222f8a7c33e509dc41399fc9";
	private String api_key="e9aT1ajrRh1NyRkzOtDoN1ZEGmIsEKuJ6f3FYyLh";
	private String userpass = user+":"+token_pass;
	private String headerValue = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));	
	
	private String urlGenerarCfdiFactura = "https://api.enlacefiscal.com/v6/generarCfdi";
	private String urlCancelarCfdiFactura = "https://api.enlacefiscal.com/v6/cancelarCfdi";
	private String urlBuscarCfdiFactura = "https://api.enlacefiscal.com/v6/informacionCfdi";
	
	private String urlGenerarCfdiPago = "https://api.enlacefiscal.com/v6/generarReciboElectronicoPago";
	
	public HttpHeaders configurarPeticionAPIEnlaceFiscal(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", headerValue);
        headers.add("x-api-key", api_key);
        return headers;
	}
	
	// METODOS PARA TIMBRADO DE FACTURAS
	public ResponseEntity<String> timbrarFactura(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlGenerarCfdiFactura, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	private ResponseEntity<String> cancelarCFDiFactura(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlCancelarCfdiFactura, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	public ResponseEntity<String> buscarFactura(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlBuscarCfdiFactura, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	
	// METODOS PARA TIMBRADO DE PAGOS
	public ResponseEntity<String> timbrarPagoEF(String json){
		//Configurar petición Headers de las API enlace fiscal
		HttpHeaders headers=configurarPeticionAPIEnlaceFiscal();
		//PETICIÓN A LA API
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(json, headers);
		ResponseEntity<String> response = restTemplate.exchange(urlGenerarCfdiPago, HttpMethod.POST, httpEntity, String.class);
		return response;
	}
	
	
	
	
	
	
	
	// Factura Final
	@Override
	public ResponseEntity<String> timbrarFacturaFinal(String cfdi) {
		return timbrarFactura(cfdi);
	}
	
	@Override
	public ResponseEntity<String> cancelarCFDiFacturaFinal(String jsonCancelarfactura) {
		return cancelarCFDiFactura(jsonCancelarfactura);
	}
	
	@Override
	public ResponseEntity<String> buscarFacturaFinal(String cfdi) {
		return buscarFactura(cfdi);
	}
	
	
	// Factura Varios
	@Override
	public ResponseEntity<String> timbrarFacturaVarios(String cfdi) {
		return timbrarFactura(cfdi);
	}
	
	@Override
	@Transactional
	public ResponseEntity<String> cancelarCFDiFacturaVarios(String jsonCancelarfactura) {
		return cancelarCFDiFactura(jsonCancelarfactura);
	}
	
	@Override
	public ResponseEntity<String> buscarFacturaVarios(String cfdi) {
		return buscarFactura(cfdi);
	}
	
	
	// Pagos
	@Override
	public ResponseEntity<String> timbrarPago(String cfdi) {
		return timbrarPagoEF(cfdi);
	}
	
	@Override
	public ResponseEntity<String> cancelarCFDiPagos(String cfdi) {
		return cancelarCFDiFactura(cfdi);
	}
	
	// Notas de Crétido
	@Override
	public ResponseEntity<String> timbrarNotaCredito(String cfdi) {
		return timbrarFactura(cfdi);
	}

	@Override
	public ResponseEntity<String> buscarCFDiPagos(String cfdi) {
		return buscarFactura(cfdi);
	}
	
}
