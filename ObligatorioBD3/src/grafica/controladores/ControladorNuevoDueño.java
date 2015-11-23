package grafica.controladores;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

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
	
	public void registrarDueño(int cedula, String nombre, String apellido) throws RemoteException, ClassNotFoundException, PreexistingEntityException, PersistenciaException{
		VODueño dueño = new VODueño(cedula,nombre,apellido);
		facha.nuevoDueño(dueño);
	}
}
