package logico;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;


public class Prodacom implements Serializable{
	//probando.
	
	
	private static final long serialVersionUID = 7398652231878450639L;
	private int cod_componente = 1;
	private int cod_proveedores = 1;
	private int cod_combos = 1;
	private int cod_facturas = 1;
	private int cod_OC = 1;
	private Administrativo admin = null;
	
	

	private ArrayList<Combo>combos;
	private ArrayList<Componente>componentes;
	private ArrayList<Factura>facturas;
	private ArrayList<Persona>personas;
	private ArrayList<Proveedor>proveedores;
	private ArrayList<OrdenCompra>ordenes;
	public static Prodacom prodacom = null;
	
	private int totDisco = 0;
	private int totMotherboard = 0;
	private int totMemoriaRam = 0;
	private int totMicroprocesadores = 0;
	
	private int mal [] = new int[3];
	private int intermedio [] = new int[3];
	private int excelente [] = new int[3];
	private ArrayList<Integer>malx;
	
	private Prodacom() {
		super();
		this.combos = new ArrayList<Combo>();
		this.componentes = new ArrayList<Componente>();
		this.facturas = new ArrayList<Factura>();
		this.personas = new ArrayList<Persona>();
		this.proveedores = new ArrayList<Proveedor>();
		this.ordenes = new ArrayList<OrdenCompra>();
	}
	
	public int getCod_OC() {
		return cod_OC;
	}

	public void setCod_OC(int cod_OC) {
		this.cod_OC = cod_OC;
	}

	public ArrayList<OrdenCompra> getOrdenes() {
		return ordenes;
	}

	public void InsertarOrden(OrdenCompra ordene) {
		this.ordenes.add(ordene);
		setCod_OC(getCod_OC()+1);
	}

	public static Prodacom getInstance() {
		if(prodacom == null) {
			prodacom = new Prodacom();
		}
		return prodacom;
	}
	
	
	public int getMal(int posicion) {
		return mal[posicion];
	}

	public void setMal(int mal, int posicion) {
		this.mal[posicion] = mal;
		
	}

	public int getIntermedio(int posicion) {
		return intermedio[posicion];
	}

	public void setIntermedio(int intermedio, int posicion) {
		this.intermedio[posicion] = intermedio;
	}

	public int getExcelente(int posicion) {
		return excelente[posicion];
	}

	public void setExcelente(int excelente,int posicion) {
		this.excelente[posicion] = excelente;
	}

	public int getTotDisco() {
		return totDisco;
	}

	public void setTotDisco(int totDisco) {
		this.totDisco = totDisco;
	}

	public int getTotMotherboard() {
		return totMotherboard;
	}

	public void setTotMotherboard(int totMotherboard) {
		this.totMotherboard = totMotherboard;
	}

	public int getTotMemoriaRam() {
		return totMemoriaRam;
	}

	public void setTotMemoriaRam(int totMemoriaRam) {
		this.totMemoriaRam = totMemoriaRam;
	}

	public int getTotMicroprocesadores() {
		return totMicroprocesadores;
	}

	public void setTotMicroprocesadores(int totMicroprocesadores) {
		this.totMicroprocesadores = totMicroprocesadores;
	}

	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void insertarCombo(Combo combo) {
		combos.add(combo);
		setCod_combos(getCod_combos()+1);
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void insertarComponente(Componente componente) {
		this.componentes.add(componente); 
		setCod_componente(getCod_componente()+1);
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void insertarFactura(Factura factura) {
		this.facturas.add(factura); 
		setCod_facturas(getCod_facturas()+1);
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
	
	public int getCod_componente() {
		return cod_componente;
	}

	public void setCod_componente(int cod_componente) {
		this.cod_componente = cod_componente;
	}

	public int getCod_proveedores() {
		return cod_proveedores;
	}

	public void setCod_proveedores(int cod_proveedores) {
		this.cod_proveedores = cod_proveedores;
	}

	public int getCod_combos() {
		return cod_combos;
	}

	public void setCod_combos(int cod_combos) {
		this.cod_combos = cod_combos;
	}

	public int getCod_facturas() {
		return cod_facturas;
	}

	public void setCod_facturas(int cod_facturas) {
		this.cod_facturas = cod_facturas;
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
				
				if( c instanceof Disco) {
					setTotDisco(getTotDisco() - cantidad);
				}
				
				if( c instanceof MotherBoard) {
					setTotMotherboard(getTotMotherboard() - cantidad);
				}
				if( c instanceof Microprocesadores) {
					setTotMicroprocesadores(getTotMicroprocesadores() - cantidad);
				}
				
				if( c instanceof MemoriaRam) {
					setTotMicroprocesadores(getTotMemoriaRam() - cantidad);
				}
				
			}			
		}
		

		
	}

	public void insertarProveedor(Proveedor p) {
		proveedores.add(p);
		setCod_proveedores(getCod_proveedores()+1);
		
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
		
		if( c instanceof Disco) {
			setTotDisco(getTotDisco()+1);
		}
		
		if( c instanceof MotherBoard) {
			setTotMotherboard(getTotMotherboard()+1);
		}
		if( c instanceof Microprocesadores) {
			setTotMicroprocesadores(getTotMicroprocesadores()+1);
		}
		
		if( c instanceof MemoriaRam) {
			setTotMemoriaRam(getTotMemoriaRam()+1);
		}
			
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
			
			if( a instanceof Disco) {
				setTotDisco(getTotDisco()-1);
			}
			
			if( a instanceof MotherBoard) {
				setTotMotherboard(getTotMotherboard()-1);
			}
			if( a instanceof Microprocesadores) {
				setTotMicroprocesadores(getTotMicroprocesadores()-1);
			}
			
			if( a instanceof MemoriaRam) {
				setTotMemoriaRam(getTotMemoriaRam()-1);
			}
			
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
	
	public float []CalcBeneficios_T(){
		
		float x[] = new  float [4]; 
		float total = 0.0f;
		
		for(Factura aux : facturas) {
			total += aux.calcualBenf();
			float z[] = aux.Benef_tipo();
			x[0] += z[0];
			x[1] += z[1];
			x[2] += z[2];
			x[3] += z[3];
			
		}
		//disco
		x[0] /= total;
		//motherboard
		x[1] /= total;
		//microprocesadores
		x[2] /= total;
		//memoriaRam
		x[3] /= total;
		
		return x;
	}
	
	public Administrativo getAdmin() {
		return admin;
	}

	public void setAdmin(Administrativo admin) {
		this.admin = admin;
	}
	
	
}
