package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaPastel extends JFrame {
	/*
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficaPastel frame = new GraficaPastel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraficaPastel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	*/
	
	
	 public static void main(String[] args) 
	    {       
	        
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("IPhone 5s", new Double(20));
	        dataset.setValue("SamSung Grand", new Double(20));
	        dataset.setValue("MotoG", new Double(40));
	        dataset.setValue("Nokia Lumia", new Double(10));
	 
	        
	        JFreeChart chart = ChartFactory.createPieChart(// char t
	                
	                "Mobile Sales",// title                                                                     
	                dataset, // data
	                true, // include legend
	                true, false);
	        
	        
	        ChartPanel panel= new ChartPanel(chart);
	        
	        
	        
	        
	        //Creamos la ventana
	        JFrame ventana = new JFrame("Grafica");
	        ventana.setVisible(true);
	        ventana.setSize(800, 600);
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	        ventana.add(panel);
	        
	 
	    }

}
