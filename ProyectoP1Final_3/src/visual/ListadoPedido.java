package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Componente;
import logico.Disco;
import logico.MemoriaRam;
import logico.Microprocesadores;
import logico.MotherBoard;
import logico.Persona;
import logico.Prodacom;
import logico.Proveedor;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ListadoPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	public static DefaultTableModel modelo;
	public static Object[] fila;
	
	private int seleccion = -1;
	private int modelrow = -1;
	private JButton btnSeleccionar;
	
	private Componente component = null;
	private Proveedor proveedor = null;
	
	public ListadoPedido() {
		setTitle("Generar Orden de Compra");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoPedido.class.getResource("/iconos/lip.png")));
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		setBounds(100, 100, 754, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					modelo = new DefaultTableModel();
					String columns[] = {"Tipo","Cant.Mínina","Cant. Real","Cant. Máxima","Serie","modelo","Marca"};
					modelo.setColumnIdentifiers(columns);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							seleccion = table.getSelectedRow();
							modelrow = table.convertRowIndexToModel(seleccion);
								if(seleccion!=-1 ) {
									
									btnSeleccionar.setEnabled(true);
									component = Prodacom.getInstance().buscarComponente(modelo.getValueAt(seleccion, 4).toString());
									//btnSeleccionar.setEnabled(true);
								}else {
									btnSeleccionar.setEnabled(false);
									//btnEliminar.setEnabled(false);
									//btnSeleccionar.setEnabled(false);
								}
							
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.setIcon(new ImageIcon(ListadoPedido.class.getResource("/iconos/select.png")));
				btnSeleccionar.setForeground(new Color(0, 255, 0));
				btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						proveedor  = Prodacom.getInstance().buscarProveedores(component.getSerie());
						
						RegPedido a = new RegPedido(component,proveedor);
						dispose();
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
				cancelButton.setIcon(new ImageIcon(ListadoPedido.class.getResource("/iconos/cancel.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
		fila = new Object[modelo.getColumnCount()];
		for(Componente c : Prodacom.getInstance().getComponentes()){
			if(c.chequearpedido()) {
				
				if(c instanceof Disco) {
					fila[0] = "Disco Duro";
				}
				if(c instanceof MotherBoard) {
					fila[0] = "MotherBoard";
				}
				if(c instanceof Microprocesadores) {
					fila[0] = "Microprocesadores";
				}
				if(c instanceof MemoriaRam) {
					fila[0] = "Memoria Ram";
				}
			fila[1]=c.getCantMinima();
			fila[2]=c.getCantReal();
			fila[3]=c.getCantMaxima();
			fila[4]=c.getSerie();
			fila[5] = c.getModelo();
			fila[6] = c.getMarca();
			modelo.addRow(fila);
		}
		
	}
		
	}

}
