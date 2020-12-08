package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logico.Combo;
import logico.Componente;
import logico.Disco;

import logico.MemoriaRam;
import logico.Microprocesadores;
import logico.MotherBoard;
import logico.Prodacom;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ListadoComponentes extends JDialog {
	
	private Componente auxiliar = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JComboBox cbxFiltro;
	private JTextField txtBusqueda;
	private JButton btnSeleccionar;
	private int seleccion = -1;
	private int modelrow = -1;
	private static Combo cargar = null;
	private static int mode = -1;
	private JButton btnInformacion;
	private Combo c = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param b 
	 */
	public ListadoComponentes(Combo aux,int mode) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoComponentes.class.getResource("/iconos/tecno.png")));
		setTitle("Listado de Componentes");
		
		this.cargar=aux;
		this.mode=mode;
		if(cargar==null) {
			if(mode==1) {
				setTitle("Listado de combos");
				
			}else {	
			setTitle("Listado de componentes");
			}
		}else {
				if(mode==1) {
				setTitle("Listado de componentes del combo: "+cargar.getNombre());
				}else {
					setTitle(cargar.getNombre());
				}
				}
		
		setModal(true);
		setResizable(false);
		setForeground(Color.RED);
		setBackground(UIManager.getColor("Button.focus"));
		setBounds(100, 100, 854, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(SystemColor.textHighlight);
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Button.focus"));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 47, 808, 314);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			
			modelo = new DefaultTableModel();
			String columns[] = {"Código","Tipo","Cant. en almacen","Precio Unitario","modelo","Marca"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					if(cargar==null) {
						if(seleccion!=-1 && (int)modelo.getValueAt(modelrow, 2)>0) {
							btnSeleccionar.setEnabled(true);
							if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
								btnInformacion.setEnabled(true);
								c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(modelrow, 0));
							}else {
								btnInformacion.setEnabled(false);
							}
						}else {
							btnInformacion.setEnabled(false);
							btnSeleccionar.setEnabled(false);
						}
					}else {
						btnSeleccionar.setEnabled(false);
						btnInformacion.setEnabled(false);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel = new JLabel("Filtro");
			lblNewLabel.setIcon(new ImageIcon(ListadoComponentes.class.getResource("/iconos/ll.png")));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setBounds(576, 14, 93, 25);
			panel.add(lblNewLabel);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbxFiltro.setBackground(UIManager.getColor("Button.focus"));
			cbxFiltro.setForeground(SystemColor.textHighlight);
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadTable(cbxFiltro.getSelectedIndex());
				}

				

			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria Ram", "Microprocesador", "MotherBoard","Combos"}));
			cbxFiltro.setBounds(691, 12, 123, 30);
			if(cargar!=null) {
				cbxFiltro.setEnabled(false);
			}else {
				if(mode==1) {
					cbxFiltro.setEnabled(false);
					cbxFiltro.setSelectedIndex(5);
					loadTable(5);
				}
			}
			panel.add(cbxFiltro);
			
			JLabel lblBuscador = new JLabel("Buscador:");
			lblBuscador.setIcon(new ImageIcon(ListadoComponentes.class.getResource("/iconos/busca.png")));
			lblBuscador.setForeground(SystemColor.textHighlight);
			lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBuscador.setBackground(Color.BLACK);
			lblBuscador.setBounds(6, 14, 134, 25);
			panel.add(lblBuscador);
			
			txtBusqueda = new JTextField();
			txtBusqueda.setBackground(UIManager.getColor("Button.focus"));
			txtBusqueda.setForeground(new Color(0, 0, 255));
			txtBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
				}
			});
			txtBusqueda.setBounds(150, 13, 236, 30);
			panel.add(txtBusqueda);
			txtBusqueda.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
				btnSeleccionar.setForeground(new Color(0, 255, 0));
				btnSeleccionar.setIcon(new ImageIcon(ListadoComponentes.class.getResource("/iconos/select.png")));
				btnSeleccionar.setEnabled(false);
				if(mode==0) {
					btnSeleccionar.setVisible(true);
				}else {
					btnSeleccionar.setVisible(false);
				}
				
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
							c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(modelrow, 0));
							Ventas a = new Ventas(c.getCod(),c.getNombre(),c.calcularprecio(),1);
							dispose();
							a.setVisible(true);
						}else {
							Componente c = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));
							Ventas a = new Ventas(c.getSerie(),c.getMarca()+" "+c.getModelo(),c.getPrecioVenta(),c.getCantReal());
							dispose();
							a.setVisible(true);
						}
					}
				});
				
				btnInformacion = new JButton("Informacion");
				btnInformacion.setIcon(new ImageIcon(ListadoComponentes.class.getResource("/iconos/Notepad-Bloc-notes-2-icon.png")));
				btnInformacion.setForeground(new Color(0, 0, 205));
				btnInformacion.setBackground(UIManager.getColor("Button.focus"));
				btnInformacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoComponentes a = new ListadoComponentes(c, 0);
						a.setVisible(true);
					}
				});
				btnInformacion.setEnabled(false);
				buttonPane.add(btnInformacion);
				buttonPane.add(btnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(ListadoComponentes.class.getResource("/iconos/cancel.png")));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(mode!=1) {
			cargarTabla();
		}
		if(mode==1) {
			loadTable(5);
		}
		
		botones(mode);
	}

	

	private void botones(int mode2) {
		if(mode2!=5) {
			btnSeleccionar.setVisible(false);
			btnInformacion.setVisible(true);
		}else {
			btnSeleccionar.setVisible(true);
			btnInformacion.setVisible(false);
		}
		
	}



	private void loadTable(int seleccionado) {
		
		modelo.setRowCount(0);
		
		fila = new Object[modelo.getColumnCount()];
		
		if(seleccionado == 0) {
			cargarTabla();
		}
		
		if(seleccionado == 1) {
			for (Componente comp : Prodacom.getInstance().getComponentes()) {
				
				if(comp instanceof Disco) {
				
				fila[0] = comp.getSerie();
				fila[1] = "Disco Duro";
				fila[2] = comp.getCantReal();
				fila[3] = comp.getPrecioVenta();
				fila[4] = comp.getModelo();
				fila[5] = comp.getMarca();
				
				modelo.addRow(fila);
			}
			}
		}else if(seleccionado == 2) {
			for (Componente comp : Prodacom.getInstance().getComponentes()) {
				if(comp instanceof MemoriaRam) {
					
					fila[0] = comp.getSerie();
					fila[1] = "Memoria Ram";	
					fila[2] = comp.getCantReal();
					fila[3] = comp.getPrecioVenta();
					fila[4] = comp.getModelo();
					fila[5] = comp.getMarca();
					
					modelo.addRow(fila);
					
				}
			}
		}
		else if(seleccionado == 3) {
			for (Componente comp : Prodacom.getInstance().getComponentes()) {
				if(comp instanceof Microprocesadores){
				fila[0] = comp.getSerie();							
				fila[1] = "Microprocesador";							
				fila[2] = comp.getCantReal();
				fila[3] = comp.getPrecioVenta();
				fila[4] = comp.getModelo();
				fila[5] = comp.getMarca();
				
				modelo.addRow(fila);
				}
			}
		}
		else if(seleccionado == 4) {
			for (Componente comp : Prodacom.getInstance().getComponentes()) {
				if(comp instanceof MotherBoard) {
					fila[0] = comp.getSerie();
					
					fila[1] = "MotherBoard";
					
					fila[2] = comp.getCantReal();
					fila[3] = comp.getPrecioVenta();
					fila[4] = comp.getModelo();
					fila[5] = comp.getMarca();
					
					modelo.addRow(fila);
				}
			}
		}
		else if(seleccionado == 5 ) {
			for(Combo c : Prodacom.getInstance().getCombos()) {
				fila[0] = c.getCod();
				fila[1] = "Combo";
				fila[2] = 1;
				fila[3] = c.calcularprecio();
				fila[4] = c.getNombre();
				fila[5] = "Unbranded";
				modelo.addRow(fila);
			}
		}
	}
	
	
	private void cargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
			
			
		if(cargar==null) {
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				fila[0] = comp.getSerie();
				if(comp instanceof Disco) {
					fila[1] = "Disco Duro";
				}
				if(comp instanceof MotherBoard) {
					fila[1] = "MotherBoard";
				}
				if(comp instanceof Microprocesadores) {
					fila[1] = "Microprocesadores";
				}
				if(comp instanceof MemoriaRam) {
					fila[1] = "Memoria Ram";
				}
				
				fila[2] = comp.getCantReal();
				fila[3] = comp.getPrecioVenta();
				fila[4] = comp.getModelo();
				fila[5] = comp.getMarca();
				modelo.addRow(fila);
			}
				for(Combo c : Prodacom.getInstance().getCombos()) {
					fila[0] = c.getCod();
					fila[1] = "Combo";
					fila[2] = 1;
					fila[3] = c.calcularprecio();
					fila[4] = c.getNombre();
					fila[5] = "Unbranded";
					modelo.addRow(fila);
			}
		}else {
			for(Componente comp : cargar.getComponentes()){
				fila[0] = comp.getSerie();
				if(comp instanceof Disco) {
					fila[1] = "Disco Duro";
				}
				if(comp instanceof MotherBoard) {
					fila[1] = "MotherBoard";
				}
				if(comp instanceof Microprocesadores) {
					fila[1] = "Microprocesadores";
				}
				if(comp instanceof MemoriaRam) {
					fila[1] = "Memoria Ram";
				}
				
				fila[2] = comp.getCantReal();
				fila[3] = comp.getPrecioVenta();
				fila[4] = comp.getModelo();
				fila[5] = comp.getMarca();
				modelo.addRow(fila);
			}
		}
	}
}
