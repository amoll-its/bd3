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

public class VentanaLDuenios {

	JFrame frame;


	/**
	 * Create the application.
	 */
	public VentanaLDuenios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		final ControlDueños ctlDueños = new ControlDueños();

		final DefaultListModel mlist = new DefaultListModel();		
		
		final JLabel lblTitulo = new JLabel("DUEÑOS");
		lblTitulo.setBounds(20,10, 200, 20);
		frame.getContentPane().add(lblTitulo);
		
		final JList list = new JList(mlist);
		list.setBounds(20, 50, 300, 200);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		frame.getContentPane().add(list);
	
				List<VODueño> ldueños = new ArrayList<VODueño>();
				ldueños = ctlDueños.listarDueños();
				int tope = ldueños.size();
				final int[] listacod = new int[tope];
				int pos = 0;
				mlist.clear();
				for(VODueño item : ldueños) {
					int cedula = item.getCedula ();
					String nombre = item.getNombre ();
					String apellido = item.getApellido ();
					mlist.addElement(apellido + ", " + nombre);
					listacod[pos]= cedula;
					pos++;
				}

	}
}
