package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import grafica.controladores.ControladorNuevaMascota;
import grafica.controladores.ControladorNuevoDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;

import javax.swing.JButton;

public class VentanaNuevaMascota {
	JFrame frmIngresarNuevaMascota;
	private JTextField txtApodo;
	private JTextField txtRaza;
	private JTextField txtCedula;

	public VentanaNuevaMascota() {
		initialize();
	}

	private void initialize() {
		frmIngresarNuevaMascota = new JFrame();
		frmIngresarNuevaMascota.setTitle("Ingresar nueva mascota");
		frmIngresarNuevaMascota.setBounds(100, 100, 450, 290);
		frmIngresarNuevaMascota.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIngresarNuevaMascota.getContentPane().setLayout(null);
		frmIngresarNuevaMascota.setLocationRelativeTo(null);
		
		JLabel lblApodo = new JLabel("Apodo:");
		lblApodo.setBounds(10, 11, 414, 14);
		frmIngresarNuevaMascota.getContentPane().add(lblApodo);
		
		txtApodo = new JTextField();
		txtApodo.setBounds(10, 36, 414, 30);
		frmIngresarNuevaMascota.getContentPane().add(txtApodo);
		txtApodo.setColumns(10);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRaza.setBounds(10, 77, 414, 14);
		frmIngresarNuevaMascota.getContentPane().add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setBounds(10, 102, 414, 30);
		frmIngresarNuevaMascota.getContentPane().add(txtRaza);
		txtRaza.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cédula dueño:");
		lblCedula.setBounds(10, 143, 414, 14);
		frmIngresarNuevaMascota.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 168, 414, 30);
		frmIngresarNuevaMascota.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorNuevaMascota controlador = new ControladorNuevaMascota();
				
				String cedula = txtCedula.getText();
				String apodo = txtApodo.getText();
				String raza = txtRaza.getText();
				
				if (!cedula.isEmpty() && !apodo.isEmpty() && !raza.isEmpty()) {
					int micedula = -1;
					
					try{
						micedula = Integer.parseInt(txtCedula.getText());
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(frmIngresarNuevaMascota,"La cedula debe ser un numero.");
					}
					
					if(micedula != -1){
						try {
							controlador.registrarMascota(apodo, raza, micedula);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NonexistentEntityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (PersistenciaException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(frmIngresarNuevaMascota,"Mascota creada con éxito.");
						frmIngresarNuevaMascota.dispose();
					}
				}else{
					JOptionPane.showMessageDialog(frmIngresarNuevaMascota,"Debes completar todos los campos.");
				}
			}
		});
		btnIngresar.setBounds(310, 209, 114, 30);
		frmIngresarNuevaMascota.getContentPane().add(btnIngresar);
	}
}
