package com.ubosque.mintic.backend.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_producto")
	private String codigoProducto;

	private double ivacompra;
	
	@Column(name="nitproveedor")
	private double nitproveedor;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_compra")
	private double precioCompra;

	@Column(name="precio_venta")
	private double precioVenta;


	//bi-directional many-to-one association to DetalleVenta
//	@OneToMany(mappedBy="producto", fetch = FetchType.LAZY)
//	private List<DetalleVenta> detalleVentas;

	//bi-directional many-to-one association to Proveedore
//	@ManyToOne (fetch = FetchType.LAZY)
//	@JoinColumn(name="nitproveedor")
//	private Proveedore proveedore;

	public Producto() {
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getIvacompra() {
		return this.ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(double nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	
	

/*	public List<DetalleVenta> getDetalleVentas() {
		return this.detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().add(detalleVenta);
		detalleVenta.setProducto(this);

		return detalleVenta;
	}

	public DetalleVenta removeDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().remove(detalleVenta);
		detalleVenta.setProducto(null);

		return detalleVenta;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}
*/
}