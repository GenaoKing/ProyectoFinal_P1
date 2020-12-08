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
import logico.Movimientos;
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
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class ListadoEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JButton btnSeleccionar;
	private Vendedor aux = null;
	private JTextField txtBusqueda;
	private JButton btnPagar;
	private Administrativo a = null;
	private int modelrow = -1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListadoEmpleados() {
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoEmpleados.class.getResource("/iconos/iu.png")));
		setTitle("Listado De Empleados");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 859, 462);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(184, 134, 11)));
			panel.setForeground(UIManager.getColor("Button.focus"));
			panel.setBackground(UIManager.getColor("Button.focus"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(UIManager.getColor("Button.focus"));
			panel_1.setBackground(UIManager.getColor("Button.focus"));
			panel_1.setBounds(12, 13, 807, 47);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Buscador:");
			lblNewLabel.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/iconos/busca.png")));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(12, 13, 122, 21);
			panel_1.add(lblNewLabel);
			
			txtBusqueda = new JTextField();
			txtBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtBusqueda.setForeground(new Color(0, 0, 255));
			txtBusqueda.setBackground(UIManager.getColor("Button.focus"));
			txtBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
				}
			});
			txtBusqueda.setBounds(144, 12, 157, 22);
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
					 modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1 ){
						btnPagar.setEnabled(true);
						if(modelo.getValueAt(modelrow, 1).toString().equalsIgnoreCase("Vendedor")) {
							btnSeleccionar.setEnabled(true);
							
							aux = Prodacom.getInstance().buscarVendedor((String)modelo.getValueAt(modelrow, 0));
						}else {
							btnSeleccionar.setEnabled(false);
							a = Prodacom.getInstance().BuscarAdmin((String)modelo.getValueAt(modelrow, 0));
						}
						
					}else{	
						btnSeleccionar.setEnabled(false);
						btnPagar.setEnabled(false);
						}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSeleccionar = new JButton("Ventas");
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/iconos/ventas.png")));
				btnSeleccionar.setForeground(new Color(0, 255, 0));
				btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoFacturas a = new ListadoFacturas(aux);
						a.setVisible(true);
					}
				});
				
				btnPagar = new JButton("Pagar Mes");
				btnPagar.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/iconos/dollar.png")));
				btnPagar.setForeground(new Color(124, 252, 0));
				btnPagar.setBackground(UIManager.getColor("Button.focus"));
				btnPagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(modelo.getValueAt(modelrow, 1).toString().equalsIgnoreCase("Administrativo")) {
							if(Prodacom.getInstance().getBalance()>=a.getSueldo()) {
							Prodacom.getInstance().setBalance(Prodacom.getInstance().getBalance()-a.getSueldo());
							Movimientos m = new Movimientos("Pago Salario", "R-"+Prodacom.getInstance().getCod_mov(), "Administrativo: "+a.getNombre(), 
									new Date(), a.getSueldo(), Prodacom.getInstance().getUser().getNombre(), Prodacom.getInstance().getBalance());
							Prodacom.getInstance().insertar(m);
							JOptionPane.showMessageDialog(null, "El pago se ha realizado con exito");
							}else {
								JOptionPane.showMessageDialog(null, "No hay suficiente dinero en caja, por favor deposite el dinero o espere a que se realizen ventas");
							}
						}else {
							if(Prodacom.getInstance().getBalance()>=Prodacom.getInstance().SueldoVendedor(aux)){
							Prodacom.getInstance().setBalance(Prodacom.getInstance().getBalance()-Prodacom.getInstance().SueldoVendedor(aux));
							Movimientos m = new Movimientos("Pago Salario", "R-"+Prodacom.getInstance().getCod_mov(), "Vendedor: "+aux.getNombre(), 
									new Date(), Prodacom.getInstance().SueldoVendedor(aux), Prodacom.getInstance().getUser().getNombre(), Prodacom.getInstance().getBalance());
							Prodacom.getInstance().insertar(m);
							JOptionPane.showMessageDialog(null, "El pago se ha realizado con exito");
						}else {
							JOptionPane.showMessageDialog(null, "No hay suficiente dinero en caja, por favor deposite el dinero o espere a que se realizen ventas");
						}
						}
					}
				});
				btnPagar.setEnabled(false);
				buttonPane.add(btnPagar);
				btnSeleccionar.setActionCommand("OK");
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(128, 0, 0));
				cancelButton.setIcon(new ImageIcon(ListadoEmpleados.class.getResource("/iconos/cancel.png")));
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
				fila[0]=p.getCedula();
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
