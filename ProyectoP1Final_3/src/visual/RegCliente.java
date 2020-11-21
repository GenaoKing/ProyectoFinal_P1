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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Registrar Cliente");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 476, 491);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(12, 36, 68, 32);
				panel.add(lblNombre);
			}
			
			txtNombre = new JTextField();
			txtNombre.setBounds(92, 41, 352, 27);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(12, 104, 68, 32);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(92, 109, 352, 27);
			panel.add(txtCedula);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(12, 172, 68, 32);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(92, 177, 352, 27);
			panel.add(txtTelefono);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(12, 240, 68, 32);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(92, 245, 352, 27);
			panel.add(txtDireccion);
			
			spnDias = new JSpinner();
			spnDias.setModel(new SpinnerNumberModel(1, 1, 120, 1));
			spnDias.setBounds(363, 354, 68, 27);
			panel.add(spnDias);
			
			lblDias = new JLabel("Dias Para Pagar:");
			lblDias.setBounds(229, 357, 109, 16);
			panel.add(lblDias);
			
			lblCredito = new JLabel("Credito:");
			lblCredito.setBounds(12, 357, 56, 16);
			panel.add(lblCredito);
			
			txtCredito = new JTextField();
			txtCredito.setBounds(92, 351, 116, 27);
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
			lblNewLabel.setBounds(12, 300, 261, 16);
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnSeleccionar = new JButton("Seleccionar De Clientes Guardados");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoClientes a = new ListadoClientes();
					dispose();
					a.setVisible(true);
					
				}
			});
			buttonPane.add(btnSeleccionar);
			{
				JButton okButton = new JButton("Registrar");
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
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
