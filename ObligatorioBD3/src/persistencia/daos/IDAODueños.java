package persistencia.daos;

import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;

public interface IDAODueños {

	public void DAODueños();
	public List<VODueño> listarDueños ();
	public void insert (EDueño ed) throws PreexistingEntityException;
	public EDueño find (int ced) throws NonexistentEntityException; 
	public void delete (int cedula) throws NonexistentEntityException;
	
}
