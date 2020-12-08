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
import java.awt.Toolkit;

public class GraficOpinion extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public GraficOpinion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficOpinion.class.getResource("/iconos/Data-Meter-icon.png")));
		setModal(true);
		setBounds(100, 100, 816, 482);
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
    String B = "C) Como calificaria la calidad de la atencion recibida?"; 
    String C = "B) Cuan probable es que recomiende nuestros servicios.";
        
    String mal = "Mal";
    String Excelente = "Excelente";
    String Intermedio = "Intermedio";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
     
        dataset.addValue(Prodacom.getInstance().getMal(0), A, mal);
        dataset.addValue(Prodacom.getInstance().getMal(1), A, Intermedio);
        dataset.addValue(Prodacom.getInstance().getMal(2), A, Excelente);
        
        dataset.addValue(Prodacom.getInstance().getIntermedio(0), C, mal);
        dataset.addValue(Prodacom.getInstance().getIntermedio(1), C, Intermedio);
        dataset.addValue(Prodacom.getInstance().getIntermedio(2), C, Excelente);
        
        dataset.addValue(Prodacom.getInstance().getExcelente(0), B, mal);
        dataset.addValue(Prodacom.getInstance().getExcelente(1), B, Intermedio);
        dataset.addValue(Prodacom.getInstance().getExcelente(2), B, Excelente);
        
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Ópinion de nuestros clientes", 
                "Categoria", 
                "Votos", 
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
