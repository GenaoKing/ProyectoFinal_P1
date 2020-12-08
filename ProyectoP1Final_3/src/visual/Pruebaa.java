package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SpinnerNumberModel;

public class RegQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable table;
	private JPanel panel_Esferico;
	private JPanel panel_Cilindrico;
	private JPanel panel_CilindricoHueco;
	private JSpinner spnCostoBase;
	private JSpinner spnCostoUnitario;
	private JRadioButton rdbEsferico;
	private JRadioButton rdbCilindrico;
	private JRadioButton rdbCilindricoHueco;
	private JSpinner spnRadioEsferico;
	private JLabel lblRadioEsferico;
	private JSpinner spnLongitudCilindrico;
	private JLabel lblRadioCilindricoHueco;
	private JSpinner spnRadioCilindroHueco;
	private JLabel lblLongitudCilindroHueco;
	private JSpinner spnLongitudCilindricoHueco;
	private JLabel lblRadioInternoCilindroHueco;
	private JSpinner spnRadioInterno;
	private JLabel lblLongitudCilindro;
	private JLabel lblRadioCilindrico;
	private JSpinner spnRadioCilindrico;
	
	
	//public static DefaultTableModel modelo;
	//public static Object[] fila;
	//private JButton btnModificar;
	//private JButton cancelButton;
	//private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			RegQuesos dialog = new RegQuesos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public RegQuesos() {
		setBackground(new Color(51, 0, 0));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegQuesos.class.getResource("/icon/Cheese-icon.png")));
		setTitle("Registrar Queso");
		setBounds(100, 100, 635, 419);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
			panel_1.setForeground(UIManager.getColor("Button.focus"));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 0, 0)));
			panel_1.setBounds(10, 11, 599, 89);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Costo Base:");
				lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
				lblNewLabel.setForeground(new Color(51, 0, 0));
				lblNewLabel.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/dollar.png")));
				lblNewLabel.setBounds(10, 30, 106, 14);
				panel_1.add(lblNewLabel);
			}
			{
				JLabel lblCostoUnitario = new JLabel("Costo Unitario:");
				lblCostoUnitario.setForeground(new Color(51, 0, 0));
				lblCostoUnitario.setBackground(UIManager.getColor("Button.focus"));
				lblCostoUnitario.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/dollar.png")));
				lblCostoUnitario.setBounds(210, 30, 128, 14);
				panel_1.add(lblCostoUnitario);
			}
			
			spnCostoBase = new JSpinner();
			spnCostoBase.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCostoBase.setForeground(new Color(102, 0, 0));
			spnCostoBase.setBackground(UIManager.getColor("Button.focus"));
			spnCostoBase.setBounds(126, 27, 63, 20);
			panel_1.add(spnCostoBase);
			
			spnCostoUnitario = new JSpinner();
			spnCostoUnitario.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCostoUnitario.setBackground(UIManager.getColor("Button.focus"));
			spnCostoUnitario.setForeground(new Color(102, 0, 0));
			spnCostoUnitario.setBounds(334, 27, 63, 20);
			panel_1.add(spnCostoUnitario);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setForeground(new Color(51, 0, 0));
				lblNombre.setBackground(UIManager.getColor("Button.focus"));
				lblNombre.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/dollar.png")));
				lblNombre.setBounds(418, 30, 75, 14);
				panel_1.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setForeground(UIManager.getColor("Button.focus"));
				txtNombre.setBackground(Color.WHITE);
				txtNombre.setBounds(503, 27, 86, 20);
				panel_1.add(txtNombre);
				txtNombre.setColumns(10);
			}
		}
		{
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(UIManager.getColor("Button.focus"));
			panel_2.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 0, 0)));
			panel_2.setBounds(10, 111, 599, 86);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbEsferico = new JRadioButton("Queso Esferico");
			rdbEsferico.setForeground(new Color(51, 0, 0));
			rdbEsferico.setBackground(UIManager.getColor("Button.focus"));
			rdbEsferico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbEsferico.setSelected(true);
					rdbCilindrico.setSelected(false);
					rdbCilindricoHueco.setSelected(false);
					
					panel_Esferico.setVisible(true);
					panel_Cilindrico.setVisible(false);
					panel_CilindricoHueco.setVisible(false);
					
					lblRadioEsferico.setVisible(true);
					spnRadioEsferico.setVisible(true);
					
					lblLongitudCilindro.setVisible(false);
					spnLongitudCilindrico.setVisible(false);
					lblRadioCilindrico.setVisible(false);
					spnRadioCilindrico.setVisible(false);
					
					lblRadioCilindricoHueco.setVisible(false);
					spnRadioCilindroHueco.setVisible(false);
					lblLongitudCilindroHueco.setVisible(false);
					spnLongitudCilindricoHueco.setVisible(false);
					lblRadioInternoCilindroHueco.setVisible(false);
					spnRadioInterno.setVisible(false);
					
				}
			});
			rdbEsferico.setBounds(57, 31, 152, 23);
			panel_2.add(rdbEsferico);
			
			rdbCilindrico = new JRadioButton("Queso Cil\u00EDndrico");
			rdbCilindrico.setBackground(UIManager.getColor("Button.focus"));
			rdbCilindrico.setForeground(new Color(51, 0, 0));
			rdbCilindrico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbEsferico.setSelected(false);
					rdbCilindrico.setSelected(true);
					rdbCilindricoHueco.setSelected(false);
					
					panel_Esferico.setVisible(false);
					panel_Cilindrico.setVisible(true);
					panel_CilindricoHueco.setVisible(false);
					
					lblRadioEsferico.setVisible(false);
					spnRadioEsferico.setVisible(false);
					
					lblLongitudCilindro.setVisible(true);
					spnLongitudCilindrico.setVisible(true);
					lblRadioCilindrico.setVisible(true);
					spnRadioCilindrico.setVisible(true);
					
					lblRadioCilindricoHueco.setVisible(false);
					spnRadioCilindroHueco.setVisible(false);
					lblLongitudCilindroHueco.setVisible(false);
					spnLongitudCilindricoHueco.setVisible(false);
					lblRadioInternoCilindroHueco.setVisible(false);
					spnRadioInterno.setVisible(false);
				}
			});
			rdbCilindrico.setBounds(223, 31, 152, 23);
			panel_2.add(rdbCilindrico);
			
			rdbCilindricoHueco = new JRadioButton("Queso Cil\u00EDndrico hueco");
			rdbCilindricoHueco.setSelected(true);
			rdbCilindricoHueco.setBackground(UIManager.getColor("Button.focus"));
			rdbCilindricoHueco.setForeground(new Color(51, 0, 0));
			rdbCilindricoHueco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbEsferico.setSelected(false);
					rdbCilindrico.setSelected(false);
					rdbCilindricoHueco.setSelected(true);
					
					panel_Esferico.setVisible(false);
					panel_Cilindrico.setVisible(false);
					panel_CilindricoHueco.setVisible(true);
					
					lblRadioEsferico.setVisible(false);
					spnRadioEsferico.setVisible(false);
					
					lblLongitudCilindro.setVisible(false);
					spnLongitudCilindrico.setVisible(false);
					lblRadioCilindrico.setVisible(false);
					spnRadioCilindrico.setVisible(false);
					
					lblRadioCilindricoHueco.setVisible(true);
					spnRadioCilindroHueco.setVisible(true);
					lblLongitudCilindroHueco.setVisible(true);
					spnLongitudCilindricoHueco.setVisible(true);
					lblRadioInternoCilindroHueco.setVisible(true);
					spnRadioInterno.setVisible(true);
				}
			});
			rdbCilindricoHueco.setBounds(389, 31, 190, 23);
			panel_2.add(rdbCilindricoHueco);
		}
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//panel_Esferico.add(scrollPane, BorderLayout.CENTER);
		
		//modelo = new DefaultTableModel();
		//String columns[] = {"Cedula","Nombre","Direccion","Telefono"};
		//modelo.setColumnIdentifiers(columns);
		table = new JTable();
		
		panel_CilindricoHueco = new JPanel();
		panel_CilindricoHueco.setForeground(UIManager.getColor("Button.focus"));
		panel_CilindricoHueco.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		panel_CilindricoHueco.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Quesos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 0, 0)));
		panel_CilindricoHueco.setBounds(10, 210, 599, 86);
		contentPanel.add(panel_CilindricoHueco);
		panel_CilindricoHueco.setLayout(null);
		
		lblRadioCilindricoHueco = new JLabel("Radio:");
		lblRadioCilindricoHueco.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Music-Radio-2-icon.png")));
		lblRadioCilindricoHueco.setForeground(new Color(51, 0, 0));
		lblRadioCilindricoHueco.setBackground(UIManager.getColor("Button.focus"));
		lblRadioCilindricoHueco.setBounds(10, 40, 98, 14);
		panel_CilindricoHueco.add(lblRadioCilindricoHueco);
		
		spnRadioCilindroHueco = new JSpinner();
		spnRadioCilindroHueco.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadioCilindroHueco.setForeground(new Color(51, 0, 0));
		spnRadioCilindroHueco.setBackground(UIManager.getColor("Button.focus"));
		spnRadioCilindroHueco.setBounds(67, 37, 64, 20);
		panel_CilindricoHueco.add(spnRadioCilindroHueco);
		
		lblLongitudCilindroHueco = new JLabel("Longitud:");
		lblLongitudCilindroHueco.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Science-Length-icon.png")));
		lblLongitudCilindroHueco.setForeground(new Color(51, 0, 0));
		lblLongitudCilindroHueco.setBackground(UIManager.getColor("Button.focus"));
		lblLongitudCilindroHueco.setBounds(232, 40, 91, 14);
		panel_CilindricoHueco.add(lblLongitudCilindroHueco);
		
		spnLongitudCilindricoHueco = new JSpinner();
		spnLongitudCilindricoHueco.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLongitudCilindricoHueco.setBackground(UIManager.getColor("Button.focus"));
		spnLongitudCilindricoHueco.setForeground(new Color(51, 0, 0));
		spnLongitudCilindricoHueco.setBounds(305, 37, 64, 20);
		panel_CilindricoHueco.add(spnLongitudCilindricoHueco);
		
		lblRadioInternoCilindroHueco = new JLabel("RadioInterno:");
		lblRadioInternoCilindroHueco.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Music-Radio-2-icon.png")));
		lblRadioInternoCilindroHueco.setForeground(new Color(51, 0, 0));
		lblRadioInternoCilindroHueco.setBackground(UIManager.getColor("Button.focus"));
		lblRadioInternoCilindroHueco.setBounds(413, 40, 125, 14);
		panel_CilindricoHueco.add(lblRadioInternoCilindroHueco);
		
		spnRadioInterno = new JSpinner();
		spnRadioInterno.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadioInterno.setForeground(new Color(51, 0, 0));
		spnRadioInterno.setBackground(UIManager.getColor("Button.focus"));
		spnRadioInterno.setBounds(518, 37, 71, 20);
		panel_CilindricoHueco.add(spnRadioInterno);
		
		panel_Esferico = new JPanel();
		panel_Esferico.setForeground(UIManager.getColor("Button.focus"));
		panel_Esferico.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		panel_Esferico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Quesos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 0, 0)));
		panel_Esferico.setBounds(10, 210, 599, 86);
		contentPanel.add(panel_Esferico);
		panel_Esferico.setLayout(null);
		
		spnRadioEsferico = new JSpinner();
		spnRadioEsferico.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadioEsferico.setForeground(new Color(51, 0, 0));
		spnRadioEsferico.setBackground(UIManager.getColor("Button.focus"));
		spnRadioEsferico.setBounds(81, 37, 120, 20);
		spnRadioEsferico.setVisible(false);
		panel_Esferico.add(spnRadioEsferico);
		
		lblRadioEsferico = new JLabel("Radio:");
		lblRadioEsferico.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Music-Radio-2-icon.png")));
		lblRadioEsferico.setForeground(new Color(51, 0, 0));
		lblRadioEsferico.setBackground(UIManager.getColor("Button.focus"));
		lblRadioEsferico.setBounds(10, 40, 100, 14);
		lblRadioEsferico.setVisible(false);
		panel_Esferico.add(lblRadioEsferico);
		
		panel_Cilindrico = new JPanel();
		panel_Cilindrico.setForeground(UIManager.getColor("Button.focus"));
		panel_Cilindrico.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		panel_Cilindrico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Quesos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 0, 0)));
		panel_Cilindrico.setBounds(10, 210, 599, 86);
		contentPanel.add(panel_Cilindrico);
		panel_Cilindrico.setLayout(null);
		
		lblRadioCilindrico = new JLabel("Radio:");
		lblRadioCilindrico.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Music-Radio-2-icon.png")));
		lblRadioCilindrico.setBackground(UIManager.getColor("Button.focus"));
		lblRadioCilindrico.setForeground(new Color(51, 0, 0));
		lblRadioCilindrico.setBounds(10, 40, 84, 14);
		lblRadioCilindrico.setVisible(false);
		panel_Cilindrico.add(lblRadioCilindrico);
		
		spnRadioCilindrico = new JSpinner();
		spnRadioCilindrico.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadioCilindrico.setForeground(new Color(51, 0, 0));
		spnRadioCilindrico.setBackground(UIManager.getColor("Button.focus"));
		spnRadioCilindrico.setBounds(77, 37, 60, 20);
		spnRadioCilindrico.setVisible(false);
		panel_Cilindrico.add(spnRadioCilindrico);
		
		lblLongitudCilindro = new JLabel("Longitud:");
		lblLongitudCilindro.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/Science-Length-icon.png")));
		lblLongitudCilindro.setForeground(new Color(51, 0, 0));
		lblLongitudCilindro.setBackground(UIManager.getColor("Button.focus"));
		lblLongitudCilindro.setBounds(222, 40, 110, 14);
		lblLongitudCilindro.setVisible(false);
		panel_Cilindrico.add(lblLongitudCilindro);
		
		spnLongitudCilindrico = new JSpinner();
		spnLongitudCilindrico.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnLongitudCilindrico.setForeground(new Color(51, 0, 0));
		spnLongitudCilindrico.setBackground(UIManager.getColor("Button.focus"));
		spnLongitudCilindrico.setBounds(296, 37, 60, 20);
		spnLongitudCilindrico.setVisible(false);
		panel_Cilindrico.add(spnLongitudCilindrico);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(new Color(0, 0, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/registrer.png")));
				okButton.setForeground(Color.BLUE);
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Queso aux = null;
						float CostoBase = Float.parseFloat(spnCostoBase.getValue().toString());
						float CostoUnitario = Float.parseFloat(spnCostoUnitario.getValue().toString());
						String nombre = txtNombre.getText();
						String Codigo = Integer.toString(Queseria.cod_quesos);
						
						if(rdbEsferico.isSelected()) {
							float radio = Float.parseFloat(spnRadioEsferico.getValue().toString());
							//float valor = Queseria.getInstance().getMisQuesos().get(Queseria.cod_quesos-1).calcularPrecio();
							aux = new Esfera(CostoBase, CostoUnitario, nombre, Codigo, 0, radio);
							Queseria.getInstance().InsertarQueso(aux);
						}
						if(rdbCilindrico.isSelected()) {
							float radio = Float.parseFloat(spnRadioCilindrico.getValue().toString());
							//float valor = Queseria.getInstance().getMisQuesos().get(Queseria.cod_quesos-1).calcularPrecio();
							float longitud = Float.parseFloat(spnLongitudCilindrico.getValue().toString());
							aux = new QuesoCilindro(CostoBase, CostoUnitario, nombre, Codigo, 0, radio, longitud);
							Queseria.getInstance().InsertarQueso(aux);
						}
						if(rdbCilindricoHueco.isSelected()) {
							float radio = Float.parseFloat(spnRadioCilindroHueco.getValue().toString());
							float longitud = Float.parseFloat(spnLongitudCilindricoHueco.getValue().toString());
							//float valor = Queseria.getInstance().getMisQuesos().get(Queseria.cod_quesos-1).calcularPrecio();
							float radioInterno = Float.parseFloat(spnRadioInterno.getValue().toString());
							aux = new QuesoCilindroHueco(CostoBase, CostoUnitario, nombre, Codigo, 0, radio, longitud, radioInterno);
							Queseria.getInstance().InsertarQueso(aux);
						}
						JOptionPane.showMessageDialog(null, "El queso ha sido registrado con exito. ", "información", JOptionPane.INFORMATION_MESSAGE);				

						Limpiar();
						
					}

					private void Limpiar() {
						
						txtNombre.setText("");
						spnCostoBase.setValue(new Integer(1));
						spnCostoUnitario.setValue(new Integer(1));
						
						spnRadioEsferico.setValue(new Integer(1));
						spnRadioCilindrico.setValue(new Integer(1));
						spnLongitudCilindrico.setValue(new Integer(1));
						spnLongitudCilindricoHueco.setValue(new Integer(1));
						spnRadioInterno.setValue(new Integer(1));
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(RegQuesos.class.getResource("/icon/delete.png")));
				cancelButton.setForeground(Color.BLUE);
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//cargarTabla();
	}
/*
	private void cargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
		for(Cliente client : Queseria.getInstance().getMisClientes()){
			fila[0] = client.getCedula();
			fila[1] = client.getNombre();
			fila[2] = client.getDireccion();
			fila[3] = client.getTelefono();
			modelo.addRow(fila);
		}
		
	}
*/
}
