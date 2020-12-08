package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Persona;
import logico.Prodacom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblCredito;
	private JTextField txtCredito;
	private JLabel lblDias;
	private JSpinner spnDias;
	private JButton btnSeleccionar;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegCliente.class.getResource("/iconos/user.png")));
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setTitle("Registrar Cliente");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 476, 491);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setForeground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setForeground(Color.DARK_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/nombre.png")));
				lblNombre.setBackground(UIManager.getColor("Button.focus"));
				lblNombre.setForeground(new Color(250, 250, 210));
				lblNombre.setBounds(12, 36, 89, 32);
				panel.add(lblNombre);
			}
			
			txtNombre = new JTextField();
			txtNombre.setForeground(new Color(0, 0, 255));
			txtNombre.setBackground(UIManager.getColor("Button.focus"));
			txtNombre.setBounds(111, 41, 333, 27);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/cedu.png")));
			lblCedula.setBackground(UIManager.getColor("Button.focus"));
			lblCedula.setForeground(new Color(250, 250, 210));
			lblCedula.setBounds(12, 104, 89, 32);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='-') && (carac!='\b'))) {
						e.consume();
					}
				}
			});
			txtCedula.setForeground(new Color(0, 0, 255));
			txtCedula.setBackground(UIManager.getColor("Button.focus"));
			txtCedula.setColumns(10);
			txtCedula.setBounds(111, 107, 333, 27);
			panel.add(txtCedula);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBackground(UIManager.getColor("Button.focus"));
			lblTelefono.setForeground(new Color(250, 250, 210));
			lblTelefono.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/tel.png")));
			lblTelefono.setBounds(12, 172, 89, 32);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='(') && (carac!='\b') && (carac!=')') && (carac!='-') && (carac!='+'))) {
						e.consume();
					}
				}
			});
			txtTelefono.setForeground(new Color(0, 0, 255));
			txtTelefono.setBackground(UIManager.getColor("Button.focus"));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(111, 177, 333, 27);
			panel.add(txtTelefono);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBackground(UIManager.getColor("Button.focus"));
			lblDireccion.setForeground(new Color(250, 250, 210));
			lblDireccion.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/dire.png")));
			lblDireccion.setBounds(12, 240, 89, 32);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBackground(UIManager.getColor("Button.focus"));
			txtDireccion.setForeground(new Color(0, 0, 255));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(111, 245, 333, 27);
			panel.add(txtDireccion);
			
			spnDias = new JSpinner();
			spnDias.setForeground(new Color(0, 0, 255));
			spnDias.setBackground(UIManager.getColor("Button.focus"));
			spnDias.setModel(new SpinnerNumberModel(1, 1, 120, 1));
			spnDias.setBounds(363, 354, 68, 27);
			panel.add(spnDias);
			
			lblDias = new JLabel("Dias Para Pagar:");
			lblDias.setBackground(UIManager.getColor("Button.focus"));
			lblDias.setForeground(new Color(250, 250, 210));
			lblDias.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/cale.png")));
			lblDias.setBounds(229, 357, 124, 16);
			panel.add(lblDias);
			
			lblCredito = new JLabel("Credito:");
			lblCredito.setBackground(UIManager.getColor("Button.focus"));
			lblCredito.setForeground(new Color(250, 250, 210));
			lblCredito.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/money.png")));
			lblCredito.setBounds(12, 357, 89, 16);
			panel.add(lblCredito);
			
			txtCredito = new JTextField();
			txtCredito.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='.') && (carac!='\b'))) {
						e.consume();
					}
				}
			});
			txtCredito.setBackground(UIManager.getColor("Button.focus"));
			txtCredito.setForeground(new Color(0, 0, 255));
			txtCredito.setBounds(110, 351, 109, 27);
			panel.add(txtCredito);
			txtCredito.setColumns(10);
			
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						rdbtnNo.setSelected(false);
						lblCredito.setVisible(true);
						txtCredito.setVisible(true);
						spnDias.setVisible(true);
						lblDias.setVisible(true);
					
				}
			});
			rdbtnSi.setSelected(true);
			rdbtnSi.setBounds(304, 296, 56, 25);
			panel.add(rdbtnSi);
			
			JLabel lblNewLabel = new JLabel("Seleccione Si Desea Abrir Linea De Credito:");
			lblNewLabel.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/select.png")));
			lblNewLabel.setForeground(new Color(250, 250, 210));
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setBounds(12, 300, 272, 16);
			panel.add(lblNewLabel);
			
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSi.setSelected(false);
					lblCredito.setVisible(false);
					txtCredito.setVisible(false);
					spnDias.setVisible(false);
					lblDias.setVisible(false);
					
				}
			});
			rdbtnNo.setBounds(366, 296, 68, 25);
			panel.add(rdbtnNo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnSeleccionar = new JButton("Seleccionar De Clientes Guardados");
			btnSeleccionar.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/clien.png")));
			btnSeleccionar.setForeground(new Color(0, 255, 0));
			btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoClientes a = new ListadoClientes(0);
					dispose();
					a.setVisible(true);
					
				}
			});
			buttonPane.add(btnSeleccionar);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.setForeground(new Color(0, 255, 0));
				okButton.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/registrer.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona c = null;
						if(rdbtnSi.isSelected()) {
							c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText()
									, txtDireccion.getText(), Float.parseFloat(txtCredito.getText())
									, Integer.parseInt(spnDias.getValue().toString()));
						}else {
							c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText()
									, txtDireccion.getText(), 0.0f
									, 0);
							
						}
						Prodacom.getInstance().insertarPersona(c);
						Facturacion.CargarCliente((Cliente)c);
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el cliente");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setIcon(new ImageIcon(RegCliente.class.getResource("/iconos/cancel.png")));
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
