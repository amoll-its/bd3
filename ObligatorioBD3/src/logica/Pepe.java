package logica;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public class Pepe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub HUMBERTO SANTANA - ppp
		try
		  {
//			int cedula = 1234567;
//			String nombre = "Juan";
//			String apellido = "Perez";
			
//			VODueño vod = new VODueño (cedula, nombre, apellido);
			
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");
//			facha.nuevoDueño (vod);

			List <VODueño> ld = new LinkedList<VODueño> ();
			System.out.print(" Bandera antes\n");

			ld = facha.listarDueños ();
			for(VODueño item : ld) {
				int cedula = item.getCedula ();
				String nombre = item.getNombre ();
				String apellido = item.getApellido ();
				System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");
				}
		    
		    
//		    String apodo = "Lobo"; 
//		    String raza = "Husky";
		    
//			VOMascota vom = new VOMascota (apodo, raza ,cedula);
//		    facha.nuevaMascota(vom);

//			List <VOMascota> lm = new LinkedList<VOMascota> ();
//			lm = facha.listarMascotas (vod);
//			for(VOMascota item : lm) {
//				String apodo = item.getApodo ();
//				String raza = item.getRaza ();
//				int cedulaDuenio = item.getCedulaDueño ();
//				System.out.print("Datos: " + cedulaDuenio + " - " + apodo + " - " + raza + "\n");
//				}

//			facha.borrarDueñoMascotas (cedula);
		    
		    
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
