package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class IngresoComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerie;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField textField_3;
	private JTextField textField_4;
	private JSpinner spnCantMaxima;
	private JSpinner spnCantReal;
	private JSpinner spnCantMinima;
	private JSpinner spnCompra;
	private JLabel lblPrecioVenta;
	private JLabel lblConector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IngresoComponentes dialog = new IngresoComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IngresoComponentes() {
		setBounds(100, 100, 789, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 753, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serie:");
		lblNewLabel.setBounds(10, 25, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(146, 25, 46, 14);
		panel.add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(306, 25, 46, 14);
		panel.add(lblMarca);
		
		txtSerie = new JTextField();
		txtSerie.setBounds(50, 22, 86, 20);
		panel.add(txtSerie);
		txtSerie.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(202, 22, 86, 20);
		panel.add(txtModelo);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(354, 22, 86, 20);
		panel.add(txtMarca);
		
		JLabel lblPrecio = new JLabel("Compra:");
		lblPrecio.setBounds(450, 25, 58, 14);
		panel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad M\u00EDnima:");
		lblCantidad.setBounds(10, 75, 99, 14);
		panel.add(lblCantidad);
		
		spnCompra = new JSpinner();
		spnCompra.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnCompra.setBounds(500, 22, 89, 20);
		panel.add(spnCompra);
		
		spnCantMinima = new JSpinner();
		spnCantMinima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantMinima.setBounds(101, 72, 127, 20);
		panel.add(spnCantMinima);
		
		lblPrecioVenta = new JLabel("Venta:");
		lblPrecioVenta.setBounds(600, 25, 76, 14);
		panel.add(lblPrecioVenta);
		
		JSpinner spnVenta = new JSpinner();
		spnVenta.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnVenta.setBounds(642, 22, 89, 20);
		panel.add(spnVenta);
		
		JLabel lblCantidadReal = new JLabel("Cantidad Real:");
		lblCantidadReal.setBounds(253, 75, 99, 14);
		panel.add(lblCantidadReal);
		
		spnCantReal = new JSpinner();
		spnCantReal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantReal.setBounds(352, 72, 127, 20);
		panel.add(spnCantReal);
		
		JLabel lblCantidadMxima = new JLabel("Cantidad M\u00E1xima:");
		lblCantidadMxima.setBounds(513, 75, 99, 14);
		panel.add(lblCantidadMxima);
		
		spnCantMaxima = new JSpinner();
		spnCantMaxima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantMaxima.setBounds(604, 72, 127, 20);
		panel.add(spnCantMaxima);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Seleccione", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 753, 57);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("MemoriaRam");
		rdbtnNewRadioButton.setBounds(245, 23, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDisco = new JRadioButton("Disco");
		rdbtnDisco.setBounds(589, 23, 109, 23);
		panel_1.add(rdbtnDisco);
		
		JRadioButton rdbtnMicroprocesadores = new JRadioButton("Microprocesadores");
		rdbtnMicroprocesadores.setBounds(407, 23, 129, 23);
		panel_1.add(rdbtnMicroprocesadores);
		
		JRadioButton rdbtnMotherboard = new JRadioButton("MotherBoard");
		rdbtnMotherboard.setSelected(true);
		rdbtnMotherboard.setBounds(53, 23, 139, 23);
		panel_1.add(rdbtnMotherboard);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 207, 753, 177);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(570, 11, 173, 155);
		panel_2.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(334, 11, 173, 155);
		panel_2.add(scrollPane_1);
		
		lblConector = new JLabel("Conexion");
		lblConector.setBounds(10, 49, 64, 14);
		panel_2.add(lblConector);
		
		JLabel lblTipoRam = new JLabel("TipoRam:");
		lblTipoRam.setBounds(10, 112, 64, 14);
		panel_2.add(lblTipoRam);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 46, 125, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 109, 125, 20);
		panel_2.add(textField_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
