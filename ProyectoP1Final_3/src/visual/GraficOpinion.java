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

public class GraficOpinion extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public GraficOpinion() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		ChartPanel panel = Barras3d();
		getContentPane().add(panel);
		
		/*
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		*/
	}
	
private ChartPanel Barras3d() {
		
	String A = "A) Que tan satisfecho se encuentra de la empresa en general.";
    String B = "B) Cuan probable es que recomiende nuestros servicios.";
    String C = "C) Como calificaria la calidad de la atencion recibida?";
        
    String mal = "Mal";
    String Excelente = "Excelente";
    String Intermedio = "Intermedio";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(0.0d, A, mal);
        dataset.addValue(0.0d, B, Excelente);
        dataset.addValue(0.0d, C, Intermedio);
        
        
        dataset.addValue(5.0, A, mal);
        dataset.addValue(6.0, B, Excelente);
        dataset.addValue(10.0, C, Intermedio);
 
        dataset.addValue(4.0, A, mal);
        dataset.addValue(2.0, B, Excelente);
        dataset.addValue(3.0, C, Intermedio);
        
        
        /*
        dataset.addValue(Prodacom.getInstance().getTotDisco(), A, vel);
        dataset.addValue(Prodacom.getInstance().getTotMotherboard(), B, vel);
        dataset.addValue(Prodacom.getInstance().getTotMemoriaRam(), C, vel);
        dataset.addValue(Prodacom.getInstance().getTotMicroprocesadores(), D, vel);
 		*/
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
