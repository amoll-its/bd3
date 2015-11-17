package grafica;

import java.io.IOException;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.IFachada;
import logica.valueObjects.VODueño;

public class ControlDueños {

	public List<VODueño> listarDueños() {
		List <VODueño> listad = new LinkedList<VODueño> ();
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			listad = facha.listarDueños ();
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		
		return listad;
	}
}
