package logico;

public abstract class Componente {
	
	protected String serie;
	protected String modelo;
	protected String marca;
	protected int cantidad;
	protected float precioVenta;
	protected float precioCompra;
	protected int cantMinima;
	protected int cantMaxima;
	protected int cantReal;
	
	public Componente(String serie, String modelo, String marca, int cantidad, float precioVenta, float precioCompra,
			int cantMinima, int cantMaxima, int cantReal) {
		super();
		this.serie = serie;
		this.modelo = modelo;
		this.marca = marca;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.cantMinima = cantMinima;
		this.cantMaxima = cantMaxima;
		this.cantReal = cantReal;
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

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getCantMinima() {
		return cantMinima;
	}

	public void setCantMinima(int cantMinima) {
		this.cantMinima = cantMinima;
	}

	public int getCantMaxima() {
		return cantMaxima;
	}

	public void setCantMaxima(int cantMaxima) {
		this.cantMaxima = cantMaxima;
	}

	public int getCantReal() {
		return cantReal;
	}

	public void setCantReal(int cantReal) {
		this.cantReal = cantReal;
	}
	

}
