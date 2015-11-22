package logica;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;


public class TS_NuevoDueño {

	public static void main(String[] args) {

		try
		  {
			int cedula = 1234567;
			String nombre = "Jimi";
			String apellido = "Hendrix";
			
			VODueño vod = new VODueño (cedula, nombre, apellido);

			
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			facha.nuevoDueño (vod);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
