package logico;

public class Cliente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1409845877323683815L;
	private float credito;
	private boolean estado;
	private int DiasCredito;
	
	public Cliente(String nombre, String cedula, String telefono, String direccion, float credito, int DiasCredito) {
		super(nombre, cedula, telefono, direccion);
		this.credito = credito;
		this.estado=true;
		this.DiasCredito=DiasCredito;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getDiasCredito() {
		return DiasCredito;
	}

	public void setDiasCredito(int diasCredito) {
		DiasCredito = diasCredito;
	}
	
	
	
}
