package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import grafica.controladores.ControladorListarDueños;
import grafica.controladores.ControladorNuevoDueño;
import logica.IFachada;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaNuevoDueño {

	JFrame frmIngresarNuevoDueño;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;


	public VentanaNuevoDueño() {
		initialize();
	}

	private void initialize() {
		frmIngresarNuevoDueño = new JFrame();
		frmIngresarNuevoDueño.setTitle("Ingresar nuevo dueño");
		frmIngresarNuevoDueño.setBounds(100, 100, 450, 285);
		frmIngresarNuevoDueño.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIngresarNuevoDueño.getContentPane().setLayout(null);
		frmIngresarNuevoDueño.setLocationRelativeTo(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 11, 182, 14);
		frmIngresarNuevoDueño.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 36, 414, 29);
		frmIngresarNuevoDueño.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 76, 171, 14);
		frmIngresarNuevoDueño.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 101, 414, 29);
		frmIngresarNuevoDueño.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 141, 161, 14);
		frmIngresarNuevoDueño.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(10, 166, 414, 29);
		frmIngresarNuevoDueño.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
					ControladorNuevoDueño controlador = new ControladorNuevoDueño();
				
					String cedula = txtCedula.getText();
					String nombre = txtNombre.getText();
					String apellido = txtApellido.getText();
					
					if (!cedula.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty()) {
							int micedula = -1;
							
							try{
								micedula = Integer.parseInt(txtCedula.getText());
							}catch(NumberFormatException nfe){
								JOptionPane.showMessageDialog(frmIngresarNuevoDueño,"La cedula debe ser un numero.");
							}
							
							if(micedula != -1){
								try {
									controlador.registrarDueño(micedula, nombre, apellido);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (PreexistingEntityException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (PersistenciaException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(frmIngresarNuevoDueño,"Dueño creado con exito.");
								frmIngresarNuevoDueño.dispose();
							}					
	
					} else {
						JOptionPane.showMessageDialog(frmIngresarNuevoDueño,"Tienes que completar todos los campos.");
					}
			}
		});
		btnIngresar.setBounds(301, 206, 123, 29);
		frmIngresarNuevoDueño.getContentPane().add(btnIngresar);
	}
}
