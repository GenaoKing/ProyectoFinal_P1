package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension din;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					fondito d = new fondito ("/visual/ty.jpg");
					frame.getContentPane().add(d);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("PRODACOM");
		
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Desktop\\Motherboard-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-45);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Componentes");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\Home-Server-icon.png"));
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ingreso");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\Paper-icon.png"));
		mntmNewMenuItem.setForeground(Color.BLUE);
		mntmNewMenuItem.setBackground(Color.WHITE);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoComponentes a = new IngresoComponentes();
				a.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturacion");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion a = new Facturacion();
				a.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.windowBorder);
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
	}

}
