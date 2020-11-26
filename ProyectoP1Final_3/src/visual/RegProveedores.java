package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Disco;
import logico.MemoriaRam;
import logico.Microprocesadores;
import logico.MotherBoard;
import logico.Prodacom;
import logico.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class RegProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCredito;
	private JTextField txtDireccion;
	private JTable table;
	private JTable table_1;
	private JButton btnAgregar;
	private static JComboBox cbxFiltro;
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	private JButton btnQuitar;
	private Componente q = null;
	private static ArrayList<Componente>agregados = new ArrayList<Componente>();
	private static ArrayList<Componente>disponibles = new ArrayList<Componente>();
	private int cont = 0;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public RegProveedores() {
		setModal(true);
		setResizable(false);
		setTitle("Registro Proveedor");
		setBounds(100, 100, 730, 606);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		for(Componente c: Prodacom.getInstance().getComponentes()){
			disponibles.add(c);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodigo = new JLabel("Codigo: ");
			lblCodigo.setBounds(12, 13, 56, 16);
			panel.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(12, 42, 116, 26);
			txtCodigo.setText("P-"+Prodacom.cod_proveedores);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre Empresa:");
			lblNombre.setBounds(220, 13, 130, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(220, 42, 474, 26);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(220, 77, 77, 16);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(220, 114, 474, 26);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblCredito = new JLabel("Credito Disponible:");
			lblCredito.setBounds(12, 77, 116, 16);
			panel.add(lblCredito);
			
			txtCredito = new JTextField();
			txtCredito.setBounds(12, 114, 116, 26);
			panel.add(txtCredito);
			txtCredito.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(12, 149, 116, 16);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(12, 178, 682, 26);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Disponibles", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 296, 297, 197);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String []columns = {"Codigo","Tipo","Marca","Modelo"};
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
						
						q = disponibles.get(seleccion);
					}else{
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(false);
						q = null;
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			btnAgregar = new JButton(">>");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cont++;
					disponibles.remove(q);
					agregados.add(q);
					CargarTabla();
					CargarTablaVendidos();
					btnAgregar.setEnabled(false);
					q=null;
					if(cont>0) {
						okButton.setEnabled(true);
					}else {
						okButton.setEnabled(false);
					}
				}
			});
			btnAgregar.setEnabled(false);
			btnAgregar.setBounds(319, 329, 68, 25);
			panel.add(btnAgregar);
			
			btnQuitar = new JButton("<<");
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cont--;
					agregados.remove(q);
					disponibles.add(q);
					CargarTabla();
					CargarTablaVendidos();
					q=null;
					if(cont>0) {
						okButton.setEnabled(true);
					}else {
						okButton.setEnabled(false);
					}
				}			
			});
			btnQuitar.setEnabled(false);
			btnQuitar.setBounds(319, 435, 68, 25);
			panel.add(btnQuitar);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Agregados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_2.setBounds(397, 296, 297, 197);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			modelo_1 = new DefaultTableModel();
			String []columns2 = {"Codigo","Tipo","Marca","Modelo"};
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
			scrollPane_1.setViewportView(table_1);
			
			JLabel lblFiltro = new JLabel("Filtro:");
			lblFiltro.setBounds(12, 220, 56, 16);
			panel.add(lblFiltro);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CargarTabla();
					CargarTablaVendidos();
				}
			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Discos Duros", "Memorias Ram", "MotherBoard", "MicroProcesadores"}));
			cbxFiltro.setBounds(12, 249, 212, 26);
			panel.add(cbxFiltro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Proveedor p = new Proveedor(agregados,txtNombre.getText(),txtCodigo.getText()
								,txtTelefono.getText(),txtDireccion.getText(),
								Float.parseFloat(txtCredito.getText()));
						Prodacom.getInstance().insertarProveedor(p);
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el proveedor");
						clear();
					}

				});
				okButton.setEnabled(false);
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
		CargarTabla();
		CargarTablaVendidos();
	}
	
	private void CargarTabla() {
		switch(cbxFiltro.getSelectedIndex()) {
		case 0:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				fila[0]=c.getSerie();
				if(c instanceof Disco) {
					fila[1]="Disco Duro";
				}
				if(c instanceof MemoriaRam) {
					fila[1]="Memoria Ram";
				}
				if(c instanceof Microprocesadores) {
					fila[1]="Microprocesador";
				}
				if(c instanceof MotherBoard) {
					fila[1]="MotherBoard";
				}
				fila[2]=c.getMarca();
				fila[3]=c.getModelo();
				modelo.addRow(fila);
			}
			break;
		case 1:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof Disco) {
					fila[0]=c.getSerie();
					fila[1]="Disco Duro";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo.addRow(fila);
				}
			}
			break;
		case 2:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof MemoriaRam) {
					fila[0]=c.getSerie();
					fila[1]="Memoria Ram";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo.addRow(fila);
				}
			}
			break;
		case 3:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof Microprocesadores) {
					fila[0]=c.getSerie();
					fila[1]="Microprocesador";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo.addRow(fila);
				}
			}
			break;
		case 4:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof MotherBoard) {
					fila[0]=c.getSerie();
					fila[1]="MotherBoard";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo.addRow(fila);
				}
			}
			break;
		}
		
	}
	
	
	private void CargarTablaVendidos() {
		switch(cbxFiltro.getSelectedIndex()) {
		case 0:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				fila[0]=c.getSerie();
				if(c instanceof Disco) {
					fila[1]="Disco Duro";
				}
				if(c instanceof MemoriaRam) {
					fila[1]="Memoria Ram";
				}
				if(c instanceof Microprocesadores) {
					fila[1]="Microprocesador";
				}
				if(c instanceof MotherBoard) {
					fila[1]="MotherBoard";
				}
				fila[2]=c.getMarca();
				fila[3]=c.getModelo();
				modelo_1.addRow(fila);
			}
			break;
		case 1:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof Disco) {
					fila[0]=c.getSerie();
					fila[1]="Disco Duro";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo_1.addRow(fila);
				}
			}
			break;
		case 2:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof MemoriaRam) {
					fila[0]=c.getSerie();
					fila[1]="Memoria Ram";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo_1.addRow(fila);
				}
			}
			break;
		case 3:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof Microprocesadores) {
					fila[0]=c.getSerie();
					fila[1]="Microprocesador";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo_1.addRow(fila);
				}
			}
			break;
		case 4:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof MotherBoard) {
					fila[0]=c.getSerie();
					fila[1]="MotherBoard";
					fila[2]=c.getMarca();
					fila[3]=c.getModelo();
					modelo_1.addRow(fila);
				}
			}
			break;
		}
		
	}
	
	private void clear() {
		txtCodigo.setText("P-"+Prodacom.cod_proveedores);
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCredito.setText("");
		modelo.setRowCount(0);
		modelo_1.setRowCount(0);
		disponibles.removeAll(disponibles);
		for(Componente c : Prodacom.getInstance().getComponentes()) {
			disponibles.add(c);
		}
		agregados.removeAll(agregados);
	}
	
}
