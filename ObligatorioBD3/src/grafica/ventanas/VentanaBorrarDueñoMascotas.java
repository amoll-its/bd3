package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import grafica.controladores.ControladorBorrarDueño;
import grafica.controladores.ControladorNuevoDueño;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;

import javax.swing.JButton;

public class VentanaBorrarDueñoMascotas {
	JFrame frmBorrarDueoY;
	private JTextField txtCedula;


	public VentanaBorrarDueñoMascotas() {
		initialize();
	}

	private void initialize() {
		frmBorrarDueoY = new JFrame();
		frmBorrarDueoY.setTitle("Borrar Dueño y Mascotas");
		frmBorrarDueoY.setBounds(100, 100, 450, 160);
		frmBorrarDueoY.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBorrarDueoY.getContentPane().setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 11, 46, 14);
		frmBorrarDueoY.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 36, 414, 30);
		frmBorrarDueoY.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(310, 77, 114, 30);
		btnBorrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorBorrarDueño controlador = new ControladorBorrarDueño();
				String cedula = txtCedula.getText();
				int micedula = -1;
				try{
					micedula = Integer.parseInt(txtCedula.getText());
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(frmBorrarDueoY,"La cedula debe ser un numero.");
				}
				
				if (!cedula.isEmpty()) {
					if(micedula != -1){
						try{
							controlador.borrarDueño(micedula);
						}catch(Exception e1){
							JOptionPane.showMessageDialog(frmBorrarDueoY,"Error al borrar.");
						}
						
						JOptionPane.showMessageDialog(frmBorrarDueoY,"Dueño borrado con exito.");
					}					
				}else{
					JOptionPane.showMessageDialog(frmBorrarDueoY,"Completa todos los campos.");
				}
			}
		});
		frmBorrarDueoY.getContentPane().add(btnBorrar);
	}

}
