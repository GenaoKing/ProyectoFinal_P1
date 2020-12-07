package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import logico.Factura;
import logico.Prodacom;
import logico.Proveedor;
import logico.Vendedor;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class ListadoFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private int seleccion = -1;
	private int modelrow = -1;
	public static DefaultTableModel modelo;
	public static Object [] fila;
	private JTextField txtFiltro;
	private Vendedor v = null;
	private Factura auxiliar = null;
	private JButton informacionButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param aux 
	 */
	public ListadoFacturas(Vendedor aux) {
		this.v=aux;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoFacturas.class.getResource("/iconos/factura.png")));
		setTitle("Listado de Facturas\r\n");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 854, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Button.focus"));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new LineBorder(new Color(0, 255, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 39, 812, 338);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					
					modelo = new DefaultTableModel();
					String columns[] = {"Código","Cliente","Vendedor","Total","Fecha","Cant.Artículos"};
					modelo.setColumnIdentifiers(columns);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							seleccion = table.getSelectedRow();
							modelrow = table.convertRowIndexToModel(seleccion);
							if(seleccion!=-1) {
							
								informacionButton.setEnabled(true);
								auxiliar = Prodacom.getInstance().buscarFactura((String)modelo.getValueAt(modelrow, 0));
								
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
			{
				JLabel lblNewLabel = new JLabel("Filtro:");
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
				lblNewLabel.setIcon(new ImageIcon(ListadoFacturas.class.getResource("/iconos/ll.png")));
				lblNewLabel.setBounds(10, 14, 63, 14);
				panel.add(lblNewLabel);
			}
			{
				txtFiltro = new JTextField();
				txtFiltro.setBackground(UIManager.getColor("Button.focus"));
				txtFiltro.setForeground(new Color(128, 0, 0));
				txtFiltro.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						DefaultTableModel mode = (DefaultTableModel)table.getModel();
						TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
						table.setRowSorter(tr);
						tr.setRowFilter(RowFilter.regexFilter(txtFiltro.getText().trim()));
					}
				});
				txtFiltro.setBounds(83, 11, 176, 20);
				panel.add(txtFiltro);
				txtFiltro.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				informacionButton = new JButton("Informacion");
				informacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Facturacion a = new Facturacion(auxiliar);
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
				cancelButton.setIcon(new ImageIcon(ListadoFacturas.class.getResource("/iconos/cancel.png")));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(102, 0, 0));
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
		
		if(v==null) {
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Factura fact : Prodacom.getInstance().getFacturas()){
				
					fila[0] = fact.getCod();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getTotal();
					fila[4] = fact.getFecha();
					fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				}
		}else {
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Factura fact : Prodacom.getInstance().getFacturas()){
				if(fact.getVendedor().equals(v)) {
					fila[0] = fact.getCod();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getTotal();
					fila[4] = fact.getFecha();
					fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				}
				}
		}
	}

}
