package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import logico.Proveedor;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListadoProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private int seleccion = -1;
	private int modelrow = -1;
	public static DefaultTableModel modelo;
	public static Object [] fila; 
	private JButton informacionButton;
	private JTextField txtFiltro;
	private Proveedor p  = null; 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListadoProveedores() {
		setModal(true);
		setResizable(false);
		setTitle("Listado Proveedores");
		setBounds(100, 100, 854, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 38, 812, 339);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					
					modelo = new DefaultTableModel();
					String columns [] = {"Código","Nombre","Teléfono","Dirección","Lim.Crédito"};
					modelo.setColumnIdentifiers(columns);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							seleccion = table.getSelectedRow();
							modelrow = table.convertRowIndexToModel(seleccion);
							if(seleccion!=-1) {
								
								informacionButton.setEnabled(true);
								
								p = Prodacom.getInstance().buscarProveedor((String)modelo.getValueAt(modelrow, 0));
								
							}else {
								informacionButton.setEnabled(false);
								
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
			
			JLabel lblNewLabel = new JLabel("Filtro:");
			lblNewLabel.setBounds(10, 13, 46, 14);
			panel.add(lblNewLabel);
			
			txtFiltro = new JTextField();
			txtFiltro.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtFiltro.getText().trim()));
				}
			});
			txtFiltro.setBounds(52, 11, 141, 20);
			panel.add(txtFiltro);
			txtFiltro.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				informacionButton = new JButton("Informaci\u00F3n");
				informacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Combo c = new Combo("Componentes que trae: "+p.getNombre(), "aux");
						for(Componente a : p.getComponentes()) {
							c.insertarcomponentes(a);
						}
						ListadoComponentes a = new ListadoComponentes(c, 0);
						a.setVisible(true);
						
		
					}
				});
				informacionButton.setEnabled(false);
				informacionButton.setActionCommand("OK");
				buttonPane.add(informacionButton);
				getRootPane().setDefaultButton(informacionButton);
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
		
		for(Proveedor provee : Prodacom.getInstance().getProveedores()){
			
				fila[0] = provee.getCodigo();
				fila[1] = provee.getNombre();
				fila[2] = provee.getTelefono();
				fila[3] = provee.getDireccion();
				fila[4] = provee.getLimCredito();
				modelo.addRow(fila);
			}
		
	}
}
