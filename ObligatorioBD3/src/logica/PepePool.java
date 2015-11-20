package logica;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.List;
import poolConexiones.*;
import logica.excepciones.PersistenciaException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public class PepePool {

	public static void main(String[] args) throws ClassNotFoundException, PersistenciaException {
		// TODO Auto-generated method stub 
//		PoolConexiones ipool= PoolConexiones.getPool();
		PoolConexiones ipool = null;
		
		System.out.print("Conexion 1*******************\n");
		IConexion icon1 = ipool.obtenerConexion(true);
		System.out.print("Conexion 2*******************\n");
		IConexion icon2 = ipool.obtenerConexion(true);
		System.out.print("Libero 2*******************\n");
		ipool.liberarConexion(icon2, true);
		System.out.print("Conexion 3*******************\n");
		IConexion icon3 = ipool.obtenerConexion(true);
		System.out.print("Libero 1*******************\n");
		ipool.liberarConexion(icon1, true);
		System.out.print("Conexion 4*******************\n");
		IConexion icon4 = ipool.obtenerConexion(true);
		System.out.print("Libero 3*******************\n");
		ipool.liberarConexion(icon3, true);
		System.out.print("Conexion 5*******************\n");
		IConexion icon5 = ipool.obtenerConexion(true);
		System.out.print("Conexion 6*******************\n");
		IConexion icon6 = ipool.obtenerConexion(true);
		System.out.print("Conexion 7*******************\n");
		IConexion icon7 = ipool.obtenerConexion(true);
		System.out.print("Libero 4*******************\n");
		ipool.liberarConexion(icon4, true);
		System.out.print("Libero 5*******************\n");
		ipool.liberarConexion(icon5, true);
		System.out.print("Libero 6*******************\n");
		ipool.liberarConexion(icon6, true);
		System.out.print("Libero 7*******************\n");
		ipool.liberarConexion(icon7, true);
		System.out.print("*******************EUREKA!!*******************\n");

	}

}
