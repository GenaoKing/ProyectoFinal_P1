package logico;

import java.util.ArrayList;

public class Combo {
	private ArrayList<Componente>componentes = new ArrayList<Componente>();
	private String nombre;
	private String cod;
	public Combo(String nombre, String cod,ArrayList<Componente>componentes) {
		super();
		this.componentes = componentes;
		this.nombre = nombre;
		this.cod = cod;
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
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public float calcularprecio() {
		float res = 0.0f;
		for(Componente c : componentes) {
			res+=c.getPrecioVenta();
		}
		return (res-(res*0.1f));
	}

	
	
	
}
