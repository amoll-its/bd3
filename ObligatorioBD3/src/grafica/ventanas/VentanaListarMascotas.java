package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grafica.controladores.ControladorListarDueños;
import grafica.controladores.ControladorListarMascotas;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaListarMascotas {
	private ControladorListarMascotas controlador;
	JFrame frame;
	private JTextField txtCedula;
	private JList list;
	
	public VentanaListarMascotas() {
		try {
			initialize();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"No se pudo establecer la conexión.");
		}
	}

	public void initialize() {
		controlador = new ControladorListarMascotas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIngreseLaCedula = new JLabel("Ingrese la Cedula:");
		lblIngreseLaCedula.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblIngreseLaCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 36, 279, 30);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int cedula = Integer.parseInt(txtCedula.getText());
				DefaultListModel mlist = new DefaultListModel();

				try {
					mlist = controlador.listarMascotas(cedula);
					JList list = new JList(mlist);
					list.setBounds(10, 70, 414, 239);
					frame.getContentPane().add(list);
				} catch (RemoteException | ClassNotFoundException | NonexistentEntityException
						| PersistenciaException e1) {
					JOptionPane.showMessageDialog(frame,
							"No se pudo establecer la conexión.");
					e1.printStackTrace();
				}
			}
		});
		btnListar.setBounds(299, 36, 125, 30);
		frame.getContentPane().add(btnListar);
	}
}
