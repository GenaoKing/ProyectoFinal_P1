package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.text.Font;
import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Prodacom;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnCredito;
	private JButton btnListarComponentes;
	private Dimension din;
	private static JButton btnSeleccionarCliente;
	private static JLabel lblNombre;
	private static JLabel lblCedula;
	private static JLabel lblTelefono;
	private static JLabel lblDireccion;
	private static JLabel lblLimiteCredito;
	private static JLabel lblCreditoDisponible;
	private JLabel lblCodigo;
	private JLabel lblFecha;
	private JComboBox cbxVendedores;
	private JLabel lblVendedor;
	private static Combo combo = null;
	private static Componente componente = null;
	private ArrayList<Combo>combos = new ArrayList<Combo>(); 
	private ArrayList<Componente>componentes = new ArrayList<Componente>(); 
	private static int cantidad = 0;
	private JLabel lblTotal;
	private JLabel lblImpuestos;
	private JLabel lblSubTotal;
	public static DefaultTableModel modelo;
	public static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion() {
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1057, 716);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setForeground(new Color(184, 134, 11));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		din = getToolkit().getScreenSize();  
		//super.setSize(1054,din.height-45);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(184, 134, 11));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.RED);
			panel_2.setBackground(UIManager.getColor("Button.focus"));
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Informacion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_2.setBounds(12, 6, 1002, 239);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			lblNombre = new JLabel("");
			lblNombre.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblNombre.setBounds(12, 23, 345, 31);
			panel_2.add(lblNombre);
			
			lblCedula = new JLabel("");
			lblCedula.setBackground(UIManager.getColor("Button.focus"));
			lblCedula.setForeground(new Color(0, 0, 128));
			lblCedula.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblCedula.setBounds(12, 77, 345, 31);
			panel_2.add(lblCedula);
			
			lblTelefono = new JLabel("");
			lblTelefono.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblTelefono.setBounds(12, 131, 345, 31);
			panel_2.add(lblTelefono);
			
			lblDireccion = new JLabel("");
			lblDireccion.setForeground(UIManager.getColor("Button.focus"));
			lblDireccion.setBackground(Color.BLACK);
			lblDireccion.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblDireccion.setBounds(12, 185, 501, 31);
			panel_2.add(lblDireccion);
			
			lblLimiteCredito = new JLabel("");
			lblLimiteCredito.setBackground(UIManager.getColor("Button.focus"));
			lblLimiteCredito.setForeground(SystemColor.textHighlight);
			lblLimiteCredito.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblLimiteCredito.setBounds(422, 23, 285, 31);
			panel_2.add(lblLimiteCredito);
			
			lblCreditoDisponible = new JLabel("");
			lblCreditoDisponible.setBackground(UIManager.getColor("Button.focus"));
			lblCreditoDisponible.setForeground(SystemColor.textHighlight);
			lblCreditoDisponible.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblCreditoDisponible.setBounds(423, 115, 272, 31);
			panel_2.add(lblCreditoDisponible);
			
			lblCodigo = new JLabel("Factura #");
			lblCodigo.setBackground(UIManager.getColor("Button.focus"));
			lblCodigo.setForeground(SystemColor.textHighlight);
			lblCodigo.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblCodigo.setBounds(758, 23, 228, 31);
			panel_2.add(lblCodigo);
			
			lblFecha = new JLabel("");
			lblFecha.setBounds(758, 115, 228, 31);
			panel_2.add(lblFecha);
			
			cbxVendedores = new JComboBox();
			cbxVendedores.setBackground(UIManager.getColor("Button.focus"));
			cbxVendedores.setForeground(SystemColor.textHighlight);
			cbxVendedores.setBounds(674, 185, 312, 31);
			panel_2.add(cbxVendedores);
			
			btnSeleccionarCliente = new JButton("Seleccionar Cliente");
			btnSeleccionarCliente.setBackground(UIManager.getColor("Button.focus"));
			btnSeleccionarCliente.setForeground(new Color(184, 134, 11));
			btnSeleccionarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegCliente a = new RegCliente();
					a.setVisible(true);
				}
			});
			btnSeleccionarCliente.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			btnSeleccionarCliente.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnAgregarClienteIcono.png")));
			btnSeleccionarCliente.setBounds(22, 23, 446, 180);
			panel_2.add(btnSeleccionarCliente);
			
			lblVendedor = new JLabel("Vendedor:");
			lblVendedor.setForeground(SystemColor.textHighlight);
			lblVendedor.setBackground(UIManager.getColor("Button.focus"));
			lblVendedor.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblVendedor.setBounds(523, 185, 139, 31);
			panel_2.add(lblVendedor);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.RED);
			panel_1.setBackground(UIManager.getColor("Button.focus"));
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Carrito", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(12, 244, 1002, 211);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String[] columns = {"Codigo","Articulo","Cantidad","Precio","Importe"}; 
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						if('C'==(char)modelo.getValueAt(modelrow, 0)) {
							btnListarComponentes.setEnabled(true);
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(false);
							componente = null;
							//combo = Prodacom.getInstance().buscarCombos((String)modelo.getValueAt(modelrow, 0));
						}else {
							btnListarComponentes.setEnabled(false);
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);
							componente = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));;
							combo = null;
						}
						
					}else{	
						btnListarComponentes.setEnabled(false);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.RED);
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			panel_3.setBackground(UIManager.getColor("Button.focus"));
			panel_3.setBounds(12, 459, 1002, 157);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			btnAgregar = new JButton("Agregar Articulo");
			btnAgregar.setForeground(new Color(184, 134, 11));
			btnAgregar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnAgregarIcono.png")));
			btnAgregar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 22));
			btnAgregar.setBackground(new Color(50, 205, 50));
			btnAgregar.setBounds(385, 13, 271, 124);
			panel_3.add(btnAgregar);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			btnModificar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnModificar.setBackground(new Color(184, 134, 11));
			btnModificar.setForeground(Color.BLACK);
			btnModificar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnModificarIcono.png")));
			btnModificar.setBounds(12, 14, 158, 52);
			panel_3.add(btnModificar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(combo!=null) {
						combos.remove(combo);
						Prodacom.getInstance().insertarCombo(combo);
					}else {
						componentes.remove(componente);
						//Prodacom.getInstance().SumarComponente(componente,cantidad);
					}
					CargarTabla();
				}

			});
			btnEliminar.setEnabled(false);
			btnEliminar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnEliminarIcono.png")));
			btnEliminar.setForeground(Color.BLACK);
			btnEliminar.setBackground(new Color(128, 0, 0));
			btnEliminar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnEliminar.setBounds(198, 15, 158, 52);
			panel_3.add(btnEliminar);
			
			btnListarComponentes = new JButton("Listar Componentes Combo");
			btnListarComponentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
				}
			});
			btnListarComponentes.setEnabled(false);
			btnListarComponentes.setBackground(new Color(0, 128, 128));
			btnListarComponentes.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnListarComponentes.png")));
			btnListarComponentes.setForeground(new Color(0, 128, 0));
			btnListarComponentes.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnListarComponentes.setBounds(12, 85, 344, 52);
			panel_3.add(btnListarComponentes);
			

			JLabel lblSubTotal = new JLabel("Sub-Total:");
			lblSubTotal.setForeground(SystemColor.textHighlight);
			lblSubTotal.setBackground(UIManager.getColor("Button.focus"));

			

			JLabel lblImpuestos = new JLabel("ITBIS (18%):");
			lblImpuestos.setBackground(UIManager.getColor("Button.focus"));
			lblImpuestos.setForeground(SystemColor.textHighlight);

			

			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setBackground(UIManager.getColor("Button.focus"));
			lblTotal.setForeground(SystemColor.textHighlight);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(new Color(184, 134, 11));
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnCredito = new JButton("Pagar A Credito");
			btnCredito.setBackground(UIManager.getColor("Button.focus"));
			btnCredito.setForeground(SystemColor.textHighlight);
			buttonPane.add(btnCredito);
			{
				JButton btnPagar = new JButton("Pagar Ahora");
				btnPagar.setBackground(UIManager.getColor("Button.focus"));
				btnPagar.setForeground(SystemColor.textHighlight);
				btnPagar.setActionCommand("OK");
				buttonPane.add(btnPagar);
				getRootPane().setDefaultButton(btnPagar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(SystemColor.textHighlight);
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
	}

	public static void CargarCliente(Cliente c) {
		lblNombre.setText(c.getNombre());
		lblCedula.setText(c.getCedula());
		lblDireccion.setText(c.getDireccion());
		lblTelefono.setText(c.getTelefono());
		lblCreditoDisponible.setText("Credito Disponible: "+Prodacom.getInstance().CreditCliente(c));
		lblLimiteCredito.setText("Limite de Credito: "+c.getCredito());
		btnSeleccionarCliente.setVisible(false);
		
	}
	
	private void CargarTabla() {
		
		
		CargarTotal();
	}

	private void CargarTotal() {
		float subtotal = 0;
		for(int i = 0;i<table.getRowCount();i++) {
			subtotal+=(float)modelo.getValueAt(i, 4);
		}
		lblSubTotal.setText("Sub-Total: "+subtotal);
		lblImpuestos.setText("ITBIS (18%): "+(subtotal*0.18));
		lblTotal.setText("Total: "+(subtotal+(subtotal*0.18)));
	}
}
