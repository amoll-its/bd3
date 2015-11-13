package poolConexiones;


import excepciones.PersistenciaException;

public interface IPoolConexiones {

	public IConexion obtenerConexion(boolean mod) throws PersistenciaException;
	public void liberarConexion(IConexion conex, boolean res) throws PersistenciaException;
	
}
