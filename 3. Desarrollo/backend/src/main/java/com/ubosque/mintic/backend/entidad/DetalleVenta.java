package com.ubosque.mintic.backend.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_ventas database table.
 * 
 */
@Entity
@Table(name="detalle_ventas")
@NamedQuery(name="DetalleVenta.findAll", query="SELECT d FROM DetalleVenta d")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_detalle_venta")
	private long codigoDetalleVenta;

	@Column(name="cantidad_producto")
	private int cantidadProducto;

	@Column(name="valor_total")
	private double valorTotal;

	@Column(name="valor_venta")
	private double valorVenta;

	private double valoriva;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Producto producto;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="codigo_venta")
	private Venta venta;

	public DetalleVenta() {
	}

	public long getCodigoDetalleVenta() {
		return this.codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public int getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorVenta() {
		return this.valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getValoriva() {
		return this.valoriva;
	}

	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}