package logico;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.table.DefaultTableModel;

public class Factura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4585348282443559002L;
	private String cod;
	private Date fecha;
	private ArrayList<Componente>componentes;
	private ArrayList<Combo>combo;
	private float total;
	private Persona cliente;
	private Vendedor vendedor;
	private boolean estado;
	private Object[][]filas;
	private int cantidad = -1;
	
	public Factura(String cod, float total, Persona cliente,
			Vendedor vendedor,boolean estado,int c) {
		super();
		this.cod = cod;
		this.fecha = new Date();
		this.combo = new ArrayList<>();
		this.componentes = new ArrayList<>();
		this.total = total;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.estado=estado;
		this.cantidad=c;
		this.filas=new Object[100][5];
		
	}







	public Object[][] getFilas() {
		return filas;
	}







	public void setFilas(Object[][] filas) {
		this.filas = filas;
	}







	public int getCantidad() {
		return cantidad;
	}







	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}







	public ArrayList<Combo> getCombo() {
		return combo;
	}

	public void setCombo(ArrayList<Combo> combo) {
		this.combo = combo;
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

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void InsertarCombos(Combo c) {
		combo.add(c);
	}
	public void InsertarComponente(Componente c) {
		componentes.add(c);
	}



	public void InsertarFilas(int pos,Object[] o) {
		for(int i = 0; i<5;i++) {
			filas[pos][i]=o[i];
		}
		
	}


	public float calcualBenf() {
		float total = 0.0f;
		
		for(Combo C : combo) {
			total += (C.calcularprecio()-C.calCompra());
			
		}
		
		for(Componente comp : componentes) {
			total += comp.Calbeneficio();
		}
		
		return total;
	}


	public float[] Benef_tipo() {
		float [] tot = new float [4];
		
		for(Componente c : componentes) {
			
			if(c instanceof Disco) {
				tot[0] += c.Calbeneficio();
			}
			
			if(c instanceof MotherBoard) {
				tot[1] += c.Calbeneficio();
			}
			
			if(c instanceof Microprocesadores) {
				tot[2] += c.Calbeneficio();
			}
			
			if(c instanceof MemoriaRam) {
				tot[3] += c.Calbeneficio();
			}
			
		}
		
		for(Combo comb : combo) {
			for(Componente comp : comb.getComponentes()) {
				
				if(comp instanceof Disco) {
					tot[0] += comp.Calbeneficio();
				}
				
				if(comp instanceof MotherBoard) {
					tot[1] += comp.Calbeneficio();
				}
				
				if(comp instanceof Microprocesadores) {
					tot[2] += comp.Calbeneficio();
				}
				
				if(comp instanceof MemoriaRam) {
					tot[3] += comp.Calbeneficio();
				}
				
			}
		}
		return tot;
	}







	public boolean vencida() {
		boolean vencida = false;
		Date hoy= new Date();
		Calendar cal1 = new GregorianCalendar();
	    Calendar cal2 = new GregorianCalendar();
	    cal1.setTime(fecha);
	    cal2.setTime(hoy);
	    
		int dias =  (int)( (cal2.getTime().getTime() - cal1.getTime().getTime()) / (1000 * 60 * 60 * 24));
		
		if(dias>=((Cliente)cliente).getDiasCredito()) {
			vencida = true;
		}
		return vencida;
	}








	
}
