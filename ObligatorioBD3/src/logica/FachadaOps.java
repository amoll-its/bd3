package logica;

import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import persistencia.daos.DAODueños;

import java.rmi.RemoteException;

public class FachadaOps
  extends java.rmi.server.UnicastRemoteObject
  implements Fachada {
	
	protected FachadaOps() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//	public void nuevoDueño (VODueño vod) {
//		
//	}
	
//	public void nuevaMascota (VOMascota vom) {
//		
//	}

	public List <VODueño> listarDueños  () throws RemoteException {

		DAODueños ddueños = new DAODueños ();  
		
		// Cargo la lista de exámenes
		List <VODueño> lista = new LinkedList<VODueño> ();
		lista = ddueños.listarDueños ();
		
		return lista;	
		
	}
	/*
	
	public List <VOMascota> listarMascotas (int cedDue) {
		
	}
	
	public void borrarDueñoMascotas (int cedDue) {
		
	}
*/
}
