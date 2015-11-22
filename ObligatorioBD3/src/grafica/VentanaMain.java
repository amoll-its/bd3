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

public class VentanaMain {

	JFrame frame;
	private JTextField txtCedula;

	/**
	 * Create the application.
	 */
	public VentanaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 100, 300, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lblTitulo = new JLabel("CERTAMEN DE MASCOTAS");
		lblTitulo.setBounds(20,10, 200, 20);
		frame.getContentPane().add(lblTitulo);

		JButton btnND = new JButton("Nuevo dueño");
		btnND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaNDuenio window = new VentanaNDuenio();
				window.frame.setVisible(true);
								
			}
		});
		btnND.setBounds(20, 50, 200, 25);
		frame.getContentPane().add(btnND);

		JButton btnNM = new JButton("Nueva mascota");
		btnNM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNM.setBounds(20, 95, 200, 25);
		frame.getContentPane().add(btnNM);

		JButton btnLD = new JButton("Listar dueños");
		btnLD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLDuenios window = new VentanaLDuenios();
				window.frame.setVisible(true);
			}
		});
		btnLD.setBounds(20, 140, 200, 25);
		frame.getContentPane().add(btnLD);

		JButton btnLM = new JButton("Listar mascotas");
		btnLM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLMascotas window = new VentanaLMascotas();
				window.frame.setVisible(true);
				
			}
		});
		btnLM.setBounds(20, 185, 200, 25);
		frame.getContentPane().add(btnLM);

		JButton btnBDM = new JButton("Borrar dueño/mascotas");
		btnBDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnBDM.setBounds(20, 230, 200, 25);
		frame.getContentPane().add(btnBDM);
		
	}
}
