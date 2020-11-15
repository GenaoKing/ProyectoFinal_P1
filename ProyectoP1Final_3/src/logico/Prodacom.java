package logico;

import java.util.ArrayList;
import java.util.Iterator;

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

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void insertarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void insertarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public Cliente buscarCliente(String cedula) {
		Cliente cliente = null;
		int i = 0;
		boolean encontrado = false;
		while (i<clientes.size() && !encontrado) {
			if(clientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
				cliente = clientes.get(i);
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
