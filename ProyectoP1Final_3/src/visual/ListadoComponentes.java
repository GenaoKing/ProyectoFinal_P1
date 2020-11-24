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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListadoComponentes extends JDialog {
	
	private Componente auxiliar = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JButton btnEliminar;
	private JComboBox cbxFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComponentes dialog = new ListadoComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComponentes() {
		setBounds(100, 100, 813, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 34, 775, 295);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			
			modelo = new DefaultTableModel();
			String columns[] = {"Código","Tipo","Cant. en almacen","Precio Unitario","modelo","Serie","Marca"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int seleccion = table.getSelectedRow();
					if(seleccion!=-1) {
						btnEliminar.setEnabled(true);
					
						auxiliar = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(seleccion, 0));
						
					}else {
						btnEliminar.setEnabled(false);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel = new JLabel("Filtro");
			lblNewLabel.setBounds(605, 9, 50, 22);
			panel.add(lblNewLabel);
			
			cbxFiltro = new JComboBox();
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
							fila[4] = comp.getSerie();
							fila[4] = comp.getMarca();
							
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
								fila[4] = comp.getSerie();
								fila[4] = comp.getMarca();
								
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
							fila[4] = comp.getSerie();
							fila[4] = comp.getMarca();
							
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
								fila[4] = comp.getSerie();
								fila[4] = comp.getMarca();
								
								modelo.addRow(fila);
							}
						}
					}
				}

			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria Ram", "Microprocesador", "MotherBoard"}));
			cbxFiltro.setBounds(676, 9, 101, 22);
			panel.add(cbxFiltro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
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
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
			fila[4] = comp.getSerie();
			fila[4] = comp.getMarca();
			
			modelo.addRow(fila);

		}
		
	}
}
