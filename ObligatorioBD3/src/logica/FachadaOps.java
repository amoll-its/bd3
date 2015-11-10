package logica;

import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;

import java.rmi.RemoteException;

public class FachadaOps
  extends java.rmi.server.UnicastRemoteObject
  implements Fachada {
	
	protected FachadaOps() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public List <VODueño> listarDueños  () throws RemoteException {

		DAODueños ddueños = new DAODueños ();  
		
		// Cargo la lista de exámenes
		List <VODueño> lista = new LinkedList<VODueño> ();
		lista = ddueños.listarDueños ();
		
		return lista;	
		
	}

	public boolean nuevoDueño (VODueño vod) throws RemoteException {
		return false;
		
	}

	public boolean nuevaMascota (VOMascota vom) throws RemoteException {
		return false;
		
	}

	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException {
		return null;
		
	}

	public void borrarDueñoMascotas (VODueño vod) throws RemoteException {
		
	}
	
}
