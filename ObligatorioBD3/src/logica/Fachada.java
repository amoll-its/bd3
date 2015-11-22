package logica;

import java.util.LinkedList;

import java.util.List;
import java.util.Properties;

import logica.Entidades.EDueño;
import logica.Entidades.EMascota;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;
import persistencia.daos.IDAODueños;
import poolConexiones.*;
import persistencia.fabrica.FabricaAbstracta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class Fachada
  extends java.rmi.server.UnicastRemoteObject
  implements IFachada {
	
	private IPoolConexiones ipool;
	private FabricaAbstracta fabrica;
	
	protected Fachada() throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		super();

		String nomFab = null;
		String nomPool = null;

		try{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("server.properties"));
			nomFab = propiedades.getProperty("fabrica");
			nomPool = propiedades.getProperty("pool"); 
		}catch (FileNotFoundException e){ 	
		   System.out.println("Error, el archivo de configuración no existe!");
		}
		 catch (IOException e){ 
		   System.out.println("Error, no se puede leer el archivo de configuración!");
		 }

		ipool = (IPoolConexiones) Class.forName(nomPool).newInstance();
		fabrica = (FabricaAbstracta) Class.forName(nomFab).newInstance();

	}

	public List <VODueño> listarDueños  () throws RemoteException, PersistenciaException {

		
//		DAODueños ddueños = new DAODueños ();
		IDAODueños ddueños = fabrica.crearDAODueños();
		
		IConexion icon = ipool.obtenerConexion(true);
			
		// Cargo la lista de dueños
		List <VODueño> lista = new LinkedList<VODueño> ();
		lista = ddueños.listarDueños (icon);
		
		ipool.liberarConexion(icon, true);
		
		return lista;			
	}

	public void nuevoDueño (VODueño vod) throws RemoteException, PreexistingEntityException, ClassNotFoundException, PersistenciaException {

		int cedula = vod.getCedula();
		String nombre = vod.getNombre();
		String apellido = vod.getApellido();
		
		IConexion icon = ipool.obtenerConexion(true);
		
		EDueño ed = new EDueño (cedula,nombre,apellido);  		
		
		DAODueños ddueños = new DAODueños ();
		ddueños.insert (ed, icon);
		ipool.liberarConexion(icon, true);
				
	}

	public void nuevaMascota (VOMascota vom) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException {

		String apodo = vom.getApodo();
		String raza = vom.getRaza();
		int cedula = vom.getCedulaDueño();
		
		IConexion icon = ipool.obtenerConexion(true);
		
		EMascota em = new EMascota (apodo,raza,cedula);  		
		
		DAOMascotas dmascotas= new DAOMascotas(cedula);

		try {
			dmascotas.insert (em,icon);
			ipool.liberarConexion(icon, true);
			} catch (SQLException e) {
//			System.out.print("Algo se rompió!\n");
				ipool.liberarConexion(icon, false);
				throw new NonexistentEntityException("El usuario no existe.");
		}


	}

//	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException {
	//En el practico 4 dice que a listarMascotas se le pasa la CEDULA no un VODueño
	public List <VOMascota> listarMascotas (int cd) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException {

		IConexion icon = ipool.obtenerConexion(true);
		
		//int cedula=vod.getCedula();
		DAODueños ddueños = new DAODueños ();

		// Busco al dueño según la cédula
		EDueño ed = ddueños.find(cd, icon);

		List <VOMascota> lista = new LinkedList<VOMascota> ();
		try {
			lista = ed.listarMascotas(icon);
			ipool.liberarConexion(icon, true);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				ipool.liberarConexion(icon, false);
				e.printStackTrace();
		}
		return lista;			
		
	}

	public void borrarDueñoMascotas (int cedula) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException {

		IConexion icon = ipool.obtenerConexion(true);
		DAODueños ddueños = new DAODueños ();

		// Busco al dueño según la cédula
		EDueño ed = ddueños.find(cedula,icon);

		try {
			ed.borrarMascotas(icon);
			ddueños.delete (cedula,icon);			
			ipool.liberarConexion(icon, true);	
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ipool.liberarConexion(icon, false);	
			}

	}	
}
