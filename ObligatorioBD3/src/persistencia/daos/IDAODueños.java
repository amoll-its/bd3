package persistencia.daos;

import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import poolConexiones.IConexion;

public interface IDAODueños {

	public void DAODueños();
	public List<VODueño> listarDueños (IConexion con);
	public void insert (EDueño ed, IConexion con) throws PreexistingEntityException;
	public EDueño find (int ced, IConexion con) throws NonexistentEntityException; 
	public void delete (int cedula, IConexion con) throws NonexistentEntityException;
	
}
