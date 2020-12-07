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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
	private JLabel lblSueldo_vendedor;
	private JSpinner spnSueldo_vendedor;
	private JTextField txtUsuario_vendedor;
	private JTextField txtContrasenna_Vendedor;
	private JLabel lblContrasenna_vendedor;
	private JLabel lblUsuario_vendedor;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegTrabajadores() {
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegTrabajadores.class.getResource("/iconos/name.png")));
		setModal(false);
		setResizable(false);
		setTitle("Registrar Trabajador");
		setBounds(100, 100, 637, 428);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 128, 128));
			panel.setForeground(UIManager.getColor("Button.focus"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.DARK_GRAY);
			panel_1.setBackground(Color.BLACK);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_1.setBounds(10, 11, 591, 133);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/cedu.png")));
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setForeground(new Color(250, 250, 210));
			lblNewLabel.setBounds(10, 35, 87, 14);
			panel_1.add(lblNewLabel);
			
			JLabel label = new JLabel("Nombre:");
			label.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/nombre.png")));
			label.setForeground(new Color(250, 250, 210));
			label.setBackground(UIManager.getColor("Button.focus"));
			label.setBounds(10, 84, 73, 14);
			panel_1.add(label);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/ju.png")));
			lblDireccin.setForeground(new Color(250, 250, 210));
			lblDireccin.setBackground(UIManager.getColor("Button.focus"));
			lblDireccin.setBounds(338, 35, 107, 14);
			panel_1.add(lblDireccin);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/tel.png")));
			lblTelfono.setForeground(new Color(250, 250, 210));
			lblTelfono.setBackground(UIManager.getColor("Button.focus"));
			lblTelfono.setBounds(338, 84, 107, 14);
			panel_1.add(lblTelfono);
			
			txtCedula = new JTextField();
			txtCedula.setForeground(new Color(250, 250, 210));
			txtCedula.setBackground(UIManager.getColor("Button.focus"));
			txtCedula.setBounds(107, 32, 126, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBackground(UIManager.getColor("Button.focus"));
			txtNombre.setForeground(new Color(250, 250, 210));
			txtNombre.setColumns(10);
			txtNombre.setBounds(107, 81, 126, 20);
			panel_1.add(txtNombre);
			
			txtDireccion = new JTextField();
			txtDireccion.setForeground(new Color(250, 250, 210));
			txtDireccion.setBackground(UIManager.getColor("Button.focus"));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(455, 32, 126, 20);
			panel_1.add(txtDireccion);
			
			txtTelefono = new JTextField();
			txtTelefono.setBackground(UIManager.getColor("Button.focus"));
			txtTelefono.setForeground(new Color(250, 250, 210));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(455, 81, 126, 20);
			panel_1.add(txtTelefono);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.DARK_GRAY);
			panel_2.setBackground(Color.BLACK);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el tipo de trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_2.setBounds(10, 155, 591, 74);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbVendedor = new JRadioButton("Vendedor");
			rdbVendedor.setBackground(UIManager.getColor("Button.focus"));
			rdbVendedor.setForeground(new Color(250, 250, 210));
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
					lblSueldo.setVisible(false);
					txtContrasenna_admin.setVisible(false);
					txtUsuario_admin.setVisible(false);
					
					lblComision_vendedor.setVisible(true);
					lblFavor_vendedor.setVisible(true);
					spnComision_vendedor.setVisible(true);
					spnSueldo_vendedor.setVisible(true);
					lblSueldo_vendedor.setVisible(true);
					
					lblUsuario_vendedor.setVisible(true);
					txtUsuario_vendedor.setVisible(true);
					lblContrasenna_vendedor.setVisible(true);
					txtContrasenna_Vendedor.setVisible(true);
					
				}
			});
			rdbVendedor.setBounds(124, 30, 109, 23);
			panel_2.add(rdbVendedor);
			
			rdbAdministrativo = new JRadioButton("Administrativo");
			rdbAdministrativo.setForeground(new Color(250, 250, 210));
			rdbAdministrativo.setBackground(UIManager.getColor("Button.focus"));
			rdbAdministrativo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					rdbVendedor.setSelected(false);
					rdbAdministrativo.setSelected(true);
					
					panel_Vendedor.setVisible(false);
					panel_Administrativo.setVisible(true);
					
					lblContrasena_admin.setVisible(true);
					lblCorreo_admin.setVisible(true);
					spnSueldo_admin.setVisible(true);
					lblSueldo.setVisible(true);
					txtContrasenna_admin.setVisible(true);
					txtUsuario_admin.setVisible(true);
					
					lblComision_vendedor.setVisible(false);
					lblFavor_vendedor.setVisible(false);
					spnComision_vendedor.setVisible(false);
					spnSueldo_vendedor.setVisible(false);
					lblSueldo_vendedor.setVisible(false);
					
					lblUsuario_vendedor.setVisible(false);
					txtUsuario_vendedor.setVisible(false);
					lblContrasenna_vendedor.setVisible(false);
					txtContrasenna_Vendedor.setVisible(false);
					
				}
			});
			rdbAdministrativo.setBounds(357, 30, 109, 23);
			panel_2.add(rdbAdministrativo);
			
			panel_Vendedor = new JPanel();
			panel_Vendedor.setForeground(Color.DARK_GRAY);
			panel_Vendedor.setBackground(Color.BLACK);
			panel_Vendedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Espec\u00EDfica", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_Vendedor.setBounds(10, 240, 591, 95);
			panel.add(panel_Vendedor);
			panel_Vendedor.setLayout(null);
			
			lblComision_vendedor = new JLabel("Comisi\u00F3n:");
			lblComision_vendedor.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/bille.png")));
			lblComision_vendedor.setForeground(new Color(250, 250, 210));
			lblComision_vendedor.setBackground(UIManager.getColor("Button.focus"));
			lblComision_vendedor.setBounds(10, 22, 93, 14);
			panel_Vendedor.add(lblComision_vendedor);
			
			spnComision_vendedor = new JSpinner();
			spnComision_vendedor.setForeground(new Color(250, 250, 210));
			spnComision_vendedor.setBackground(UIManager.getColor("Button.focus"));
			spnComision_vendedor.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(100), new Float(1)));
			spnComision_vendedor.setBounds(113, 18, 75, 20);
			panel_Vendedor.add(spnComision_vendedor);
			
			lblFavor_vendedor = new JLabel("(Favor de ingresar el porciento que tendr\u00E1 de comisi\u00F3n por venta.)");
			lblFavor_vendedor.setForeground(new Color(250, 250, 210));
			lblFavor_vendedor.setBackground(UIManager.getColor("Button.focus"));
			lblFavor_vendedor.setEnabled(false);
			lblFavor_vendedor.setBounds(198, 22, 383, 14);
			panel_Vendedor.add(lblFavor_vendedor);
			
			lblSueldo_vendedor = new JLabel("Sueldo:");
			lblSueldo_vendedor.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/dinero.png")));
			lblSueldo_vendedor.setBackground(UIManager.getColor("Button.focus"));
			lblSueldo_vendedor.setForeground(new Color(250, 250, 210));
			lblSueldo_vendedor.setBounds(10, 58, 93, 14);
			panel_Vendedor.add(lblSueldo_vendedor);
			
			spnSueldo_vendedor = new JSpinner();
			spnSueldo_vendedor.setBackground(UIManager.getColor("Button.focus"));
			spnSueldo_vendedor.setForeground(new Color(250, 250, 210));
			spnSueldo_vendedor.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnSueldo_vendedor.setBounds(113, 56, 75, 20);
			panel_Vendedor.add(spnSueldo_vendedor);
			
			lblUsuario_vendedor = new JLabel("Usuario:");
			lblUsuario_vendedor.setForeground(new Color(250, 250, 210));
			lblUsuario_vendedor.setBackground(Color.BLACK);
			lblUsuario_vendedor.setBounds(225, 58, 93, 14);
			panel_Vendedor.add(lblUsuario_vendedor);
			
			txtUsuario_vendedor = new JTextField();
			txtUsuario_vendedor.setBounds(282, 55, 99, 20);
			panel_Vendedor.add(txtUsuario_vendedor);
			txtUsuario_vendedor.setColumns(10);
			
			txtContrasenna_Vendedor = new JTextField();
			txtContrasenna_Vendedor.setColumns(10);
			txtContrasenna_Vendedor.setBounds(482, 55, 99, 20);
			panel_Vendedor.add(txtContrasenna_Vendedor);
			
			lblContrasenna_vendedor = new JLabel("Contrase\u00F1a:");
			lblContrasenna_vendedor.setForeground(new Color(250, 250, 210));
			lblContrasenna_vendedor.setBackground(Color.BLACK);
			lblContrasenna_vendedor.setBounds(401, 58, 93, 14);
			panel_Vendedor.add(lblContrasenna_vendedor);
			
			panel_Administrativo = new JPanel();
			panel_Administrativo.setForeground(Color.DARK_GRAY);
			panel_Administrativo.setBackground(Color.BLACK);
			panel_Administrativo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Espec\u00EDfica", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_Administrativo.setBounds(10, 240, 591, 95);
			panel.add(panel_Administrativo);
			panel_Administrativo.setLayout(null);
			
			lblCorreo_admin = new JLabel("Nombre usuario:");
			lblCorreo_admin.setBackground(UIManager.getColor("Button.focus"));
			lblCorreo_admin.setForeground(new Color(250, 250, 210));
			lblCorreo_admin.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/nombre.png")));
			lblCorreo_admin.setBounds(10, 30, 119, 14);
			lblCorreo_admin.setVisible(false);
			panel_Administrativo.add(lblCorreo_admin);
			lblContrasena_admin = new JLabel("Contrase\u00F1a:");
			lblContrasena_admin.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/marca.png")));
			lblContrasena_admin.setForeground(new Color(250, 250, 210));
			lblContrasena_admin.setBackground(UIManager.getColor("Button.focus"));
			lblContrasena_admin.setBounds(10, 70, 119, 14);
			lblContrasena_admin.setVisible(false);
			panel_Administrativo.add(lblContrasena_admin);
			
			txtUsuario_admin = new JTextField();
			txtUsuario_admin.setForeground(new Color(250, 250, 210));
			txtUsuario_admin.setBackground(UIManager.getColor("Button.focus"));
			txtUsuario_admin.setBounds(139, 27, 141, 20);
			txtUsuario_admin.setVisible(false);
			panel_Administrativo.add(txtUsuario_admin);
			txtUsuario_admin.setColumns(10);
			
			txtContrasenna_admin = new JTextField();
			txtContrasenna_admin.setForeground(new Color(250, 250, 210));
			txtContrasenna_admin.setBackground(UIManager.getColor("Button.focus"));
			txtContrasenna_admin.setColumns(10);
			txtContrasenna_admin.setBounds(139, 67, 141, 20);
			txtContrasenna_admin.setVisible(false);
			panel_Administrativo.add(txtContrasenna_admin);
			
			lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/bille.png")));
			lblSueldo.setForeground(new Color(250, 250, 210));
			lblSueldo.setBackground(UIManager.getColor("Button.focus"));
			lblSueldo.setBounds(361, 30, 85, 14);
			lblSueldo.setVisible(false);
			panel_Administrativo.add(lblSueldo);
			
			spnSueldo_admin = new JSpinner();
			spnSueldo_admin.setForeground(new Color(250, 250, 210));
			spnSueldo_admin.setBackground(UIManager.getColor("Button.focus"));
			spnSueldo_admin.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnSueldo_admin.setBounds(440, 27, 99, 20);
			spnSueldo_admin.setVisible(false);
			panel_Administrativo.add(spnSueldo_admin);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/registrer.png")));
				okButton.setForeground(new Color(0, 255, 0));
				okButton.setBackground(UIManager.getColor("Button.focus"));
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
							aux = new Vendedor(nombre, cedula, telefono, direccion, 0, comision, Float.parseFloat(spnSueldo_vendedor.getValue().toString()), txtUsuario_vendedor.getText(), txtContrasenna_Vendedor.getText());
							Prodacom.getInstance().insertarPersona(aux);
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
				cancelButton.setIcon(new ImageIcon(RegTrabajadores.class.getResource("/iconos/cancel.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
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
		spnSueldo_admin.setValue(new Integer(1));
		
		spnComision_vendedor.setValue(new Integer(1));
		spnSueldo_vendedor.setValue(new Integer(1));
		txtContrasenna_Vendedor.setText("");
		txtUsuario_vendedor.setText("");
		
	}
}
