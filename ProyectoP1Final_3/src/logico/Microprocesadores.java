package logico;

public class Microprocesadores extends Componente {

	private String conector;
	private float velocidad;
	private boolean GHz;
		
	public Microprocesadores(String serie, String modelo, String marca, int cantidad, float precioVenta,
			float precioCompra, int cantMinima, int cantMaxima, int cantReal, String conector, float velocidad,
			boolean gHz) {
		super(serie, modelo, marca, cantidad, precioVenta, precioCompra, cantMinima, cantMaxima, cantReal);
		this.conector = conector;
		this.velocidad = velocidad;
		GHz = gHz;
	}
	public String getConector() {
		return conector;
	}
	public void setConector(String conector) {
		this.conector = conector;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	public boolean isGHz() {
		return GHz;
	}
	public void setGHz(boolean gHz) {
		GHz = gHz;
	}
	
	
}
