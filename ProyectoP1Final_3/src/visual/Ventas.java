package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(12, 13, 101, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel(nombre);
			lblNombre.setBackground(Color.WHITE);
			lblNombre.setBounds(12, 57, 346, 31);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBounds(12, 101, 56, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblPrecio = new JLabel(""+precio);
			lblPrecio.setBackground(Color.WHITE);
			lblPrecio.setBounds(12, 130, 346, 31);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setBounds(12, 174, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		
		spnCantidad = new JSpinner();
		spnCantidad.addChangeListener(new ChangeListener() {
			  @Override
			  public void stateChanged(ChangeEvent e) {
			   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
			   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
			   System.out.println("Descuento: "+desc);
			   subtotal = subtotal-(subtotal*desc);
			   lblSubTotal.setText("SubTotal: "+subtotal);
			  }
			});
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, disponibles, 1));
		spnCantidad.setBounds(12, 208, 101, 22);
		contentPanel.add(spnCantidad);
		{
			JLabel lblNewLabel_3 = new JLabel("Descuento:");
			lblNewLabel_3.setBounds(250, 174, 73, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			spnDescuento = new JSpinner();
			spnDescuento.addChangeListener(new ChangeListener() {
				  @Override
				  public void stateChanged(ChangeEvent e) {
				   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
				   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
				   System.out.println("Descuento: "+desc);
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
			lblSubTotal = new JLabel("Subtotal: "+(subtotal-(subtotal*(Integer.parseInt(spnDescuento.getValue().toString())/100.0f))));
			lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSubTotal.setBounds(12, 254, 222, 31);
			contentPanel.add(lblSubTotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fila[0]=codigo;
						fila[1]=nombre;
						fila[2]=spnCantidad.getValue().toString();
						fila[3]=precio;
						fila[4]=subtotal;
						dispose();
						Facturacion.CargarTabla(fila);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
