package grafica.controladores;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import grafica.ventanas.VentanaListarDueños;
import logica.IFachada;
import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;

public class ControladorListarDueños {
	private IFachada facha;
	
	public ControladorListarDueños() {
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
	
	public DefaultListModel listarDueños() throws RemoteException, ClassNotFoundException, PersistenciaException {
		List<VODueño> listadueños = facha.listarDueños();
		int tope = listadueños.size();
		final int[] listacod = new int[tope];
		int pos = 0;
		DefaultListModel mlist = new DefaultListModel();
		mlist.clear();
		for(VODueño item : listadueños) {
			int cedula = item.getCedula ();
			String nombre = item.getNombre ();
			String apellido = item.getApellido ();
			mlist.addElement(apellido + ", " + nombre);
			listacod[pos]= cedula;
			pos++;
		}
		
		return mlist;			
	}
}
