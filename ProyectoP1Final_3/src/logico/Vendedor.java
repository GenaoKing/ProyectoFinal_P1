package logico;

public class Vendedor extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8701753345005896347L;
	private float totalventas;
	private float comision;
	private float sueldo;
	private String usuario;
	private String contrasenna;
	
	public Vendedor(String nombre, String cedula, String telefono, String direccion, float totalventas, float comision,
			float sueldo, String usuario, String contrasenna) {
		super(nombre, cedula, telefono, direccion);
		this.totalventas = 0;
		this.comision = comision/100;
		this.sueldo = sueldo;
		this.usuario = usuario;
		this.contrasenna = contrasenna;
	}
	
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenna() {
		return contrasenna;
	}


	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
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
