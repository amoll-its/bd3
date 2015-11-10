package logica;

import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.PreexistingEntityException;
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
		
		// Cargo la lista de dueños
		List <VODueño> lista = new LinkedList<VODueño> ();
		lista = ddueños.listarDueños ();
		
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

	public void nuevaMascota (VOMascota vom) throws RemoteException {
		
	}

	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException {
		return null;
		
	}

	public void borrarDueñoMascotas (VODueño vod) throws RemoteException {
		
	}
	
}
