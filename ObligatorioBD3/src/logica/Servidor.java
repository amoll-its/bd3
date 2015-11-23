package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

public class Servidor {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		String ipaddress = null;
		try{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("server.properties"));
			ipaddress = propiedades.getProperty("ipaddress");
		}catch (FileNotFoundException e){ 	
		   System.out.println("Error, el archivo de configuración no existe!");
		}
		 catch (IOException e){ 
		   System.out.println("Error, no se puede leer el archivo de configuración!");
		 }

		try
		{ 
			System.setProperty("java.rmi.server.hostname",ipaddress);
			LocateRegistry.createRegistry(1099);
			// instancio mi Objeto Remoto y lo publico
			Fachada fachada = new Fachada();
			System.out.printf("%s \n", ManagementFactory.getRuntimeMXBean().getName());
			Naming.rebind("//"+ipaddress+":1099/fachada", fachada);

		}
		catch (RemoteException e)
		{ e.printStackTrace(); }
		catch (MalformedURLException e)
		{ e.printStackTrace(); }
	}

}
