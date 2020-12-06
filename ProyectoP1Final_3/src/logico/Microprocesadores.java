package logico;

public class Microprocesadores extends Componente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4391055141576634470L;
	private String conector;
	private float velocidad;
	private boolean GHz;
		
	
	public Microprocesadores(String serie, String modelo, String marca, float precioVenta, float precioCompra,
			int cantMinima, int cantMaxima, int cantReal, String conector, float velocidad, boolean gHz) {
		super(serie, modelo, marca, precioVenta, precioCompra, cantMinima, cantMaxima, cantReal);
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
