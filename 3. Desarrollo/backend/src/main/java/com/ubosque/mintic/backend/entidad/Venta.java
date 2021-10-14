package com.ubosque.mintic.backend.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private long codigoVenta;

	private double ivaventa;

	@Column(name="total_venta")
	private double totalVenta;

	@Column(name="valor_venta")
	private double valorVenta;

	//bi-directional many-to-one association to DetalleVenta
	@OneToMany(mappedBy="venta")
	private List<DetalleVenta> detalleVentas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cedula_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cedula_usuario")
	private Usuario usuario;

	public Venta() {
	}

	public long getCodigoVenta() {
		return this.codigoVenta;
	}

	public void setCodigoVenta(long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public double getIvaventa() {
		return this.ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotalVenta() {
		return this.totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getValorVenta() {
		return this.valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return this.detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().add(detalleVenta);
		detalleVenta.setVenta(this);

		return detalleVenta;
	}

	public DetalleVenta removeDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().remove(detalleVenta);
		detalleVenta.setVenta(null);

		return detalleVenta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}