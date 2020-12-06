package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Administrativo;
import logico.Persona;
import logico.Prodacom;
import logico.Vendedor;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegTrabajadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JPanel panel_Administrativo;
	private JLabel lblCorreo_admin;
	private JLabel lblContrasena_admin;
	private JTextField txtUsuario_admin;
	private JTextField txtContrasenna_admin;
	private JSpinner spnSueldo_admin;
	private JLabel lblSueldo;
	private JPanel panel_Vendedor;
	private JLabel lblComision_vendedor;
	private JLabel lblFavor_vendedor;
	private JSpinner spnComision_vendedor;
	private JRadioButton rdbAdministrativo;
	private JRadioButton rdbVendedor;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegTrabajadores() {
		setModal(false);
		setResizable(false);
		setTitle("Registrar Trabajador");
		setBounds(100, 100, 637, 428);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 591, 133);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(10, 35, 46, 14);
			panel_1.add(lblNewLabel);
			
			JLabel label = new JLabel("Nombre:");
			label.setBounds(10, 84, 73, 14);
			panel_1.add(label);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setBounds(338, 35, 66, 14);
			panel_1.add(lblDireccin);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(338, 84, 66, 14);
			panel_1.add(lblTelfono);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(66, 32, 167, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(66, 81, 167, 20);
			panel_1.add(txtNombre);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(414, 32, 167, 20);
			panel_1.add(txtDireccion);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(414, 81, 167, 20);
			panel_1.add(txtTelefono);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el tipo de trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(10, 155, 591, 74);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbVendedor = new JRadioButton("Vendedor");
			rdbVendedor.setSelected(true);
			rdbVendedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					rdbVendedor.setSelected(true);
					rdbAdministrativo.setSelected(false);
					
					panel_Vendedor.setVisible(true);
					panel_Administrativo.setVisible(false);
					
					lblContrasena_admin.setVisible(false);
					lblCorreo_admin.setVisible(false);
					spnSueldo_admin.setVisible(false);
					txtContrasenna_admin.setVisible(false);
					txtUsuario_admin.setVisible(false);
					
					lblComision_vendedor.setVisible(true);
					lblFavor_vendedor.setVisible(true);
					spnComision_vendedor.setVisible(true);
					
					
				}
			});
			rdbVendedor.setBounds(124, 30, 109, 23);
			panel_2.add(rdbVendedor);
			
			rdbAdministrativo = new JRadioButton("Administrativo");
			rdbAdministrativo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					rdbVendedor.setSelected(false);
					rdbAdministrativo.setSelected(true);
					
					panel_Vendedor.setVisible(false);
					panel_Administrativo.setVisible(true);
					
					lblContrasena_admin.setVisible(true);
					lblCorreo_admin.setVisible(true);
					spnSueldo_admin.setVisible(true);
					txtContrasenna_admin.setVisible(true);
					txtUsuario_admin.setVisible(true);
					
					lblComision_vendedor.setVisible(false);
					lblFavor_vendedor.setVisible(false);
					spnComision_vendedor.setVisible(false);
					
					
				}
			});
			rdbAdministrativo.setBounds(357, 30, 109, 23);
			panel_2.add(rdbAdministrativo);
			
			panel_Vendedor = new JPanel();
			panel_Vendedor.setBorder(new TitledBorder(null, "Informaci\u00F3n Espec\u00EDfica", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_Vendedor.setBounds(10, 240, 591, 95);
			panel.add(panel_Vendedor);
			panel_Vendedor.setLayout(null);
			
			lblComision_vendedor = new JLabel("Comisi\u00F3n:");
			lblComision_vendedor.setBounds(10, 39, 75, 14);
			panel_Vendedor.add(lblComision_vendedor);
			
			spnComision_vendedor = new JSpinner();
			spnComision_vendedor.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(100), new Float(1)));
			spnComision_vendedor.setBounds(69, 36, 119, 20);
			panel_Vendedor.add(spnComision_vendedor);
			
			lblFavor_vendedor = new JLabel("(Favor de ingresar el porciento que tendr\u00E1 de comisi\u00F3n por venta.)");
			lblFavor_vendedor.setEnabled(false);
			lblFavor_vendedor.setBounds(198, 39, 383, 14);
			panel_Vendedor.add(lblFavor_vendedor);
			
			panel_Administrativo = new JPanel();
			panel_Administrativo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Espec\u00EDfica", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Administrativo.setBounds(10, 240, 591, 95);
			panel.add(panel_Administrativo);
			panel_Administrativo.setLayout(null);
			
			lblCorreo_admin = new JLabel("Nombre usuario:");
			lblCorreo_admin.setBounds(10, 30, 98, 14);
			lblCorreo_admin.setVisible(false);
			panel_Administrativo.add(lblCorreo_admin);
			lblContrasena_admin = new JLabel("Contrase\u00F1a:");
			lblContrasena_admin.setBounds(10, 70, 98, 14);
			lblContrasena_admin.setVisible(false);
			panel_Administrativo.add(lblContrasena_admin);
			
			txtUsuario_admin = new JTextField();
			txtUsuario_admin.setBounds(118, 27, 162, 20);
			txtUsuario_admin.setVisible(false);
			panel_Administrativo.add(txtUsuario_admin);
			txtUsuario_admin.setColumns(10);
			
			txtContrasenna_admin = new JTextField();
			txtContrasenna_admin.setColumns(10);
			txtContrasenna_admin.setBounds(118, 67, 162, 20);
			txtContrasenna_admin.setVisible(false);
			panel_Administrativo.add(txtContrasenna_admin);
			
			lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setBounds(361, 30, 69, 14);
			lblSueldo.setVisible(false);
			panel_Administrativo.add(lblSueldo);
			
			spnSueldo_admin = new JSpinner();
			spnSueldo_admin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnSueldo_admin.setBounds(423, 27, 106, 20);
			spnSueldo_admin.setVisible(false);
			panel_Administrativo.add(spnSueldo_admin);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Persona aux = null;
						String nombre = txtNombre.getText();
						String cedula = txtCedula.getText();
						String direccion = txtDireccion.getText();
						String telefono = txtTelefono.getText();
						if(txtCedula.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ha dejado espacios vacios en información General!!\nFAVOR DE LLENARLOS CORRECTAMENTE.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
						if(rdbVendedor.isSelected()) {
							float comision = Float.parseFloat(spnComision_vendedor.getValue().toString());
							aux = new Vendedor(nombre, cedula, telefono, direccion, 0, comision, 0);
							Prodacom.getInstance().insertarPersona(aux);
							//aux = new Vendedor(nombre, cedula, telefono, direccion, totalventas, comision, sueldo)
						}
						
						if(rdbAdministrativo.isSelected()) {
							String usuario = txtUsuario_admin.getText();
							String contrasena = txtContrasenna_admin.getText();
							float sueldo = Float.parseFloat(spnSueldo_admin.getValue().toString());
							aux = new Administrativo(nombre, cedula, telefono, direccion, usuario, contrasena, sueldo);
							Prodacom.getInstance().insertarPersona(aux);
						}
						clear();
						JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente al empleado!!", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
					}

	
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clear() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		
		txtContrasenna_admin.setText("");
		txtUsuario_admin.setText("");
		spnSueldo_admin.setValue(new Integer(0));
		
		spnComision_vendedor.setValue(new Integer(0));
		
	}
}
