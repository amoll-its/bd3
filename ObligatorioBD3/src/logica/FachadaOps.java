package logica;

import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.Entidades.EMascota;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;

import java.rmi.RemoteException;
import java.sql.SQLException;

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

	public void nuevaMascota (VOMascota vom) throws RemoteException, PreexistingEntityException {

		String apodo = vom.getApodo();
		String raza = vom.getRaza();
		int cedula = vom.getCedulaDueño();

		EMascota em = new EMascota (apodo,raza,cedula);  		
		
		DAOMascotas dmascotas = new DAOMascotas (cedula);
		try {
			dmascotas.insert (em);
		} catch (SQLException e) {
			System.out.print("Algo se rompió!\n");
			e.printStackTrace();
		}

	}

	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException {

		return null;
		
	}

	public void borrarDueñoMascotas (VODueño vod) throws RemoteException {
		
	}
	
}
