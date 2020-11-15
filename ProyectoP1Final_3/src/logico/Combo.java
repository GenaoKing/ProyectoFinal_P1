package logico;

import java.util.ArrayList;

public class Combo {
	private ArrayList<Componente>componentes;
	private String nombre;
	private String cod;
	public Combo(String nombre, String cod) {
		super();
		this.componentes = new ArrayList<>();
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
	

	
	
	
}
