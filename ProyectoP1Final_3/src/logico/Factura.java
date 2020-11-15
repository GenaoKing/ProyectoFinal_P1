package logico;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private String cod;
	private Date fecha;
	private ArrayList<Componente>componentes;
	private float total;
	private Cliente cliente;
	private Usuario vendedor;
	
	public Factura(String cod, Date fecha, float total, Cliente cliente,
			Usuario vendedor) {
		super();
		this.cod = cod;
		this.fecha = fecha;
		this.componentes = new ArrayList<>();
		this.total = total;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
}
