package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.Prodacom;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class Principal extends JFrame {

	private static JPanel contentPane;
	private Dimension din;
	private static JPanel panel_1;
	private static JPanel panel_3;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		this.addWindowListener(new WindowListener() {

			 @Override
			public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub			 
			}

			 @Override
			public void windowClosing(WindowEvent e) {
			try {
			File f = new File("prodacom.dat");
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(Prodacom.getInstance());
			objectOut.close();
			
			} catch (Exception ex) {
			ex.printStackTrace();
			}

			}
			 
			 
			 
			 @Override
			public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
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
		
		setTitle("PRODACOM");
		
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/iconos/tecno.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-45);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.focus"));
		menuBar.setForeground(UIManager.getColor("Button.focus"));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Facturar");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/iconos/factura.png")));
		mnNewMenu_1.setForeground(SystemColor.textHighlight);
		mnNewMenu_1.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturaci\u00F3n");
		mntmNewMenuItem_1.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_1.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/iconos/name.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion aux = new Facturacion(null);
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado Facturas");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/iconos/factu.png")));
		mntmNewMenuItem_2.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_2.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFacturas aux = new ListadoFacturas(null);
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("Componentes");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/iconos/compo.png")));
		mnNewMenu.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu.setForeground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ingreso");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/iconos/ingreso.png")));
		mntmNewMenuItem.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem.setBackground(UIManager.getColor("Button.focus"));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoComponentes a = new IngresoComponentes();
				a.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado Componente");
		mntmNewMenuItem_4.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_4.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/iconos/hu.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponentes aux = new ListadoComponentes(null,0);
				aux.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Cliente");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/iconos/user.png")));
		mnNewMenu_2.setForeground(SystemColor.textHighlight);
		mnNewMenu_2.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado Cliente");
		mntmNewMenuItem_3.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_3.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/iconos/clien.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoClientes aux = new ListadoClientes(1);
				aux.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("Combos");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu_3.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_3.setForeground(SystemColor.textHighlight);
		mnNewMenu_3.setIcon(new ImageIcon(Principal.class.getResource("/iconos/com.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Registrar Combo");
		mntmNewMenuItem_5.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_5.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_5.setIcon(new ImageIcon(Principal.class.getResource("/iconos/lip.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCombo aux = new RegCombo();
				aux.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado Combo");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Principal.class.getResource("/iconos/ju.png")));
		mntmNewMenuItem_6.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_6.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponentes aux = new ListadoComponentes(null,1);
				aux.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("Proveedor");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu_4.setIcon(new ImageIcon(Principal.class.getResource("/iconos/compras.png")));
		mnNewMenu_4.setForeground(SystemColor.textHighlight);
		mnNewMenu_4.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar Proveedor");
		mntmNewMenuItem_7.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_7.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/iconos/list.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegProveedores aux = new RegProveedores();
				aux.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado Proveedores");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Principal.class.getResource("/iconos/name.png")));
		mntmNewMenuItem_8.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_8.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProveedores aux = new ListadoProveedores();
				aux.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_5 = new JMenu("Administracion");
		mnNewMenu_5.setIcon(new ImageIcon(Principal.class.getResource("/iconos/folder-data-icon.png")));
		mnNewMenu_5.setForeground(SystemColor.textHighlight);
		mnNewMenu_5.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("Empleados");
		mnNewMenu_6.setIcon(new ImageIcon(Principal.class.getResource("/iconos/user.png")));
		mnNewMenu_6.setForeground(SystemColor.textHighlight);
		mnNewMenu_6.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_5.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar");
		mntmNewMenuItem_9.setIcon(new ImageIcon(Principal.class.getResource("/iconos/list.png")));
		mntmNewMenuItem_9.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_9.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegTrabajadores a = new RegTrabajadores();
				a.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listado");
		mntmNewMenuItem_10.setIcon(new ImageIcon(Principal.class.getResource("/iconos/name.png")));
		mntmNewMenuItem_10.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_10.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEmpleados a = new ListadoEmpleados();
				a.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_8 = new JMenu("Graficos");
		mnNewMenu_8.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Data-Meter-icon.png")));
		mnNewMenu_8.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_8.setForeground(SystemColor.textHighlight);
		mnNewMenu_5.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("pastel");
		mntmNewMenuItem_13.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Bar-Chart-icon.png")));
		mntmNewMenuItem_13.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_13.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testeo2 x = new testeo2();
				x.setVisible(true);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("barras");
		mntmNewMenuItem_14.setIcon(new ImageIcon(Principal.class.getResource("/iconos/chart-bar-chart-icon.png")));
		mntmNewMenuItem_14.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_14.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testeo aux = new testeo();
				aux.setVisible(true);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_9 = new JMenu("Cuentas y Ordenes de Compra");
		mnNewMenu_9.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Graphics-Pen-icon.png")));
		mnNewMenu_9.setForeground(SystemColor.textHighlight);
		mnNewMenu_9.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_5.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Estado de Cuentas");
		mntmNewMenuItem_15.setIcon(new ImageIcon(Principal.class.getResource("/iconos/lip.png")));
		mntmNewMenuItem_15.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_15.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_9.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Ingresar Dinero");
		mntmNewMenuItem_16.setIcon(new ImageIcon(Principal.class.getResource("/iconos/dollar.png")));
		mntmNewMenuItem_16.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_16.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_9.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Generar Orden De Compra");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPedido aux = new ListadoPedido();
				aux.setVisible(true);
			}
		});
		mntmNewMenuItem_17.setIcon(new ImageIcon(Principal.class.getResource("/iconos/compras.png")));
		mntmNewMenuItem_17.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_17.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_9.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_7 = new JMenu("Opini\u00F3n");
		mnNewMenu_7.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Notepad-Bloc-notes-2-icon.png")));
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnNewMenu_7.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_7.setForeground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Opini\u00F3n Empresa");
		mntmNewMenuItem_11.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Paper-icon.png")));
		mntmNewMenuItem_11.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_11.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Opinion x = new Opinion();
				x.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Encuesta");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficOpinion x = new GraficOpinion();
				x.setVisible(true);
				
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_12);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.focus"));
		contentPane.setBackground(UIManager.getColor("Button.focus"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(Barras3d());
		contentPane.add(panel_3);
		
		panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(crear());
		contentPane.add(panel_1);
		setLocationRelativeTo(null);
		
		cargargraficos();
		
	}
	public static void cargargraficos() {
		
		panel_3.add(Barras3d());
		panel_1.add(crear());
		panel_3.doLayout();
		panel_1.doLayout();

	}
	
	private static ChartPanel crear() {
		float total[] = new float [4];
		total = Prodacom.getInstance().CalcBeneficios_T();
	
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Disco Duro", total[0]);
        dataset.setValue("MotherBoard", total[1]);
        dataset.setValue("Microprocesadores", total[2]);
        dataset.setValue("MemoriaRam", total[3]);
 
        
        JFreeChart chart = ChartFactory.createPieChart(// char t
                
                "Porciento de ganancias por tipo.",// title                                                                     
                dataset, // data
                true, // include legend
                true, false);
        
        
        ChartPanel panel= new ChartPanel(chart);
        panel.setForeground(UIManager.getColor("Button.focus"));
        panel.setBackground(UIManager.getColor("Button.focus"));
		
		return panel;
	}
private static ChartPanel Barras3d() {
		
		String A = "Disco Duro";
        String B = "Motherboard";
        String C = "MemoriaRam";
        String D = "Microprocesador";
        
        String vel = "Ventas";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        dataset.addValue(0.0d, A, vel);
        dataset.addValue(0.0d, B, vel);
        dataset.addValue(0.0d, C, vel);
        dataset.addValue(0.0d, D, vel);
        
        
        dataset.addValue(5.0, B, vel);
        dataset.addValue(6.0, B, vel);
        dataset.addValue(10.0, B, vel);
 
        dataset.addValue(4.0, C, vel);
        dataset.addValue(2.0, C, vel);
        dataset.addValue(3.0, C, vel);
        */
        dataset.addValue(Prodacom.getInstance().getTotDisco(), A, vel);
        dataset.addValue(Prodacom.getInstance().getTotMotherboard(), B, vel);
        dataset.addValue(Prodacom.getInstance().getTotMemoriaRam(), C, vel);
        dataset.addValue(Prodacom.getInstance().getTotMicroprocesadores(), D, vel);
 		
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Grafica ventas componentes", 
                "Categoria", 
                "Vendidos", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false);
 
        ChartPanel panel = new ChartPanel(barChart);
        panel.setForeground(UIManager.getColor("Button.focus"));
        panel.setBackground(UIManager.getColor("Button.focus"));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
       // panel.setlocati;
        return panel;
	}
}
