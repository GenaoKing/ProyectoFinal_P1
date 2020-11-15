package logico;

public abstract class Componente {
	
	protected String serie;
	protected String modelo;
	protected String marca;
	protected int cantidad;
	protected float precio;
	
	public Componente(String serie, String modelo, String marca, int cantidad, float precio) {
		super();
		this.serie = serie;
		this.modelo = modelo;
		this.marca = marca;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	

}
