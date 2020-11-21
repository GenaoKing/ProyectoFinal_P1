package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import javafx.scene.text.Font;

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

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnCredito;
	private JButton btnListarComponentes;
	private Dimension din;

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
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1054, 1027);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		din = getToolkit().getScreenSize();  
		super.setSize(1054,din.height-45);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Informacion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));
			panel_2.setBounds(12, 13, 1002, 239);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNombre = new JLabel("");
			lblNombre.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblNombre.setBounds(12, 23, 345, 31);
			panel_2.add(lblNombre);
			
			JLabel lblCedula = new JLabel("");
			lblCedula.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblCedula.setBounds(12, 77, 345, 31);
			panel_2.add(lblCedula);
			
			JLabel lblTelefono = new JLabel("");
			lblTelefono.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblTelefono.setBounds(12, 131, 345, 31);
			panel_2.add(lblTelefono);
			
			JLabel lblDireccion = new JLabel("");
			lblDireccion.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblDireccion.setBounds(12, 185, 501, 31);
			panel_2.add(lblDireccion);
			
			JLabel lblLimiteCredito = new JLabel("");
			lblLimiteCredito.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblLimiteCredito.setBounds(422, 23, 285, 31);
			panel_2.add(lblLimiteCredito);
			
			JLabel lblCreditoDisponible = new JLabel("");
			lblCreditoDisponible.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblCreditoDisponible.setBounds(423, 115, 272, 31);
			panel_2.add(lblCreditoDisponible);
			
			JLabel lblCodigo = new JLabel("Factura #");
			lblCodigo.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblCodigo.setBounds(758, 23, 228, 31);
			panel_2.add(lblCodigo);
			
			JLabel lblFecha = new JLabel("");
			lblFecha.setBounds(758, 115, 228, 31);
			panel_2.add(lblFecha);
			
			JComboBox cbxVendedores = new JComboBox();
			cbxVendedores.setBounds(601, 185, 385, 31);
			panel_2.add(cbxVendedores);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Carrito", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(13, 256, 1001, 465);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setBounds(16, 723, 998, 182);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			btnAgregar = new JButton("Agregar Articulo");
			btnAgregar.setForeground(new Color(255, 255, 255));
			btnAgregar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnAgregarIcono.png")));
			btnAgregar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 22));
			btnAgregar.setBackground(new Color(50, 205, 50));
			btnAgregar.setBounds(385, 13, 271, 124);
			panel_3.add(btnAgregar);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnModificar.setBackground(new Color(30, 144, 255));
			btnModificar.setForeground(new Color(255, 255, 255));
			btnModificar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnModificarIcono.png")));
			btnModificar.setBounds(12, 14, 158, 52);
			panel_3.add(btnModificar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnEliminarIcono.png")));
			btnEliminar.setForeground(new Color(255, 255, 255));
			btnEliminar.setBackground(new Color(255, 0, 0));
			btnEliminar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnEliminar.setBounds(198, 15, 158, 52);
			panel_3.add(btnEliminar);
			
			btnListarComponentes = new JButton("Listar Componentes Combo");
			btnListarComponentes.setBackground(new Color(30, 144, 255));
			btnListarComponentes.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnListarComponentes.png")));
			btnListarComponentes.setForeground(new Color(255, 255, 255));
			btnListarComponentes.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnListarComponentes.setBounds(12, 85, 344, 52);
			panel_3.add(btnListarComponentes);
			
			JLabel lblSubTotal = new JLabel("Sub-Total:");
			lblSubTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 20));
			lblSubTotal.setBounds(704, 13, 282, 39);
			panel_3.add(lblSubTotal);
			
			JLabel lblImpuestos = new JLabel("ITBIS (18%):");
			lblImpuestos.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 20));
			lblImpuestos.setBounds(704, 70, 282, 39);
			panel_3.add(lblImpuestos);
			
			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 20));
			lblTotal.setBounds(704, 122, 282, 39);
			panel_3.add(lblTotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnCredito = new JButton("Pagar A Credito");
			buttonPane.add(btnCredito);
			{
				JButton btnPagar = new JButton("Pagar Ahora");
				btnPagar.setActionCommand("OK");
				buttonPane.add(btnPagar);
				getRootPane().setDefaultButton(btnPagar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
