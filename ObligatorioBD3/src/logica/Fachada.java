package logica;

import java.rmi.RemoteException;
import java.util.List;

import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public interface Fachada extends java.rmi.Remote {
	
	public List <VODueño> listarDueños  () throws RemoteException;

	public void nuevoDueño (VODueño vod) throws RemoteException, PreexistingEntityException;

	public void nuevaMascota (VOMascota vom) throws RemoteException;

	public List <VOMascota> listarMascotas (VODueño vod) throws RemoteException;

	public void borrarDueñoMascotas (VODueño vod) throws RemoteException;
	
	
}
