package com.ubosque.mintic.backend.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ventas database table.
 * 
 */
@Entity
@Table(name="ventas")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_venta")
	private String codigoVenta;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cedula_cliente")
	private Cliente cliente;

	public Venta() {
	}

	public String getCodigoVenta() {
		return this.codigoVenta;
	}

	public void setCodigoVenta(String codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}