package logico;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;


public class Prodacom {
	//probando.
	public static int cod_componente = 1;
	public static int cod_proveedores = 1;
	public static int cod_combos = 1;
	public static int cod_facturas = 1;
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
		cod_combos++;
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
		cod_facturas++;
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
	
	public Combo buscarCombo(String codigo) {
		Combo combo = null;
		int i = 0;
		boolean encontrado = false;
		while (i<combos.size() && !encontrado) {
			if(combos.get(i).getCod().equalsIgnoreCase(codigo)) {
				encontrado = true;
				combo = combos.get(i);
			}
			i++;
		}
		return combo;
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

	public void SumarComponente(Componente componente, int cantidad) {
		for(Componente c : componentes) {
			if(c.equals(componente)) {
				c.cantReal+=cantidad;
			}
		}
		
	}

	public void insertarProveedor(Proveedor p) {
		proveedores.add(p);
		cod_proveedores++;
		
	}

	public Proveedor buscarProveedor(String valueAt) {
		int i = 0;
		boolean encontrado = false;
		Proveedor p = null;
		while(i<proveedores.size() && !encontrado) {
			if(proveedores.get(i).getCodigo().equalsIgnoreCase(valueAt)) {
				p = proveedores.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public void VenderCombo(Combo c) {
		Combo a = buscarCombo(c.getCod());
		for(Componente b : c.getComponentes()) {
			VenderComponente(b);
		}
		
	}

	public void VenderComponente(Componente c) {
		Componente a = buscarComponente(c.serie);
		a.setCantReal(a.getCantReal()-1);
		
	}

	public boolean ChecarCombo(Combo c) {
		boolean res = true;
		int cantidad = 0;
		int i = 0;
		int j = 0;
		while(i<c.getComponentes().size() && res) {
			j=i+1;
			cantidad = c.getComponentes().get(i).getCantReal()-1;
			if(cantidad>0) {
				while(j<c.getComponentes().size() && res) {
					if(c.getComponentes().get(i).equals(c.getComponentes().get(j))) {
						cantidad--;
						if(cantidad==-1) {
							res = false;
						}
					}
					j++;
				}
			}else {
				res = false;
			}
			i++;
		}
		return res;
	}

	public void DevolverCombo(Combo c) {
		for(Componente a : c.getComponentes() ) {
			a.setCantReal(a.getCantReal()+1);
		}
		
	}

	public ArrayList<String> NombresVendedores() {
		ArrayList<String>nombres = new ArrayList<String>();
		for(Persona p : personas) {
			if(p instanceof Vendedor) {
				nombres.add(p.getCedula()+"| |"+p.getNombre());
			}
		}
		return nombres;
	}

	public Vendedor buscarVendedor(String substring) {
		Vendedor v = null;
		boolean encontrado = false;
		int i = 0;
		while(i<personas.size() && !encontrado) {
			if(personas.get(i) instanceof Vendedor && personas.get(i).getCedula().equalsIgnoreCase(substring) ) {
				encontrado = true;
				v = (Vendedor)personas.get(i);
			}
			i++;
		}
		return v;
	}
	
}
