package logica;

import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.Entidades.EMascota;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;
import poolConexiones.IConexion;
import poolConexiones.IPoolConexiones;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class Fachada
  extends java.rmi.server.UnicastRemoteObject
  implements IFachada {
	
	private IPoolConexiones pool;
	
	protected Fachada() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public List <VODueño> listarDueños  () throws RemoteException, PersistenciaException {

		System.out.print(" Bandera listar\n");
		DAODueños ddueños = new DAODueños ();  
		System.out.print(" Bandera 0\n");

		IConexion icon = pool.obtenerConexion(true); 
		System.out.print(" Bandera 0.1\n");
		
		// Cargo la lista de dueños
		List <VODueño> lista = new LinkedList<VODueño> ();
		lista = ddueños.listarDueños ();
		
		pool.liberarConexion(icon, true);
		
		return lista;			
	}

	public void nuevoDueño (VODueño vod) throws RemoteException, PreexistingEntityException {

		int cedula = vod.getCedula();
		String nombre = vod.getNombre();
		String apellido = vod.getApellido();
		
		EDueño ed = new EDueño (cedula,nombre,apellido);  		
		
		DAODueños ddueños = new DAODueños ();
		ddueños.insert (ed);
				
	}

	public void nuevaMascota (VOMascota vom) throws RemoteException, NonexistentEntityException {

		String apodo = vom.getApodo();
		String raza = vom.getRaza();
		int cedula = vom.getCedulaDueño();

		EMascota em = new EMascota (apodo,raza,cedula);  		
		
		DAOMascotas dmascotas = new DAOMascotas (cedula);
		try {
			dmascotas.insert (em);
		} catch (SQLException e) {
//			System.out.print("Algo se rompió!\n");
            throw new NonexistentEntityException("El usuario no existe.");
		}

	}

	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException, NonexistentEntityException {

		int cedula=vod.getCedula();
		DAODueños ddueños = new DAODueños ();

		// Busco al dueño según la cédula
		EDueño ed = ddueños.find(cedula);

		List <VOMascota> lista = new LinkedList<VOMascota> ();
		try {
			lista = ed.listarMascotas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;			
		
	}

	public void borrarDueñoMascotas (int cedula) throws RemoteException, NonexistentEntityException {

		DAODueños ddueños = new DAODueños ();

		// Busco al dueño según la cédula
		EDueño ed = ddueños.find(cedula);

		try {
			ed.borrarMascotas();
			ddueños.delete (cedula);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
