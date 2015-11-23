package retirar;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.IFachada;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;


public class Pepe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub HUMBERTO SANTANA - ppp
		try
		  {
			int cedula1 = 1111111;
			String nombre1 = "Juan";
			String apellido1 = "Perez";
			
			VODueño vod = new VODueño (cedula1, nombre1, apellido1);

			
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
			facha.nuevoDueño (vod);

			List <VODueño> ld = new LinkedList<VODueño> ();

			ld = facha.listarDueños ();

			for(VODueño item : ld) {
				int cedula = item.getCedula ();
				String nombre = item.getNombre ();
				String apellido = item.getApellido ();
				System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");
				}
		    
			facha.borrarDueñoMascotas(cedula1);
			System.out.print("----------------\n");
			ld = facha.listarDueños ();

			for(VODueño item : ld) {
				int cedula = item.getCedula ();
				String nombre = item.getNombre ();
				String apellido = item.getApellido ();
				System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");
				}
		    
			System.out.print("----------------\n");
			String apodo = "Lobo2"; 
		    String raza = "Husky2";
		    cedula1=1234567;
		    
			VOMascota vom = new VOMascota (apodo, raza ,cedula1);
		    facha.nuevaMascota(vom);

			//VODueño vod1 = new VODueño (1234567, "Jimi", "Hendrix");
			List <VOMascota> lm = new LinkedList<VOMascota> ();
			lm = facha.listarMascotas (1234567);
			for(VOMascota item : lm) {
				apodo = item.getApodo ();
				raza = item.getRaza ();
				int cedulaDuenio = item.getCedulaDueño ();
				System.out.print("Datos: " + cedulaDuenio + " - " + apodo + " - " + raza + "\n");
				}

//			facha.borrarDueñoMascotas (cedula);
		    
		    
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
