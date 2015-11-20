package persistencia.fabrica;

import persistencia.daos.DAODueños;
import persistencia.daos.DAODueñosArchivo;
import persistencia.daos.DAOMascotas;
import persistencia.daos.DAOMascotasArchivo;
import persistencia.daos.IDAODueños;
import persistencia.daos.IDAOMascotas;

public class FabricaArchivos implements FabricaAbstracta {

	public FabricaArchivos() {
		// TODO Auto-generated constructor stub
	}

	public IDAODueños crearDAODueños() {
		return new DAODueñosArchivo();
	}

	@Override
	public IDAOMascotas crearDAOMascotas(int cedulaDueño) {
		return new DAOMascotasArchivo(cedulaDueño);
	}

}
