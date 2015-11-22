package grafica.controladores;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
		    facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
		  }
		  catch (Exception e)
		  {
			  JOptionPane.showMessageDialog(null, "Ha ocurrido un error de RMI");
			  e.printStackTrace();
		  }		
	}
	
	public void registrarMascota(String apodo, String raza, int cedula) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, NonexistentEntityException, PersistenciaException{
		VOMascota mascota = new VOMascota(apodo,raza,cedula);
	    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
		facha.nuevaMascota(mascota);
	}
}
