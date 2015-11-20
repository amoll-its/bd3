package logica;

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


public class PepeInsertar {

	public static void main(String[] args) {
		// Prueba de "Listar Dueños"
		try
		  {

			IPoolConexiones ipool;

			ipool = (IPoolConexiones) new PoolConexiones();

			IConexion icon = ipool.obtenerConexion(true);

			int cedula = 2345678;
			String nombre = "Janis";
			String apellido = "Joplin";
			
			EDueño ed = new EDueño (cedula,nombre,apellido);  		
			
			IDAODueños ddueños = new DAODueñosArchivo ();
			ddueños.insert (ed, icon);
			
			System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");

			
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
