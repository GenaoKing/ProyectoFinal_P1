package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logico.Administrativo;
import logico.Persona;
import logico.Prodacom;
import logico.Vendedor;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListadoEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JButton btnSeleccionar;
	private Vendedor aux = null;
	private JTextField txtBusqueda;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListadoEmpleados() {
		setTitle("Listado De Empleados");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 859, 462);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 13, 807, 47);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Buscador:");
			lblNewLabel.setBounds(12, 13, 77, 21);
			panel_1.add(lblNewLabel);
			
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
			txtBusqueda.setBounds(87, 12, 214, 22);
			panel_1.add(txtBusqueda);
			txtBusqueda.setColumns(10);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 67, 807, 290);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String[] columns = {"Cedula","Tipo","Nombre","Telefono","Direccion","Sueldo","Comision"}; 
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1 && modelo.getValueAt(modelrow, 1).toString().equalsIgnoreCase("Vendedor")){
						btnSeleccionar.setEnabled(true);
					
						aux = Prodacom.getInstance().buscarVendedor((String)modelo.getValueAt(modelrow, 0));
						
						
					}else{	
						btnSeleccionar.setEnabled(false);
				
						}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSeleccionar = new JButton("Ventas");
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoFacturas a = new ListadoFacturas(aux);
						a.setVisible(true);
					}
				});
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.setActionCommand("OK");
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	CargarTabla();
	}

	private void CargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		for(Persona p : Prodacom.getInstance().getPersonas()) {
			if((p instanceof Vendedor) || (p instanceof Administrativo)) {
				fila[0]=p.getNombre();
				if(p instanceof Vendedor) {
					fila[1]="Vendedor";
					fila[5]=((Vendedor) p).getSueldo();
					fila[6]=((Vendedor) p).getComision()*100;
					
				}else {
					fila[1]="Administrativo";
					fila[5]=((Administrativo)p).getSueldo();
					fila[6]=0.0f;
				}
				fila[2]=p.getNombre();
				fila[3]=p.getTelefono();
				fila[4]=p.getDireccion();
				modelo.addRow(fila);
			}
		}
		
	}
}
