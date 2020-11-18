package logico;

import java.util.ArrayList;


public class Prodacom {
	//probando.
	private ArrayList<Combo>combos;
	private ArrayList<Componente>componentes;
	private ArrayList<Factura>facturas;
	private ArrayList<Persona>personas;
	private static Prodacom prodacom = null;
	private Prodacom() {
		super();
		this.combos = new ArrayList<>();
		this.componentes = new ArrayList<>();
		this.facturas = new ArrayList<>();
		this.personas = new ArrayList<>();
	}
	
	public static Prodacom getInstance() {
		if(prodacom == null) {
			prodacom = new Prodacom();
		}
		return prodacom;
	}

	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void insertarCombo(Combo combo) {
		combos.add(combo);
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void insertarComponente(Componente componente) {
		this.componentes.add(componente); 
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void insertarFactura(Factura factura) {
		this.facturas.add(factura); 
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void insertarPersona(Persona persona) {
		this.personas.add(persona);
	}




	
	public Persona buscarCliente(String cedula) {
		Persona cliente = null;
		int i = 0;
		boolean encontrado = false;
		while (i<personas.size() && !encontrado) {
			if(personas.get(i).getCedula().equalsIgnoreCase(cedula) && personas.get(i) instanceof Cliente) {
				encontrado = true;
				cliente =(Cliente) personas.get(i);
			}
			i++;
		}
		return cliente;
	}
	
	public Factura buscarFactura(String codigo) {
		Factura factura = null;
		int i = 0;
		boolean encontrado = false;
		while (i<facturas.size() && !encontrado) {
			if(facturas.get(i).getCod().equalsIgnoreCase(codigo)) {
				encontrado = true;
				factura = facturas.get(i);
			}
			i++;
		}
		return factura;
	}
	
	public Componente buscarComponente(String serie) {
		Componente componente = null;
		int i = 0;
		boolean encontrado = false;
		while (i<componentes.size() && !encontrado) {
			if(componentes.get(i).getSerie().equalsIgnoreCase(serie)) {
				encontrado = true;
				componente = componentes.get(i);
			}
			i++;
		}
		return componente;
	}
	
}
