package persistencia;

import java.util.LinkedList;
import java.util.List;

import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;
import persistencia.daos.DAODueños;
import persistencia.daos.DAODueñosArchivo;
import persistencia.daos.IDAODueños;
import poolConexiones.IConexion;
import poolConexiones.IPoolConexiones;
import poolConexiones.PoolConexiones;

public class Pepe2 {

	public static void main(String[] args) throws PersistenciaException, ClassNotFoundException {

		IPoolConexiones ipool;
		
		ipool = (IPoolConexiones) new PoolConexiones();
		
		IConexion icon = ipool.obtenerConexion(true);

		IDAODueños ddueños = new DAODueñosArchivo ();  

		icon = ipool.obtenerConexion(true);
			
		// Cargo la lista de dueños
		List <VODueño> ld = new LinkedList<VODueño> ();
		ld = ddueños.listarDueños (icon);

		for(VODueño item : ld) {
			int cedula = item.getCedula ();
			String nombre = item.getNombre ();
			String apellido = item.getApellido ();
			System.out.print("Datos: " + cedula + " - " + nombre + " - " + apellido + "\n");
			}
		
		
//		ipool.liberarConexion(icon, true);
		

	}

}
