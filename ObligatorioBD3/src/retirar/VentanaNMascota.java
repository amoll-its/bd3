	package retirar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import logica.valueObjects.VOMascota;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaNMascota {

	JFrame frame;
	private JTextField txtCedula;
	private JTextField txtApodo;
	private JTextField txtRaza;

	/**
	 * Create the application.
	 */
	public VentanaNMascota() {
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
			
		final ControlMascotas ctlMascotas = new ControlMascotas();

		final DefaultListModel mlist = new DefaultListModel();		
		
		final JLabel lblTitulo = new JLabel("NUEVA MASCOTA");
		lblTitulo.setBounds(20,10, 200, 20);
		frame.getContentPane().add(lblTitulo);
		
		
		final JLabel lblCedula = new JLabel("Cédula Dueño:");
		lblCedula.setBounds(20, 50, 61, 15);
		frame.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 50, 100, 19);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);

		final JLabel lblApodo = new JLabel("Apodo:");
		lblApodo.setBounds(20, 90, 61, 15);
		frame.getContentPane().add(lblApodo);
		
		txtApodo = new JTextField();
		txtApodo.setBounds(90, 90, 100, 19);
		frame.getContentPane().add(txtApodo);
		txtApodo.setColumns(10);

		final JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(20, 130, 61, 15);
		frame.getContentPane().add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setBounds(90, 130, 100, 19);
		frame.getContentPane().add(txtRaza);
		txtRaza.setColumns(10);

		
		JButton btnNM = new JButton("Nueva Mascota");
		btnNM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cd = Integer.parseInt(txtCedula.getText());
				String am=txtApodo.getText();
				String rm=txtRaza.getText();
				VOMascota vom = new VOMascota(am, rm, cd);
				ctlMascotas.nuevaMascota(vom);
			}
		});
		btnNM.setBounds(200, 50, 200, 25);
		frame.getContentPane().add(btnNM);
		
	

	}
}
