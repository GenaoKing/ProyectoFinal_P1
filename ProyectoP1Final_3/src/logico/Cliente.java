package logico;

public class Cliente extends Persona {

	private float credito;
	
	public Cliente(String nombre, String cedula, String telefono, String direccion, float credito) {
		super(nombre, cedula, telefono, direccion);
		this.credito = credito;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}
	
}
