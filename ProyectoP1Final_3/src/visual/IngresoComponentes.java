package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Disco;
import logico.MemoriaRam;
import logico.Microprocesadores;
import logico.MotherBoard;
import logico.Prodacom;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class IngresoComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerie;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtConexion_MotherBoard;
	private JTextField txtTipoRam_MotherBoard;
	private JSpinner spnCantMaxima;
	private JSpinner spnCantReal;
	private JSpinner spnCantMinima;
	private JSpinner spnCompra;
	private JLabel lblPrecioVenta;
	private JLabel lblConector_MotherBoard;
	private JTable table;
	private JTable table_1;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JLabel lblTipoRam_MotherBoard;
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	private ArrayList<String> conexiones;
	public String q=null;
	private ArrayList<String>agregados = new ArrayList<String>();
	private int cont = 0;
	private JButton okButton;
	private JPanel panel_Disponibles;
	private JPanel panel_Agregados;
	private JPanel panel_MotherBoard;
	private JLabel lblCantidadDeMemoria_MemoriaRam;
	private JLabel lblTipoDeMemoria_MemoriaRam;
	private JLabel lblMemoria_MemoriaRam;
	private JSpinner spnCantidadDeMemoria_MemoriaRam;
	private JComboBox cbxTipoDeMemoria_MemoriaRam;
	private JComboBox cbxMemoria_MemoriaRam;
	private JPanel panel_Microprocesadores;
	private JLabel lblTipoDeconexion_Microprocesadores;
	private JLabel lblVelocidad_Microprocesadores;
	private JLabel lblTipo_Microprocesadores;
	private JTextField txtTipoDeConexion_Microprocesadores;
	private JPanel panel_DiscoDuro;
	private JLabel lblCantAlmacenamiento_DiscoDuro;
	private JLabel lblUnidadDeAlmacenamiento_DiscoDuro;
	private JLabel lblTipoDeConexion_DiscoDuro;
	private JSpinner spnCantAlmacenamiento_DiscoDuro;
	private JComboBox cbxUnidadDeAlmacenamiento_DiscoDuro;
	private JComboBox cbxTipoDeConexion_DiscoDuro;
	private JSpinner spnVelocidad_Microprocesadores;
	private JComboBox cbxTipo_Microprocesadores;
	private JPanel panel_MemoriaRam;
	private JRadioButton rdbtnMotherboard;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbtnMicroprocesadores;
	private JRadioButton rdbtnDisco;
	private JSpinner spnVenta;

	/**
	 * Launch the application.
	 */
	



	/**
	 * Create the dialog.
	 */
	public IngresoComponentes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IngresoComponentes.class.getResource("/iconos/ingreso.png")));
		setTitle("Ingreso de componentes");
		setModal(true);
		setResizable(false);
		setForeground(new Color(0, 128, 128));
		setBackground(UIManager.getColor("Button.focus"));
		setBounds(100, 100, 789, 563);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(new Color(0, 139, 139));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(139, 0, 0)));
		panel.setBounds(10, 11, 753, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serie:");
		lblNewLabel.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/se.png")));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setBounds(10, 25, 61, 14);
		panel.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/model.png")));
		lblModelo.setBackground(UIManager.getColor("Button.focus"));
		lblModelo.setForeground(new Color(250, 250, 210));
		lblModelo.setBounds(146, 25, 74, 14);
		panel.add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/marca.png")));
		lblMarca.setBackground(UIManager.getColor("Button.focus"));
		lblMarca.setForeground(new Color(250, 250, 210));
		lblMarca.setBounds(306, 25, 66, 14);
		panel.add(lblMarca);
		
		txtSerie = new JTextField();
		txtSerie.setEnabled(false);
		txtSerie.setBounds(81, 22, 58, 20);
		txtSerie.setText("S-"+Prodacom.getInstance().getCod_componente());
		panel.add(txtSerie);
		txtSerie.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBackground(UIManager.getColor("Button.focus"));
		txtModelo.setForeground(new Color(102, 0, 0));
		txtModelo.setColumns(10);
		txtModelo.setBounds(230, 22, 66, 20);
		panel.add(txtModelo);
		
		txtMarca = new JTextField();
		txtMarca.setForeground(new Color(102, 0, 0));
		txtMarca.setBackground(UIManager.getColor("Button.focus"));
		txtMarca.setColumns(10);
		txtMarca.setBounds(366, 22, 74, 20);
		panel.add(txtMarca);
		
		JLabel lblPrecio = new JLabel("Compra:");
		lblPrecio.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/compras.png")));
		lblPrecio.setBackground(UIManager.getColor("Button.focus"));
		lblPrecio.setForeground(new Color(250, 250, 210));
		lblPrecio.setBounds(450, 25, 82, 14);
		panel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad M\u00EDnima:");
		lblCantidad.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/dollar.png")));
		lblCantidad.setBackground(UIManager.getColor("Button.focus"));
		lblCantidad.setForeground(new Color(250, 250, 210));
		lblCantidad.setBounds(7, 75, 132, 14);
		panel.add(lblCantidad);
		
		spnCompra = new JSpinner();
		spnCompra.setBackground(UIManager.getColor("Button.focus"));
		spnCompra.setForeground(new Color(102, 0, 0));
		spnCompra.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnCompra.setBounds(523, 22, 66, 20);
		panel.add(spnCompra);
		
		spnCantMinima = new JSpinner();
		spnCantMinima.setForeground(new Color(102, 0, 0));
		spnCantMinima.setBackground(UIManager.getColor("Button.focus"));
		spnCantMinima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantMinima.setBounds(157, 72, 86, 20);
		panel.add(spnCantMinima);
		
		lblPrecioVenta = new JLabel("Venta:");
		lblPrecioVenta.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/ventas.png")));
		lblPrecioVenta.setForeground(new Color(250, 250, 210));
		lblPrecioVenta.setBackground(UIManager.getColor("Button.focus"));
		lblPrecioVenta.setBounds(599, 25, 66, 14);
		panel.add(lblPrecioVenta);
		
		spnVenta = new JSpinner();
		spnVenta.setForeground(new Color(102, 0, 0));
		spnVenta.setBackground(UIManager.getColor("Button.focus"));
		spnVenta.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnVenta.setBounds(670, 22, 61, 20);
		panel.add(spnVenta);
		
		JLabel lblCantidadReal = new JLabel("Cantidad Real:");
		lblCantidadReal.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/dinero.png")));
		lblCantidadReal.setForeground(new Color(250, 250, 210));
		lblCantidadReal.setBackground(UIManager.getColor("Button.focus"));
		lblCantidadReal.setBounds(253, 75, 130, 14);
		panel.add(lblCantidadReal);
		
		spnCantReal = new JSpinner();
		spnCantReal.setBackground(UIManager.getColor("Button.focus"));
		spnCantReal.setForeground(new Color(102, 0, 0));
		spnCantReal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantReal.setBounds(366, 72, 86, 20);
		panel.add(spnCantReal);
		
		JLabel lblCantidadMxima = new JLabel("Cantidad M\u00E1xima:");
		lblCantidadMxima.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/money.png")));
		lblCantidadMxima.setBackground(UIManager.getColor("Button.focus"));
		lblCantidadMxima.setForeground(new Color(250, 250, 210));
		lblCantidadMxima.setBounds(489, 75, 146, 14);
		panel.add(lblCantidadMxima);
		
		spnCantMaxima = new JSpinner();
		spnCantMaxima.setForeground(new Color(102, 0, 0));
		spnCantMaxima.setBackground(UIManager.getColor("Button.focus"));
		spnCantMaxima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantMaxima.setBounds(616, 72, 86, 20);
		panel.add(spnCantMaxima);
		
		panel_DiscoDuro = new JPanel();
		panel_DiscoDuro.setForeground(Color.DARK_GRAY);
		panel_DiscoDuro.setBackground(Color.BLACK);
		panel_DiscoDuro.setBorder(new LineBorder(new Color(128, 0, 0)));
		panel_DiscoDuro.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_DiscoDuro);
		panel_DiscoDuro.setLayout(null);
		
		lblCantAlmacenamiento_DiscoDuro = new JLabel("Cantidad de almacenamiento:");
		lblCantAlmacenamiento_DiscoDuro.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/alma.png")));
		lblCantAlmacenamiento_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		lblCantAlmacenamiento_DiscoDuro.setForeground(new Color(250, 250, 210));
		lblCantAlmacenamiento_DiscoDuro.setBounds(10, 54, 202, 14);
		//lblCantAlmacenamiento_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(lblCantAlmacenamiento_DiscoDuro);
		
		lblUnidadDeAlmacenamiento_DiscoDuro = new JLabel("Unidad de almacenamiento:");
		lblUnidadDeAlmacenamiento_DiscoDuro.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/disco.png")));
		lblUnidadDeAlmacenamiento_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		lblUnidadDeAlmacenamiento_DiscoDuro.setForeground(new Color(250, 250, 210));
		lblUnidadDeAlmacenamiento_DiscoDuro.setBounds(10, 122, 202, 14);
		//lblUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(lblUnidadDeAlmacenamiento_DiscoDuro);
		
		lblTipoDeConexion_DiscoDuro = new JLabel("Tipo de conexion:");
		lblTipoDeConexion_DiscoDuro.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/compo.png")));
		lblTipoDeConexion_DiscoDuro.setForeground(new Color(250, 250, 210));
		lblTipoDeConexion_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		lblTipoDeConexion_DiscoDuro.setBounds(10, 190, 202, 14);
		//lblTipoDeConexion_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(lblTipoDeConexion_DiscoDuro);
		
		spnCantAlmacenamiento_DiscoDuro = new JSpinner();
		spnCantAlmacenamiento_DiscoDuro.setForeground(SystemColor.textHighlight);
		spnCantAlmacenamiento_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		spnCantAlmacenamiento_DiscoDuro.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantAlmacenamiento_DiscoDuro.setBounds(222, 51, 131, 20);
		//spnCantAlmacenamiento_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(spnCantAlmacenamiento_DiscoDuro);
		
		cbxUnidadDeAlmacenamiento_DiscoDuro = new JComboBox();
		cbxUnidadDeAlmacenamiento_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		cbxUnidadDeAlmacenamiento_DiscoDuro.setForeground(SystemColor.textHighlight);
		cbxUnidadDeAlmacenamiento_DiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"Gb", "Tb"}));
		cbxUnidadDeAlmacenamiento_DiscoDuro.setBounds(222, 119, 131, 20);
		//cbxUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(cbxUnidadDeAlmacenamiento_DiscoDuro);
		
		cbxTipoDeConexion_DiscoDuro = new JComboBox();
		cbxTipoDeConexion_DiscoDuro.setForeground(SystemColor.textHighlight);
		cbxTipoDeConexion_DiscoDuro.setBackground(UIManager.getColor("Button.focus"));
		cbxTipoDeConexion_DiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"IDE", "SATA ", "SATA-2 ", "SATA-3"}));
		cbxTipoDeConexion_DiscoDuro.setBounds(222, 187, 131, 20);
		//cbxTipoDeConexion_DiscoDuro.setVisible(false);
		panel_DiscoDuro.add(cbxTipoDeConexion_DiscoDuro);
		
		panel_Microprocesadores = new JPanel();
		panel_Microprocesadores.setBackground(Color.BLACK);
		panel_Microprocesadores.setForeground(Color.DARK_GRAY);
		panel_Microprocesadores.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
		panel_Microprocesadores.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_Microprocesadores);
		panel_Microprocesadores.setLayout(null);
		
		lblTipoDeconexion_Microprocesadores = new JLabel("Tipo de conexion o socket:");
		lblTipoDeconexion_Microprocesadores.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/compo.png")));
		lblTipoDeconexion_Microprocesadores.setForeground(new Color(250, 250, 210));
		lblTipoDeconexion_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		lblTipoDeconexion_Microprocesadores.setBounds(10, 58, 207, 14);
		lblTipoDeconexion_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(lblTipoDeconexion_Microprocesadores);
		
		lblVelocidad_Microprocesadores = new JLabel("Velocidad:");
		lblVelocidad_Microprocesadores.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/disco.png")));
		lblVelocidad_Microprocesadores.setForeground(new Color(250, 250, 210));
		lblVelocidad_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		lblVelocidad_Microprocesadores.setBounds(10, 135, 207, 14);
		lblVelocidad_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(lblVelocidad_Microprocesadores);
		
		lblTipo_Microprocesadores = new JLabel("Tipo de procesamiento:");
		lblTipo_Microprocesadores.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/ll.png")));
		lblTipo_Microprocesadores.setForeground(new Color(250, 250, 210));
		lblTipo_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		lblTipo_Microprocesadores.setBounds(10, 201, 207, 14);
		lblTipo_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(lblTipo_Microprocesadores);
		
		txtTipoDeConexion_Microprocesadores = new JTextField();
		txtTipoDeConexion_Microprocesadores.setForeground(SystemColor.textHighlight);
		txtTipoDeConexion_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		txtTipoDeConexion_Microprocesadores.setBounds(191, 55, 199, 20);
		txtTipoDeConexion_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(txtTipoDeConexion_Microprocesadores);
		txtTipoDeConexion_Microprocesadores.setColumns(10);
		
		spnVelocidad_Microprocesadores = new JSpinner();
		spnVelocidad_Microprocesadores.setForeground(SystemColor.textHighlight);
		spnVelocidad_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		spnVelocidad_Microprocesadores.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVelocidad_Microprocesadores.setBounds(191, 132, 199, 20);
		spnVelocidad_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(spnVelocidad_Microprocesadores);
		
		cbxTipo_Microprocesadores = new JComboBox();
		cbxTipo_Microprocesadores.setBackground(UIManager.getColor("Button.focus"));
		cbxTipo_Microprocesadores.setForeground(new Color(250, 250, 210));
		cbxTipo_Microprocesadores.setModel(new DefaultComboBoxModel(new String[] {"MHz", "GHz"}));
		cbxTipo_Microprocesadores.setBounds(191, 198, 199, 20);
		cbxTipo_Microprocesadores.setVisible(false);
		panel_Microprocesadores.add(cbxTipo_Microprocesadores);
		
		panel_MotherBoard = new JPanel();
		panel_MotherBoard.setForeground(Color.DARK_GRAY);
		panel_MotherBoard.setBackground(Color.BLACK);
		panel_MotherBoard.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
		panel_MotherBoard.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_MotherBoard);
		panel_MotherBoard.setLayout(null);
		
		lblConector_MotherBoard = new JLabel("Conexion:");
		lblConector_MotherBoard.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/se.png")));
		lblConector_MotherBoard.setForeground(new Color(250, 250, 210));
		lblConector_MotherBoard.setBackground(UIManager.getColor("Button.focus"));
		lblConector_MotherBoard.setBounds(10, 49, 113, 14);
		lblConector_MotherBoard.setVisible(true);
		panel_MotherBoard.add(lblConector_MotherBoard);
		
		lblTipoRam_MotherBoard = new JLabel("TipoRam:");
		lblTipoRam_MotherBoard.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/model.png")));
		lblTipoRam_MotherBoard.setForeground(new Color(250, 250, 210));
		lblTipoRam_MotherBoard.setBackground(UIManager.getColor("Button.focus"));
		lblTipoRam_MotherBoard.setBounds(10, 112, 113, 14);
		panel_MotherBoard.add(lblTipoRam_MotherBoard);
		
		txtConexion_MotherBoard = new JTextField();
		txtConexion_MotherBoard.setBackground(UIManager.getColor("Button.focus"));
		txtConexion_MotherBoard.setForeground(SystemColor.textHighlight);
		txtConexion_MotherBoard.setBounds(87, 46, 125, 20);
		txtConexion_MotherBoard.setVisible(false);
		panel_MotherBoard.add(txtConexion_MotherBoard);
		txtConexion_MotherBoard.setColumns(10);
		
		txtTipoRam_MotherBoard = new JTextField();
		txtTipoRam_MotherBoard.setForeground(SystemColor.textHighlight);
		txtTipoRam_MotherBoard.setBackground(UIManager.getColor("Button.focus"));
		txtTipoRam_MotherBoard.setColumns(10);
		txtTipoRam_MotherBoard.setBounds(87, 109, 125, 20);
		txtTipoRam_MotherBoard.setVisible(false);
		panel_MotherBoard.add(txtTipoRam_MotherBoard);
		
		btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/derecha.png")));
		btnAgregar.setSelectedIcon(null);
		btnAgregar.setBackground(UIManager.getColor("Button.focus"));
		btnAgregar.setForeground(UIManager.getColor("Button.focus"));
		btnAgregar.setEnabled(false);
		btnAgregar.setVisible(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont++;
				conexiones.remove(q);
				agregados.add(q);
				CargarTabla();
				CargarTablaAgregados();
				btnAgregar.setEnabled(false);
				if(cont>0) {
					okButton.setEnabled(true);
				}else {
					okButton.setEnabled(false);
				}
				
			}
		});
		btnAgregar.setBounds(445, 66, 80, 25);
		panel_MotherBoard.add(btnAgregar);
		
		btnQuitar = new JButton("");
		btnQuitar.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/izquierda.png")));
		btnQuitar.setForeground(UIManager.getColor("Button.focus"));
		btnQuitar.setBackground(UIManager.getColor("Button.focus"));
		btnQuitar.setEnabled(false);
		btnQuitar.setVisible(false);
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont--;
				conexiones.add(q);
				agregados.remove(q);
				CargarTabla();
				CargarTablaAgregados();
				btnQuitar.setEnabled(false);
				if(cont>0) {
					okButton.setEnabled(true);
				}else {
					okButton.setEnabled(false);
				}
				
			}
		});
		btnQuitar.setBounds(445, 175, 80, 25);
		panel_MotherBoard.add(btnQuitar);
		
		panel_Disponibles = new JPanel();
		panel_Disponibles.setForeground(Color.DARK_GRAY);
		panel_Disponibles.setBackground(UIManager.getColor("Button.focus"));
		panel_Disponibles.setBounds(227, 37, 192, 211);
		panel_Disponibles.setVisible(false);
		panel_MotherBoard.add(panel_Disponibles);
		panel_Disponibles.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_Disponibles.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		modelo = new DefaultTableModel();
		String array[]={"USB-C","USB-A","Jack 3.5 mm","SATA","PCIe","I/O","HDMI","Ethernet","VGA","Micro-SD","SD"};
		conexiones =new ArrayList<String>( Arrays.asList(array));
		String []columns = {"Nombre"};
		modelo.setColumnIdentifiers(columns);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_1.clearSelection();
				int seleccion = table.getSelectedRow();
				int modelrow = table.convertRowIndexToModel(seleccion);
				if(seleccion!=-1){
					btnAgregar.setEnabled(true);
					btnQuitar.setEnabled(false);
					q = conexiones.get(seleccion);
				}else{
					btnAgregar.setEnabled(false);
					btnQuitar.setEnabled(false);
					q = null;
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modelo);
		scrollPane_1.setViewportView(table);
		
		panel_Agregados = new JPanel();
		panel_Agregados.setForeground(Color.DARK_GRAY);
		panel_Agregados.setBackground(UIManager.getColor("Button.focus"));
		panel_Agregados.setBounds(549, 37, 192, 211);
		panel_Agregados.setVisible(false);
		panel_MotherBoard.add(panel_Agregados);
		panel_Agregados.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Agregados.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		modelo_1 = new DefaultTableModel();
		String []columns2 = {"Nombre"};
		modelo_1.setColumnIdentifiers(columns2);
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
				int seleccion = table_1.getSelectedRow();
				int modelrow = table_1.convertRowIndexToModel(seleccion);
				if(seleccion!=-1){
					btnAgregar.setEnabled(false);
					btnQuitar.setEnabled(true);
					
					q = agregados.get(modelrow);
				}else{
					btnAgregar.setEnabled(false);
					btnQuitar.setEnabled(false);
					q = null;
				}
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(modelo_1);
		scrollPane.setViewportView(table_1);
		
		panel_MemoriaRam = new JPanel();
		panel_MemoriaRam.setForeground(UIManager.getColor("Button.focus"));
		panel_MemoriaRam.setBackground(Color.BLACK);
		panel_MemoriaRam.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
		panel_MemoriaRam.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_MemoriaRam);
		panel_MemoriaRam.setLayout(null);
		
		lblCantidadDeMemoria_MemoriaRam = new JLabel("Cantidad de memoria:");
		lblCantidadDeMemoria_MemoriaRam.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/compo.png")));
		lblCantidadDeMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		lblCantidadDeMemoria_MemoriaRam.setForeground(new Color(250, 250, 210));
		lblCantidadDeMemoria_MemoriaRam.setBounds(10, 54, 186, 14);
		lblCantidadDeMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(lblCantidadDeMemoria_MemoriaRam);
		
		lblTipoDeMemoria_MemoriaRam = new JLabel("Tipo de memoria:");
		lblTipoDeMemoria_MemoriaRam.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/ll.png")));
		lblTipoDeMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		lblTipoDeMemoria_MemoriaRam.setForeground(new Color(250, 250, 210));
		lblTipoDeMemoria_MemoriaRam.setBounds(10, 122, 186, 14);
		lblTipoDeMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(lblTipoDeMemoria_MemoriaRam);
		
		lblMemoria_MemoriaRam = new JLabel("Memoria:");
		lblMemoria_MemoriaRam.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/ll.png")));
		lblMemoria_MemoriaRam.setForeground(new Color(250, 250, 210));
		lblMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		lblMemoria_MemoriaRam.setBounds(10, 190, 186, 14);
		lblMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(lblMemoria_MemoriaRam);
		
		spnCantidadDeMemoria_MemoriaRam = new JSpinner();
		spnCantidadDeMemoria_MemoriaRam.setForeground(SystemColor.textHighlight);
		spnCantidadDeMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		spnCantidadDeMemoria_MemoriaRam.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidadDeMemoria_MemoriaRam.setBounds(140, 51, 111, 20);
		spnCantidadDeMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(spnCantidadDeMemoria_MemoriaRam);
		
		cbxTipoDeMemoria_MemoriaRam = new JComboBox();
		cbxTipoDeMemoria_MemoriaRam.setForeground(SystemColor.textHighlight);
		cbxTipoDeMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		cbxTipoDeMemoria_MemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3 "}));
		cbxTipoDeMemoria_MemoriaRam.setBounds(140, 119, 111, 20);
		cbxTipoDeMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(cbxTipoDeMemoria_MemoriaRam);
		
		cbxMemoria_MemoriaRam = new JComboBox();
		cbxMemoria_MemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		cbxMemoria_MemoriaRam.setForeground(SystemColor.textHighlight);
		cbxMemoria_MemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"Gb", "Mb"}));
		cbxMemoria_MemoriaRam.setBounds(140, 187, 111, 20);
		cbxMemoria_MemoriaRam.setVisible(false);
		panel_MemoriaRam.add(cbxMemoria_MemoriaRam);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBorder(new LineBorder(new Color(128, 0, 0)));
		panel_1.setBounds(10, 139, 753, 57);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnMemoriaRam = new JRadioButton("MemoriaRam");
		rdbtnMemoriaRam.setForeground(new Color(250, 250, 210));
		rdbtnMemoriaRam.setBackground(UIManager.getColor("Button.focus"));
		rdbtnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnMotherboard.setSelected(false);
				rdbtnDisco.setSelected(false);
				rdbtnMicroprocesadores.setSelected(false);
				rdbtnMemoriaRam.setSelected(true);
				
				panel_MotherBoard.setVisible(false);
				panel_DiscoDuro.setVisible(false);
				panel_MemoriaRam.setVisible(true);
				panel_Microprocesadores.setVisible(false);
				
				
				lblCantAlmacenamiento_DiscoDuro.setVisible(false);
				lblTipoDeConexion_DiscoDuro.setVisible(false);
				lblUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				spnCantAlmacenamiento_DiscoDuro.setVisible(false);
				cbxTipoDeConexion_DiscoDuro.setVisible(false);
				cbxUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				
				lblTipo_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblTipoDeconexion_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblVelocidad_Microprocesadores.setVisible(false);
				spnVelocidad_Microprocesadores.setVisible(false);
				
				lblMemoria_MemoriaRam.setVisible(true);
				cbxMemoria_MemoriaRam.setVisible(true);
				lblCantidadDeMemoria_MemoriaRam.setVisible(true);
				spnCantidadDeMemoria_MemoriaRam.setVisible(true);
				lblTipoDeMemoria_MemoriaRam.setVisible(true);
				cbxTipoDeMemoria_MemoriaRam.setVisible(true);
				
				lblConector_MotherBoard.setVisible(false);
				txtConexion_MotherBoard.setVisible(false);
				lblTipoRam_MotherBoard.setVisible(false);
				txtTipoRam_MotherBoard.setVisible(false);
				panel_Disponibles.setVisible(false);
				panel_Agregados.setVisible(false);
				btnAgregar.setVisible(false);
				btnQuitar.setVisible(false);
				
			}
		});
		rdbtnMemoriaRam.setBounds(207, 23, 109, 23);
		panel_1.add(rdbtnMemoriaRam);
		
		rdbtnDisco = new JRadioButton("Disco");
		rdbtnDisco.setBackground(UIManager.getColor("Button.focus"));
		rdbtnDisco.setForeground(new Color(250, 250, 210));
		rdbtnDisco.setSelected(true);
		rdbtnDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnMotherboard.setSelected(false);
				rdbtnDisco.setSelected(true);
				rdbtnMicroprocesadores.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				
				panel_MotherBoard.setVisible(false);
				panel_DiscoDuro.setVisible(true);
				panel_MemoriaRam.setVisible(false);
				panel_Microprocesadores.setVisible(false);
				
				
				lblCantAlmacenamiento_DiscoDuro.setVisible(true);
				lblTipoDeConexion_DiscoDuro.setVisible(true);
				lblUnidadDeAlmacenamiento_DiscoDuro.setVisible(true);
				spnCantAlmacenamiento_DiscoDuro.setVisible(true);
				cbxTipoDeConexion_DiscoDuro.setVisible(true);
				cbxUnidadDeAlmacenamiento_DiscoDuro.setVisible(true);
				
				lblTipo_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblTipoDeconexion_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblVelocidad_Microprocesadores.setVisible(false);
				spnVelocidad_Microprocesadores.setVisible(false);
				
				lblMemoria_MemoriaRam.setVisible(false);
				cbxMemoria_MemoriaRam.setVisible(false);
				lblCantidadDeMemoria_MemoriaRam.setVisible(false);
				spnCantidadDeMemoria_MemoriaRam.setVisible(false);
				lblTipoDeMemoria_MemoriaRam.setVisible(false);
				cbxTipoDeMemoria_MemoriaRam.setVisible(false);
				
				lblConector_MotherBoard.setVisible(false);
				txtConexion_MotherBoard.setVisible(false);
				lblTipoRam_MotherBoard.setVisible(false);
				txtTipoRam_MotherBoard.setVisible(false);
				panel_Disponibles.setVisible(false);
				panel_Agregados.setVisible(false);
				btnAgregar.setVisible(false);
				btnQuitar.setVisible(false);
			}
		});
		rdbtnDisco.setBounds(49, 23, 109, 23);
		panel_1.add(rdbtnDisco);
		
		rdbtnMicroprocesadores = new JRadioButton("Microprocesadores");
		rdbtnMicroprocesadores.setBackground(UIManager.getColor("Button.focus"));
		rdbtnMicroprocesadores.setForeground(new Color(250, 250, 210));
		rdbtnMicroprocesadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnMotherboard.setSelected(false);
				rdbtnDisco.setSelected(false);
				rdbtnMicroprocesadores.setSelected(true);
				rdbtnMemoriaRam.setSelected(false);
				
				panel_MotherBoard.setVisible(false);
				panel_DiscoDuro.setVisible(false);
				panel_MemoriaRam.setVisible(false);
				panel_Microprocesadores.setVisible(true);
				
				lblCantAlmacenamiento_DiscoDuro.setVisible(false);
				lblTipoDeConexion_DiscoDuro.setVisible(false);
				lblUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				spnCantAlmacenamiento_DiscoDuro.setVisible(false);
				cbxTipoDeConexion_DiscoDuro.setVisible(false);
				cbxUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				
				lblTipo_Microprocesadores.setVisible(true);
				cbxTipo_Microprocesadores.setVisible(true);
				lblTipoDeconexion_Microprocesadores.setVisible(true);
				txtTipoDeConexion_Microprocesadores.setVisible(true);
				lblVelocidad_Microprocesadores.setVisible(true);
				spnVelocidad_Microprocesadores.setVisible(true);
				
				lblMemoria_MemoriaRam.setVisible(false);
				cbxMemoria_MemoriaRam.setVisible(false);
				lblCantidadDeMemoria_MemoriaRam.setVisible(false);
				spnCantidadDeMemoria_MemoriaRam.setVisible(false);
				lblTipoDeMemoria_MemoriaRam.setVisible(false);
				cbxTipoDeMemoria_MemoriaRam.setVisible(false);
				
				lblConector_MotherBoard.setVisible(false);
				txtConexion_MotherBoard.setVisible(false);
				lblTipoRam_MotherBoard.setVisible(false);
				txtTipoRam_MotherBoard.setVisible(false);
				panel_Disponibles.setVisible(false);
				panel_Agregados.setVisible(false);
				btnAgregar.setVisible(false);
				btnQuitar.setVisible(false);
				
			}
		});
		rdbtnMicroprocesadores.setBounds(365, 23, 147, 23);
		panel_1.add(rdbtnMicroprocesadores);
		
		rdbtnMotherboard = new JRadioButton("MotherBoard");
		rdbtnMotherboard.setForeground(new Color(250, 250, 210));
		rdbtnMotherboard.setBackground(UIManager.getColor("Button.focus"));
		rdbtnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnMotherboard.setSelected(true);
				rdbtnDisco.setSelected(false);
				rdbtnMicroprocesadores.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				
				panel_MotherBoard.setVisible(true);
				panel_DiscoDuro.setVisible(false);
				panel_MemoriaRam.setVisible(false);
				panel_Microprocesadores.setVisible(false);
				
				
				lblCantAlmacenamiento_DiscoDuro.setVisible(false);
				lblTipoDeConexion_DiscoDuro.setVisible(false);
				lblUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				spnCantAlmacenamiento_DiscoDuro.setVisible(false);
				cbxTipoDeConexion_DiscoDuro.setVisible(false);
				cbxUnidadDeAlmacenamiento_DiscoDuro.setVisible(false);
				
				lblTipo_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblTipoDeconexion_Microprocesadores.setVisible(false);
				cbxTipo_Microprocesadores.setVisible(false);
				lblVelocidad_Microprocesadores.setVisible(false);
				spnVelocidad_Microprocesadores.setVisible(false);
				
				lblMemoria_MemoriaRam.setVisible(false);
				cbxMemoria_MemoriaRam.setVisible(false);
				lblCantidadDeMemoria_MemoriaRam.setVisible(false);
				spnCantidadDeMemoria_MemoriaRam.setVisible(false);
				lblTipoDeMemoria_MemoriaRam.setVisible(false);
				cbxTipoDeMemoria_MemoriaRam.setVisible(false);
				
				lblConector_MotherBoard.setVisible(true);
				txtConexion_MotherBoard.setVisible(true);
				lblTipoRam_MotherBoard.setVisible(true);
				txtTipoRam_MotherBoard.setVisible(true);
				panel_Disponibles.setVisible(true);
				panel_Agregados.setVisible(true);
				btnAgregar.setVisible(true);
				btnQuitar.setVisible(true);
				
				
				
			}
		});
		rdbtnMotherboard.setBounds(561, 23, 139, 23);
		panel_1.add(rdbtnMotherboard);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(128, 0, 0)));
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/registrer.png")));
				okButton.setForeground(new Color(0, 255, 0));
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						Componente aux = null;
						String serie = txtSerie.getText();
						String modelo= txtModelo.getText();
						String marca = txtMarca.getText();
						float compra = Float.parseFloat(spnCompra.getValue().toString());
						float venta = Float.parseFloat(spnVenta.getValue().toString());
						int cantMin = Integer.parseInt(spnCantMinima.getValue().toString());
						int cantMax = Integer.parseInt(spnCantMaxima.getValue().toString());
						int cantReal = Integer.parseInt(spnCantReal.getValue().toString());	
						if( (cantReal<=cantMax && cantReal>=cantMin) && (venta>=(compra+compra*0.10f)) ) {
							if(!txtMarca.getText().isEmpty() || !txtModelo.getText().isEmpty() ) {
								
						if(rdbtnDisco.isSelected()) {
							float almacenamiento = Float.parseFloat(spnCantAlmacenamiento_DiscoDuro.getValue().toString());
							String conexion = cbxTipoDeConexion_DiscoDuro.getSelectedItem().toString();
							boolean Gb = true;
							if(cbxUnidadDeAlmacenamiento_DiscoDuro.getSelectedItem().toString() == "Tb") {
								Gb = false;
							}
							aux = new Disco(txtSerie.getText(), modelo, marca, venta, compra, cantMin, cantMax, cantReal, almacenamiento, Gb, conexion);
							Prodacom.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "El Componente ha sido registrado con exito. ", "información", JOptionPane.INFORMATION_MESSAGE);	

						}
						if(rdbtnMemoriaRam.isSelected()) {
							float cantidadMem = Float.parseFloat(spnCantidadDeMemoria_MemoriaRam.getValue().toString());
							String tipo= cbxTipoDeMemoria_MemoriaRam.getSelectedItem().toString();
							boolean Gb = true;
							if(cbxMemoria_MemoriaRam.getSelectedItem().toString() == "Mb") {
								Gb = false;
							}
							aux = new MemoriaRam(txtSerie.getText(), modelo, marca, venta, compra, cantMin, cantMax, cantReal, cantidadMem, tipo, Gb);
							Prodacom.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "El Componente ha sido registrado con exito. ", "información", JOptionPane.INFORMATION_MESSAGE);	

						}
						if(rdbtnMicroprocesadores.isSelected()) {
							if(!txtTipoDeConexion_Microprocesadores.getText().isEmpty()) {
							
							String conector = txtTipoDeConexion_Microprocesadores.getText();
							float velocidad = Float.parseFloat(spnVelocidad_Microprocesadores.getValue().toString());
							boolean GHz = true;
							if(cbxTipo_Microprocesadores.getSelectedItem().toString() == "MHz") {
								GHz = false;
							}
								aux = new Microprocesadores(txtSerie.getText(), modelo, marca, venta, compra, cantMin, cantMax, cantReal, conector, velocidad, GHz);
								Prodacom.getInstance().insertarComponente(aux);
								JOptionPane.showMessageDialog(null, "El Componente ha sido registrado con exito. ", "información", JOptionPane.INFORMATION_MESSAGE);	

						}else {
							JOptionPane.showMessageDialog(null, "Recuerde que debe de llenar el apartado de Tipo de conexion para el microprocesador.", "Información", JOptionPane.INFORMATION_MESSAGE);

						}
						}
						
						if(rdbtnMotherboard.isSelected() ) {
							if(!txtConexion_MotherBoard.getText().isEmpty() || !txtTipoRam_MotherBoard.getText().isEmpty() || modelo_1.getRowCount()>0){
							String conector = txtConexion_MotherBoard.getText();
							String tipoRam = txtTipoRam_MotherBoard.getText();
							
							aux = new MotherBoard(txtSerie.getText(), modelo, marca, venta, compra, cantMin, cantMax, cantReal, conector, tipoRam, conexiones);
							Prodacom.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "El Componente ha sido registrado con exito. ", "información", JOptionPane.INFORMATION_MESSAGE);	

						}else {
							JOptionPane.showMessageDialog(null, "Recuerde que debe de llenar los apartados de la seccion Motherboard.\nTambien debe verificar que la tabla tenga al menos 1 conexión agregada.", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
							//Prodacom.getInstance().insertarComponente(aux);
						}
						
						LIMPIAR();
						}else {
							JOptionPane.showMessageDialog(null,"Debe llenar la informacion general!!!","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "El precio de venta debe de ser al menos un 10% mas alto que el precio de compra.\nPOR POLITICA DE LA EMPRESA.\nRecuerde que la cantidad real debe ser mayor que la míninma y menor que la cantidad máxima del componente.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				
				}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(IngresoComponentes.class.getResource("/iconos/delete.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(String s:agregados) {
							conexiones.add(s);
						}
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		CargarTabla();
		CargarTablaAgregados();
	}
	
	private void LIMPIAR() {
		
		txtSerie.setText("S-"+Prodacom.getInstance().getCod_componente());
		txtModelo.setText("");
		txtMarca.setText("");
		spnCompra.setValue(new Integer(1));
		spnVenta.setValue(new Integer(1));
		spnCantMinima.setValue(new Integer(1));
		spnCantMaxima.setValue(new Integer(1));
		spnCantReal.setValue(new Integer(1));
		//Motherboard
		txtConexion_MotherBoard.setText("");
		txtTipoRam_MotherBoard.setText("");
		//disco
		spnCantAlmacenamiento_DiscoDuro.setValue(new Integer(1));
		cbxTipoDeConexion_DiscoDuro.setSelectedItem(0);
		cbxUnidadDeAlmacenamiento_DiscoDuro.setSelectedItem(0);
		//Memoria Ram
		spnCantidadDeMemoria_MemoriaRam.setValue(new Integer(1));
		cbxMemoria_MemoriaRam.setSelectedItem(0);
		cbxTipoDeMemoria_MemoriaRam.setSelectedItem(0);
		//Microprocesadores
		txtTipoDeConexion_Microprocesadores.setText("");
		spnVelocidad_Microprocesadores.setValue(new Integer(1));
		cbxTipo_Microprocesadores.setSelectedItem(0);
		
		
		agregados.removeAll(agregados);
		conexiones.removeAll(conexiones);
		//modelo = new DefaultTableModel();
		String array[]={"USB-C","USB-A","Jack 3.5 mm","SATA","PCIe","I/O","HDMI","Ethernet","VGA","Micro-SD","SD"};
		conexiones =new ArrayList<String>( Arrays.asList(array));
		String []columns = {"Nombre"};
		//modelo.setColumnIdentifiers(columns);
		CargarTabla();
		CargarTablaAgregados();
	}
	private void CargarTablaAgregados() {
		modelo_1.setRowCount(0);
		fila = new Object[modelo_1.getColumnCount()];
		for(String e:agregados) {
			fila[0]=e;
			modelo_1.addRow(fila);
		}
		
	}

	private void CargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(String e: conexiones) {
			fila[0]=e;
			modelo.addRow(fila);
		}
	}
}
