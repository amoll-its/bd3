package grafica.controladores;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import grafica.ventanas.VentanaListarDueños;
import grafica.ventanas.VentanaListarMascotas;
import logica.IFachada;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public class ControladorListarMascotas {
	private IFachada facha;
	
	public ControladorListarMascotas() {
		try
		{
		    facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
		  }
		  catch (Exception e)
		  {
			  JOptionPane.showMessageDialog(null, "Ha ocurrido un error de RMI");
			  e.printStackTrace();
		  }	
	}
	
	public DefaultListModel listarMascotas(int cedula) throws RemoteException, ClassNotFoundException, NonexistentEntityException, PersistenciaException {
		List<VOMascota> listamascotas = new ArrayList<VOMascota>();
		listamascotas = facha.listarMascotas(cedula);
		int tope = listamascotas.size();
		final int[] listacod = new int[tope];
		int pos = 0;
		DefaultListModel mlist = new DefaultListModel();
		mlist.clear();
		for(VOMascota item : listamascotas) {
			String apodo = item.getApodo();
			mlist.addElement(apodo);
			listacod[pos]= cedula;
			pos++;
		}
		
		return mlist;	
	}
}