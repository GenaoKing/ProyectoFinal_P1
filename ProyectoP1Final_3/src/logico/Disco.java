package logico;

public class Disco extends Componente {

	private float almacenamiento;
	private boolean Gb;
	private String conexion;
	
	public Disco(String serie, String modelo, String marca, int cantidad, float precio, float almacenamiento,
			boolean gb, String conexion) {
		super(serie, modelo, marca, cantidad, precio);
		this.almacenamiento = almacenamiento;
		this.Gb = gb;
		this.conexion = conexion;
	}

	public float getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(float almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public boolean isGb() {
		return Gb;
	}

	public void setGb(boolean gb) {
		Gb = gb;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	
	
}
