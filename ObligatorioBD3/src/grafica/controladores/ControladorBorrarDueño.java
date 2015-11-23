package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.JOptionPane;

import logica.IFachada;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;

public class ControladorBorrarDueño {
	private IFachada facha;
	
	public ControladorBorrarDueño() {
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
	
	public void borrarDueño(int micedula) throws RemoteException, ClassNotFoundException, NonexistentEntityException, PersistenciaException {
		facha.borrarDueñoMascotas(micedula);
	}

}
