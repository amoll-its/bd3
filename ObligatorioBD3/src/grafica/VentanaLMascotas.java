	package grafica;

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

public class VentanaLMascotas {

	JFrame frame;
	private JTextField txtCedula;

	/**
	 * Create the application.
	 */
	public VentanaLMascotas() {
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
		
		final JLabel lblTitulo = new JLabel("MASCOTAS");
		lblTitulo.setBounds(20,10, 200, 20);
		frame.getContentPane().add(lblTitulo);
		
		
		final JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(20, 50, 61, 15);
		frame.getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 50, 100, 19);
		frame.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);


		
		//int ced=1234567;
		
		final JList list = new JList(mlist);
		list.setBounds(20, 100, 300, 200);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		frame.getContentPane().add(list);
		
		JButton btnLM = new JButton("Listar mascotas");
		btnLM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<VOMascota> lmascotas = new ArrayList<VOMascota>();
				int ced = Integer.parseInt(txtCedula.getText());
				lmascotas = ctlMascotas.listarMascotas(ced);
				int tope = lmascotas.size();
				final int[] listacod = new int[tope];
				int pos = 0;
				mlist.clear();
				for(VOMascota item : lmascotas) {
					int cedula = item.getCedulaDueño ();
					String apodo = item.getApodo ();
					String raza = item.getRaza ();
					mlist.addElement(apodo + ", " + raza);
					listacod[pos]= cedula;
					pos++;
				}
				
			}
		});
		btnLM.setBounds(200, 50, 200, 25);
		frame.getContentPane().add(btnLM);
		
	

	}
}
