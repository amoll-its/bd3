package persistencia.fabrica;

import persistencia.daos.DAODueños;
import persistencia.daos.DAODueñosSerial;
import persistencia.daos.DAOMascotas;
import persistencia.daos.DAOMascotasSerial;
import persistencia.daos.IDAODueños;
import persistencia.daos.IDAOMascotas;

public class FabricaSerial implements FabricaAbstracta {

	public FabricaSerial() {
		// TODO Auto-generated constructor stub
	}

	public IDAODueños crearDAODueños() {
		return new DAODueñosSerial();
	}

	@Override
	public IDAOMascotas crearDAOMascotas() {
		return new DAOMascotasSerial();
	}

}
