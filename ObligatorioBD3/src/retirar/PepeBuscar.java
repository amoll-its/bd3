package retirar;

import java.lang.management.ManagementFactory;
import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAODueñosArchivo;
import persistencia.daos.IDAODueños;
import poolConexiones.IConexion;
import poolConexiones.IPoolConexiones;
import poolConexiones.PoolConexiones;


public class PepeBuscar {

	public static void main(String[] args) {
		// Prueba de "Listar Dueños"
		try
		  {

			IPoolConexiones ipool;

			ipool = (IPoolConexiones) new PoolConexiones();

			IConexion icon = ipool.obtenerConexion(true);

			IDAODueños ddueños = new DAODueñosArchivo ();

			int ced = 1234567;
			// Busco al dueño según la cédula
			EDueño ed = ddueños.find(ced,icon);

			int cedula = ed.getCedula();
			String nombre = ed.getNombre();
			String apellido = ed.getApellido();
			
			System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");

			
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
