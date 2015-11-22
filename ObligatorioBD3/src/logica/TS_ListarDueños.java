package logica;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;


public class TS_ListarDueños {

	public static void main(String[] args) {
		// TODO Auto-generated method stub HUMBERTO SANTANA - ppp
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");

			List <VODueño> ld = new LinkedList<VODueño> ();

			ld = facha.listarDueños ();

			for(VODueño item : ld) {
				int cedula = item.getCedula ();
				String nombre = item.getNombre ();
				String apellido = item.getApellido ();
				System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");
				}
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
