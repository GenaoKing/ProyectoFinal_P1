package logico;

import java.io.Serializable;
import java.util.Date;

public class OrdenCompra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7325234041320311359L;
	private String codigo;
	private Date fecha;
	private Componente componente;
	private Proveedor proveedor;
	private int cantidad;
	private float total;
	private Administrativo admin;
	
	public OrdenCompra(String codigo, Date fecha, Componente componente, Proveedor proveedor, int cantidad, float total,
			Administrativo admin) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.componente = componente;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.total = total;
		this.admin = admin;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Administrativo getAdmin() {
		return admin;
	}
	public void setAdmin(Administrativo admin) {
		this.admin = admin;
	}
	
	
	
}
