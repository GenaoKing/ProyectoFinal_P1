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
import org.jfree.data.general.DefaultPieDataset;

import logico.Prodacom;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class testeo2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public testeo2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(testeo2.class.getResource("/iconos/Bar-Chart-icon.png")));
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setModal(true);
		setBounds(100, 100, 815, 506);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		ChartPanel panel= crear();
		getContentPane().add(panel);
	}

	private ChartPanel crear() {
		float total[] = new float [4];
		total = Prodacom.getInstance().CalcBeneficios_T();
	
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Disco Duro", total[0]);
        dataset.setValue("MotherBoard", total[1]);
        dataset.setValue("Microprocesadores", total[2]);
        dataset.setValue("MemoriaRam", total[3]);
 
        
        JFreeChart chart = ChartFactory.createPieChart(// char t
                
                "Porciento de ganancias por tipo.",// title                                                                     
                dataset, // data
                true, // include legend
                true, false);
        
        
        ChartPanel panel= new ChartPanel(chart);
        panel.setForeground(UIManager.getColor("Button.focus"));
        panel.setBackground(UIManager.getColor("Button.focus"));
		
		return panel;
	}


}
