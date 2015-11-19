package poolConexiones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import logica.excepciones.PersistenciaException;


public class PoolConexiones implements IPoolConexiones {
//public class PoolConexiones{
	
	private String driver, url, user, password;
	private int nivelTransaccionalidad;
	private IConexion[] conexiones;
	private int tamanio, creadas, tope;
//	private static PoolConexiones mipool;//Singleton
	
//CAMBIO PARA SINGLETON	public PoolConexiones() throws ClassNotFoundException{
	public PoolConexiones() throws ClassNotFoundException{
		try{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("conexion.properties"));
	 
			driver = propiedades.getProperty("driver");
			url = propiedades.getProperty("url");
			user = propiedades.getProperty("usuario");
			password = propiedades.getProperty("password");
			tamanio = Integer.parseInt (propiedades.getProperty ("tamanio"));
			nivelTransaccionalidad = Integer.parseInt(propiedades.getProperty("nivel"));
			creadas=0;
			tope=0;
			Class.forName(driver);
			conexiones = new IConexion[tamanio];
		
		}catch (FileNotFoundException e){ 	
		   System.out.println("Error, El archivo no exite");
		}
		 catch (IOException e){ 
		   System.out.println("Error, No se puede leer el archivo");
		 }
	   
	}

/*	public static PoolConexiones getPool() throws ClassNotFoundException {
		if (mipool==null){
			mipool = new PoolConexiones();
		}
		return mipool;
	}
*/	
	
	public synchronized IConexion obtenerConexion(boolean mod) throws PersistenciaException {
		IConexion conex = null;
		while (conex==null){
			if (tope>0){
				conex=conexiones[tope-1];
				tope--;
			}
			else
				if (creadas<tamanio)
					try
					{
						Connection conect = DriverManager.getConnection(url, user, password);
						conect.setTransactionIsolation(nivelTransaccionalidad);
						conect.setAutoCommit(false);
						conex = new Conexion(conect);
						creadas++;
					}catch (SQLException e){
						throw new PersistenciaException ("error de conexion");
					}				
				else
					try
					{
						wait ();
					}
					catch (InterruptedException e)
					{
						throw new PersistenciaException ("error de sincronizaci�n");
					}
		}
//		System.out.print("Tamaño: " + tamanio +"\n");
//		System.out.print("Creadas: " + creadas +"\n");
//		System.out.print("Tope: " + tope +"\n");
		return conex;
	}

	public synchronized void liberarConexion(IConexion conex, boolean res) throws PersistenciaException {
		// TODO Auto-generated method stub
		Connection con;
		con=((Conexion) conex).getConnection();
		try
		{
			if (res)
				con.commit();
			else 
				con.rollback();
		}
		catch (SQLException e)
		{
			throw new PersistenciaException ("error al cerrar transacci�n");
		}
					
		tope++;
		conexiones[tope-1]= conex;
		notify();
//		System.out.print("Tamaño: " + tamanio +"\n");
//		System.out.print("Creadas: " + creadas +"\n");
//		System.out.print("Tope: " + tope +"\n");
	}


}
