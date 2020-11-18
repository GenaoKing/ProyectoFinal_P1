package logico;

public class Administrativo extends Persona {

	private String user;
	private String pass;
	private float sueldo;
	
	public Administrativo(String nombre, String cedula, String telefono, String direccion, String user, String pass,float sueldo) {
		super(nombre, cedula, telefono, direccion);
		this.user = user;
		this.pass = pass;
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

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
}
