package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logico.Combo;
import logico.Componente;
import logico.Prodacom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class Ventas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int disponibles = 1;
	private String nombre ="";
	private float precio = 0.0f;
	private JSpinner spnCantidad;
	private JSpinner spnDescuento;
	private float subtotal = 0.0f;
	private String codigo = "";
	public static Object[] fila = new Object [5];
	private JLabel lblPrecio;
	private JLabel lblSubTotal;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param i 
	 * @param f 
	 * @param string 
	 */
	public Ventas(String cod, String string, float f, int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventas.class.getResource("/iconos/se.png")));
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		this.disponibles=i;
		this.nombre=string;
		this.precio=f;
		this.codigo = cod;
		setTitle("Agregar Articulo: "+codigo);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 388, 388);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setForeground(Color.DARK_GRAY);
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setForeground(new Color(250, 250, 210));
			lblNewLabel.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/nombre.png")));
			lblNewLabel.setBounds(12, 13, 133, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel(nombre);
			lblNombre.setForeground(new Color(250, 250, 210));
			lblNombre.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/model.png")));
			lblNombre.setBackground(UIManager.getColor("Button.focus"));
			lblNombre.setBounds(12, 57, 346, 31);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_2.setForeground(new Color(250, 250, 210));
			lblNewLabel_2.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/money.png")));
			lblNewLabel_2.setBounds(12, 101, 73, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblPrecio = new JLabel(""+precio);
			lblPrecio.setForeground(new Color(250, 250, 210));
			lblPrecio.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/dollar.png")));
			lblPrecio.setBackground(UIManager.getColor("Button.focus"));
			lblPrecio.setBounds(12, 130, 346, 31);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_1.setForeground(new Color(250, 250, 210));
			lblNewLabel_1.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/iu.png")));
			lblNewLabel_1.setBounds(12, 174, 101, 16);
			contentPanel.add(lblNewLabel_1);
		}
		
		spnCantidad = new JSpinner();
		spnCantidad.setForeground(new Color(128, 0, 0));
		spnCantidad.setBackground(UIManager.getColor("Button.focus"));
		spnCantidad.addChangeListener(new ChangeListener() {
			  @Override
			  public void stateChanged(ChangeEvent e) {
			   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
			   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
			   subtotal = subtotal-(subtotal*desc);
			   lblSubTotal.setText("SubTotal: "+subtotal);
			  }
			});
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, disponibles, 1));
		spnCantidad.setBounds(12, 208, 101, 22);
		contentPanel.add(spnCantidad);
		{
			JLabel lblNewLabel_3 = new JLabel("Descuento:");
			lblNewLabel_3.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_3.setForeground(new Color(250, 250, 210));
			lblNewLabel_3.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/dinero.png")));
			lblNewLabel_3.setBounds(250, 174, 100, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			spnDescuento = new JSpinner();
			spnDescuento.setBackground(UIManager.getColor("Button.focus"));
			spnDescuento.setForeground(new Color(128, 0, 0));
			spnDescuento.addChangeListener(new ChangeListener() {
				  @Override
				  public void stateChanged(ChangeEvent e) {
				   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
				   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
				   subtotal = subtotal-(subtotal*desc);
				   lblSubTotal.setText("SubTotal: "+subtotal);
				  }
				});
			spnDescuento.setModel(new SpinnerNumberModel(0, 0, 10, 1));
			spnDescuento.setBounds(249, 208, 101, 22);
			contentPanel.add(spnDescuento);
		}
		{
			subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
			lblSubTotal = new JLabel("SubTotal: "+(subtotal-(subtotal*(Integer.parseInt(spnDescuento.getValue().toString())/100.0f))));
			lblSubTotal.setForeground(new Color(250, 250, 210));
			lblSubTotal.setBackground(UIManager.getColor("Button.focus"));
			lblSubTotal.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/money.png")));
			lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSubTotal.setBounds(12, 254, 222, 31);
			contentPanel.add(lblSubTotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.setForeground(new Color(0, 255, 0));
				okButton.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/registrer.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if('C'==codigo.charAt(0)) {
							Combo c = Prodacom.getInstance().buscarCombo(codigo);
							if(Prodacom.getInstance().ChecarCombo(c)) {
								fila[0]=codigo;
								fila[1]=nombre;
								fila[2]=Integer.parseInt(spnCantidad.getValue().toString());
								fila[3]=precio;
								fila[4]=subtotal;
								Prodacom.getInstance().VenderCombo(c);
								dispose();
								Facturacion.CargarTabla(fila);
							}else {
								JOptionPane.showMessageDialog(null, "En stock no hay items suficientes para vender el combo: "+c.getNombre()
							, "Error", JOptionPane.WARNING_MESSAGE);
								dispose();
								ListadoComponentes a = new ListadoComponentes(null, 0);
								a.setVisible(true);
							}
					
					}else {
						Componente c = Prodacom.getInstance().buscarComponente(codigo);
						fila[0]=codigo;
						fila[1]=nombre;
						fila[2]=Integer.parseInt(spnCantidad.getValue().toString());
						fila[3]=precio;
						fila[4]=subtotal;
						int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
						for(int i = 0;i<cantidad;i++) {
							Prodacom.getInstance().VenderComponente(c);
						}
						dispose();
						Facturacion.CargarTabla(fila);
					}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setIcon(new ImageIcon(Ventas.class.getResource("/iconos/cancel.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
