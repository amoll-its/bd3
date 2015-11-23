package retirar;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.IFachada;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;


public class TS_NuevaMascota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub HUMBERTO SANTANA - ppp
		try
		  {
			// Invoco a la fachada remota.
		    IFachada facha = (IFachada)Naming.lookup ("//localhost:1099/fachada");

		    String apodo = "Negro"; 
		    String raza = "Labrador";
//		    String apodo = "Pancho"; 
//		    String raza = "Salchicha";
		    int cedula = 7654321;
		    
			VOMascota vom = new VOMascota (apodo, raza ,cedula);
		    facha.nuevaMascota(vom);

			List <VOMascota> lm = new LinkedList<VOMascota> ();
			lm = facha.listarMascotas (cedula);
			for(VOMascota item : lm) {
				apodo = item.getApodo ();
				raza = item.getRaza ();
				int cedulaDuenio = item.getCedulaDueño ();
				System.out.print("Datos: " + cedulaDuenio + " - " + apodo + " - " + raza + "\n");
				}
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
