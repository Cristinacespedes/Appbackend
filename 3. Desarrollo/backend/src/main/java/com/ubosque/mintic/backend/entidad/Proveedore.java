package com.ubosque.mintic.backend.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedores database table.
 * 
 */
@Entity
@Table(name="proveedores")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nitproveedor")
	private String nitproveedor;

	@Column(name="ciudad_proveedor")
	private String ciudadProveedor;

	@Column(name="direccion_proveedor")
	private String direccionProveedor;

	@Column(name="nombre_proveedor")
	private String nombreProveedor;

	@Column(name="telefono_proveedor")
	private String telefonoProveedor;

	//bi-directional many-to-one association to Producto
//	@OneToMany(mappedBy="proveedore",fetch = FetchType.LAZY)
//	private List<Producto> productos;

	public Proveedore() {
	}

	public String getNitproveedor() {
		return this.nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getCiudadProveedor() {
		return this.ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

/*	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProveedore(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProveedore(null);

		return producto;
	}
*/
}