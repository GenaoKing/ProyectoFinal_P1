package logico;

public class Microprocesadores extends Componente {

	private String conector;
	private float velocidad;
	private boolean GHz;
	
	public Microprocesadores(String serie, String modelo, String marca, int cantidad, float precio, String conector,
			float velocidad, boolean gHz) {
		super(serie, modelo, marca, cantidad, precio);
		this.conector = conector;
		this.velocidad = velocidad;
		this.GHz = gHz;
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
