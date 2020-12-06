package logico;

import java.util.ArrayList;

public class MotherBoard extends Componente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3632202469402410404L;
	private String conector;
	private String tipoRam;
	private ArrayList<String>conexiones;
		
	public MotherBoard(String serie, String modelo, String marca, float precioVenta, float precioCompra, int cantMinima,
			int cantMaxima, int cantReal, String conector, String tipoRam, ArrayList<String> conexiones) {
		super(serie, modelo, marca, precioVenta, precioCompra, cantMinima, cantMaxima, cantReal);
		this.conector = conector;
		this.tipoRam = tipoRam;
		this.conexiones = conexiones;
	}

	public String getConector() {
		return conector;
	}
	
	public void setConector(String conector) {
		this.conector = conector;
	}
	public String getTipoRam() {
		return tipoRam;
	}
	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}
	public ArrayList<String> getConexiones() {
		return conexiones;
	}
	public void setConexiones(ArrayList<String> conexiones) {
		this.conexiones = conexiones;
	}
	

}
