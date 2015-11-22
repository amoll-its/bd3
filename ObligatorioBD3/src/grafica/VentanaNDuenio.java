	package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
	
import logica.valueObjects.VODueño;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaNDuenio {

	JFrame frame;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;

	/**
	 * Create the application.
	 */
	public VentanaNDuenio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(400, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		final ControlDueños ctlDueños = new ControlDueños();

		final DefaultListModel mlist = new DefaultListModel();		
		
		final JLabel lblTitulo = new JLabel("NUEVO DUEÑO");
		lblTitulo.setBounds(20,10, 200, 20);
		frame.getContentPane().add(lblTitulo);
		
		
		final JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(20, 50, 61, 15);
		frame.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 50, 100, 19);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);

		final JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 90, 61, 15);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 90, 100, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		final JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 130, 61, 15);
		frame.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(90, 130, 100, 19);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		
		JButton btnND = new JButton("Nuevo Dueño");
		btnND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cd = Integer.parseInt(txtCedula.getText());
				String nd=txtNombre.getText();
				String ad=txtApellido.getText();
				VODueño vod = new VODueño(cd, nd, ad);
				ctlDueños.nuevoDueño(vod);
			}
		});
		btnND.setBounds(200, 50, 200, 25);
		frame.getContentPane().add(btnND);
		
	

	}
}
