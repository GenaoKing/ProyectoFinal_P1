package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5002069196887305194L;
	//
	private ArrayList<Componente>componentes;
	private String nombre;
	private String codigo;
	private String telefono;
	private String direccion;
	private float LimCredito;
	


	public Proveedor(String nombre, String codigo, String telefono, String direccion,
			float limCredito) {
		super();
		this.componentes   = new ArrayList<Componente>();
		this.nombre = nombre;
		this.codigo = codigo;
		this.telefono = telefono;
		this.direccion = direccion;
		LimCredito = limCredito;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLimCredito() {
		return LimCredito;
	}

	public void setLimCredito(float limCredito) {
		LimCredito = limCredito;
	}
	
	public void insertarcomponentes(Componente c) {
		componentes.add(c);
	}
	
	
	

}
