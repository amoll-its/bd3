package grafica.controladores;

import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import logica.IFachada;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;

public class ControladorBorrarDueño {
	private IFachada facha;
	
	public ControladorBorrarDueño() {
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
	
	public void borrarDueño(int micedula) throws RemoteException, ClassNotFoundException, NonexistentEntityException, PersistenciaException {
		facha.borrarDueñoMascotas(micedula);
	}

}
