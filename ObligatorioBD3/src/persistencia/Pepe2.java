package persistencia;

import java.util.LinkedList;
import java.util.List;

import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;
import persistencia.daos.DAODueños;
import persistencia.daos.DAODueñosArchivo;
import persistencia.daos.IDAODueños;
import poolConexiones.IConexion;
import poolConexiones.PoolConexiones;

public class Pepe2 {

	public static void main(String[] args) throws PersistenciaException {
		
		IConexion icon = null;
		IDAODueños ddueños = new DAODueñosArchivo ();  

		PoolConexiones ipool;
		try {
			ipool = PoolConexiones.getPool();
			icon = ipool.obtenerConexion(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Cargo la lista de dueños
		List <VODueño> lista = new LinkedList<VODueño> ();
//		lista = ddueños.listarDueños (icon);
		ddueños.listarDueños (icon);
		
//		ipool.liberarConexion(icon, true);
		

	}

}
