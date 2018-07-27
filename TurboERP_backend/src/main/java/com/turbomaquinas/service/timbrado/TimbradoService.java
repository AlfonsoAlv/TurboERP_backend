package com.turbomaquinas.service.timbrado;

import org.springframework.http.ResponseEntity;

public interface TimbradoService {
	public ResponseEntity<String> timbrarFacturaFinal(String jsonfactura);
	public ResponseEntity<String> cancelarCFDiFacturaFinal(String jsonCancelarfactura);
	public ResponseEntity<String> buscarFacturaFinal(String cfdi);
	public ResponseEntity<String> timbrarFacturaVarios(String jsonfactura);
	public ResponseEntity<String> cancelarCFDiFacturaVarios(String jsonCancelarfactura);
	public ResponseEntity<String> buscarFacturaVarios(String cfdi);
	public ResponseEntity<String> timbrarPago(String cfdi);
	public ResponseEntity<String> timbrarNotaCredito(String cfdi);
}
