package logica;

import java.rmi.Naming;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

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
//			facha.nuevoDueño (vod);
		    
		    String apodo = "Rambo"; 
		    String raza = "Doberman";
		    
			VOMascota vom = new VOMascota (apodo, raza ,cedula);
		    facha.nuevaMascota(vom);
		    
		    
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
