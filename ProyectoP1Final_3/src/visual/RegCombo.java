package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class RegCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	public int [] saber = new int[4];
	public Componente q = null;
	public int cont = 0;
	private JTable table;
	private JTable table_1;
	private JButton btnQuitar;
	private JButton btnAgregar;
	
	private ArrayList<Componente>agregados = new ArrayList<Componente>();
	private JButton registrarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCombo dialog = new RegCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCombo() {
		setTitle("Registro de combo");
		setBounds(100, 100, 631, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registrar", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 96, 248, 234);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String columns[] = {"Serie","Marca","Modelo","Precio"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					table_1.clearSelection();
					int seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(true);
						btnQuitar.setEnabled(false);
						
						q = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));

					}else{
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(false);
						q = null;
					}
				}			
			});
			
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(336, 96, 248, 234);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			modelo_1 = new DefaultTableModel();
			String []columns2 = {"Serie","Marca","Modelo","Precio"};
			modelo_1.setColumnIdentifiers(columns2);
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					table.clearSelection();
					int seleccion = table_1.getSelectedRow();
					int modelrow = table_1.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(true);
						
						q = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));
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
			
			btnAgregar = new JButton(">>");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//conexiones.remove(q);
					agregados.add(q);
					cargarTabla();
					CargarTablaAgregados();
					
					if(q instanceof Disco) {
						saber[0] = 1;
					}
					if(q instanceof MotherBoard) {
						saber[1] = 1;
					}
					if(q instanceof Microprocesadores) {
						saber[2] = 1;
					}else {
						//Memoria ram
						saber[3] = 1;
					}
					cargarTablaExceptuando();
					btnAgregar.setEnabled(false);
					if(cont>=2) {
						registrarButton.setEnabled(true);
					}else {
						registrarButton.setEnabled(false);
					}
					q = null;
					
				}



				
			});
			btnAgregar.setBounds(268, 147, 58, 23);
			panel.add(btnAgregar);
			
			btnQuitar = new JButton("<<");
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cont--;
					//conexiones.add(q);
					agregados.remove(q);
					
					if(q instanceof Disco) {
						saber[0]--;
					}
					if(q instanceof MotherBoard) {
						saber[1]--;
					}
					if(q instanceof Microprocesadores) {
						saber[2]--;
					}else {
						//Memoria ram
						saber[3]--;
					}
					
					cargarTablaExceptuando();
					CargarTablaAgregados();
					
					btnQuitar.setEnabled(false);
					if(cont>=2) {
						registrarButton.setEnabled(true);
					}else {
						registrarButton.setEnabled(false);
					}
					q = null;
				}
			});
			btnQuitar.setBounds(268, 249, 58, 23);
			panel.add(btnQuitar);
			
			JLabel lblNewLabel = new JLabel("Filtro");
			lblNewLabel.setBounds(10, 71, 46, 14);
			panel.add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(66, 68, 192, 20);
			panel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				registrarButton = new JButton("Registrar");
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
	
	private void CargarTablaAgregados() {
		modelo_1.setRowCount(0);
		fila = new Object[modelo_1.getColumnCount()];
		for(Componente comp:agregados) {
			fila[0] = comp.getSerie();
			fila[1] = comp.getMarca();
			fila[2] = comp.getModelo();
			fila[3] = comp.getPrecioVenta();
			modelo_1.addRow(fila);
		}
		
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
		for(Componente comp : Prodacom.getInstance().getComponentes()){
			fila[0] = comp.getSerie();
			fila[1] = comp.getMarca();
			fila[2] = comp.getModelo();
			fila[3] = comp.getPrecioVenta();
			
			modelo.addRow(fila);
		
	}
}
	
	private void cargarTablaExceptuando() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
		if(saber[0] > 0) {
			
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof Disco)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
		}
		if(saber[1] > 0){
			
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof MotherBoard)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
			
		}
		if(saber[2] > 0) {
			
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof Microprocesadores)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
		}
		
		if(saber[3] > 0 ) {
			
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof MemoriaRam)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
		}
		
		
	}
	
}