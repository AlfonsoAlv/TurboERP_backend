package com.turbomaquinas.POJO.comercial;

import java.math.BigDecimal;

public class Facturas {

	private int id;
	private String tipo;
	private int numero;
	private BigDecimal saldo;
	private String moneda;
	private int clientes_id;
	private String estado;

	public Facturas() {
		super();
	}

	public Facturas(int id, String tipo, int numero, BigDecimal saldo, String moneda, int clientes_id, String estado) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
		this.moneda = moneda;
		this.clientes_id = clientes_id;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getClientes_id() {
		return clientes_id;
	}

	public void setClientes_id(int clientes_id) {
		this.clientes_id = clientes_id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
