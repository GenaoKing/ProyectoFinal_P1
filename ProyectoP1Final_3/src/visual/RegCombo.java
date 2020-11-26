package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
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
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class RegCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	private int [] saber = new int[4];
	private Componente q = null;
	private int cont = 0;
	private int contador = 0;
	private JTable table;
	private JTable table_1;
	private JButton btnQuitar;
	private JButton btnAgregar;
	
	private ArrayList<Componente>agregados = new ArrayList<Componente>();
	private JButton registrarButton;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegCombo() {
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(new Color(70, 130, 180));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegCombo.class.getResource("/iconos/list.png")));
		setModal(true);
		setResizable(false);
		setTitle("Registro de combo");
		setBounds(100, 100, 631, 446);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(0, 128, 128));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(70, 130, 180));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new TitledBorder(null, "Registrar", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("Button.focus"));
			panel_1.setForeground(new Color(0, 128, 128));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Disponibles", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 0)));
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
			panel_2.setForeground(new Color(0, 128, 128));
			panel_2.setBackground(UIManager.getColor("Button.focus"));
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 0)));
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
			
			btnAgregar = new JButton("");
			btnAgregar.setBackground(UIManager.getColor("Button.focus"));
			btnAgregar.setForeground(new Color(0, 0, 255));
			btnAgregar.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/derecha.png")));
			btnAgregar.setEnabled(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					agregados.add(q);
					cont++;
					
					if(q instanceof Disco) {
						saber[0] = 1;
					}
					if(q instanceof MotherBoard) {
						saber[1] = 1;
					}
					if(q instanceof Microprocesadores) {
						saber[2] = 1;
					}
					if(q instanceof MemoriaRam){
						//Memoria ram
						saber[3] = 1;
					}
					CargarTablaAgregados();
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
			
			btnQuitar = new JButton("");
			btnQuitar.setForeground(new Color(0, 0, 255));
			btnQuitar.setBackground(UIManager.getColor("Button.focus"));
			btnQuitar.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/izquierda.png")));
			btnQuitar.setEnabled(false);
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cont--;
					agregados.remove(q);
					
					if(q instanceof Disco) {
						saber[0] = 0;
					}
					if(q instanceof MotherBoard) {
						saber[1]= 0;
					}
					if(q instanceof Microprocesadores) {
						saber[2]= 0;
					}
					if(q instanceof MemoriaRam){
						//Memoria ram
						saber[3]= 0;
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
			lblNewLabel.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/ll.png")));
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setForeground(new Color(184, 134, 11));
			lblNewLabel.setBounds(10, 71, 88, 14);
			panel.add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setForeground(new Color(0, 0, 255));
			comboBox.setBackground(UIManager.getColor("Button.focus"));
			comboBox.setBounds(108, 68, 150, 20);
			panel.add(comboBox);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBackground(UIManager.getColor("Button.focus"));
			lblNombre.setForeground(new Color(184, 134, 11));
			lblNombre.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/name.png")));
			lblNombre.setBounds(10, 21, 90, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setForeground(new Color(0, 0, 255));
			txtNombre.setBackground(UIManager.getColor("Button.focus"));
			txtNombre.setBounds(108, 18, 150, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCod = new JLabel("C\u00F3digo:");
			lblCod.setForeground(new Color(184, 134, 11));
			lblCod.setBackground(UIManager.getColor("Button.focus"));
			lblCod.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/code.png")));
			lblCod.setBounds(336, 21, 90, 14);
			panel.add(lblCod);
			
			txtCodigo = new JTextField();
			txtCodigo.setBackground(UIManager.getColor("Button.focus"));
			txtCodigo.setForeground(new Color(0, 0, 255));
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setText("C-"+Prodacom.cod_combos);
			txtCodigo.setBounds(436, 18, 141, 20);
			panel.add(txtCodigo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				registrarButton = new JButton("Registrar");
				registrarButton.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/registrer.png")));
				registrarButton.setBackground(new Color(0, 128, 0));
				registrarButton.setForeground(new Color(184, 134, 11));
				registrarButton.setEnabled(false);
				registrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Combo aux  =  new Combo(txtNombre.getText(), txtCodigo.getText());
						Prodacom.getInstance().insertarCombo(aux);
						for(Componente c : agregados) {
							aux.insertarcomponentes(c);
						}
						clear();
						registrarButton.setEnabled(false);
						saber = new int[4];
						contador  =0;
					}

					
				});
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(RegCombo.class.getResource("/iconos/delete.png")));
				cancelButton.setBackground(new Color(128, 0, 0));
				cancelButton.setForeground(new Color(184, 134, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		if(contador==0) {
		cargarTabla();
		}
		contador++;
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
	private void clear() {
		txtCodigo.setText("C-"+Prodacom.cod_combos);
		txtNombre.setText("");
		
		agregados.removeAll(agregados);
		cargarTabla();
		modelo_1.setRowCount(0);
		
	}
	
	private void cargarTablaExceptuando() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
			
		if(saber[0] > 0) {
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof Disco && saber[0] > 0)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
	}
			if(saber[1] > 0) {
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof MotherBoard) && saber[1] > 0) {
					
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
				if(!(comp instanceof Microprocesadores && saber[2] > 0)) {
				fila[0] = comp.getSerie();
				fila[1] = comp.getMarca();
				fila[2] = comp.getModelo();
				fila[3] = comp.getPrecioVenta();
				
				modelo.addRow(fila);
				}
		}
	}
		
			if(saber[3] > 0) {
			for(Componente comp : Prodacom.getInstance().getComponentes()){
				if(!(comp instanceof MemoriaRam && saber[3] > 0)) {
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