package retirar;

import java.lang.management.ManagementFactory;
import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.IFachada;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;


public class PepeListar {

	public static void main(String[] args) {
		// Prueba de "Listar Dueños"
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");

			List <VODueño> ld = new LinkedList<VODueño> ();

			System.out.printf("Antes de listar");
			ld = facha.listarDueños ();
			System.out.printf("Después de listar");

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
