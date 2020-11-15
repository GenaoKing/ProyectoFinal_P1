package logico;

public class Usuario extends Cliente {
	private String user;
	private String pass;
	private float totalventas;
	private float sueldo;
	
	public Usuario(String nombre, String cedula, String telefono, String direccion, String user, String pass,
			float totalventas, float sueldo) {
		super(nombre, cedula, telefono, direccion);
		this.user = user;
		this.pass = pass;
		this.totalventas = totalventas;
		this.sueldo = sueldo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public float getTotalventas() {
		return totalventas;
	}

	public void setTotalventas(float totalventas) {
		this.totalventas = totalventas;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
