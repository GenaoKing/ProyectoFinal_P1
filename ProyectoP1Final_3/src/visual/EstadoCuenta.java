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
		setTitle("Estado De Cuenta General");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1021, 632);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-90);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnDepositar = new JButton("Depositar");
					btnDepositar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							double monto = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto del retiro"));
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
		}
		
	}

}
