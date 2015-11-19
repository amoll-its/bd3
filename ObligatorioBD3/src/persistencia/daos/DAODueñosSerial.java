package persistencia.daos;

import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import poolConexiones.IConexion;

public class DAODueñosSerial implements IDAODueños {

	public DAODueñosSerial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DAODueños() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VODueño> listarDueños(IConexion con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EDueño ed, IConexion con) throws PreexistingEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EDueño find(int ced, IConexion con) throws NonexistentEntityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int cedula, IConexion con) throws NonexistentEntityException {
		// TODO Auto-generated method stub
		
	}

}
