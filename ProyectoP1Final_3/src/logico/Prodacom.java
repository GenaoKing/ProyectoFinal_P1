package logico;

import java.util.ArrayList;

public class Prodacom {
	
	private ArrayList<Combo>combos;
	private ArrayList<Componente>componentes;
	private ArrayList<Factura>facturas;
	private ArrayList<Cliente>clientes;
	private ArrayList<Usuario>usuarios;
	private static Prodacom prodacom = null;
	private Prodacom() {
		super();
		this.combos = new ArrayList<>();
		this.componentes = new ArrayList<>();
		this.facturas = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.usuarios = new ArrayList<>();
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

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
