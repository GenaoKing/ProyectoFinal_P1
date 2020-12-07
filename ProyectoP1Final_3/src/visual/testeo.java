package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Prodacom;

public class testeo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public testeo() {
		setModal(true);
		setBounds(100, 100, 802, 493);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		ChartPanel panel = Barras3d();
		getContentPane().add(panel);
		
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
