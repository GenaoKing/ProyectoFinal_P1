package logico;

import java.util.ArrayList;


public class Prodacom {
	//probando.
	public static int cod_componente = 1;
	private ArrayList<Combo>combos;
	private ArrayList<Componente>componentes;
	private ArrayList<Factura>facturas;
	private ArrayList<Persona>personas;
	private ArrayList<Proveedor>proveedores;
	private static Prodacom prodacom = null;
	
	private Prodacom() {
		super();
		this.combos = new ArrayList<Combo>();
		this.componentes = new ArrayList<Componente>();
		this.facturas = new ArrayList<Factura>();
		this.personas = new ArrayList<Persona>();
		this.proveedores = new ArrayList<Proveedor>();
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
		cod_componente++;
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

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor proveedor) {
		this.proveedores.add(proveedor);
	}

	public void insertarPersona(Persona persona) {
		this.personas.add(persona);
	}
	



	public boolean HacerPedido(String serie) {
		boolean res = false;
		Componente componente = buscarComponente(serie);
		if(componente!=null) {
			Proveedor proveedor = buscarProveedores(serie);
			if(proveedor!=null) {
				res = componente.chequearpedido();
			}
		}
		return res;
	}

	
	public Cliente buscarCliente(String cedula) {
		Cliente cliente = null;
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
	

	public Proveedor buscarProveedores(String serie) {
		Proveedor proveedor = null;
		int i = 0;
		int j = 0;
		boolean encontrado1 = false;
		boolean encontrado = false;
		while (i<proveedores.size() && !encontrado) {
			j=0;
			while(j<proveedores.get(i).getComponentes().size() && !encontrado1) {
				if(proveedores.get(i).getComponentes().get(j).getSerie().equalsIgnoreCase(serie)) {
					encontrado = true;
					encontrado1 = true;
					proveedor = proveedores.get(i);
				}
				j++;
			}
			i++;
		}
		return proveedor;
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

	public float CreditCliente(Cliente c) {
		float res = 0;
		for(Factura f : facturas) {
			if(f.getCliente().cedula.equalsIgnoreCase(c.cedula) && f.isEstado()) {
				res+=f.getTotal();
			}
		}
		
		return c.getCredito()-res;
	}
	
}
