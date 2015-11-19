package persistencia.fabrica;

import persistencia.daos.IDAODueños;
import persistencia.daos.IDAOMascotas;

public interface FabricaAbstracta {

	public IDAODueños crearDAODueños();
	
	public IDAOMascotas crearDAOMascotas();
	
}
