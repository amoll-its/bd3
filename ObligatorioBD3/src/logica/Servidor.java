package logica;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{ // pongo a correr el rmiregistry
		LocateRegistry.createRegistry(1099);
		// instancio mi Objeto Remoto y lo publico
		Fachada fachada = new Fachada();
		System.out.println ("Antes de publicarlo");
		System.out.printf("%s \n", ManagementFactory.getRuntimeMXBean().getName());
		Naming.rebind("//localhost:1099/fachada", fachada);
		System.out.println ("Luego de publicarlo");
		}
		catch (RemoteException e)
		{ e.printStackTrace(); }
		catch (MalformedURLException e)
		{ e.printStackTrace(); }
	}

}
