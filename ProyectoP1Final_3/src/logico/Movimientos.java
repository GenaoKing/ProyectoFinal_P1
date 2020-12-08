package logico;

import java.util.Date;

public class Movimientos {

	private String transaccion;
	private String cod;
	private String descripcion;
	private Date fecha;
	private double monto;
	private String usuario;
	private double balance;
	
	public Movimientos(String transaccion, String cod, String descripcion, Date fecha, double monto, String usuario,double balance) {
		super();
		this.transaccion = transaccion;
		this.cod = cod;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.monto = monto;
		this.usuario = usuario;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
