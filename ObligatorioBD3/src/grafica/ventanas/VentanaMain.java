package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class VentanaMain {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMain window = new VentanaMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.setBounds(100, 100, 450, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnListarDueos = new JButton("Listar Dueños");
		btnListarDueos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaListarDueños vld = new VentanaListarDueños();
				vld.frame.setVisible(true);
			}
		});
		btnListarDueos.setBounds(10, 11, 414, 33);
		
		frame.getContentPane().add(btnListarDueos);
		
		JButton btnListarMascotas = new JButton("Listar Mascotas");
		
		btnListarMascotas.setBounds(10, 55, 414, 33);
		btnListarMascotas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaListarMascotas vlm = new VentanaListarMascotas();
				vlm.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnListarMascotas);
		
		JButton btnNuevoDueo = new JButton("Nuevo Dueño");
		btnNuevoDueo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaNuevoDueño vnd = new VentanaNuevoDueño();
				vnd.frmIngresarNuevoDueo.setVisible(true);
			}
		});
		btnNuevoDueo.setBounds(10, 99, 414, 33);
		frame.getContentPane().add(btnNuevoDueo);
		
		JButton btnNuevaMascota = new JButton("Nueva Mascota");
		btnNuevaMascota.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaNuevaMascota vnm = new VentanaNuevaMascota();
				vnm.frmIngresarNuevaMascota.setVisible(true);
			}
		});
		btnNuevaMascota.setBounds(10, 143, 414, 33);
		frame.getContentPane().add(btnNuevaMascota);
		
		JButton btnBorrarDueo = new JButton("Borrar Dueño");
		btnBorrarDueo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaBorrarDueñoMascotas vbdm = new VentanaBorrarDueñoMascotas();
				vbdm.frmBorrarDueoY.setVisible(true);
			}
		});
		btnBorrarDueo.setBounds(10, 187, 414, 33);
		frame.getContentPane().add(btnBorrarDueo);
	}

}
