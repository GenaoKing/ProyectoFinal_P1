package logico;

public class MemoriaRam extends Componente {

	private float cantidadMem;
	private String tipo;
	private boolean Gb;
	
	public MemoriaRam(String serie, String modelo, String marca, int cantidad, float precio, float cantidadMem,
			String tipo, boolean gb) {
		super(serie, modelo, marca, cantidad, precio);
		this.cantidadMem = cantidadMem;
		this.tipo = tipo;
		this.Gb = gb;
	}
	
	public float getCantidadMem() {
		return cantidadMem;
	}
	public void setCantidadMem(float cantidadMem) {
		this.cantidadMem = cantidadMem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isGb() {
		return Gb;
	}
	public void setGb(boolean gb) {
		Gb = gb;
	}
	
	
}
