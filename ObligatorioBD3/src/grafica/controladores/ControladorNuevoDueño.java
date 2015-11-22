package grafica.controladores;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import logica.IFachada;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;

public class ControladorNuevoDueño {
	private IFachada facha;
	
	public ControladorNuevoDueño() {
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
	
	public void registrarDueño(int cedula, String nombre, String apellido) throws RemoteException, ClassNotFoundException, PreexistingEntityException, PersistenciaException{
		VODueño dueño = new VODueño(cedula,nombre,apellido);
		facha.nuevoDueño(dueño);
	}
}
