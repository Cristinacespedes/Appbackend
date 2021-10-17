package com.ubosque.mintic.frontend.dto;

public class VentasDTO {
	
	private long codigoVenta;
	private double ivaventa;
	private double totalVenta;
	private double valorVenta;
	private long cliente;
	private long usuario;
	
public long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	public long getCliente() {
		return cliente;
	}
	public void setCliente(long cliente) {
		this.cliente = cliente;
	}
	public long getUsuario() {
		return usuario;
	}
	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

}
