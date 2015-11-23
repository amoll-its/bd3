package grafica.controladores;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.JOptionPane;

import logica.IFachada;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public class ControladorNuevaMascota {
	private IFachada facha;
	
	public ControladorNuevaMascota() {
		try
		{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("cliente.properties"));
	 
			String servfachada = propiedades.getProperty("fachada");
			// Invoco a la fachada remota.
			facha = (IFachada)Naming.lookup (servfachada);
		  }
		  catch (Exception e)
		  {
			  JOptionPane.showMessageDialog(null, "Ha ocurrido un error de RMI");
			  e.printStackTrace();
		  }		
	}
	
	public void registrarMascota(String apodo, String raza, int cedula) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, NonexistentEntityException, PersistenciaException{
		VOMascota mascota = new VOMascota(apodo,raza,cedula);
		facha.nuevaMascota(mascota);
	}
}
