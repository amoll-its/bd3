package grafica;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import logica.IFachada;
import logica.valueObjects.VODueño;

public class ControlDueños {

	public List<VODueño> listarDueños() {
		List <VODueño> listad = new LinkedList<VODueño> ();
		try
		  {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("cliente.properties"));
	 
			String servfachada = propiedades.getProperty("fachada");
			// Invoco a la fachada remota.
		    //IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			IFachada facha = (IFachada)Naming.lookup (servfachada);
			listad = facha.listarDueños ();
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		
		return listad;
	}

	public void nuevoDueño( VODueño vod) {
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			facha.nuevoDueño (vod);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

	public void borrarDueñoMascotas( int cd) {
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			facha.borrarDueñoMascotas (cd);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}
	
}
