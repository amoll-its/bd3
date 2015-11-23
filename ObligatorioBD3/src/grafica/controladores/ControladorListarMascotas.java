package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

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
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("cliente.properties"));
	 
			String servfachada = propiedades.getProperty("fachada");
			// Invoco a la fachada remota.
			facha = (IFachada)Naming.lookup (servfachada);

//			facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
		  }
		  catch (Exception e)
		  {
			  JOptionPane.showMessageDialog(null, "Ha ocurrido un error de RMI");
			  e.printStackTrace();
		  }	
	}

	public List<VOMascota> listarMascotas(int cedula) throws RemoteException, ClassNotFoundException, NonexistentEntityException, PersistenciaException {

		List<VOMascota> listamascotas = new ArrayList<VOMascota>();
		listamascotas = facha.listarMascotas(cedula);
		
		return listamascotas;	
	}
/*	
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
			String raza = item.getRaza();
			mlist.addElement(apodo + " ("+ raza + ")");
			listacod[pos]= cedula;
			pos++;
		}
		
		return mlist;	
	}
*/
}
