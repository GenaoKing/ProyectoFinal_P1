package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.ui.Window;

import javafx.scene.text.Font;
import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Disco;
import logico.Factura;
import logico.MemoriaRam;
import logico.Microprocesadores;
import logico.MotherBoard;
import logico.Persona;
import logico.Prodacom;
import logico.Vendedor;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.DecimalFormat;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private static JButton btnCredito;
	private JButton btnListarComponentes;
	private Dimension din;
	private static JButton btnSeleccionarCliente;
	private static JLabel lblNombre;
	private static JLabel lblCedula;
	private static JLabel lblTelefono;
	private static JLabel lblDireccion;
	private static JLabel lblLimiteCredito;
	private static JLabel lblCreditoDisponible;
	private static JLabel lblCodigo;
	private static JLabel lblFecha;
	private static JComboBox cbxVendedores;
	private static JLabel lblVendedor;
	private static Combo combo = null;
	private static Componente componente = null;
	private static ArrayList<Combo>combos = new ArrayList<Combo>(); 
	private static ArrayList<Componente>componentes = new ArrayList<Componente>(); 
	private static int cantidad = 0;
	public static DefaultTableModel modelo;
	public static Object[] fila =new Object [5];
	private int seleccion = -1;
	private static JLabel lblSubTotal;
	private static JLabel lblImpuestos;
	private static JLabel lblTotal;
	private static float subtotal = 0;
	private static Cliente cliente = null;
	private static JButton btnPagar;

	private static Factura auxiliar = null;

	
	public Facturacion(Factura q) {
		this.auxiliar=q;
		
		this.addWindowListener(new WindowListener() {
		
			@Override
			public void windowClosed(WindowEvent e) {
			
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				if(auxiliar==null) {
				for(int i=0;i<modelo.getRowCount();i++) {
					if('C'==((String)modelo.getValueAt(i, 0)).charAt(0)) {
						Combo c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(i, 0));
						Prodacom.getInstance().DevolverCombo(c);
					}else {
						Componente c = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(i, 0));
						Prodacom.getInstance().SumarComponente(c, (int)modelo.getValueAt(i, 2));
					}
				}
				}
				clear();
				cliente = null;
				dispose();
			
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1057, 716);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setForeground(new Color(184, 134, 11));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		din = getToolkit().getScreenSize();  
		//super.setSize(1054,din.height-45);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(0, 128, 128));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new LineBorder(Color.DARK_GRAY));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.RED);
			panel_2.setBackground(UIManager.getColor("Button.focus"));
			panel_2.setBorder(new LineBorder(Color.DARK_GRAY));
			panel_2.setBounds(12, 6, 1002, 239);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			lblNombre = new JLabel("");
			lblNombre.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblNombre.setBounds(12, 23, 345, 31);
			panel_2.add(lblNombre);
			
			lblCedula = new JLabel("");
			lblCedula.setBackground(UIManager.getColor("Button.focus"));
			lblCedula.setForeground(new Color(0, 0, 128));
			lblCedula.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblCedula.setBounds(12, 77, 345, 31);
			panel_2.add(lblCedula);
			
			lblTelefono = new JLabel("");
			lblTelefono.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblTelefono.setBounds(12, 131, 345, 31);
			panel_2.add(lblTelefono);
			
			lblDireccion = new JLabel("");
			lblDireccion.setBackground(UIManager.getColor("Button.focus"));
			lblDireccion.setForeground(SystemColor.textHighlight);
			lblDireccion.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblDireccion.setBounds(12, 185, 501, 31);
			panel_2.add(lblDireccion);
			
			lblLimiteCredito = new JLabel("");
			lblLimiteCredito.setBackground(UIManager.getColor("Button.focus"));
			lblLimiteCredito.setForeground(SystemColor.textHighlight);
			lblLimiteCredito.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblLimiteCredito.setBounds(422, 23, 285, 31);
			panel_2.add(lblLimiteCredito);
			
			lblCreditoDisponible = new JLabel("");
			lblCreditoDisponible.setBackground(UIManager.getColor("Button.focus"));
			lblCreditoDisponible.setForeground(SystemColor.textHighlight);
			lblCreditoDisponible.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblCreditoDisponible.setBounds(423, 115, 272, 31);
			panel_2.add(lblCreditoDisponible);
			
			lblCodigo = new JLabel("Factura #"+Prodacom.getInstance().getInstance().getCod_facturas());
			lblCodigo.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/factura.png")));
			lblCodigo.setBackground(UIManager.getColor("Button.focus"));
			lblCodigo.setForeground(SystemColor.textHighlight);
			lblCodigo.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblCodigo.setBounds(752, 23, 234, 31);
			panel_2.add(lblCodigo);
			
			lblFecha = new JLabel("");
			Calendar inicio=new GregorianCalendar();
			inicio.setTime(new Date());
			lblFecha.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
			lblFecha.setBackground(UIManager.getColor("Button.focus"));
			lblFecha.setForeground(SystemColor.textHighlight);
			lblFecha.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblFecha.setBounds(758, 115, 228, 31);
			panel_2.add(lblFecha);
			
		
			cbxVendedores = new JComboBox(Prodacom.getInstance().NombresVendedores().toArray());
			if(auxiliar!=null) {
				cbxVendedores.setVisible(false);
			}else {
				cbxVendedores.setVisible(true);
			}
			cbxVendedores.setBackground(UIManager.getColor("Button.focus"));
			cbxVendedores.setForeground(SystemColor.textHighlight);
			cbxVendedores.setBounds(764, 185, 222, 31);
			panel_2.add(cbxVendedores);
			
			btnSeleccionarCliente = new JButton("Seleccionar Cliente");
			if(auxiliar!=null) {
				btnSeleccionarCliente.setVisible(false);
			}else {
				btnSeleccionarCliente.setVisible(true);
			}
			btnSeleccionarCliente.setBackground(UIManager.getColor("Button.focus"));
			btnSeleccionarCliente.setForeground(new Color(184, 134, 11));
			btnSeleccionarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegCliente a = new RegCliente();
					a.setVisible(true);
				}
			});
			btnSeleccionarCliente.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			btnSeleccionarCliente.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnAgregarClienteIcono.png")));
			btnSeleccionarCliente.setBounds(22, 23, 446, 180);
			panel_2.add(btnSeleccionarCliente);
			
			lblVendedor = new JLabel("Vendedor:");
			lblVendedor.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/user.png")));
			lblVendedor.setForeground(SystemColor.textHighlight);
			lblVendedor.setBackground(UIManager.getColor("Button.focus"));
			lblVendedor.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblVendedor.setBounds(523, 185, 222, 31);
			panel_2.add(lblVendedor);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.RED);
			panel_1.setBackground(UIManager.getColor("Button.focus"));
			panel_1.setBorder(new LineBorder(new Color(128, 0, 0)));
			panel_1.setBounds(12, 244, 1002, 211);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String[] columns = {"Codigo","Articulo","Cantidad","Precio","Importe"}; 
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			if(auxiliar!=null) {
				table.setRowSelectionAllowed(false);
			}else {
				table.setRowSelectionAllowed(true);
			}
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					botones();
					if(seleccion!=-1){
						if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
							btnListarComponentes.setEnabled(true);
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(false);
							componente = null;
							combo = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(modelrow, 0));
							cantidad = Integer.parseInt((String)modelo.getValueAt(modelrow, 2));
						}else {
							btnListarComponentes.setEnabled(false);
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);
							componente = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(modelrow, 0));
							System.out.println(seleccion+"||"+modelrow);
							cantidad = (int)modelo.getValueAt(seleccion, 2);
							combo = null;
						}
						
					}else{	
						btnListarComponentes.setEnabled(false);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.RED);
			panel_3.setBorder(new LineBorder(new Color(184, 134, 11), 3, true));
			panel_3.setBackground(UIManager.getColor("Button.focus"));
			panel_3.setBounds(12, 459, 1002, 157);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			btnAgregar = new JButton("Agregar Articulo");
			if(auxiliar!=null) {
				btnAgregar.setVisible(false);
			}else {
				btnAgregar.setVisible(true);
			}
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoComponentes a = new ListadoComponentes(null,0);
					a.setVisible(true);
				}
			});
			btnAgregar.setForeground(new Color(184, 134, 11));
			btnAgregar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnAgregarIcono.png")));
			btnAgregar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 22));
			btnAgregar.setBackground(new Color(50, 205, 50));
			btnAgregar.setBounds(385, 13, 271, 124);
			panel_3.add(btnAgregar);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			if(auxiliar!=null) {
				btnModificar.setVisible(false);
			}else {
				btnModificar.setVisible(true);
			}
			btnModificar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnModificar.setBackground(new Color(184, 134, 11));
			btnModificar.setForeground(Color.BLACK);
			btnModificar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnModificarIcono.png")));
			btnModificar.setBounds(12, 14, 158, 52);
			panel_3.add(btnModificar);
			
			btnEliminar = new JButton("Eliminar");
			if(auxiliar!=null) {
				btnEliminar.setVisible(false);
			}else {
				btnEliminar.setVisible(true);
			}
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(combo!=null) {
						combos.remove(combo);
						combo = null;
					}else {
						componentes.remove(componente);
						Prodacom.getInstance().SumarComponente(componente,cantidad);
						componente = null;
					}
					modelo.removeRow(seleccion);
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
					botones();
					CargarTotal();
					seleccion = -1;
				}

			});
			btnEliminar.setEnabled(false);
			btnEliminar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnEliminarIcono.png")));
			btnEliminar.setForeground(Color.BLACK);
			btnEliminar.setBackground(new Color(128, 0, 0));
			btnEliminar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnEliminar.setBounds(198, 15, 158, 52);
			panel_3.add(btnEliminar);
			
			btnListarComponentes = new JButton("Listar Componentes Combo");
			if(auxiliar!=null) {
				btnListarComponentes.setVisible(false);
			}else {
				btnListarComponentes.setVisible(true);
			}
			btnListarComponentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			btnListarComponentes.setEnabled(false);
			btnListarComponentes.setBackground(new Color(0, 128, 128));
			btnListarComponentes.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/btnListarComponentes.png")));
			btnListarComponentes.setForeground(new Color(0, 128, 0));
			btnListarComponentes.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnListarComponentes.setBounds(12, 85, 344, 52);
			panel_3.add(btnListarComponentes);
			
			lblSubTotal = new JLabel("SubTotal:");
			lblSubTotal.setForeground(Color.BLUE);
			lblSubTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblSubTotal.setBounds(668, 14, 322, 33);
			panel_3.add(lblSubTotal);
			
			lblImpuestos = new JLabel("ITBIS (18%):");
			lblImpuestos.setForeground(Color.BLUE);
			lblImpuestos.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblImpuestos.setBounds(668, 61, 322, 33);
			panel_3.add(lblImpuestos);
			
			lblTotal = new JLabel("Total:");
			lblTotal.setForeground(Color.BLUE);
			lblTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblTotal.setBounds(668, 108, 322, 33);
			panel_3.add(lblTotal);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnCredito = new JButton("Pagar A Credito");
			btnCredito.setEnabled(false);
			btnCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int ok = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la factura");
					
					if(cliente !=null && ok==JOptionPane.OK_OPTION) {
						float pago = Prodacom.getInstance().CreditCliente(cliente);
						if(pago>=(subtotal+(subtotal*0.18f))) {
							int end = cbxVendedores.getSelectedItem().toString().indexOf("|");
							Vendedor v = Prodacom.getInstance().buscarVendedor(cbxVendedores.getSelectedItem().toString().substring(0, end));
							Factura f = new Factura("F-"+Prodacom.getInstance().getCod_facturas(), subtotal+(subtotal*0.18f), cliente, v, true,modelo.getRowCount());
							
							for(int i= 0;i<modelo.getRowCount();i++) {
								fila[0]=modelo.getValueAt(i, 0).toString();
								fila[1]=modelo.getValueAt(i, 1).toString();
								fila[2]=Integer.parseInt(modelo.getValueAt(i, 2).toString());
								fila[3]=Float.parseFloat(modelo.getValueAt(i, 3).toString());
								fila[4]=Float.parseFloat(modelo.getValueAt(i, 4).toString());
								System.out.println(modelo.getValueAt(i, 0).toString());
								f.InsertarFilas(i,fila);
							
							}
							
							for(Combo c : combos) {
								f.InsertarCombos(c);
							}
							for(Componente c : componentes) {
								f.InsertarComponente(c);
							}
							
							try {
								GenerarFactura(f);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							Prodacom.getInstance().insertarFactura(f);
							JOptionPane.showMessageDialog(null, "El credito restante para el cliente es de: "+(pago-(subtotal+(subtotal*0.18f))));
							btnCredito.setEnabled(false);
							
							clear();
						}else {
							JOptionPane.showMessageDialog(null, "Su credito disponible no es suficiente para pagar el total de: "+(subtotal+(subtotal*0.18f)));
							btnCredito.setEnabled(true);
						}
					}
				}
			});
			btnCredito.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/bille.png")));
			btnCredito.setBackground(UIManager.getColor("Button.focus"));
			btnCredito.setForeground(SystemColor.textHighlight);
			buttonPane.add(btnCredito);
			{
				btnPagar = new JButton("Pagar Ahora");
				btnPagar.setEnabled(false);
				btnPagar.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/money.png")));
				btnPagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int ok = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la factura");
						
						if(cliente !=null && ok==JOptionPane.OK_OPTION) {
							float pago = Float.parseFloat(JOptionPane.showInputDialog("Digite el monto del pago"));
							if(pago>=(subtotal+(subtotal*0.18f))) {
								int end = cbxVendedores.getSelectedItem().toString().indexOf("|");
								Vendedor v = Prodacom.getInstance().buscarVendedor(cbxVendedores.getSelectedItem().toString().substring(0, end));
								Factura f = new Factura("F-"+Prodacom.getInstance().getCod_facturas(), subtotal+(subtotal*0.18f), cliente, v, false,modelo.getRowCount());
								
								for(int i= 0;i<modelo.getRowCount();i++) {
									fila[0]=modelo.getValueAt(i, 0).toString();
									fila[1]=modelo.getValueAt(i, 1).toString();
									fila[2]=Integer.parseInt(modelo.getValueAt(i, 2).toString());
									fila[3]=Float.parseFloat(modelo.getValueAt(i, 3).toString());
									fila[4]=Float.parseFloat(modelo.getValueAt(i, 4).toString());
									System.out.println(modelo.getValueAt(i, 0).toString());
									f.InsertarFilas(i,fila);
								
								}
								
								for(Combo c : combos) {
									f.InsertarCombos(c);
									
								}
								for(Componente c : componentes) {
									f.InsertarComponente(c);
									
								}
								
								try {
									GenerarFactura(f);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Prodacom.getInstance().insertarFactura(f);
								
								JOptionPane.showMessageDialog(null, "Su devuelta es: "+(pago-(subtotal+(subtotal*0.18f))));
								btnPagar.setEnabled(false);
								
								clear();
							}else {
								JOptionPane.showMessageDialog(null, "Ha ingresado una cantidad inferior a la requerida, procure que pase de: "+(subtotal+(subtotal*0.18f)));
								btnPagar.setEnabled(true);
							}
						}
					}

			
				});
				btnPagar.setBackground(UIManager.getColor("Button.focus"));
				btnPagar.setForeground(new Color(0, 255, 0));
				btnPagar.setActionCommand("OK");
				buttonPane.add(btnPagar);
				getRootPane().setDefaultButton(btnPagar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(Facturacion.class.getResource("/iconos/delete.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<modelo.getRowCount();i++) {
							if('C'==((String)modelo.getValueAt(i, 0)).charAt(0)) {
								Combo c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(i, 0));
								Prodacom.getInstance().DevolverCombo(c);
							}else {
								Componente c = Prodacom.getInstance().buscarComponente((String)modelo.getValueAt(i, 0));
								Prodacom.getInstance().SumarComponente(c, (int)modelo.getValueAt(i, 2));
							}
						}
						cliente = null;
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(auxiliar!=null) {
		
			cargarfactura();
		}
	}

	
	private void clear() {
		btnSeleccionarCliente.setVisible(true);
		lblNombre.setText("");
		lblCedula.setText("");
		lblDireccion.setText("");
		lblTelefono.setText("");
		lblCreditoDisponible.setText("");
		lblLimiteCredito.setText("");
		modelo.setRowCount(0);
		cliente=null;
		combos.clear();//

		componentes.clear();//
		componente=null;
		combo=null;
		lblCodigo.setText("Factura #"+Prodacom.getInstance().getCod_facturas());	
		Calendar inicio=new GregorianCalendar();
		inicio.setTime(new Date());
		lblFecha.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
		lblSubTotal.setText("Sub-Total: 0.0");
		lblImpuestos.setText("ITBIS (18%): 0.0");
		lblTotal.setText("Total: 0.0");
		
	}		
	
	
	
	public static void CargarCliente(Cliente c) {
		cliente  = c;
		lblNombre.setText(c.getNombre());
		lblCedula.setText(c.getCedula());
		lblDireccion.setText(c.getDireccion());
		lblTelefono.setText(c.getTelefono());
		lblCreditoDisponible.setText("Credito Disponible: "+Prodacom.getInstance().CreditCliente(c));
		lblLimiteCredito.setText("Limite de Credito: "+c.getCredito());
		btnSeleccionarCliente.setVisible(false);
		botones();
		
	}
	
	public static void CargarTabla(Object[] fila) {
		
		if('C'==fila[0].toString().charAt(0)) {
			for(int i = 0;i<(int)fila[2];i++) {
				Combo c = Prodacom.getInstance().buscarCombo(fila[0].toString());
				combos.add(c);
			}
		
		}else {
			for(int i = 0;i<(int)fila[2];i++) {
				Componente c = Prodacom.getInstance().buscarComponente(fila[0].toString());
				componentes.add(c);
			}
		}
		
		
		modelo.addRow(fila);
		botones();
		
		CargarTotal();
	}

	private static void CargarTotal() {
		subtotal = 0;
		for(int i = 0;i<table.getRowCount();i++) {
			subtotal+=(float)modelo.getValueAt(i, 4);
		}
		DecimalFormat formato1 = new DecimalFormat("#.00");
		lblSubTotal.setText("Sub-Total: "+formato1.format(subtotal));
		lblImpuestos.setText("ITBIS (18%): "+formato1.format((subtotal*0.18f)));
		lblTotal.setText("Total: "+formato1.format((subtotal+(subtotal*0.18f))));
		botones();
	
	}
	
	private static void botones() {
		if(modelo.getRowCount()>0 && cliente!=null) {
			btnPagar.setEnabled(true);
			btnCredito.setEnabled(true);
			}else {
				btnCredito.setEnabled(false);
				btnPagar.setEnabled(false);
			}
	}

private void GenerarFactura(Factura f) throws IOException {
		
		DecimalFormat formato1 = new DecimalFormat("#.00");
		Calendar inicio=new GregorianCalendar();
		inicio.setTime(f.getFecha());
		try {
			File carpeta = new File("facturas");
			if(!carpeta.isDirectory()) {
				carpeta.mkdir();
			}
			
			File fichero = new File("facturas","Factura-"+Prodacom.getInstance().getCod_facturas()+".txt");
			FileOutputStream fos = new FileOutputStream(fichero);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write(String.format("%-50s %-50s",("Cliente: "+f.getCliente().getNombre()),f.getCod()));
			bw.newLine();
			bw.write(String.format("%-50s %-50s",("Cedula: "+f.getCliente().getCedula()),"Fecha: "+inicio.get(Calendar
					.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR)));
			bw.newLine();
			
			bw.write(String.format("%-50s %-50s",("Telefono: "+f.getCliente().getTelefono()),"Vendedor: "+f.getVendedor().getNombre()));
			bw.newLine();
			if(f.isEstado()) {
				inicio.add(Calendar.DAY_OF_YEAR, ((Cliente)f.getCliente()).getDiasCredito());
				bw.write(String.format("%-50s %-50s",("Direccion: "+f.getCliente().getDireccion()),"Vence: "
						+inicio.get(Calendar
								.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR)));// 
			
			}else {
				bw.write(String.format("%-50s %-50s",("Direccion: "+f.getCliente().getDireccion()),"Vence: Pago al contado"));
			}
			bw.newLine();
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write(String.format("%-20s %-20s %-20s %-20s %-20s","Codigo","Articulo","Cantidad","Precio","Importe"));//10,7,7,
			bw.newLine();
			for(int i = 0;i<modelo.getRowCount();i++) {
				String codigo = (String)modelo.getValueAt(i, 0); 
				String nombre =(String)modelo.getValueAt(i, 1); 
				int cantidad = (int)modelo.getValueAt(i, 2); 
				float precio = (float)modelo.getValueAt(i, 3);
				float importe = (float)modelo.getValueAt(i, 4); 
				if(nombre.length()<=20) {
				bw.write(String.format("%-20s %-20s %-20s %-20s %-20s",codigo,nombre,cantidad,precio,importe));
				
				bw.newLine();
				}else {
					bw.write(String.format("%-20s %-20s %-20s %-20s %-20s",codigo, nombre.substring(0, 20),cantidad,precio,importe));
					bw.newLine();
				}
			}
			bw.write("Sub-Total: "+formato1.format((f.getTotal()/1.18f)));
			bw.newLine();
			bw.write("ITBIS 18%: "+formato1.format((f.getTotal()/1.18f)*0.18));
			bw.newLine();
			bw.write("Total: "+formato1.format(f.getTotal()));
			bw.newLine();
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write("Gracias por preferirnos, recuerde que no aceptamos devoluciones");
			bw.newLine();
			bw.close();
			fos.close();
}catch (IOException e) {
	JOptionPane.showMessageDialog(null, "Ha ocurrido un error por favor compruebe que la carpeta -facturas- se encuentra creada en la ruta del programa");
}
		
	}


private void cargarfactura() {
	if(auxiliar!=null) {
	btnSeleccionarCliente.setVisible(false);
	cbxVendedores.setVisible(false);
	btnCredito.setVisible(false);
	btnPagar.setVisible(false);
	lblCedula.setText("Cedula: "+auxiliar.getCliente().getCedula());
	lblNombre.setText("Nombre: "+auxiliar.getCliente().getNombre());
	lblTelefono.setText("Telefono: "+auxiliar.getCliente().getTelefono());
	lblDireccion.setText("Direccion: "+auxiliar.getCliente().getDireccion());
	lblVendedor.setText("Vendedor: "+auxiliar.getVendedor().getNombre());
	lblCodigo.setText("Factura #"+auxiliar.getCod().subSequence(2, auxiliar.getCod().length()));
	Calendar inicio=new GregorianCalendar();
	inicio.setTime(auxiliar.getFecha());
	lblFecha.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
	modelo.setRowCount(0);
	Object [][]filas=auxiliar.getFilas();
	for(int i = 0;i<auxiliar.getCantidad();i++) {
		int j =0;
		for(j=0;j<5;j++) {
			fila[j]=filas[i][j];
		}
		
		modelo.addRow(fila);
	}
	DecimalFormat formato1 = new DecimalFormat("#.00");
	lblSubTotal.setText("Sub-Total: "+formato1.format(auxiliar.getTotal()/1.18f));
	lblImpuestos.setText("ITBIS (18%): "+formato1.format((auxiliar.getTotal()/1.18f)*0.18f));
	lblTotal.setText("Total: "+formato1.format(auxiliar.getTotal()));
	}
}	
}
