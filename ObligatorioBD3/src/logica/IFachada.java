package logica;

import java.rmi.RemoteException;
import java.util.List;

import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public interface IFachada extends java.rmi.Remote {
	
	public List <VODueño> listarDueños  () throws RemoteException, PersistenciaException, ClassNotFoundException;

	public void nuevoDueño (VODueño vod) throws RemoteException, PreexistingEntityException, ClassNotFoundException, PersistenciaException;

	public void nuevaMascota (VOMascota vom) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException ;

	public List <VOMascota> listarMascotas (int cd) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException;

	public void borrarDueñoMascotas (int cedula) throws RemoteException, NonexistentEntityException, ClassNotFoundException, PersistenciaException;
	
	
}
