package retirar;

import java.lang.management.ManagementFactory;
import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueñosArchivo;
import persistencia.daos.DAOMascotasArchivo;
import persistencia.daos.IDAODueños;
import persistencia.daos.IDAOMascotas;
import poolConexiones.IConexion;
import poolConexiones.IPoolConexiones;
import poolConexiones.PoolConexiones;


public class PepeListarMascota {

	public static void main(String[] args) {
		// Prueba de "Listar Mascotas"
		try
		  {
			IPoolConexiones ipool;

			ipool = (IPoolConexiones) new PoolConexiones();

			IConexion icon = ipool.obtenerConexion(true);

			IDAODueños ddueños = new DAODueñosArchivo ();

			int ced = 2345678;
			IDAOMascotas dmascotas = new DAOMascotasArchivo (ced);

			List <VOMascota> lista = new LinkedList<VOMascota> ();
			lista = dmascotas.listarMascotas(icon);
			
			for(VOMascota item : lista) {
				String apodo = item.getApodo ();
				String raza = item.getRaza ();
				System.out.print("Datos: " + ced + " - " + apodo + " - " + raza + "\n");
				}
		  }
		  catch (Exception e)
		  {
		    e.printStackTrace();
		  }		

	}

}
