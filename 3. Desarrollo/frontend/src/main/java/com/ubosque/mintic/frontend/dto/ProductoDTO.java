package com.ubosque.mintic.frontend.dto;


public class ProductoDTO {
	private String codigoProducto;
	private double ivacompra;
	//private ProveedorDTO proveedore;
	private long nitproveedor;
	private String nombreProducto;
	private double precioCompra;
	private double precioVenta;
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	/*public ProveedorDTO getProveedore() {
		return proveedore;
	}
	public void setProveedore(ProveedorDTO proveedore) {
		this.proveedore = proveedore;
	}*/
	public long getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	

	
}
