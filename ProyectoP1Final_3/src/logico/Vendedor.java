package logico;

public class Vendedor extends Persona {

	private float totalventas;
	private float comision;
	private float sueldo;
	
	public Vendedor(String nombre, String cedula, String telefono, String direccion, float totalventas, float comision,
			float sueldo) {
		super(nombre, cedula, telefono, direccion);
		this.totalventas = 0;
		this.comision = comision/100;
		this.sueldo = sueldo;
	}
	public float getTotalventas() {
		return totalventas;
	}
	public void setTotalventas(float totalventas) {
		this.totalventas = totalventas;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
