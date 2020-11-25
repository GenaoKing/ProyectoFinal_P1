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

public class ListadoComponentes extends JDialog {
	
	private Componente auxiliar = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JButton btnEliminar;
	private JComboBox cbxFiltro;
	private JTextField txtBusqueda;
	private JButton btnSeleccionar;
	private int seleccion = -1;
	private int modelrow = -1;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param b 
	 */
	public ListadoComponentes() {
		setTitle("Listado de componentes");
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
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 47, 808, 314);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			
			modelo = new DefaultTableModel();
			String columns[] = {"Código","Tipo","Cant. en almacen","Precio Unitario","modelo","Serie","Marca"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1) {
						System.out.println(modelrow);
						btnEliminar.setEnabled(true);
						btnSeleccionar.setEnabled(true);
						auxiliar = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));
						
					}else {
						btnEliminar.setEnabled(false);
						btnSeleccionar.setEnabled(false);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel = new JLabel("Filtro");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setBounds(611, 14, 58, 25);
			panel.add(lblNewLabel);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbxFiltro.setBackground(UIManager.getColor("Button.focus"));
			cbxFiltro.setForeground(SystemColor.textHighlight);
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadTable(cbxFiltro.getSelectedIndex());
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
							fila[5] = comp.getSerie();
							fila[6] = comp.getMarca();
							
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
								fila[5] = comp.getSerie();
								fila[6] = comp.getMarca();
								
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
							fila[5] = comp.getSerie();
							fila[6] = comp.getMarca();
							
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
								fila[5] = comp.getSerie();
								fila[6] = comp.getMarca();
								
								modelo.addRow(fila);
							}
						}
					}
					else if(seleccionado == 5 ) {
						for(Combo c : Prodacom.getInstance().getCombos()) {
							fila[0] = c.getCod();
							fila[1] = "Combo";
							fila[2] = "Hasta Agotar Existencias";
							fila[3] = c.calcularprecio();
							fila[4] = c.getNombre();
							fila[5] = "Unbranded";
							fila[6] = "Unbranded";
							modelo.addRow(fila);
						}
					}
				}

			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria Ram", "Microprocesador", "MotherBoard","Combos"}));
			cbxFiltro.setBounds(691, 12, 123, 30);
			panel.add(cbxFiltro);
			
			JLabel lblBuscador = new JLabel("Buscador:");
			lblBuscador.setForeground(SystemColor.textHighlight);
			lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBuscador.setBackground(Color.BLACK);
			lblBuscador.setBounds(6, 14, 94, 25);
			panel.add(lblBuscador);
			
			txtBusqueda = new JTextField();
			txtBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
				}
			});
			txtBusqueda.setBounds(106, 12, 261, 30);
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
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setForeground(UIManager.getColor("Button.focus"));
				btnEliminar.setBackground(Color.RED);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(auxiliar!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar el componente:"+auxiliar.getSerie()+ "Marca:"+auxiliar.getMarca(),"Confirmacion", JOptionPane.INFORMATION_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Prodacom.getInstance().getComponentes().remove(auxiliar);
								cargarTabla();
								btnEliminar.setEnabled(false);
								auxiliar = null;
							}
							JOptionPane.showConfirmDialog(null, "Se ha eliminado con exito el componente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
							Combo c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(modelrow, 0));
							Ventas a = new Ventas(c.getCod(),c.getNombre(),c.calcularprecio(),100);
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
				buttonPane.add(btnSeleccionar);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(178, 34, 34));
				cancelButton.setForeground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarTabla();
	}

	

	
	
	private void cargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
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
			}else {
				fila[1] = "Memoria Ram";
			}
			
			fila[2] = comp.getCantReal();
			fila[3] = comp.getPrecioVenta();
			fila[4] = comp.getModelo();
			fila[5] = comp.getSerie();
			fila[6] = comp.getMarca();
			modelo.addRow(fila);
		}
			for(Combo c : Prodacom.getInstance().getCombos()) {
				fila[0] = c.getCod();
				fila[1] = "Combo";
				fila[2] = "Hasta Agotar Existencias";
				fila[3] = c.calcularprecio();
				fila[4] = c.getNombre();
				fila[5] = "Unbranded";
				fila[6] = "Unbranded";
				modelo.addRow(fila);
			}
			

		}
}
