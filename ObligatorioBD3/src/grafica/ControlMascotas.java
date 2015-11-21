package grafica;

import java.io.IOException;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.IFachada;
import logica.valueObjects.VOMascota;

public class ControlMascotas {

	public List<VOMascota> listarMascotas(int cd) {
		List <VOMascota> listam = new LinkedList<VOMascota> ();
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			listam = facha.listarMascotas (cd);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		
		return listam;
	}

	public void nuevaMascota( VOMascota vom) {
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			facha.nuevaMascota (vom);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}


	
}
