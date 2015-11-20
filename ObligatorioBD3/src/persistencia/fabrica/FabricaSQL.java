package persistencia.fabrica;

import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;
import persistencia.daos.IDAODueños;
import persistencia.daos.IDAOMascotas;

public class FabricaSQL implements FabricaAbstracta {

	public FabricaSQL() {
		// TODO Auto-generated constructor stub
	}

	public IDAODueños crearDAODueños() {
		return new DAODueños();
	}

	public IDAOMascotas crearDAOMascotas(int cedulaDueño) {
		return new DAOMascotas(cedulaDueño);
	}	
	
}
