package logica;

import java.rmi.RemoteException;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;

public interface Fachada extends java.rmi.Remote {
	
	public List <VODueño> listarDueños  () throws RemoteException;
//	public void nuevoDueño (VODueño vod);
//	public void nuevaMascota (VOMascota vom);

}
