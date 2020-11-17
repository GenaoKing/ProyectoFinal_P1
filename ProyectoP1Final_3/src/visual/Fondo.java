package visual;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	ImageIcon imagen;
	String nombre;
	
	public Fondo(String nombre) {
		this.nombre = nombre;
	}

	public void paint(Graphics g) {
		Dimension tamaio = getSize();
		
	imagen = new ImageIcon(getClass().getResource(nombre));
	g.drawImage(imagen.getImage(),0,0,tamaio.width,tamaio.height,null);
	setOpaque(false);
	super.paint(g);
	}

}
