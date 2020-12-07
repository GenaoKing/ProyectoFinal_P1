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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.Prodacom;

public class GraficOpinion extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) 
    {       
        ChartPanel panel=Barras3d();
        //ChartPanel panel=Pastel3d();
        
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        ventana.add(panel);
 
    }
 
    static ChartPanel Barras3d() 
    {
        
        String A = "A) Que tan satisfecho se encuentra de la empresa en general.";
        String B = "B) Cuan probable es que recomiende nuestros servicios.";
        String C = "C) Como calificaria la calidad de la atencion recibida?";
 
        String vel = "Mal";
        String millas = "Excelente";
        String usuarios = "Intermedio";
 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 
        dataset.addValue(1.0, A, vel);
        dataset.addValue(3.0, A, usuarios);
        dataset.addValue(5.0, A, millas);
 
        dataset.addValue(5.0, B, vel);
        dataset.addValue(6.0, B, usuarios);
        dataset.addValue(10.0, B, millas);
 
        dataset.addValue(4.0, C, vel);
        dataset.addValue(2.0, C, usuarios);
        dataset.addValue(3.0, C, millas);
 
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Grafica de opiniones", 
                "Categoria", 
                "Puntuacion", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false);
 
        ChartPanel panel = new ChartPanel(barChart);
 
        return panel;
 
    }
	
	
	
}
