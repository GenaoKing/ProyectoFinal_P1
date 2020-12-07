package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Prodacom;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Opinion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnPregC;
	private JSpinner spnPregB;
	private JSpinner spnPregA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Opinion dialog = new Opinion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Opinion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Opinion.class.getResource("/iconos/Notepad-Bloc-notes-2-icon.png")));
		setTitle("Opiniones Empresa\r\n");
		setBounds(100, 100, 622, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.DARK_GRAY);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(184, 134, 11)));
			panel.setBackground(new Color(0, 139, 139));
			panel.setForeground(UIManager.getColor("Button.focus"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.DARK_GRAY);
			panel_1.setBackground(Color.BLACK);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Instrucciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_1.setBounds(10, 11, 576, 101);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Las puntuaciones seran del 1 al 3.");
			lblNewLabel.setForeground(new Color(250, 250, 210));
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 21, 218, 22);
			panel_1.add(lblNewLabel);
			{
				JLabel lblmalintermedioexcelente = new JLabel("1-Mal.     2-Intermedio.     3-Excelente.\r\n");
				lblmalintermedioexcelente.setForeground(new Color(250, 250, 210));
				lblmalintermedioexcelente.setBackground(UIManager.getColor("Button.focus"));
				lblmalintermedioexcelente.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblmalintermedioexcelente.setBounds(10, 47, 268, 22);
				panel_1.add(lblmalintermedioexcelente);
			}
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(288, 21, 10, 69);
			panel_1.add(separator);
			{
				JLabel lblNewLabel_1 = new JLabel("Favor de seleccionar en los cuadros su ");
				lblNewLabel_1.setForeground(new Color(250, 250, 210));
				lblNewLabel_1.setBackground(UIManager.getColor("Button.focus"));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(308, 27, 258, 14);
				panel_1.add(lblNewLabel_1);
			}
			{
				JLabel lblValoracion = new JLabel("valoraci\u00F3n.\r\n");
				lblValoracion.setBackground(UIManager.getColor("Button.focus"));
				lblValoracion.setForeground(new Color(250, 250, 210));
				lblValoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblValoracion.setBounds(308, 53, 258, 14);
				panel_1.add(lblValoracion);
			}
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.DARK_GRAY);
			panel_2.setBackground(Color.BLACK);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pregunta #1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_2.setBounds(10, 123, 576, 77);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Que tan satisfecho se encuentra de la empresa en general.");
			lblNewLabel_2.setForeground(new Color(250, 250, 210));
			lblNewLabel_2.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(10, 11, 556, 23);
			panel_2.add(lblNewLabel_2);
			
			spnPregA = new JSpinner();
			spnPregA.setForeground(new Color(250, 250, 210));
			spnPregA.setBackground(UIManager.getColor("Button.focus"));
			spnPregA.setModel(new SpinnerNumberModel(3, 1, 3, 1));
			spnPregA.setBounds(89, 45, 111, 20);
			panel_2.add(spnPregA);
			
			JLabel lblNewLabel_3 = new JLabel("Respuesta:");
			lblNewLabel_3.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_3.setForeground(new Color(250, 250, 210));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(10, 45, 90, 17);
			panel_2.add(lblNewLabel_3);
			
			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.DARK_GRAY);
			panel_3.setBackground(Color.BLACK);
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pregunta #2", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_3.setBounds(10, 214, 576, 77);
			panel.add(panel_3);
			
			JLabel lblCuanProbableEs = new JLabel("Cuan probable es que recomiende nuestros servicios.");
			lblCuanProbableEs.setBackground(UIManager.getColor("Button.focus"));
			lblCuanProbableEs.setForeground(new Color(250, 250, 210));
			lblCuanProbableEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCuanProbableEs.setBounds(10, 11, 556, 23);
			panel_3.add(lblCuanProbableEs);
			
			spnPregB = new JSpinner();
			spnPregB.setBackground(UIManager.getColor("Button.focus"));
			spnPregB.setForeground(new Color(250, 250, 210));
			spnPregB.setModel(new SpinnerNumberModel(3, 1, 3, 1));
			spnPregB.setBounds(89, 45, 111, 20);
			panel_3.add(spnPregB);
			
			JLabel label_1 = new JLabel("Respuesta:");
			label_1.setBackground(UIManager.getColor("Button.focus"));
			label_1.setForeground(new Color(250, 250, 210));
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(10, 45, 90, 17);
			panel_3.add(label_1);
			
			JPanel panel_4 = new JPanel();
			panel_4.setForeground(Color.DARK_GRAY);
			panel_4.setBackground(Color.BLACK);
			panel_4.setLayout(null);
			panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pregunta #3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_4.setBounds(10, 302, 576, 77);
			panel.add(panel_4);
			
			JLabel lblComoCalificaraLa = new JLabel("Como calificar\u00EDa la calidad de la atenci\u00F3n recibida");
			lblComoCalificaraLa.setForeground(new Color(250, 250, 210));
			lblComoCalificaraLa.setBackground(UIManager.getColor("Button.focus"));
			lblComoCalificaraLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblComoCalificaraLa.setBounds(10, 11, 556, 23);
			panel_4.add(lblComoCalificaraLa);
			
			spnPregC = new JSpinner();
			spnPregC.setForeground(new Color(250, 250, 210));
			spnPregC.setBackground(UIManager.getColor("Button.focus"));
			spnPregC.setModel(new SpinnerNumberModel(3, 1, 3, 1));
			spnPregC.setBounds(90, 45, 111, 20);
			panel_4.add(spnPregC);
			
			JLabel label_2 = new JLabel("Respuesta:");
			label_2.setBackground(UIManager.getColor("Button.focus"));
			label_2.setForeground(new Color(250, 250, 210));
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_2.setBounds(10, 45, 90, 17);
			panel_4.add(label_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar");
				okButton.setIcon(new ImageIcon(Opinion.class.getResource("/iconos/select.png")));
				okButton.setBackground(new Color(47, 79, 79));
				okButton.setForeground(new Color(0, 255, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(Integer.valueOf(spnPregA.getValue().toString())==1) {
							//Prodacom.getInstance().setMal[0](Prodacom.getInstance().getMal()[0]);
							//Prodacom.getInstance().setMal(Prodacom.getInstance().getMal()[0]+1);
							
						}
						if(Integer.valueOf(spnPregA.getValue().toString())==2) {
							Prodacom.getInstance().setMal(Prodacom.getInstance().getMal());
						}
						if(Integer.valueOf(spnPregA.getValue().toString())==3) {
							
							
							
							
						}
						
						
						if(Integer.valueOf(spnPregA.getValue().toString())==1) {
							
						}
						if(Integer.valueOf(spnPregA.getValue().toString())==2) {
							
						}
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(Opinion.class.getResource("/iconos/cancel.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(new Color(47, 79, 79));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
