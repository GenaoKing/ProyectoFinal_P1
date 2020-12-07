package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Prodacom;
import java.awt.Toolkit;

public class GraficaBarras extends JFrame {


	public GraficaBarras() {
		//setBounds(100, 100, 450, 300);
		//setLocationRelativeTo(null);
		ChartPanel panel = Barras3d();
		
		JFrame ventana = new JFrame("Grafica");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaBarras.class.getResource("/iconos/Bar-Chart-icon.png")));
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        ventana.getContentPane().add(panel, BorderLayout.EAST);
        
	
	
	/*
	public static void main(String[] args) 
    {       
        ChartPanel panel=Barras3d();
        //ChartPanel panel=Pastel3d();
        /*
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        ventana.add(panel);
 	
    }
 	*/
        /*
    private static ChartPanel Barras3d() 
    {
        
        String A = "Disco Duro";
        String B = "Motherboard";
        String C = "MemoriaRam";
        String D = "Microprocesador";
        
        String vel = "Ventas";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        dataset.addValue(0.0d, A, vel);
        dataset.addValue(0.0d, B, vel);
        dataset.addValue(0.0d, C, vel);
        dataset.addValue(0.0d, D, vel);
        
        
        dataset.addValue(5.0, B, vel);
        dataset.addValue(6.0, B, vel);
        dataset.addValue(10.0, B, vel);
 
        dataset.addValue(4.0, C, vel);
        dataset.addValue(2.0, C, vel);
        dataset.addValue(3.0, C, vel);
        
        dataset.addValue(Prodacom.getInstance().getTotDisco(), A, vel);
        dataset.addValue(Prodacom.getInstance().getTotMotherboard(), B, vel);
        dataset.addValue(Prodacom.getInstance().getTotMemoriaRam(), C, vel);
        dataset.addValue(Prodacom.getInstance().getTotMicroprocesadores(), D, vel);
 		
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Grafica ventas componentes", 
                "Categoria", 
                "Vendidos", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false);
 
        ChartPanel panel = new ChartPanel(barChart);
 
        return panel;
 
    }
    */
}

	private ChartPanel Barras3d() {
		
		String A = "Disco Duro";
        String B = "Motherboard";
        String C = "MemoriaRam";
        String D = "Microprocesador";
        
        String vel = "Ventas";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        dataset.addValue(0.0d, A, vel);
        dataset.addValue(0.0d, B, vel);
        dataset.addValue(0.0d, C, vel);
        dataset.addValue(0.0d, D, vel);
        
        
        dataset.addValue(5.0, B, vel);
        dataset.addValue(6.0, B, vel);
        dataset.addValue(10.0, B, vel);
 
        dataset.addValue(4.0, C, vel);
        dataset.addValue(2.0, C, vel);
        dataset.addValue(3.0, C, vel);
        */
        dataset.addValue(Prodacom.getInstance().getTotDisco(), A, vel);
        dataset.addValue(Prodacom.getInstance().getTotMotherboard(), B, vel);
        dataset.addValue(Prodacom.getInstance().getTotMemoriaRam(), C, vel);
        dataset.addValue(Prodacom.getInstance().getTotMicroprocesadores(), D, vel);
 		
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Grafica ventas componentes", 
                "Categoria", 
                "Vendidos", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false);
 
        ChartPanel panel = new ChartPanel(barChart);
       // panel.setlocati;
        return panel;
	}
}