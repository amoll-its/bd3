package grafica.ventanas;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import grafica.controladores.ControladorListarDueños;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;

public class VentanaListarDueños {
	private ControladorListarDueños controlador;
	JFrame frame;

	public VentanaListarDueños() {
		controlador = new ControladorListarDueños();
		
		try {
			controlador.listarDueños();
			initialize();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "No se pudo establecer la conexión.(VentanaListarDueños)");
			e.printStackTrace();
		}
	}
	
	private void initialize() throws RemoteException, ClassNotFoundException, PersistenciaException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo( null );


		
		DefaultListModel mlist = new DefaultListModel();
		mlist = controlador.listarDueños();	
		
		JList list = new JList(mlist);
		list.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(list);
	}
}
