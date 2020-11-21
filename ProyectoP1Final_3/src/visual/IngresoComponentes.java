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
import javax.swing.table.DefaultTableModel;



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
	private JLabel lblTipoDeMemoria;
	private JLabel lblMemoria;
	private JSpinner spnCantidadDeMemoria;
	private JComboBox cbxTipoDeMemoria;
	private JComboBox cbxMemoria;
	private JPanel panel_Microprocesadores;
	private JLabel lblTipoDeconexion_Microprocesadores;
	private JLabel lblVelocidad_Microprocesadores;
	private JLabel lblTipo_Microprocesadores;
	private JTextField txtTipoDeConexion_Microprocesadores;

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
		setBounds(100, 100, 789, 563);
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
		
		panel_Microprocesadores = new JPanel();
		panel_Microprocesadores.setBorder(new TitledBorder(null, "Informacion Adicional:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_Microprocesadores.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_Microprocesadores);
		panel_Microprocesadores.setLayout(null);
		
		lblTipoDeconexion_Microprocesadores = new JLabel("Tipo de conexion o socket:");
		lblTipoDeconexion_Microprocesadores.setBounds(10, 58, 171, 14);
		panel_Microprocesadores.add(lblTipoDeconexion_Microprocesadores);
		
		lblVelocidad_Microprocesadores = new JLabel("Velocidad:");
		lblVelocidad_Microprocesadores.setBounds(10, 135, 171, 14);
		panel_Microprocesadores.add(lblVelocidad_Microprocesadores);
		
		lblTipo_Microprocesadores = new JLabel("Tipo de procesamiento:");
		lblTipo_Microprocesadores.setBounds(10, 201, 171, 14);
		panel_Microprocesadores.add(lblTipo_Microprocesadores);
		
		txtTipoDeConexion_Microprocesadores = new JTextField();
		txtTipoDeConexion_Microprocesadores.setBounds(191, 55, 199, 20);
		panel_Microprocesadores.add(txtTipoDeConexion_Microprocesadores);
		txtTipoDeConexion_Microprocesadores.setColumns(10);
		
		JSpinner spnVelocidad_Microprocesadores = new JSpinner();
		spnVelocidad_Microprocesadores.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVelocidad_Microprocesadores.setBounds(191, 132, 199, 20);
		panel_Microprocesadores.add(spnVelocidad_Microprocesadores);
		
		JComboBox cbxTipo_Microprocesadores = new JComboBox();
		cbxTipo_Microprocesadores.setModel(new DefaultComboBoxModel(new String[] {"MHz", "GHz"}));
		cbxTipo_Microprocesadores.setBounds(191, 198, 199, 20);
		panel_Microprocesadores.add(cbxTipo_Microprocesadores);
		
		panel_MotherBoard = new JPanel();
		panel_MotherBoard.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_MotherBoard.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_MotherBoard);
		panel_MotherBoard.setLayout(null);
		
		lblConector_MotherBoard = new JLabel("Conexion:");
		lblConector_MotherBoard.setBounds(10, 49, 64, 14);
		panel_MotherBoard.add(lblConector_MotherBoard);
		
		lblTipoRam_MotherBoard = new JLabel("TipoRam:");
		lblTipoRam_MotherBoard.setBounds(10, 112, 64, 14);
		panel_MotherBoard.add(lblTipoRam_MotherBoard);
		
		txtConexion_MotherBoard = new JTextField();
		txtConexion_MotherBoard.setBounds(87, 46, 125, 20);
		panel_MotherBoard.add(txtConexion_MotherBoard);
		txtConexion_MotherBoard.setColumns(10);
		
		txtTipoRam_MotherBoard = new JTextField();
		txtTipoRam_MotherBoard.setColumns(10);
		txtTipoRam_MotherBoard.setBounds(87, 109, 125, 20);
		panel_MotherBoard.add(txtTipoRam_MotherBoard);
		
		btnAgregar = new JButton(">>");
		btnAgregar.setEnabled(false);
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
		
		btnQuitar = new JButton("<<");
		btnQuitar.setEnabled(false);
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
		panel_Disponibles.setBounds(227, 37, 192, 211);
		panel_MotherBoard.add(panel_Disponibles);
		panel_Disponibles.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_Disponibles.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
		panel_Agregados.setBounds(549, 37, 192, 211);
		panel_MotherBoard.add(panel_Agregados);
		panel_Agregados.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Agregados.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
					
					q = agregados.get(seleccion);
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
		rdbtnMicroprocesadores.setBounds(407, 23, 147, 23);
		panel_1.add(rdbtnMicroprocesadores);
		
		JRadioButton rdbtnMotherboard = new JRadioButton("MotherBoard");
		rdbtnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rdbtnMotherboard.setSelected(true);
		rdbtnMotherboard.setBounds(53, 23, 139, 23);
		panel_1.add(rdbtnMotherboard);
		
		JPanel panel_MemoriaRam = new JPanel();
		panel_MemoriaRam.setBorder(new TitledBorder(null, "Informacion Adicional", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_MemoriaRam.setBounds(10, 207, 753, 261);
		contentPanel.add(panel_MemoriaRam);
		panel_MemoriaRam.setLayout(null);
		
		lblCantidadDeMemoria_MemoriaRam = new JLabel("Cantidad de memoria:");
		lblCantidadDeMemoria_MemoriaRam.setBounds(10, 54, 111, 14);
		panel_MemoriaRam.add(lblCantidadDeMemoria_MemoriaRam);
		
		lblTipoDeMemoria = new JLabel("Tipo de memoria:");
		lblTipoDeMemoria.setBounds(10, 122, 97, 14);
		panel_MemoriaRam.add(lblTipoDeMemoria);
		
		lblMemoria = new JLabel("Memoria:");
		lblMemoria.setBounds(10, 190, 86, 14);
		panel_MemoriaRam.add(lblMemoria);
		
		spnCantidadDeMemoria = new JSpinner();
		spnCantidadDeMemoria.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidadDeMemoria.setBounds(131, 51, 111, 20);
		panel_MemoriaRam.add(spnCantidadDeMemoria);
		
		cbxTipoDeMemoria = new JComboBox();
		cbxTipoDeMemoria.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3 "}));
		cbxTipoDeMemoria.setBounds(131, 119, 111, 20);
		panel_MemoriaRam.add(cbxTipoDeMemoria);
		
		cbxMemoria = new JComboBox();
		cbxMemoria.setModel(new DefaultComboBoxModel(new String[] {"Gb", "Mb"}));
		cbxMemoria.setBounds(131, 187, 111, 20);
		panel_MemoriaRam.add(cbxMemoria);
		
		modelo_1 = new DefaultTableModel();
		String []columns2 = {"Nombre"};
		modelo_1.setColumnIdentifiers(columns2);
		
		modelo = new DefaultTableModel();
		String array[]={"USB-C","USB-A","Jack 3.5 mm","SATA","PCIe","I/O","HDMI","Ethernet","VGA","Micro-SD","SD"};
		conexiones =new ArrayList<String>( Arrays.asList(array));
		String []columns = {"Nombre"};
		modelo.setColumnIdentifiers(columns);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
