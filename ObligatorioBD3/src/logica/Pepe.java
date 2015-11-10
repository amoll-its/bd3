package logica;

import java.rmi.Naming;

import logica.valueObjects.VODueño;

public class Pepe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub HUMBERTO  x
		try
		  {
			int cedula = 7654321;
			String nombre = "Juan";
			String apellido = "Perez";
			
			VODueño vod = new VODueño (cedula, nombre, apellido);
			
			// Invoco a la fachada remota.
		    Fachada facha = (Fachada)Naming.lookup ("//localhost:1099/fachada");
			facha.nuevoDueño (vod);
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
