package grafica;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.Fachada;
import logica.valueObjects.VODueño;

public class Main {

  public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	try
	  {
		// Invoco a la fachada remota.
	    Fachada facha = (Fachada)Naming.lookup ("//localhost:1099/fachada");

		List <VODueño> listad = new LinkedList<VODueño> ();
		listad = facha.listarDueños ();
		for(VODueño item : listad) {
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
