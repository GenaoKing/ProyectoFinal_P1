package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Movimientos;
import logico.Prodacom;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class EstadoCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private Dimension din;
	private JButton btnRetirar;
	private JButton btnDepositar;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public EstadoCuenta() {
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(EstadoCuenta.class.getResource("/iconos/iu.png")));
		setTitle("Estado De Cuenta General");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1021, 632);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-90);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				
				modelo = new DefaultTableModel();
				String columns[] = {"Codigo","Transaccion","Fecha","Monto","Descripcion","Usuario","Balance"};
				modelo.setColumnIdentifiers(columns);
				table = new JTable();
				table.setFont(new Font("Arial", Font.PLAIN, 15));
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(EstadoCuenta.class.getResource("/iconos/cancel.png")));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnDepositar = new JButton("Depositar");
					btnDepositar.setIcon(new ImageIcon(EstadoCuenta.class.getResource("/iconos/dinero.png")));
					btnDepositar.setForeground(new Color(0, 255, 0));
					btnDepositar.setBackground(UIManager.getColor("Button.focus"));
					btnDepositar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							double monto = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto del deposito"));
							if(monto<=0) {
								JOptionPane.showMessageDialog(null, "Maldito mongolo a quien se le ocurre hacer un deposito de 0? o negativo");
							}else {
								Prodacom.getInstance().Deposito(monto);
								JOptionPane.showMessageDialog(null, "El deposito ha sido un exito");
							}
						}
					});
					buttonPane.add(btnDepositar);
				}
				{
					btnRetirar = new JButton("Retirar");
					btnRetirar.setIcon(new ImageIcon(EstadoCuenta.class.getResource("/iconos/dollar.png")));
					btnRetirar.setForeground(new Color(128, 0, 0));
					btnRetirar.setBackground(UIManager.getColor("Button.focus"));
					btnRetirar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							double monto = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto del retiro"));
							if(Prodacom.getInstance().Retiro(monto)) {
								JOptionPane.showMessageDialog(null, "El retiro ha sido un exito");
							}else {
								JOptionPane.showMessageDialog(null, "El retiro no se pudo completar, confirma que el monto sea inferior al actual en caja","ERROR",JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					buttonPane.add(btnRetirar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		CargarTabla();
	}

	public static void CargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(Movimientos m : Prodacom.getInstance().getMovimientos()) {
			fila[0]=m.getCod();
			fila[1]=m.getTransaccion();
			Calendar inicio=new GregorianCalendar();
			inicio.setTime(m.getFecha());
			fila[2]=(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
			fila[3]=m.getMonto();
			fila[4]=m.getDescripcion();
			fila[5]=m.getUsuario();
			fila[6]=m.getBalance();
			modelo.addRow(fila);
		}
		
	}

}
