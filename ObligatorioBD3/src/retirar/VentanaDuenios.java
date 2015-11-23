	package retirar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import grafica.ControlDueños;
import logica.valueObjects.VODueño;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaDuenios {

	JFrame frame;
	private JTextField txtCedula;

	/**
	 * Create the application.
	 */
	public VentanaDuenios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		txtCedula = new JTextField();
		txtCedula.setBounds(467, 54, 114, 19);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		final ControlDueños ctlDueños = new ControlDueños();

		final DefaultListModel mlist = new DefaultListModel();		
		
		final JList list = new JList(mlist);
		list.setBounds(33, 32, 293, 167);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		frame.getContentPane().add(list);

		final JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(402, 56, 61, 15);
		frame.getContentPane().add(lblCedula);

		final JLabel lblPepito = new JLabel("Pepito");
		lblPepito.setText("");
		lblPepito.setBounds(199, 228, 278, 15);
		frame.getContentPane().add(lblPepito);

		JButton btnNewButton = new JButton("Verificar dueño");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(412, 105, 182, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnListarDueños = new JButton("Listar dueños");
		btnListarDueños.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
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
		});
		btnListarDueños.setBounds(100, 218, 167, 25);
		frame.getContentPane().add(btnListarDueños);
	}
}
